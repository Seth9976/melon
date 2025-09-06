package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;

@Deprecated
public class PlaybackControlView extends PlayerControlView {
    @Deprecated
    public interface ControlDispatcher extends com.google.android.exoplayer2.ControlDispatcher {
    }

    @Deprecated
    static final class DefaultControlDispatcher extends com.google.android.exoplayer2.DefaultControlDispatcher implements ControlDispatcher {
        private DefaultControlDispatcher() {
        }

        public DefaultControlDispatcher(com.google.android.exoplayer2.ui.PlaybackControlView.1 playbackControlView$10) {
        }
    }

    @Deprecated
    public static final ControlDispatcher DEFAULT_CONTROL_DISPATCHER;

    static {
        PlaybackControlView.DEFAULT_CONTROL_DISPATCHER = new DefaultControlDispatcher(null);
    }

    public PlaybackControlView(Context context0) {
        super(context0);
    }

    public PlaybackControlView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public PlaybackControlView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    public PlaybackControlView(Context context0, AttributeSet attributeSet0, int v, AttributeSet attributeSet1) {
        super(context0, attributeSet0, v, attributeSet1);
    }

    class com.google.android.exoplayer2.ui.PlaybackControlView.1 {
    }

}

