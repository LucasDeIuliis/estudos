package br.com.estudos;

import br.com.estudos.controller.TesteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



@SpringBootApplication
public class Testes01Application {

	@Autowired
	TesteController testeController;

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() throws Exception {
		testeController.testeFluxo();
	}

	public static void main(String[] args) {SpringApplication.run(Testes01Application.class, args);
		}
	{
		String nomeArquivo = "C:/Teste01/teste01.txt"; // Substitua pelo nome do seu arquivo

		try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				System.out.println(linha);
			}
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo: " + e.getMessage());
		}

	}

}





