package br.eb.ime.model;

import java.util.ArrayList;

public class Log {
	private ArrayList<LogEntry> entries;

	public ArrayList<LogEntry> getLog() {
		return entries;
	}

	public void setEntries(ArrayList<LogEntry> entries) {
		this.entries = entries;
	}

	public Log() {
		super();
		}
	
	public Log(ArrayList<LogEntry> log) {
		super();
		entries = log;
	}
	

}
