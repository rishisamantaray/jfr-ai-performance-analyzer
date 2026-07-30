package in.jfr.jfranalyzer.dto;

import java.time.LocalDateTime;

public class ApiResponse {
    private String message;
    private LocalDateTime timestamp;

    public ApiResponse() {
    }

    public ApiResponse(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
