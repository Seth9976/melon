package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;

public class AuthhsJsonRes extends CmtBaseRes {
    @b("authKey")
    public String authkey;
    @b("authTime")
    public String authtime;
    @b("file")
    public String file;
    private static final long serialVersionUID = 1927921367240034493L;

    public AuthhsJsonRes() {
        this.authkey = "";
        this.file = "";
        this.authtime = "";
    }

    @Override  // com.iloen.melon.net.v3x.comments.CmtBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

