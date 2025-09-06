package com.facebook.login;

import android.os.Bundle;

public final class d implements Runnable {
    public final LoginLogger a;
    public final Bundle b;

    public d(LoginLogger loginLogger0, Bundle bundle0) {
        this.a = loginLogger0;
        this.b = bundle0;
    }

    @Override
    public final void run() {
        LoginLogger.logHeartbeatEvent$lambda$0(this.a, this.b);
    }
}

