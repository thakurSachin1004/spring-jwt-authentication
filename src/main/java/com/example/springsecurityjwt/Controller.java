package com.example.springsecurityjwt;

import com.example.springsecurityjwt.mapper.AuthenticateRequest;
import com.example.springsecurityjwt.mapper.AuthenticateResponse;
import com.example.springsecurityjwt.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Controller {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private Utils jwtUtils;

    @Autowired
    private MyUserService myUserService;

    @GetMapping("/home")
    public String homePage() {return "Home Page. Visible to everyone";}

    @GetMapping(value = "/user" )
    public String firstPage(HttpServletRequest request) {
//        System.out.println(request.getHeader("Authorization"));
//        System.out.println(request.getCookies());
//        System.out.println(request.getAuthType());
        return "Hello Users";
    }

    @PostMapping("/authenticate")
    public AuthenticateResponse createJWT(@RequestBody AuthenticateRequest authenticateRequest) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), authenticateRequest.getPassword()));
        }
        catch (BadCredentialsException badCredentialsException) {
            throw new Exception("Incorrect Username or password", badCredentialsException);
        }

        final UserDetails userDetails = myUserService.loadUserByUsername(authenticateRequest.getUsername());

        final String token = jwtUtils.generateToken(userDetails);

        return new AuthenticateResponse(token);
    }

}
