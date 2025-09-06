package com.iloen.melon.sns.model;

import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.log.LogU;

public class SharableMv extends SharableBase {
    public static final Parcelable.Creator CREATOR = null;
    public String a;
    public String b;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public boolean i;
    private static final long serialVersionUID = 0x4453C7E65F7062DDL;

    static {
        SharableMv.CREATOR = new e(26);
    }

    public SharableMv(Parcel parcel0) {
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        boolean z = false;
        this.i = false;
        this.a = parcel0.readString();
        this.b = parcel0.readString();
        this.d = parcel0.readString();
        this.e = parcel0.readString();
        this.f = parcel0.readString();
        this.g = parcel0.readString();
        this.h = parcel0.readString();
        if(parcel0.readByte() != 0) {
            z = true;
        }
        this.i = z;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.a;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        return ContsTypeCode.VIDEO;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        return this.f;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        if(MelonAppBase.instance.getContext() == null) {
            LogU.e("SharableBase", "getDisplayMessage() context is NULL!");
            return null;
        }
        String s = this.getTextLimitForLength(this.b, 0x2F);
        return this.makeMessage(snsTarget0, String.format("%1$s의 %2$s - 감상해보세요. ", this.getTextLimitForLength(this.d, 27), s));
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return new String[]{this.b, this.d};
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public String getPageTypeCode() {
        return "mvd";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        return this.e;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        String s = this.b;
        String s1 = this.d;
        return TextUtils.isEmpty(s1) ? this.getTextLimitForLength(s, 0x2F) : this.getTextLimitForLength(s, 0x2F) + " - " + this.getTextLimitForLength(s1, 27);
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isVideoContent() {
        return true;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.d);
        parcel0.writeString(this.e);
        parcel0.writeString(this.f);
        parcel0.writeString(this.g);
        parcel0.writeString(this.h);
        parcel0.writeByte(((byte)this.i));
    }
}

