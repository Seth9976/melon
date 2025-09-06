package com.iloen.melon.utils.time;

import com.iloen.melon.utils.a;
import com.iloen.melon.utils.log.LogU;

public class LapTime {
    public final String a;
    public long b;
    public long c;
    public long d;
    public long e;

    public LapTime(String s) {
        this.a = s;
    }

    public LapTime(String s, long v) {
        this.a = s;
        this.start(v, 0L);
    }

    public long getLastElapsedTime() {
        return this.c;
    }

    public long getLastLapTime() {
        return this.d;
    }

    public long getStartTime() {
        return this.b;
    }

    public long getTotalElapsedTime() {
        return this.d - this.b + this.e;
    }

    public LapTime lap(long v) {
        if(this.b <= v) {
            this.c = v - this.d;
            this.d = v;
            return this;
        }
        StringBuilder stringBuilder0 = new StringBuilder("startTime is bigger than lapTime - start:");
        stringBuilder0.append(this.b);
        a.s(v, ", current:", ", tag:", stringBuilder0);
        stringBuilder0.append(this.a);
        LogU.e("LapTime", stringBuilder0.toString());
        this.start(v, this.e);
        return this;
    }

    public void reset() {
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
    }

    public void setElapsedTimeAddition(long v) {
        LogU.v("LapTime", "[" + this.a + "] setElapsedTimeAddition: " + v);
        this.e = v;
    }

    public LapTime start(long v, long v1) {
        if(v < 0L) {
            v = 0L;
        }
        this.b = v;
        this.d = v;
        this.setElapsedTimeAddition(v1);
        return this;
    }

    @Override
    public String toString() {
        return "LapTime {" + ("tag=" + this.a) + (",started=" + this.b) + (",lastLap=" + this.d) + (",lastElapsed=" + this.c) + (",elaseAddition=" + this.e) + (",totalElapsed=" + this.getTotalElapsedTime()) + "}";
    }
}

