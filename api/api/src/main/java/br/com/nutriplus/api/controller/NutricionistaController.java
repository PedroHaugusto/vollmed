package br.com.nutriplus.api.controller;

import br.com.nutriplus.api.nutricionista.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("nutricionistas")
public class NutricionistaController {

    @Autowired
    private NutricionistaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarNutricionista(@RequestBody @Valid DadosCadastroNutricionista dados) {
        repository.save(new Nutricionista(dados));
    }

    @GetMapping
    public Page<DadosListagemNutricionista> listarNutricionistas(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemNutricionista::new);
    }

    @Transactional
    @PutMapping
    public void editarNutricionista(@RequestBody @Valid EditarNutricionista dados) {

        var nutricionista = repository.getReferenceById(dados.id());
        nutricionista.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirNutricionista(@PathVariable Long id) {
        var nutricionista = repository.getReferenceById(id);
        nutricionista.excluir();
    }
}