package com.example.back_end.facade;

import com.example.back_end.api.dto.request.SpeakerRequestDto;
import com.example.back_end.api.dto.response.SpeakerResponseDto;

public interface SpeakerFacade extends CrudFacade<SpeakerRequestDto, SpeakerResponseDto> {
}
