package com.iloen.melon.push;

import Q1.c;
import Tf.o;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat.Builder;
import androidx.media3.session.H0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.request.PushSetReq.ParamInfo;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.json.JSONException;
import org.json.JSONObject;
import p9.b;
import p9.e;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/push/PushAlertReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "p9/b", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PushAlertReceiver extends BroadcastReceiver {
    public int a;

    static {
    }

    public PushAlertReceiver() {
        this.a = MelonSettingInfo.incrementAndGetPushNotificationId();
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        String s5;
        q.g(context0, "context");
        if(intent0 == null) {
            LogU.Companion.w("PushAlertReceiver", "onReceive() invalid intent");
            return;
        }
        String s = intent0.getAction();
        if(TextUtils.isEmpty(s)) {
            LogU.Companion.w("PushAlertReceiver", "onReceive() invalid action");
            return;
        }
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("PushAlertReceiver", "onReceive() action: " + s);
        if(intent0.getExtras() == null) {
            logU$Companion0.w("PushAlertReceiver", "onReceive() invalid extras");
            return;
        }
        Bundle bundle0 = intent0.getExtras();
        if((bundle0 == null ? null : bundle0.keySet()) == null) {
            logU$Companion0.w("PushAlertReceiver", "onReceive() invalid keySet");
            return;
        }
        if(s != null) {
            boolean z = false;
            String s1 = "";
            switch(s) {
                case "android.intent.action.BOOT_COMPLETED": {
                    if(!MelonSettingInfo.getUsePushAlert() && !MelonSettingInfo.getUseMarketingPushAlert()) {
                        logU$Companion0.d("PushAlertReceiver", "onReceive() push alert off");
                        return;
                    }
                    e e0 = new e();
                    e0.a = 0;
                    e0.execute(null);
                    return;
                }
                case "com.google.android.c2dm.intent.RECEIVE": 
                case "com.google.android.c2dm.intent.REGISTRATION": {
                    logU$Companion0.d("PushAlertReceiver", "onReceive() PUSH_REG || PUSH_MSG");
                    return;
                }
                case "com.iloen.android.push.intent.RECEIVE": {
                    if(!MelonSettingInfo.getUsePushAlert() && !MelonSettingInfo.getUseMarketingPushAlert()) {
                        logU$Companion0.d("PushAlertReceiver", "onReceive() push alert off");
                        return;
                    }
                    String s3 = intent0.getStringExtra("val");
                    String s4 = "-1";
                    if(s3 == null) {
                        s5 = "";
                    }
                    else {
                        String[] arr_s = (String[])o.R0(s3, new String[]{"/"}, 0, 6).toArray(new String[0]);
                        if(arr_s.length > 0) {
                            s5 = arr_s[0];
                            if(s5 == null) {
                                s5 = "";
                            }
                        }
                        else {
                            s5 = "";
                        }
                        if("msg".equalsIgnoreCase(s5) && arr_s.length > 1) {
                            String s6 = arr_s[1];
                            if(s6 != null) {
                                s4 = s6;
                            }
                        }
                    }
                    if("msg".equalsIgnoreCase(s5)) {
                        MelonAppBase.Companion.getClass();
                        if(t.a().isMusicMessageForeground() && q.b(t.a().getMusicMessageCurrentInboxSeq(), s4)) {
                            Intent intent1 = new Intent();
                            c.Z(intent1, "com.iloen.melon.intent.action.music_message", 2);
                            intent1.putExtra("com.iloen.melon.intent.action.music_message.inbox_seq", s4);
                            context0.sendBroadcast(intent1);
                            return;
                        }
                    }
                    if("msg".equalsIgnoreCase(s5)) {
                        int v1 = Integer.parseInt(s4);
                        if(v1 > 0) {
                            this.a = v1;
                        }
                    }
                    PushItemInfo pushItemInfo0 = new PushItemInfo();
                    String s7 = intent0.getStringExtra("content");
                    if(s7 == null) {
                        s7 = "";
                    }
                    pushItemInfo0.a = s7;
                    String s8 = intent0.getStringExtra("val");
                    if(s8 == null) {
                        s8 = "";
                    }
                    pushItemInfo0.b = s8;
                    String s9 = intent0.getStringExtra("pid");
                    if(s9 == null) {
                        s9 = "";
                    }
                    pushItemInfo0.c = s9;
                    String s10 = intent0.getStringExtra("seq");
                    if(s10 == null) {
                        s10 = "";
                    }
                    pushItemInfo0.f = s10;
                    String s11 = intent0.getStringExtra("title");
                    if(s11 == null) {
                        s11 = "";
                    }
                    pushItemInfo0.g = s11;
                    String s12 = intent0.getStringExtra("licon");
                    if(s12 == null) {
                        s12 = "";
                    }
                    pushItemInfo0.e = s12;
                    String s13 = intent0.getStringExtra("imgUrl");
                    if(s13 == null) {
                        s13 = "";
                    }
                    pushItemInfo0.d = s13;
                    intent0.getStringExtra("action");
                    String s14 = intent0.getStringExtra("msgType");
                    if(s14 != null) {
                        s1 = s14;
                    }
                    pushItemInfo0.h = s1;
                    String s15 = intent0.getStringExtra("tiaraInfo");
                    if(!TextUtils.isEmpty(s15) && s15 != null) {
                        try {
                            JSONObject jSONObject0 = new JSONObject(s15);
                            String s16 = jSONObject0.getString("source");
                            q.f(s16, "getString(...)");
                            pushItemInfo0.j = s16;
                            String s17 = jSONObject0.getString("channel");
                            q.f(s17, "getString(...)");
                            pushItemInfo0.k = s17;
                            String s18 = jSONObject0.getString("messageId");
                            q.f(s18, "getString(...)");
                            pushItemInfo0.l = s18;
                            String s19 = jSONObject0.getString("object");
                            q.f(s19, "getString(...)");
                            pushItemInfo0.m = s19;
                            String s20 = jSONObject0.getString("menuid");
                            q.f(s20, "getString(...)");
                            pushItemInfo0.n = s20;
                        }
                        catch(JSONException jSONException0) {
                            jSONException0.printStackTrace();
                        }
                    }
                    q.g("1757129604804", "<set-?>");
                    pushItemInfo0.i = "1757129604804";
                    String s21 = intent0.getStringExtra("badge");
                    pushItemInfo0.o = s21 == null ? 0 : Integer.parseInt(s21);
                    Object object0 = context0.getSystemService("notification");
                    q.e(object0, "null cannot be cast to non-null type android.app.NotificationManager");
                    PushNotification pushNotification0 = new PushNotification(context0);
                    Notification notification0 = pushNotification0.c(pushItemInfo0, new H0(25, ((NotificationManager)object0), this));
                    if(pushItemInfo0.o > 0) {
                        z = true;
                    }
                    ((NotificationManager)object0).notify(this.a, notification0);
                    if(!"msg".equalsIgnoreCase(s5) && !"gift".equalsIgnoreCase(s5)) {
                        NotificationCompat.Builder notificationCompat$Builder0 = pushNotification0.b(z);
                        notificationCompat$Builder0.G.icon = 0x7F0805BF;  // drawable:ic_push_big
                        notificationCompat$Builder0.e(16, true);
                        notificationCompat$Builder0.e(8, true);
                        notificationCompat$Builder0.r = z ? "push_group_key_badge" : "push_group_key_default";
                        notificationCompat$Builder0.s = true;
                        notificationCompat$Builder0.D = 2;
                        Notification notification1 = notificationCompat$Builder0.a();
                        q.f(notification1, "build(...)");
                        ((NotificationManager)object0).notify(((int)z), notification1);
                    }
                    break;
                }
                case "com.iloen.android.push.intent.REGISTRATION": {
                    ParamInfo pushSetReq$ParamInfo0 = new ParamInfo();
                    pushSetReq$ParamInfo0.memberKey = intent0.getStringExtra("memberKey");
                    pushSetReq$ParamInfo0.certificateType = "R0";
                    pushSetReq$ParamInfo0.deviceToken = intent0.getStringExtra("deviceToken");
                    pushSetReq$ParamInfo0.sendTypeCode = intent0.getStringExtra("sendTypeCode");
                    pushSetReq$ParamInfo0.appTypeCode = intent0.getStringExtra("appTypeCode");
                    pushSetReq$ParamInfo0.appVer = intent0.getStringExtra("appVer");
                    pushSetReq$ParamInfo0.deviceOsVer = intent0.getStringExtra("deviceOsVer");
                    pushSetReq$ParamInfo0.deviceModelName = intent0.getStringExtra("deviceModelName");
                    pushSetReq$ParamInfo0.pushNotifyYn = intent0.getStringExtra("pushNotifyYn");
                    pushSetReq$ParamInfo0.mannerModeYn = intent0.getStringExtra("mannerModeYn");
                    pushSetReq$ParamInfo0.mannerModeStartTime = intent0.getStringExtra("mannerModeStartTime");
                    pushSetReq$ParamInfo0.mannerModeEndTime = intent0.getStringExtra("mannerModeEndTime");
                    pushSetReq$ParamInfo0.mktRecvAgreeYn = intent0.getStringExtra("mktRecvAgreeYn");
                    int v = intent0.getIntExtra("callFrom", -1);
                    String s2 = intent0.getStringExtra("pushType");
                    if(s2 != null) {
                        s1 = s2;
                    }
                    logU$Companion0.d("PushAlertReceiver", "onReceive() PUSH_REGISTRATION callFrom: " + v);
                    new b(context0, pushSetReq$ParamInfo0, v, s1).execute(null);
                }
            }
        }
    }
}

