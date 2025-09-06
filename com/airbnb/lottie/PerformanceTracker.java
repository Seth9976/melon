package com.airbnb.lottie;

import android.util.Log;
import androidx.collection.g;
import b2.b;
import com.airbnb.lottie.utils.MeanCalculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public class PerformanceTracker {
    public interface FrameListener {
        void onFrameRendered(float arg1);
    }

    private boolean enabled;
    private final Comparator floatComparator;
    private final Set frameListeners;
    private final Map layerRenderTimes;

    public PerformanceTracker() {
        this.enabled = false;
        this.frameListeners = new g(0);
        this.layerRenderTimes = new HashMap();
        this.floatComparator = new Comparator() {
            public int compare(b b0, b b1) {
                float f = (float)(((Float)b0.b));
                float f1 = (float)(((Float)b1.b));
                if(f1 > f) {
                    return 1;
                }
                return f > f1 ? -1 : 0;
            }

            @Override
            public int compare(Object object0, Object object1) {
                return this.compare(((b)object0), ((b)object1));
            }
        };
    }

    public void addFrameListener(FrameListener performanceTracker$FrameListener0) {
        this.frameListeners.add(performanceTracker$FrameListener0);
    }

    public void clearRenderTimes() {
        this.layerRenderTimes.clear();
    }

    public List getSortedRenderTimes() {
        if(!this.enabled) {
            return Collections.EMPTY_LIST;
        }
        List list0 = new ArrayList(this.layerRenderTimes.size());
        for(Object object0: this.layerRenderTimes.entrySet()) {
            ((ArrayList)list0).add(new b(((String)((Map.Entry)object0).getKey()), ((MeanCalculator)((Map.Entry)object0).getValue()).getMean()));
        }
        Collections.sort(list0, this.floatComparator);
        return list0;
    }

    public void logRenderTimes() {
        if(this.enabled) {
            List list0 = this.getSortedRenderTimes();
            Log.d("LOTTIE", "Render times:");
            for(int v = 0; v < list0.size(); ++v) {
                b b0 = (b)list0.get(v);
                Log.d("LOTTIE", String.format("\t\t%30s:%.2f", b0.a, b0.b));
            }
        }
    }

    public void recordRenderTime(String s, float f) {
        if(this.enabled) {
            MeanCalculator meanCalculator0 = (MeanCalculator)this.layerRenderTimes.get(s);
            if(meanCalculator0 == null) {
                meanCalculator0 = new MeanCalculator();
                this.layerRenderTimes.put(s, meanCalculator0);
            }
            meanCalculator0.add(f);
            if(s.equals("__container")) {
                for(Object object0: this.frameListeners) {
                    ((FrameListener)object0).onFrameRendered(f);
                }
            }
        }
    }

    public void removeFrameListener(FrameListener performanceTracker$FrameListener0) {
        this.frameListeners.remove(performanceTracker$FrameListener0);
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }
}

