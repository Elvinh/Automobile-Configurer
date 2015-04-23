package model;

import java.io.Serializable;

public class OptionSet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3305369614268341318L;
	
	private Option opt[];
	private String name;
	
	public OptionSet(){	
	}
	protected OptionSet(String n)
	{
		this.name = n;
	}
	public OptionSet(String n, int size)
	{
		opt = new Option[size];
		name = n;
		for(int i=0;i<opt.length;i++)
			opt[i] = new Option();
	}
	protected Option[] getOpt() {
		return opt;
	}
	protected Option getOpt(int i)
	{
		return opt[i];
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	
	protected void printAll()
	{
		System.out.println("\n" + name + ":");
		for(int i=0;i<opt.length;i++)
		{
			opt[i].printAll();
		}
	}
	
}
