package com.iloen.melon.playback;

public class PrepareOverTimeException extends MPException {
    private int networkConnectionType;
    private static final long serialVersionUID = 1L;

    public PrepareOverTimeException(Playable playable0, String s, int v) {
        super(playable0, s);
        this.networkConnectionType = v;
    }

    public PrepareOverTimeException(Playable playable0, String s, Exception exception0, int v) {
        super(playable0, s, exception0);
        this.networkConnectionType = v;
    }

    public String getBaseMessage() {
        return super.getMessage();
    }

    @Override
    public String getMessage() {
        return this.getNetworkType() + "/" + this.getBaseMessage();
    }

    public String getNetworkType() {
        int v = this.networkConnectionType;
        if(v == 1) {
            return "Mobile";
        }
        return v == 2 ? "Wifi" : "No Connection";
    }
}

