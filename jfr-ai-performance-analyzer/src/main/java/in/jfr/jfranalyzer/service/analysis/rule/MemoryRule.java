package in.jfr.jfranalyzer.service.analysis.rule;

import in.jfr.jfranalyzer.model.AnalysisResult;
import in.jfr.jfranalyzer.model.PerformanceSummary;
import in.jfr.jfranalyzer.model.Recommendation;
import org.springframework.stereotype.Component;

@Component
public class MemoryRule implements AnalysisRule {

    @Override
    public void evaluate(
            PerformanceSummary summary,
            AnalysisResult result) {

        if(summary.getMemory().getGcEvents() > 20){

            result.setPerformanceScore(
                    result.getPerformanceScore() - 15);

            result.getRecommendations().add(

                    new Recommendation(

                            "MEMORY",

                            "MEDIUM",

                            "Frequent GC detected."

                    )

            );

        }

    }

}