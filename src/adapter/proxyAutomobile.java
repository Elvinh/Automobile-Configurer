package adapter;
import java.io.IOException;
import exception.AutoException;
import util.FileIO;
import model.*;

public abstract class proxyAutomobile {
	private AutomobileCollection autoColl;
	
	public proxyAutomobile()
	{
		autoColl = new AutomobileCollection();
	}
	
	public AutomobileCollection getAutoColl() {
		return autoColl;
	}

	public void setAutoColl(AutomobileCollection autoColl) {
		this.autoColl = autoColl;
	}

	public void updateOptionSetName(String modelName, String optionSetName,
			String newName) 
	{
		int opsetIndex = autoColl.getAutoMap().get(modelName).findOpset(optionSetName);
		autoColl.getAutoMap().get(modelName).setOptionsetName(opsetIndex, newName);
	}

	public void updateOptionPrice(String modelName, String optionSetName,
			String optionName, float newPrice) 
	{
		int opsetIndex = autoColl.getAutoMap().get(modelName).findOpset(optionSetName);
		int opIndex = autoColl.getAutoMap().get(modelName).findOption(optionSetName, optionName);
		autoColl.getAutoMap().get(modelName).setOptionPrice(opsetIndex, opIndex, newPrice);
	}

	public void buildAuto(String fileName) throws AutoException 
	{
		Automobile a1 = null;
		FileIO io = new FileIO();
		do {
			try {
				a1 = io.readFile(fileName);
			} catch (AutoException e) {
				if( e.geterrorNo()==101)
				{
					fileName = e.fixFileNotRead();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while(a1 == null);
		autoColl.addAuto(a1.getName(), a1);
	}

	public void printAuto(String modelName) 
	{
		try {
			autoColl.getAutoMap().get(modelName).printAll();
		} catch (NullPointerException e) {
			 new AutoException(106,"Model not found.");
		}
	}

}
