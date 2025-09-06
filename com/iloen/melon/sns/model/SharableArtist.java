package com.iloen.melon.sns.model;

import H8.q;
import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.log.LogU;

public class SharableArtist extends SharableBase {
    public static final Parcelable.Creator CREATOR = null;
    public String a;
    public String b;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    private static final long serialVersionUID = 0x46BF19B86422C36DL;

    static {
        SharableArtist.CREATOR = new e(10);
    }

    public SharableArtist(q q0) {
        this.a = (String)q0.a;
        this.b = (String)q0.b;
        this.d = (String)q0.c;
        this.e = (String)q0.d;
        this.f = (String)q0.e;
        this.g = (String)q0.f;
        this.h = null;
        this.i = (String)q0.g;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.a;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        return ContsTypeCode.ARTIST;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        String s = this.g;
        return TextUtils.isEmpty(s) ? this.getDefaultPostEditArtistImageUrl() : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        if(MelonAppBase.instance.getContext() == null) {
            LogU.e("SharableBase", "getDisplayMessage() context is NULL!");
            return null;
        }
        return this.makeMessage(snsTarget0, String.format("%1$s - 좋아합니다. ", this.getTextLimitForLength(this.b, 27)));
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return !"twitter".equals(snsTarget0.getId()) || MelonAppBase.instance.getContext() == null ? null : new String[]{this.b};
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "art";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        String s = this.f;
        return TextUtils.isEmpty(s) ? this.getDefaultPostImageUrl() : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        return this.getTextLimitForLength(this.b, 27);
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
    }
}

