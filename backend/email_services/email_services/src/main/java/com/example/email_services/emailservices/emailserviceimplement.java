package com.example.email_services.emailservices;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class emailserviceimplement implements emailservice {

    @Value("${spring.mail.username}")
    private String Emailfrom;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendEmail(long verificationcode , String to) {
        try {
            System.out.println(to);
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setFrom(Emailfrom);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject("Email Verification");
            mimeMessageHelper.setText("Subject: Your Verification Code for Foodit Account\n" +
                    "\n" +
                    "Dear Valued Customer,\n" +
                    "\n" +
                    "Thank you for choosing Foodit, your go-to platform for delicious and convenient food delivery. We are excited have you as part of our growing community!\n" +
                    "\n" +
                    "To ensure the security of your account, we have implemented a verification process. Please find below your unique verification code:\n" +
                    "\n" +
                    "Verification Code:" + verificationcode + "\n"+
                    "\n" +
                    "Please note that this code is confidential and should not be shared with anyone. It is essential for confirming your identity and maintaining the integrity of your Foodif account.\n" +
                    "\n" +
                    "To complete the verification process, please follow these simple steps:\n" +
                    "\n" +
                    "1. Open the Foodit mobile app or visit our website at www.foodit.com.\n" +
                    "2. Click on the \"Sign In\" button to access your account.\n" +
                    "3. Enter your registered email address and password.\n" +
                    "4. When prompted, enter the verification code provided above in the designated field.\n" +
                    "5. Click on the \"Verify\" button to confirm your account.\n" +
                    "\n" +
                    "Once your account is successfully verified, you will gain full access to all the features and benefits Foodit has to offer. Enjoy browsing through a wide range of restaurants, exploring diverse cuisines, and placing orders effortlessly.\n" +
                    "\n" +
                    "If you encounter any issues during the verification process or have any questions regarding your Foodit account, please do not hesitate to reach out to our dedicated customer support team. They are available 24/7 and can be contacted via email at support@foodif.com or by calling our toll-free number at +1-800-123-4567.\n" +
                    "\n" +
                    "Thank you for your cooperation in completing the verification process promptly. We look forward to serving you and providing an exceptional food delivery experience.\n" +
                    "\n" +
                    "Sincerely,\n" +
                    "\n" +
                    "Customer Support Representative\n" +
                    "Foodit");
            javaMailSender.send(message);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
