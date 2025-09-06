package androidx.core.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public abstract class NotificationCompatSideChannelService extends Service {
    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        intent0.getAction().equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL");
        return null;
    }
}

