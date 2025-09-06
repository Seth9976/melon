package com.melon.playback.melon;

import Ub.t;
import Vb.o0;
import Vb.u0;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import b3.E;
import bc.c;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import va.e;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/melon/playback/melon/MelonMediaPlayer$useMobileDataSettingChangeReceiver$1", "Landroid/content/BroadcastReceiver;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonMediaPlayer.useMobileDataSettingChangeReceiver.1 extends BroadcastReceiver {
    public final o0 a;

    public MelonMediaPlayer.useMobileDataSettingChangeReceiver.1(o0 o00) {
        this.a = o00;
        super();
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        q.g(context0, "arg0");
        q.g(intent0, "intent");
        o0 o00 = this.a;
        u0 u00 = o00.z;
        LogU.debug$default(o00.e1(), e.b("onReceive() StatusReceiver: ", intent0.getAction()), null, false, 6, null);
        if(q.b(intent0.getAction(), "com.iloen.melon.intent.action.setting.changed.3g.usage")) {
            E e0 = o00.W();
            if(e0 != null) {
                o00.D.getClass();
                if(c.c(e0) && o00.isPlaying() && !NetUtils.isConnected()) {
                    o00.setPlayWhenReady(false);
                    o00.D0().m = false;
                }
            }
        }
        else if(q.b(intent0.getAction(), "android.intent.action.AIRPLANE_MODE") && !NetUtils.isConnected() && ((t)u00.d()).f()) {
            u00.getClass();
            ((t)u00.d()).a("Unavailable Network");
        }
    }
}

