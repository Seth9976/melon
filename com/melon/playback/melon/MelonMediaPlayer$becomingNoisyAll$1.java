package com.melon.playback.melon;

import Vb.o0;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import va.e;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/melon/playback/melon/MelonMediaPlayer$becomingNoisyAll$1", "Landroid/content/BroadcastReceiver;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonMediaPlayer.becomingNoisyAll.1 extends BroadcastReceiver {
    public final o0 a;

    public MelonMediaPlayer.becomingNoisyAll.1(o0 o00) {
        this.a = o00;
        super();
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        q.g(context0, "context");
        q.g(intent0, "intent");
        o0 o00 = this.a;
        LogU.debug$default(o00.e1(), e.b("onReceive() becomingNoisyAll: ", intent0.getAction()), null, false, 6, null);
        if("android.media.AUDIO_BECOMING_NOISY".equals(intent0.getAction())) {
            o00.setPlayWhenReady(false);
            o00.o1();
        }
    }
}

