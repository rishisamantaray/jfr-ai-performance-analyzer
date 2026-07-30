package in.jfr.jfranalyzer.service;

import org.springframework.stereotype.Service;

@Service
public class CpuStressService {
    public void generateCpuLoad(int durationSeconds) {

        long endTime = System.currentTimeMillis() + durationSeconds * 1000L;

        long primeCount = 0;

        while (System.currentTimeMillis() < endTime) {

            for (long number = 2; number < 100000; number++) {

                if (isPrime(number)) {
                    primeCount++;
                }

            }

        }

        System.out.println("Prime numbers found : " + primeCount);

    }

    private boolean isPrime(long number) {

        if (number <= 1)
            return false;

        for (long i = 2; i <= Math.sqrt(number); i++) {

            if (number % i == 0)
                return false;

        }

        return true;

    }
}
