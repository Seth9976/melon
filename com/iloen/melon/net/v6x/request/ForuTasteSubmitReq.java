package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ForuTasteSubmitRes;
import e1.u;
import va.e0;
import va.o;

public class ForuTasteSubmitReq extends RequestV6Req {
    public static class Params {
        public String artistIds;
        public String songIds;
        public String tagSeqs;

    }

    public ForuTasteSubmitReq(Context context0, Params foruTasteSubmitReq$Params0) {
        super(context0, 0, ForuTasteSubmitRes.class, false);
        this.addParams(foruTasteSubmitReq$Params0);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/foru/taste/submit.json";
    }
}

