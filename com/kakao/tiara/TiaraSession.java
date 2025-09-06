package com.kakao.tiara;

import android.os.SystemClock;

final class TiaraSession {
    interface SessionCallback {
        void onStartNewSession(SessionIds arg1);
    }

    private boolean isForeground;
    private boolean isHeld;
    private long lastActTime;
    private SessionCallback sessionCallback;
    private SessionIds sessionIds;
    private long timeout;

    public TiaraSession(SessionCallback tiaraSession$SessionCallback0, int v) {
        this.sessionIds = SessionIds.generateNewIds();
        this.sessionCallback = tiaraSession$SessionCallback0;
        this.timeout = (long)(v * 1000);
        this.lastActTime = SystemClock.elapsedRealtime();
        this.isForeground = false;
        this.isHeld = false;
    }

    public SessionIds getSessionIds() {
        synchronized(this) {
        }
        return this.sessionIds;
    }

    public void hold() {
        synchronized(this) {
            if(this.isHeld) {
                return;
            }
            this.startNewSessionIfExpired();
            this.isHeld = true;
        }
    }

    private boolean isExpired() {
        return SystemClock.elapsedRealtime() - this.lastActTime > this.timeout;
    }

    public void onBackground() {
        synchronized(this) {
            this.updateLastActTime();
            this.isForeground = false;
        }
    }

    public void onForeground() {
        synchronized(this) {
            this.startNewSessionIfExpired();
            this.isForeground = true;
        }
    }

    public void release() {
        synchronized(this) {
            if(!this.isHeld) {
                return;
            }
            this.updateLastActTime();
            this.isHeld = false;
        }
    }

    private void startNewSession() {
        SessionIds sessionIds0 = SessionIds.generateNewIds();
        this.sessionIds = sessionIds0;
        this.sessionCallback.onStartNewSession(sessionIds0);
    }

    public void startNewSessionIfExpired() {
        synchronized(this) {
            if(!this.isForeground && !this.isHeld) {
                if(this.isExpired()) {
                    this.startNewSession();
                }
                this.updateLastActTime();
            }
        }
    }

    private void updateLastActTime() {
        this.lastActTime = SystemClock.elapsedRealtime();
    }
}

