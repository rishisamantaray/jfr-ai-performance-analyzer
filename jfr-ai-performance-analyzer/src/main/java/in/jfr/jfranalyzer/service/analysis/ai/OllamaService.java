package in.jfr.jfranalyzer.service.analysis.ai;

import in.jfr.jfranalyzer.model.AnalysisResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class OllamaService {

    private final RestClient restClient =
            RestClient.builder()
                    .baseUrl("http://localhost:11434")
                    .build();

    private final PromptBuilder promptBuilder;

    public OllamaService(PromptBuilder promptBuilder) {
        this.promptBuilder = promptBuilder;
    }

    public String analyze(
            AnalysisResult result) throws Exception {

        OllamaRequest request =
                new OllamaRequest();

        request.setModel("llama3.1:8b");

        request.setPrompt(
                promptBuilder.build(result));

        request.setStream(false);

        OllamaResponse response =
                restClient.post()
                        .uri("/api/generate")
                        .body(request)
                        .retrieve()
                        .body(OllamaResponse.class);

        return response.getResponse();

    }

}