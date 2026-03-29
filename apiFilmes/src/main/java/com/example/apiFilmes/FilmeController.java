package com.example.apiFilmes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin("*")

public class FilmeController {

    private List<FilmeModel> listaFilmes = new ArrayList<>(List.of(
            new FilmeModel(1L, "O Poderoso Chefão", new Date(72, 2, 24)),
            new FilmeModel(2L, "Matrix", new Date(99, 2, 31)),
            new FilmeModel(3L, "Interestelar", new Date(114, 10, 6)),
            new FilmeModel(4L, "Pulp Fiction", new Date(94, 9, 14)),
            new FilmeModel(5L, "Parasita", new Date(119, 4, 30)),
            new FilmeModel(6L, "Cidade de Deus", new Date(102, 7, 30))
    ));


    @GetMapping
    public ResponseEntity<List<FilmeModel>> listAllMovie() {
        if (listaFilmes.isEmpty()) {
            // Retorna Status 204 - No Content (Sem Conteúdo)
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaFilmes);
    }

    @PostMapping
    public ResponseEntity<FilmeModel> createMovie(@RequestBody FilmeModel novoFilme) {
        if (novoFilme.nome() == null || novoFilme.nome().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        FilmeModel filmeParaSalvar = novoFilme;
        if (novoFilme.id() == null) {
            Long novoId = (long) (listaFilmes.size() + 1);
            filmeParaSalvar = new FilmeModel(novoId, novoFilme.nome(), novoFilme.anoLancamento());
        }

        listaFilmes.add(filmeParaSalvar);
        return ResponseEntity.status(201).body(filmeParaSalvar);
    }
}

