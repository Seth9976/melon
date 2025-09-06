package com.iloen.melon.eventbus;

import com.iloen.melon.net.v4x.response.NotificationLoginRes;

public class EventLoginPromotionDialog {
    private NotificationLoginRes mRes;

    public EventLoginPromotionDialog(NotificationLoginRes notificationLoginRes0) {
        this.mRes = notificationLoginRes0;
    }

    public NotificationLoginRes getResponse() {
        return this.mRes;
    }
}

