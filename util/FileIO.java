package util;

import java.io.*;
import java.util.StringTokenizer;

import adapter.AutoException;
import model.Automobile;
import model.OptionSet;

public class FileIO {

	public FileIO(){
	}
	
	public Automobile readFile(String fileName) throws AutoException, IOException
	{
		//Open File for reading
		
		FileReader file;
		try {
			file = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			throw new AutoException(101,"File name not found.");
		}
		
		BufferedReader buff = new BufferedReader(file);
		boolean eof = false;
		
		//Parse for Automobile Name, Base Price, and Number of Options
		String ln = buff.readLine();
		StringTokenizer firstLine = new StringTokenizer(ln, ",");
		String AutomobileName = firstLine.nextToken();
		float baseP = Integer.parseInt(firstLine.nextToken());
		int numOfOpsets = Integer.parseInt(firstLine.nextToken());
		
		Automobile car = new Automobile(AutomobileName, baseP, numOfOpsets);
	
		//Parse Automobile Options
		int i = 0;
		while (!eof || i < numOfOpsets) 
		{
			String line = buff.readLine();
			if (line == null)
				eof = true;
			else
			{
				//Get Optionset Name
				StringTokenizer st = new StringTokenizer(line, "=,");
				car.getOpset()[i] = new OptionSet(st.nextToken(),Integer.parseInt(st.nextToken()));
				int j = 0;
				//Get Options
				while(st.hasMoreTokens()) 
				{
					car.setOptionName(i,j,st.nextToken());
					car.setOptionPrice(i,j,Float.parseFloat(st.nextToken()));
					j++;
				}
			}
			i++;
		}	
		buff.close();
		
		return car;
	}
	
	public void serialize(Automobile auto) throws IOException
	{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("A.dat"));
		out.writeObject(auto);
		out.close();
	}
	
	public Automobile deserialize() throws IOException, ClassNotFoundException
	{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("A.dat"));
		Automobile Automobile = (Automobile) in.readObject();
		in.close();
		return Automobile;
	}
}
