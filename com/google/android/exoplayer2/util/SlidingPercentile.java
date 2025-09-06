package com.google.android.exoplayer2.util;

import com.iloen.melon.utils.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SlidingPercentile {
    static class Sample {
        public int index;
        public float value;
        public int weight;

        private Sample() {
        }

        public Sample(com.google.android.exoplayer2.util.SlidingPercentile.1 slidingPercentile$10) {
        }
    }

    private static final Comparator INDEX_COMPARATOR = null;
    private static final int MAX_RECYCLED_SAMPLES = 5;
    private static final int SORT_ORDER_BY_INDEX = 1;
    private static final int SORT_ORDER_BY_VALUE = 0;
    private static final int SORT_ORDER_NONE = -1;
    private static final Comparator VALUE_COMPARATOR;
    private int currentSortOrder;
    private final int maxWeight;
    private int nextSampleIndex;
    private int recycledSampleCount;
    private final Sample[] recycledSamples;
    private final ArrayList samples;
    private int totalWeight;

    static {
        SlidingPercentile.INDEX_COMPARATOR = new b(0);
        SlidingPercentile.VALUE_COMPARATOR = new b(1);
    }

    public SlidingPercentile(int v) {
        this.maxWeight = v;
        this.recycledSamples = new Sample[5];
        this.samples = new ArrayList();
        this.currentSortOrder = -1;
    }

    public void addSample(int v, float f) {
        Sample slidingPercentile$Sample0;
        this.ensureSortedByIndex();
        int v1 = this.recycledSampleCount;
        if(v1 > 0) {
            this.recycledSampleCount = v1 - 1;
            slidingPercentile$Sample0 = this.recycledSamples[v1 - 1];
        }
        else {
            slidingPercentile$Sample0 = new Sample(null);
        }
        int v2 = this.nextSampleIndex;
        this.nextSampleIndex = v2 + 1;
        slidingPercentile$Sample0.index = v2;
        slidingPercentile$Sample0.weight = v;
        slidingPercentile$Sample0.value = f;
        this.samples.add(slidingPercentile$Sample0);
        this.totalWeight += v;
        while(true) {
            int v3 = this.totalWeight;
            int v4 = this.maxWeight;
            if(v3 <= v4) {
                break;
            }
            int v5 = v3 - v4;
            Sample slidingPercentile$Sample1 = (Sample)this.samples.get(0);
            int v6 = slidingPercentile$Sample1.weight;
            if(v6 <= v5) {
                this.totalWeight -= v6;
                this.samples.remove(0);
                int v7 = this.recycledSampleCount;
                if(v7 >= 5) {
                    continue;
                }
                this.recycledSampleCount = v7 + 1;
                this.recycledSamples[v7] = slidingPercentile$Sample1;
            }
            else {
                slidingPercentile$Sample1.weight = v6 - v5;
                this.totalWeight -= v5;
            }
        }
    }

    private void ensureSortedByIndex() {
        if(this.currentSortOrder != 1) {
            Collections.sort(this.samples, SlidingPercentile.INDEX_COMPARATOR);
            this.currentSortOrder = 1;
        }
    }

    private void ensureSortedByValue() {
        if(this.currentSortOrder != 0) {
            Collections.sort(this.samples, SlidingPercentile.VALUE_COMPARATOR);
            this.currentSortOrder = 0;
        }
    }

    public float getPercentile(float f) {
        this.ensureSortedByValue();
        float f1 = f * ((float)this.totalWeight);
        int v1 = 0;
        for(int v = 0; v < this.samples.size(); ++v) {
            Sample slidingPercentile$Sample0 = (Sample)this.samples.get(v);
            v1 += slidingPercentile$Sample0.weight;
            if(((float)v1) >= f1) {
                return slidingPercentile$Sample0.value;
            }
        }
        return this.samples.isEmpty() ? NaNf : ((Sample)a.i(1, this.samples)).value;
    }

    private static int lambda$static$0(Sample slidingPercentile$Sample0, Sample slidingPercentile$Sample1) {
        return slidingPercentile$Sample0.index - slidingPercentile$Sample1.index;
    }

    private static int lambda$static$1(Sample slidingPercentile$Sample0, Sample slidingPercentile$Sample1) {
        return Float.compare(slidingPercentile$Sample0.value, slidingPercentile$Sample1.value);
    }

    public void reset() {
        this.samples.clear();
        this.currentSortOrder = -1;
        this.nextSampleIndex = 0;
        this.totalWeight = 0;
    }

    class com.google.android.exoplayer2.util.SlidingPercentile.1 {
    }

}

