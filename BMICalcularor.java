
import javax.swing.JOptionPane;
public class BMICalcularor 
{

	public static void main(String[] args)
	{
		
		
		   
		 
		  String weight, height;
		  weight = JOptionPane.showInputDialog( "Please enter your weight");
		  height = JOptionPane.showInputDialog( "Please enter your height");
		  double numweight;
		  double numheight;
		  numweight = Double.parseDouble(weight);
		  numheight = Double.parseDouble(height);
		  
		     JOptionPane.showMessageDialog( null, "Your BMI is" + (numweight*703)/(numheight*numheight));
		     
		    double BMI = (numweight*703)/(numheight*numheight);
		    if (BMI < 16)
		     JOptionPane.showMessageDialog( null, "Emaciated");
		    else if (BMI < 18.5)
		      JOptionPane.showMessageDialog( null, "Underweight");
		    else if (BMI < 25)
		      JOptionPane.showMessageDialog( null, "Normal");
		    else if (BMI < 30)
		      JOptionPane.showMessageDialog( null, "Overweight");
		    else if (BMI > 30)
		      JOptionPane.showMessageDialog( null, "Obese");
	}
	}
		   

		   
	


