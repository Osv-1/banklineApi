package com.br.banklineapi.service;

import com.br.banklineapi.dto.NovaMovimentacao;
import com.br.banklineapi.model.Correntista;
import com.br.banklineapi.model.Movimentacao;
import com.br.banklineapi.model.MovimentacaoTipo;
import com.br.banklineapi.repository.CorrentistaRepository;
import com.br.banklineapi.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository mr;

    @Autowired
    private CorrentistaRepository cr;

    public void save(NovaMovimentacao novaMovimentacao) {
        Movimentacao movimentacao = new Movimentacao();

        //Operador alternário
        Double valor = novaMovimentacao.getValor();
        if (novaMovimentacao.getTipo() == MovimentacaoTipo.DESPESA) {
            valor = valor * -1;
        }

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(valor);

        Correntista correntista = cr.findById(novaMovimentacao.getIdConta()).orElse(null);
        if (correntista != null) {
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            cr.save(correntista);
        }

        mr.save(movimentacao);
    }

}
