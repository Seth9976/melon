package com.google.android.exoplayer2.source.hls.playlist;

import b3.Z;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

public final class HlsMediaPlaylist extends HlsPlaylist {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaylistType {
    }

    public static final class Segment implements Comparable {
        public final long byterangeLength;
        public final long byterangeOffset;
        public final DrmInitData drmInitData;
        public final long durationUs;
        public final String encryptionIV;
        public final String fullSegmentEncryptionKeyUri;
        public final boolean hasGapTag;
        public final Segment initializationSegment;
        public final int relativeDiscontinuitySequence;
        public final long relativeStartTimeUs;
        public final String title;
        public final String url;

        public Segment(String s, long v, long v1, String s1, String s2) {
            this(s, null, "", 0L, -1, 0x8000000000000001L, null, s1, s2, v, v1, false);
        }

        public Segment(String s, Segment hlsMediaPlaylist$Segment0, String s1, long v, int v1, long v2, DrmInitData drmInitData0, String s2, String s3, long v3, long v4, boolean z) {
            this.url = s;
            this.initializationSegment = hlsMediaPlaylist$Segment0;
            this.title = s1;
            this.durationUs = v;
            this.relativeDiscontinuitySequence = v1;
            this.relativeStartTimeUs = v2;
            this.drmInitData = drmInitData0;
            this.fullSegmentEncryptionKeyUri = s2;
            this.encryptionIV = s3;
            this.byterangeOffset = v3;
            this.byterangeLength = v4;
            this.hasGapTag = z;
        }

        public int compareTo(Long long0) {
            if(this.relativeStartTimeUs > ((long)long0)) {
                return 1;
            }
            return this.relativeStartTimeUs >= ((long)long0) ? 0 : -1;
        }

        @Override
        public int compareTo(Object object0) {
            return this.compareTo(((Long)object0));
        }
    }

    public static final int PLAYLIST_TYPE_EVENT = 2;
    public static final int PLAYLIST_TYPE_UNKNOWN = 0;
    public static final int PLAYLIST_TYPE_VOD = 1;
    public final int discontinuitySequence;
    public final long durationUs;
    public final boolean hasDiscontinuitySequence;
    public final boolean hasEndTag;
    public final boolean hasProgramDateTime;
    public final long mediaSequence;
    public final int playlistType;
    public final DrmInitData protectionSchemes;
    public final List segments;
    public final long startOffsetUs;
    public final long startTimeUs;
    public final long targetDurationUs;
    public final int version;

    public HlsMediaPlaylist(int v, String s, List list0, long v1, long v2, boolean z, int v3, long v4, int v5, long v6, boolean z1, boolean z2, boolean z3, DrmInitData drmInitData0, List list1) {
        super(s, list0, z1);
        this.playlistType = v;
        this.startTimeUs = v2;
        this.hasDiscontinuitySequence = z;
        this.discontinuitySequence = v3;
        this.mediaSequence = v4;
        this.version = v5;
        this.targetDurationUs = v6;
        this.hasEndTag = z2;
        this.hasProgramDateTime = z3;
        this.protectionSchemes = drmInitData0;
        this.segments = Collections.unmodifiableList(list1);
        if(list1.isEmpty()) {
            this.durationUs = 0L;
        }
        else {
            Segment hlsMediaPlaylist$Segment0 = (Segment)Z.h(1, list1);
            this.durationUs = hlsMediaPlaylist$Segment0.relativeStartTimeUs + hlsMediaPlaylist$Segment0.durationUs;
        }
        if(v1 == 0x8000000000000001L) {
            v1 = 0x8000000000000001L;
        }
        else if(v1 < 0L) {
            v1 += this.durationUs;
        }
        this.startOffsetUs = v1;
    }

    public HlsMediaPlaylist copy(List list0) [...] // Inlined contents

    @Override  // com.google.android.exoplayer2.offline.FilterableManifest
    public Object copy(List list0) {
        return this;
    }

    public HlsMediaPlaylist copyWith(long v, int v1) {
        return new HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, v, true, v1, this.mediaSequence, this.version, this.targetDurationUs, this.hasIndependentSegments, this.hasEndTag, this.hasProgramDateTime, this.protectionSchemes, this.segments);
    }

    // 去混淆评级： 低(20)
    public HlsMediaPlaylist copyWithEndTag() {
        return this.hasEndTag ? this : new HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, this.startTimeUs, this.hasDiscontinuitySequence, this.discontinuitySequence, this.mediaSequence, this.version, this.targetDurationUs, this.hasIndependentSegments, true, this.hasProgramDateTime, this.protectionSchemes, this.segments);
    }

    public long getEndTimeUs() {
        return this.startTimeUs + this.durationUs;
    }

    public boolean isNewerThan(HlsMediaPlaylist hlsMediaPlaylist0) {
        if(hlsMediaPlaylist0 != null) {
            long v = this.mediaSequence;
            long v1 = hlsMediaPlaylist0.mediaSequence;
            if(v <= v1) {
                if(Long.compare(v, v1) < 0) {
                    return false;
                }
                int v2 = this.segments.size();
                int v3 = hlsMediaPlaylist0.segments.size();
                return v2 > v3 || v2 == v3 && this.hasEndTag && !hlsMediaPlaylist0.hasEndTag;
            }
        }
        return true;
    }
}

