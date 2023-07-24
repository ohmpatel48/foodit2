package com.foodit.main.contoller;

import com.foodit.main.services.impl.emailserviceimplement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/verify")
public class verifycontrol {


    private emailserviceimplement sendingmail;

    public verifycontrol(emailserviceimplement sendingmail) {
        this.sendingmail = sendingmail;
    }


    @PostMapping("/")
    public long send(@RequestBody String email){
        Random random = new Random();
        long code = random.nextLong(100000,999999);
        sendingmail.sendEmail(code,email);
        return code;
    }

}
