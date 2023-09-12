package br.com.estudos;

import br.com.estudos.controller.TesteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

//importando bibliotecas
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		String caminhoArquivo = "C:/Teste01/teste01.txt";
		 String caminhoSaida = "C:/Teste01/saida.txt";
				
				try {
		            // Use a API java.nio.file para obter um Stream das linhas do arquivo
		            Path path = Paths.get(caminhoArquivo);
		            Stream<String> linhas = Files.lines(path);

		            // Use forEach para imprimir cada linha no console
		           // linhas.forEach(System.out::println);
		            
		            		            
		            Stream<String> linhasProcessadas = linhas.map(line -> line.replaceAll("['s','m','v',9,'d',6,3,'.','--','&','~~',"
		            		+ "'´', 0, ';']", ""));

		            linhasProcessadas.forEach(System.out::println);
		            
		            Path pathSaida = Paths.get(caminhoSaida);
		            Files.write(pathSaida, linhasProcessadas.collect(Collectors.toList()));
		            		           
		        
		            // Feche os Streams
		            linhas.close();
		            		         
		        
		            // Feche o Stream após a leitura
		         //   linhas.close();
		        } catch (IOException e) {
		            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
		        }
	}
	}
				//TIRANDO LETRAS INDESEJADAS
				
			
			       
