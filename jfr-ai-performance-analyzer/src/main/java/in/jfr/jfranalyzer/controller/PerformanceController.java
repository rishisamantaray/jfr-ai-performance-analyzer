package in.jfr.jfranalyzer.controller;

import in.jfr.jfranalyzer.dto.ApiResponse;
import in.jfr.jfranalyzer.service.CpuStressService;
import in.jfr.jfranalyzer.service.IOStressService;
import in.jfr.jfranalyzer.service.MemoryStressService;
import in.jfr.jfranalyzer.service.ThreadContentionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerformanceController {

    private final CpuStressService cpuStressService;
    private final MemoryStressService memoryStressService;
    private final ThreadContentionService threadContentionService;
    private final IOStressService ioStressService;

    public PerformanceController(CpuStressService cpuStressService,
                                 MemoryStressService memoryStressService
    ,ThreadContentionService threadContentionService,
                                 IOStressService ioStressService) {
        this.cpuStressService = cpuStressService;
        this.memoryStressService = memoryStressService;
        this.threadContentionService = threadContentionService;
        this.ioStressService = ioStressService;
    }

    @GetMapping("/cpu")
    public ApiResponse cpuLoad() {

        cpuStressService.generateCpuLoad(20);

        return new ApiResponse("CPU stress completed");

    }

    @GetMapping("/memory")
    public ApiResponse memoryLoad() {

        memoryStressService.generateMemoryPressure(60);

        return new ApiResponse("Memory stress completed");
    }

    @GetMapping("/threads")
    public ApiResponse threadContention() {

        threadContentionService.generateThreadContention();

        return new ApiResponse("Thread contention simulation started");

    }

    @GetMapping("/io")
    public ApiResponse ioTest() throws Exception {

        String result = ioStressService.performIOTest();

        return new ApiResponse(result);

    }
}
