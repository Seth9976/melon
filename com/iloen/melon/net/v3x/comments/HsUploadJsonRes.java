package com.iloen.melon.net.v3x.comments;

import A8.M;
import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;

public class HsUploadJsonRes extends CmtBaseRes {
    @b("code")
    public int code;
    @b("file")
    public String file;
    @b("msg")
    public String msg;
    private static final long serialVersionUID = 0x66370BAE524E8640L;
    @b("uploadtime")
    public String uploadtime;

    public HsUploadJsonRes() {
        this.code = 0;
        this.msg = "";
        this.file = "";
        this.uploadtime = "";
    }

    public String getFileUrl() {
        return M.o + "/" + this.file;
    }

    @Override  // com.iloen.melon.net.v3x.comments.CmtBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

