package com.example;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/tests")
public class TestController {
    final Test test = new Test();
    final Page<Test> page = new PageImpl<>(Collections.singletonList(test));

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTest() {
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    public static class Test {
        private Map<String, String> map = new HashMap<>();

        public Test() {
            for (int i = 0; i < 20; i++) {
                map.put(String.valueOf(i), UUID.randomUUID().toString());
            }
        }

        public Map<String, String> getMap() {
            return map;
        }
    }
}