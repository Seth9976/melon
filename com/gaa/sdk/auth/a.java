package com.gaa.sdk.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

public final class a implements b {
    public final int a;
    public final d b;
    public final Activity c;
    public final Z8.b d;

    public a(d d0, Z8.b b0, Activity activity0, int v) {
        this.a = v;
        this.b = d0;
        this.d = b0;
        this.c = activity0;
        super();
    }

    public a(d d0, Activity activity0, Z8.b b0) {
        this.a = 1;
        super();
        this.b = d0;
        this.c = activity0;
        this.d = b0;
    }

    @Override  // com.gaa.sdk.auth.b
    public void c(e e0, Intent intent0) {
        if(this.a != 0) {
            Z8.b b0 = this.d;
            if(!e0.a() && intent0 != null) {
                this.b.a(this.c, intent0, b0);
                return;
            }
            b0.a(e0);
            return;
        }
        Z8.b b1 = this.d;
        if(e0.a()) {
            y5.a.X("GaaSignInClientImpl", "Background login successfully completed.");
            b1.a(e0);
            return;
        }
        d d0 = this.b;
        Activity activity0 = this.c;
        if(e0.a == 11) {
            y5.a.X("GaaSignInClientImpl", "The service needs to be updated.");
            a a0 = new a(d0, activity0, b1);
            y5.a.X("GaaSignInClientImpl", "Start the service installation flow.");
            GaaSignInClientImpl.2 gaaSignInClientImpl$20 = new GaaSignInClientImpl.2(((Handler)d0.f.a), a0);
            Intent intent1 = new Intent(activity0, SignInActivity.class);
            intent1.setAction("com.gaa.sdk.ACTION_DOWNLOAD");
            intent1.putExtra("result_receiver", gaaSignInClientImpl$20);
            intent1.putExtra("connection_info", d0.e);
            activity0.startActivity(intent1);
            return;
        }
        if(intent0 != null) {
            d0.a(activity0, intent0, b1);
            return;
        }
        b1.a(e0);
    }
}

