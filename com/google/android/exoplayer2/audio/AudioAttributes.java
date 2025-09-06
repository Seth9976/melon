package com.google.android.exoplayer2.audio;

import Qc.l;
import android.annotation.TargetApi;
import android.media.AudioAttributes.Builder;
import com.google.android.exoplayer2.util.Util;

public final class AudioAttributes {
    public static final class Builder {
        private int allowedCapturePolicy;
        private int contentType;
        private int flags;
        private int usage;

        public Builder() {
            this.contentType = 0;
            this.flags = 0;
            this.usage = 1;
            this.allowedCapturePolicy = 1;
        }

        public AudioAttributes build() {
            return new AudioAttributes(this.contentType, this.flags, this.usage, this.allowedCapturePolicy, null);
        }

        public Builder setAllowedCapturePolicy(int v) {
            this.allowedCapturePolicy = v;
            return this;
        }

        public Builder setContentType(int v) {
            this.contentType = v;
            return this;
        }

        public Builder setFlags(int v) {
            this.flags = v;
            return this;
        }

        public Builder setUsage(int v) {
            this.usage = v;
            return this;
        }
    }

    public static final AudioAttributes DEFAULT;
    public final int allowedCapturePolicy;
    private android.media.AudioAttributes audioAttributesV21;
    public final int contentType;
    public final int flags;
    public final int usage;

    static {
        AudioAttributes.DEFAULT = new Builder().build();
    }

    private AudioAttributes(int v, int v1, int v2, int v3) {
        this.contentType = v;
        this.flags = v1;
        this.usage = v2;
        this.allowedCapturePolicy = v3;
    }

    public AudioAttributes(int v, int v1, int v2, int v3, com.google.android.exoplayer2.audio.AudioAttributes.1 audioAttributes$10) {
        this(v, v1, v2, v3);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return AudioAttributes.class == class0 && this.contentType == ((AudioAttributes)object0).contentType && this.flags == ((AudioAttributes)object0).flags && this.usage == ((AudioAttributes)object0).usage && this.allowedCapturePolicy == ((AudioAttributes)object0).allowedCapturePolicy;
        }
        return false;
    }

    @TargetApi(21)
    public android.media.AudioAttributes getAudioAttributesV21() {
        if(this.audioAttributesV21 == null) {
            AudioAttributes.Builder audioAttributes$Builder0 = new AudioAttributes.Builder().setContentType(this.contentType).setFlags(this.flags).setUsage(this.usage);
            if(Util.SDK_INT >= 29) {
                l.v(audioAttributes$Builder0, this.allowedCapturePolicy);
            }
            this.audioAttributesV21 = audioAttributes$Builder0.build();
        }
        return this.audioAttributesV21;
    }

    @Override
    public int hashCode() {
        return (((this.contentType + 0x20F) * 0x1F + this.flags) * 0x1F + this.usage) * 0x1F + this.allowedCapturePolicy;
    }

    class com.google.android.exoplayer2.audio.AudioAttributes.1 {
    }

}

