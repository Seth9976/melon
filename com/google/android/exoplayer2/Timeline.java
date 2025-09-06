package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.ads.AdPlaybackState.AdGroup;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public abstract class Timeline {
    public static final class Period {
        private AdPlaybackState adPlaybackState;
        public long durationUs;
        public Object id;
        private long positionInWindowUs;
        public Object uid;
        public int windowIndex;

        public Period() {
            this.adPlaybackState = AdPlaybackState.NONE;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 != null) {
                Class class0 = object0.getClass();
                return Period.class.equals(class0) && Util.areEqual(this.id, ((Period)object0).id) && Util.areEqual(this.uid, ((Period)object0).uid) && this.windowIndex == ((Period)object0).windowIndex && this.durationUs == ((Period)object0).durationUs && this.positionInWindowUs == ((Period)object0).positionInWindowUs && Util.areEqual(this.adPlaybackState, ((Period)object0).adPlaybackState);
            }
            return false;
        }

        public int getAdCountInAdGroup(int v) {
            return this.adPlaybackState.adGroups[v].count;
        }

        public long getAdDurationUs(int v, int v1) {
            AdGroup adPlaybackState$AdGroup0 = this.adPlaybackState.adGroups[v];
            return adPlaybackState$AdGroup0.count == -1 ? 0x8000000000000001L : adPlaybackState$AdGroup0.durationsUs[v1];
        }

        public int getAdGroupCount() {
            return this.adPlaybackState.adGroupCount;
        }

        public int getAdGroupIndexAfterPositionUs(long v) {
            return this.adPlaybackState.getAdGroupIndexAfterPositionUs(v, this.durationUs);
        }

        public int getAdGroupIndexForPositionUs(long v) {
            return this.adPlaybackState.getAdGroupIndexForPositionUs(v, this.durationUs);
        }

        public long getAdGroupTimeUs(int v) {
            return this.adPlaybackState.adGroupTimesUs[v];
        }

        public long getAdResumePositionUs() {
            return this.adPlaybackState.adResumePositionUs;
        }

        public long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public int getFirstAdIndexToPlay(int v) {
            return this.adPlaybackState.adGroups[v].getFirstAdIndexToPlay();
        }

        public int getNextAdIndexToPlay(int v, int v1) {
            return this.adPlaybackState.adGroups[v].getNextAdIndexToPlay(v1);
        }

        public long getPositionInWindowMs() {
            return C.usToMs(this.positionInWindowUs);
        }

        public long getPositionInWindowUs() {
            return this.positionInWindowUs;
        }

        public boolean hasPlayedAdGroup(int v) {
            return !this.adPlaybackState.adGroups[v].hasUnplayedAds();
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = ((((((this.id == null ? 0 : this.id.hashCode()) + 0xD9) * 0x1F + (this.uid == null ? 0 : this.uid.hashCode())) * 0x1F + this.windowIndex) * 0x1F + ((int)(this.durationUs ^ this.durationUs >>> 0x20))) * 0x1F + ((int)(this.positionInWindowUs ^ this.positionInWindowUs >>> 0x20))) * 0x1F;
            AdPlaybackState adPlaybackState0 = this.adPlaybackState;
            if(adPlaybackState0 != null) {
                v = adPlaybackState0.hashCode();
            }
            return v1 + v;
        }

        public boolean isAdAvailable(int v, int v1) {
            AdGroup adPlaybackState$AdGroup0 = this.adPlaybackState.adGroups[v];
            return adPlaybackState$AdGroup0.count != -1 && adPlaybackState$AdGroup0.states[v1] != 0;
        }

        public Period set(Object object0, Object object1, int v, long v1, long v2) {
            return this.set(object0, object1, v, v1, v2, AdPlaybackState.NONE);
        }

        public Period set(Object object0, Object object1, int v, long v1, long v2, AdPlaybackState adPlaybackState0) {
            this.id = object0;
            this.uid = object1;
            this.windowIndex = v;
            this.durationUs = v1;
            this.positionInWindowUs = v2;
            this.adPlaybackState = adPlaybackState0;
            return this;
        }
    }

    public static final class Window {
        public static final Object SINGLE_WINDOW_UID;
        public long defaultPositionUs;
        public long durationUs;
        public int firstPeriodIndex;
        public boolean isDynamic;
        public boolean isLive;
        public boolean isSeekable;
        public int lastPeriodIndex;
        public Object manifest;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;
        public Object tag;
        public Object uid;
        public long windowStartTimeMs;

        static {
            Window.SINGLE_WINDOW_UID = new Object();
        }

        public Window() {
            this.uid = Window.SINGLE_WINDOW_UID;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 != null) {
                Class class0 = object0.getClass();
                return Window.class.equals(class0) && Util.areEqual(this.uid, ((Window)object0).uid) && Util.areEqual(this.tag, ((Window)object0).tag) && Util.areEqual(this.manifest, ((Window)object0).manifest) && this.presentationStartTimeMs == ((Window)object0).presentationStartTimeMs && this.windowStartTimeMs == ((Window)object0).windowStartTimeMs && this.isSeekable == ((Window)object0).isSeekable && this.isDynamic == ((Window)object0).isDynamic && this.isLive == ((Window)object0).isLive && this.defaultPositionUs == ((Window)object0).defaultPositionUs && this.durationUs == ((Window)object0).durationUs && this.firstPeriodIndex == ((Window)object0).firstPeriodIndex && this.lastPeriodIndex == ((Window)object0).lastPeriodIndex && this.positionInFirstPeriodUs == ((Window)object0).positionInFirstPeriodUs;
            }
            return false;
        }

        public long getDefaultPositionMs() {
            return C.usToMs(this.defaultPositionUs);
        }

        public long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public long getPositionInFirstPeriodMs() {
            return C.usToMs(this.positionInFirstPeriodUs);
        }

        public long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }

        @Override
        public int hashCode() {
            int v = this.uid.hashCode();
            int v1 = 0;
            int v2 = this.tag == null ? 0 : this.tag.hashCode();
            Object object0 = this.manifest;
            if(object0 != null) {
                v1 = object0.hashCode();
            }
            return ((((((((((((v + 0xD9) * 0x1F + v2) * 0x1F + v1) * 0x1F + ((int)(this.presentationStartTimeMs ^ this.presentationStartTimeMs >>> 0x20))) * 0x1F + ((int)(this.windowStartTimeMs ^ this.windowStartTimeMs >>> 0x20))) * 0x1F + this.isSeekable) * 0x1F + this.isDynamic) * 0x1F + this.isLive) * 0x1F + ((int)(this.defaultPositionUs ^ this.defaultPositionUs >>> 0x20))) * 0x1F + ((int)(this.durationUs ^ this.durationUs >>> 0x20))) * 0x1F + this.firstPeriodIndex) * 0x1F + this.lastPeriodIndex) * 0x1F + ((int)(this.positionInFirstPeriodUs ^ this.positionInFirstPeriodUs >>> 0x20));
        }

        public Window set(Object object0, Object object1, Object object2, long v, long v1, boolean z, boolean z1, boolean z2, long v2, long v3, int v4, int v5, long v6) {
            this.uid = object0;
            this.tag = object1;
            this.manifest = object2;
            this.presentationStartTimeMs = v;
            this.windowStartTimeMs = v1;
            this.isSeekable = z;
            this.isDynamic = z1;
            this.isLive = z2;
            this.defaultPositionUs = v2;
            this.durationUs = v3;
            this.firstPeriodIndex = v4;
            this.lastPeriodIndex = v5;
            this.positionInFirstPeriodUs = v6;
            return this;
        }
    }

    public static final Timeline EMPTY;

    static {
        Timeline.EMPTY = new Timeline() {
            @Override  // com.google.android.exoplayer2.Timeline
            public int getIndexOfPeriod(Object object0) {
                return -1;
            }

            @Override  // com.google.android.exoplayer2.Timeline
            public Period getPeriod(int v, Period timeline$Period0, boolean z) {
                throw new IndexOutOfBoundsException();
            }

            @Override  // com.google.android.exoplayer2.Timeline
            public int getPeriodCount() {
                return 0;
            }

            @Override  // com.google.android.exoplayer2.Timeline
            public Object getUidOfPeriod(int v) {
                throw new IndexOutOfBoundsException();
            }

            @Override  // com.google.android.exoplayer2.Timeline
            public Window getWindow(int v, Window timeline$Window0, long v1) {
                throw new IndexOutOfBoundsException();
            }

            @Override  // com.google.android.exoplayer2.Timeline
            public int getWindowCount() {
                return 0;
            }
        };
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Timeline)) {
            return false;
        }
        if(((Timeline)object0).getWindowCount() == this.getWindowCount() && ((Timeline)object0).getPeriodCount() == this.getPeriodCount()) {
            Window timeline$Window0 = new Window();
            Period timeline$Period0 = new Period();
            Window timeline$Window1 = new Window();
            Period timeline$Period1 = new Period();
            for(int v = 0; v < this.getWindowCount(); ++v) {
                if(!this.getWindow(v, timeline$Window0).equals(((Timeline)object0).getWindow(v, timeline$Window1))) {
                    return false;
                }
            }
            for(int v1 = 0; v1 < this.getPeriodCount(); ++v1) {
                if(!this.getPeriod(v1, timeline$Period0, true).equals(((Timeline)object0).getPeriod(v1, timeline$Period1, true))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    // 去混淆评级： 低(20)
    public int getFirstWindowIndex(boolean z) {
        return this.isEmpty() ? -1 : 0;
    }

    public abstract int getIndexOfPeriod(Object arg1);

    // 去混淆评级： 低(20)
    public int getLastWindowIndex(boolean z) {
        return this.isEmpty() ? -1 : this.getWindowCount() - 1;
    }

    public final int getNextPeriodIndex(int v, Period timeline$Period0, Window timeline$Window0, int v1, boolean z) {
        int v2 = this.getPeriod(v, timeline$Period0).windowIndex;
        if(this.getWindow(v2, timeline$Window0).lastPeriodIndex == v) {
            int v3 = this.getNextWindowIndex(v2, v1, z);
            return v3 == -1 ? -1 : this.getWindow(v3, timeline$Window0).firstPeriodIndex;
        }
        return v + 1;
    }

    public int getNextWindowIndex(int v, int v1, boolean z) {
        switch(v1) {
            case 0: {
                return v == this.getLastWindowIndex(z) ? -1 : v + 1;
            }
            case 1: {
                return v;
            }
            default: {
                if(v1 != 2) {
                    throw new IllegalStateException();
                }
                return v == this.getLastWindowIndex(z) ? this.getFirstWindowIndex(z) : v + 1;
            }
        }
    }

    public final Period getPeriod(int v, Period timeline$Period0) {
        return this.getPeriod(v, timeline$Period0, false);
    }

    public abstract Period getPeriod(int arg1, Period arg2, boolean arg3);

    public Period getPeriodByUid(Object object0, Period timeline$Period0) {
        return this.getPeriod(this.getIndexOfPeriod(object0), timeline$Period0, true);
    }

    public abstract int getPeriodCount();

    public final Pair getPeriodPosition(Window timeline$Window0, Period timeline$Period0, int v, long v1) {
        return (Pair)Assertions.checkNotNull(this.getPeriodPosition(timeline$Window0, timeline$Period0, v, v1, 0L));
    }

    public final Pair getPeriodPosition(Window timeline$Window0, Period timeline$Period0, int v, long v1, long v2) {
        Assertions.checkIndex(v, 0, this.getWindowCount());
        this.getWindow(v, timeline$Window0, v2);
        if(v1 == 0x8000000000000001L) {
            v1 = timeline$Window0.getDefaultPositionUs();
            if(v1 == 0x8000000000000001L) {
                return null;
            }
        }
        int v3 = timeline$Window0.firstPeriodIndex;
        long v4 = timeline$Window0.getPositionInFirstPeriodUs() + v1;
        for(long v5 = this.getPeriod(v3, timeline$Period0, true).getDurationUs(); v5 != 0x8000000000000001L && v4 >= v5 && v3 < timeline$Window0.lastPeriodIndex; v5 = this.getPeriod(v3, timeline$Period0, true).getDurationUs()) {
            v4 -= v5;
            ++v3;
        }
        return Pair.create(Assertions.checkNotNull(timeline$Period0.uid), v4);
    }

    public int getPreviousWindowIndex(int v, int v1, boolean z) {
        switch(v1) {
            case 0: {
                return v == this.getFirstWindowIndex(z) ? -1 : v - 1;
            }
            case 1: {
                return v;
            }
            default: {
                if(v1 != 2) {
                    throw new IllegalStateException();
                }
                return v == this.getFirstWindowIndex(z) ? this.getLastWindowIndex(z) : v - 1;
            }
        }
    }

    public abstract Object getUidOfPeriod(int arg1);

    public final Window getWindow(int v, Window timeline$Window0) {
        return this.getWindow(v, timeline$Window0, 0L);
    }

    public abstract Window getWindow(int arg1, Window arg2, long arg3);

    @Deprecated
    public final Window getWindow(int v, Window timeline$Window0, boolean z) {
        return this.getWindow(v, timeline$Window0, 0L);
    }

    public abstract int getWindowCount();

    @Override
    public int hashCode() {
        Window timeline$Window0 = new Window();
        Period timeline$Period0 = new Period();
        int v = this.getWindowCount() + 0xD9;
        for(int v2 = 0; v2 < this.getWindowCount(); ++v2) {
            v = v * 0x1F + this.getWindow(v2, timeline$Window0).hashCode();
        }
        int v3 = this.getPeriodCount() + v * 0x1F;
        for(int v1 = 0; v1 < this.getPeriodCount(); ++v1) {
            v3 = v3 * 0x1F + this.getPeriod(v1, timeline$Period0, true).hashCode();
        }
        return v3;
    }

    public final boolean isEmpty() {
        return this.getWindowCount() == 0;
    }

    public final boolean isLastPeriod(int v, Period timeline$Period0, Window timeline$Window0, int v1, boolean z) {
        return this.getNextPeriodIndex(v, timeline$Period0, timeline$Window0, v1, z) == -1;
    }
}

