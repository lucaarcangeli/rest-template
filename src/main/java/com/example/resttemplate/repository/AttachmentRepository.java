package com.example.resttemplate.repository;

import com.example.resttemplate.entity.Attachment;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * @author OITECH develop team - 19/12/2018
 */
//@RepositoryRestResource(collectionResourceRel = "attachments", path = "attachments")
public interface AttachmentRepository extends PagingAndSortingRepository<Attachment, Integer> {

    public Iterable<Attachment> findByFileNotNull();

}
