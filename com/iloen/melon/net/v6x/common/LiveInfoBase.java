package com.iloen.melon.net.v6x.common;

import S7.b;
import com.iloen.melon.constants.LiveStatusCode;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.LinkInfoBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LiveInfoBase implements Serializable {
    public static class Artist extends ArtistsInfoBase {
        private static final long serialVersionUID = 2120503819286829091L;

    }

    public static class CARD implements Serializable {
        public static class BUTTON extends LinkInfoBase {
            private static final long serialVersionUID = -5145056700262643420L;
            @b("TEXT")
            public String text;

            public BUTTON() {
                this.text = "";
            }
        }

        public static class ITEM implements Serializable {
            @b("BADGE")
            public String badge;
            private static final long serialVersionUID = 0x8F99C59D927E15A0L;
            @b("TEXT")
            public String text;

            public ITEM() {
                this.badge = "";
                this.text = "";
            }
        }

        @b("BADGE")
        public String badge;
        @b("BGCOLOR")
        public String bgColor;
        @b("BUTTON")
        public BUTTON button;
        @b("DESC")
        public String desc;
        @b("IMGURL")
        public String imgUrl;
        @b("ITEMS")
        public List items;
        private static final long serialVersionUID = 0x970DE7C047A6907DL;
        @b("TITLE")
        public String title;

        public CARD() {
            this.bgColor = "";
            this.badge = "";
            this.title = "";
            this.desc = "";
            this.items = new ArrayList();
            this.button = null;
            this.imgUrl = "";
        }
    }

    @b("ARTISTLIST")
    public ArrayList artistList;
    @b("CARD")
    public CARD card;
    @b("CAUTION")
    public List caution;
    @b("ISCHEER")
    @Deprecated
    public boolean isCheer;
    @b("ISSUEDATE")
    public String issueDate;
    @b("LIKECNT")
    public String likeCnt;
    @b("LIVEDESC")
    public String liveDesc;
    @b("LIVEIMG")
    public String liveImg;
    @b("LIVESEQ")
    public String liveSeq;
    @b("LIVESTATUSCODE")
    public LiveStatusCode liveStatusCode;
    @b("LIVETITLE")
    public String liveTitle;
    private static final long serialVersionUID = 0x687DBF7869EFB429L;
    @b("TEXT1")
    public String text1;
    @b("TEXT2")
    public String text2;
    @b("TEXT3")
    public String text3;
    @b("VERSIONPUSH")
    public List versionPush;
    @b("VIEWCNT")
    public String viewCnt;

    public LiveInfoBase() {
        this.liveSeq = "";
        this.liveStatusCode = null;
        this.liveTitle = "";
        this.liveDesc = "";
        this.liveImg = "";
        this.viewCnt = "";
        this.likeCnt = "";
        this.issueDate = "";
        this.text1 = "";
        this.text2 = "";
        this.text3 = "";
        this.versionPush = new ArrayList();
        this.caution = new ArrayList();
        this.card = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

