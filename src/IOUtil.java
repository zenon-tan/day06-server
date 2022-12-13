import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class IOUtil {

    public static void write(Socket socket, String payload) throws Exception{

        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

        System.out.printf(">>> %s\n", payload);
        dos.writeUTF(payload);
        dos.flush();


        
    }

    public static String read(Socket socket) throws Exception{

        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        String payload = dis.readUTF();
        System.out.printf("<<< %s\n", payload);

        return payload;


    }


    
}
