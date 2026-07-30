package in.jfr.jfranalyzer.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

@Service
public class IOStressService {
    private static final String FILE_NAME = "data/sample.dat";

    public String performIOTest() throws Exception {

        Files.createDirectories(Path.of("data"));

        createLargeFile();

        long writeStart = System.currentTimeMillis();

        appendToFile();

        long writeEnd = System.currentTimeMillis();

        long readStart = System.currentTimeMillis();

        readFile();

        long readEnd = System.currentTimeMillis();

        return String.format(
                "Write Time = %d ms | Read Time = %d ms",
                (writeEnd - writeStart),
                (readEnd - readStart)
        );

    }

    private void createLargeFile() throws IOException {

        File file = new File(FILE_NAME);

        if (file.exists()) {
            return;
        }

        try (BufferedOutputStream bos =
                     new BufferedOutputStream(new FileOutputStream(file))) {

            byte[] buffer = new byte[1024 * 1024];

            Random random = new Random();

            for (int i = 0; i < 100; i++) {

                random.nextBytes(buffer);

                bos.write(buffer);

            }

        }

    }

    private void appendToFile() throws IOException {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            for (int i = 0; i < 10000; i++) {

                writer.write("JFR AI Performance Analyzer\n");

            }

        }

    }

    private void readFile() throws IOException {

        try (BufferedInputStream bis =
                     new BufferedInputStream(new FileInputStream(FILE_NAME))) {

            byte[] buffer = new byte[8192];

            while (bis.read(buffer) != -1) {

                // Reading file

            }

        }

    }
}
