package com.br.banklineapi.controller;

import com.br.banklineapi.dto.NovoCorrentista;
import com.br.banklineapi.model.Correntista;
import com.br.banklineapi.repository.CorrentistaRepository;
import com.br.banklineapi.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository cr;

    @Autowired
    private CorrentistaService cs;


    @GetMapping
    public List<Correntista> findAll() {
        return cr.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentista correntista) {
        cs.save(correntista);
    }


}
