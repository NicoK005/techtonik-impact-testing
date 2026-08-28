package com.demo.consumers;

import com.demo.auth.api.TokenResultDTO;

import java.time.Duration;
import java.time.Instant;

/** Caches the auth token until shortly before it expires. */
public class BillingTokenCache {

    private TokenResultDTO cached;
    private Instant refreshAt = Instant.EPOCH;

    public boolean isStale() {
        return Instant.now().isAfter(refreshAt);
    }

    public void store(TokenResultDTO token) {
        this.cached = token;
        // Refresh a minute early so an in-flight call never uses a dead token.
        this.refreshAt = Instant.now()
                .plus(Duration.ofSeconds(token.getExpiresIn()))
                .minus(Duration.ofSeconds(60));
    }

    public String bearer() {
        return cached == null ? null : "Bearer " + cached.getAccessToken();
    }
}
