package br.eb.ime.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.eb.ime.model.Log;
import br.eb.ime.model.LogEntry;
import br.eb.ime.model.*;

public  class FileLoader {

	public  void loadLog(String nomeArquivo) throws IOException, ParseException, InterruptedException {
	   
	   ArrayList<LogEntry> entries = new ArrayList<LogEntry>();
	   Log log =  new Log();
	   	   
	   String linha;
	   String initialMode = "SilentMode";
	   
		// objetos de carga do arquivo
		      FileReader arq = new FileReader(nomeArquivo);
		      BufferedReader lerArq = new BufferedReader(arq);

		int windowSize = 3;// tamanho máximo da janela
		int count = 1;      
		      
		// a variável "linha" recebe o valor "null" quando o processo
		// de repetição atingir o final do arquivo texto
		
		linha = lerArq.readLine(); // lê a primeira linha do arquivo de log
		
		while (linha!=null) { 
			   
		         entries.add(fromLineToLogEntry(linha));// adiciona cada linha no ArrayList<LogEntry> 
		    	 LogEntry entry = new LogEntry(fromLineToLogEntry(linha));
		    	
			    
		    	 if (count<windowSize) {
		    		entry.showLogEntry();//mostra a linha lida
			    	System.out.println(initialMode);
			    	count++;
			    }else {
			    	log.setEntries(entries);//janela completa inserida no Objeto Log, que será checado
			    	entry.showLogEntry();//mostra a linha lida
			    	System.out.println(CheckModeModificado.check(log,windowSize));//momento onde as regras são aplicadas na classe Final CheckMode
			    	entries.remove(0); // elimina a primeira linha a cada leitura de uma nova linha(tornando a janela deslizante) 
			    }
		    	
		    	 Thread.sleep(20); // Simula o intervalo de leitura do ambiente (aguarda 20 milisegundos)
		    	linha = lerArq.readLine(); // lê cada uma das próximas linhas até a última linha
		    };
		    lerArq.close();	
		   
	}
	
	// Este método insere uma linha lida em um objeto LogEntry
	public  LogEntry fromLineToLogEntry(String line) throws ParseException {
		 LogEntry logEntry= new LogEntry();
		   
		    String campos[] = line.split(" ");//coleta dos dados de cada linha
	        Date dtHoraLida;
	        Date hoje = new Date();
			SimpleDateFormat df;
			df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");// formatando a data hora de leitura
	        //Formato de entrada da data lida SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
		        dtHoraLida=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(df.format(hoje));
		        float sampleValue = Float.parseFloat(campos[0]);
		        int frequency = Integer.parseInt(campos[1]);
		        double securityLevel =  (double)Float.parseFloat(campos[2]);
		        String role = campos[3];
		        logEntry = new LogEntry(dtHoraLida, sampleValue, securityLevel, frequency, role);// contrutor
	    
	  return logEntry;
    }
	

	public FileLoader() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
