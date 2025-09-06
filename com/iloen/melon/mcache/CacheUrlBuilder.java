package com.iloen.melon.mcache;

import android.text.TextUtils;
import com.iloen.melon.mcache.error.OtherError;
import com.iloen.melon.mcache.error.ParamError.IllegalArgumentError;

public class CacheUrlBuilder {
    public static final String TAG = "CacheUrlBuilder";
    private String bitrate;
    private String cacheEnableYn;
    private String cid;
    private String contentType;
    private String isLocalYn;
    private String metaType;
    private String streamPath;

    public CacheUrlBuilder(String s, String s1) {
        this.cacheEnableYn = "Y";
        this.isLocalYn = "N";
        this.streamPath = s;
        this.cid = s1;
    }

    public CacheUrlBuilder bitrate(String s) {
        this.bitrate = s;
        return this;
    }

    public String build() {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(TextUtils.isEmpty(this.streamPath)) {
            new IllegalArgumentError("CacheUrlBuilder", "Stream path can not be null.");
        }
        else {
            stringBuilder0.append(this.streamPath);
        }
        if(TextUtils.isEmpty(this.cid)) {
            new IllegalArgumentError("CacheUrlBuilder", "Cid can not be null.");
        }
        else {
            stringBuilder0.append("&cid=");
            stringBuilder0.append(this.cid);
        }
        stringBuilder0.append("&cacheEnable=");
        stringBuilder0.append(this.cacheEnableYn);
        stringBuilder0.append("&isLocal=");
        stringBuilder0.append(this.isLocalYn);
        if(!TextUtils.isEmpty(this.bitrate)) {
            stringBuilder0.append("&bitrate=");
            stringBuilder0.append(this.bitrate);
        }
        if(!TextUtils.isEmpty(this.metaType)) {
            stringBuilder0.append("&metaType=");
            stringBuilder0.append(this.metaType);
        }
        if("Y".equals(this.isLocalYn) && !TextUtils.isEmpty(this.contentType)) {
            stringBuilder0.append("&contentType=");
            stringBuilder0.append(this.contentType);
        }
        if(stringBuilder0.length() < 1) {
            new OtherError("CacheUrlBuilder", "Return url can not be null.");
        }
        return stringBuilder0.toString();
    }

    public CacheUrlBuilder cacheEnable(boolean z) {
        this.cacheEnableYn = z ? "Y" : "N";
        return this;
    }

    public CacheUrlBuilder contentType(String s) {
        this.contentType = s;
        return this;
    }

    public CacheUrlBuilder isLocal(boolean z) {
        this.isLocalYn = z ? "Y" : "N";
        return this;
    }

    public CacheUrlBuilder metaType(String s) {
        this.metaType = s;
        return this;
    }
}

