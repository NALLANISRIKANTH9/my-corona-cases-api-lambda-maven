package com.nallani.my.corona.cases.api.lambda.maven;

import com.nallani.my.corona.cases.api.lambda.maven.service.CoronaCasesApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component("CustomerVerificationFunctionHandler")
public class CoronaCasesApiServiceFunction implements Function<String, String> {

    private static Logger LOG = LoggerFactory.getLogger(CoronaCasesApiServiceFunction.class);
    @Autowired private CoronaCasesApiService coronaCasesApiService;

    @Override
    public String apply(String s) {
        try {
            LOG.info("Calling service for input " + s);
            return coronaCasesApiService.getUsaCases();
        } catch (Exception e) {
            e.getStackTrace();
            LOG.info("Exception....." + e);
            return String.valueOf(e);
        }
    }
}