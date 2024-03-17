package com.example.bb.email;

import com.example.bb.user.model.Users;

public interface IEmailService {

	void sendForgotPasswordEmail(Users user);
    void sendResetPasswordConfirmationEmail(Users user);
    void sendAddUserEmail(Users user);
}
