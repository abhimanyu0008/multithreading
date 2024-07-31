package practices.thread;

public class MyThread implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("value of i  "+i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello");
        MyThread th=new MyThread();
        Thread t1=new Thread(th);

        MyThread_2 thread2=new MyThread_2();
        thread2.start();
        t1.start();
    }
}
