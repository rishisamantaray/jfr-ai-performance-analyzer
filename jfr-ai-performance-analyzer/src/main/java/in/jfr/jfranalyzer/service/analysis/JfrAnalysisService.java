package in.jfr.jfranalyzer.service.analysis;

import in.jfr.jfranalyzer.model.AnalysisResult;
import in.jfr.jfranalyzer.model.PerformanceSummary;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JfrAnalysisService {
    private final EventExtractorService extractor;
    private final MetricsCalculatorService calculator;

    public JfrAnalysisService(
            EventExtractorService extractor,
            MetricsCalculatorService calculator) {

        this.extractor = extractor;
        this.calculator = calculator;
    }

    public AnalysisResult analyze(String file)
            throws IOException {

        PerformanceSummary summary =
                new PerformanceSummary();

        try (RecordingFile recording =
                     new RecordingFile(Path.of(file))) {

            while (recording.hasMoreEvents()) {

                RecordedEvent event =
                        recording.readEvent();

                extractor.processEvent(
                        event,
                        summary);

            }

        }

        return calculator.calculate(summary);

    }
}
