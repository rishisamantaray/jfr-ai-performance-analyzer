package in.jfr.jfranalyzer.service.analysis.rule;

import in.jfr.jfranalyzer.model.AnalysisResult;
import in.jfr.jfranalyzer.model.PerformanceSummary;
import in.jfr.jfranalyzer.model.Recommendation;
import org.springframework.stereotype.Component;

@Component
public class ThreadRule implements AnalysisRule {

    @Override
    public void evaluate(
            PerformanceSummary summary,
            AnalysisResult result) {

        if(summary.getThreads().getMonitorEnterEvents() > 10){

            result.setPerformanceScore(

                    result.getPerformanceScore()-20

            );

            result.getRecommendations().add(

                    new Recommendation(

                            "THREAD",

                            "HIGH",

                            "High lock contention detected."

                    )

            );

        }

    }

}
