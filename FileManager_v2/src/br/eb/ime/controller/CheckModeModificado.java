package br.eb.ime.controller;

import java.util.ArrayList;
import java.util.TreeMap;
import java.io.File;
import java.lang.reflect.*;

import java.util.*;

import br.eb.ime.model.Log;
import br.eb.ime.model.LogEntry;

public final class CheckModeModificado {
	
	public static String check(Log log, int windowSize) {
		String CurrentMode="MAINTAIN_CURRENT_MODE",NewMode="",className="" ;
		int priority = 1000;
		
		//usando métodos para checar ASC e DESC
		boolean asc = checkAsc(log);
		boolean desc = checkDesc(log);
		
		//Pega o último elemento do objeto Log, ou seja, a última leitura do ambiente
		LogEntry entryTest = log.getLog().get(windowSize-1);
		
		//TreeMap que armazena <Integer RulePriority,String nomeClasse>
		TreeMap<Integer, String> map = new TreeMap<>();
		
		//A aplicação de todas as regras definidas na tabela de regras e definição do modo de operação
		
		//Itera sobre as classes Java do pacote src.br.eb.ime.rules do corrente projeto e armazena num Treemap <Integer RulePriority,String nomeClasse>
		File dir = new File(System.getProperty("user.dir")+"\\src\\br\\eb\\ime\\rules");
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
		  for (File child : directoryListing) {
			className = "br.eb.ime.rules."+child.getName().replace(".java", "");
			try {
				Class<?> cls = Class.forName(className);
				Method methodGetPriority;
				try {
					  methodGetPriority = cls.getMethod("getRulePriority");
					  try {
						priority = Integer.parseInt(methodGetPriority.invoke(cls).toString());
						map.put(priority, className);
						} catch (IllegalArgumentException e) { e.printStackTrace(); }
						  catch (IllegalAccessException e) { e.printStackTrace(); }
						  catch (InvocationTargetException e) { e.printStackTrace(); }
					} catch (SecurityException e) { e.printStackTrace(); }
					  catch (NoSuchMethodException e) { e.printStackTrace(); }
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		    //CurrentMode = TieResolver(CurrentMode, NewMode, asc,desc,entryTest.getSecurityLevel(),entryTest.getFrequency(),entryTest.getRole().strip());
		  }
		} else {
          System.out.println("Could not find the directory: "+System.getProperty("user.dir")+"/Rules");
		}
		
		//TreeMap organiza o map em ordem decrescente de prioridade (1>2>3>....>1000>...)
		//Checa as regras de acordo com a ordem de prioridade --> a primeira que modificar o modo do rádio dá um break no loop
		for (Map.Entry<Integer, String> e : map.entrySet()) {
            //System.out.println(e.getKey() + " " + e.getValue());
			try {
				Class<?> cls = Class.forName(e.getValue());
				Method methodCheckMode;
				try {
					  methodCheckMode = cls.getMethod("checkMode", java.lang.String.class,boolean.class, boolean.class, double.class, double.class, java.lang.String.class);
					  try {
						NewMode = methodCheckMode.invoke(cls,CurrentMode,asc,desc,entryTest.getSecurityLevel(),entryTest.getFrequency(),entryTest.getRole().strip()).toString();
						System.out.println("Resultado da aplicação da regra " + e.getValue().subSequence(16, e.getValue().length()) +" (Prioridade-->"+e.getKey()+ ") = " + NewMode);
						//CurrentMode = NewMode;
						if(!(NewMode.equalsIgnoreCase("MAINTAIN_CURRENT_MODE"))) return NewMode;

						} catch (IllegalArgumentException ex) { ex.printStackTrace(); }
						  catch (IllegalAccessException ex) { ex.printStackTrace(); }
						  catch (InvocationTargetException ex) { ex.printStackTrace(); }
					} catch (SecurityException ex) { ex.printStackTrace(); }
					  catch (NoSuchMethodException ex) { ex.printStackTrace(); }

			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
        }
		
		CurrentMode = NewMode;
		
	return CurrentMode;
}
	
	/*public static String TieResolver(String currentMode, String newMode, boolean Asc, boolean Desc, double securityLevel, double carrierFrequency, String opRole) {
		if(opRole.equals("cmd")){
			return "Silent Mode";
		}else {
			return newMode;
		}
	}*/

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
