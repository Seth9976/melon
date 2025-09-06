package com.iloen.melon.net.v4x.common;

import S7.b;
import com.melon.net.res.common.LinkInfoBase;

public class BannerBase extends LinkInfoBase {
    public static class Builder {
        public String banerseq;
        public String bgcolor;
        public String contsid;
        public String contstypecode;
        public String imgurl;
        public String isfullimg;
        private String linktype;
        public String linkurl;
        public String linkurl2;
        public String scheme;
        public String tag1;
        public String tag2;
        private String text;
        private String title;

        public Builder() {
            this.imgurl = "";
            this.linkurl = "";
            this.linkurl2 = "";
            this.banerseq = "";
            this.isfullimg = "";
            this.bgcolor = "";
            this.contstypecode = "";
            this.contsid = "";
            this.scheme = "";
            this.tag1 = "";
            this.tag2 = "";
        }

        public static String a(Builder bannerBase$Builder0) {
            return bannerBase$Builder0.linktype;
        }

        public static String b(Builder bannerBase$Builder0) {
            return bannerBase$Builder0.text;
        }

        public Builder banerSeq(String s) {
            this.banerseq = s;
            return this;
        }

        public Builder bgColor(String s) {
            this.bgcolor = s;
            return this;
        }

        public BannerBase build() {
            return new BannerBase(this, 0);
        }

        public static String c(Builder bannerBase$Builder0) {
            return bannerBase$Builder0.title;
        }

        public Builder contsId(String s) {
            this.contsid = s;
            return this;
        }

        public Builder contsTypeCode(String s) {
            this.contstypecode = s;
            return this;
        }

        public Builder imgUrl(String s) {
            this.imgurl = s;
            return this;
        }

        public Builder isFullImg(String s) {
            this.isfullimg = s;
            return this;
        }

        public Builder linkType(String s) {
            this.linktype = s;
            return this;
        }

        public Builder linkUrl(String s) {
            this.linkurl = s;
            return this;
        }

        public Builder linkurl2(String s) {
            this.linkurl2 = s;
            return this;
        }

        public Builder scheme(String s) {
            this.scheme = s;
            return this;
        }

        public Builder tag1(String s) {
            this.tag1 = s;
            return this;
        }

        public Builder tag2(String s) {
            this.tag2 = s;
            return this;
        }

        public Builder text(String s) {
            this.text = s;
            return this;
        }

        public Builder title(String s) {
            this.title = s;
            return this;
        }
    }

    @b(alternate = {"adminTitle"}, value = "ADMINTITLE")
    public String adminTitle;
    @b(alternate = {"bannerSeq"}, value = "BANERSEQ")
    public String banerseq;
    @b(alternate = {"bannerAreaCode"}, value = "BANERAREACODE")
    public String bannerAreaCode;
    @b(alternate = {"bgColor"}, value = "BGCOLOR")
    public String bgcolor;
    @b(alternate = {"contsId"}, value = "CONTSID")
    public String contsid;
    @b(alternate = {"contsTypeCode"}, value = "CONTSTYPECODE")
    public String contstypecode;
    @b(alternate = {"imgUrl"}, value = "IMGURL")
    public String imgurl;
    @b(alternate = {"impArea"}, value = "IMPAREA")
    public String impArea;
    @b(alternate = {"impContsTypeCode"}, value = "IMPCONTSTYPECODE")
    public String impContsTypeCode;
    @b(alternate = {"impType"}, value = "IMPTYPE")
    public String impType;
    @b(alternate = {"isFullImg"}, value = "ISFULLIMG")
    public String isfullimg;
    @b(alternate = {"menuId"}, value = "MENUID")
    public String menuId;
    private static final long serialVersionUID = 0x3DFF856298DFDC9BL;
    @b("TAG1")
    public String tag1;
    @b("TAG2")
    public String tag2;
    @b(alternate = {"targetId"}, value = "TARGETID")
    public String targetId;
    @b("TEXT")
    public String text;
    @b("text1")
    public String text1;
    @b("text1Color")
    public String text1Color;
    @b("text2")
    public String text2;
    @b("TITLE")
    public String title;

    public BannerBase() {
        this.title = "";
        this.text = "";
        this.imgurl = "";
        this.banerseq = "";
        this.isfullimg = "";
        this.bgcolor = "";
        this.contstypecode = "";
        this.contsid = "";
        this.tag1 = "";
        this.tag2 = "";
        this.text1 = "";
        this.text1Color = "";
        this.text2 = "";
    }

    private BannerBase(Builder bannerBase$Builder0) {
        this.text1 = "";
        this.text1Color = "";
        this.text2 = "";
        this.linktype = Builder.a(bannerBase$Builder0);
        this.title = Builder.c(bannerBase$Builder0);
        this.text = Builder.b(bannerBase$Builder0);
        this.imgurl = bannerBase$Builder0.imgurl;
        this.linkurl = bannerBase$Builder0.linkurl;
        this.banerseq = bannerBase$Builder0.banerseq;
        this.isfullimg = bannerBase$Builder0.isfullimg;
        this.bgcolor = bannerBase$Builder0.bgcolor;
        this.contstypecode = bannerBase$Builder0.contstypecode;
        this.contsid = bannerBase$Builder0.contsid;
        this.scheme = bannerBase$Builder0.scheme;
        this.tag1 = bannerBase$Builder0.tag1;
        this.tag2 = bannerBase$Builder0.tag2;
    }

    public BannerBase(Builder bannerBase$Builder0, int v) {
        this(bannerBase$Builder0);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override  // com.melon.net.res.common.LinkInfoBase
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

