package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.SearchNextTagListRes;

public class SearchNextTagListReq extends SearchV6BaseReq {
    public static class ArtistParams extends Params {
        public String artistId;
        public String displayKeyword;
        public String tagType;

    }

    public static class DjTagParams extends Params {
        public String displayKeyword;
        public String tagSeq;
        public String tagType;

    }

    public static class GenreParams extends Params {
        public String displayKeyword;
        public String genreType;
        public String genreTypeGroupName;
        public String tagType;

    }

    public static class Menu extends Params {
        public String displayKeyword;
        public String tagType;

    }

    public static class Params {
    }

    public static class PromotionParams extends Params {
        public String promotionSeq;
        public String tagType;

    }

    public SearchNextTagListReq(Context context0, Params searchNextTagListReq$Params0) {
        super(context0, 0, SearchNextTagListRes.class);
        this.addMemberKey();
        this.addParams(searchNextTagListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/search/nextTagList.json";
    }
}

