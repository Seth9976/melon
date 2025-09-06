package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.ListArtistRes;

public class ListArtistReq extends RequestV4Req {
    public static class Params {
        public String orderBy;
        public int pageSize;
        public int startIndex;

        public Params() {
            this.startIndex = 1;
            this.pageSize = 30;
            this.orderBy = "EXACT";
        }
    }

    public ListArtistReq(Context context0, String s, Params listArtistReq$Params0) {
        super(context0, 0, ListArtistRes.class);
        this.addMemberKey();
        this.addParamToValueEncoded("searchKeyword", s);
        this.addParams(listArtistReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/setting/listArtist.json";
    }
}

