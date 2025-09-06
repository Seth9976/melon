package com.facebook.appevents;

import com.facebook.appevents.codeless.CodelessManager;

public final class a implements Runnable {
    public final int a;
    public final String b;

    public a(String s, int v) {
        this.a = v;
        this.b = s;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            CodelessManager.a(this.b);
            return;
        }
        AnalyticsUserIDStore.setUserID$lambda$1(this.b);
    }
}

