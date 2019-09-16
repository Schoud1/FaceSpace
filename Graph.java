package FaceSpace;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;


public class Graph {

    private int numVertices;
    private int numEdges;
    private Bag<Integer>[] adj;

    
    public Graph(int numVertices) {
        initializeEmptyGraph(numVertices);
    }

  
    public Graph(String pathToFile) {

        File f = new File(pathToFile);
        Scanner scanner;
        try {
            scanner = new Scanner(f);

           
            int numVertices = Integer.parseInt(scanner.nextLine());
            initializeEmptyGraph(numVertices);

            while (scanner.hasNextLine()) {     
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                this.addEdge(v, w);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void initializeEmptyGraph(int numVertices) {
        
        this.numVertices = numVertices;
        this.numEdges = 0;

        
        if(numVertices == 0)
        {
        	adj = null;
        }
        else
        {
        	adj = (Bag<Integer>[]) new Bag[numVertices];
        }

      
        for (int v = 0; v < numVertices; v++) {
            adj[v] = new BagArray<Integer>();
        }
    }
    
    public void addVertex()
    {
    	int v;
    	Bag<Integer>[] updated_adj = (Bag<Integer>[]) new Bag[numVertices + 1];
    	
    	for(v = 0; v < numVertices; v++)
    	{
    		updated_adj[v] = new BagArray<Integer>();
    		
    		Iterator<Integer> it = adj[v].iterator();
    		
    		while(it.hasNext())
    		{
    			updated_adj[v].add(new Integer(it.next()));
    		}
    	}
    	updated_adj[v] = new BagArray<Integer>();
    	numVertices += 1;
    	adj = updated_adj;
    }

    public void addEdge(int v, int w)
    {    	
   		numEdges++;
   		adj[v].add(w);
   		adj[w].add(v);
    }

    public void removeEdge(int v, int w)
    {
    	Bag<Integer>[] updated_adj = (Bag<Integer>[]) new Bag[numVertices];
    	Integer tmp;
    	
    	for(int u = 0; u < numVertices; u++)
    	{
    		if(u != v && u != w) 
    		{
    			updated_adj[u] = new BagArray<Integer>();
    			Iterator<Integer> it = adj[u].iterator();
        		
        		while(it.hasNext())
        		{
        			updated_adj[u].add(new Integer(it.next().intValue()));
        		}
    		}
    		else if(u == v)
    		{
    			updated_adj[u] = new BagArray<Integer>();
    			Iterator<Integer> it = adj[u].iterator();
        		
        		while(it.hasNext())
        		{
    				tmp = it.next();
    				
    				if(tmp.intValue() != w)
    				{
    					updated_adj[u].add(new Integer(tmp.intValue()));
    				}
        		}
    		}
    		else if(u == w)
    		{
    			updated_adj[u] = new BagArray<Integer>();
    			Iterator<Integer> it = adj[u].iterator();
        		
        		while(it.hasNext())
        		{
    				tmp = it.next();
    				
    				if(tmp.intValue() != v)
    				{
    					updated_adj[u].add(new Integer(tmp.intValue()));
    				}
        		}
    		}
    	}
   		numEdges--;
   		adj = updated_adj;
    }
    
    
    public Iterable<Integer> adj(int v)
    {
        return adj[v];  
    }

    public int numVertices()
    {
        return this.numVertices;
    }

    public int numEdges()
    {
        return this.numEdges;
    }

    public int degree(int v)
    {
        return adj[v].size();
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        sb.append(numVertices + " vertices, " + numEdges + " edges " + NEWLINE);
        for (int v = 0; v < numVertices; v++) {
            sb.append(v + ": ");
            for (int w : adj[v]) {
                sb.append(w + " ");
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

   

}