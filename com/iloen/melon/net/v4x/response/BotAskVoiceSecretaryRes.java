package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class BotAskVoiceSecretaryRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class CONTENTSLIST implements Serializable {
            public static class SONGLIST extends SongInfoBase {
                @Override  // com.melon.net.res.common.SongInfoBase
                public String toString() {
                    return ToStringUtil.toStringFields(this);
                }
            }

            @b("BUTTONPOSITION")
            public String buttonPosition;
            @b("BUTTONSCHEME")
            public String buttonScheme;
            @b("CONTENTID")
            public String contentId;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("ENTITY")
            public String entity;
            @b("IMG")
            public String img;
            @b("INDEXKEY")
            public String indexKey;
            @b("ISBUTTONDP")
            public boolean isButtonDp;
            @b("LANDINGSCHEME")
            public String landingScheme;
            @b("LANDINGTYPE")
            public String lendingType;
            @b("SONGLIST")
            public ArrayList songList;
            @b("TEXT1")
            public String text1;
            @b("TEXT2")
            public String text2;

            public CONTENTSLIST() {
                this.songList = null;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("ANSWERVALUE")
        public String answerValue;
        @b("CONTENTSLIST")
        public ArrayList contentsList;
        @b("FEEDBACKID")
        public String feedbackId;
        @b("SCHEME")
        public String scheme;
        @b("SESSIONKEY")
        public String sessionKey;

        public RESPONSE() {
            this.contentsList = null;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("LOGGING")
    public String logging;
    @b("response")
    public RESPONSE response;

    public boolean existContents() {
        return this.response != null && (this.response.contentsList != null && !this.response.contentsList.isEmpty());
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

