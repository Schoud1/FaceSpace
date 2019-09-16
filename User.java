package FaceSpace;


import java.lang.String;
import java.lang.Object;


public class User extends Object implements Cloneable
{
	private String name;
	private int id;
	
	public User(String nm)
	{
		name = nm;
		id = 0;
	}
	
	public void updateName(String nm)
	{
		name = nm;
	}
	
	public void updateId(int i)
	{
		id = i;
	}
	
	@Override
	public boolean equals(Object o)
	{
		User u = new User("");
		
		if(u.getClass() != o.getClass())
		{
			return false;
		}
		
		u = (User)o;
		
		if(name.equals(u.name))
		{
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return (id + name.length()) % 8;
	}
	
	@Override
 	public String toString()
 	{
		return name;
 	}
	
	@Override
	public Object clone()
	{
		User u = new User(name);
		u.id = id;
		
		return (Object)u;
	}
	
	public int vertexNo()
	{
		return id;
	}
	
	public void print()
	{
		System.out.print(name);
	}
}
