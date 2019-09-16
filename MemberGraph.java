package FaceSpace;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class MemberGraph {

	private LinkedListH<User> faces;
	private Graph net;

	
	public MemberGraph() {
		faces = new LinkedListH<User>();
		net = new Graph(0);
	}
	
	// 1: Add user
	public void addUser(Scanner in)
	{
		String name;
		User u;
		
		System.out.println("Please enter the name of the new member:");
		name = in.nextLine();
		u = new User(name);
		
		if(faces.contains(u))
		{
			System.out.println("FaceSpace already has a user:");
			u.print();
			System.out.println("");
		}
		else
		{
			u.updateId(net.numVertices());
			faces.addLast(u);
			net.addVertex();
			System.out.println("FaceSpace is adding the user:");
			u.print();
			System.out.println("");
		}
	}

	// 2: Update User
	public void updateUser(Scanner in)
	{
		String name;
		User u, w;
		int ndx;
		
		System.out.println("Please enter the name of the member to update:");
		name = in.nextLine();
		u = new User(name);
		
		if(faces.contains(u)) 
		{
			System.out.println("FaceSpace found user:");
			u.print();
			System.out.println("");
			
			System.out.println("Please enter the new name for the user:");
			name = in.nextLine();
			w = new User(name);
			
			if( ! faces.contains(w))
			{
				for(ndx = 0; ndx < faces.size(); ndx++)
				{
					User v = faces.removeFirst();
				
					if(u.equals(v)) // not ==, but equals
					{
						v.updateName(name); // use the one from the list, so
											
						faces.addLast(v);
						break;
					}
					faces.addLast(v);
				}
			}
			
			System.out.println("User has been updated");
		}
		else
		{
			System.out.println("User does not exist in system");
			System.out.println("FaceSpace is unable to update the user:");
			u.print();
			System.out.println("");
		}
	}
	
	// 3: Search for User
	public void searchUser(Scanner in)
	{
		String name;
		User u, actual;
		
		System.out.println("Please enter a name to search:");
		name = in.nextLine();
		u = new User(name);
		
		if(faces.contains(u))
		{
			Iterator<User> it = faces.iterator();
			
			while(it.hasNext())
			{
				actual = it.next();
				
				if(actual.equals(u))
				{
					System.out.println("FaceSpace found user:");
					actual.print();
					System.out.println("");
				}
			}
		}
		else
		{
			System.out.println("FaceSpace user is not found:");
			u.print();
			System.out.println("");
		}
	}
	
	// 4: Add Friend to User
	public void addNet(Scanner in)
	{
		String name;
		User u, v;
		User friend1 = null;
		User friend2 = null;
		boolean one; 
		
		System.out.println("Please enter the name of a friend:");
		name = in.nextLine();
		u = new User(name);
		
		if(faces.contains(u))
		{
			System.out.println("FaceSpace found user:");
			u.print();
			System.out.println("");
		}
		else
		{
			System.out.println("FaceSpace user is not found:");
			u.print();
			System.out.println("");
			return;
		}

		System.out.println("Please enter the name of a friend:");
		name = in.nextLine();
		v = new User(name);
		
		if(faces.contains(v))
		{
			System.out.println("FaceSpace found user:");
			v.print();
			System.out.println("");
		}
		else
		{
			System.out.println("FaceSpace user is not found:");
			v.print();
			System.out.println("");
			return;
		}
		
		for(int ndx = 0; ndx < faces.size(); ndx++)
		{
			User a = faces.removeFirst();
			
			if(a.equals(u))
			{
				friend1 = a;
				faces.addLast(a);
				break; 
			}
			faces.addLast(a);
		}
		
		for(int ndx = 0; ndx < faces.size(); ndx++)
		{
			User a = faces.removeFirst();
			
			if(a.equals(v))
			{
				friend2 = a;
				faces.addLast(a);
				break;
			}
			faces.addLast(a);
		}
		net.addEdge(friend1.vertexNo(), friend2.vertexNo());
		System.out.println("Two users are now friends");
	}

	// 5: Remove Friend from User
	public void removeNet(Scanner in)
	{
		String name;
		User u, v;
		User friend1 = null;
		User friend2 = null;
		
		System.out.println("Please enter the name of a friend:");
		name = in.nextLine();
		u = new User(name);
		
		if(faces.contains(u))
		{
			System.out.println("FaceSpace found user:");
			u.print();
			System.out.println("");
		}
		else
		{
			System.out.println("FaceSpace user is not found:");
			u.print();
			System.out.println("");
			return;
		}

		System.out.println("Please enter the name of a friend:");
		name = in.nextLine();
		v = new User(name);
		
		if(faces.contains(v))
		{
			System.out.println("FaceSpace found user:");
			v.print();
			System.out.println("");
		}
		else
		{
			System.out.println("FaceSpace user is not found:");
			v.print();
			System.out.println("");
			return;
		}
		
		for(int ndx = 0; ndx < faces.size(); ndx++)
		{
			User a = faces.removeFirst();
			
			if(a.equals(u))
			{
				friend1 = a;
				faces.addLast(a);
				break; // done searching
			}
			faces.addLast(a);
		}
		
		for(int ndx = 0; ndx < faces.size(); ndx++)
		{
			User a = faces.removeFirst();
			
			if(a.equals(v))
			{
				friend2 = a;
				faces.addLast(a);
				break;
			}
			faces.addLast(a);
		}
		net.removeEdge(friend1.vertexNo(), friend2.vertexNo());
		System.out.println("Two users are not friends");
	}
	
	// 6: Find Degree of Separation Between Users
	public void separationNet(Scanner in)
	{
		String name;
		User u, v;
		User friend1 = null;
		User friend2 = null;
		DepthFirstPaths dfps;
		
		System.out.println("Please enter a name of FaceSpacer:");
		name = in.nextLine();
		u = new User(name);
		
		if(faces.contains(u))
		{
			System.out.println("FaceSpace found user:");
			u.print();
			System.out.println("");
		}
		else
		{
			System.out.println("FaceSpace user is not found:");
			u.print();
			System.out.println("");
			return;
		}

		System.out.println("Please enter the name of a second FaceSpacer:");
		name = in.nextLine();
		v = new User(name);
		
		if(faces.contains(v))
		{
			System.out.println("FaceSpace found user:");
			v.print();
			System.out.println("");
		}
		else
		{
			System.out.println("FaceSpace user is not found:");
			v.print();
			System.out.println("");
			return;
		}
		
		for(int ndx = 0; ndx < faces.size(); ndx++)
		{
			User a = faces.removeFirst();
			
			if(a.equals(u))
			{
				friend1 = a;
				faces.addLast(a);
				break; // done searching
			}
			faces.addLast(a);
		}
		
		for(int ndx = 0; ndx < faces.size(); ndx++)
		{
			User a = faces.removeFirst();
			
			if(a.equals(v))
			{
				friend2 = a;
				faces.addLast(a);
				break;
			}
			faces.addLast(a);
		}
		
		dfps = new DepthFirstPaths(net, friend1.vertexNo());
		
		if(dfps.hasPathTo(friend2.vertexNo()))
		{
			System.out.print("The user ");
			friend1.print();
			System.out.print(" is connected to the user ");
			friend2.print();
			System.out.println("");
		}
		else
		{
			System.out.print("The user ");
			friend1.print();
			System.out.print(" is not connected to the user ");
			friend2.print();
			System.out.println("");
		}
	}
}