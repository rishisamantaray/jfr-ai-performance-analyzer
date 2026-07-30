package in.jfr.jfranalyzer.service.analysis;

import in.jfr.jfranalyzer.model.PerformanceSummary;
import jdk.jfr.consumer.RecordedEvent;
import org.springframework.stereotype.Service;

@Service
public class EventExtractorService {

    public void processEvent(
            RecordedEvent event,
            PerformanceSummary summary) {

        String eventName =
                event.getEventType().getName();

        switch (eventName) {

            case "jdk.ExecutionSample":
                processExecutionSample(summary);
                break;

            case "jdk.CPULoad":
                processCpuLoad(event, summary);
                break;

            case "jdk.ObjectAllocationSample":
                processAllocation(summary);
                break;

            case "jdk.GarbageCollection":
                processGarbageCollection(summary);
                break;

            case "jdk.ThreadPark":
                processThreadPark(summary);
                break;

            case "jdk.JavaMonitorEnter":
                processMonitorEnter(summary);
                break;

            case "jdk.FileRead":
                processFileRead(summary);
                break;

            case "jdk.FileWrite":
                processFileWrite(summary);
                break;

            default:
                break;
        }

    }

    private void processExecutionSample(
            PerformanceSummary summary) {

        summary.getCpu().setExecutionSamples(
                summary.getCpu().getExecutionSamples() + 1);

    }

    private void processCpuLoad(
            RecordedEvent event,
            PerformanceSummary summary) {

        try {

            double jvmLoad =
                    event.getDouble("jvmUser");

            summary.getCpu()
                    .setAverageJvmCpuLoad(jvmLoad);

        } catch (Exception ignored) {

        }

    }

    private void processAllocation(
            PerformanceSummary summary) {

        summary.getMemory()
                .setAllocationEvents(

                        summary.getMemory()
                                .getAllocationEvents() + 1);

    }

    private void processGarbageCollection(
            PerformanceSummary summary) {

        summary.getMemory()
                .setGcEvents(

                        summary.getMemory()
                                .getGcEvents() + 1);

    }

    private void processThreadPark(
            PerformanceSummary summary) {

        summary.getThreads()
                .setParkedEvents(

                        summary.getThreads()
                                .getParkedEvents() + 1);

    }

    private void processMonitorEnter(
            PerformanceSummary summary) {

        summary.getThreads()
                .setMonitorEnterEvents(

                        summary.getThreads()
                                .getMonitorEnterEvents() + 1);

    }

    private void processFileRead(
            PerformanceSummary summary) {

        summary.getIo()
                .setFileReadEvents(

                        summary.getIo()
                                .getFileReadEvents() + 1);

    }

    private void processFileWrite(
            PerformanceSummary summary) {

        summary.getIo()
                .setFileWriteEvents(

                        summary.getIo()
                                .getFileWriteEvents() + 1);

    }

}
