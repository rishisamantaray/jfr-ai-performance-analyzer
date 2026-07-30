package in.jfr.jfranalyzer.model;

import java.util.ArrayList;
import java.util.List;

public class ComponentAnalysis {
    private HealthStatus status;

    private int score;

    private List<String> findings = new ArrayList<>();

    public HealthStatus getStatus() {
        return status;
    }

    public void setStatus(HealthStatus status) {
        this.status = status;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getFindings() {
        return findings;
    }

    public void setFindings(List<String> findings) {
        this.findings = findings;
    }

    public void addFinding(String finding) {
        findings.add(finding);
    }
}
