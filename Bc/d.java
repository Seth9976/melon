package bc;

import Yb.f;
import Yb.n;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.v4x.common.NotificationActionTypeHelper;

public abstract class d {
    public static void a(Notification httpResponse$Notification0) {
        if(NotificationActionTypeHelper.isViewTypeSubBlock(httpResponse$Notification0)) {
            throw new n(httpResponse$Notification0.message, f.c);
        }
    }
}

