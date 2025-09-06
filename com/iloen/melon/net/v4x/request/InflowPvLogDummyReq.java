package com.iloen.melon.net.v4x.request;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.iloen.melon.utils.StringUtils;

public class InflowPvLogDummyReq extends PvLogDummyReq {
    public static final class Params {
        public static class Builder {
            private String artId;
            private String chnlLseq;
            private String chnlMseq;
            private String chnlSseq;
            private String chnlType;
            private String contsId;
            private String contsType;
            private String gnrCode;
            private String menuId;
            private String radioType;
            private String ref;
            private String simSongYn;

            public Builder(String s) {
                this.ref = s;
            }

            public Builder artId(String s) {
                this.artId = s;
                return this;
            }

            public Params build() {
                return new Params(this);
            }

            public static String c(Builder inflowPvLogDummyReq$Params$Builder0) {
                return inflowPvLogDummyReq$Params$Builder0.chnlMseq;
            }

            public Builder chnlLseq(String s) {
                this.chnlLseq = s;
                return this;
            }

            public Builder chnlMseq(String s) {
                this.chnlMseq = s;
                return this;
            }

            public Builder chnlSseq(String s) {
                this.chnlSseq = s;
                return this;
            }

            public Builder chnlType(String s) {
                this.chnlType = s;
                return this;
            }

            public Builder contsId(String s) {
                this.contsId = s;
                return this;
            }

            public Builder contsType(String s) {
                this.contsType = s;
                return this;
            }

            public static String e(Builder inflowPvLogDummyReq$Params$Builder0) {
                return inflowPvLogDummyReq$Params$Builder0.chnlType;
            }

            public static String f(Builder inflowPvLogDummyReq$Params$Builder0) {
                return inflowPvLogDummyReq$Params$Builder0.contsId;
            }

            public static String g(Builder inflowPvLogDummyReq$Params$Builder0) {
                return inflowPvLogDummyReq$Params$Builder0.contsType;
            }

            public Builder gnrCode(String s) {
                this.gnrCode = s;
                return this;
            }

            public static String h(Builder inflowPvLogDummyReq$Params$Builder0) {
                return inflowPvLogDummyReq$Params$Builder0.gnrCode;
            }

            public static String i(Builder inflowPvLogDummyReq$Params$Builder0) {
                return inflowPvLogDummyReq$Params$Builder0.menuId;
            }

            public Builder intent(Intent intent0) {
                String s = intent0.getStringExtra("pvmenuid");
                String s1 = intent0.getStringExtra("contsid");
                String s2 = intent0.getStringExtra("contstype");
                String s3 = intent0.getStringExtra("artistids");
                String s4 = intent0.getStringExtra("chnllseq");
                String s5 = intent0.getStringExtra("chnlmseq");
                String s6 = intent0.getStringExtra("chnlsseq");
                String s7 = intent0.getStringExtra("chnltype");
                String s8 = intent0.getStringExtra("gnrCode");
                String s9 = intent0.getStringExtra("radioType");
                String s10 = intent0.getStringExtra("simsongyn");
                this.contsId = StringUtils.getNotNullString(s1);
                this.contsType = StringUtils.getNotNullString(s2);
                this.menuId = StringUtils.getNotNullString(s);
                this.artId = StringUtils.getNotNullString(s3);
                this.chnlLseq = StringUtils.getNotNullString(s4);
                this.chnlMseq = StringUtils.getNotNullString(s5);
                this.chnlSseq = StringUtils.getNotNullString(s6);
                this.chnlType = StringUtils.getNotNullString(s7);
                this.gnrCode = StringUtils.getNotNullString(s8);
                this.radioType = StringUtils.getNotNullString(s9);
                this.simSongYn = StringUtils.getNotNullString(s10);
                return this;
            }

            public static String j(Builder inflowPvLogDummyReq$Params$Builder0) {
                return inflowPvLogDummyReq$Params$Builder0.radioType;
            }

            public static String k(Builder inflowPvLogDummyReq$Params$Builder0) {
                return inflowPvLogDummyReq$Params$Builder0.ref;
            }

            public static String l(Builder inflowPvLogDummyReq$Params$Builder0) {
                return inflowPvLogDummyReq$Params$Builder0.simSongYn;
            }

            public Builder menuId(String s) {
                this.menuId = s;
                return this;
            }

            public Builder radioType(String s) {
                this.radioType = s;
                return this;
            }

            public Builder ref(String s) {
                this.ref = s;
                return this;
            }

            public Builder simSongYn(String s) {
                this.simSongYn = s;
                return this;
            }

            public Builder uri(Uri uri0) {
                String s = uri0.getQueryParameter("pvmenuid");
                String s1 = uri0.getQueryParameter("contsId");
                String s2 = uri0.getQueryParameter("contsType");
                String s3 = uri0.getQueryParameter("artistids");
                String s4 = uri0.getQueryParameter("chnllseq");
                String s5 = uri0.getQueryParameter("chnlmseq");
                String s6 = uri0.getQueryParameter("chnlsseq");
                String s7 = uri0.getQueryParameter("chnltype");
                String s8 = uri0.getQueryParameter("gnrCode");
                String s9 = uri0.getQueryParameter("radioType");
                String s10 = uri0.getQueryParameter("simsongyn");
                this.contsId = StringUtils.getNotNullString(s1);
                this.contsType = StringUtils.getNotNullString(s2);
                this.menuId = StringUtils.getNotNullString(s);
                this.artId = StringUtils.getNotNullString(s3);
                this.chnlLseq = StringUtils.getNotNullString(s4);
                this.chnlMseq = StringUtils.getNotNullString(s5);
                this.chnlSseq = StringUtils.getNotNullString(s6);
                this.chnlType = StringUtils.getNotNullString(s7);
                this.gnrCode = StringUtils.getNotNullString(s8);
                this.radioType = StringUtils.getNotNullString(s9);
                this.simSongYn = StringUtils.getNotNullString(s10);
                return this;
            }
        }

        public String artId;
        public String chnlLseq;
        public String chnlMseq;
        public String chnlSseq;
        public String chnlType;
        public String contsId;
        public String contsType;
        public String gnrCode;
        public String menuId;
        public String radioType;
        public String ref;
        public String simSongYn;

        public Params(Builder inflowPvLogDummyReq$Params$Builder0) {
            this.ref = Builder.k(inflowPvLogDummyReq$Params$Builder0);
            this.contsId = Builder.f(inflowPvLogDummyReq$Params$Builder0);
            this.contsType = Builder.g(inflowPvLogDummyReq$Params$Builder0);
            this.menuId = Builder.i(inflowPvLogDummyReq$Params$Builder0);
            this.artId = inflowPvLogDummyReq$Params$Builder0.artId;
            this.chnlLseq = inflowPvLogDummyReq$Params$Builder0.chnlLseq;
            this.chnlMseq = Builder.c(inflowPvLogDummyReq$Params$Builder0);
            this.chnlSseq = inflowPvLogDummyReq$Params$Builder0.chnlSseq;
            this.chnlType = Builder.e(inflowPvLogDummyReq$Params$Builder0);
            this.gnrCode = Builder.h(inflowPvLogDummyReq$Params$Builder0);
            this.radioType = Builder.j(inflowPvLogDummyReq$Params$Builder0);
            this.simSongYn = Builder.l(inflowPvLogDummyReq$Params$Builder0);
        }
    }

    public InflowPvLogDummyReq(Context context0, Params inflowPvLogDummyReq$Params0) {
        super(context0, "inflow");
        this.addParams(inflowPvLogDummyReq$Params0);
    }
}

