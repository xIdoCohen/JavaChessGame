package Runner;

import java.awt.*;
import javax.swing.*;
public class myButton extends JButton
{
    private Image img;
    public myButton(Image img1)
    {
        this.img=img1;
    }
    public Image getImage()
    {
        return this.img;
    }
    public void setImage(Image img1)
    {
        this.img=img1;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

}
