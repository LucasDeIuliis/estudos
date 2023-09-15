package br.com.estudos;

import br.com.estudos.controller.TesteController;
import br.com.estudos.service.LeituraDeNomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import org.springframework.context.event.EventListener;


@SpringBootApplication
public class Testes01Application {

	@Autowired
	TesteController testeController;

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() throws Exception {
		testeController.testeFluxo();
	}

	public static void main(String[] args) {
		SpringApplication.run(Testes01Application.class, args);

		LeituraDeNomeService programa = new LeituraDeNomeService();
		programa.lerEImprimirArquivo();

	}
}

// --------------------------------codigo sem application.properties-------------------------------------------------------
//		//codigo sem application.properties//
//		String caminhoDoArquivo = "D:\\\\estudos\\\\testes01\\\\exercicios\\\\Arquivo de Apoio\\\\teste01.txt";
//		String caminhoDoNovoArquivo = "D:\\\\estudos\\\\testes01\\\\exercicios\\\\Arquivo de Apoio\\\\teste01resposta.txt";
//		LeituraDeNomeService leituraDeNomeService = new LeituraDeNomeService();
//		leituraDeNomeService.lerEImprimirArquivo(caminhoDoArquivo, caminhoDoNovoArquivo);

