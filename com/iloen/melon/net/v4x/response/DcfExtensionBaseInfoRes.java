package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.DcfContentBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class DcfExtensionBaseInfoRes extends ResponseV4Res {
    public static final class Response extends ResponseBase {
        public static class LangContentList extends DcfContentBase {
        }

        public static class NoticeList {
            @b("CONTENT")
            public String content;
            @b("ORDER")
            public String order;

            public NoticeList() {
                this.order = "";
                this.content = "";
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class SongContentList extends DcfContentBase {
        }

        @b("LANGCONTENTLIST")
        public ArrayList langContentList;
        @b("LANGDCFYN")
        public String langdcfyn;
        @b("NOTICELIST")
        public ArrayList noticeList;
        @b("SONGCONTENTLIST")
        public ArrayList songContentList;
        @b("SONGDCFYN")
        public String songdcfyn;

        public Response() {
            this.langContentList = null;
            this.songContentList = null;
            this.noticeList = null;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public Response response;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

