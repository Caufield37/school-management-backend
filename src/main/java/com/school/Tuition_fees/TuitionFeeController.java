package com.school.Tuition_fees;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tuitionfees")
public class TuitionFeeController {

    private final TuitionFeeService tuitionFeeService;

    public TuitionFeeController(TuitionFeeService tuitionFeeService) {
        this.tuitionFeeService = tuitionFeeService;
    }

    @GetMapping("/{studentId}")
    public List<PaymentReport> viewAllPayment(@PathVariable Long studentId) {
        return tuitionFeeService.viewStudentTuitionFee(studentId);
    }

    @PostMapping("/pay")
    public ResponseEntity<String> recordPayment(@RequestBody PaymentRequest request) {
        tuitionFeeService.recordPayment(request.getStudentId(), request.getMonth());
        return ResponseEntity.ok("Payment recorded successfully for student ID: " + request.getStudentId());
    }
}
