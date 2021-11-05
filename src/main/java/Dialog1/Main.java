package Dialog1;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ThreadGroup mainGroup = new ThreadGroup("mg");


        new MyThread(mainGroup, "T1").start();
        new MyThread(mainGroup, "T2").start();
        new MyThread(mainGroup, "T3").start();
        new MyThread(mainGroup, "T4").start();

        Thread.sleep(5000);

        mainGroup.interrupt();
    }
}

