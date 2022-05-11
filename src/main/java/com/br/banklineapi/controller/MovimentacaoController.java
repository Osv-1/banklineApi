package com.br.banklineapi.controller;


import com.br.banklineapi.dto.NovaMovimentacao;
import com.br.banklineapi.dto.NovoCorrentista;
import com.br.banklineapi.model.Correntista;
import com.br.banklineapi.model.Movimentacao;
import com.br.banklineapi.repository.CorrentistaRepository;
import com.br.banklineapi.repository.MovimentacaoRepository;
import com.br.banklineapi.service.CorrentistaService;
import com.br.banklineapi.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository mr;
    @Autowired
    private MovimentacaoService ms;

    @GetMapping
    public List<Movimentacao> findAll() {
        return mr.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao movimentacao) {
        ms.save(movimentacao);
    }


}
