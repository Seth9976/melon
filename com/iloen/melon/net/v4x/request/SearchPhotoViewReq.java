package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SearchPhotoViewRes;

public class SearchPhotoViewReq extends SearchPhotoViewBaseReq {
    public SearchPhotoViewReq(Context context0, String s, String s1, String s2, String s3) {
        super(context0, 0, SearchPhotoViewRes.class);
        this.addMemberKey();
        this.addParamToValueEncoded("searchKeyword", s);
        this.addParam("orderBy", s1);
        this.addParam("photoId", s2);
        this.addParam("photoIndex", s3);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/search/searchPhotoView.json";
    }
}

