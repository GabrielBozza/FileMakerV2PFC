package br.eb.ime.rules;

/**
 * 
 *	Class RuleTest3
 * 
 **/

public class RuleTest3 {

	public static String checkMode(String CurrentMode, boolean SampleValues_ASC, boolean SampleValues_DESC, double SecLevel, double CarrierFreq, String OpRole){

		final String NewMode;

		if(((CarrierFreq>=100.0)&&(SecLevel<=0.5)||((OpRole.equalsIgnoreCase("soldier"))&&((SampleValues_ASC==true)&&(SampleValues_DESC==false))))){
			NewMode = "Mode_4";
			return NewMode;
		}
		else{
			return (CurrentMode + "(MANTEM MODO)");
		}
	}
}	
	
