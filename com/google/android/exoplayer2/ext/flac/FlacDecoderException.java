package com.google.android.exoplayer2.ext.flac;

import com.google.android.exoplayer2.audio.AudioDecoderException;

public final class FlacDecoderException extends AudioDecoderException {
    public FlacDecoderException(String s) {
        super(s);
    }

    public FlacDecoderException(String s, Throwable throwable0) {
        super(s, throwable0);
    }
}

