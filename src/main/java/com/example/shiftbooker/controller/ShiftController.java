package com.example.shiftbooker.controller;

import com.example.shiftbooker.model.Shift;
import com.example.shiftbooker.service.ShiftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schichten")
public class ShiftController {

    private final ShiftService shiftService;

    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @GetMapping
    public ResponseEntity<List<Shift>> getAllShifts(){
        List<Shift> shifts = shiftService.findAllShifts();
        return new ResponseEntity<>(shifts, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Shift> getShiftById(@PathVariable("id") Long id){
        Shift shift = shiftService.findShiftById(id);
        return new ResponseEntity<Shift>(shift, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Shift> addShift(@RequestBody Shift shift){
        Shift newShift = shiftService.addOrUpdateShift(shift);
        return new ResponseEntity<Shift>(newShift,HttpStatus.CREATED);
    }
}
