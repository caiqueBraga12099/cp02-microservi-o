package com.github.caiqueBraga12099.registrometeorologico.exception;

public class RegistroNaoEncontradoException extends RuntimeException {

    public RegistroNaoEncontradoException(Long id) {

        super("Registro " + id + " não encontrado");
    }
}
