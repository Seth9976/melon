package com.facebook.login;

import android.os.Bundle;
import android.util.Pair;
import com.facebook.internal.PlatformServiceClient.CompletedListener;
import e.a;

public final class g implements CompletedListener, a {
    public final Object a;
    public final Object b;

    public g(Object object0, Object object1) {
        this.a = object0;
        this.b = object1;
        super();
    }

    @Override  // com.facebook.internal.PlatformServiceClient$CompletedListener
    public void completed(Bundle bundle0) {
        GetTokenLoginMethodHandler.tryAuthorize$lambda$1(((GetTokenLoginMethodHandler)this.a), ((Request)this.b), bundle0);
    }

    @Override  // e.a
    public void onActivityResult(Object object0) {
        AndroidxActivityResultRegistryOwnerStartActivityDelegate.startActivityForResult$lambda$0(((AndroidxActivityResultRegistryOwnerStartActivityDelegate)this.a), ((LauncherHolder)this.b), ((Pair)object0));
    }
}

