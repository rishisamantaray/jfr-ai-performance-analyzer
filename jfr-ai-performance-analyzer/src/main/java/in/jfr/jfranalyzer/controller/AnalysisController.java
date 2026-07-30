package in.jfr.jfranalyzer.controller;

import in.jfr.jfranalyzer.model.AnalysisResult;
import in.jfr.jfranalyzer.model.PerformanceSummary;
import in.jfr.jfranalyzer.service.analysis.JfrAnalysisService;
import jdk.jfr.consumer.RecordedEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnalysisController {
    private final JfrAnalysisService analysisService;

    public AnalysisController(JfrAnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @GetMapping("/analyze")
    public AnalysisResult analyze(
            @RequestParam String file)
            throws IOException {

        return analysisService.analyze(file);

    }
}
