import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Optional;
import java.util.Arrays;

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testObtenerTodos() throws Exception {
        Cliente cliente1 = new Cliente();
        cliente1.setClienteId(1L);
        cliente1.setEstado(true);

        Cliente cliente2 = new Cliente();
        cliente2.setClienteId(2L);
        cliente2.setEstado(true);

        when(clienteService.obtenerTodos()).thenReturn(Arrays.asList(cliente1, cliente2));

        mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)));
    }

    @Test
    void testObtenerPorId_Existente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setClienteId(1L);

        when(clienteService.obtenerPorId(1L)).thenReturn(Optional.of(cliente));

        mockMvc.perform(get("/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.clienteId", is(1)));
    }

    @Test
    void testObtenerPorId_NoExistente() throws Exception {
        when(clienteService.obtenerPorId(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/clientes/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCrearCliente() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setClienteId(1L);
        cliente.setEstado(true);

        when(clienteService.guardarCliente(any(Cliente.class))).thenReturn(cliente);

        mockMvc.perform(post("/clientes")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.clienteId", is(1)));
    }

    @Test
    void testEliminarCliente_Existente() throws Exception {
        when(clienteService.obtenerPorId(1L)).thenReturn(Optional.of(new Cliente()));

        mockMvc.perform(delete("/clientes/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testEliminarCliente_NoExistente() throws Exception {
        when(clienteService.obtenerPorId(1L)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/clientes/1"))
                .andExpect(status().isNotFound());
    }
}
