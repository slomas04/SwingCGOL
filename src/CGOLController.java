import java.util.Random;
import java.awt.Color;

public class CGOLController {
    private final int WIDTH;
    private final int HEIGHT;

    private CGOLBoard board;
    private final PixelGrid pGrid;

    private void renderImage(){
        for (int hi = 0; hi < HEIGHT; hi++){
            for (int wi = 0; wi < WIDTH; wi++){
                Color determined = (board.isAlive(hi, wi)) ? Color.white : Color.black;
                pGrid.setColour(determined, WIDTH - wi - 1, HEIGHT - hi - 1);
            }
        }
        pGrid.repaint();
    }

    public void updateGrid(){
        board = board.updateGrid();
        renderImage();
    }

    public CGOLController(int w, int h){
        WIDTH = w;
        HEIGHT = h;

        board = new CGOLBoard(w, h);

        pGrid = new PixelGrid(WIDTH, HEIGHT, "Conway's Game of Life");
        renderImage();
        pGrid.toggleVisible();
    }
}
