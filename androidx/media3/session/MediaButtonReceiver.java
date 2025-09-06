package androidx.media3.session;

import B0.t;
import P1.c;
import android.app.ForegroundServiceStartNotAllowedException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import com.iloen.melon.utils.a;
import e3.b;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MediaButtonReceiver extends BroadcastReceiver {
    public static final String[] a;

    static {
        MediaButtonReceiver.a = new String[]{"android.intent.action.MEDIA_BUTTON", "androidx.media3.session.MediaLibraryService", "androidx.media3.session.MediaSessionService"};
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        ComponentName componentName0;
        String[] arr_s;
        if(intent0 != null && Objects.equals(intent0.getAction(), "android.intent.action.MEDIA_BUTTON") && intent0.hasExtra("android.intent.extra.KEY_EVENT")) {
            Bundle bundle0 = intent0.getExtras();
            bundle0.getClass();
            KeyEvent keyEvent0 = (KeyEvent)bundle0.getParcelable("android.intent.extra.KEY_EVENT");
            if(keyEvent0 != null && keyEvent0.getAction() == 0 && keyEvent0.getRepeatCount() == 0) {
                switch(keyEvent0.getKeyCode()) {
                    case 0x4F: 
                    case 85: 
                    case 0x7E: {
                        int v = 0;
                        while(true) {
                            arr_s = MediaButtonReceiver.a;
                            if(v >= 3) {
                                break;
                            }
                            String s = arr_s[v];
                            PackageManager packageManager0 = context0.getPackageManager();
                            Intent intent1 = new Intent(s);
                            intent1.setPackage("com.iloen.melon");
                            List list0 = packageManager0.queryIntentServices(intent1, 0);
                            if(list0.size() == 1) {
                                ServiceInfo serviceInfo0 = ((ResolveInfo)list0.get(0)).serviceInfo;
                                componentName0 = new ComponentName(serviceInfo0.packageName, serviceInfo0.name);
                            }
                            else {
                                if(!list0.isEmpty()) {
                                    goto label_33;
                                }
                                componentName0 = null;
                            }
                            if(componentName0 != null) {
                                intent0.setComponent(componentName0);
                                try {
                                    c.startForegroundService(context0, intent0);
                                }
                                catch(IllegalStateException illegalStateException0) {
                                    if(Build.VERSION.SDK_INT < 0x1F || !t.C(illegalStateException0)) {
                                        throw illegalStateException0;
                                    }
                                    b.p("MediaButtonReceiver", "caught exception when trying to start a foreground service from the background: " + ((ForegroundServiceStartNotAllowedException)illegalStateException0).getMessage());
                                }
                                return;
                            }
                            ++v;
                            continue;
                        label_33:
                            StringBuilder stringBuilder0 = a.n("Expected 1 service that handles ", s, ", found ");
                            stringBuilder0.append(list0.size());
                            throw new IllegalStateException(stringBuilder0.toString());
                        }
                        throw new IllegalStateException("Could not find any Service that handles any of the actions " + Arrays.toString(arr_s));
                    }
                    default: {
                        Log.w("MediaButtonReceiver", "Ignore key event that is not a `play` command on API 26 or above to avoid an \'ForegroundServiceDidNotStartInTimeException\'");
                        return;
                    }
                }
            }
            return;
        }
        Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent0);
    }
}

