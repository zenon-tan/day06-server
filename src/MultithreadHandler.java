import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MultithreadHandler implements Runnable{

    private String soc;

    
    public MultithreadHandler(String soc) {
        this.soc = soc;
    }



    @Override
    public void run() {

        while(true) {

            try {
                ServerSocket server = new ServerSocket(Integer.parseInt(soc));
                Socket sc = server.accept();
    
                // Order in which the input and output streams is IMPORTANT
    
    
    
                System.out.printf("New connection from %d, Thread-%s\n",server.getLocalPort(),
                Thread.currentThread().getName());
       
                DataInputStream dis = new DataInputStream(new BufferedInputStream(sc.getInputStream()));
       
                String msg = dis.readUTF();
                System.out.printf("<<< %s\n", msg);
       
                String[] values = msg.split(" ");
       
       
                // Generate random list
       
                int n = Integer.parseInt(values[0]);
                int limit = Integer.parseInt(values[1]);
       
               Random rnd = new SecureRandom();
               List<Integer> randList = new LinkedList<>();
       
               for(int i = 0; i < n; i++) {
                   randList.add(rnd.nextInt(limit));
                   
               }
       
               String msgToClient = randList.toString();
       
       
                // Output Stream
       
               DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(sc.getOutputStream()));
       
                System.out.printf(">>> %s\n", msg);
                dos.writeUTF(msgToClient);
                dos.flush();
                System.out.printf("<<< %s\n", msg);
       
                sc.close();
                server.close();
                dis.close();
                dos.close();
                
             } catch (IOException e) {
                e.printStackTrace();
             }
    

        }

         

        
    }

    
}
