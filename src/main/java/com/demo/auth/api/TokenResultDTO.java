package com.demo.auth.api;

/**
 * Response contract of the token endpoint.
 *
 * <p>This is the producer side of the demo. Six consumer classes read
 * {@link #getExpiresIn()}; removing that field is the breaking change the
 * Risk Gate is expected to catch.
 */
public class TokenResultDTO {

    private String accessToken;
    private String tokenType;

    /**
     * Seconds until the token expires.
     *
     * <p>Consumers cache and schedule against this. Deleting it is the
     * breaking change under test.
     */
    private long expiresIn;

    private String scope;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
