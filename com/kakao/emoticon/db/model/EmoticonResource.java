package com.kakao.emoticon.db.model;

import com.kakao.emoticon.db.JSONColumnMapper;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.kakao.emoticon.net.response.ItemSubType;
import org.json.JSONException;
import org.json.JSONObject;

public class EmoticonResource {
    private ItemSubType emoticonType;
    private final String itemId;
    private final JSONColumnMapper jv;
    private final int resourceId;
    private int version;

    public EmoticonResource(String s, int v) {
        this.jv = new JSONColumnMapper("v");
        this.itemId = s;
        this.resourceId = v;
    }

    public EmoticonResource(String s, int v, int v1, ItemSubType itemSubType0) {
        this.jv = new JSONColumnMapper("v");
        this.itemId = s;
        this.resourceId = v;
        this.version = v1;
        this.emoticonType = itemSubType0;
    }

    public static EmoticonViewParam convertToEmoticonParam(EmoticonResource emoticonResource0, int v, ItemSubType itemSubType0) {
        try {
            JSONObject jSONObject0 = new JSONObject();
            jSONObject0.put("item_id", emoticonResource0.itemId);
            jSONObject0.put("item_sub_type", itemSubType0.getType());
            jSONObject0.put("item_ver", v);
            jSONObject0.put("resource_id", emoticonResource0.resourceId);
            return EmoticonViewParam.get(jSONObject0.toString());
        }
        catch(JSONException unused_ex) {
            return null;
        }
    }

    public ItemSubType getEmoticonType() {
        return this.emoticonType;
    }

    public String getItemId() {
        return this.itemId;
    }

    public int getResourceId() {
        return this.resourceId;
    }

    public String getV() {
        return this.jv.getV();
    }

    public int getVersion() {
        return this.version;
    }

    @Override
    public String toString() {
        new StringBuilder(", v=").append(this.jv.getV());
        return super.toString();
    }
}

