package com.example.shiftbooker.repo;

import com.example.shiftbooker.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepo extends JpaRepository<Shift, Long> {
}
