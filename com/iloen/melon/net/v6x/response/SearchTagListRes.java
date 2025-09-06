package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class SearchTagListRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        private static final long serialVersionUID = 0x3E45BBAC18L;
        @b("TAGLIST")
        public ArrayList tagList;

    }

    @b("response")
    public Response response;

    @Override
    public String toString() {
        return super.toString();
    }
}

