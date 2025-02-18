import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoRepository movimientoRepository;

    // GET: Obtener todos los movimientos
    @GetMapping
    public List<Movimiento> obtenerTodos() {
        return movimientoRepository.findAll();
    }

    // GET: Obtener movimiento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> obtenerPorId(@PathVariable Long id) {
        Optional<Movimiento> movimiento = movimientoRepository.findById(id);
        return movimiento.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: Crear nuevo movimiento
    @PostMapping
    public Movimiento crearMovimiento(@RequestBody Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    // DELETE: Eliminar movimiento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable Long id) {
        if (!movimientoRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        movimientoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
