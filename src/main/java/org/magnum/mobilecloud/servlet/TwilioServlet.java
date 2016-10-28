package org.magnum.mobilecloud.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.twiml.Say;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;

public class TwilioServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Create a TwiML response and add our friendly message.
        VoiceResponse voiceResponse = new VoiceResponse.Builder()
                .say(new Say.Builder("Hello Monkey").build())
                .build();

        response.setContentType("application/xml");
        try {
            response.getWriter().print(voiceResponse.toXml());
        } catch (TwiMLException e) {
            e.printStackTrace();
        }
    }
}