package com.iloen.melon.net.v4x.request;

import android.content.Context;

public class OrderByPvLogDummyReq extends PvLogDummyReq {
    public static enum OrderBy {
        MINE("O17"),
        LISTEN("O18"),
        RECENT_FWD("O22"),
        RECENT_REV("O31"),
        ARTIST_FWD("O32"),
        ARTIST_REV("O33"),
        SONG_FWD("O34"),
        SONG_REV("O35"),
        ALBUM("O36"),
        @Deprecated(since = "v6.14.0 어학 서비스 종료")
        LECTURE("O37"),
        DOWNLOAD("O9"),
        KOREAN("O3");

        public final String value;

        private static OrderBy[] $values() [...] // Inlined contents

        private OrderBy(String s1) {
            this.value = s1;
        }

        public String getString() {
            return this.value;
        }
    }

    public static final String PARAM_KEY = "orderBy";

    public OrderByPvLogDummyReq(Context context0, String s, OrderBy orderByPvLogDummyReq$OrderBy0) {
        super(context0, s);
        this.addParam("orderBy", orderByPvLogDummyReq$OrderBy0.getString());
    }
}

