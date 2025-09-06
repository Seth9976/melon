package com.melon.playback.melon;

import Vb.o0;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import va.e;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/melon/playback/melon/MelonMediaPlayer$checkNetworkConnectReceiver$1", "Landroid/content/BroadcastReceiver;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonMediaPlayer.checkNetworkConnectReceiver.1 extends BroadcastReceiver {
    public final o0 a;

    public MelonMediaPlayer.checkNetworkConnectReceiver.1(o0 o00) {
        this.a = o00;
        super();
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        q.g(intent0, "intent");
        if(context0 == null) {
            return;
        }
        LogU.debug$default(this.a.e1(), e.b("onReceive() checkNetworkConnectReceiver action : ", intent0.getAction()), null, false, 6, null);
    }
}

