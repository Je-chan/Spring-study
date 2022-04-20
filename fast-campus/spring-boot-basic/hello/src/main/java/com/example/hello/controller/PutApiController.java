package com.example.hello.controller;

import com.example.hello.dto.DtoPut;
import org.springframework.web.bind.annotation.*;

// RestController 를 사용하면 리턴 값으로 객체를 보내줄 때 JSON 형태로 보내준다
@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put-practice")
    public DtoPut put(@RequestBody DtoPut requestDto) {
        System.out.println(requestDto);
        return requestDto;
    }

    @PutMapping("/path-variable/{userId}")
    public DtoPut putVariable(@RequestBody DtoPut requestDto, @PathVariable(name = "userId") Long id) {
        System.out.println(id);
        return requestDto;
    }

}
