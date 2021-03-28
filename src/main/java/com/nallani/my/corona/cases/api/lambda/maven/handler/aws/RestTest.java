package com.nallani.my.corona.cases.api.lambda.maven.handler.aws;

import com.nallani.my.corona.cases.api.lambda.maven.service.CoronaCasesApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class RestTest {
    @Autowired
    private CoronaCasesApiService coronaClass;

    @RequestMapping(
            value = "/get-usa",
            method = RequestMethod.GET
    )
    public String getINR() throws Exception {
        return coronaClass.getUsaCases();
    }

    @GetMapping("/health")
    public String healthcheck() {
        return "OK";
    }
}
