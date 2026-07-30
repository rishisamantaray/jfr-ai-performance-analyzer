package in.jfr.jfranalyzer.model;

public class IOSummary {
    private long fileReadEvents;

    private long fileWriteEvents;

    private long socketReadEvents;

    private long socketWriteEvents;

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

    public long getSocketReadEvents() {
        return socketReadEvents;
    }

    public void setSocketReadEvents(long socketReadEvents) {
        this.socketReadEvents = socketReadEvents;
    }

    public long getSocketWriteEvents() {
        return socketWriteEvents;
    }

    public void setSocketWriteEvents(long socketWriteEvents) {
        this.socketWriteEvents = socketWriteEvents;
    }
}
