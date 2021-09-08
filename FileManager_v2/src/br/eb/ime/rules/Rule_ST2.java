package br.eb.ime.rules;

/**
 * 
 *	Class Rule_ST2
 * 
 **/

public class Rule_ST2 {

	static Integer RulePriority = 2;

	public static String checkMode(String CurrentMode, boolean SNRValues_ASC, boolean SNRValues_DESC, double SecLevel, double CarrierFreq, String OpRole){

		final String NewMode;

		if(((SNRValues_DESC==true)&&((SecLevel<0.5)&&(CarrierFreq==100.0)&&(OpRole.equalsIgnoreCase("Soldier"))))){
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
	
