package br.eb.ime.rules;

/**
 * 
 *	Class Rule3
 * 
 **/

public class Rule3 {

	static Integer RulePriority = 3;

	public static String checkMode(String CurrentMode, boolean SampleValues_ASC, boolean SampleValues_DESC, double SecLevel, double CarrierFreq, String OpRole){

		final String NewMode;

		if(!(SampleValues_ASC==true)){
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
	
