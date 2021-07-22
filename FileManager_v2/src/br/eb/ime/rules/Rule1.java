package br.eb.ime.rules;

/**
 * 
 *	Class Rule1
 * 
 **/

public class Rule1 {

	static Integer RulePriority = 1;

	public static String checkMode(String CurrentMode, boolean SampleValues_ASC, boolean SampleValues_DESC, double SecLevel, double CarrierFreq, String OpRole){

		final String NewMode;

		if(((SecLevel>50.0)||((SecLevel>50.0)||(CarrierFreq<100.0)&&(CarrierFreq>75.0))||(OpRole.equalsIgnoreCase("cmt")))){
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
	
