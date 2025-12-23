@RestController
@RequestMapping("/logs")
public class TemperatureLogController {

    private final TemperatureLogService service;

    public TemperatureLogController(TemperatureLogService service) {
        this.service = service;
    }

    @PostMapping
    public TemperatureSensorLog create(@RequestBody TemperatureSensorLog log) {
        return service.saveLog(log);
    }

    @GetMapping
    public List<TemperatureSensorLog> getAll() {
        return service.getAllLogs();
    }
}
