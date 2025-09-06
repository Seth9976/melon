package androidx.media.session;

import P1.c;
import Z2.b;
import android.content.BroadcastReceiver.PendingResult;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;
import com.iloen.melon.utils.a;
import java.util.List;

public class MediaButtonReceiver extends BroadcastReceiver {
    public static final int a;

    public static ComponentName a(Context context0, String s) {
        PackageManager packageManager0 = context0.getPackageManager();
        Intent intent0 = new Intent(s);
        intent0.setPackage("com.iloen.melon");
        List list0 = packageManager0.queryIntentServices(intent0, 0);
        if(list0.size() == 1) {
            ServiceInfo serviceInfo0 = ((ResolveInfo)list0.get(0)).serviceInfo;
            return new ComponentName(serviceInfo0.packageName, serviceInfo0.name);
        }
        if(list0.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder0 = a.n("Expected 1 service that handles ", s, ", found ");
        stringBuilder0.append(list0.size());
        throw new IllegalStateException(stringBuilder0.toString());
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        if(intent0 != null && "android.intent.action.MEDIA_BUTTON".equals(intent0.getAction()) && intent0.hasExtra("android.intent.extra.KEY_EVENT")) {
            ComponentName componentName0 = MediaButtonReceiver.a(context0, "android.intent.action.MEDIA_BUTTON");
            if(componentName0 != null) {
                intent0.setComponent(componentName0);
                try {
                    c.startForegroundService(context0, intent0);
                }
                catch(IllegalStateException illegalStateException0) {
                    if(Build.VERSION.SDK_INT < 0x1F || !Z2.a.b(illegalStateException0)) {
                        throw illegalStateException0;
                    }
                    Log.e("MediaButtonReceiver", "caught exception when trying to start a foreground service from the background: " + Z2.a.a(illegalStateException0).getMessage());
                }
                return;
            }
            ComponentName componentName1 = MediaButtonReceiver.a(context0, "android.media.browse.MediaBrowserService");
            if(componentName1 == null) {
                throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
            }
            BroadcastReceiver.PendingResult broadcastReceiver$PendingResult0 = this.goAsync();
            Context context1 = context0.getApplicationContext();
            b b0 = new b(broadcastReceiver$PendingResult0, context1, intent0);
            MediaBrowserCompat mediaBrowserCompat0 = new MediaBrowserCompat(context1, componentName1, b0, null);
            b0.d = mediaBrowserCompat0;
            mediaBrowserCompat0.connect();
            return;
        }
        Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent0);
    }
}

