package com.demo.auth.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Producer endpoint. Techtonik discovers these as ENDPOINT nodes during the
 * scan, and the Endpoint Testing page can probe them once the service runs.
 */
@Path("/v1/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TokenResource {

    @POST
    @Path("/token")
    public TokenResultDTO issueToken(TokenRequestDTO request) {
        TokenResultDTO result = new TokenResultDTO();
        result.setAccessToken("demo-token");
        result.setTokenType("Bearer");
        result.setExpiresIn(3600);
        result.setScope(request == null ? "read" : request.getScope());
        return result;
    }

    @GET
    @Path("/token/{clientId}")
    public TokenResultDTO currentToken(@PathParam("clientId") String clientId) {
        TokenResultDTO result = new TokenResultDTO();
        result.setAccessToken("demo-token-" + clientId);
        result.setTokenType("Bearer");
        result.setExpiresIn(1800);
        result.setScope("read");
        return result;
    }
}
