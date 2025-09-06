package com.iloen.melon.fragments.present;

import androidx.activity.result.ActivityResult;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v4x.response.GiftProhibitedWordsCheckRes;
import e.a;

public final class b implements ErrorListener, Listener, a {
    public final int a;
    public final PresentSendFragment b;

    public b(PresentSendFragment presentSendFragment0, int v) {
        this.a = v;
        this.b = presentSendFragment0;
        super();
    }

    @Override  // e.a
    public void onActivityResult(Object object0) {
        switch(this.a) {
            case 0: {
                PresentSendFragment.searchFriendActivityResult$lambda$1(this.b, ((ActivityResult)object0));
                return;
            }
            case 1: {
                PresentSendFragment.pickContactActivityResult$lambda$3(this.b, ((ActivityResult)object0));
                return;
            }
            default: {
                PresentSendFragment.searchSongActivityResult$lambda$7(this.b, ((ActivityResult)object0));
            }
        }
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        PresentSendFragment.sendPresent$lambda$21(this.b, volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        PresentSendFragment.sendPresent$lambda$20(this.b, ((GiftProhibitedWordsCheckRes)object0));
    }
}

