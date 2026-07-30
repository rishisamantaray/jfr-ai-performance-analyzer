package in.jfr.jfranalyzer.service.analysis.report;

import in.jfr.jfranalyzer.model.AnalysisResult;

public interface ReportGenerator {
    String generate(AnalysisResult result);
}
