package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.v6x.response.SearchAutocompleteKwdRes;

public class SearchAutocompleteKwdReq extends HttpRequest {
    public static class Params {
        public String pageSize;
        public String query;
        public String wordCount;

        public Params() {
            this.pageSize = "10";
            this.wordCount = "7";
        }
    }

    public SearchAutocompleteKwdReq(Context context0, String s) {
        super(context0, 0, SearchAutocompleteKwdRes.class, false);
        Params searchAutocompleteKwdReq$Params0 = new Params();
        searchAutocompleteKwdReq$Params0.query = s;
        this.addParams(searchAutocompleteKwdReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/search/mobile4web/search_autocompleteKwd.json";
    }
}

