package c9;

import com.android.volley.Response.Listener;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventLoginPromotionDialog;
import com.iloen.melon.net.v4x.response.NotificationLoginRes;

public final class d implements Listener {
    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        EventBusHelper.post(new EventLoginPromotionDialog(((NotificationLoginRes)object0)));
    }
}

