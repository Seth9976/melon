package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Track {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Transformation {
    }

    public static final int TRANSFORMATION_CEA608_CDAT = 1;
    public static final int TRANSFORMATION_NONE;
    public final long durationUs;
    public final long[] editListDurations;
    public final long[] editListMediaTimes;
    public final Format format;
    public final int id;
    public final long movieTimescale;
    public final int nalUnitLengthFieldLength;
    private final TrackEncryptionBox[] sampleDescriptionEncryptionBoxes;
    public final int sampleTransformation;
    public final long timescale;
    public final int type;

    public Track(int v, int v1, long v2, long v3, long v4, Format format0, int v5, TrackEncryptionBox[] arr_trackEncryptionBox, int v6, long[] arr_v, long[] arr_v1) {
        this.id = v;
        this.type = v1;
        this.timescale = v2;
        this.movieTimescale = v3;
        this.durationUs = v4;
        this.format = format0;
        this.sampleTransformation = v5;
        this.sampleDescriptionEncryptionBoxes = arr_trackEncryptionBox;
        this.nalUnitLengthFieldLength = v6;
        this.editListDurations = arr_v;
        this.editListMediaTimes = arr_v1;
    }

    public Track copyWithFormat(Format format0) {
        return new Track(this.id, this.type, this.timescale, this.movieTimescale, this.durationUs, format0, this.sampleTransformation, this.sampleDescriptionEncryptionBoxes, this.nalUnitLengthFieldLength, this.editListDurations, this.editListMediaTimes);
    }

    public TrackEncryptionBox getSampleDescriptionEncryptionBox(int v) {
        return this.sampleDescriptionEncryptionBoxes == null ? null : this.sampleDescriptionEncryptionBoxes[v];
    }
}

