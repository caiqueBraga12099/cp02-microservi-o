CREATE TABLE registro_meteorologico (
    registro_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    estacao_nome VARCHAR(100) NOT NULL,
    data_registro DATE NOT NULL,
    temperatura DECIMAL(19,4) NOT NULL,
    percentual_umidade DECIMAL(19,4) NOT NULL,
    precipitacao DECIMAL(19,4) NOT NULL,
    condicao_climatica VARCHAR(20) NOT NULL,
    CONSTRAINT ck_estacao_nome CHECK (CHAR_LENGTH(estacao_nome) >= 3),
    CONSTRAINT ck_umidade CHECK (percentual_umidade BETWEEN 0 AND 100),
    CONSTRAINT ck_precipitacao CHECK (precipitacao >= 0),
    CONSTRAINT ck_condicao CHECK (condicao_climatica IN ('ENSOLARADO','NUBLADO','CHUVOSO','TEMPESTADE'))
);
