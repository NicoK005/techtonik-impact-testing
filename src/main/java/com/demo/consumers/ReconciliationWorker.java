package com.demo.consumers;

import com.demo.auth.api.TokenResultDTO;

/** Long-running batch job; re-authenticates mid-run when the token would expire. */
public class ReconciliationWorker {

    private static final long BATCH_DURATION_SECONDS = 900;

    public boolean canCompleteBatch(TokenResultDTO token) {
        return token.getExpiresIn() > BATCH_DURATION_SECONDS;
    }

    public long secondsUntilRefresh(TokenResultDTO token) {
        return Math.max(0, token.getExpiresIn() - BATCH_DURATION_SECONDS);
    }
}
