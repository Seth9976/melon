package com.iloen.melon.sns.model;

import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/iloen/melon/sns/model/SharableMusicWave;", "Lcom/iloen/melon/sns/model/SharableBase;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SharableMusicWave extends SharableBase {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public String a;
    public String b;
    public String d;
    public String e;
    public String f;

    static {
        SharableMusicWave.CREATOR = new e(25);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.a;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        q.f(ContsTypeCode.MUSIC_WAVE, "MUSIC_WAVE");
        return ContsTypeCode.MUSIC_WAVE;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        String s = this.d;
        if(s == null) {
            s = this.getDefaultPostEditImageUrl();
            q.f(s, "getDefaultPostEditImageUrl(...)");
        }
        return s;
    }

    // 去混淆评级： 中等(60)
    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        return q.b((snsTarget0 == null ? null : snsTarget0.getId()), "twitter") ? va.e.c(this.getShareTitle(snsTarget0), "\n\n", "") : "";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        if(snsTarget0.getId().equals("twitter")) {
            String s = this.getShareTitle(snsTarget0);
            return s == null ? null : new String[]{s, ""};
        }
        String s1 = this.getShareTitle(snsTarget0);
        return s1 == null ? null : new String[]{s1, ""};
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayTitle(SnsTarget snsTarget0) {
        return this.b;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getOutPostingLogParam(SnsTarget snsTarget0) {
        String s = this.getBaseOutPostingLogParam(snsTarget0) + "&sId=" + this.f;
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "mwchannel";
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareGatePageUrl(SnsTarget snsTarget0, boolean z) {
        return this.e == null ? "" : this.e;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        String s = this.d;
        if(s == null) {
            s = this.getDefaultPostImageUrl();
            q.f(s, "getDefaultPostImageUrl(...)");
        }
        return s;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareLinkFacebook() {
        return this.e == null ? "" : this.e;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareLinkKakao() {
        return this.e == null ? "" : this.e;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareLinkNormal() {
        return this.e == null ? "" : this.e;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareLinkTwitter() {
        return this.e == null ? "" : this.e;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        String s = this.b;
        q.g(snsTarget0, "target");
        return snsTarget0.getId().equals("facebook") ? s : " " + s;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isShowMusicMessage() {
        return false;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.d);
        parcel0.writeString(this.e);
        parcel0.writeString(this.f);
    }
}

