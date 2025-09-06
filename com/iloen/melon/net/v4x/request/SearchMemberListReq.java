package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SearchMemberListRes;

public class SearchMemberListReq extends SearchRequestBaseReq {
    public static class Params {
        public int orderBy;
        public int pageSize;
        public int startIndex;

    }

    public static final int FROM_MUSIC_MESSAGE = 0;
    public static final int FROM_PRESENT = 1;
    public static final int FROM_SEARCH = 2;
    public static final int ORDER_ALPHABET = 4;
    public static final int ORDER_CORRECT = 1;
    public int mFrom;

    public SearchMemberListReq(Context context0, String s, Params searchMemberListReq$Params0, int v) {
        super(context0, 0, SearchMemberListRes.class);
        this.mFrom = 2;
        this.addMemberKey();
        this.addParamToValueEncoded("searchKeyword", s);
        this.addParams(searchMemberListReq$Params0);
        this.mFrom = v;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        int v = this.mFrom;
        if(v == 0) {
            return "/mymusic/message/searchMemberList.json";
        }
        return v == 1 ? "/mymusic/gift/searchMemberList.json" : "/search/searchMemberList.json";
    }
}

