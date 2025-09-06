package com.google.android.gms.auth.api.signin.internal;

import U2.a;
import android.os.Bundle;
import androidx.loader.content.Loader;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Set;

final class zbv implements a {
    final SignInHubActivity zba;

    public zbv(SignInHubActivity signInHubActivity0, zbw zbw0) {
        this.zba = signInHubActivity0;
        super();
    }

    @Override  // U2.a
    public final Loader onCreateLoader(int v, Bundle bundle0) {
        Set set0 = GoogleApiClient.getAllClients();
        return new zbc(this.zba, set0);
    }

    @Override  // U2.a
    public final void onLoadFinished(Loader loader0, Object object0) {
        Void void0 = (Void)object0;
        this.zba.setResult(this.zba.zbe, this.zba.zbf);
        this.zba.finish();
    }

    @Override  // U2.a
    public final void onLoaderReset(Loader loader0) {
    }
}

