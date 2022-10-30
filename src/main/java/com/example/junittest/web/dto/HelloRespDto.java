package com.example.junittest.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloRespDto {

    private final String name;
    private final int amount;
}