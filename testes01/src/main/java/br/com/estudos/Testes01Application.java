package br.com.estudos;

import br.com.estudos.controller.TesteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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

	public static void main(String[] args) {SpringApplication.run(Testes01Application.class, args);
		}
	{
				String caminhoEntrada = "C:/Teste01/teste01.txt";
				String caminhoSaida = "C:/Teste01/saida.txt";

				try {
					// Use a API java.nio.file para obter um Stream das linhas do arquivo de entrada
					Path pathEntrada = Paths.get(caminhoEntrada);
					Stream<String> linhas = Files.lines(pathEntrada);

					// Colete as linhas processadas em uma lista
					List<String> linhasProcessadas = linhas.map(line -> processarLinha(line)).collect(Collectors.toList());

					// Imprima as linhas processadas no console
					linhasProcessadas.forEach(System.out::println);

					// Escreva as linhas processadas em um novo arquivo de saída
					Path pathSaida = Paths.get(caminhoSaida);
					Files.write(pathSaida, linhasProcessadas);

					// Feche o Stream
					linhas.close();
				} catch (IOException e) {
					System.out.println("Ocorreu um erro ao processar o arquivo: " + e.getMessage());
				}
			}

			private static String processarLinha(String linha) {
				StringBuilder resultado = new StringBuilder();
				boolean encontrouMaiuscula = false;

				for (char c : linha.toCharArray()) {
					if (Character.isUpperCase(c)) {
						encontrouMaiuscula = true;
					}

					if (encontrouMaiuscula) {
						if (Character.isLetterOrDigit(c) || Character.isWhitespace(c)) {
							resultado.append(c);
						}
					}
				}

				return resultado.toString();
			}
		}







