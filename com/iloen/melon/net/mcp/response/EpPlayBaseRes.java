package com.iloen.melon.net.mcp.response;

import S7.b;
import com.iloen.melon.net.v6x.response.ResponseV6Res;

public class EpPlayBaseRes extends ResponseV6Res {
    @b("result")
    public String result;
    private static final long serialVersionUID = 0xFB88A3023D126371L;

    public EpPlayBaseRes() {
        this.result = "";
    }
}

