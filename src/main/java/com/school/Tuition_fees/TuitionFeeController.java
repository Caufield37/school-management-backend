package com.school.Tuition_fees;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tuitionfees")
public class TuitionFeeController {

    private final TuitionFeeService tuitionFeeService;

    public TuitionFeeController(TuitionFeeService tuitionFeeService) {
        this.tuitionFeeService = tuitionFeeService;
    }

    @PostMapping("/pay")
    public ResponseEntity<String> recordPayment(@RequestBody PaymentRequest request) {
        tuitionFeeService.recordPayment(request.getStudentId(), request.getMonth());
        return ResponseEntity.ok("Payment recorded successfully for student ID: " + request.getStudentId());
    }
}
