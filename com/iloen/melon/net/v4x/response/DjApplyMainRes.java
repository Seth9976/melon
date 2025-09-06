package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class DjApplyMainRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class OPTION implements Serializable {
            @b("ACTION")
            public String action;
            @b("LINKTYPE")
            public String linkType;
            @b("MESSAGE")
            public String message;
            private static final long serialVersionUID = -156029803322703240L;
            @b("TITLE")
            public String title;
            @b("URL")
            public String url;

            public OPTION() {
                this.action = "";
                this.linkType = "";
                this.url = "";
                this.title = "";
                this.message = "";
            }
        }

        public static class TAGLIST extends TagInfoBase {
            private static final long serialVersionUID = 0xC4FE85464628C2F0L;

        }

        @b("CONTENT")
        public String content;
        @b("DJSTATUS")
        public String djStatus;
        @b("MEMBERKEY")
        public String memberKey;
        @b("MEMBERNICKNAME")
        public String memberNickName;
        @b("MYPAGEDESC")
        public String myPageDesc;
        @b("MYPAGEIMG")
        public String myPageImg;
        @b("OPTION")
        public OPTION option;
        @b("PLYLSTCNT")
        public String plylstCnt;
        @b("PLYLSTSEQ")
        public String plylstSeq;
        @b("PLYLSTTITLE")
        public String plylstTitle;
        private static final long serialVersionUID = 0xE29138C109744D57L;
        @b("SONGCNT")
        public String songCnt;
        @b("TAGLIST")
        public ArrayList tagList;
        @b("THUMBIMG")
        public String thumbImg;
        @b("USERGENRE")
        public String userGenre;

        public RESPONSE() {
            this.memberKey = "";
            this.djStatus = "";
            this.option = null;
            this.content = "";
            this.myPageImg = "";
            this.memberNickName = "";
            this.userGenre = "";
            this.plylstCnt = "";
            this.myPageDesc = "";
            this.plylstSeq = "";
            this.plylstTitle = "";
            this.thumbImg = "";
            this.songCnt = "";
            this.tagList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xC3FA08B4C3274A17L;

    public DjApplyMainRes() {
        this.response = null;
    }
}

