package rafpio.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.os.Environment;

public class IOHelper {

    public static void copyFile(String inName, String outName) {
        try{
            InputStream in = new FileInputStream(inName);

            //For Overwrite the file.
            OutputStream out = new FileOutputStream(outName);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0){
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            System.out.println("File copied.");
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage() + " in the specified directory.");
            System.exit(0);
        }
        catch(IOException e){
            System.out.println(e.getMessage());      
        }
    }

    public static void copyFile(InputStream is, String fileName) {
        if (!Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())) {
            throw new IllegalStateException("Media not accesible");
        }

        byte[] buf = new byte[512];
        int size = 0;
        int totalSize = 0;

        try {
            FileOutputStream fos = new FileOutputStream(
                    fileName);
            while ((size = is.read(buf)) > 0) {
                totalSize += size;
                fos.write(buf, 0, size);
            }
            is.close();
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(totalSize + " byte(s) copied");
    }
}
