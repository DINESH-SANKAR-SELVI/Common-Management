package com.DINESH.commonManagement.repositories;

import com.DINESH.commonManagement.entities.AutoGenerateSequence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.text.DecimalFormat;

@Repository
@Transactional
public class AutoGenerateSequenceRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public AutoGenerateSequence getbycodeandtype(String type, String code) {
        try {
            return (AutoGenerateSequence) entityManager
                    .createNativeQuery("SELECT * FROM sequence_generator WHERE type=:type AND code=:code;", AutoGenerateSequence.class)
                    .setParameter("type", type).setParameter("code", code).getSingleResult();
        } catch (Exception error){
            return null;
        }
    }

    public String getSequence(String type, String code, String pattern) {

        AutoGenerateSequence autoGenerateSequence = getbycodeandtype(type ,code);
        if (null == autoGenerateSequence) {
            autoGenerateSequence = new AutoGenerateSequence();

            autoGenerateSequence.setCode(code);
            autoGenerateSequence.setType(type);
            autoGenerateSequence.setMaster(code);
            autoGenerateSequence.setSequenceNo(0);

            entityManager.persist(autoGenerateSequence);
        }
        autoGenerateSequence.setSequenceNo(autoGenerateSequence.getSequenceNo() + 1);
        entityManager.flush();

        String sequenceValue;
        if (pattern.isBlank()) return String.valueOf(autoGenerateSequence.getSequenceNo());
        else {
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            return code.concat(decimalFormat.format(autoGenerateSequence.getSequenceNo()));
        }
    }
}

