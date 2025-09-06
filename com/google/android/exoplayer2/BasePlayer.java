package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Util;

public abstract class BasePlayer implements Player {
    public static final class ListenerHolder {
        public final EventListener listener;
        private boolean released;

        public ListenerHolder(EventListener player$EventListener0) {
            this.listener = player$EventListener0;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 != null) {
                Class class0 = object0.getClass();
                return ListenerHolder.class == class0 ? this.listener.equals(((ListenerHolder)object0).listener) : false;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.listener.hashCode();
        }

        public void invoke(ListenerInvocation basePlayer$ListenerInvocation0) {
            if(!this.released) {
                basePlayer$ListenerInvocation0.invokeListener(this.listener);
            }
        }

        public void release() {
            this.released = true;
        }
    }

    public interface ListenerInvocation {
        void invokeListener(EventListener arg1);
    }

    protected final Window window;

    public BasePlayer() {
        this.window = new Window();
    }

    @Override  // com.google.android.exoplayer2.Player
    public final int getBufferedPercentage() {
        long v = this.getBufferedPosition();
        long v1 = this.getDuration();
        if(Long.compare(v, 0x8000000000000001L) != 0 && v1 != 0x8000000000000001L) {
            return Long.compare(v1, 0L) == 0 ? 100 : Util.constrainValue(((int)(v * 100L / v1)), 0, 100);
        }
        return 0;
    }

    @Override  // com.google.android.exoplayer2.Player
    public final long getContentDuration() {
        Timeline timeline0 = this.getCurrentTimeline();
        return timeline0.isEmpty() ? 0x8000000000000001L : timeline0.getWindow(this.getCurrentWindowIndex(), this.window).getDurationMs();
    }

    @Override  // com.google.android.exoplayer2.Player
    public final Object getCurrentManifest() {
        Timeline timeline0 = this.getCurrentTimeline();
        return timeline0.isEmpty() ? null : timeline0.getWindow(this.getCurrentWindowIndex(), this.window).manifest;
    }

    @Override  // com.google.android.exoplayer2.Player
    public final Object getCurrentTag() {
        Timeline timeline0 = this.getCurrentTimeline();
        return timeline0.isEmpty() ? null : timeline0.getWindow(this.getCurrentWindowIndex(), this.window).tag;
    }

    @Override  // com.google.android.exoplayer2.Player
    public final int getNextWindowIndex() {
        Timeline timeline0 = this.getCurrentTimeline();
        return timeline0.isEmpty() ? -1 : timeline0.getNextWindowIndex(this.getCurrentWindowIndex(), this.getRepeatModeForNavigation(), this.getShuffleModeEnabled());
    }

    @Override  // com.google.android.exoplayer2.Player
    public final int getPreviousWindowIndex() {
        Timeline timeline0 = this.getCurrentTimeline();
        return timeline0.isEmpty() ? -1 : timeline0.getPreviousWindowIndex(this.getCurrentWindowIndex(), this.getRepeatModeForNavigation(), this.getShuffleModeEnabled());
    }

    private int getRepeatModeForNavigation() {
        int v = this.getRepeatMode();
        return v == 1 ? 0 : v;
    }

    @Override  // com.google.android.exoplayer2.Player
    public final boolean hasNext() {
        return this.getNextWindowIndex() != -1;
    }

    @Override  // com.google.android.exoplayer2.Player
    public final boolean hasPrevious() {
        return this.getPreviousWindowIndex() != -1;
    }

    @Override  // com.google.android.exoplayer2.Player
    public final boolean isCurrentWindowDynamic() {
        Timeline timeline0 = this.getCurrentTimeline();
        return !timeline0.isEmpty() && timeline0.getWindow(this.getCurrentWindowIndex(), this.window).isDynamic;
    }

    @Override  // com.google.android.exoplayer2.Player
    public final boolean isCurrentWindowLive() {
        Timeline timeline0 = this.getCurrentTimeline();
        return !timeline0.isEmpty() && timeline0.getWindow(this.getCurrentWindowIndex(), this.window).isLive;
    }

    @Override  // com.google.android.exoplayer2.Player
    public final boolean isCurrentWindowSeekable() {
        Timeline timeline0 = this.getCurrentTimeline();
        return !timeline0.isEmpty() && timeline0.getWindow(this.getCurrentWindowIndex(), this.window).isSeekable;
    }

    @Override  // com.google.android.exoplayer2.Player
    public final boolean isPlaying() {
        return this.getPlaybackState() == 3 && this.getPlayWhenReady() && this.getPlaybackSuppressionReason() == 0;
    }

    @Override  // com.google.android.exoplayer2.Player
    public final void next() {
        int v = this.getNextWindowIndex();
        if(v != -1) {
            this.seekToDefaultPosition(v);
        }
    }

    @Override  // com.google.android.exoplayer2.Player
    public final void previous() {
        int v = this.getPreviousWindowIndex();
        if(v != -1) {
            this.seekToDefaultPosition(v);
        }
    }

    @Override  // com.google.android.exoplayer2.Player
    public final void seekTo(long v) {
        this.seekTo(this.getCurrentWindowIndex(), v);
    }

    @Override  // com.google.android.exoplayer2.Player
    public final void seekToDefaultPosition() {
        this.seekToDefaultPosition(this.getCurrentWindowIndex());
    }

    @Override  // com.google.android.exoplayer2.Player
    public final void seekToDefaultPosition(int v) {
        this.seekTo(v, 0x8000000000000001L);
    }

    @Override  // com.google.android.exoplayer2.Player
    public final void stop() {
        this.stop(false);
    }
}

