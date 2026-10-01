package com.school.Tuition_fees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TuitionFeeRepository extends JpaRepository <TuitionFee, Long> {

    TuitionFee findByStudentIdAndFeeMonth(Long studentId, int feeMonth);

    List<TuitionFee> findByStudentId(Long studentId);

}
