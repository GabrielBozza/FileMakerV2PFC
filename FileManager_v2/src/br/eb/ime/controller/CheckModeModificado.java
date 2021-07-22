package br.eb.ime.controller;

import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.lang.reflect.*;

import br.eb.ime.model.Log;
import br.eb.ime.model.LogEntry;

public final class CheckModeModificado {
	
	public static String check(Log log, int windowSize) {
		String CurrentMode="SILENT MODE",NewMode="",className="" ;
		//usando métodos para checar ASC e DESC
		boolean asc = checkAsc(log);
		boolean desc = checkDesc(log);
		//Pega o último elemento do objeto Log, ou seja, a última leitura do ambiente
		LogEntry entryTest = log.getLog().get(windowSize-1);
		
		//A aplicação de todas as regras definidas na tabela de regras e definição do modo de operação
		
		File dir = new File(System.getProperty("user.dir")+"\\src\\br\\eb\\ime\\rules");
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
		  for (File child : directoryListing) {

			className = "br.eb.ime.rules."+child.getName().replace(".java", "");
			try {
				Class<?> cls = Class.forName(className);
				Method method;
				try {
					  method = cls.getMethod("checkMode", java.lang.String.class,boolean.class, boolean.class, double.class, double.class, java.lang.String.class);
					  try {
						NewMode = method.invoke(cls,CurrentMode,asc,desc,entryTest.getSecurityLevel(),entryTest.getFrequency(),entryTest.getRole().strip()).toString();
						System.out.println("Resultado da aplicação da regra = " + NewMode);
						} catch (IllegalArgumentException e) { e.printStackTrace(); }
						  catch (IllegalAccessException e) { e.printStackTrace(); }
						  catch (InvocationTargetException e) { e.printStackTrace(); }
					} catch (SecurityException e) { e.printStackTrace(); }
					  catch (NoSuchMethodException e) { e.printStackTrace(); }

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			//NewMode = a.checkMode(asc, desc, windowSize, windowSize, className)  
		    //NewMode  = child.getClass().checkMode(asc,desc,entryTest.getSecurityLevel(),entryTest.getFrequency(),entryTest.getRole().strip());
		    CurrentMode = TieResolver(CurrentMode, NewMode, asc,desc,entryTest.getSecurityLevel(),entryTest.getFrequency(),entryTest.getRole().strip());
		  }
		} else {
          System.out.println("Could not find the directory: "+System.getProperty("user.dir")+"/Rules");
		}
		
	return CurrentMode;
}
	
	public static String TieResolver(String currentMode, String newMode, boolean Asc, boolean Desc, double securityLevel, double carrierFrequency, String opRole) {
		if(opRole.equals("cmd")){
			return "Silent Mode";
		}else {
			return newMode;
		}
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
