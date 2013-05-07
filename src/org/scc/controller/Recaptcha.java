package org.scc.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

/**
 * Servlet implementation class Recaptcha
 */
@WebServlet("/Recaptcha")
public class Recaptcha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recaptcha() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Captcha codes
		String reChallenge = request.getParameter("recaptcha_challenge_field");
		String reResponse = request.getParameter("recaptcha_response_field");
		String remoteAddr = request.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();

		// ***  PROVIDE  PRIVATE KEY HERE ***
		reCaptcha.setPrivateKey("6LcQjOASAAAAAJ5jpe7R-7QYKt1N0UQ30gwu_dPx");

		ReCaptchaResponse reCaptchaResponse =
		reCaptcha.checkAnswer(remoteAddr, reChallenge, reResponse);
		boolean valid = reCaptchaResponse.isValid();

		if (valid) {
		//do this
			response.getWriter().write("good");

		} else {
		//do this
			response.getWriter().write("bad");
		}
	}

}
