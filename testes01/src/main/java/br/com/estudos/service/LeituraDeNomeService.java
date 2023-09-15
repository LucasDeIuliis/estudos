package br.com.estudos.service;
import org.springframework.stereotype.Service;

import java.io.*;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LeituraDeNomeService {
    public void lerEImprimirArquivo() {
        Properties properties = loadProperties("application.properties");

        String caminhoDoArquivo = properties.getProperty("caminhoDoArquivoOrigem");
        String caminhoDoNovoArquivo = properties.getProperty("caminhoDoArquivoDestino");

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoDoArquivo));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoDoNovoArquivo))) {

            String linha;
            boolean primeiraLinha = true;

            while ((linha = leitor.readLine()) != null) {
                if (primeiraLinha) {
                    escritor.write(linha);
                    escritor.newLine();
                    primeiraLinha = false;
                    System.out.println(linha);
                } else {
                    // Use uma expressão regular para extrair nomes
                    String[] nomes = extrairNomes(linha);
                    for (String nome : nomes) {
                        // Escrever o nome no novo arquivo
                        escritor.write(nome);
                        escritor.newLine();
                        System.out.println(nome);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler ou criar o arquivo: " + e.getMessage());
        }
    }

    private String[] extrairNomes(String texto) {
        // Use uma expressão regular para extrair nomes
        Pattern pattern = Pattern.compile("[A-Z][a-zA-ZÀ-ÖØ-öø-ÿ]+( [A-Z][a-zA-ZÀ-ÖØ-öø-ÿ]+)*");
        Matcher matcher = pattern.matcher(texto);
        StringBuilder nomes = new StringBuilder();

        while (matcher.find()) {
            nomes.append(matcher.group()).append("\n");
        }

        return nomes.toString().trim().split("\n");
    }

    private Properties loadProperties(String propertiesFile) {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFile)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Arquivo de propriedades não encontrado: " + propertiesFile);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo de propriedades: " + e.getMessage());
        }
        return properties;
    }
}

// -----------------------codigo sem application.properties-------------------------------------------------------
//        public void lerEImprimirArquivo(String caminhoDoArquivo, String caminhoDoNovoArquivo) {
//            try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoDoArquivo));
//                 BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoDoNovoArquivo))) {
//
//                String linha;
//                boolean primeiraLinha = true;
//
//                while ((linha = leitor.readLine()) != null) {
//                    if (primeiraLinha) {
//                        escritor.write(linha);
//                        escritor.newLine();
//                        primeiraLinha = false;
//                        System.out.println(linha);
//                    } else {
//                        // Use uma expressão regular para extrair nomes
//                        String[] nomes = extrairNomes(linha);
//                        for (String nome : nomes) {
//                            // Escrever o nome no novo arquivo
//                            escritor.write(nome);
//                            escritor.newLine();
//                            System.out.println(nome);
//                        }
//                    }
//                }
//            } catch (IOException e) {
//                System.err.println("Erro ao ler ou criar o arquivo: " + e.getMessage());
//            }
//        }
//
//        private String[] extrairNomes(String texto) {
//            // Use uma expressão regular para extrair nomes
//            Pattern pattern = Pattern.compile("[A-Z][a-zA-ZÀ-ÖØ-öø-ÿ]+( [A-Z][a-zA-ZÀ-ÖØ-öø-ÿ]+)*");
//            Matcher matcher = pattern.matcher(texto);
//            StringBuilder nomes = new StringBuilder();
//
//            while (matcher.find()) {
//                nomes.append(matcher.group()).append("\n");
//            }
//
//            return nomes.toString().trim().split("\n");
//        }
//    }
