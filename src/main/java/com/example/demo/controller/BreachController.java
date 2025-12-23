@RestController
@RequestMapping("/breaches")
public class BreachController {

    private final BreachDetectionService service;

    public BreachController(BreachDetectionService service) {
        this.service = service;
    }

    @PostMapping
    public BreachRecord create(@RequestBody BreachRecord breach) {
        return service.saveBreach(breach);
    }

    @GetMapping
    public List<BreachRecord> getAll() {
        return service.getAllBreaches();
    }
}
