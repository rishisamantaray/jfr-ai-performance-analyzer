package in.jfr.jfranalyzer.service.analysis.report;

import in.jfr.jfranalyzer.model.AnalysisResult;
import in.jfr.jfranalyzer.model.Recommendation;
import in.jfr.jfranalyzer.model.ReportData;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReportMapper {
    public ReportData map(AnalysisResult result, String recordingFile) {

        ReportData report = new ReportData();

        report.setApplicationName("JFR AI Performance Analyzer");
        report.setRecordingFile(recordingFile);
        report.setGeneratedAt(LocalDateTime.now());

        report.setPerformanceScore(result.getPerformanceScore());
        report.setHealthStatus(result.getHealthStatus());

        report.setAverageCpuLoad(
                result.getSummary().getCpu().getAverageJvmCpuLoad());

        report.setExecutionSamples(
                result.getSummary().getCpu().getExecutionSamples());

        report.setGcEvents(
                result.getSummary().getMemory().getGcEvents());

        report.setAllocationEvents(
                result.getSummary().getMemory().getAllocationEvents());

        report.setMonitorContentionEvents(
                result.getSummary().getThreads().getMonitorEnterEvents());

        report.setParkedThreadEvents(
                result.getSummary().getThreads().getParkedEvents());

        report.setFileReadEvents(
                result.getSummary().getIo().getFileReadEvents());

        report.setFileWriteEvents(
                result.getSummary().getIo().getFileWriteEvents());

        for (Recommendation recommendation : result.getRecommendations()) {

            report.getRecommendations().add(
                    recommendation.getCategory()
                            + " : "
                            + recommendation.getMessage());

        }

        return report;

    }
}
