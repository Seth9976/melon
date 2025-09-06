package androidx.appcompat.app;

import A7.d;
import Q0.a;
import W.p;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.media3.session.N0;
import androidx.media3.session.legacy.E;
import androidx.mediarouter.app.MediaRouteChooserDialog;
import com.gaa.sdk.iap.l;
import com.google.android.gms.common.api.Status;
import com.iloen.melon.custom.MelonWebView;
import com.iloen.melon.mediastore.MelonMediaProvider;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import e3.m;
import e3.n;
import e3.o;
import i.n.i.b.a.s.e.L7;
import i.n.i.b.a.s.e.qc;
import i.n.i.b.a.s.e.rc;
import i.n.i.b.a.s.e.u9;
import j3.b;
import j3.e;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class z extends BroadcastReceiver {
    public final int a;
    public final Object b;

    public z(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        int v = 4;
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                ((a)object0).o();
                return;
            }
            case 1: {
                if(Objects.equals(intent0.getAction(), "android.intent.action.MEDIA_BUTTON")) {
                    Uri uri0 = intent0.getData();
                    if(Objects.equals(uri0, uri0)) {
                        KeyEvent keyEvent0 = (KeyEvent)intent0.getParcelableExtra("android.intent.extra.KEY_EVENT");
                        if(keyEvent0 != null) {
                            ((E)((p)((N0)object0).k.b).a).a.dispatchMediaButtonEvent(keyEvent0);
                        }
                    }
                }
                return;
            }
            case 2: {
                if("android.intent.action.SCREEN_OFF".equals(intent0.getAction())) {
                    ((MediaRouteChooserDialog)object0).dismiss();
                }
                return;
            }
            case 3: {
                if(intent0 == null) {
                    LogU.w("MelonWebView", "onReceiver() invalid intent");
                    return;
                }
                String s = intent0.getAction();
                if(s == null) {
                    LogU.w("MelonWebView", "onReceiver() invalid action");
                    return;
                }
                LogU.w("MelonWebView", "onReceiver() action: " + s);
                if("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(s)) {
                    Bundle bundle0 = intent0.getExtras();
                    Status status0 = (Status)bundle0.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
                    LogU.d("MelonWebView", "onReceive status : " + status0);
                    switch(status0.getStatusCode()) {
                        case 0: {
                            if(intent0.getExtras() == null) {
                                LogU.w("MelonWebView", "onReceiver() invalid bundle");
                                return;
                            }
                            String s1 = (String)bundle0.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
                            LogU.d("MelonWebView", "msg:" + s1);
                            ToastManager.debug(("msg:" + s1));
                            l l0 = ((MelonWebView)object0).f;
                            if(l0 == null) {
                                LogU.w("MelonWebView", "onReceiver() invalid smsRecvInfo");
                                return;
                            }
                            String s2 = l0.c;
                            if(!TextUtils.isEmpty(s1)) {
                                LogU.d("MelonWebView", "onReceiver() serverOriginNumber:" + l0.e);
                                String s3 = null;
                                if(TextUtils.isEmpty(s2)) {
                                    LogU.w("MelonWebView", "onReceiver() invalid pattern");
                                    ((MelonWebView)object0).f = null;
                                    return;
                                }
                                try {
                                    Matcher matcher0 = Pattern.compile(s2).matcher(s1);
                                    if(matcher0.find()) {
                                        s3 = matcher0.group(l0.d);
                                        LogU.d("MelonWebView", "onReceiver() authNumber:" + s3);
                                    }
                                    else {
                                        LogU.w("MelonWebView", "onReceiver() pattern not found");
                                    }
                                }
                                catch(Exception exception0) {
                                    LogU.d("MelonWebView", "onReceiver() " + exception0);
                                }
                                if(!TextUtils.isEmpty(s3)) {
                                    String s4 = d.n(new StringBuilder("javascript:"), l0.b, "(\'", s3, "\')");
                                    LogU.w("MelonWebView", "onReceiver() javascript > " + s4);
                                    ToastManager.debug(s4);
                                    ((MelonWebView)object0).loadUrl(s4);
                                }
                            }
                            ((MelonWebView)object0).c();
                            break;
                        }
                        case 15: {
                            ((MelonWebView)object0).c();
                            return;
                        }
                        default: {
                            return;
                        }
                    }
                }
                return;
            }
            case 4: {
                o o0 = (o)object0;
                ConnectivityManager connectivityManager0 = (ConnectivityManager)context0.getSystemService("connectivity");
                int v1 = 0;
                if(connectivityManager0 != null) {
                    try {
                        NetworkInfo networkInfo0 = connectivityManager0.getActiveNetworkInfo();
                    }
                    catch(SecurityException unused_ex) {
                        goto label_96;
                    }
                    if(networkInfo0 == null || !networkInfo0.isConnected()) {
                        v1 = 1;
                    }
                    else {
                    alab1:
                        switch(networkInfo0.getType()) {
                            case 1: {
                                v1 = 2;
                                break;
                            }
                            case 0: 
                            case 4: 
                            case 5: {
                                switch(networkInfo0.getSubtype()) {
                                    case 1: 
                                    case 2: {
                                        v1 = 3;
                                        break alab1;
                                    }
                                    case 13: {
                                        v1 = 5;
                                        break alab1;
                                    }
                                    case 3: 
                                    case 4: 
                                    case 5: 
                                    case 6: 
                                    case 7: 
                                    case 8: 
                                    case 9: 
                                    case 10: 
                                    case 11: 
                                    case 12: 
                                    case 14: 
                                    case 15: 
                                    case 17: {
                                        v1 = 4;
                                        break alab1;
                                    }
                                    case 18: {
                                        v1 = 2;
                                        break alab1;
                                    }
                                    case 20: {
                                        v1 = 9;
                                        break alab1;
                                    }
                                    default: {
                                        v1 = 6;
                                        break alab1;
                                    }
                                }
                            }
                            case 6: {
                                v1 = 5;
                                break;
                            }
                            case 9: {
                                v1 = 7;
                                break;
                            }
                            default: {
                                v1 = 8;
                            }
                        }
                    }
                }
            label_96:
                if(v1 == 5) {
                    try {
                        TelephonyManager telephonyManager0 = (TelephonyManager)context0.getSystemService("phone");
                        telephonyManager0.getClass();
                        n n0 = new n(o0);
                        telephonyManager0.registerTelephonyCallback(context0.getMainExecutor(), n0);
                        telephonyManager0.unregisterTelephonyCallback(n0);
                    }
                    catch(RuntimeException unused_ex) {
                        o.a(5, o0);
                    }
                    return;
                }
                o.a(v1, o0);
                return;
            }
            case 5: {
                rc rc0 = (rc)object0;
                ConnectivityManager connectivityManager1 = (ConnectivityManager)context0.getSystemService("connectivity");
                if(connectivityManager1 == null) {
                label_135:
                    v = 0;
                }
                else {
                    try {
                        NetworkInfo networkInfo1 = connectivityManager1.getActiveNetworkInfo();
                    }
                    catch(SecurityException unused_ex) {
                        goto label_135;
                    }
                    if(networkInfo1 == null || !networkInfo1.isConnected()) {
                        v = 1;
                    }
                    else {
                    alab2:
                        switch(networkInfo1.getType()) {
                            case 1: {
                                v = 2;
                                break;
                            }
                            case 0: 
                            case 4: 
                            case 5: {
                                switch(networkInfo1.getSubtype()) {
                                    case 1: 
                                    case 2: {
                                        v = 3;
                                        break alab2;
                                    }
                                    case 13: {
                                        v = 5;
                                        break alab2;
                                    }
                                    case 3: 
                                    case 4: 
                                    case 5: 
                                    case 6: 
                                    case 7: 
                                    case 8: 
                                    case 9: 
                                    case 10: 
                                    case 11: 
                                    case 12: 
                                    case 14: 
                                    case 15: 
                                    case 17: {
                                        break alab2;
                                    }
                                    case 18: {
                                        v = 2;
                                        break alab2;
                                    }
                                    case 20: {
                                        if(L7.a >= 29) {
                                            v = 9;
                                        }
                                        else {
                                            goto label_135;
                                        }
                                        break alab2;
                                    }
                                    default: {
                                        v = 6;
                                        break alab2;
                                    }
                                }
                            }
                            case 6: {
                                v = 5;
                                break;
                            }
                            case 9: {
                                v = 7;
                                break;
                            }
                            default: {
                                v = 8;
                            }
                        }
                    }
                }
                if(v == 5) {
                    int v2 = L7.a;
                    if(v2 >= 29) {
                        try {
                            TelephonyManager telephonyManager1 = (TelephonyManager)context0.getSystemService("phone");
                            telephonyManager1.getClass();
                            qc qc0 = new qc(rc0);
                            if(v2 < 0x1F) {
                                telephonyManager1.listen(qc0, 1);
                            }
                            else {
                                telephonyManager1.listen(qc0, 0x100000);
                            }
                            telephonyManager1.listen(qc0, 0);
                            return;
                        }
                        catch(RuntimeException unused_ex) {
                        }
                    }
                }
                rc.b(rc0, v);
                return;
            }
            case 6: {
                u9 u90 = new u9(((K0.d)object0), 5);
                ((Handler)((K0.d)object0).e).post(u90);
                return;
            }
            case 7: {
                if(intent0.getAction().equals("android.intent.action.MEDIA_EJECT") || intent0.getAction().equals("android.intent.action.MEDIA_UNMOUNTED")) {
                    ((MelonMediaProvider)object0).b(Uri.parse("content://com.iloen.melon.provider.melondcf/external"));
                    MelonMediaProvider.w.clear();
                }
                return;
            }
            case 8: {
                if(!this.isInitialStickyBroadcast()) {
                    ((e)object0).a(b.b(context0, intent0, ((e)object0).i, ((e)object0).h));
                }
                return;
            }
            case 9: {
                ((m)object0).f();
                return;
            }
            default: {
                ((r.d)object0).m.startQuery(42, null, r.d.o, new String[]{"CarConnectionState"}, null, null, null);
            }
        }
    }
}

