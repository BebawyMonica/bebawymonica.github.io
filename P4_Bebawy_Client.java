 /* CS 225 - Fundamentals of Computer Science
 * File Name: P4_Bebawy_Client.java
 * Java Programming
 * Project 4 - Due 03/20/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Monica Bebawy
 * Description: This file contains the source code for project 4.
 */

import java.io.File;

//TODO 1: Update the client class name below, the L6_LastName1_LastName2_PersonalizedFbBanner_P2
//references below, and header above with your name(s).
public class P4_Bebawy_Client
{	
	public static void main(String[] args)
	{
		// TODO 2: Update your info
		// Your program should always output your name and the lab/problem
		// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Monica Bebawy");
		System.out.println("Project four");
		System.out.println("");
		
		// Delete all the old output files
		DeleteOldOutput();

		
		// Run one of the following 4 methods at
		// any given time
		RollBall(new P4_Bebawy_Basketball());
		//RollBall(new P4_Bebawy_Beachball());
		//ThrowBall(new P4_Bebawy_Basketball());		
		//ThrowBall(new P4_Bebawy_Beachball());
		
		System.out.println("Ball movement simulation complete.");
	}	
	
	//////////////////////////////////////////////////////////
	// Calls high-level code to roll the ball
	public static void RollBall(P4_Bebawy_MovingBall b)
	{
		int name = 0;
		
		b.RollBall(20);
		while ((b.getBallCenterX() < Court.getCourtLength()))
		{
			b.AdvanceRollingBallSingleFrame();
			System.out.println("Frame " + name + " output.");
			Court.DrawBallOnCourt(b, Integer.toString(name++));
			
		}
	}
	
	//////////////////////////////////////////////////////////
	// Calls high-level code to throw the ball
	public static void ThrowBall(P4_Bebawy_MovingBall b)
	{
		int name = 0;
		
		b.ThrowBall(20, 400);
		while ((b.getBallCenterX() < Court.getCourtLength()) && b.IsThrownBallStillBouncing())
		{
			b.AdvanceThrownBallSingleFrame();
			System.out.println("Frame " + name + " output.");
			Court.DrawBallOnCourt(b, Integer.toString(name++));
		}
	}
	
	//////////////////////////////////////////////////////////
	// Deletes all files in the "Output" directory
	public static void DeleteOldOutput()
	{
		File dir = new File("Output");
	    String[] list = dir.list();
	    for (int i = 0; i < list.length; i++)
	    {
	      File file = new File("Output", list[i]);
	      file.delete();
	    }	
	}
}
