package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import androidx.collection.W;
import androidx.collection.s;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import org.json.JSONObject;

public class LottieComposition {
    @Deprecated
    public static class Factory {
        static final class ListenerAdapter implements Cancellable, LottieListener {
            private boolean cancelled;
            private final OnCompositionLoadedListener listener;

            private ListenerAdapter(OnCompositionLoadedListener onCompositionLoadedListener0) {
                this.cancelled = false;
                this.listener = onCompositionLoadedListener0;
            }

            public ListenerAdapter(OnCompositionLoadedListener onCompositionLoadedListener0, com.airbnb.lottie.LottieComposition.1 lottieComposition$10) {
                this(onCompositionLoadedListener0);
            }

            @Override  // com.airbnb.lottie.Cancellable
            public void cancel() {
                this.cancelled = true;
            }

            public void onResult(LottieComposition lottieComposition0) {
                if(this.cancelled) {
                    return;
                }
                this.listener.onCompositionLoaded(lottieComposition0);
            }

            @Override  // com.airbnb.lottie.LottieListener
            public void onResult(Object object0) {
                this.onResult(((LottieComposition)object0));
            }
        }

        @Deprecated
        public static Cancellable fromAssetFileName(Context context0, String s, OnCompositionLoadedListener onCompositionLoadedListener0) {
            Cancellable cancellable0 = new ListenerAdapter(onCompositionLoadedListener0, null);
            LottieCompositionFactory.fromAsset(context0, s).addListener(((LottieListener)cancellable0));
            return cancellable0;
        }

        @Deprecated
        public static LottieComposition fromFileSync(Context context0, String s) {
            return (LottieComposition)LottieCompositionFactory.fromAssetSync(context0, s).getValue();
        }

        @Deprecated
        public static Cancellable fromInputStream(InputStream inputStream0, OnCompositionLoadedListener onCompositionLoadedListener0) {
            Cancellable cancellable0 = new ListenerAdapter(onCompositionLoadedListener0, null);
            LottieCompositionFactory.fromJsonInputStream(inputStream0, null).addListener(((LottieListener)cancellable0));
            return cancellable0;
        }

        @Deprecated
        public static LottieComposition fromInputStreamSync(InputStream inputStream0) {
            return (LottieComposition)LottieCompositionFactory.fromJsonInputStreamSync(inputStream0, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromInputStreamSync(InputStream inputStream0, boolean z) {
            if(z) {
                Logger.warning("Lottie now auto-closes input stream!");
            }
            return (LottieComposition)LottieCompositionFactory.fromJsonInputStreamSync(inputStream0, null).getValue();
        }

        @Deprecated
        public static Cancellable fromJsonReader(JsonReader jsonReader0, OnCompositionLoadedListener onCompositionLoadedListener0) {
            Cancellable cancellable0 = new ListenerAdapter(onCompositionLoadedListener0, null);
            LottieCompositionFactory.fromJsonReader(jsonReader0, null).addListener(((LottieListener)cancellable0));
            return cancellable0;
        }

        @Deprecated
        public static Cancellable fromJsonString(String s, OnCompositionLoadedListener onCompositionLoadedListener0) {
            Cancellable cancellable0 = new ListenerAdapter(onCompositionLoadedListener0, null);
            LottieCompositionFactory.fromJsonString(s, null).addListener(((LottieListener)cancellable0));
            return cancellable0;
        }

        @Deprecated
        public static LottieComposition fromJsonSync(Resources resources0, JSONObject jSONObject0) {
            return (LottieComposition)LottieCompositionFactory.fromJsonSync(jSONObject0, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromJsonSync(JsonReader jsonReader0) {
            return (LottieComposition)LottieCompositionFactory.fromJsonReaderSync(jsonReader0, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromJsonSync(String s) {
            return (LottieComposition)LottieCompositionFactory.fromJsonStringSync(s, null).getValue();
        }

        @Deprecated
        public static Cancellable fromRawFile(Context context0, int v, OnCompositionLoadedListener onCompositionLoadedListener0) {
            Cancellable cancellable0 = new ListenerAdapter(onCompositionLoadedListener0, null);
            LottieCompositionFactory.fromRawRes(context0, v).addListener(((LottieListener)cancellable0));
            return cancellable0;
        }
    }

    private Rect bounds;
    private W characters;
    private float endFrame;
    private Map fonts;
    private float frameRate;
    private boolean hasDashPattern;
    private Map images;
    private float imagesDpScale;
    private s layerMap;
    private List layers;
    private List markers;
    private int maskAndMatteCount;
    private final PerformanceTracker performanceTracker;
    private Map precomps;
    private float startFrame;
    private int unscaledHeight;
    private int unscaledWidth;
    private final HashSet warnings;

    public LottieComposition() {
        this.performanceTracker = new PerformanceTracker();
        this.warnings = new HashSet();
        this.maskAndMatteCount = 0;
    }

    public void addWarning(String s) {
        Logger.warning(s);
        this.warnings.add(s);
    }

    public Rect getBounds() {
        return this.bounds;
    }

    public W getCharacters() {
        return this.characters;
    }

    public float getDuration() {
        return (float)(((long)(this.getDurationFrames() / this.frameRate * 1000.0f)));
    }

    public float getDurationFrames() {
        return this.endFrame - this.startFrame;
    }

    public float getEndFrame() {
        return this.endFrame;
    }

    public Map getFonts() {
        return this.fonts;
    }

    public float getFrameForProgress(float f) {
        return MiscUtils.lerp(this.startFrame, this.endFrame, f);
    }

    public float getFrameRate() {
        return this.frameRate;
    }

    public Map getImages() {
        float f = Utils.dpScale();
        if(f != this.imagesDpScale) {
            for(Object object0: this.images.entrySet()) {
                this.images.put(((String)((Map.Entry)object0).getKey()), ((LottieImageAsset)((Map.Entry)object0).getValue()).copyWithScale(this.imagesDpScale / f));
            }
        }
        this.imagesDpScale = f;
        return this.images;
    }

    public List getLayers() {
        return this.layers;
    }

    public Marker getMarker(String s) {
        int v = this.markers.size();
        for(int v1 = 0; v1 < v; ++v1) {
            Marker marker0 = (Marker)this.markers.get(v1);
            if(marker0.matchesName(s)) {
                return marker0;
            }
        }
        return null;
    }

    public List getMarkers() {
        return this.markers;
    }

    public int getMaskAndMatteCount() {
        return this.maskAndMatteCount;
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.performanceTracker;
    }

    public List getPrecomps(String s) {
        return (List)this.precomps.get(s);
    }

    public float getProgressForFrame(float f) {
        return (f - this.startFrame) / (this.endFrame - this.startFrame);
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public int getUnscaledHeight() {
        return this.unscaledHeight;
    }

    public int getUnscaledWidth() {
        return this.unscaledWidth;
    }

    public ArrayList getWarnings() {
        return new ArrayList(Arrays.asList(((String[])this.warnings.toArray(new String[this.warnings.size()]))));
    }

    public boolean hasDashPattern() {
        return this.hasDashPattern;
    }

    public boolean hasImages() {
        return !this.images.isEmpty();
    }

    public void incrementMatteOrMaskCount(int v) {
        this.maskAndMatteCount += v;
    }

    public void init(Rect rect0, float f, float f1, float f2, List list0, s s0, Map map0, Map map1, float f3, W w0, Map map2, List list1, int v, int v1) {
        this.bounds = rect0;
        this.startFrame = f;
        this.endFrame = f1;
        this.frameRate = f2;
        this.layers = list0;
        this.layerMap = s0;
        this.precomps = map0;
        this.images = map1;
        this.imagesDpScale = f3;
        this.characters = w0;
        this.fonts = map2;
        this.markers = list1;
        this.unscaledWidth = v;
        this.unscaledHeight = v1;
    }

    public Layer layerModelForId(long v) {
        return (Layer)this.layerMap.b(v);
    }

    public void setHasDashPattern(boolean z) {
        this.hasDashPattern = z;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.performanceTracker.setEnabled(z);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("LottieComposition:\n");
        for(Object object0: this.layers) {
            stringBuilder0.append(((Layer)object0).toString("\t"));
        }
        return stringBuilder0.toString();
    }

    class com.airbnb.lottie.LottieComposition.1 {
    }

}

