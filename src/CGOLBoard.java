import java.util.Random;

public class CGOLBoard {
    private final int WIDTH;
    private final int HEIGHT;

    private final Random r = new Random();
    private final GOLCell[][] GOLGrid;

    public CGOLBoard(int w, int h){
        WIDTH = w;
        HEIGHT = h;
        // Create and instantiate golGrid
        GOLGrid = new GOLCell[HEIGHT][WIDTH];
        for (int hi = 0; hi < HEIGHT; hi++){
            for (int wi = 0; wi < WIDTH; wi++){
                GOLGrid[hi][wi] = new GOLCell();
            }
        }

        for (int hi = 0; hi < HEIGHT; hi++){
            for (int wi = 0; wi < WIDTH; wi++){
                GOLGrid[hi][wi].setNeighbors(this.getNeighbors(hi, wi));
                GOLGrid[hi][wi].setAlive(r.nextBoolean());
            }
        }
    }

    private void randomizeGrid(){
        for (int hi = 0; hi < HEIGHT; hi++){
            for (int wi = 0; wi < WIDTH; wi++){
                GOLGrid[hi][wi].setAlive(r.nextBoolean());
            }
        }
    }

    public boolean isAlive(int h, int w){
        return GOLGrid[h][w].isAlive();
    }

    protected void setAlive(int h, int w, boolean b){
        GOLGrid[h][w].setAlive(b);
    }

    private GOLCell[] getNeighbors(int col, int row){
        GOLCell[] nArr = new GOLCell[8];

        boolean isTop = (col == 0);
        boolean isBottom = (col == (HEIGHT-1));
        boolean isLeft = (row == 0);
        boolean isRight = (row == (WIDTH-1));

        nArr[0] = (isTop || isLeft) ? null : GOLGrid[col-1][row-1];
        nArr[1] = (isTop) ? null : GOLGrid[col-1][row];
        nArr[2] = (isTop || isRight) ? null : GOLGrid[col-1][row+1];
        nArr[3] = (isLeft) ? null : GOLGrid[col][row-1];
        nArr[4] = (isRight) ? null : GOLGrid[col][row+1];
        nArr[5] = (isBottom || isLeft) ? null : GOLGrid[col+1][row-1];
        nArr[6] = (isBottom) ? null : GOLGrid[col+1][row];
        nArr[7] = (isBottom || isRight) ? null : GOLGrid[col+1][row+1];

        return nArr;
    }

    public CGOLBoard updateGrid(){
        CGOLBoard nextFrame = new CGOLBoard(WIDTH, HEIGHT);

        for (int hi = 0; hi < HEIGHT; hi++){
            for (int wi = 0; wi < WIDTH; wi++){
                GOLCell cell = GOLGrid[hi][wi];
                int aliveNeighbors = cell.getAliveNeighbors();
                if(cell.isAlive()){
                    nextFrame.setAlive(hi, wi, aliveNeighbors == 2 || aliveNeighbors == 3);
                } else {
                    nextFrame.setAlive(hi, wi, aliveNeighbors == 3);
                }
            }
        }
        return nextFrame;
    }
}
