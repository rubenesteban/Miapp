package com.miempresa.miapp.repositories;

import com.miempresa.miapp.models.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {}
