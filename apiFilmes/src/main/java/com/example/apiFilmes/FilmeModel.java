package com.example.apiFilmes;

import java.util.Date;

public record FilmeModel(
        Long id,
        String nome,
        Date anoLancamento)
{ }
