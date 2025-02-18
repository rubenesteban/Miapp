import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import java.util.List;
import java.util.Arrays;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerTodos() {
        Cliente cliente1 = new Cliente();
        cliente1.setClienteId(1L);
        cliente1.setEstado(true);

        Cliente cliente2 = new Cliente();
        cliente2.setClienteId(2L);
        cliente2.setEstado(true);

        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

        List<Cliente> clientes = clienteService.obtenerTodos();

        assertNotNull(clientes);
        assertEquals(2, clientes.size());
    }

    @Test
    void testObtenerPorId() {
        Cliente cliente = new Cliente();
        cliente.setClienteId(1L);

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Optional<Cliente> resultado = clienteService.obtenerPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals(1L, resultado.get().getClienteId());
    }

    @Test
    void testGuardarCliente() {
        Cliente cliente = new Cliente();
        cliente.setClienteId(1L);

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente resultado = clienteService.guardarCliente(cliente);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getClienteId());
    }

    @Test
    void testEliminarCliente() {
        Cliente cliente = new Cliente();
        cliente.setClienteId(1L);

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        doNothing().when(clienteRepository).deleteById(1L);

        clienteService.eliminarCliente(1L);

        verify(clienteRepository, times(1)).deleteById(1L);
    }
}
