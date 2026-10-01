package com.school.Tuition_fees;


import com.school.Classroom.Classroom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentReport {

    private Long studentId;
    private String studentName;
    private String classroomName;
    private int month;
    private boolean status;
    private LocalDateTime paidAt;
}
