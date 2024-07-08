package com.riwi.workshop.api.controllers.BasicControllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public interface BasicController<RESPONSE, RESPONSEBASIC, CREATEREQUEST, UPDATEREQUEST> extends
                DeleteController,
                GetByIdController<RESPONSE>, PostController<RESPONSEBASIC, CREATEREQUEST>,
                PutController<RESPONSE, UPDATEREQUEST> {
}