package com.demo.consumers;

import com.demo.auth.api.TokenResultDTO;

/** Warns operators when the service account credential is close to expiry. */
public class NotificationDispatcher {

    public boolean shouldWarnOperators(TokenResultDTO token) {
        return token.getExpiresIn() < 600;
    }

    public String warningMessage(TokenResultDTO token) {
        return "Service token expires in " + token.getExpiresIn() + "s";
    }
}
