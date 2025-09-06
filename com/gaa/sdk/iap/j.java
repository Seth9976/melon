package com.gaa.sdk.iap;

import E9.g;
import Z8.b;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.ResultReceiver;
import com.gaa.sdk.base.ConnectionInfo;
import com.iloen.melon.MelonAppBase;
import d5.c;

public final class j {
    public int a;
    public final Context b;
    public boolean c;
    public int d;
    public final c e;
    public K5.c f;
    public i g;
    public final String h;
    public final ConnectionInfo i;
    public final g j;
    public final Handler k;
    public final ResultReceiver l;

    public j(MelonAppBase melonAppBase0, Z8.g g0) {
        this.a = 0;
        this.c = false;
        this.d = 6;
        g g1 = new g(7);
        this.j = g1;
        this.k = (Handler)g1.a;
        this.l = new PurchaseClientImpl.1(this, ((Handler)g1.a));
        Context context0 = melonAppBase0.getApplicationContext();
        this.b = context0;
        this.i = new ConnectionInfo(context0);
        this.e = new c(melonAppBase0.getApplicationContext(), g0);
        this.h = "21.00.00";
    }

    public final void a(d d0) {
        ((a)this.e.c).a.g(d0, null);
    }

    public final d b() {
        return this.a == 0 || this.a == 3 ? B.a.Z(2) : B.a.Z(6);
    }

    public final boolean c() {
        return this.a == 2 && this.f != null && this.g != null;
    }

    public final void d(Activity activity0, b b0) {
        PurchaseClientImpl.2 purchaseClientImpl$20 = new PurchaseClientImpl.2(this, this.k, b0);
        Intent intent0 = new Intent(activity0, ProxyActivity.class);
        intent0.setAction("com.gaa.sdk.ACTION_DOWNLOAD");
        intent0.putExtra("result_receiver", purchaseClientImpl$20);
        intent0.putExtra("connection_info", this.i);
        activity0.startActivity(intent0);
    }
}

