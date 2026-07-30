package in.jfr.jfranalyzer.model;

import java.util.ArrayList;
import java.util.List;

public class CpuSummary {
    private long executionSamples;

    private List<String> hotMethods = new ArrayList<>();

    private double averageJvmCpuLoad;

    private double averageMachineCpuLoad;

    public List<String> getHotMethods() {
        return hotMethods;
    }

    public void setHotMethods(List<String> hotMethods) {
        this.hotMethods = hotMethods;
    }

    public long getExecutionSamples() {
        return executionSamples;
    }

    public void setExecutionSamples(long executionSamples) {
        this.executionSamples = executionSamples;
    }

    public double getAverageJvmCpuLoad() {
        return averageJvmCpuLoad;
    }

    public void setAverageJvmCpuLoad(double averageJvmCpuLoad) {
        this.averageJvmCpuLoad = averageJvmCpuLoad;
    }

    public double getAverageMachineCpuLoad() {
        return averageMachineCpuLoad;
    }

    public void setAverageMachineCpuLoad(double averageMachineCpuLoad) {
        this.averageMachineCpuLoad = averageMachineCpuLoad;
    }
}
