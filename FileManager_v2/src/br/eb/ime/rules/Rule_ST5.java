package br.eb.ime.rules;

/**
 * 
 *	Class Rule_ST5
 * 
 **/

public class Rule_ST5 {

	static Integer RulePriority = 5;

	public static String checkMode(String CurrentMode, boolean SNRValues_ASC, boolean SNRValues_DESC, double SecLevel, double CarrierFreq, String OpRole){

		final String NewMode;

		if((SNRValues_ASC==true)){
			NewMode = "ALERT_MODE";
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
	
