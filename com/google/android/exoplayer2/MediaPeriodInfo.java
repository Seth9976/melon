package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.util.Util;

final class MediaPeriodInfo {
    public final long contentPositionUs;
    public final long durationUs;
    public final long endPositionUs;
    public final MediaPeriodId id;
    public final boolean isFinal;
    public final boolean isLastInTimelinePeriod;
    public final long startPositionUs;

    public MediaPeriodInfo(MediaPeriodId mediaSource$MediaPeriodId0, long v, long v1, long v2, long v3, boolean z, boolean z1) {
        this.id = mediaSource$MediaPeriodId0;
        this.startPositionUs = v;
        this.contentPositionUs = v1;
        this.endPositionUs = v2;
        this.durationUs = v3;
        this.isLastInTimelinePeriod = z;
        this.isFinal = z1;
    }

    public MediaPeriodInfo copyWithContentPositionUs(long v) {
        return v == this.contentPositionUs ? this : new MediaPeriodInfo(this.id, this.startPositionUs, v, this.endPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
    }

    public MediaPeriodInfo copyWithStartPositionUs(long v) {
        return v == this.startPositionUs ? this : new MediaPeriodInfo(this.id, v, this.contentPositionUs, this.endPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return MediaPeriodInfo.class == class0 && this.startPositionUs == ((MediaPeriodInfo)object0).startPositionUs && this.contentPositionUs == ((MediaPeriodInfo)object0).contentPositionUs && this.endPositionUs == ((MediaPeriodInfo)object0).endPositionUs && this.durationUs == ((MediaPeriodInfo)object0).durationUs && this.isLastInTimelinePeriod == ((MediaPeriodInfo)object0).isLastInTimelinePeriod && this.isFinal == ((MediaPeriodInfo)object0).isFinal && Util.areEqual(this.id, ((MediaPeriodInfo)object0).id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ((((((this.id.hashCode() + 0x20F) * 0x1F + ((int)this.startPositionUs)) * 0x1F + ((int)this.contentPositionUs)) * 0x1F + ((int)this.endPositionUs)) * 0x1F + ((int)this.durationUs)) * 0x1F + this.isLastInTimelinePeriod) * 0x1F + this.isFinal;
    }
}

