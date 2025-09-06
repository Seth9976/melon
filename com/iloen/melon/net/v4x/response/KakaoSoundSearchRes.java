package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.util.ArrayList;

public class KakaoSoundSearchRes {
    public static class SongInfo {
        @b("songid")
        public String songId;

        public SongInfo() {
            this.songId = null;
        }
    }

    @b("matched")
    public ArrayList matched;
    @b("status_code")
    public String statusCode;

    public KakaoSoundSearchRes() {
        this.matched = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

