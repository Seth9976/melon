package com.iloen.melon.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/push/receiver/PushServerIFReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PushServerIFReceiver extends BroadcastReceiver {
    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        q.g(context0, "context");
        q.g(intent0, "intent");
        String s = intent0.getAction();
        LogU.Companion.i("PushServerIFReceiver", "onReceive() actionName: " + s);
    }
}

