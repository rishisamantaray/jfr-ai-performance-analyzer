package in.jfr.jfranalyzer.model;

public class ThreadSummary {

    private long blockedEvents;

    private long parkedEvents;

    private long monitorEnterEvents;

    public long getBlockedEvents() {
        return blockedEvents;
    }

    public void setBlockedEvents(long blockedEvents) {
        this.blockedEvents = blockedEvents;
    }

    public long getParkedEvents() {
        return parkedEvents;
    }

    public void setParkedEvents(long parkedEvents) {
        this.parkedEvents = parkedEvents;
    }

    public long getMonitorEnterEvents() {
        return monitorEnterEvents;
    }

    public void setMonitorEnterEvents(long monitorEnterEvents) {
        this.monitorEnterEvents = monitorEnterEvents;
    }
}
