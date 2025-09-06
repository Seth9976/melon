package com.google.android.exoplayer2.ui;

import U4.x;
import android.annotation.SuppressLint;
import android.os.Looper;
import android.widget.TextView;
import b3.Z;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Player.EventListener;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Locale;
import k8.Y;

public class DebugTextViewHelper implements EventListener, Runnable {
    private static final int REFRESH_INTERVAL_MS = 1000;
    private final SimpleExoPlayer player;
    private boolean started;
    private final TextView textView;

    public DebugTextViewHelper(SimpleExoPlayer simpleExoPlayer0, TextView textView0) {
        Assertions.checkArgument(simpleExoPlayer0.getApplicationLooper() == Looper.getMainLooper());
        this.player = simpleExoPlayer0;
        this.textView = textView0;
    }

    public String getAudioString() {
        Format format0 = this.player.getAudioFormat();
        DecoderCounters decoderCounters0 = this.player.getAudioDecoderCounters();
        if(format0 != null && decoderCounters0 != null) {
            String s = DebugTextViewHelper.getDecoderCountersBufferCountString(decoderCounters0);
            StringBuilder stringBuilder0 = Z.o(Z.e(Z.e(Z.e(36, format0.sampleMimeType), format0.id), s), "\n", format0.sampleMimeType, "(id:", format0.id);
            stringBuilder0.append(" hz:");
            stringBuilder0.append(format0.sampleRate);
            stringBuilder0.append(" ch:");
            stringBuilder0.append(format0.channelCount);
            return x.m(stringBuilder0, s, ")");
        }
        return "";
    }

    public String getDebugString() {
        return this.getPlayerStateString() + this.getVideoString() + this.getAudioString();
    }

    private static String getDecoderCountersBufferCountString(DecoderCounters decoderCounters0) {
        return decoderCounters0 == null ? "" : " sib:" + decoderCounters0.skippedInputBufferCount + " sb:" + decoderCounters0.skippedOutputBufferCount + " rb:" + decoderCounters0.renderedOutputBufferCount + " db:" + decoderCounters0.droppedBufferCount + " mcdb:" + decoderCounters0.maxConsecutiveDroppedBufferCount + " dk:" + decoderCounters0.droppedToKeyframeCount;
    }

    private static String getPixelAspectRatioString(float f) {
        if(f != -1.0f && f != 1.0f) {
            String s = String.format(Locale.US, "%.02f", f);
            return s.length() == 0 ? new String(" par:") : " par:" + s;
        }
        return "";
    }

    public String getPlayerStateString() {
        String s;
        switch(this.player.getPlaybackState()) {
            case 1: {
                s = "idle";
                break;
            }
            case 2: {
                s = "buffering";
                break;
            }
            case 3: {
                s = "ready";
                break;
            }
            case 4: {
                s = "ended";
                break;
            }
            default: {
                s = "unknown";
            }
        }
        boolean z = this.player.getPlayWhenReady();
        int v = this.player.getCurrentWindowIndex();
        StringBuilder stringBuilder0 = Z.p("playWhenReady:", " playbackState:", s, " window:", z);
        stringBuilder0.append(v);
        return stringBuilder0.toString();
    }

    public String getVideoString() {
        Format format0 = this.player.getVideoFormat();
        DecoderCounters decoderCounters0 = this.player.getVideoDecoderCounters();
        if(format0 != null && decoderCounters0 != null) {
            String s = DebugTextViewHelper.getPixelAspectRatioString(format0.pixelWidthHeightRatio);
            String s1 = DebugTextViewHelper.getDecoderCountersBufferCountString(decoderCounters0);
            StringBuilder stringBuilder0 = Z.o(Z.e(Z.e(Z.e(Z.e(0x20, format0.sampleMimeType), format0.id), s), s1), "\n", format0.sampleMimeType, "(id:", format0.id);
            stringBuilder0.append(" r:");
            stringBuilder0.append(format0.width);
            stringBuilder0.append("x");
            stringBuilder0.append(format0.height);
            return Y.l(stringBuilder0, s, s1, ")");
        }
        return "";
    }

    @Override  // com.google.android.exoplayer2.Player$EventListener
    public final void onPlayerStateChanged(boolean z, int v) {
        this.updateAndPost();
    }

    @Override  // com.google.android.exoplayer2.Player$EventListener
    public final void onPositionDiscontinuity(int v) {
        this.updateAndPost();
    }

    @Override
    public final void run() {
        this.updateAndPost();
    }

    public final void start() {
        if(this.started) {
            return;
        }
        this.started = true;
        this.player.addListener(this);
        this.updateAndPost();
    }

    public final void stop() {
        if(!this.started) {
            return;
        }
        this.started = false;
        this.player.removeListener(this);
        this.textView.removeCallbacks(this);
    }

    @SuppressLint({"SetTextI18n"})
    public final void updateAndPost() {
        String s = this.getDebugString();
        this.textView.setText(s);
        this.textView.removeCallbacks(this);
        this.textView.postDelayed(this, 1000L);
    }
}

