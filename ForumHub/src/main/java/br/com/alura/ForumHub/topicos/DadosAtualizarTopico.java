package br.com.alura.ForumHub.topicos;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizarTopico(

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem
        )
     {
}