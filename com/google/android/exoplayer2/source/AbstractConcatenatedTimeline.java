package com.google.android.exoplayer2.source;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;

abstract class AbstractConcatenatedTimeline extends Timeline {
    private final int childCount;
    private final boolean isAtomic;
    private final ShuffleOrder shuffleOrder;

    public AbstractConcatenatedTimeline(boolean z, ShuffleOrder shuffleOrder0) {
        this.isAtomic = z;
        this.shuffleOrder = shuffleOrder0;
        this.childCount = shuffleOrder0.getLength();
    }

    public abstract int getChildIndexByChildUid(Object arg1);

    public abstract int getChildIndexByPeriodIndex(int arg1);

    public abstract int getChildIndexByWindowIndex(int arg1);

    public static Object getChildPeriodUidFromConcatenatedUid(Object object0) {
        return ((Pair)object0).second;
    }

    public static Object getChildTimelineUidFromConcatenatedUid(Object object0) {
        return ((Pair)object0).first;
    }

    public abstract Object getChildUidByChildIndex(int arg1);

    public static Object getConcatenatedUid(Object object0, Object object1) {
        return Pair.create(object0, object1);
    }

    public abstract int getFirstPeriodIndexByChildIndex(int arg1);

    @Override  // com.google.android.exoplayer2.Timeline
    public int getFirstWindowIndex(boolean z) {
        int v = 0;
        if(this.childCount == 0) {
            return -1;
        }
        if(this.isAtomic) {
            z = false;
        }
        if(z) {
            v = this.shuffleOrder.getFirstIndex();
        }
        while(this.getTimelineByChildIndex(v).isEmpty()) {
            v = this.getNextChildIndex(v, z);
            if(v == -1) {
                return -1;
            }
            if(false) {
                break;
            }
        }
        int v1 = this.getFirstWindowIndexByChildIndex(v);
        return this.getTimelineByChildIndex(v).getFirstWindowIndex(z) + v1;
    }

    public abstract int getFirstWindowIndexByChildIndex(int arg1);

    @Override  // com.google.android.exoplayer2.Timeline
    public final int getIndexOfPeriod(Object object0) {
        if(!(object0 instanceof Pair)) {
            return -1;
        }
        Object object1 = AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(object0);
        Object object2 = AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(object0);
        int v = this.getChildIndexByChildUid(object1);
        if(v == -1) {
            return -1;
        }
        int v1 = this.getTimelineByChildIndex(v).getIndexOfPeriod(object2);
        return v1 == -1 ? -1 : this.getFirstPeriodIndexByChildIndex(v) + v1;
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public int getLastWindowIndex(boolean z) {
        int v = this.childCount;
        if(v == 0) {
            return -1;
        }
        if(this.isAtomic) {
            z = false;
        }
        int v1 = z ? this.shuffleOrder.getLastIndex() : v - 1;
        while(this.getTimelineByChildIndex(v1).isEmpty()) {
            v1 = this.getPreviousChildIndex(v1, z);
            if(v1 == -1) {
                return -1;
            }
            if(false) {
                break;
            }
        }
        int v2 = this.getFirstWindowIndexByChildIndex(v1);
        return this.getTimelineByChildIndex(v1).getLastWindowIndex(z) + v2;
    }

    private int getNextChildIndex(int v, boolean z) {
        if(z) {
            return this.shuffleOrder.getNextIndex(v);
        }
        return v >= this.childCount - 1 ? -1 : v + 1;
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public int getNextWindowIndex(int v, int v1, boolean z) {
        int v2 = 0;
        if(this.isAtomic) {
            if(v1 == 1) {
                v1 = 2;
            }
            z = false;
        }
        int v3 = this.getChildIndexByWindowIndex(v);
        int v4 = this.getFirstWindowIndexByChildIndex(v3);
        Timeline timeline0 = this.getTimelineByChildIndex(v3);
        if(v1 != 2) {
            v2 = v1;
        }
        int v5 = timeline0.getNextWindowIndex(v - v4, v2, z);
        if(v5 != -1) {
            return v4 + v5;
        }
        int v6;
        for(v6 = this.getNextChildIndex(v3, z); v6 != -1 && this.getTimelineByChildIndex(v6).isEmpty(); v6 = this.getNextChildIndex(v6, z)) {
        }
        if(v6 != -1) {
            int v7 = this.getFirstWindowIndexByChildIndex(v6);
            return this.getTimelineByChildIndex(v6).getFirstWindowIndex(z) + v7;
        }
        return v1 == 2 ? this.getFirstWindowIndex(z) : -1;
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public final Period getPeriod(int v, Period timeline$Period0, boolean z) {
        int v1 = this.getChildIndexByPeriodIndex(v);
        int v2 = this.getFirstWindowIndexByChildIndex(v1);
        int v3 = this.getFirstPeriodIndexByChildIndex(v1);
        this.getTimelineByChildIndex(v1).getPeriod(v - v3, timeline$Period0, z);
        timeline$Period0.windowIndex += v2;
        if(z) {
            timeline$Period0.uid = AbstractConcatenatedTimeline.getConcatenatedUid(this.getChildUidByChildIndex(v1), Assertions.checkNotNull(timeline$Period0.uid));
        }
        return timeline$Period0;
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public final Period getPeriodByUid(Object object0, Period timeline$Period0) {
        Object object1 = AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(object0);
        Object object2 = AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(object0);
        int v = this.getChildIndexByChildUid(object1);
        int v1 = this.getFirstWindowIndexByChildIndex(v);
        this.getTimelineByChildIndex(v).getPeriodByUid(object2, timeline$Period0);
        timeline$Period0.windowIndex += v1;
        timeline$Period0.uid = object0;
        return timeline$Period0;
    }

    private int getPreviousChildIndex(int v, boolean z) {
        if(z) {
            return this.shuffleOrder.getPreviousIndex(v);
        }
        return v <= 0 ? -1 : v - 1;
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public int getPreviousWindowIndex(int v, int v1, boolean z) {
        int v2 = 0;
        if(this.isAtomic) {
            if(v1 == 1) {
                v1 = 2;
            }
            z = false;
        }
        int v3 = this.getChildIndexByWindowIndex(v);
        int v4 = this.getFirstWindowIndexByChildIndex(v3);
        Timeline timeline0 = this.getTimelineByChildIndex(v3);
        if(v1 != 2) {
            v2 = v1;
        }
        int v5 = timeline0.getPreviousWindowIndex(v - v4, v2, z);
        if(v5 != -1) {
            return v4 + v5;
        }
        int v6;
        for(v6 = this.getPreviousChildIndex(v3, z); v6 != -1 && this.getTimelineByChildIndex(v6).isEmpty(); v6 = this.getPreviousChildIndex(v6, z)) {
        }
        if(v6 != -1) {
            int v7 = this.getFirstWindowIndexByChildIndex(v6);
            return this.getTimelineByChildIndex(v6).getLastWindowIndex(z) + v7;
        }
        return v1 == 2 ? this.getLastWindowIndex(z) : -1;
    }

    public abstract Timeline getTimelineByChildIndex(int arg1);

    @Override  // com.google.android.exoplayer2.Timeline
    public final Object getUidOfPeriod(int v) {
        int v1 = this.getChildIndexByPeriodIndex(v);
        int v2 = this.getFirstPeriodIndexByChildIndex(v1);
        Object object0 = this.getTimelineByChildIndex(v1).getUidOfPeriod(v - v2);
        return AbstractConcatenatedTimeline.getConcatenatedUid(this.getChildUidByChildIndex(v1), object0);
    }

    @Override  // com.google.android.exoplayer2.Timeline
    public final Window getWindow(int v, Window timeline$Window0, long v1) {
        int v2 = this.getChildIndexByWindowIndex(v);
        int v3 = this.getFirstWindowIndexByChildIndex(v2);
        int v4 = this.getFirstPeriodIndexByChildIndex(v2);
        this.getTimelineByChildIndex(v2).getWindow(v - v3, timeline$Window0, v1);
        Object object0 = this.getChildUidByChildIndex(v2);
        if(!Window.SINGLE_WINDOW_UID.equals(timeline$Window0.uid)) {
            object0 = AbstractConcatenatedTimeline.getConcatenatedUid(object0, timeline$Window0.uid);
        }
        timeline$Window0.uid = object0;
        timeline$Window0.firstPeriodIndex += v4;
        timeline$Window0.lastPeriodIndex += v4;
        return timeline$Window0;
    }
}

