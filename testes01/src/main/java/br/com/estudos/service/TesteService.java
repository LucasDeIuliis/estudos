package br.com.estudos.service;

import org.springframework.stereotype.Service;

@Service
public class TesteService {
    public void mensagemInicial(){
        String nome = "Olá Mundo - Lucas";
        System.out.println( new StringBuilder(nome).reverse().toString());
    }
}
