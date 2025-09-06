package com.iloen.melon.fragments.friend;

import androidx.activity.result.ActivityResult;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import e.a;

public final class l implements ErrorListener, a {
    public final int a;
    public final MetaContentBaseFragment b;

    public l(MetaContentBaseFragment metaContentBaseFragment0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        super();
    }

    @Override  // e.a
    public void onActivityResult(Object object0) {
        ((FriendAddFragment)this.b).lambda$new$0(((ActivityResult)object0));
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        switch(this.a) {
            case 0: {
                FollowingFragment.onFetchStart$lambda$2(((FollowingFragment)this.b), volleyError0);
                return;
            }
            case 2: {
                OtherFollowerFragment.onFetchStart$lambda$2(((OtherFollowerFragment)this.b), volleyError0);
                return;
            }
            default: {
                OtherFollowingFragment.onFetchStart$lambda$2(((OtherFollowingFragment)this.b), volleyError0);
            }
        }
    }
}

