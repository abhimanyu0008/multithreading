class mythread extends Thread
{
    private int n;
    public mythread(int n)
    {
        this.n=n;
    }
    public void run()
    {
        for(int i=1;i<=5;i++)
        {
            System.out.println(i*n);
        }
    }
}
public class Table {
    public static void main(String args[])
    {
        mythread th=new mythread(5);
        th.start();
        mythread th2=new mythread(6);
        th2.start();
    }

}
