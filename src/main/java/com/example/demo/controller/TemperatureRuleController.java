@RestController
@RequestMapping("/rules")
public class TemperatureRuleController {

    private final TemperatureRuleService service;

    public TemperatureRuleController(TemperatureRuleService service) {
        this.service = service;
    }

    @PostMapping
    public TemperatureRule create(@RequestBody TemperatureRule rule) {
        return service.saveRule(rule);
    }

    @GetMapping
    public List<TemperatureRule> getAll() {
        return service.getAllRules();
    }
}
