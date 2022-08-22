package com.jetch.web.controller;

import com.jetch.web.configuration.WebSecurityConfiguration;
import com.jetch.web.entity.JwtRequest;
import com.jetch.web.entity.JwtResponse;
import com.jetch.web.utils.JwtUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3000/hello"})
public class LoginController {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    AuthenticationManager authenticationManager;

    private static Logger logger = LogManager.getLogger(LoginController.class);

    @PostMapping({"/authenticate/lo"})
    public ResponseEntity<JwtResponse> authenticate(@RequestBody JwtRequest request) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getUserPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Bad Creadential exception ");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
        String token = jwtUtils.generateToken(userDetails);
        JwtResponse response = new JwtResponse(token, (long) HttpStatus.OK.value());

        logger.info(token);

        return ResponseEntity.ok(response);
    }

    @PostMapping({"/post"})
    public String post(){
        return "Post request";
    }
    @GetMapping("/hello")
    public String Login(){
        return "Login Success";
    }

    @GetMapping("/hey")
    public String logout(){
        return "Login out";
    }
}
