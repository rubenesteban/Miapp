ackage com.miempresa.miapp.services;
import com.miempresa.miapp.models.Movimiento;
import com.miempresa.miapp.repositories.MovimientoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovimientoService {
    private final MovimientoRepository movimientoRepository;

    public MovimientoService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    public List<Movimiento> obtenerTodos() {
        return movimientoRepository.findAll();
    }
}
