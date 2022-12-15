package com.example.shiftbooker.service;

import com.example.shiftbooker.exception.NotFoundException;
import com.example.shiftbooker.model.Shift;
import com.example.shiftbooker.repo.ShiftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftService {

    private final ShiftRepo shiftRepo;

    @Autowired
    public ShiftService(ShiftRepo shiftRepo) {
        this.shiftRepo = shiftRepo;
    }

    public List<Shift> findAllShifts() {  return shiftRepo.findAll();  }

    public Shift findShiftById(Long id) {
        return shiftRepo.findById(id).orElseThrow(() -> new NotFoundException("Schicht existiert nicht!"));
    }

    public Shift addOrUpdateShift(Shift shift) {
        return shiftRepo.save(shift);
    }

    public void deleteShift(Long id){shiftRepo.deleteById(id);}

}
