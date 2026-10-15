"""Teste HTTP: rode com a API iniciada. Usa apenas a biblioteca padrão do Python."""
import json
import sys
from datetime import date, timedelta
from urllib.request import Request, urlopen
from urllib.error import HTTPError
base = (sys.argv[1] if len(sys.argv) > 1 else "http://localhost:8080").rstrip("/")
path = "/api/registros-meteorologicos"
def call(method, endpoint, expected, data=None):
    request = Request(base + endpoint, data=None if data is None else json.dumps(data).encode(),
                      headers={"Content-Type": "application/json"}, method=method)
    try:
        response = urlopen(request, timeout=15)
    except HTTPError as error:
        response = error
    with response:
        body = response.read()
        assert response.status == expected, (method, endpoint, response.status, body)
        return json.loads(body) if body else None
payload = dict(estacaoNome="Estacao de teste", dataRegistro=date.today().isoformat(), temperatura=-5.5,
               percentualUmidade=0, precipitacao=0, condicaoClimatica="ENSOLARADO")
assert isinstance(call("GET", path, 200), list)
created = call("POST", path, 201, payload)
record_path = path + "/" + str(created["registroId"])
try:
    assert call("GET", record_path, 200)["estacaoNome"] == payload["estacaoNome"]
    updated = dict(payload, percentualUmidade=100, condicaoClimatica="TEMPESTADE")
    assert call("PUT", record_path, 200, updated)["percentualUmidade"] == 100
    for change in [dict(estacaoNome="ab"), dict(estacaoNome=" "), dict(estacaoNome="x"*101),
                   dict(dataRegistro=(date.today()+timedelta(days=1)).isoformat()),
                   dict(temperatura=None), dict(percentualUmidade=-1), dict(percentualUmidade=101),
                   dict(precipitacao=-1), dict(condicaoClimatica=None), dict(condicaoClimatica="INVALIDO")]:
        call("POST", path, 400, dict(payload, **change))
    for field in payload:
        missing = payload.copy()
        del missing[field]
        call("POST", path, 400, missing)
    call("PUT", record_path, 400, dict(payload, percentualUmidade=101))
    assert call("GET", "/v3/api-docs", 200)["openapi"].startswith("3.")
finally:
    call("DELETE", record_path, 204)
call("GET", record_path, 404)
call("PUT", record_path, 404, payload)
call("DELETE", record_path, 404)
print("OK: CRUD, limites, obrigatoriedade, erros e OpenAPI.")
