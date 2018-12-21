package com.example.resttemplate.service;

import com.example.resttemplate.entity.Attachment;
import com.example.resttemplate.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author OITECH develop team - 19/12/2018
 */
@Service
public class AttachmentsService {

    @Autowired
    private AttachmentRepository attachmentRepository;


    /**
     * @return List of all attachments
     */
    public List<Attachment> findAll() {
        return (List<Attachment>) attachmentRepository.findAll();
    }


    /**
     * @return List of all attachments with file not null
     */
    public List<Attachment> findAllNotNull() {
        return (List<Attachment>) attachmentRepository.findByFileNotNull();
    }
}

