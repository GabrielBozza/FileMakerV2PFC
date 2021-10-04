package br.eb.ime.controller;

import java.util.ArrayList;
import java.util.Date;

import br.eb.ime.model.Log;
import br.eb.ime.model.LogEntry;

public final class CheckMode {
	
	public static String check(Log log, int windowSize) {
		String mode="";
		//usando métodos para checar ASC e DESC
		boolean asc = checkAsc(log);
		boolean desc = checkDesc(log);
		//Pega o último elemento do objeto Log, ou seja, a última leitura do ambiente
		LogEntry entryTest = log.getLog().get(windowSize-1);
		
		//A aplicação de todas as regras definidas na tabela de regras e definição do modo de operação
		
		if  ((asc) && (entryTest.getSecurityLevel()>=0.5)&&(entryTest.getFrequency()==50)&&(entryTest.getRole().strip().equals("cmt"))){
			mode = "SILENT_MODE";
						
		} else {if ((asc)&&(entryTest.getSecurityLevel()<0.5)&&(entryTest.getFrequency()==100)&&(entryTest.getRole().strip().equals("cmt"))){
						mode="FULLDUPLEX_MODE";
						
					} else {if (asc) {
								mode ="ALERT_MODE";
								
					          }	
					   }
		  } 
	
	  
    	 
    	 if ((desc)&&(entryTest.getSecurityLevel()>=0.5)&&(entryTest.getFrequency()==50)&&(entryTest.getRole().strip().equals("soldier"))){
						mode = "NORMAL_MODE";
						
						
					  } else {
						     if ((desc)&&(entryTest.getSecurityLevel()<0.5)&&(entryTest.getFrequency()==100)&&(entryTest.getRole().strip().equals("soldier"))){
					    	     mode = "NORMAL_MODE";
								 
								
					          }else {if(desc) {
										mode = "ALERT_MODE";
											
					                  }
					           }
  	                    }
     
     
     if((!asc) && (!desc)) { Date fim = new Date();
            	    mode = "MAINTAIN_CURRENT_MODE";
     }
      
	return mode;
}

	 //método auxiliar  para checagem da condição ASC
	 static boolean checkAsc(final Log logTes){
		float test=0;
		boolean fim=false;
		boolean asct = false;
		 ArrayList<LogEntry> logEntries = logTes.getLog();
		
		for (LogEntry logEntry : logEntries) {
			if (!fim) {
				if (test < logEntry.getSampleValue()) {
					test = logEntry.getSampleValue();
					asct=true;
				}else {
					asct=false;
					fim =true;
				}
			}
		}
		return asct;
	}
		
	 
	 //método auxiliar  para checagem da condição DESC
	 static boolean checkDesc(Log logTes){
		float test=10;
		boolean fim=false;
		boolean desct = false;
		 ArrayList<LogEntry> logEntries = logTes.getLog();
		
		for (LogEntry logEntry : logEntries) {
			if (!fim) {
				if (test > logEntry.getSampleValue()) {
					test = logEntry.getSampleValue();
					desct=true;
				}else {
					desct=false;
					fim =true;
				}
			}
		}
		return desct;
	}	
	    	
	 	 
	
	
}
