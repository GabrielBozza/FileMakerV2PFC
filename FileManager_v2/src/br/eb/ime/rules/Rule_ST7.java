package br.eb.ime.rules;

/**
 * 
 *	Class Rule_ST7
 * 
 **/

public class Rule_ST7 {

	static Integer RulePriority = 7;

	public static String checkMode(String CurrentMode, boolean SNRValues_ASC, boolean SNRValues_DESC, double SecLevel, double CarrierFreq, String OpRole){

		final String NewMode;
		
	
		if(((SNRValues_ASC==false)&&(SNRValues_DESC==false))){
			NewMode = "MAINTAIN_CURRENT_MODE";
			return NewMode;
		}
		else{
			return "MAINTAIN_CURRENT_MODE";
		}
	}

	public static Integer getRulePriority(){
		return RulePriority;
	}
}	
	
