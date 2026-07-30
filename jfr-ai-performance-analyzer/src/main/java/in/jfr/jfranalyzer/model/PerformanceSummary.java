package in.jfr.jfranalyzer.model;

import java.util.ArrayList;
import java.util.List;

public class PerformanceSummary {
    private CpuSummary cpu = new CpuSummary();

    private MemorySummary memory = new MemorySummary();

    private ThreadSummary threads = new ThreadSummary();

    private IOSummary io = new IOSummary();

    private List<Recommendation> recommendations = new ArrayList<>();

    private int performanceScore;
    

    public CpuSummary getCpu() {
        return cpu;
    }

    public void setCpu(CpuSummary cpu) {
        this.cpu = cpu;
    }

    public MemorySummary getMemory() {
        return memory;
    }

    public void setMemory(MemorySummary memory) {
        this.memory = memory;
    }

    public ThreadSummary getThreads() {
        return threads;
    }

    public void setThreads(ThreadSummary threads) {
        this.threads = threads;
    }

    public IOSummary getIo() {
        return io;
    }

    public void setIo(IOSummary io) {
        this.io = io;
    }

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

    public int getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(int performanceScore) {
        this.performanceScore = performanceScore;
    }
}
