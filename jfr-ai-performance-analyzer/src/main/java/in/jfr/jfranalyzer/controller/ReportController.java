package in.jfr.jfranalyzer.controller;

import in.jfr.jfranalyzer.model.AnalysisResult;
import in.jfr.jfranalyzer.model.ReportData;
import in.jfr.jfranalyzer.service.analysis.JfrAnalysisService;
import in.jfr.jfranalyzer.service.analysis.ai.OllamaResponse;
import in.jfr.jfranalyzer.service.analysis.ai.OllamaService;
import in.jfr.jfranalyzer.service.analysis.report.PdfReportGeneratorService;
import in.jfr.jfranalyzer.service.analysis.report.ReportMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    private final JfrAnalysisService analysisService;

    private final ReportMapper mapper;

    private final PdfReportGeneratorService pdfService;

    private final OllamaService  ollamaService;

    public ReportController(
            JfrAnalysisService analysisService,
            ReportMapper mapper,
            PdfReportGeneratorService pdfService,
            OllamaService  ollamaService) {

        this.analysisService = analysisService;
        this.mapper = mapper;
        this.pdfService = pdfService;
        this.ollamaService = ollamaService;
    }

    @GetMapping("/report")
    public String generateReport(
            @RequestParam String file)
            throws Exception {

        AnalysisResult result =
                analysisService.analyze(file);

        ReportData report =
                mapper.map(result, file);

        return pdfService.generateReport(report);

    }

    @GetMapping("/ai-report")
    public String aiReport(
            @RequestParam String file)
            throws Exception {

        AnalysisResult result =
                analysisService.analyze(file);

        return ollamaService.analyze(result);

    }
}
