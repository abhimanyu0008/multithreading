package practices.thread;

public class MyThread_2 extends Thread {
    public void run(){
        for(int i=10;i>0;i--){
            System.out.println("value of thread is "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
       MyThread_2 th=new MyThread_2();
        th.start();
    }
}
