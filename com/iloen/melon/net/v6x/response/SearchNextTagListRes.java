package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class SearchNextTagListRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        public static class Tag extends SearchTagBase {
            private static final long serialVersionUID = 0x9680D83C6E63AD1L;

        }

        @b("NEXTTAGLIST")
        public ArrayList tagList;

    }

    public Response response;
    private static final long serialVersionUID = 0x96807FB6C2B2A71L;

    public SearchNextTagListRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

