package in.jfr.jfranalyzer.model;

import java.util.ArrayList;
import java.util.List;

public class MemorySummary {
    private long allocationEvents;

    private long gcEvents;

    private long totalAllocatedBytes;

    private long maxHeapUsedBytes;
    

    public long getAllocationEvents() {
        return allocationEvents;
    }

    public void setAllocationEvents(long allocationEvents) {
        this.allocationEvents = allocationEvents;
    }

    public long getGcEvents() {
        return gcEvents;
    }

    public void setGcEvents(long gcEvents) {
        this.gcEvents = gcEvents;
    }

    public long getTotalAllocatedBytes() {
        return totalAllocatedBytes;
    }

    public void setTotalAllocatedBytes(long totalAllocatedBytes) {
        this.totalAllocatedBytes = totalAllocatedBytes;
    }

    public long getMaxHeapUsedBytes() {
        return maxHeapUsedBytes;
    }

    public void setMaxHeapUsedBytes(long maxHeapUsedBytes) {
        this.maxHeapUsedBytes = maxHeapUsedBytes;
    }
}
