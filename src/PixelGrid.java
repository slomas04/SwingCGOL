/**
 * Pixel Grid
 * Made by: Samuel Lomas
 * Editable pixel array
 * */

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;


public class PixelGrid extends JPanel{
    private BufferedImage grid;
    private final Dimension preferredSize;
    private boolean isVisible;

    private JFrame window;

    public PixelGrid(int width, int height, String title) {
        preferredSize = new Dimension(width, height);
        grid = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        window = new JFrame(title);
        isVisible = false;

        window.add(this); // Incorporates the pixel grid into the window
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
    }

    public void toggleVisible(){
        isVisible = !isVisible;
        window.setVisible(isVisible);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(grid, 0, 0, this);
    }

    public void setColour(Color c, int x, int y){
        grid.setRGB(x, y, c.getRGB());
    }

    /**
     * Fill an area with a colour
     * @param c java.awt.color
     * @param x1 X coord of point a
     * @param y1 Y coord of point a
     * @param x2 X coord of point b
     * @param y2 Y coord of point b
     * @param inclusive inclusive fill if true, otherwise exclusive
     * */
    public void fillArea(Color c, int x1, int y1, int x2, int y2, boolean inclusive){
        int arWidth = x2-x1;
        int arHeight = y2-y1;
        if (inclusive) {
            for(int h = y1; h <= y2; h++){
                for(int w = x1; w <= x2; w++){
                    setColour(c, w, h);
                }
            }
        } else {
            for(int h = y1; h < y2; h++){
                for(int w = x1; w < x2; w++){
                    setColour(c, w, h);
                }
            }
        }
    }

    public void clear(){
        fillArea(Color.WHITE, 0, 0,
                (int)preferredSize.getWidth(), (int)preferredSize.getHeight(), false);
    }

    public void clear(Color c){
        fillArea(c, 0, 0,
                (int)preferredSize.getWidth(), (int)preferredSize.getHeight(), false);
    }

    @Override
    public Dimension getPreferredSize() {
        return preferredSize;
    }
}
