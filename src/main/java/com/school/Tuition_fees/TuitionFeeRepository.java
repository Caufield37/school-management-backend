package com.school.Tuition_fees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuitionFeeRepository extends JpaRepository <TuitionFee, Long> {

}
