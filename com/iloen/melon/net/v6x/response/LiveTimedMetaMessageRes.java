package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;

public class LiveTimedMetaMessageRes extends ResponseV6Res {
    public static class MESSAGE implements Serializable {
        @b("ARTIST")
        public ArtistsInfoBase artist;
        private static final long serialVersionUID = 0x3F7036E54EA59792L;
        @b("TEXT")
        public String text;

        public MESSAGE() {
            this.text = "";
        }
    }

    public static class RESPONSE extends ResponseBase {
        @b("MESSAGE")
        public MESSAGE message;
        private static final long serialVersionUID = 4045100091618714643L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x729818976CC806E6L;

    public LiveTimedMetaMessageRes() {
        this.response = null;
    }
}

