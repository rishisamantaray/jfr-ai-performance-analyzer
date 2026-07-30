package in.jfr.jfranalyzer.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReportData {

    private String applicationName;

    private String recordingFile;

    private LocalDateTime generatedAt;

    private int performanceScore;

    private String healthStatus;

    private double averageCpuLoad;

    private long executionSamples;

    private long gcEvents;

    private long allocationEvents;

    private long monitorContentionEvents;

    private long parkedThreadEvents;

    private long fileReadEvents;

    private long fileWriteEvents;

    private List<String> recommendations = new ArrayList<>();

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getRecordingFile() {
        return recordingFile;
    }

    public void setRecordingFile(String recordingFile) {
        this.recordingFile = recordingFile;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
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

    public double getAverageCpuLoad() {
        return averageCpuLoad;
    }

    public void setAverageCpuLoad(double averageCpuLoad) {
        this.averageCpuLoad = averageCpuLoad;
    }

    public long getExecutionSamples() {
        return executionSamples;
    }

    public void setExecutionSamples(long executionSamples) {
        this.executionSamples = executionSamples;
    }

    public long getGcEvents() {
        return gcEvents;
    }

    public void setGcEvents(long gcEvents) {
        this.gcEvents = gcEvents;
    }

    public long getAllocationEvents() {
        return allocationEvents;
    }

    public void setAllocationEvents(long allocationEvents) {
        this.allocationEvents = allocationEvents;
    }

    public long getMonitorContentionEvents() {
        return monitorContentionEvents;
    }

    public void setMonitorContentionEvents(long monitorContentionEvents) {
        this.monitorContentionEvents = monitorContentionEvents;
    }

    public long getParkedThreadEvents() {
        return parkedThreadEvents;
    }

    public void setParkedThreadEvents(long parkedThreadEvents) {
        this.parkedThreadEvents = parkedThreadEvents;
    }

    public long getFileReadEvents() {
        return fileReadEvents;
    }

    public void setFileReadEvents(long fileReadEvents) {
        this.fileReadEvents = fileReadEvents;
    }

    public long getFileWriteEvents() {
        return fileWriteEvents;
    }

    public void setFileWriteEvents(long fileWriteEvents) {
        this.fileWriteEvents = fileWriteEvents;
    }

    public List<String> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<String> recommendations) {
        this.recommendations = recommendations;
    }
}
