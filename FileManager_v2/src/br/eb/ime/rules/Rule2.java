package br.eb.ime.rules;

/**
 * 
 *	Class Rule2
 * 
 **/

public class Rule2 {

	static Integer RulePriority = 2;

	public static String checkMode(String CurrentMode, boolean SampleValues_ASC, boolean SampleValues_DESC, double SecLevel, double CarrierFreq, String OpRole){

		final String NewMode;

		if((((SecLevel>50.0)||(CarrierFreq==100.0)&&(CarrierFreq==100.0))&&(SecLevel<=0.0)&&(SampleValues_DESC!=false)||((SecLevel>50.0)||(CarrierFreq==100.0)&&(CarrierFreq==100.0)))){
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
	
