package com.example.bb.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bb.user.model.Users;

@Service
public class EmailService implements IEmailService{

	@Autowired
	private SendMail sendMail;
	
    public void sendForgotPasswordEmail(Users user) {
    	String body= user.getFirstName()+", your OTP for reset password on bulk bazar is "+user.getValidOtp()
    										+".It is valid till "+user.getValidOtpTime();
    	String subject="Bulk Bajar - Forgot Password";
    	sendMail.sendNewMail(user.getEmail(),subject, body);
    }
    
    public void sendResetPasswordConfirmationEmail(Users user) {
    	String body= user.getFirstName()+", your password has been changed on bulk bajar.";
    	String subject="Bulk Bajar - Password Changed";
    	sendMail.sendNewMail(user.getEmail(),subject, body);
    }
    
    public void sendAddUserEmail(Users user) {
    	String body=user.getFirstName()+", you have registered on bulk bajar. Your username : "+user.getUsername()+" and password : "+user.getPassword();
    	String subject="Bulk Bajar - Registration Complete";
    	sendMail.sendNewMail(user.getEmail(),subject, body);
    }
}
