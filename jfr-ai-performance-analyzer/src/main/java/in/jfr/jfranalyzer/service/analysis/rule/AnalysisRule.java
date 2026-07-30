package in.jfr.jfranalyzer.service.analysis.rule;

import in.jfr.jfranalyzer.model.AnalysisResult;
import in.jfr.jfranalyzer.model.PerformanceSummary;

public interface AnalysisRule {
    void evaluate(
            PerformanceSummary summary,
            AnalysisResult result);
}
