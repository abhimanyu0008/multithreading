package practices.thread;

public class ThreadOperation {
    public static void main(String[] args) {
        System.out.println("My Thread");
        int x=3+4;
        System.out.println("value of x is "+x);
        Thread t=Thread.currentThread();
        String tname=t.getName();
        t.setName("MyMain");
        System.out.println(t.getName());
        System.out.println("Current running thread is "+tname);
        System.out.println(t.getId()+" Thread id");
    }
}
