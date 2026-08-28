package com.demo.consumers;

import com.demo.auth.api.TokenResultDTO;

/** Records token issuance for the audit trail. */
public class AuditLogWriter {

    public String render(TokenResultDTO token) {
        return String.format("issued type=%s scope=%s ttl=%ds",
                token.getTokenType(), token.getScope(), token.getExpiresIn());
    }
}
