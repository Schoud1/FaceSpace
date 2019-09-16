package FaceSpace;



import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.LinkedList;


public class FaceSpace {

	
	public static void main(String[] args)
	{
		MemberGraph g = new MemberGraph();
		Scanner scan = new Scanner(System.in);
		int response = getCommand(scan);
		
		while(7 != response)
		{
			switch(response)
			{
			case 1: // add a user
				g.addUser(scan);
				break;
				
			case 2: // update a user
				g.updateUser(scan);
				break;
				
			case 3: // search for a user
				g.searchUser(scan);
				break;
				
			case 4: // add a friend to the user
				g.addNet(scan);
				break;
				
			case 5: // remove a friend from a user
				g.removeNet(scan);
				break;
				
			case 6: // find degrees of separation
				g.separationNet(scan);
				break;
			}
			
			response = getCommand(scan);
		}
	}
	
	public static int getCommand(Scanner in)
	{
		int result = 0;
		String input;
		
		while( ! (0 < result && result < 8))
		{
			System.out.println("Please select an activity on FaceSpace");
			System.out.println("1\t--\tAdd a user");
			System.out.println("2\t--\tUpdate a user");
			System.out.println("3\t--\tSearch for a user");
			System.out.println("4\t--\tAdd a friend to a user");
			System.out.println("5\t--\tRemove a friend from a user");
			System.out.println("6\t--\tFind separation between two users");
			System.out.println("7\t--\tQuit");
		
			input = in.nextLine();
			result = Integer.parseInt(input);
		}
		
		return result;
	}
}
