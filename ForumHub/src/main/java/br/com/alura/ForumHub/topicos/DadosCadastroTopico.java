package br.com.alura.ForumHub.topicos;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String nomeCurso
       )

     {
}