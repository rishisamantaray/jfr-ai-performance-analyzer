package in.jfr.jfranalyzer.service;

import org.springframework.stereotype.Service;

@Service
public class ThreadContentionService {

    private final Object sharedLock = new Object();

    public void generateThreadContention() {

        Runnable task = () -> {

            String threadName = Thread.currentThread().getName();

            synchronized (sharedLock) {

                System.out.println(threadName + " acquired lock");

                try {

                    Thread.sleep(2000);

                } catch (InterruptedException e) {

                    Thread.currentThread().interrupt();

                }

                System.out.println(threadName + " released lock");

            }

        };

        for (int i = 1; i <= 8; i++) {

            Thread worker = new Thread(task);

            worker.setName("Worker-" + i);

            worker.start();

        }

    }
}
