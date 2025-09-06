package com.iloen.melon.playback;

import A7.d;
import U4.x;
import android.os.Debug;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.iloen.melon.utils.log.LogU;
import java.text.DecimalFormat;

@Deprecated(since = "더 이상 사용처 없음")
public class MelonLoadControl implements LoadControl {
    private static final int ABOVE_HIGH_WATERMARK = 0;
    private static final int BELOW_LOW_WATERMARK = 2;
    private static final int BETWEEN_WATERMARKS = 1;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_MAX_BUFFER_MS = 30000;
    public static final int DEFAULT_MIN_BUFFER_MS = 15000;
    public static final int LOADING_PRIORITY = 0;
    private static final boolean LOGV = false;
    private static final String TAG = "MelonLoadControl";
    public static int VIDEO_BUFFER_SCALE_UP_FACTOR = 4;
    private final DefaultAllocator allocator;
    private final long bufferForPlaybackAfterRebufferUs;
    private final long bufferForPlaybackUs;
    private boolean isBuffering;
    private final long maxBufferUs;
    private final long minBufferUs;
    private final PriorityTaskManager priorityTaskManager;
    private int targetBufferSize;

    public MelonLoadControl() {
        this(new DefaultAllocator(true, 0x10000));
    }

    public MelonLoadControl(DefaultAllocator defaultAllocator0) {
        this(defaultAllocator0, 15000, 30000, 2500L, 5000L);
    }

    public MelonLoadControl(DefaultAllocator defaultAllocator0, int v, int v1, long v2, long v3) {
        this(defaultAllocator0, v, v1, v2, v3, null);
    }

    public MelonLoadControl(DefaultAllocator defaultAllocator0, int v, int v1, long v2, long v3, PriorityTaskManager priorityTaskManager0) {
        this.allocator = defaultAllocator0;
        this.minBufferUs = ((long)(v * MelonLoadControl.VIDEO_BUFFER_SCALE_UP_FACTOR)) * 1000L;
        this.maxBufferUs = ((long)(MelonLoadControl.VIDEO_BUFFER_SCALE_UP_FACTOR * v1)) * 1000L;
        this.bufferForPlaybackUs = v2 * 1000L;
        this.bufferForPlaybackAfterRebufferUs = v3 * 1000L;
        this.priorityTaskManager = priorityTaskManager0;
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public Allocator getAllocator() {
        return this.allocator;
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public long getBackBufferDurationUs() {
        return 0L;
    }

    private static int getDefaultBufferSize(int v) {
        switch(v) {
            case 0: {
                return 0x22C0000;
            }
            case 1: {
                return 0x360000;
            }
            case 2: {
                return 0x1F40000;
            }
            case 3: 
            case 4: 
            case 5: {
                return 0x20000;
            }
            case 6: {
                return 0;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    private void logHeap() {
        if(!MelonLoadControl.LOGV) {
            return;
        }
        Double double0 = (double)Debug.getNativeHeapAllocatedSize();
        Double double1 = (double)Debug.getNativeHeapSize();
        Double double2 = (double)Debug.getNativeHeapFreeSize();
        DecimalFormat decimalFormat0 = new DecimalFormat();
        decimalFormat0.setMaximumFractionDigits(1);
        decimalFormat0.setMinimumFractionDigits(1);
        StringBuilder stringBuilder0 = d.o("[Runtime] avail/max/free >> ", "8,589,934,592.0", " ", "8,589,934,592.0", " ");
        stringBuilder0.append("2,414,753,672.0");
        String s = decimalFormat0.format(double0);
        String s1 = decimalFormat0.format(double1);
        String s2 = decimalFormat0.format(double2);
        StringBuilder stringBuilder1 = d.o(" | ", s, " ", s1, " ");
        stringBuilder1.append(s2);
        stringBuilder1.append(" << alloc/avail/free [Native]");
        LogU.d("MelonLoadControl", stringBuilder0.toString() + stringBuilder1.toString());
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public void onPrepared() {
        this.reset(false);
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public void onReleased() {
        this.reset(true);
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public void onStopped() {
        this.reset(true);
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public void onTracksSelected(Renderer[] arr_renderer, TrackGroupArray trackGroupArray0, TrackSelectionArray trackSelectionArray0) {
        this.targetBufferSize = 0;
        for(int v = 0; v < arr_renderer.length; ++v) {
            if(trackSelectionArray0.get(v) != null) {
                this.targetBufferSize += MelonLoadControl.getDefaultBufferSize(arr_renderer[v].getTrackType());
                if(arr_renderer[v].getTrackType() == 2) {
                    this.targetBufferSize *= MelonLoadControl.VIDEO_BUFFER_SCALE_UP_FACTOR;
                }
            }
            StringBuilder stringBuilder0 = x.n(v, "onTracksSelected() index: ", ", targetBufferSize: ");
            stringBuilder0.append(this.targetBufferSize);
            LogU.d("MelonLoadControl", stringBuilder0.toString());
        }
        this.allocator.setTargetBufferSize(this.targetBufferSize);
        this.logHeap();
    }

    private void reset(boolean z) {
        this.targetBufferSize = 0;
        PriorityTaskManager priorityTaskManager0 = this.priorityTaskManager;
        if(priorityTaskManager0 != null && this.isBuffering) {
            priorityTaskManager0.remove(0);
        }
        this.isBuffering = false;
        if(z) {
            this.allocator.reset();
        }
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public boolean retainBackBufferFromKeyframe() {
        return false;
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public boolean shouldContinueLoading(long v, float f) {
        this.logHeap();
        return Runtime.getRuntime().totalMemory() < Runtime.getRuntime().maxMemory();
    }

    @Override  // com.google.android.exoplayer2.LoadControl
    public boolean shouldStartPlayback(long v, float f, boolean z) {
        long v1 = z ? this.bufferForPlaybackAfterRebufferUs : this.bufferForPlaybackUs;
        return v1 <= 0L || v >= v1;
    }
}

