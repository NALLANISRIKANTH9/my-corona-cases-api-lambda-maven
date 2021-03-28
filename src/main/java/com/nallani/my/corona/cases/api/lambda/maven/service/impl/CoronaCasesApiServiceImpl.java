package com.nallani.my.corona.cases.api.lambda.maven.service.impl;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nallani.my.corona.cases.api.lambda.maven.service.CoronaCasesApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CoronaCasesApiServiceImpl implements CoronaCasesApiService {
    private static Logger LOG = LoggerFactory.getLogger(CoronaCasesApiServiceImpl.class);
    @Autowired
    private Environment env;

    @Override
    public String getUsaCases() throws Exception {
        ResponseEntity<String> response= null;
        JsonNode rootNode = null;
        String status = null;

        RestTemplate r = new RestTemplate();
        response = r.getForEntity("https://coronavirus-19-api.herokuapp.com/countries/USA", String.class);
        String result =  response.getBody();
        if (result == null){
            throw  new NullPointerException("result cannot be null");
        }
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> message = mapper.readValue(result, Map.class);
        LOG.info("String to map convert  " + message);
        String msg = String.valueOf(message);
        String nobraces = msg.substring(1, msg.length()-1);
        //String.format("Nallani %s", result) ;
        LOG.info("final message " + nobraces);
        getSNS(nobraces);
        return nobraces;
    }

    public AmazonSNS getSNS(String msg) {
        LOG.info("Message: " + msg);
        AmazonSNSClient sns = new AmazonSNSClient();
        final PublishRequest publishRequest = new PublishRequest("arn:aws:sns:us-east-1:140458552010:corona-cases", msg);
        final PublishResult publishResponse = sns.publish(publishRequest);
        LOG.info("MessageId: " + publishResponse.getMessageId());
        return sns;
    }
}