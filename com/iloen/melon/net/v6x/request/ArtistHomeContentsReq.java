package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes;
import com.iloen.melon.utils.system.AppUtils;

public class ArtistHomeContentsReq extends RequestV6_5Req {
    public ArtistHomeContentsReq(Context context0, String s) {
        super(context0, 0, ArtistHomeContentsRes.class);
        this.addParam("artistId", s);
        this.addParam("appVer", AppUtils.getVersionName(MelonAppBase.instance.getContext()));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/home/contents.json";
    }
}

