import java.io.*;
import java.lang.*;

public class CCL extends ClassLoader {

    public Class findClass(String name) throws ClassNotFoundException {
        try {
            byte[] b=loadClassData(name);
            return defineClass(name, b, 0, b.length);
        } catch(IOException e) {
            throw new ClassNotFoundException(e.getMessage());
        }

    }

    private byte[] loadClassData(String name) throws IOException{
        FileInputStream f=new FileInputStream("CrashClass.class");
        int size=(int) f.getChannel().size();
        DataInputStream s=new DataInputStream(f);

        byte[] b=new byte[size];
        s.readFully(b);
        s.close();

        return b;
    }

}