import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListClient {

    public static void main(String[] args) throws Exception {

        // Read args
        
        int rangeVal = Integer.parseInt(args[0]);
        int range = Integer.parseInt(args[1]);
        String host = args[2];
        int port = Integer.parseInt(args[3]);

        // Create socket

        Socket cs = new Socket(host, port);

        System.out.printf("Connected to %s:%d on %d\n", host, port, cs.getPort());

        // Output Stream

        String outMsg = "%d %d".formatted(rangeVal, range);

        IOUtil.write(cs, outMsg);


        // Input Stream

        String msg = IOUtil.read(cs);
        System.out.println(msg);

        // Calculate average

        msg = msg.replace("[", "").replace("]", "");
        System.out.println(msg);
        String[] values = msg.split(", ");

        float sum = 0;
        for(String i : values) {
            sum += Integer.parseInt(i);
        }

        float average = sum / values.length;

        System.out.printf("The average is %f\n",average);
        

        cs.close();





        


    }
    
}
