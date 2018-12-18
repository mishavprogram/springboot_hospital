package com.mvp.springboot.hospital.service;

import com.mvp.springboot.hospital.entities.Reception;
import com.mvp.springboot.hospital.entities.ReceptionStatus;
import com.mvp.springboot.hospital.repositories.ReceptionRepository;
import com.mvp.springboot.hospital.service.converter.ReceptionConverter;
import com.mvp.springboot.hospital.service.dto.ReceptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ReceptionService {

    @Autowired
    private ReceptionRepository receptionRepository;

    @Autowired
    private ReceptionConverter receptionConverter;

    public List<Reception> findAll(ReceptionStatus status){
        if (status==null){
            return receptionRepository.findAll();
        }
        return receptionRepository.findAllByStatusIn(status);
    }

    public Reception create(Reception reception){
        reception.setStatus(ReceptionStatus.NO_RESULT);
        return receptionRepository.save(reception);
    }

    public ReceptionDto findById(Long id){
        Reception reception = receptionRepository.getOne(id);
        return receptionConverter.toDto(reception);
    }
}
