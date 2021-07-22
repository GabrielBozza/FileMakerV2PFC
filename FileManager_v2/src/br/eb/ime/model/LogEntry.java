package br.eb.ime.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogEntry {
	private Date dataHora;
	private float sampleValue;
	private double securityLevel;
	private int frequency;
	private String role;
	
	
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public float getSampleValue() {
		return sampleValue;
	}
	public void setSampleValue(float sampleValue) {
		this.sampleValue = sampleValue;
	}
	public double getSecurityLevel() {
		return securityLevel;
	}
	public void setSecurityLevel(double securityLevel) {
		this.securityLevel = securityLevel;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public LogEntry(Date dataHora, float sampleValue, double securityLevel, int frequency, String role) {
		super();
		this.dataHora = dataHora;
		this.sampleValue = sampleValue;
		this.securityLevel = securityLevel;
		this.frequency = frequency;
		this.role = role;
	}
	
	public LogEntry(LogEntry entry) {
		super();
		this.dataHora = entry.getDataHora();
		this.sampleValue = entry.getSampleValue();
		this.securityLevel = entry.getSecurityLevel();
		this.frequency = entry.getFrequency();
		this.role = entry.getRole();
	}
	
	
	public LogEntry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void showLogEntry(LogEntry entry) {
		Date dataHora = entry.getDataHora();
	    SimpleDateFormat df;
	    df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");//Formato de saída da data
	    
	    DecimalFormatSymbols decF = new DecimalFormatSymbols(Locale.US);
		DecimalFormat formatter = new DecimalFormat("#0.0", decF); 
		 
		  
		System.out.println(df.format(dataHora)+" "+ entry.getSampleValue()+" "+ entry.getFrequency()+" "+ formatter.format(entry.getSecurityLevel())+" "+entry.getRole());
	}
	
	public void showLogEntry() {
		SimpleDateFormat df;
	    df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");//Formato de saída da data
	    
	    DecimalFormatSymbols decF = new DecimalFormatSymbols(Locale.US);
		DecimalFormat formatter = new DecimalFormat("#0.0", decF); 
		   
		System.out.println(df.format(this.dataHora)+" "+ this.getSampleValue()+" "+ this.getFrequency()+" "+ formatter.format(this.getSecurityLevel())+" "+this.getRole());
	}

}
