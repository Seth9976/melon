package r;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

public abstract class b {
    public static void a(Context context0, BroadcastReceiver broadcastReceiver0, IntentFilter intentFilter0) {
        context0.registerReceiver(broadcastReceiver0, intentFilter0, 2);
    }
}

