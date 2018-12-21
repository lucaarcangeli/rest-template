package com.example.resttemplate.api;

import com.example.resttemplate.entity.Attachment;
import com.example.resttemplate.service.AttachmentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;


/**
 * @author OITECH develop team - 19/12/2018
 */
@RestController
@RequestMapping(value = "/v1")
@Slf4j
public class AttachmentFacadeRest extends GenericRestFacade {

    @Autowired
    private AttachmentsService attachmentsService;


    /**
     * @param httpServletRequest
     * @param locale
     * @return
     */
    @GetMapping(value = "/attachments")
    public ResponseEntity<?> FindAll(HttpServletRequest httpServletRequest, Locale locale) {
        List<Attachment> all = attachmentsService.findAllNotNull();

        all.forEach(a -> {
            String path = "/var/doc/allegati";
            if (a.getEntity() != null && a.getEntity().equalsIgnoreCase("fattura")) {
                path = "/var/doc/fatture";
            }
            log.info("{}/{}", path, a.getFile());
        });
        log.info("TOTAL: {}", all.size());

        return ResponseEntity.ok().build();
    }
}
