import java.awt.*;

public class Node {
    Node parent ;
    int x , y;
    Color color ;
    public int g , h ;
    boolean walkable;

    Node(boolean walkable,int x , int y)
    {
        this.x = x;
        this.y = y;
        this.walkable = walkable;


    }

    public int fCost()
    {
        return g+h;
    }


    void draw(Graphics g )
    {

        g.setColor(color);
        g.fillOval(x*Panel.nodeSize,y*Panel.nodeSize,Panel.nodeSize,Panel.nodeSize);
    }
    void update()
    {
        // where the color changing happens
        if(walkable)
        {
            color = Color.white;
        }
        else
        {
            color = Color.red;
        }
        if(this==Grid.start)
        {
            color = Color.green;

        }
        if(this==Grid.goal)
        {
            color=Color.MAGENTA;
        }
        if(Grid.path!=null)
        {
            if(Grid.path.contains(this))
            {
                color = Color.yellow;
            }
        }

    }




}
