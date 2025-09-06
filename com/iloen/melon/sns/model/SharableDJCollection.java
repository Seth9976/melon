package com.iloen.melon.sns.model;

import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.log.LogU;

public class SharableDJCollection extends SharableBase {
    public static final Parcelable.Creator CREATOR = null;
    public String a;
    public String b;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    private static final long serialVersionUID = 0xF400946EAABAA7EBL;

    static {
        SharableDJCollection.CREATOR = new e(18);
    }

    public SharableDJCollection(c c0) {
        this.a = c0.a;
        this.b = c0.b;
        this.d = c0.c;
        this.e = c0.d;
        this.f = c0.e;
        this.g = c0.f;
        this.h = c0.g;
        this.i = c0.h;
        this.j = c0.i;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.a;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        return ContsTypeCode.DJ_PLAYLIST;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        String s = this.h;
        return TextUtils.isEmpty(s) ? this.getDefaultPostEditImageUrl() : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        if(MelonAppBase.instance.getContext() == null) {
            LogU.e("SharableBase", "getDisplayMessage() context is NULL!");
            return null;
        }
        String s = String.format("%1$s by %2$s ", this.b, this.d);
        StringBuilder stringBuilder0 = new StringBuilder();
        if(snsTarget0 != null && ("twitter".equals(snsTarget0.getId()) || "kakao".equals(snsTarget0.getId()))) {
            stringBuilder0.append("DJ 플레이리스트");
            stringBuilder0.append(" - ");
        }
        stringBuilder0.append(s);
        return this.makeMessage(snsTarget0, stringBuilder0.toString());
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return new String[]{this.b, "by " + this.d};
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "djc";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        String s = this.g;
        return TextUtils.isEmpty(s) ? this.getDefaultPostImageUrl() : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        String s = this.b;
        String s1 = this.d;
        return TextUtils.isEmpty(s1) ? s : s + " by " + s1;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.d);
        parcel0.writeString(this.e);
        parcel0.writeString(this.f);
        parcel0.writeString(this.g);
        parcel0.writeString(this.h);
        parcel0.writeString(this.i);
        parcel0.writeString(this.j);
    }
}

