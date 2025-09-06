package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;

public interface MediaSource {
    public static final class MediaPeriodId {
        public final int adGroupIndex;
        public final int adIndexInAdGroup;
        public final int nextAdGroupIndex;
        public final Object periodUid;
        public final long windowSequenceNumber;

        public MediaPeriodId(Object object0) {
            this(object0, -1L);
        }

        public MediaPeriodId(Object object0, int v, int v1, long v2) {
            this(object0, v, v1, v2, -1);
        }

        private MediaPeriodId(Object object0, int v, int v1, long v2, int v3) {
            this.periodUid = object0;
            this.adGroupIndex = v;
            this.adIndexInAdGroup = v1;
            this.windowSequenceNumber = v2;
            this.nextAdGroupIndex = v3;
        }

        public MediaPeriodId(Object object0, long v) {
            this(object0, -1, -1, v, -1);
        }

        public MediaPeriodId(Object object0, long v, int v1) {
            this(object0, -1, -1, v, v1);
        }

        // 去混淆评级： 低(20)
        public MediaPeriodId copyWithPeriodUid(Object object0) {
            return this.periodUid.equals(object0) ? this : new MediaPeriodId(object0, this.adGroupIndex, this.adIndexInAdGroup, this.windowSequenceNumber, this.nextAdGroupIndex);
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 != null) {
                Class class0 = object0.getClass();
                return MediaPeriodId.class == class0 && this.periodUid.equals(((MediaPeriodId)object0).periodUid) && this.adGroupIndex == ((MediaPeriodId)object0).adGroupIndex && this.adIndexInAdGroup == ((MediaPeriodId)object0).adIndexInAdGroup && this.windowSequenceNumber == ((MediaPeriodId)object0).windowSequenceNumber && this.nextAdGroupIndex == ((MediaPeriodId)object0).nextAdGroupIndex;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return ((((this.periodUid.hashCode() + 0x20F) * 0x1F + this.adGroupIndex) * 0x1F + this.adIndexInAdGroup) * 0x1F + ((int)this.windowSequenceNumber)) * 0x1F + this.nextAdGroupIndex;
        }

        public boolean isAd() {
            return this.adGroupIndex != -1;
        }
    }

    public interface MediaSourceCaller {
        void onSourceInfoRefreshed(MediaSource arg1, Timeline arg2);
    }

    void addEventListener(Handler arg1, MediaSourceEventListener arg2);

    MediaPeriod createPeriod(MediaPeriodId arg1, Allocator arg2, long arg3);

    void disable(MediaSourceCaller arg1);

    void enable(MediaSourceCaller arg1);

    default Object getTag() {
        return null;
    }

    void maybeThrowSourceInfoRefreshError();

    void prepareSource(MediaSourceCaller arg1, TransferListener arg2);

    void releasePeriod(MediaPeriod arg1);

    void releaseSource(MediaSourceCaller arg1);

    void removeEventListener(MediaSourceEventListener arg1);
}

