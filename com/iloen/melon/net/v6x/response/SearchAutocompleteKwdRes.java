package com.iloen.melon.net.v6x.response;

import com.iloen.melon.net.HttpResponse;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import s9.a;

public class SearchAutocompleteKwdRes extends HttpResponse {
    public static class SearchAutoKeywordBase extends ResponseBase implements a {
        public String keyword;

        @Override  // s9.a
        public int getContentType() {
            return 4;
        }
    }

    public List keywordList;

}

