package com.google.android.gms.cast.framework;

public interface SessionManagerListener {
    void onSessionEnded(Session arg1, int arg2);

    void onSessionEnding(Session arg1);

    void onSessionResumeFailed(Session arg1, int arg2);

    void onSessionResumed(Session arg1, boolean arg2);

    void onSessionResuming(Session arg1, String arg2);

    void onSessionStartFailed(Session arg1, int arg2);

    void onSessionStarted(Session arg1, String arg2);

    void onSessionStarting(Session arg1);

    void onSessionSuspended(Session arg1, int arg2);
}

