package com.iloen.melon.sns.model;

import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.image.ImageUrl;
import com.iloen.melon.utils.image.MelonImageSource;
import com.iloen.melon.utils.log.LogU;

public class SharableAlbum extends SharableBase {
    public static final Parcelable.Creator CREATOR = null;
    public final boolean a;
    public String b;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    private static final long serialVersionUID = 0xE19AF610397836F3L;

    static {
        SharableAlbum.CREATOR = new e(9);
    }

    public SharableAlbum(a a0) {
        this.a = a0.a;
        this.b = (String)a0.b;
        this.d = (String)a0.c;
        this.e = (String)a0.d;
        this.f = (String)a0.e;
        this.g = (String)a0.f;
        this.h = (String)a0.g;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.b;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        return ContsTypeCode.ALBUM;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        String s = this.b;
        String s1 = this.f;
        if(!TextUtils.isEmpty(s1)) {
            return s1;
        }
        return this.a || TextUtils.isEmpty(s) ? this.getDefaultPostEditImageUrl() : ImageUrl.getAlbumSmallUri(MelonImageSource.NETWORK, s).toString();
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        if(MelonAppBase.instance.getContext() == null) {
            LogU.e("SharableBase", "getDisplayMessage() context is NULL!");
            return null;
        }
        String s = this.getTextLimitForLength(this.d, 57);
        return this.makeMessage(snsTarget0, String.format("%1$s의 %2$s - 추천합니다. ", this.getTextLimitForLength(this.g, 27), s));
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return new String[]{this.d, this.g};
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "alb";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        String s = this.b;
        String s1 = this.e;
        if(!TextUtils.isEmpty(s1)) {
            return s1;
        }
        return this.a || TextUtils.isEmpty(s) ? "null/sns_post_default_500.jpg?tm=2025090611" : ImageUrl.getAlbumMediumUri(MelonImageSource.NETWORK, s).toString();
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        return this.getTextLimitForLength(this.d, 57) + " - " + this.getTextLimitForLength(this.g, 27);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.b);
        parcel0.writeString(this.d);
        parcel0.writeString(this.e);
        parcel0.writeString(this.f);
        parcel0.writeString(this.g);
        parcel0.writeString(this.h);
    }
}

