package com.example.email_services.contoller;


import com.example.email_services.emailservices.emailserviceimplement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/verifyemail")
public class emailcontoller {

    private final emailserviceimplement sendmail;

    public emailcontoller(emailserviceimplement sendmail) {
        this.sendmail = sendmail;
    }


    @PostMapping("/")
    public long send(@RequestBody String email){
        Random random = new Random();
        long code = random.nextLong(100000,999999);
        sendmail.sendEmail(code,email);
        return code;
    }
}
