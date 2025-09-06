package androidx.media3.session;

import A6.i;
import android.app.NotificationManager;
import android.content.Context;
import androidx.media3.exoplayer.x;
import e3.b;

public class DefaultMediaNotificationProvider implements o0 {
    public static final class Builder {
        public final Context a;
        public x b;
        public String c;
        public int d;
        public boolean e;

        public Builder(Context context0) {
            this.a = context0;
            this.b = new x(1);
            this.c = "default_channel_id";
            this.d = 0x7F1302E0;  // string:default_notification_channel_name "@com.iloen.melon:string/notification_channel_player"
        }
    }

    public final Context a;
    public final x b;
    public final String c;
    public final int d;
    public final NotificationManager e;
    public i f;
    public final int g;

    public DefaultMediaNotificationProvider(Context context0) {
        this(context0, new x(1), "default_channel_id", 0x7F1302E0);  // string:default_notification_channel_name "@com.iloen.melon:string/notification_channel_player"
    }

    public DefaultMediaNotificationProvider(Context context0, x x0, String s, int v) {
        this.a = context0;
        this.b = x0;
        this.c = s;
        this.d = v;
        NotificationManager notificationManager0 = (NotificationManager)context0.getSystemService("notification");
        b.k(notificationManager0);
        this.e = notificationManager0;
        this.g = 0x7F08070A;  // drawable:media3_notification_small_icon
    }
}

