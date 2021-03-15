package kr.mail.fmember;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuth extends Authenticator {

	PasswordAuthentication pa;
	
	public MailAuth() {
		String mail_id = "patrm93";
		String mail_pw = "Qkralswn1!";
		
		pa = new PasswordAuthentication(mail_id, mail_pw);
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}
