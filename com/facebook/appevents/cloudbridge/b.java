package com.facebook.appevents.cloudbridge;

import java.util.List;

public final class b implements Runnable {
    public final Integer a;
    public final List b;

    public b(Integer integer0, List list0) {
        this.a = integer0;
        this.b = list0;
    }

    @Override
    public final void run() {
        com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests.transformGraphRequestAndSendToCAPIGEndPoint.1.1.invoke$lambda$0(this.a, this.b);
    }
}

