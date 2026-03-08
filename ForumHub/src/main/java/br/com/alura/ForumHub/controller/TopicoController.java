package br.com.alura.ForumHub.controller;

import br.com.alura.ForumHub.curso.CursoRepository;
import br.com.alura.ForumHub.usuario.Usuario;
import br.com.alura.ForumHub.usuario.UsuarioRepository;
import br.com.alura.ForumHub.topicos.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopico> cadastrar(@RequestBody @Valid @NotNull DadosCadastroTopico dados,
                                                             @AuthenticationPrincipal Usuario usuarioLogado, UriComponentsBuilder uriBuilder) {
        var curso = cursoRepository.findByNome(dados.nomeCurso());
        var topico = new Topico(dados, usuarioLogado, curso);
        topicoRepository.save(topico);

        var uri = uriBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listarTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        var page = topicoRepository.findAll(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> detalhar(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopico> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizarTopico dados) {
        var topicoOptinal = topicoRepository.findById(id);
        if (topicoOptinal.isPresent()) {
            var topico = topicoOptinal.get();
            topico.atualizarInformacoes(dados);

            return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        var topicoOptinal = topicoRepository.findById(id);

        if (topicoOptinal.isPresent()) ;
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
        //return ResponseEntity.notFound().build();

    }

