package in.jfr.jfranalyzer.service.analysis.rule;

import in.jfr.jfranalyzer.model.AnalysisResult;
import in.jfr.jfranalyzer.model.PerformanceSummary;
import in.jfr.jfranalyzer.model.Recommendation;
import org.springframework.stereotype.Component;

@Component
public class IORule implements AnalysisRule {

    @Override
    public void evaluate(
            PerformanceSummary summary,
            AnalysisResult result) {

        if(summary.getIo().getFileReadEvents() > 100){

            result.setPerformanceScore(

                    result.getPerformanceScore()-10

            );

            result.getRecommendations().add(

                    new Recommendation(

                            "IO",

                            "LOW",

                            "Heavy file read activity."

                    )

            );

        }

    }

}
