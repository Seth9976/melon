package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.PlaybackParameters;
import java.nio.ByteBuffer;

public class ForwardingAudioSink implements AudioSink {
    private final AudioSink sink;

    public ForwardingAudioSink(AudioSink audioSink0) {
        this.sink = audioSink0;
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void configure(int v, int v1, int v2, int v3, int[] arr_v, int v4, int v5) {
        this.sink.configure(v, v1, v2, v3, arr_v, v4, v5);
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() {
        this.sink.disableTunneling();
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void enableTunnelingV21(int v) {
        this.sink.enableTunnelingV21(v);
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        this.sink.flush();
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean z) {
        return this.sink.getCurrentPositionUs(z);
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public PlaybackParameters getPlaybackParameters() {
        return this.sink.getPlaybackParameters();
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public boolean handleBuffer(ByteBuffer byteBuffer0, long v) {
        return this.sink.handleBuffer(byteBuffer0, v);
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        this.sink.handleDiscontinuity();
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        return this.sink.hasPendingData();
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        return this.sink.isEnded();
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.sink.pause();
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.sink.play();
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() {
        this.sink.playToEndOfStream();
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        this.sink.reset();
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioAttributes(AudioAttributes audioAttributes0) {
        this.sink.setAudioAttributes(audioAttributes0);
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int v) {
        this.sink.setAudioSessionId(v);
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo0) {
        this.sink.setAuxEffectInfo(auxEffectInfo0);
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void setListener(Listener audioSink$Listener0) {
        this.sink.setListener(audioSink$Listener0);
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void setPlaybackParameters(PlaybackParameters playbackParameters0) {
        this.sink.setPlaybackParameters(playbackParameters0);
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        this.sink.setVolume(f);
    }

    @Override  // com.google.android.exoplayer2.audio.AudioSink
    public boolean supportsOutput(int v, int v1) {
        return this.sink.supportsOutput(v, v1);
    }
}

