package com.school.Tuition_fees;


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
    private String classroom;
    private int month;
    private boolean status;
    private LocalDateTime paidAt;
}
