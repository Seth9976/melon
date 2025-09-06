package com.facebook.login;

import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.internal.CallbackManagerImpl.Callback;

public final class e implements Callback {
    public final LoginManager a;
    public final FacebookCallback b;

    public e(LoginManager loginManager0, FacebookCallback facebookCallback0) {
        this.a = loginManager0;
        this.b = facebookCallback0;
    }

    @Override  // com.facebook.internal.CallbackManagerImpl$Callback
    public final boolean onActivityResult(int v, Intent intent0) {
        return LoginManager.registerCallback$lambda$0(this.a, this.b, v, intent0);
    }
}

