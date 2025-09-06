package com.google.android.exoplayer2;

public final class RendererConfiguration {
    public static final RendererConfiguration DEFAULT;
    public final int tunnelingAudioSessionId;

    static {
        RendererConfiguration.DEFAULT = new RendererConfiguration(0);
    }

    public RendererConfiguration(int v) {
        this.tunnelingAudioSessionId = v;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return RendererConfiguration.class == class0 && this.tunnelingAudioSessionId == ((RendererConfiguration)object0).tunnelingAudioSessionId;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.tunnelingAudioSessionId;
    }
}

