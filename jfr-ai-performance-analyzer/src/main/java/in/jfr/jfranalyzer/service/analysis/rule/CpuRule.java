package in.jfr.jfranalyzer.service.analysis.rule;

import in.jfr.jfranalyzer.model.AnalysisResult;
import in.jfr.jfranalyzer.model.PerformanceSummary;
import in.jfr.jfranalyzer.model.Recommendation;

public class CpuRule implements AnalysisRule{
    @Override
    public void evaluate(
            PerformanceSummary summary,
            AnalysisResult result) {

        if (summary.getCpu().getAverageJvmCpuLoad() > 0.90) {

            result.setPerformanceScore(
                    result.getPerformanceScore() - 20);

            result.getRecommendations().add(

                    new Recommendation(

                            "CPU",

                            "HIGH",

                            "CPU utilization exceeds 90%."

                    )

            );

        }

    }
}
