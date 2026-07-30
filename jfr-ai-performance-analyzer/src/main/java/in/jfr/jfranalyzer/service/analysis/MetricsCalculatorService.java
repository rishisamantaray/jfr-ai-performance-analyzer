package in.jfr.jfranalyzer.service.analysis;

import in.jfr.jfranalyzer.model.AnalysisResult;
import in.jfr.jfranalyzer.model.PerformanceSummary;
import in.jfr.jfranalyzer.model.Recommendation;
import in.jfr.jfranalyzer.service.analysis.rule.AnalysisRule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricsCalculatorService {
    private final List<AnalysisRule> rules;

    public MetricsCalculatorService(
            List<AnalysisRule> rules){

        this.rules = rules;

    }

    public AnalysisResult calculate(
            PerformanceSummary summary){

        AnalysisResult result =
                new AnalysisResult();

        result.setSummary(summary);

        result.setPerformanceScore(100);

        for(AnalysisRule rule : rules){

            rule.evaluate(summary,result);

        }

        if(result.getPerformanceScore()<0){

            result.setPerformanceScore(0);

        }

        determineHealth(result);

        return result;

    }

    private void determineHealth(
            AnalysisResult result){

        int score =
                result.getPerformanceScore();

        if(score>=90){

            result.setHealthStatus("EXCELLENT");

        }else if(score>=75){

            result.setHealthStatus("GOOD");

        }else if(score>=50){

            result.setHealthStatus("WARNING");

        }else{

            result.setHealthStatus("CRITICAL");

        }

    }

}
