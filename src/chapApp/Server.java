package chapApp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.InflaterInputStream;

public class Server {
    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out;
    public Server(){
        try{
            server=new ServerSocket(7777);
            System.out.println("Server is ready to accept connection");
            System.out.println("waiting");
            socket=server.accept();

            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream());

            startReading();
            startWriting();

        }catch (Exception e){

        }
    }
    public void startReading(){
        //thread-read karke deta rhega
        Runnable r1=()->{
            System.out.println("reader started ");
            try {
            while (true){

                    String msg=br.readLine();
                    if(msg.equals("exit")){
                        System.out.println("client terminate the chat");
                        socket.close();
                        break;
                    }
                    System.out.println("client : "+msg);
                }
                }
            catch (IOException e) {
                //throw new RuntimeException(e);
                System.out.println("connection closed");
            }
        };
        new Thread(r1).start();

    }
    public void startWriting(){
        //thread - data user lega and the send karega client tak
        Runnable r2=()->{
            System.out.println("Writer started");
            try {
            while (true && !socket.isClosed()){


                    BufferedReader br1= new BufferedReader(new InputStreamReader(System.in));
                    String content = br1.readLine();
                    out.println(content);
                    out.flush();
                    if(content.equals("exit")){
                        socket.close();
                        break;
                    }
                }
                System.out.println("connection closed");
            }
            catch (IOException e) {
                //throw new RuntimeException(e);
                System.out.println("connection closed");
            }
        };
        new Thread(r2).start();
    }
    public static void main(String[] args) {
        System.out.println("Hello");
        new Server();
    }
}
