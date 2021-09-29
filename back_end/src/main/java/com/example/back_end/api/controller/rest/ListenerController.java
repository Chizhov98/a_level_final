package com.example.back_end.api.controller.rest;

import com.example.back_end.facade.ListenerFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ListenerController {
    private final ListenerFacade listenerFacade;

    public ListenerController(ListenerFacade listenerFacade) {
        this.listenerFacade = listenerFacade;
    }
}
