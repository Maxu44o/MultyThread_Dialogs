package Dialog2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //final int THREADNUMBER = 4;
        final int THREADNUMBER = Runtime.getRuntime().availableProcessors();

        final ExecutorService threadPool = Executors.newFixedThreadPool(THREADNUMBER);

        List<Callable<Integer>> callables = new ArrayList<>();


        callables.add(new MessagerTask("T0", 498));
        callables.add(new MessagerTask("T1", 500));
        callables.add(new MessagerTask("T2", 501));
        callables.add(new MessagerTask("T3", 502));
        callables.add(new MessagerTask("T4", 530));
        callables.add(new MessagerTask("T5", 500));
        callables.add(new MessagerTask("T6", 500));
        callables.add(new MessagerTask("T7", 490));
        callables.add(new MessagerTask("T8", 490));
        callables.add(new MessagerTask("T9", 550));
        callables.add(new MessagerTask("T10", 560));
        callables.add(new MessagerTask("T11", 570));
        callables.add(new MessagerTask("T12", 550));
        callables.add(new MessagerTask("T13", 1));


        Integer r1 = threadPool.invokeAny(callables);
        System.out.println("Количество вызовов при .invokeAny=" + r1+"\n");


        List<Future<Integer>> futures = threadPool.invokeAll(callables);
        int r2 = 0;
        for (Future<Integer> f : futures) {
            r2 += f.get();
        }
        System.out.println("Количество вызовов при .invokeAll=" + r2);

        threadPool.shutdown();
    }
}

