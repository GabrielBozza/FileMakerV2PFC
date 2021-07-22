package br.eb.ime.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.List;


import br.eb.ime.model.Log;
import br.eb.ime.model.LogEntry;


public class Manager {

	public static void main(String[] args) throws IOException, InterruptedException, ParseException {
		
					
    //"nome  e local do arquivo texto de log que será gerado	
	String nomeArquivo = "C:\\Users\\g-boz\\OneDrive\\Documentos\\testeLogNew.txt";	  
		
		// Grava arquivo de teste
			FileMaker fileMaker =  new FileMaker();
			fileMaker.gravaArquivo(nomeArquivo);
   
		// Simula a leitura do ambiente lendo os dados do arquivo de Log a cada 20ms e determina o modo de operação
				FileLoader fileLoader = new FileLoader();
				fileLoader.loadLog(nomeArquivo);
	  
	}	
}		
		


	


