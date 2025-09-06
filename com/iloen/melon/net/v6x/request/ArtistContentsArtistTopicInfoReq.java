package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicInfoRes;

public class ArtistContentsArtistTopicInfoReq extends RequestV6_1Req {
    public ArtistContentsArtistTopicInfoReq(Context context0, String s, String s1) {
        super(context0, 0, ArtistContentsArtistTopicInfoRes.class);
        this.addParam("artistId", s);
        this.addParam("topicSeq", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/contents/artistTopicInfo.json";
    }
}

