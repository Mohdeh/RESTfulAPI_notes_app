import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import javax.net.ssl.SSLSession;
import javax.swing.text.Document;
import javax.swing.text.View;
import javax.xml.crypto.Data;

import java.util.*;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.text.*;
import java.awt.PageAttributes.MediaType;
import java.io.File;


@Path("/authentication")
public class AuthenticationEndpoint {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("userEmail") String userEmail, 
                                     @FormParam("userPass") String password) {

        try {

            // Authenticate the user using the credentials provided
            authenticate(userEmail, password);

            // Issue a token for the user
            String token = issueToken(userEmail);

            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }      
    }

    private void authenticate(String username, String password) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
    }

    private void issueToken(String username) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
    }
}
