package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.AlbumSuggestedContentsRes;
import com.iloen.melon.net.v6x.request.SuggestedContentsV6_1Req;

public class AlbumSuggestedContentsReq extends SuggestedContentsV6_1Req {
    public AlbumSuggestedContentsReq(Context context0, String s) {
        super(context0, 0, AlbumSuggestedContentsRes.class, true);
        this.addParam("albumId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/album/suggestedContents.json";
    }
}

