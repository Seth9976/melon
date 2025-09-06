package p9;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.media3.session.H0;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.push.PushItemInfo;
import com.iloen.melon.push.PushNotification;
import com.iloen.melon.utils.system.NotificationHelper.NotificationInfo;
import kotlin.jvm.internal.q;

public final class d extends CustomTarget {
    public final PushNotification a;
    public final PushItemInfo b;
    public final H0 c;

    public d(PushNotification pushNotification0, PushItemInfo pushItemInfo0, H0 h00) {
        this.a = pushNotification0;
        this.b = pushItemInfo0;
        this.c = h00;
        super();
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.CustomTarget
    public final void onLoadFailed(Drawable drawable0) {
        super.onLoadFailed(drawable0);
        this.a.b = null;
        NotificationInfo notificationHelper$NotificationInfo0 = this.a.a(this.b);
        this.c.onUpdate(notificationHelper$NotificationInfo0.notif);
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object object0, Transition transition0) {
        q.g(((Bitmap)object0), "bitmap");
        this.a.b = (Bitmap)object0;
        NotificationInfo notificationHelper$NotificationInfo0 = this.a.a(this.b);
        this.c.onUpdate(notificationHelper$NotificationInfo0.notif);
    }
}

