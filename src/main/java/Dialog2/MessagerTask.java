package Dialog2;

import java.util.concurrent.Callable;

public class MessagerTask implements Callable<Integer> {
    final int ITERATIONS = 10;
    public Integer messageNumber;
    public String name;
    private int time;

    public MessagerTask(String name, int time) {
        this.name = name;
        this.time = time;
    }


    @Override
    public Integer call() throws Exception {
        System.out.printf("Task# %s starts\n", name);
        for (int i = 0; i < ITERATIONS; i++) {
            messageNumber = i;
            Thread.sleep(time);
        }
        System.out.printf("Tread# %s prints messageNumber# %d\n", name, messageNumber);
        return messageNumber;
    }
}
