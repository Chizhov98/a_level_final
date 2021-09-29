package com.example.back_end.api.controller.rest;

import com.example.back_end.facade.SpeakerFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/speaker")
public class SpeakerController {

    private final SpeakerFacade speakerFacade;

    public SpeakerController(SpeakerFacade speakerFacade) {
        this.speakerFacade = speakerFacade;
    }
}

