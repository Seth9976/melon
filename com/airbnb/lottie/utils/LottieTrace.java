package com.airbnb.lottie.utils;

import U4.x;
import android.os.Trace;
import com.iloen.melon.utils.a;

public class LottieTrace {
    private static final int MAX_DEPTH = 5;
    private int depthPastMaxDepth;
    private final String[] sections;
    private final long[] startTimeNs;
    private int traceDepth;

    public LottieTrace() {
        this.sections = new String[5];
        this.startTimeNs = new long[5];
        this.traceDepth = 0;
        this.depthPastMaxDepth = 0;
    }

    public void beginSection(String s) {
        int v = this.traceDepth;
        if(v == 5) {
            ++this.depthPastMaxDepth;
            return;
        }
        this.sections[v] = s;
        this.startTimeNs[v] = System.nanoTime();
        Trace.beginSection(s);
        ++this.traceDepth;
    }

    public float endSection(String s) {
        int v = this.depthPastMaxDepth;
        if(v > 0) {
            this.depthPastMaxDepth = v - 1;
            return 0.0f;
        }
        int v1 = this.traceDepth - 1;
        this.traceDepth = v1;
        if(v1 == -1) {
            throw new IllegalStateException("Can\'t end trace section. There are none.");
        }
        if(!s.equals(this.sections[v1])) {
            throw new IllegalStateException(x.m(a.n("Unbalanced trace call ", s, ". Expected "), this.sections[this.traceDepth], "."));
        }
        Trace.endSection();
        return ((float)(System.nanoTime() - this.startTimeNs[this.traceDepth])) / 1000000.0f;
    }
}

