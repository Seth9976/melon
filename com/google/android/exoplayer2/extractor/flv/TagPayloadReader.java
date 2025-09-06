package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

abstract class TagPayloadReader {
    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String s) {
            super(s);
        }
    }

    protected final TrackOutput output;

    public TagPayloadReader(TrackOutput trackOutput0) {
        this.output = trackOutput0;
    }

    // 去混淆评级： 低(20)
    public final boolean consume(ParsableByteArray parsableByteArray0, long v) {
        return this.parseHeader(parsableByteArray0) && this.parsePayload(parsableByteArray0, v);
    }

    public abstract boolean parseHeader(ParsableByteArray arg1);

    public abstract boolean parsePayload(ParsableByteArray arg1, long arg2);

    public abstract void seek();
}

