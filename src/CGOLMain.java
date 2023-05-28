public class CGOLMain {
    public static void main(String[] args) throws InterruptedException {
        int w, h, s;
        if(args.length != 3){
            w = 640;
            h = 480;
            s = 2;
        } else {
            w = Integer.parseInt(args[0]);
            h = Integer.parseInt(args[1]);
            s = Integer.parseInt(args[2]);
            System.out.println(String.format("Launch Parameters detected: %d, %d ,%d", w,h,s));
        }
        CGOLController game = new CGOLController(w,h,s);
        while(true){
            Thread.sleep(66);
            game.updateGrid();
        }
    }
}