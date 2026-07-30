package in.jfr.jfranalyzer.model;

public class AllocationInfo {

    private String className;

    private long allocations;

    public AllocationInfo() {
    }

    public AllocationInfo(
            String className,
            long allocations) {

        this.className = className;
        this.allocations = allocations;

    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public long getAllocations() {
        return allocations;
    }

    public void setAllocations(long allocations) {
        this.allocations = allocations;
    }

}
