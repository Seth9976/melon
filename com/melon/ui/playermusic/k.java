package com.melon.ui.playermusic;

import androidx.compose.runtime.b0;
import com.iloen.melon.player.trackzero.SinglePlayer.SinglePlayerCallback;
import kotlin.jvm.internal.q;

public final class k implements SinglePlayerCallback {
    public final b0 a;

    public k(b0 b00) {
        this.a = b00;
    }

    @Override  // com.iloen.melon.player.trackzero.SinglePlayer$SinglePlayerCallback
    public final void onCompletion() {
    }

    @Override  // com.iloen.melon.player.trackzero.SinglePlayer$SinglePlayerCallback
    public final void onError(String s) {
        q.g(s, "error");
        this.a.setValue(Boolean.FALSE);
    }

    @Override  // com.iloen.melon.player.trackzero.SinglePlayer$SinglePlayerCallback
    public final void onPlaybackStateChanged(boolean z, int v) {
        if(v == 3) {
            b0 b00 = this.a;
            if(!((Boolean)b00.getValue()).booleanValue()) {
                b00.setValue(Boolean.TRUE);
            }
        }
    }

    @Override  // com.iloen.melon.player.trackzero.SinglePlayer$SinglePlayerCallback
    public final void onPlaybackTransitions() {
    }
}

