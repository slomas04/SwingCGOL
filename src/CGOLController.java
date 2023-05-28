import java.util.Random;
import java.awt.Color;

public class CGOLController {
    private final int WIDTH;
    private final int HEIGHT;

    private final int SCALE;

    private CGOLBoard board;
    private final PixelGrid pGrid;

    private void renderImage(){
        if (SCALE != 1){
            for (int hi = 0; hi < HEIGHT; hi++){
                for (int wi = 0; wi < WIDTH; wi++){
                    Color determined = (board.isAlive(hi, wi)) ? Color.white : Color.black;
                    pGrid.fillArea(determined, wi*SCALE, hi*SCALE,
                            wi*SCALE + SCALE, hi*SCALE + SCALE, false);
                }
            }
        } else {
            for (int hi = 0; hi < HEIGHT; hi++){
                for (int wi = 0; wi < WIDTH; wi++){
                    Color determined = (board.isAlive(hi, wi)) ? Color.white : Color.black;
                    pGrid.setColour(determined, WIDTH - wi - 1, HEIGHT - hi - 1);
                }
            }
        }
        pGrid.repaint();
    }

    public void updateGrid(){
        board = board.updateGrid();
        renderImage();
    }

    public CGOLController(int w, int h, int scale){
        WIDTH = w/scale;
        HEIGHT = h/scale;
        SCALE = scale;

        board = new CGOLBoard(WIDTH, HEIGHT);

        pGrid = new PixelGrid(w, h, "Conway's Game of Life");
        pGrid.fillArea(Color.black, 0,0, WIDTH, HEIGHT, true);
        renderImage();
        pGrid.toggleVisible();
    }
}
