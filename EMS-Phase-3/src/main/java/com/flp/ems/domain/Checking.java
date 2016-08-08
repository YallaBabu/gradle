package com.flp.ems.domain;

import java.util.HashSet;

public class Checking {
	static HashSet<String> Hset=new HashSet<String>();
	public static void checking()
	{
		for(int i=1;i<5;i++)
		{
			Hset.add("syam");
		}
		System.out.print(Hset);
		
	}
	
	public static void main(String args[])
	
	{

  checking();

}
}
