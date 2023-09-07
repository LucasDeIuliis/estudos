package br.com.estudos.controller;

import br.com.estudos.service.TesteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TesteController {

    @Autowired
    TesteService testeService;
    public void testeFluxo(){
        testeService.mensagemInicial();
    }
}
