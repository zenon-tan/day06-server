
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListServer {

    public static void main(String[] args) throws Exception {

        ExecutorService threadpool = Executors.newFixedThreadPool(2);

        MultithreadHandler thr = new MultithreadHandler(args[0]);
        System.out.println(" Listening on Port: " + args[0]);

        threadpool.submit(thr);
   

    }


}