package com.github.saintukrainian.emailsender.sender;

import java.io.IOException;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

public class Sender {

    @NotNull
    @Pattern(regexp = "\\w+@\\w+\\.\\w+", message = "Enter correct email")
    private String email;

    @NotNull
    @Size(max = 64)
    private String subject;

    @NotNull
    private String content;

    public Sender() {}
    
    public Sender(String email, String subject, String content) {
        this.email = email;
        this.subject = subject;
        this.content = content;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public void sendEmail(Sender sender) {
        Email from = new Email("idanchik48@gmail.com");
        String subject = sender.getSubject();
        Email to = new Email("idanchik47@gmail.com");
        Content content = new Content("text/plain", sender.getEmail() + " - emailed from." + "\n" + sender.getContent());
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
