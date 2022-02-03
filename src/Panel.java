import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Panel  extends GamePanel{
    Grid board ;
    boolean shift =false , control =false ;
    public static int nodeSize = 30;
    public Panel()
    {

        board = new Grid(18,18   );
        this.start();
    }

    @Override
    public void update() {

        board.update();
    }

    @Override
    public void paint(Graphics g) {

        board.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_SHIFT)
        {
            shift = true;
        }
        if(e.getKeyCode()==KeyEvent.VK_CONTROL)
        {
            control = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_SHIFT)
        {
            shift = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_CONTROL)
        {
            control = false ;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX()/nodeSize;
        int y = e.getY()/nodeSize;
        if(x>=0&&x<Main.width&&y>=0&&y<Main.height)
        {
            if(!shift&&!control){
                board.nodes[y][x].walkable = !board.nodes[y][x].walkable;
            }
            else if(shift) {
                Grid.start = board.nodes[y][x];
            }else
            {
             Grid.goal = board.nodes[y][x];
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
