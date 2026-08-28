package com.demo.consumers;

import com.demo.auth.api.TokenResultDTO;

/** Maps an auth token onto a browser session lifetime. */
public class PortalSessionService {

    public int sessionTimeoutSeconds(TokenResultDTO token) {
        // The UI session must never outlive the token behind it.
        return (int) Math.min(token.getExpiresIn(), 7200L);
    }

    public boolean requiresReauth(TokenResultDTO token) {
        return token.getExpiresIn() < 300;
    }
}
