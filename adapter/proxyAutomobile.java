package adapter;
import java.io.IOException;
import util.FileIO;
import model.*;

public abstract class proxyAutomobile {
	private Automobile a1;
	
	public void updateOptionSetName(String modelName, String optionSetName,
			String newName) 
	{
		a1.setOptionsetName(a1.findOpset(optionSetName), newName);
	}

	public void updateOptionPrice(String modelName, String optionSetName,
			String optionName, float newPrice) 
	{
		a1.setOptionPrice(a1.findOpset(optionSetName), a1.findOption(optionSetName, optionName), newPrice);
	}

	public void buildAuto(String fileName) throws AutoException 
	{
		FileIO io = new FileIO();
		do {
			try {
				a1 = io.readFile(fileName);
			} catch (AutoException e) {
				fileName = e.fixFileNotRead();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while(a1 == null);
		
	}

	public void printAuto(String modelName) 
	{
		a1.printAll();
	}

}
