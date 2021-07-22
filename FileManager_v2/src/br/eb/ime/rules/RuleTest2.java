package br.eb.ime.rules;

/**
 * 
 *	Class RuleTest2
 * 
 **/

public class RuleTest2 {

	public static String checkMode(String CurrentMode, boolean SampleValues_ASC, boolean SampleValues_DESC, double SecLevel, double CarrierFreq, String OpRole){

		final String NewMode;

		if(((SampleValues_ASC==true)&&((SecLevel>=0.5)&&(CarrierFreq==50.0)&&(OpRole.equalsIgnoreCase("cmt"))))){
			NewMode = "Mode_3";
			return NewMode;
		}
		else{
			return (CurrentMode + "(MANTEM MODO)");
		}
	}
}	
	
