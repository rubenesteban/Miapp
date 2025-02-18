package com.miempresa.miapp.services;
import com.miempresa.miapp.models.Cuenta;
import com.miempresa.miapp.repositories.CuentaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CuentaService {
    private final CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public List<Cuenta> obtenerTodas() {
        return cuentaRepository.findAll();
    }
}
