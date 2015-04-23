package adapter;

import java.util.Scanner;

public class AutoException extends Exception{
	private int errorNo;
	private String errorMsg;
	
	public AutoException() {
		super();
		printmyproblem();
	}
	
	public AutoException(String errormsg) {
		super();
		this.errorMsg = errormsg;
		printmyproblem();
	}
	
	public AutoException(int errorNo) {
		super();
		this.errorNo = errorNo;
		printmyproblem();
	}
	
	public AutoException(int errorNo, String errormsg) {
		super();
		this.errorNo = errorNo;
		this.errorMsg = errormsg;
		printmyproblem();
	}
	
	public int geterrorNo() {
		return errorNo;
	}
	
	public void seterrorNo(int errorNo) {
		this.errorNo = errorNo;
	}
	
	public String getErrormsg() {
		return errorMsg;
	}
	
	public void setErrormsg(String errormsg) {
		this.errorMsg = errormsg;
	}
	
	public void printmyproblem() {
		System.out.println("AutoException[errorNo=" + errorNo + ", errormsg=" + errorMsg + "]"); 
	}
	
	public String fixFileNotRead()
	{
		Scanner read = new Scanner(System.in);
		System.out.println("Enter file name.");
		String filename = read.nextLine();
		read.close();
		
		return filename;
	}
}