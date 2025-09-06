package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.CommentMyListRes;
import e1.u;
import va.e0;
import va.o;

public class CommentMyListReq extends RequestV6Req {
    public static class Params {
        public int cmtLevel;
        public int pageSize;
        public int startIndex;

    }

    public CommentMyListReq(Context context0, Params commentMyListReq$Params0) {
        super(context0, 0, CommentMyListRes.class, false);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParams(commentMyListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/comment/my/list.json";
    }
}

