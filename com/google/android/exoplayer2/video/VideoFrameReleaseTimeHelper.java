package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager.DisplayListener;
import android.hardware.display.DisplayManager;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer.FrameCallback;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.Util;

public final class VideoFrameReleaseTimeHelper {
    @TargetApi(17)
    final class DefaultDisplayListener implements DisplayManager.DisplayListener {
        private final DisplayManager displayManager;

        public DefaultDisplayListener(DisplayManager displayManager0) {
            this.displayManager = displayManager0;
        }

        @Override  // android.hardware.display.DisplayManager$DisplayListener
        public void onDisplayAdded(int v) {
        }

        @Override  // android.hardware.display.DisplayManager$DisplayListener
        public void onDisplayChanged(int v) {
            if(v == 0) {
                VideoFrameReleaseTimeHelper.this.updateDefaultDisplayRefreshRateParams();
            }
        }

        @Override  // android.hardware.display.DisplayManager$DisplayListener
        public void onDisplayRemoved(int v) {
        }

        public void register() {
            this.displayManager.registerDisplayListener(this, null);
        }

        public void unregister() {
            this.displayManager.unregisterDisplayListener(this);
        }
    }

    static final class VSyncSampler implements Handler.Callback, Choreographer.FrameCallback {
        private static final int CREATE_CHOREOGRAPHER = 0;
        private static final VSyncSampler INSTANCE = null;
        private static final int MSG_ADD_OBSERVER = 1;
        private static final int MSG_REMOVE_OBSERVER = 2;
        private Choreographer choreographer;
        private final HandlerThread choreographerOwnerThread;
        private final Handler handler;
        private int observerCount;
        public volatile long sampledVsyncTimeNs;

        static {
            VSyncSampler.INSTANCE = new VSyncSampler();
        }

        private VSyncSampler() {
            this.sampledVsyncTimeNs = 0x8000000000000001L;
            HandlerThread handlerThread0 = new HandlerThread("ChoreographerOwner:Handler");
            this.choreographerOwnerThread = handlerThread0;
            handlerThread0.start();
            Handler handler0 = Util.createHandler(handlerThread0.getLooper(), this);
            this.handler = handler0;
            handler0.sendEmptyMessage(0);
        }

        public void addObserver() {
            this.handler.sendEmptyMessage(1);
        }

        private void addObserverInternal() {
            int v = this.observerCount + 1;
            this.observerCount = v;
            if(v == 1) {
                this.choreographer.postFrameCallback(this);
            }
        }

        private void createChoreographerInstanceInternal() {
            this.choreographer = Choreographer.getInstance();
        }

        @Override  // android.view.Choreographer$FrameCallback
        public void doFrame(long v) {
            this.sampledVsyncTimeNs = v;
            this.choreographer.postFrameCallbackDelayed(this, 500L);
        }

        public static VSyncSampler getInstance() {
            return VSyncSampler.INSTANCE;
        }

        @Override  // android.os.Handler$Callback
        public boolean handleMessage(Message message0) {
            int v = message0.what;
            switch(v) {
                case 0: {
                    this.createChoreographerInstanceInternal();
                    return true;
                }
                case 1: {
                    this.addObserverInternal();
                    return true;
                }
                default: {
                    if(v != 2) {
                        return false;
                    }
                    this.removeObserverInternal();
                    return true;
                }
            }
        }

        public void removeObserver() {
            this.handler.sendEmptyMessage(2);
        }

        private void removeObserverInternal() {
            int v = this.observerCount - 1;
            this.observerCount = v;
            if(v == 0) {
                this.choreographer.removeFrameCallback(this);
                this.sampledVsyncTimeNs = 0x8000000000000001L;
            }
        }
    }

    private static final long CHOREOGRAPHER_SAMPLE_DELAY_MILLIS = 500L;
    private static final long MAX_ALLOWED_DRIFT_NS = 20000000L;
    private static final int MIN_FRAMES_FOR_ADJUSTMENT = 6;
    private static final long VSYNC_OFFSET_PERCENTAGE = 80L;
    private long adjustedLastFrameTimeNs;
    private final DefaultDisplayListener displayListener;
    private long frameCount;
    private boolean haveSync;
    private long lastFramePresentationTimeUs;
    private long pendingAdjustedFrameTimeNs;
    private long syncFramePresentationTimeNs;
    private long syncUnadjustedReleaseTimeNs;
    private long vsyncDurationNs;
    private long vsyncOffsetNs;
    private final VSyncSampler vsyncSampler;
    private final WindowManager windowManager;

    public VideoFrameReleaseTimeHelper() {
        this(null);
    }

    public VideoFrameReleaseTimeHelper(Context context0) {
        DefaultDisplayListener videoFrameReleaseTimeHelper$DefaultDisplayListener0 = null;
        if(context0 == null) {
            this.windowManager = null;
        }
        else {
            context0 = context0.getApplicationContext();
            this.windowManager = (WindowManager)context0.getSystemService("window");
        }
        if(this.windowManager == null) {
            this.displayListener = null;
            this.vsyncSampler = null;
        }
        else {
            if(Util.SDK_INT >= 17) {
                videoFrameReleaseTimeHelper$DefaultDisplayListener0 = this.maybeBuildDefaultDisplayListenerV17(context0);
            }
            this.displayListener = videoFrameReleaseTimeHelper$DefaultDisplayListener0;
            this.vsyncSampler = VSyncSampler.getInstance();
        }
        this.vsyncDurationNs = 0x8000000000000001L;
        this.vsyncOffsetNs = 0x8000000000000001L;
    }

    public long adjustReleaseTime(long v, long v1) {
        long v4;
        long v3;
        if(this.haveSync) {
            if(v != this.lastFramePresentationTimeUs) {
                ++this.frameCount;
                this.adjustedLastFrameTimeNs = this.pendingAdjustedFrameTimeNs;
            }
            long v2 = this.frameCount;
            if(Long.compare(v2, 6L) >= 0) {
                v3 = this.adjustedLastFrameTimeNs + (1000L * v - this.syncFramePresentationTimeNs) / v2;
                if(this.isDriftTooLarge(v3, v1)) {
                    this.haveSync = false;
                    v4 = v1;
                    v3 = 1000L * v;
                }
                else {
                    v4 = this.syncUnadjustedReleaseTimeNs + v3 - this.syncFramePresentationTimeNs;
                }
            }
            else {
                if(this.isDriftTooLarge(1000L * v, v1)) {
                    this.haveSync = false;
                }
                v4 = v1;
                v3 = 1000L * v;
            }
        }
        else {
            v4 = v1;
            v3 = 1000L * v;
        }
        if(!this.haveSync) {
            this.syncFramePresentationTimeNs = 1000L * v;
            this.syncUnadjustedReleaseTimeNs = v1;
            this.frameCount = 0L;
            this.haveSync = true;
        }
        this.lastFramePresentationTimeUs = v;
        this.pendingAdjustedFrameTimeNs = v3;
        VSyncSampler videoFrameReleaseTimeHelper$VSyncSampler0 = this.vsyncSampler;
        if(videoFrameReleaseTimeHelper$VSyncSampler0 != null && this.vsyncDurationNs != 0x8000000000000001L) {
            return videoFrameReleaseTimeHelper$VSyncSampler0.sampledVsyncTimeNs == 0x8000000000000001L ? v4 : VideoFrameReleaseTimeHelper.closestVsync(v4, videoFrameReleaseTimeHelper$VSyncSampler0.sampledVsyncTimeNs, this.vsyncDurationNs) - this.vsyncOffsetNs;
        }
        return v4;
    }

    private static long closestVsync(long v, long v1, long v2) {
        long v4;
        long v3 = (v - v1) / v2 * v2 + v1;
        if(v <= v3) {
            v4 = v3 - v2;
            return v3 - v >= v - v4 ? v4 : v3;
        }
        v4 = v3;
        v3 = v2 + v3;
        return v3 - v >= v - v4 ? v4 : v3;
    }

    public void disable() {
        if(this.windowManager != null) {
            DefaultDisplayListener videoFrameReleaseTimeHelper$DefaultDisplayListener0 = this.displayListener;
            if(videoFrameReleaseTimeHelper$DefaultDisplayListener0 != null) {
                videoFrameReleaseTimeHelper$DefaultDisplayListener0.unregister();
            }
            this.vsyncSampler.removeObserver();
        }
    }

    public void enable() {
        this.haveSync = false;
        if(this.windowManager != null) {
            this.vsyncSampler.addObserver();
            DefaultDisplayListener videoFrameReleaseTimeHelper$DefaultDisplayListener0 = this.displayListener;
            if(videoFrameReleaseTimeHelper$DefaultDisplayListener0 != null) {
                videoFrameReleaseTimeHelper$DefaultDisplayListener0.register();
            }
            this.updateDefaultDisplayRefreshRateParams();
        }
    }

    private boolean isDriftTooLarge(long v, long v1) {
        return Math.abs(v1 - this.syncUnadjustedReleaseTimeNs - (v - this.syncFramePresentationTimeNs)) > 20000000L;
    }

    @TargetApi(17)
    private DefaultDisplayListener maybeBuildDefaultDisplayListenerV17(Context context0) {
        DisplayManager displayManager0 = (DisplayManager)context0.getSystemService("display");
        return displayManager0 == null ? null : new DefaultDisplayListener(this, displayManager0);
    }

    private void updateDefaultDisplayRefreshRateParams() {
        Display display0 = this.windowManager.getDefaultDisplay();
        if(display0 != null) {
            long v = (long)(1000000000.0 / ((double)display0.getRefreshRate()));
            this.vsyncDurationNs = v;
            this.vsyncOffsetNs = v * 80L / 100L;
        }
    }
}

