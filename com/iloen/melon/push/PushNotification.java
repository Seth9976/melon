package com.iloen.melon.push;

import A7.d;
import N1.p;
import N1.r;
import Tf.v;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.graphics.drawable.IconCompat;
import androidx.media3.session.H0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.analytics.ClickLog;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.image.ImageUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.NotificationHelper.NotificationInfo;
import com.iloen.melon.utils.system.NotificationHelper;
import com.iloen.melon.utils.system.ScreenUtils;
import com.kakao.tiara.data.TrafficSource.Builder;
import com.kakao.tiara.data.TrafficSource;
import d5.s;
import java.util.HashMap;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;
import p9.c;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/push/PushNotification;", "Lcom/iloen/melon/utils/system/NotificationHelper;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PushNotification extends NotificationHelper {
    public Bitmap b;
    public Bitmap c;

    public PushNotification(@Nullable Context context0) {
        super(context0);
    }

    public final NotificationInfo a(PushItemInfo pushItemInfo0) {
        Bitmap bitmap1;
        p p0;
        String s3;
        String s = pushItemInfo0.c;
        String s1 = pushItemInfo0.e;
        String s2 = pushItemInfo0.f;
        int v = pushItemInfo0.o;
        StringBuilder stringBuilder0 = d.o("buildNotification() content: ", pushItemInfo0.a, ", pushVal: ", pushItemInfo0.b, ", pid: ");
        d.u(stringBuilder0, s, " , largeIconUri: ", s1, " , seq: ");
        stringBuilder0.append(s2);
        stringBuilder0.append(" , badge: ");
        stringBuilder0.append(v);
        LogU.Companion.d("PushNotification", stringBuilder0.toString());
        NotificationInfo notificationHelper$NotificationInfo0 = new NotificationInfo();
        Object object0 = this.mContext.getSystemService("audio");
        q.e(object0, "null cannot be cast to non-null type android.media.AudioManager");
        int v1 = ((AudioManager)object0).getRingerMode();
        notificationHelper$NotificationInfo0.hasLargeIcon = this.b != null;
        Intent intent0 = new Intent("com.iloen.melon.MELON_PUSH_ACT_START");
        intent0.addCategory("android.intent.category.DEFAULT");
        intent0.addFlags(0x10000000);
        intent0.putExtra("val", pushItemInfo0.b);
        intent0.putExtra("pid", pushItemInfo0.c);
        intent0.putExtra("bigPictureUri", pushItemInfo0.d);
        intent0.putExtra("largeIconUri", pushItemInfo0.e);
        intent0.putExtra("seq", pushItemInfo0.f);
        intent0.putExtra("from", "indicator");
        intent0.putExtra("channel", pushItemInfo0.k);
        intent0.putExtra("source", pushItemInfo0.j);
        intent0.putExtra("messageId", pushItemInfo0.l);
        intent0.putExtra("object", pushItemInfo0.m);
        intent0.putExtra("menuId", pushItemInfo0.n);
        intent0.putExtra("msgType", pushItemInfo0.h);
        intent0.putExtra("badge", pushItemInfo0.o);
        int v2 = TextUtils.isEmpty(pushItemInfo0.f) ? 0 : Integer.parseInt(pushItemInfo0.f);
        PendingIntent pendingIntent0 = PendingIntent.getActivity(this.mContext, v2, intent0, 0xC000000);
        Uri uri0 = RingtoneManager.getDefaultUri(2);
        boolean z = pushItemInfo0.o > 0;
        NotificationCompat.Builder notificationCompat$Builder0 = this.b(z);
        Notification notification0 = notificationCompat$Builder0.G;
        if(TextUtils.isEmpty(pushItemInfo0.g)) {
            s3 = "Melon";
            q.f("Melon", "getString(...)");
        }
        else {
            s3 = pushItemInfo0.g;
        }
        Bitmap bitmap0 = this.c;
        int v3 = bitmap0 != null || this.b != null ? 0x7F0805C1 : 0x7F0805BF;  // drawable:ic_push_small
        if(bitmap0 == null) {
            String s5 = pushItemInfo0.a;
            p0 = new N1.q(0);
            p0.e = NotificationCompat.Builder.b(s5);
        }
        else {
            String s4 = pushItemInfo0.a;
            p0 = new p();  // 初始化器: LN1/s;-><init>()V
            IconCompat iconCompat0 = new IconCompat(1);
            iconCompat0.b = bitmap0;
            p0.d = iconCompat0;
            p0.b = NotificationCompat.Builder.b(s4);
            p0.c = true;
        }
        MelonAppBase.Companion.getClass();
        int v4 = ColorUtils.getColor(t.a().getContext(), 0x7F06017A);  // color:green500e_support_high_contrast
        boolean z1 = !TextUtils.isEmpty(pushItemInfo0.b) && (v.r0(pushItemInfo0.b, "msg/", false) || v.r0(pushItemInfo0.b, "gift/", false));
        if(z1) {
            bitmap1 = this.b;
            if(bitmap1 == null) {
                int v5 = ScreenUtils.dipToPixel(this.mContext, 64.0f);
                bitmap1 = ImageUtils.getCircledBitmap(ImageUtils.getResourceBitmapImpl(0x7F0805C0), v5, v5);  // drawable:ic_push_noimage
                q.f(bitmap1, "getCircledBitmap(...)");
            }
        }
        else {
            bitmap1 = this.b;
            if(bitmap1 == null) {
                bitmap1 = ImageUtils.getResourceBitmapImpl(0x7F080598);  // drawable:ic_onesignal_large_icon_default
            }
        }
        notificationCompat$Builder0.g = pendingIntent0;
        notificationCompat$Builder0.e(2, false);
        notificationCompat$Builder0.e = NotificationCompat.Builder.b(s3);
        notificationCompat$Builder0.f = NotificationCompat.Builder.b(pushItemInfo0.a);
        notificationCompat$Builder0.z = v4;
        notificationCompat$Builder0.e(8, true);
        notificationCompat$Builder0.e(16, true);
        notificationCompat$Builder0.G.ledARGB = v4;
        notificationCompat$Builder0.G.ledOnMS = 500;
        notificationCompat$Builder0.G.ledOffMS = 500;
        notificationCompat$Builder0.G.flags |= 1;
        notification0.icon = v3;
        notificationCompat$Builder0.g(p0);
        notificationCompat$Builder0.t = pushItemInfo0.i;
        notificationCompat$Builder0.i = pushItemInfo0.o;
        notificationCompat$Builder0.C = 1;
        if(bitmap1 != null) {
            notificationCompat$Builder0.f(bitmap1);
        }
        switch(v1) {
            case 1: {
                notification0.vibrate = new long[]{1000L, 1000L};
                break;
            }
            case 2: {
                notificationCompat$Builder0.G.sound = uri0;
                notificationCompat$Builder0.G.audioStreamType = -1;
                notificationCompat$Builder0.G.audioAttributes = r.a(r.d(r.c(r.b(), 4), 5));
            }
        }
        notificationCompat$Builder0.A = 1;
        if(!z1) {
            notificationCompat$Builder0.r = z ? "push_group_key_badge" : "push_group_key_default";
        }
        Notification notification1 = notificationCompat$Builder0.a();
        q.f(notification1, "build(...)");
        notificationHelper$NotificationInfo0.notif = notification1;
        return notificationHelper$NotificationInfo0;
    }

    public final NotificationCompat.Builder b(boolean z) {
        this.makeChannelId(3, (z ? "106" : "103"), "푸시", Boolean.valueOf(z));
        return new NotificationCompat.Builder(this.mContext, (z ? "106" : "103"));
    }

    public final Notification c(PushItemInfo pushItemInfo0, H0 h00) {
        if(!TextUtils.isEmpty(pushItemInfo0.d)) {
            Context context0 = this.mContext;
            if(context0 != null) {
                Glide.with(context0).asBitmap().load(pushItemInfo0.d).into(new c(this, pushItemInfo0, h00));
            }
        }
        if(!TextUtils.isEmpty(pushItemInfo0.e)) {
            Context context1 = this.mContext;
            if(context1 != null) {
                Glide.with(context1).asBitmap().load(pushItemInfo0.e).apply(RequestOptions.circleCropTransform()).into(new p9.d(this, pushItemInfo0, h00));
            }
        }
        NotificationInfo notificationHelper$NotificationInfo0 = this.a(pushItemInfo0);
        String s = pushItemInfo0.f;
        s s1 = new s();
        s1.a = "5";
        s1.d = "Z15";
        s1.h = "R2";
        s1.n = s;
        new ClickLog(s1).a();
        TrafficSource trafficSource0 = new Builder().source(pushItemInfo0.j).channel(pushItemInfo0.k).object(pushItemInfo0.m).messageId(pushItemInfo0.l).build();
        HashMap hashMap0 = p8.q.b();
        hashMap0.put("menuid", pushItemInfo0.n);
        p8.q.c().trackExtra("페이지 이동").customProps(hashMap0).page(pushItemInfo0.n).trafficSource(trafficSource0).adTrackId("2875552754074864296").track();
        return notificationHelper$NotificationInfo0.notif;
    }
}

