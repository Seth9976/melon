package com.iloen.melon.net.v3x.comments;

import android.content.Context;
import android.text.TextUtils;
import b3.Z;
import com.iloen.melon.utils.StringUtils;
import e1.u;
import java.io.File;
import va.e0;
import va.o;

public class HsUploadJsonReq extends CmtImgUpBaseReq {
    private static final String TAG = "HsUploadJsonReq";

    public HsUploadJsonReq(Context context0, AuthhsJsonRes authhsJsonRes0, String s, String s1) {
        super(context0, HsUploadJsonRes.class, s1);
        this.addParam("filePath", this.makeFilePath());
        this.addParam("overWrite", "N");
        this.addFilePart("uploadFile", new File(s));
        this.addParam("fileName", authhsJsonRes0.file);
        this.addParam("auth", authhsJsonRes0.authkey);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/hs_upload_json.html";
    }

    private String getCurrentYyyymmdd() [...] // 潜在的解密器

    private String makeFilePath() {
        String s = u.v(((e0)o.a()).j());
        StringBuilder stringBuilder0 = new StringBuilder("/");
        stringBuilder0.append("202509249");
        stringBuilder0.append("/");
        if(!TextUtils.isEmpty(s)) {
            int v = s.length();
            if(v > 5) {
                try {
                    String s1 = s.substring(v - 5, v);
                    if(!TextUtils.isEmpty(s1)) {
                        stringBuilder0.append(s1.substring(0, 3));
                        stringBuilder0.append("/");
                        stringBuilder0.append(s1.substring(3, s1.length()));
                        return stringBuilder0.toString();
                    }
                }
                catch(Exception exception0) {
                    Z.v(exception0, new StringBuilder("makeFilePath() size > 5 : "), "HsUploadJsonReq");
                }
            }
            try {
                String s2 = StringUtils.lpad(s, 5, "0");
                stringBuilder0.append(String.format("%03s", s2.substring(0, v - 2)));
                stringBuilder0.append("/");
                stringBuilder0.append(s2.substring(v - 2, v));
                return stringBuilder0.toString();
            }
            catch(Exception exception1) {
                Z.v(exception1, new StringBuilder("makeFilePath() size < 5 :"), "HsUploadJsonReq");
            }
        }
        stringBuilder0.append("000/00");
        return stringBuilder0.toString();
    }
}

