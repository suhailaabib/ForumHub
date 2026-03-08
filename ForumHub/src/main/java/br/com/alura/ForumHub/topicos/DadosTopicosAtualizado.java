package br.com.alura.ForumHub.topicos;

import java.time.LocalDateTime;

public record DadosTopicosAtualizado(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao
       )
    {

  public DadosTopicosAtualizado(Topico topico) {
    this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao());
     }
  }
