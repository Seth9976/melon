package com.iloen.melon.slook;

import android.content.Context;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.slook.request.SlookListReqDelegator.DelegateEventListener;

class CocktailPlayerPanelProvider.1 implements DelegateEventListener {
    public final Context a;
    public final CocktailPlayerPanelProvider b;

    public CocktailPlayerPanelProvider.1(CocktailPlayerPanelProvider cocktailPlayerPanelProvider0, Context context0) {
        this.b = cocktailPlayerPanelProvider0;
        this.a = context0;
    }

    @Override  // com.iloen.melon.slook.request.SlookListReqDelegator$DelegateEventListener
    public void onFailed() {
        this.b.performUpdate(this.a, false);
        this.b.c(this.a);
    }

    @Override  // com.iloen.melon.slook.request.SlookListReqDelegator$DelegateEventListener
    public void onSuccess(HttpResponse httpResponse0) {
        this.b.performUpdate(this.a, false);
        this.b.c(this.a);
    }
}

