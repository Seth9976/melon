package com.iloen.melon.slook;

import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.response.DjTodayListForEdgeRes.RESPONSE.PLYLSTLIST;
import com.iloen.melon.net.v4x.response.DjTodayListForEdgeRes.RESPONSE;
import com.iloen.melon.net.v4x.response.DjTodayListForEdgeRes;
import com.iloen.melon.slook.request.SlookListReqDelegator.DelegateEventListener;
import com.iloen.melon.utils.log.LogU;
import d3.g;
import java.util.ArrayList;

class CocktailPlayerPanelProvider.6 implements DelegateEventListener {
    public final CocktailPlayerPanelProvider a;

    public CocktailPlayerPanelProvider.6(CocktailPlayerPanelProvider cocktailPlayerPanelProvider0) {
        this.a = cocktailPlayerPanelProvider0;
    }

    @Override  // com.iloen.melon.slook.request.SlookListReqDelegator$DelegateEventListener
    public void onFailed() {
        LogU.w("CocktailPlayerPanelProvider", "playMelonDjToday()$onFailed()");
    }

    @Override  // com.iloen.melon.slook.request.SlookListReqDelegator$DelegateEventListener
    public void onSuccess(HttpResponse httpResponse0) {
        if(((DjTodayListForEdgeRes)httpResponse0) != null) {
            RESPONSE djTodayListForEdgeRes$RESPONSE0 = ((DjTodayListForEdgeRes)httpResponse0).response;
            if(djTodayListForEdgeRes$RESPONSE0 != null) {
                ArrayList arrayList0 = djTodayListForEdgeRes$RESPONSE0.plylstList;
                if(arrayList0 != null) {
                    String s = ((PLYLSTLIST)arrayList0.get(0)).plylstseq;
                    this.a.c.playPlaylist(this.a.f, s, "1000001515");
                    g.f0("O04", null, "P1");
                }
            }
        }
    }
}

