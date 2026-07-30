package in.jfr.jfranalyzer.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MemoryStressService {
    public void generateMemoryPressure(int iterations) {

        List<byte[]> memory = new ArrayList<>();

        Random random = new Random();

        for (int i = 1; i <= iterations; i++) {

            // Allocate 5 MB
            byte[] data = new byte[5 * 1024 * 1024];

            random.nextBytes(data);

            memory.add(data);

            System.out.println("Allocated : " + (i * 5) + " MB");

            if (memory.size() > 20) {

                // Release old objects
                memory.clear();

                System.gc();

                System.out.println("Garbage Collection Triggered");

            }

        }

    }
}
