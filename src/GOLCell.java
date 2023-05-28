public class GOLCell {

    private Boolean alive;

    // Set private arr for storing neighbors
    // NW N NE W E SW S SE
    private GOLCell[] neighbors;

    public GOLCell(){
        alive = false;
        neighbors = new GOLCell[8];
    }

    public boolean isAlive(){
        return alive;
    }

    public void setAlive(boolean alive){
        this.alive = alive;
    }

    public GOLCell getNeighbor(int index){
        try{
            return neighbors[index];
        } catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException();
        }
    }

    public void setNeighbor(int index, GOLCell c){
        try{
            neighbors[index] = c;
        } catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException();
        }
    }

    public void setNeighbors(GOLCell[] arr){
        if (arr.length == 8){
            neighbors = arr;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getAliveNeighbors(){
        int count = 0;
        for (GOLCell c : neighbors){
            count += (c == null || !c.isAlive()) ? 0 : 1;
        }
        return count;
    }
}
