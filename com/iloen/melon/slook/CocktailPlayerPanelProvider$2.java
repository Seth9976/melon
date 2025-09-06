package com.iloen.melon.slook;

import android.content.ComponentName;
import android.content.Context;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.slook.request.SlookListReqDelegator.DelegateEventListener;
import com.samsung.android.sdk.look.cocktailbar.SlookCocktailManager;

class CocktailPlayerPanelProvider.2 implements DelegateEventListener {
    public final Context a;

    public CocktailPlayerPanelProvider.2(CocktailPlayerPanelProvider cocktailPlayerPanelProvider0, Context context0) {
        this.a = context0;
    }

    @Override  // com.iloen.melon.slook.request.SlookListReqDelegator$DelegateEventListener
    public void onFailed() {
        SlookCocktailManager slookCocktailManager0 = SlookCocktailManager.getInstance(this.a);
        slookCocktailManager0.notifyCocktailViewDataChanged(slookCocktailManager0.getCocktailIds(new ComponentName(this.a, CocktailPlayerPanelProvider.class))[0], 0x7F0A09E6);  // id:remote_list
    }

    @Override  // com.iloen.melon.slook.request.SlookListReqDelegator$DelegateEventListener
    public void onSuccess(HttpResponse httpResponse0) {
        SlookCocktailManager slookCocktailManager0 = SlookCocktailManager.getInstance(this.a);
        slookCocktailManager0.notifyCocktailViewDataChanged(slookCocktailManager0.getCocktailIds(new ComponentName(this.a, CocktailPlayerPanelProvider.class))[0], 0x7F0A09E6);  // id:remote_list
    }
}

