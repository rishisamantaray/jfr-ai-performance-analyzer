package in.jfr.jfranalyzer.model;

public class Recommendation {

    private String category;
    private String severity;
    private String message;

    public Recommendation() {
    }

    public Recommendation(String category, String severity, String message) {
        this.category = category;
        this.severity = severity;
        this.message = message;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
