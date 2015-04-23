package model;
import java.io.*;
import java.util.Scanner;

public class Automobile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8665829698387750321L;
	
	private String name;
	private float basePrice;
	private OptionSet opset[];
	
/**Constructors**/
	public Automobile()
	{
		name = null;
		basePrice = 0;
	}
	
	public Automobile(String n)
	{
		this.name = n;
	}
	public Automobile(String n, float baseP)
	{
		this.name = n;
		this.basePrice = baseP;
	}
	public Automobile(String n, int size) {
		this.name = n;
		opset = new OptionSet[size];
	}
	
	public Automobile(String n, float baseP, int sizeofOpset)
	{
		this.name = n;
		this.basePrice = baseP;
		opset = new OptionSet[sizeofOpset];	
		for(int i=0;i<opset.length;i++)
			opset[i] = new OptionSet();
	}
	
/**Getter/Setters**/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	
/**OptionSet accessors, mutators, modifiers**/
	public OptionSet getOpset(int i) {
		return opset[i];
	}
	public OptionSet[] getOpset()
	{
		return opset;
	}
	public void setOptionsetName(int pos, String n) 
	{
		opset[pos].setName(n);
		return;
		
	}
	public int findOpset(String name)
	{
		int targetIndex = -1;
		for(int i = 0; i < opset.length; i++)
		{
			if(opset[i].getName().equals(name))
			{
				targetIndex = i;
			};
		}
		return targetIndex;
	}
	
	public void updateOpset() 
	{
		String name = null;
		int foundIndex = -1;
		System.out.println("Enter name to be updated.");
		Scanner in = new Scanner(System.in);
		name = in.nextLine();
		foundIndex = findOpset(name);
		System.out.println("Enter new name.");
		name = in.nextLine();
		opset[foundIndex].setName(name);
		in.close();
	}
	
	public void deleteOpset()
	{
		String name = null;
		int foundIndex = -1;
		System.out.println("Enter name to be deleted.");
		Scanner in = new Scanner(System.in);
		name = in.nextLine();
		foundIndex = findOpset(name);
		//opset[foundIndex].clear();
		in.close();
	}
	
/** OptionSet accessors, mutators, modifiers **/
	public String getOptionName(int i, int j)
	{
		return opset[i].getOpt()[j].getName();
	}

	public void setOptionName(int i, int j, String n) 
	{
		opset[i].getOpt(j).setName(n);
		return;
	}
	
	public float getOptionPrice(int i, int j)
	{
		return opset[i].getOpt()[j].getPrice();
	}
	
	public void setOptionPrice(int i, int j, Float price) 
	{
		opset[i].getOpt(j).setPrice(price);
		return;
	}
	
	public int findOption(String optionSetName, String optionName)
	{
		int targetIndex = -1;
		int index = -1;
		
		index = findOpset(optionSetName);
		
		for(int i = 0; i < opset[index].getOpt().length; i++)
		{
			if(opset[index].getOpt(i).getName().equals(optionName))
			{
				targetIndex = i;
				//exit loop
			};
		}
		return targetIndex;
	}
	
	public void updateOption(int opsetIndex) 
	{
		String name = null;
		float price = 0;
		int foundIndex = -1;
		
		foundIndex = findOption(null, name);
		opset[opsetIndex].getOpt(foundIndex).setName(name);
		opset[opsetIndex].getOpt(foundIndex).setPrice(price);
		
	}
	
	public void deleteOption()
	{
		
	}
	
/** Print Methods **/
	public void printAll() 
	{
		System.out.println("\n"+name); 
		System.out.print("Base Price: ");
		System.out.println(basePrice);
		for(int i=0;i<opset.length;i++)
		{
			opset[i].printAll();
		}
		
	}
}
