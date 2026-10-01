package com.school.Tuition_fees;


import com.school.Classroom.Classroom;
import com.school.Student.Student;
import com.school.Student.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TuitionFeeService {

    private final TuitionFeeRepository tuitionFeeRepository;
    private final StudentRepository studentRepository;

    public TuitionFeeService(TuitionFeeRepository tuitionFeeRepository,
                             StudentRepository studentRepository) {
        this.tuitionFeeRepository = tuitionFeeRepository;
        this.studentRepository = studentRepository;
    }

    public TuitionFee recordPayment(Long studentId, int month) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("student does not exist..."));



        boolean alreadyPaid = tuitionFeeRepository.existsByStudentIdAndFeeMonthAndIsPaidTrue(studentId, month);

        if (alreadyPaid) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Tuition fee for month " + month + " is already paid.");
        }

        TuitionFee fee = new TuitionFee();
        fee.setStudent(student);
        fee.setFeeMonth(month);
        fee.setPaid(true);
        fee.setPaidAt(LocalDateTime.now());

        return tuitionFeeRepository.save(fee);
    }

    @Transactional
    public List<PaymentReport> reportPayment(Long classId, int feeMonth) {

        List<Student> students = studentRepository.findByClassroomId(classId);

        List<PaymentReport> paymentReportsList = new ArrayList<>();
        for(Student student : students) {
            Long studentId = student.getId();
            String firstName = student.getFirstName();
            String lastName = student.getLastName();

            String name = firstName + " " + lastName;

            String classroom = student.getClassroom().getClassname();

            TuitionFee tuitionfee = tuitionFeeRepository.findByStudentIdAndFeeMonth(studentId, feeMonth);

            LocalDateTime paidAt = null;
            boolean status = false;
            if(tuitionfee != null) {
                status = true;
                paidAt = tuitionfee.getPaidAt();
            } else {
                status = false;
            }
            paymentReportsList.add(new PaymentReport(studentId, name, classroom, feeMonth, status, paidAt));
        }
        return paymentReportsList;

    }

    public List<PaymentReport> viewStudentTuitionFee(Long studentId) {

        List<TuitionFee> studentTuitionFeesList = tuitionFeeRepository.findByStudentId(studentId);
        List<PaymentReport> studentTuitionFeePaymentReportList = new ArrayList<>();

        for(TuitionFee studentTuitionFee : studentTuitionFeesList) {
            PaymentReport report = new PaymentReport();
            String studentFName = studentTuitionFee.getStudent().getFirstName();
            String studentLName = studentTuitionFee.getStudent().getLastName();
            String name = studentFName + " " + studentLName;
            String classroomName = studentTuitionFee.getStudent().getClassroom().getClassname();
            int month = studentTuitionFee.getFeeMonth();
            boolean status = studentTuitionFee.isPaid();
            LocalDateTime paidAt = studentTuitionFee.getPaidAt();

            report.setStudentId(studentId);
            report.setStudentName(name);
            report.setClassroomName(classroomName);
            report.setMonth(month);
            report.setStatus(status);
            report.setPaidAt(paidAt);

            studentTuitionFeePaymentReportList.add(report);

        }

        return studentTuitionFeePaymentReportList;
    }
}
