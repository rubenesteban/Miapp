import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;

    // GET: Obtener todas las cuentas
    @GetMapping
    public List<Cuenta> obtenerTodas() {
        return cuentaRepository.findAll();
    }

    // GET: Obtener cuenta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> obtenerPorId(@PathVariable Long id) {
        Optional<Cuenta> cuenta = cuentaRepository.findById(id);
        return cuenta.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: Crear nueva cuenta
    @PostMapping
    public Cuenta crearCuenta(@RequestBody Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    // DELETE: Eliminar cuenta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Long id) {
        if (!cuentaRepository.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cuentaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
