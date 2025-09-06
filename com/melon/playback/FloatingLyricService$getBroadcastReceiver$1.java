package com.melon.playback;

import A3.l;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import d9.j;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/melon/playback/FloatingLyricService$getBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FloatingLyricService.getBroadcastReceiver.1 extends BroadcastReceiver {
    public final FloatingLyricService a;
    public static final int b;

    public FloatingLyricService.getBroadcastReceiver.1(FloatingLyricService floatingLyricService0) {
        this.a = floatingLyricService0;
        super();
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        q.g(context0, "context");
        q.g(intent0, "intent");
        String s = intent0.getAction();
        if(s != null) {
            LogU.Companion.d("FloatingLyricService", "filter action : " + s);
            boolean z = TextUtils.equals("android.intent.action.SCREEN_OFF", s);
            FloatingLyricService floatingLyricService0 = this.a;
            if(z) {
                j.d("FloatingLyricService");
                ViewUtils.hideWhen(floatingLyricService0.e, true);
                return;
            }
            if(TextUtils.equals("android.intent.action.SCREEN_ON", s)) {
                j.c("FloatingLyricService");
                l l0 = new l(floatingLyricService0, 7);
                floatingLyricService0.r.postDelayed(l0, 1000L);
            }
        }
    }
}

