/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: The class is an algorithm for Wi-Fi diagnosis
 * Due: 02.06.2023
 * Platform/compiler: Online GDB
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Fedor Mikhaylovich Sogonov
*/
package Dopustim;
import java.util.Scanner;
public class Code
{
    
   	public static void main(String[] args) 
	{
        Scanner input = new Scanner(System.in);
        String ans;
        
		System.out.println("If you have a problem with internet connectivity this WiFi Diagnosis might work.");
		System.out.println(" ");
		
		System.out.println("Reboot the computer and try to connect.");
        System.out.println("Did that fix the problem?");
        ans = input.next();
        
        if (ans.equals("No") || ans.equals("no"))
        {
            System.out.println("Reboot the router and try to connect.");
            System.out.println("Did that fix the problem?");
            ans = input.next();
            if (ans.equals("No") || ans.equals("no"))
            {
                System.out.println("Make sure that cables connecting the router are firmly pluged in and power is getting to the router.");
                System.out.println("Did that fix the problem?");
                ans = input.next();
                if (ans.equals("No") || ans.equals("no"))
                {
                            
                    System.out.println("Move the computer closer to router and try to connect.");
                    System.out.println("Did that fix the problem?");
                    ans = input.next();
                    if (ans.equals("No") || ans.equals("no")){
                        System.out.println("Contact your ISP.");
                    }
                            
                    else if (ans.equals("Yes") || ans.equals("yes"))
                    {
                        System.out.println("Done.");
                    }
                    else 
                    {
                        System.out.println("Invalid answer; try again.");
                    }
                }
                else if (ans.equals("Yes") || ans.equals("yes"))
                {
                    System.out.println("Done.");
                }
                            
                else 
                {
                    System.out.println("Invalid answer; try again.");
                }
            }else if (ans.equals("Yes") || ans.equals("yes"))
            {
                System.out.println("Done.");
            }
                        
            else 
            {
                System.out.println("Invalid answer; try again.");
                }
        }
        else if (ans.equals("Yes") || ans.equals("yes"))
        {
            System.out.println("Done.");
        }
        else 
        {
            System.out.println("Invalid answer; try again.");
        }
        System.out.println("Programmer: Fedor Mikhaylovich Sogonov");
        
    }
}