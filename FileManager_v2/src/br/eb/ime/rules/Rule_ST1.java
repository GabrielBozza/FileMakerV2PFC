package br.eb.ime.rules;

/**
 * 
 *	Class Rule_ST1
 * 
 **/

public class Rule_ST1 {

	static Integer RulePriority = 10;

	public static String checkMode(String CurrentMode, boolean SNRValues_ASC, boolean SNRValues_DESC, double SecLevel, double CarrierFreq, String OpRole){

		final String NewMode;

		if(((SNRValues_ASC==true)&&((SecLevel>=0.5)&&(CarrierFreq==50.0)&&(OpRole.equalsIgnoreCase("Cmt"))))){
			NewMode = "SILENT_MODE";
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
	
