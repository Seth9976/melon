package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;
import e1.u;
import va.e0;
import va.o;

public abstract class PersonalBaseReq extends RequestV4Req {
    public PersonalBaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.c;
    }
}

