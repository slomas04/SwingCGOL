public class CGOLMain {
    public static void main(String[] args) throws InterruptedException {
        CGOLController game = new CGOLController(640,480);
        while(true){
            Thread.sleep(66);
            game.updateGrid();
        }
    }
}