package com.SpringBoot_SpringSecurity.controller;

import com.SpringBoot_SpringSecurity.entity.User;
import com.SpringBoot_SpringSecurity.payload.JWTAuthResponse;
import com.SpringBoot_SpringSecurity.payload.LoginDto;
import com.SpringBoot_SpringSecurity.payload.RegisterDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;

/*
* rest controller imputato a consumare le api del core controller: esegue autenticazione con credenziali admin e le recupera
*
* see: https://www.javainuse.com/webseries/spring-security-jwt/chap6
*  */

@RestController
@RequestMapping("/api/get_pers")
public class coreConsumerController {

    Logger log= LoggerFactory.getLogger(coreConsumerController.class);

    @Autowired private RestTemplate rt;
    private static final String url="http://localhost:8082";
    private static final String urlPersoncine=url+"/api/personcine";
    private static final String urlLogin=url+"/api/auth/login";

    //ACCESSING THE CORE MICROSERVICE

    @GetMapping("/all")
    public ResponseEntity<Object> getPersoncine(){

        ResponseEntity<Object> res=new ResponseEntity<>("I bunny men sono una mia opinione", HttpStatus.I_AM_A_TEAPOT);

        var jwt=login();


        if(jwt!=null){ //se il login è andato a buon fine
            var respStr=doRequestWithToken(jwt, urlPersoncine);

            if (respStr.getStatusCode().equals(HttpStatus.OK)) {//se la request è andata a buon fine
                var payload = respStr.getBody();
                res=new ResponseEntity<>(payload, HttpStatus.OK);
            }
        }
        return res;

    }


//      tries to login with the admin credentials and returns the JWTAuthResponse
        private JWTAuthResponse login(){

        JWTAuthResponse jwt =null;

        try {
            var loginDto = new LoginDto("Freeman_because_I'm_Bianca", "bianca");


             jwt=rt.postForObject(urlLogin, loginDto, JWTAuthResponse.class);
        }
        catch(RestClientException e){ log.error("ERRORE NEL LOGIN: "+e.getMessage());}

        return jwt;
        }

//     makes a request to the url, with the jwt token inserted
        private ResponseEntity<Object> doRequestWithToken(JWTAuthResponse jwt, String url){

        ResponseEntity<Object> res=null;

        try{ String token = "Bearer " + jwt.getAccessToken();
            HttpHeaders headers = getHeaders();
            headers.set("Authorization", token);
            HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);

//      send the request to the url!!
           res= rt.exchange(url, HttpMethod.GET, jwtEntity, Object.class);

        }
        catch(RestClientException e){log.error("ERRORE IN REQUEST CON TOKEN: "+e.getMessage());}
        return res;
    }

        private HttpHeaders getHeaders() {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
            return headers;
        }
        private String getBody(final User user) throws JsonProcessingException {
            return new ObjectMapper().writeValueAsString(user);
        }




}
