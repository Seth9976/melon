package com.melon.playback.melon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/melon/playback/melon/MelonMediaPlayer$customActionReceiver$1", "Landroid/content/BroadcastReceiver;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonMediaPlayer.customActionReceiver.1 extends BroadcastReceiver {
    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        q.g(context0, "context");
        q.g(intent0, "intent");
        String s = "android.appwidget.action.APPWIDGET_UPDATE".equals(intent0.getAction()) ? intent0.getStringExtra("com.iloen.melon.intent.action") : null;
        if(!"com.iloen.melon.response_like_content".equals(s)) {
            "com.iloen.melon.intent.action.playback.playmode".equals(s);
        }
    }
}

