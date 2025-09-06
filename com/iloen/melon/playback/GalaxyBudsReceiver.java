package com.iloen.melon.playback;

import Db.i;
import Qb.z;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.media3.session.legacy.V;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.fragments.artistchannel.viewholder.f;
import com.iloen.melon.net.v4x.request.InflowPvLogDummyReq.Params.Builder;
import com.iloen.melon.net.v4x.request.InflowPvLogDummyReq;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.O;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001A\u00020\b2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001A\u00020\u000B8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/playback/GalaxyBudsReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lie/H;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class GalaxyBudsReceiver extends BroadcastReceiver {
    public static final int $stable = 8;
    @NotNull
    private final String TAG;

    public GalaxyBudsReceiver() {
        this.TAG = "GalaxyBudsReceiver";
    }

    public static H a(z z0) {
        return GalaxyBudsReceiver.onReceive$lambda$1$lambda$0(z0);
    }

    @Override  // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context0, @Nullable Intent intent0) {
        if(intent0 == null) {
            LogU.Companion.d(this.TAG, "onReceive() intent is null");
            return;
        }
        String s = intent0.getAction();
        Y.w("onReceive() action: ", s, LogU.Companion, this.TAG);
        Context context1 = Y.a(MelonAppBase.Companion);
        q.f("com.samsung.accessory.earbuds.action.SEND_PUI_EVENT", "getString(...)");
        if("com.samsung.accessory.earbuds.action.SEND_PUI_EVENT".equals(s)) {
            O.a(new InflowPvLogDummyReq(context1, new Builder("W60700").build()));
            DevLog.Companion.get("AutoPlay").put(this.TAG + ".onReceive() keycode : " + s);
            if(context0 != null) {
                f f0 = new f(10);
                Context context2 = context0.getApplicationContext();
                q.f(context2, "getApplicationContext(...)");
                V v0 = new V(context2, "From GalaxyBuds");
                i.a(((i)v0.b), null, new Nc.f(v0, 8), 3);
                z z0 = (z)v0.c;
                z0.o(true);
                z0.a(new Dc.i(12, f0, z0));
            }
        }
    }

    private static final H onReceive$lambda$1$lambda$0(z z0) {
        q.g(z0, "$this$request");
        z0.s();
        return H.a;
    }
}

