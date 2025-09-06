package com.iloen.melon.net.v3x;

import S7.b;
import android.text.TextUtils;
import com.iloen.melon.net.HttpResponse;

public class ResponseV3Res extends HttpResponse {
    @b("ACTION")
    public String action;
    @b("ERRORCODE")
    public String errorcode;
    @b("ERRORMSG")
    public String errormsg;
    @b("MENUID")
    public String menuid;
    @b("MESSAGE")
    public String message;
    private static final long serialVersionUID = 5660312001924596358L;
    @b("SIZE")
    public int size;
    @b("STATUS")
    public String status;

    public ResponseV3Res() {
        this.size = 0;
        this.status = "";
        this.action = "";
        this.message = "";
        this.errorcode = "";
        this.errormsg = "";
        this.menuid = "";
    }

    @Override  // com.iloen.melon.net.HttpResponse
    public boolean isSuccessful() {
        return TextUtils.isEmpty(this.status) ? false : "0".equals(this.status);
    }
}

