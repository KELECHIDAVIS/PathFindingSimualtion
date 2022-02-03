import java.awt.*;
import java.util.ArrayList;

public class Grid
{
    Node[][] nodes;
    public static Node start , goal;
    public static int gridx , gridy;
    public static ArrayList<Node> path;

    public Grid(int row, int col)
    {
        nodes = new Node[row][col];
        for(int i =0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                nodes[i][j] = new Node(true, j,i);
            }
        }
        gridx = col;
        gridy = row ;
        start=nodes[0][0];
        goal = nodes[row-1][col-1];
    }
    public  ArrayList<Node> getNeighbors( Node a )
    {
        ArrayList<Node> neighbors = new ArrayList<Node>();

        for(int i =-1; i<=1; i++ )
        {
            for(int j =-1; j<=1; j++)
            {
                if(i==0&&j==0)
                {
                    continue;
                }
                int x = a.x+j, y=a.y+i;
                if(y>=0&&y<this.nodes.length&&x>=0&&x<this.nodes[0].length)
                {
                    neighbors.add(this.nodes[y][x]);
                }
            }
        }
        return neighbors;
    }

    public void draw(Graphics g )
    {

        for(int i =0; i<nodes.length; i++)
        {
            for(int j=0; j<nodes[i].length; j++)
            {
                nodes[i][j].draw(g);
            }
        }
    }

    public void update()
    {
        for(int i =0; i<nodes.length; i++)
        {
            for(int j=0; j<nodes[i].length; j++)
            {
                nodes[i][j].update();
            }
        }
        path = Astar.Astar(this,start,goal);
    }





}
