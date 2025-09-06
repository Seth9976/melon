package com.iloen.melon.sns.model;

import A7.d;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.log.LogU;

public class SharableRealChart extends SharableBase {
    public static final Parcelable.Creator CREATOR = null;
    public String a;
    public String b;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    private static final long serialVersionUID = 0x46BF19B86422C36DL;

    static {
        SharableRealChart.CREATOR = new e(4);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.d;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        return ContsTypeCode.PHOTO;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDefaultShareLinkPageUrl(SnsTarget snsTarget0) {
        StringBuilder stringBuilder0 = x.p(super.getDefaultShareLinkPageUrl(snsTarget0), "&dt=");
        stringBuilder0.append(this.a);
        return stringBuilder0.toString();
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        String s = this.h;
        return TextUtils.isEmpty(s) ? this.getDefaultPostEditImageUrl() : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        String s = "";
        if(!"twitter".equals(snsTarget0.getId()) && !"kakao".equals(snsTarget0.getId())) {
            return "";
        }
        if(MelonAppBase.instance.getContext() == null) {
            LogU.e("SharableBase", "getMessage() context is NULL!");
            return "";
        }
        String s1 = String.format("%s위", this.d);
        StringBuilder stringBuilder0 = a.n("[", "멜론차트", " ");
        d.u(stringBuilder0, this.b, "] ", s1, " ");
        stringBuilder0.append(this.f);
        stringBuilder0.append(" - ");
        String s2 = this.e;
        if(!TextUtils.isEmpty(s2)) {
            StringBuilder stringBuilder1 = new StringBuilder();
            if(s2.contains(",")) {
                String[] arr_s = s2.split(",");
                for(int v = 0; v < arr_s.length; ++v) {
                    stringBuilder1.append(arr_s[v]);
                    stringBuilder1.append(", ");
                }
                s = l1.q(stringBuilder1, 2, 0);
            }
            else {
                stringBuilder1.append(s2);
                s = stringBuilder1.toString();
            }
        }
        stringBuilder0.append(s);
        return this.makeMessage(snsTarget0, stringBuilder0.toString());
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return null;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayTitle(SnsTarget snsTarget0) {
        return "";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "chtgrp";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        String s = this.g;
        return TextUtils.isEmpty(s) ? this.getDefaultPostImageUrl() : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        return null;
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
        parcel0.writeString(this.g);
        parcel0.writeString(this.h);
    }
}

