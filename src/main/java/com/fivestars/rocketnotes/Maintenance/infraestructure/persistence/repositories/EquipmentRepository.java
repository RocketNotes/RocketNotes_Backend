package com.fivestars.rocketnotes.Maintenance.infraestructure.persistence.repositories;

import com.fivestars.rocketnotes.Maintenance.domain.model.agreggates.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
