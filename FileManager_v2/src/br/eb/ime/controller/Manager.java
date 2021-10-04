package br.eb.ime.controller;

import java.io.IOException;
import java.text.ParseException;

public class Manager {

	public static void main(String[] args) throws IOException, InterruptedException, ParseException {
		
					
    //"nome  e local do arquivo texto de log que será gerado	
	//String nomeArquivo = "C:\\Users\\g-boz\\OneDrive\\Documentos\\testeLogNew.txt";	
	//String nomeArquivo = "C:\\Users\\g-boz\\OneDrive\\Documentos\\testeLogNewModificado.txt";	
	String nomeArquivo = "C:\\Users\\g-boz\\OneDrive\\Documentos\\testeLogNew_ComErros_Limite.txt";	
		
		// Grava arquivo de teste -- comentar para nao gerar outros logs aleatorios (testes)
			//FileMaker fileMaker =  new FileMaker();
			//fileMaker.gravaArquivo(nomeArquivo);
   
		// Simula a leitura do ambiente lendo os dados do arquivo de Log a cada 20ms e determina o modo de operação
				FileLoader fileLoader = new FileLoader();
				fileLoader.loadLog(nomeArquivo);
	  
	}	
}		
		


	


