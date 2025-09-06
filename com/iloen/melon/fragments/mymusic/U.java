package com.iloen.melon.fragments.mymusic;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v4x.response.DeleteUserImgRes;
import com.iloen.melon.net.v4x.response.UpdateUserImgRes;
import com.iloen.melon.net.v6x.response.MyMusicUpdateMyProfileOpenYnRes;
import com.iloen.melon.utils.image.ImageSelector.OnDefaultImageClick;

public final class u implements ErrorListener, Listener, OnDefaultImageClick {
    public final int a;
    public final MemberProfileEditFragment b;

    public u(MemberProfileEditFragment memberProfileEditFragment0, int v) {
        this.a = v;
        this.b = memberProfileEditFragment0;
        super();
    }

    @Override  // com.iloen.melon.utils.image.ImageSelector$OnDefaultImageClick
    public void onDefaultImageClick() {
        ProfileThumbViewHolder.bindItem$lambda$2$lambda$0(this.b);
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        MemberProfileEditFragment.setUserProfileImage$lambda$11(this.b, volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        switch(this.a) {
            case 1: {
                MemberProfileEditFragment.deleteProfileImg$lambda$12(this.b, ((DeleteUserImgRes)object0));
                return;
            }
            case 2: {
                MemberProfileEditFragment.requestOpenYn$lambda$18(this.b, ((MyMusicUpdateMyProfileOpenYnRes)object0));
                return;
            }
            default: {
                MemberProfileEditFragment.setUserProfileImage$lambda$10(this.b, ((UpdateUserImgRes)object0));
            }
        }
    }
}

