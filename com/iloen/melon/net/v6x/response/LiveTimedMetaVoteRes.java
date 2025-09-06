package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.List;

public class LiveTimedMetaVoteRes extends ResponseV6Res {
    public static class CANDI implements Serializable {
        @b("CANDINAME")
        public String candiName;
        @b("CANDINO")
        public String candiNo;
        @b("DPCOUNT")
        public String dpCount;
        @b("IMGURL")
        public String imgUrl;
        @b("PERCENTAGE")
        public String percentage;
        private static final long serialVersionUID = 0xC65C29CD98186E2AL;

        public CANDI() {
            this.candiNo = "";
            this.candiName = "";
            this.imgUrl = "";
            this.dpCount = "";
            this.percentage = "";
        }
    }

    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 0xA215E96B01914777L;
        @b("VOTE")
        public VOTE vote;

    }

    public static class VOTE implements Serializable {
        @b("CANDILIST")
        public List candiList;
        @b("ISEND")
        public Boolean isEnd;
        private static final long serialVersionUID = 0xFE372394FD9890A3L;
        @b("SUBTITLE")
        public String subTitle;
        @b("TITLE")
        public String title;
        @b("VOTEMETASEQ")
        public String voteMetaSeq;

        public VOTE() {
            this.voteMetaSeq = "";
            this.title = "";
            this.subTitle = "";
            this.isEnd = Boolean.TRUE;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xAB0D03788CF954B3L;

    public LiveTimedMetaVoteRes() {
        this.response = null;
    }
}

