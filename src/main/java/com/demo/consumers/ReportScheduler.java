package com.demo.consumers;

import com.demo.auth.api.TokenResultDTO;

/** Schedules report generation inside the credential's validity window. */
public class ReportScheduler {

    public boolean fitsInWindow(TokenResultDTO token, long estimatedRuntimeSeconds) {
        return estimatedRuntimeSeconds < token.getExpiresIn();
    }
}
