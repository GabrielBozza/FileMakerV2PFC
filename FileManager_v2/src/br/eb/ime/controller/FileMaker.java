package br.eb.ime.controller;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Random;

public  class  FileMaker {

	public  void gravaArquivo(String nomeArquivo) throws IOException, InterruptedException, ParseException{
    	FileWriter arq = new FileWriter(nomeArquivo);
	    PrintWriter gravarArq = new PrintWriter(arq);
    	int i;	
    	for (i=1; i<=100; i++) {
	    	gravarArq.printf(gerarPower()+" "+gerarFReq()+" "+gerarSecurityLevel()+" "+gerarRole()+"%n");
	    }
    	gravarArq.close();
	    arq.close();
     }
	
	public  String gerarFReq() {
	   String freq; int numero;
	   Random random = new Random();
	   numero = random.nextInt(10);
	    if (numero < 5) {
		 freq = "100";
	     } else  freq = "50";
	  return freq;
	}
	
	public  String gerarRole() {
		   String role; int numero;
		   Random random = new Random();
		   numero = random.nextInt(10);
		    if (numero < 5) {
			 role = "cmt";
		     } else  role = "soldier";
		  return role;
	}
	
	public  String gerarSecurityLevel() throws ParseException {
		   float sLevel;
		   
		   Random random = new Random();
		   sLevel = random.nextFloat();
		   DecimalFormatSymbols decF = new DecimalFormatSymbols(Locale.US);
		   DecimalFormat formatter = new DecimalFormat("#0.0", decF); 
		 
		 return formatter.format(sLevel);
		 
	}
	
	public  String gerarPower() {
		   Integer power=0;
		   Random random = new Random();
		   while  (power < 2 ) {
			  power = random.nextInt(10);
		    }
		   return power.toString();
		}

	public FileMaker() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

	    
	    
	    
	  
	    
	    
	    
	    
	
