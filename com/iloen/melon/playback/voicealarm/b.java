package com.iloen.melon.playback.voicealarm;

import we.a;

public final class b implements a {
    public final int a;
    public final VoiceTrackAudioFocusHelper b;

    public b(VoiceTrackAudioFocusHelper voiceTrackAudioFocusHelper0, int v) {
        this.a = v;
        this.b = voiceTrackAudioFocusHelper0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a != 0 ? VoiceTrackAudioFocusHelper.audioFocusRequest_delegate$lambda$2(this.b) : VoiceTrackAudioFocusHelper.audioManager_delegate$lambda$0(this.b);
    }
}

