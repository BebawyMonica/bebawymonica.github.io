 /* CS 225 - Fundamentals of Computer Science
 * File Name: P4_Bebawy_MovingBall.java
 * Java Programming
 * Project 4 - Due 03/20/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Monica Bebawy
 * Description: This file contains the source code for project 4.
 * This class if where the balls actually movies 
 */
public class P4_Bebawy_MovingBall extends Ball implements BallMethods
{
	// This is to know when the ball hits the ground 
	protected boolean isFalling = false;

	// This is the overloaded constructor 
	P4_Bebawy_MovingBall(double rad, double bsl, String imageNameWithExt)
	{
		super(rad, bsl, imageNameWithExt);
	}
	
	/* This is the ThrowBall 
	 * This method does not move the ball
	 * first i set the x-velocity to the height velocity
	 * then the y-velocity to 0
	 * then the ball center to the starting height 
	 * then the ball center x to the ball center at x - the radius 
	 * then we set the ball still bouncing to true
	 */
	public void ThrowBall(double hVelocity, double startingHeight)
	{
		xVelocity = hVelocity;
		yVelocity = 0;
		ballCenterY = startingHeight;
		ballCenterX = ballCenterX - radius;
		ballStillBouncing = true; 
	}

	/* This is the RollBall method 
	 * This method does not roll the ball 
	 * It just sets the ball on the screen 
	 * first i set the x-velocity to the height velocity
	 * then i set the ball center y to the radius - 500(the width of the court)
	 * finally i set the ball center x to ball center at x - the radius 
	 */
	public void RollBall(double hVelocity) 
	{
		xVelocity = hVelocity;
		ballCenterY = radius - 500;
		ballCenterX = ballCenterX - radius;
	}

	/* This is the AdvanceRoolingBallSingleFrame method
	 * This method is actually where the ball rolls 
	 * first i calculated the 
	 * then in an if statement 
	 * i checked to see if ball center y is <= radius
	 * if so, i set ball center y to radius 
	 * is falling to false
	 * ball center x to ball center x + xVelocity
	 * and finally i rotated the ball 
	 */
	public void AdvanceRollingBallSingleFrame() 
	{
		double circum = 2*Math.PI*radius;
		if(ballCenterY <= radius)
		{
			ballCenterY = radius;
			isFalling = false;
			ballCenterX += xVelocity;
			degreesRotated += (xVelocity/circum)*360;
		}	
	}

	/* This is the AdvanceThrownBallSingleFrame method
	 * this method is actually where the ball when thrown 
	 * this method is just four if..else statements 
	 * they check if the ball is bouncing, falling
	 * or going back up
	 */
	public void AdvanceThrownBallSingleFrame() 
	{
	    /* The first if statement checks and see if yVelocity <=0
	     * and if it is not falling 
	     * first i set isFalling to true
         * then yVelocity = yVelocity + 9.8
		 */
		if(yVelocity <= 0 && !isFalling)
		{
			isFalling = true;
			yVelocity = yVelocity + 9.8;
		}
		/* The second if statement checks if ballcenterY <= radius
		 * and if it is falling
		 * first i set isFalling to false 
		 * then change the yVelocity to yVelocity-(yVelocity*bounceSpeedLoss) 
		 * then i check if yVelocity < 10
		 * and if so i set ballStillBouncing to false 
		 */
		else if(ballCenterY <= radius && isFalling)
		{
			isFalling = false;
			yVelocity = yVelocity - (yVelocity*bounceSpeedLoss);
			if(yVelocity < 10)
				ballStillBouncing = false;
		}
		/* The third if statement checks if the ball isFalling
		 * first i set ballCenterX to ballCenterX + xVelocity
		 * then ballCenterY to ballCenterY - yVelocity
		 * finally i set the yVelocity to yVelocity + 9.8
		 */
		else if(isFalling)
		{
			ballCenterX += xVelocity;
			ballCenterY -= yVelocity;
			yVelocity = yVelocity + 9.8;
		}
		/* The final if statement checks if the  ball is not falling
		 * first i set ballCenterX to ballCenterX + xVelocity
		 * then ballCenterY to ballCenterY + yVelocity
		 * finally i set the yVelocity to yVelocity - 9.8
		 */
		else if(!isFalling)
		{
			ballCenterX += xVelocity;
			ballCenterY += yVelocity;
			yVelocity = yVelocity - 9.8;
		}
	}

	/* This is the IsThrownBallStillBouncing
	 * this method checks if ballStillBouncing is true
	 * it returns true
	 * otherwise it returns false
	 */
	public boolean IsThrownBallStillBouncing() 
	{
		if(ballStillBouncing == true)
			return true;
		else 
		return false;
	}
}