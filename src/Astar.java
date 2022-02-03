import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Astar
{


    // distance finder
    public static int dist(Node a , Node b)
    {
        int x = Math.abs(a.x-b.x);
        int y  = Math.abs(a.y-b.y);
        if(x<y)   // diagonal moves cost  14 while regular moves cost 10
        {
            return 14*x +(10*(y-x));
        }
        return 14*y +(10*(x-y));
    }



    public static ArrayList<Node> Astar(Grid board , Node start , Node goal    )
    {
        ArrayList<Node> openSet = new ArrayList<Node>();
        HashSet<Node> closedSet = new HashSet<Node>();
        //add start to openset
        openSet.add(start);
        //loop
        while(openSet.size()>0)
        {
            //current = the node in openset with lowest fcost
            Node current = openSet.get(0);
            for(int i =0; i<openSet.size(); i++) // this makes the current one the node with the least fcost or one that has the same fcost but is closer to the goal
            {
                if(openSet.get(i).fCost()<current.fCost()||(current.fCost()==openSet.get(i).fCost()&&openSet.get(i).h<current.h))
                {
                    current = openSet.get(i);
                }
            }

            openSet.remove(current);
            closedSet.add(current);
            if(current==goal)
            {

                // first we want to retrace our steps then return

                return retrace(start,goal);
            }

            // for each neighbor
            for(Node e: board.getNeighbors( current))
            {
                // if not traversable or neighbor is in closed
                if(!e.walkable||closedSet.contains(e))
                    continue;

                //if new path to neighbor is shorter or neighbor is not in open
                int newCostToNeighbor = current.g + dist(current, e);
                if(newCostToNeighbor<e.g||!openSet.contains(e))
                {
                    e.g = newCostToNeighbor;
                    e.h = dist(e,goal   );
                    e.parent =current;
                    if(!openSet.contains(e))
                    {
                        openSet.add(e);
                    }
                }

            }




        }
        // no path
        System.out.println("No Path Found");
        return null;
    }

    public static ArrayList<Node> retrace(Node start , Node goal )
    {
        ArrayList<Node> path = new ArrayList<Node>();
        Node current = goal ;
        while(current.parent!=start)
        {
            path.add(current.parent);
            current = current.parent;
        }
        Collections.reverse(path);
        return path;
    }







}
