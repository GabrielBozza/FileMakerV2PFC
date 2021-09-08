package br.eb.ime.rules;

/**
 * 
 *	Class Rule_ST6
 * 
 **/

public class Rule_ST6 {

	static Integer RulePriority = 6;

	public static String checkMode(String CurrentMode, boolean SNRValues_ASC, boolean SNRValues_DESC, double SecLevel, double CarrierFreq, String OpRole){

		final String NewMode;

		if((SNRValues_DESC==true)){
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
	
