package in.jfr.jfranalyzer.model;

public class HotMethod {

    private String className;

    private String methodName;

    private long samples;

    public HotMethod() {
    }

    public HotMethod(String className,
                     String methodName,
                     long samples) {

        this.className = className;
        this.methodName = methodName;
        this.samples = samples;

    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public long getSamples() {
        return samples;
    }

    public void setSamples(long samples) {
        this.samples = samples;
    }

}
