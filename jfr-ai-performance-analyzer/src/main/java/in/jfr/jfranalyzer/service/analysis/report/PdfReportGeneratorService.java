package in.jfr.jfranalyzer.service.analysis.report;

import in.jfr.jfranalyzer.model.ReportData;
import org.openpdf.text.*;
import org.openpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class PdfReportGeneratorService {
    public String generateReport(ReportData report)
            throws IOException, DocumentException {

        String fileName = "reports/PerformanceReport.pdf";

        Document document = new Document();

        PdfWriter.getInstance(document,
                new FileOutputStream(fileName));

        document.open();

        Font title =
                FontFactory.getFont(
                        FontFactory.HELVETICA_BOLD,
                        22);

        Font heading =
                FontFactory.getFont(
                        FontFactory.HELVETICA_BOLD,
                        16);

        Font normal =
                FontFactory.getFont(
                        FontFactory.HELVETICA,
                        12);

        document.add(new Paragraph(
                "JFR PERFORMANCE REPORT",
                title));

        document.add(new Paragraph(" "));

        document.add(new Paragraph(
                "Application : "
                        + report.getApplicationName(),
                normal));

        document.add(new Paragraph(
                "Recording : "
                        + report.getRecordingFile(),
                normal));

        document.add(new Paragraph(
                "Generated : "
                        + report.getGeneratedAt(),
                normal));

        document.add(new Paragraph(" "));

        document.add(new Paragraph(
                "OVERALL HEALTH",
                heading));

        document.add(new Paragraph(
                "Performance Score : "
                        + report.getPerformanceScore(),
                normal));

        document.add(new Paragraph(
                "Health Status : "
                        + report.getHealthStatus(),
                normal));

        document.add(new Paragraph(" "));

        document.add(new Paragraph(
                "CPU",
                heading));

        document.add(new Paragraph(
                "Average JVM CPU : "
                        + report.getAverageCpuLoad(),
                normal));

        document.add(new Paragraph(
                "Execution Samples : "
                        + report.getExecutionSamples(),
                normal));

        document.add(new Paragraph(" "));

        document.add(new Paragraph(
                "MEMORY",
                heading));

        document.add(new Paragraph(
                "GC Events : "
                        + report.getGcEvents(),
                normal));

        document.add(new Paragraph(
                "Allocation Events : "
                        + report.getAllocationEvents(),
                normal));

        document.add(new Paragraph(" "));

        document.add(new Paragraph(
                "THREADS",
                heading));

        document.add(new Paragraph(
                "Monitor Contention : "
                        + report.getMonitorContentionEvents(),
                normal));

        document.add(new Paragraph(
                "Thread Park Events : "
                        + report.getParkedThreadEvents(),
                normal));

        document.add(new Paragraph(" "));

        document.add(new Paragraph(
                "FILE IO",
                heading));

        document.add(new Paragraph(
                "File Reads : "
                        + report.getFileReadEvents(),
                normal));

        document.add(new Paragraph(
                "File Writes : "
                        + report.getFileWriteEvents(),
                normal));

        document.add(new Paragraph(" "));

        document.add(new Paragraph(
                "RECOMMENDATIONS",
                heading));

        if (report.getRecommendations().isEmpty()) {

            document.add(new Paragraph(
                    "No recommendations.",
                    normal));

        } else {

            for (String recommendation :
                    report.getRecommendations()) {

                document.add(new Paragraph(
                        "- " + recommendation,
                        normal));

            }

        }

        document.close();

        return fileName;

    }
}
