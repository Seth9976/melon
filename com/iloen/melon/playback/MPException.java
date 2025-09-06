package com.iloen.melon.playback;

public class MPException extends Exception {
    long playTime;
    Playable playable;
    private static final long serialVersionUID = 1L;

    public MPException(Playable playable0, String s) {
        this(playable0, s, null);
    }

    public MPException(Playable playable0, String s, Exception exception0) {
        super(s, exception0);
        this.playable = playable0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Error { ");
        Throwable throwable0 = this.getCause();
        if(throwable0 == null) {
            stringBuilder0.append(this.getMessage());
        }
        else {
            stringBuilder0.append(throwable0.getMessage());
        }
        stringBuilder0.append(", ");
        stringBuilder0.append("playTime=");
        stringBuilder0.append(this.playTime);
        stringBuilder0.append(", playable=");
        stringBuilder0.append(this.playable);
        stringBuilder0.append(" }");
        return stringBuilder0.toString();
    }
}

