package com.iloen.melon.eventbus;

import android.net.Uri;
import com.iloen.melon.utils.NameValuePairList;
import com.iloen.melon.utils.network.NetUtils;

public class EventKakaoLogin {
    public int loginType;
    public NameValuePairList paramList;
    public Uri uri;

    public EventKakaoLogin(int v) {
        this.loginType = v;
    }

    public EventKakaoLogin(int v, Uri uri0) {
        this.loginType = v;
        this.uri = uri0;
        this.paramList = NetUtils.getQueryParamList(uri0);
    }
}

