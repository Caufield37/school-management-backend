package com.school.Tuition_fees;


import com.school.Student.Student;
import com.school.Student.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TuitionFeeService {

    private final TuitionFeeRepository tuitionFeeRepository;
    private final StudentRepository studentRepository;

    public TuitionFeeService(TuitionFeeRepository tuitionFeeRepository,
                             StudentRepository studentRepository) {
        this.tuitionFeeRepository = tuitionFeeRepository;
        this.studentRepository = studentRepository;
    }

    public TuitionFee recordPayment(Long studentId, String month) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("student does not exist..."));

        TuitionFee fee = new TuitionFee();

        fee.setStudent(student);
        fee.setFeeMonth(month);
        fee.setPaid(true);
        fee.setPaidAt(LocalDateTime.now());

        return tuitionFeeRepository.save(fee);
    }

    public PaymentReport reportPayment(Long studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("student does not exist..."));
        
    }
}
