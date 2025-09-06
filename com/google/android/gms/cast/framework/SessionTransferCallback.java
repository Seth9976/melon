package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.SessionState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class SessionTransferCallback {
    @Retention(RetentionPolicy.SOURCE)
    public @interface TransferFailedReason {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TransferType {
    }

    public static final int TRANSFER_FAILED_REASON_STORE_SESSION_STATE = 100;
    public static final int TRANSFER_FAILED_REASON_TRANSFER_TIMEOUT = 101;
    public static final int TRANSFER_TYPE_FROM_REMOTE_TO_LOCAL = 1;
    public static final int TRANSFER_TYPE_UNKNOWN;

    public void onTransferFailed(int v, int v1) {
    }

    public void onTransferred(int v, SessionState sessionState0) {
    }

    public void onTransferring(int v) {
    }
}

