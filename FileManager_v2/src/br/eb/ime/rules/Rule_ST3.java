package br.eb.ime.rules;

/**
 * 
 *	Class Rule_ST3
 * 
 **/

public class Rule_ST3 {

	static Integer RulePriority = 3;

	public static String checkMode(String CurrentMode, boolean SNRValues_ASC, boolean SNRValues_DESC, double SecLevel, double CarrierFreq, String OpRole){

		final String NewMode;

		if(((SNRValues_ASC==true)&&((SecLevel<0.5)&&(CarrierFreq==100.0)&&(OpRole.equalsIgnoreCase("Cmt"))))){
			NewMode = "FULLDUPLEX_MODE";
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
	
