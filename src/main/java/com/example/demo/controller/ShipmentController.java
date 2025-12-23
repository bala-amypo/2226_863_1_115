@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentRecordService service;

    public ShipmentController(ShipmentRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ShipmentRecord create(@RequestBody ShipmentRecord shipment) {
        return service.saveShipment(shipment);
    }

    @GetMapping
    public List<ShipmentRecord> getAll() {
        return service.getAllShipments();
    }
}
