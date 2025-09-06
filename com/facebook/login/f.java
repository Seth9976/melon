package com.facebook.login;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.Callback;

public final class f implements Callback {
    public final LoginManager a;

    public f(LoginManager loginManager0) {
        this.a = loginManager0;
    }

    @Override  // com.facebook.internal.CallbackManagerImpl$Callback
    public final boolean onActivityResult(int v, Intent intent0) {
        return LoginManager.startLogin$lambda$1(this.a, v, intent0);
    }
}

