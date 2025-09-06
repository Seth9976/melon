package com.google.firebase.messaging;

import Q1.c;
import U4.x;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.session.legacy.L;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import d5.m;
import i.n.i.b.a.s.e.v7;
import java.util.ArrayDeque;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import jeb.synthetic.FIN;

public class FirebaseMessagingService extends EnhancedIntentService {
    public Rpc g;
    public static final ArrayDeque h;

    static {
        FirebaseMessagingService.h = new ArrayDeque(10);
    }

    @Override  // com.google.firebase.messaging.EnhancedIntentService
    public final Intent b(Intent intent0) {
        return (Intent)((ArrayDeque)u.m().d).poll();
    }

    @Override  // com.google.firebase.messaging.EnhancedIntentService
    public final void c(Intent intent0) {
        String s = intent0.getAction();
        if(!"com.google.android.c2dm.intent.RECEIVE".equals(s) && !"com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(s)) {
            if("com.google.firebase.messaging.NEW_TOKEN".equals(s)) {
                this.e(intent0.getStringExtra("token"));
                return;
            }
            Log.d("FirebaseMessaging", "Unknown intent action: " + intent0.getAction());
            return;
        }
        String s1 = intent0.getStringExtra("google.message_id");
        if(TextUtils.isEmpty(s1)) {
        label_17:
            String s2 = intent0.getStringExtra("message_type");
            if(s2 == null) {
                s2 = "gcm";
            }
            switch(s2) {
                case "deleted_messages": {
                    break;
                }
                case "gcm": {
                    c.J(intent0);
                    Bundle bundle0 = intent0.getExtras();
                    if(bundle0 == null) {
                        bundle0 = new Bundle();
                    }
                    bundle0.remove("androidx.content.wakelockid");
                    if(L.f(bundle0)) {
                        L l0 = new L(bundle0);
                        ExecutorService executorService0 = Executors.newSingleThreadExecutor(new NamedThreadFactory("Firebase-Messaging-Network-Io"));
                        m m0 = new m(this, l0, executorService0);
                        int v = FIN.finallyOpen$NT();
                        if(m0.o()) {
                            FIN.finallyCodeBegin$NT(v);
                            executorService0.shutdown();
                            FIN.finallyCodeEnd$NT(v);
                        }
                        else {
                            FIN.finallyExec$NT(v);
                            if(c.T(intent0)) {
                                c.K(intent0.getExtras(), "_nf");
                            }
                            this.d(new RemoteMessage(bundle0));
                        }
                    }
                    else {
                        this.d(new RemoteMessage(bundle0));
                    }
                    break;
                }
                case "send_error": {
                    if(intent0.getStringExtra("google.message_id") == null) {
                        intent0.getStringExtra("message_id");
                    }
                    String s3 = intent0.getStringExtra("error");
                    new v7(s3);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
                    if(s3 != null) {
                        s3.toLowerCase(Locale.US).getClass();
                    }
                    break;
                }
                case "send_event": {
                    intent0.getStringExtra("google.message_id");
                    break;
                }
                default: {
                    Log.w("FirebaseMessaging", "Received message with unknown type: " + s2);
                }
            }
        }
        else {
            ArrayDeque arrayDeque0 = FirebaseMessagingService.h;
            if(!arrayDeque0.contains(s1)) {
                if(arrayDeque0.size() >= 10) {
                    arrayDeque0.remove();
                }
                arrayDeque0.add(s1);
                goto label_17;
            }
            else if(Log.isLoggable("FirebaseMessaging", 3)) {
                x.w("Received duplicate message: ", s1, "FirebaseMessaging");
            }
        }
        if(this.g == null) {
            this.g = new Rpc(this.getApplicationContext());
        }
        this.g.messageHandled(new CloudMessage(intent0));
    }

    public void d(RemoteMessage remoteMessage0) {
    }

    public void e(String s) {
    }
}

