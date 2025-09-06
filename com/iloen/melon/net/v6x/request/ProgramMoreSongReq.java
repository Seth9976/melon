package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ProgramMoreSongRes;

public class ProgramMoreSongReq extends RequestV6Req {
    public static class Params {
        public String cnpckSeq;
        public int pageSize;
        public String progSeq;
        public int startIndex;

        public Params() {
            this.pageSize = 100;
        }
    }

    public ProgramMoreSongReq(Context context0, Params programMoreSongReq$Params0) {
        super(context0, 0, ProgramMoreSongRes.class);
        this.addParams(programMoreSongReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/program/more/song.json";
    }
}

