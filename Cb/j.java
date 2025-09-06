package Cb;

import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventNotificationScheme;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.common.NotificationActionType;
import com.iloen.melon.net.v4x.common.NotificationActionTypeHelper;
import kotlin.jvm.internal.q;

public abstract class j {
    public static final void a(Notification httpResponse$Notification0, boolean z) {
        if(httpResponse$Notification0 != null) {
            if(!NotificationActionTypeHelper.isViewTypeNull(httpResponse$Notification0) && (z && !NotificationActionTypeHelper.isViewTypeNotifyScreen(NotificationActionType.valueOf(httpResponse$Notification0.actionType)))) {
                NotificationActionTypeHelper.performActionType(httpResponse$Notification0);
            }
            String s = httpResponse$Notification0.getRedirectScheme();
            if(s != null && s.length() != 0) {
                EventNotificationScheme eventNotificationScheme0 = new EventNotificationScheme();
                eventNotificationScheme0.scheme = s;
                EventBusHelper.post(eventNotificationScheme0);
            }
        }
    }

    public static void b(Notification httpResponse$Notification0, boolean z, int v) {
        if((v & 1) != 0) {
            z = true;
        }
        j.a(httpResponse$Notification0, z);
    }

    public static final boolean c(Notification httpResponse$Notification0) {
        if(httpResponse$Notification0 == null) {
            return true;
        }
        return NotificationActionTypeHelper.isViewTypeNull(httpResponse$Notification0) ? true : NotificationActionTypeHelper.isStatusNormal(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static final boolean d(HttpResponse httpResponse0) {
        q.g(httpResponse0, "<this>");
        return j.c(httpResponse0.notification);
    }
}

