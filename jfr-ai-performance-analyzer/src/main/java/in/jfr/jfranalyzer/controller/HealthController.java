package in.jfr.jfranalyzer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class HealthController {
    @GetMapping("/")
    public Map<String, Object> home() {

        return Map.of(
                "application", "JFR AI Performance Analyzer",
                "status", "Running",
                "time", LocalDateTime.now()
        );
    }
}
