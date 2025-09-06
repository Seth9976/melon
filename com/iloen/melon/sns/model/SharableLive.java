package com.iloen.melon.sns.model;

import android.os.Parcel;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import java.util.Arrays;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/sns/model/SharableLive;", "Lcom/iloen/melon/sns/model/SharableBase;", "CREATOR", "com/iloen/melon/sns/model/d", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SharableLive extends SharableBase {
    @NotNull
    public static final d CREATOR;
    public String a;
    public String b;
    public String d;
    public String e;
    public ShareLinkData f;

    static {
        SharableLive.CREATOR = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final int describeContents() {
        return 0;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.a;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        q.f(ContsTypeCode.LIVE, "LIVE");
        return ContsTypeCode.LIVE;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        String s = this.e;
        if(s == null) {
            s = this.getDefaultPostEditImageUrl();
            q.f(s, "getDefaultPostEditImageUrl(...)");
        }
        return s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        if(Y.a(MelonAppBase.Companion) == null) {
            return null;
        }
        q.f("멜론 라이브 \'%1$s\' - 감상해보세요.", "getString(...)");
        return this.makeMessage(snsTarget0, String.format("멜론 라이브 \'%1$s\' - 감상해보세요.", Arrays.copyOf(new Object[]{this.b}, 1)));
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        String s = this.b;
        String s1 = "";
        if(s == null) {
            s = "";
        }
        String s2 = this.d;
        if(s2 != null) {
            s1 = s2;
        }
        return new String[]{s, s1};
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayTitle(SnsTarget snsTarget0) {
        return null;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "live";
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareGatePageUrl(SnsTarget snsTarget0, boolean z) {
        String s;
        q.g(snsTarget0, "target");
        switch(snsTarget0.getId()) {
            case "facebook": {
                s = this.getShareLinkFacebook();
                return z ? this.getShortenUrl(s) : s;
            }
            case "kakao": {
                s = this.getShareLinkKakao();
                return z ? this.getShortenUrl(s) : s;
            }
            case "twitter": {
                s = this.getShareLinkTwitter();
                return z ? this.getShortenUrl(s) : s;
            }
            default: {
                s = this.getShareLinkNormal();
                return z ? this.getShortenUrl(s) : s;
            }
        }
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        String s = this.e;
        if(s == null) {
            s = this.getDefaultPostEditImageUrl();
            q.f(s, "getDefaultPostEditImageUrl(...)");
        }
        return s;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareLinkFacebook() {
        return this.f == null ? null : this.f.b;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareLinkKakao() {
        return this.f == null ? null : this.f.d;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareLinkNormal() {
        return this.f == null ? null : this.f.a;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareLinkTwitter() {
        return this.f == null ? null : this.f.c;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        return this.b;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isShowMusicMessage() {
        return false;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isVideoContent() {
        return true;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "parcel");
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.d);
        parcel0.writeString(this.e);
        parcel0.writeParcelable(this.f, v);
    }
}

