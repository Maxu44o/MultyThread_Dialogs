package Dialog1;

public class MyThread extends Thread {
    public MyThread(){
    }

    public MyThread(ThreadGroup group, String name) {
    super(group, name);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(1000);
                System.out.println("Я поток " + this.getName() + ". Всем привет!");
            }
        } catch (InterruptedException e) {
        } finally {
            System.out.printf("%s завершен \n", getName());
        }

    }
}
