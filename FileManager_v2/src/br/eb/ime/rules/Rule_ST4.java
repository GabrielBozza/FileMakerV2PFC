package br.eb.ime.rules;

/**
 * 
 *	Class Rule_ST4
 * 
 **/

public class Rule_ST4 {

	static Integer RulePriority = 4;

	public static String checkMode(String CurrentMode, boolean SNRValues_ASC, boolean SNRValues_DESC, double SecLevel, double CarrierFreq, String OpRole){

		final String NewMode;

		if(((SNRValues_DESC==true)&&((SecLevel>=0.5)&&(CarrierFreq==50.0)&&(OpRole.equalsIgnoreCase("Soldier"))))){
			NewMode = "NORMAL_MODE";
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
	
