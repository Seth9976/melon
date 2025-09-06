package com.iloen.melon.net;

import com.android.volley.VolleyError;

public class ServerResponseError extends VolleyError {
    private String errorCode;
    private boolean messageFromServer;

    public ServerResponseError() {
    }

    public ServerResponseError(String s) {
        this(s, false);
    }

    public ServerResponseError(String s, String s1) {
        super(s);
        this.messageFromServer = true;
        this.errorCode = s1;
    }

    public ServerResponseError(String s, boolean z) {
        super(s);
        this.messageFromServer = z;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public boolean isMessageFromServer() {
        return this.messageFromServer;
    }
}

