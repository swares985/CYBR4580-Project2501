import java.lang.*;

public class Main {

    public static void main(String[] args) {
        for(int i=0; i<1; ) {
            Main m = new Main();
            m.run();
        }
    }

    public void run() {
        try {
            CCL l = new CCL();

            Class c = null;

            c = l.findClass("CCL");

            c.newInstance();

            c=null;
            l=null;
        } catch(Exception ignored) {}
    }
}