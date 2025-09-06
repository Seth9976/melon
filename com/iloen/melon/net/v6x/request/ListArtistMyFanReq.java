package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ListArtistMyFanRes;
import e1.u;
import va.e0;
import va.o;

public class ListArtistMyFanReq extends RequestV6Req {
    public static class Params {
        public String orderBy;
        public int pageSize;
        public int startIndex;
        public String targetMemberKey;

    }

    public ListArtistMyFanReq(Context context0, Params listArtistMyFanReq$Params0) {
        super(context0, 0, ListArtistMyFanRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
        this.addParams(listArtistMyFanReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/artistfan/listArtistMyFan.json";
    }
}

