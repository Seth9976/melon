package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ProgramMoreAlbumRes;

public class ProgramMoreAlbumReq extends RequestV6Req {
    public static enum OrderType {
        NEW("NEW"),
        POP("POP"),
        OLD("OLD");

        private final String value;

        private static OrderType[] $values() [...] // Inlined contents

        private OrderType(String s1) {
            this.value = s1;
        }

        public static OrderType getType(int v) {
            switch(v) {
                case 0: {
                    return OrderType.NEW;
                }
                case 1: {
                    return OrderType.POP;
                }
                default: {
                    return OrderType.OLD;
                }
            }
        }

        public String getValue() {
            return this.value;
        }
    }

    public static class Params {
        public String orderBy;
        public String progSeq;

    }

    public ProgramMoreAlbumReq(Context context0, Params programMoreAlbumReq$Params0) {
        super(context0, 0, ProgramMoreAlbumRes.class);
        this.addParams(programMoreAlbumReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/program/more/album.json";
    }
}

