package com.droideye.dao;

import com.droideye.domain.Certificate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CertificationMapper extends JpaRepository<Certificate, Integer> {

    /*
     * 根据传入的用户证件号，来查询出其所有证件信息
     * */
    //@Query(value = "SELECT u from Certificate u WHERE u.userIdNumber=:idNumber")
    //default Optional<List<Certificate>> forCertificatedStateByUserIdNum(@Param("idNumber") Long idNumber) {
    //    ArrayList<Certificate> defaultList = Lists.newArrayList(
    //            new Certificate().builder().id(1).certificateType("工作居住证 of " + idNumber)
    //                    .certificateNumber("201701010001")
    //                    .issuanceDate(Date.from(LocalDate.of(2017, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
    //                    .validityDate(Date.from(LocalDate.of(2020, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
    //                    .userIdNumber(idNumber)
    //                    .build()
    //    );
    //    return Optional.of(defaultList);
    //}

    @Query(value = "SELECT u from Certificate u WHERE u.userIdNumber=:idNumber")
    Optional<List<Certificate>> forCertificatedStateByUserIdNum(@Param("idNumber") Long idNumber);
}
