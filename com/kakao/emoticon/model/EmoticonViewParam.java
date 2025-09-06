package com.kakao.emoticon.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import androidx.appcompat.app.o;
import com.kakao.emoticon.net.response.ItemSubType;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class EmoticonViewParam implements Parcelable {
    public static final Parcelable.Creator CREATOR = null;
    public static final String ITEM_ID = "item_id";
    public static final String ITEM_TYPE = "item_sub_type";
    public static final String ITEM_VERSION = "item_ver";
    public static final String RESOURCE_ID = "resource_id";
    private String emoticonId;
    private ItemSubType emoticonType;
    private int emoticonVersion;
    private int resourceId;

    static {
        EmoticonViewParam.CREATOR = new Parcelable.Creator() {
            public EmoticonViewParam createFromParcel(Parcel parcel0) {
                return new EmoticonViewParam(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public EmoticonViewParam[] newArray(int v) {
                return new EmoticonViewParam[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    private EmoticonViewParam() {
    }

    public EmoticonViewParam(Parcel parcel0) {
        this.emoticonId = parcel0.readString();
        int v = parcel0.readInt();
        this.emoticonType = v == -1 ? null : ItemSubType.values()[v];
        this.resourceId = parcel0.readInt();
        this.emoticonVersion = parcel0.readInt();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof EmoticonViewParam)) {
            return false;
        }
        if(this.resourceId != ((EmoticonViewParam)object0).resourceId) {
            return false;
        }
        if(this.emoticonVersion != ((EmoticonViewParam)object0).emoticonVersion) {
            return false;
        }
        return Objects.equals(this.emoticonId, ((EmoticonViewParam)object0).emoticonId) ? this.emoticonType == ((EmoticonViewParam)object0).emoticonType : false;
    }

    public static EmoticonViewParam get(String s) {
        try {
            EmoticonViewParam emoticonViewParam0 = new EmoticonViewParam();
            JSONObject jSONObject0 = new JSONObject(s);
            emoticonViewParam0.emoticonId = jSONObject0.optString("item_id");
            int v = jSONObject0.optInt("item_sub_type");
            emoticonViewParam0.emoticonType = ItemSubType.Companion.valueOfInt(v);
            emoticonViewParam0.emoticonVersion = jSONObject0.optInt("item_ver");
            emoticonViewParam0.resourceId = jSONObject0.optInt("resource_id");
            return emoticonViewParam0;
        }
        catch(Exception unused_ex) {
            return null;
        }
    }

    public String getEmoticonId() {
        return this.emoticonId;
    }

    public ItemSubType getEmoticonType() {
        return this.emoticonType;
    }

    public int getEmoticonVersion() {
        return this.emoticonVersion;
    }

    public int getResourceId() {
        return this.resourceId;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.emoticonId == null ? 0 : this.emoticonId.hashCode();
        ItemSubType itemSubType0 = this.emoticonType;
        if(itemSubType0 != null) {
            v = itemSubType0.hashCode();
        }
        return ((v1 * 0x1F + v) * 0x1F + this.resourceId) * 0x1F + this.emoticonVersion;
    }

    public JSONObject toJsonObject() {
        try {
            JSONObject jSONObject0 = new JSONObject();
            jSONObject0.put("item_id", this.emoticonId);
            jSONObject0.put("item_sub_type", this.emoticonType.getType());
            jSONObject0.put("item_ver", this.emoticonVersion);
            jSONObject0.put("resource_id", this.resourceId);
            return jSONObject0;
        }
        catch(JSONException unused_ex) {
            return null;
        }
    }

    public String toJsonString() {
        try {
            JSONObject jSONObject0 = new JSONObject();
            jSONObject0.put("item_id", this.emoticonId);
            jSONObject0.put("item_sub_type", this.emoticonType.getType());
            jSONObject0.put("item_ver", this.emoticonVersion);
            jSONObject0.put("resource_id", this.resourceId);
            return jSONObject0.toString();
        }
        catch(JSONException unused_ex) {
            return "";
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("EmoticonViewParam{emoticonId=\'");
        stringBuilder0.append(this.emoticonId);
        stringBuilder0.append("\', emoticonType=");
        stringBuilder0.append(this.emoticonType);
        stringBuilder0.append(", resourceId=");
        stringBuilder0.append(this.resourceId);
        stringBuilder0.append(", emoticonVersion=");
        return o.q(stringBuilder0, this.emoticonVersion, '}');
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.emoticonId);
        parcel0.writeInt((this.emoticonType == null ? -1 : this.emoticonType.ordinal()));
        parcel0.writeInt(this.resourceId);
        parcel0.writeInt(this.emoticonVersion);
    }
}

