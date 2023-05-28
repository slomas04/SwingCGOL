public class CGOLMain {
    public static void main(String[] args) throws InterruptedException {
        int w, h;
        if(args.length != 2){
            w = 640;
            h = 480;
        } else {
            w = Integer.parseInt(args[0]);
            h = Integer.parseInt(args[1]);
        }
        CGOLController game = new CGOLController(w,h);
        while(true){
            Thread.sleep(66);
            game.updateGrid();
        }
    }
}