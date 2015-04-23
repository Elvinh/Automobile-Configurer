package Drivers;
import java.io.IOException;

import adapter.*;


public class DriverLab2 {

	public static void main(String[] args) throws IOException, AutoException 
	{
		BuildAuto test = new BuildAuto();
		test.buildAuto("AutomobileData.txt");
		test.printAuto(null);
		test.updateOptionSetName(null, "Colors", "Color");
		test.printAuto(null);
		test.updateOptionPrice(null, "Color", "Fort Knox Gold Clearcoat Metallic", 1);
		test.printAuto(null);
	}
}
