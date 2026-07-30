package in.jfr.jfranalyzer.model;

import java.util.ArrayList;
import java.util.List;

public class AnalysisResult {
    private PerformanceSummary summary;

    private int performanceScore;

    private String healthStatus;

    private List<Recommendation> recommendations = new ArrayList<>();

    public PerformanceSummary getSummary() {
        return summary;
    }

    public void setSummary(PerformanceSummary summary) {
        this.summary = summary;
    }

    public int getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(int performanceScore) {
        this.performanceScore = performanceScore;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }
}
