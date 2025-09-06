package com.iloen.melon.sns.model;

import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;

public class SharableMelgunsPick extends SharableBase {
    public static final Parcelable.Creator CREATOR = null;
    public String a;
    public String b;
    public String d;
    public String e;
    public String f;
    private static final long serialVersionUID = 0x327A3FA89681369CL;

    static {
        SharableMelgunsPick.CREATOR = new e(22);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.a;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        return ContsTypeCode.DJ_MELGUN;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        return this.f;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        return this.makeMessage(snsTarget0, "멜군\'s Pick - " + this.d);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return null;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayTitle(SnsTarget snsTarget0) {
        return this.getDisplayMessage(snsTarget0);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "mgp";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        String s = this.e;
        return TextUtils.isEmpty(s) ? this.getDefaultPostImageUrl() : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        return this.b;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isShowMusicMessage() {
        return false;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.d);
        parcel0.writeString(this.e);
        parcel0.writeString(this.f);
    }
}

