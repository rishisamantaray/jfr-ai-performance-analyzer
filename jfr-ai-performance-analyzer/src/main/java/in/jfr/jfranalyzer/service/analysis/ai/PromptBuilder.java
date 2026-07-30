package in.jfr.jfranalyzer.service.analysis.ai;

import in.jfr.jfranalyzer.model.AnalysisResult;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class PromptBuilder {

    private final ObjectMapper mapper = new ObjectMapper();

    public String build(AnalysisResult result) throws Exception {

        String json =
                mapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(result);

        return """
You are a Senior JVM Performance Engineer.

Analyze the following JVM analysis.

Provide:

1. Executive Summary

2. CPU Analysis

3. Memory Analysis

4. Thread Analysis

5. File IO Analysis

6. Optimization Suggestions

Keep the explanation professional.

JVM Analysis:

%s
""".formatted(json);

    }

}
