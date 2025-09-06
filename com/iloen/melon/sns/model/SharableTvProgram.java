package com.iloen.melon.sns.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import java.util.Arrays;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/iloen/melon/sns/model/SharableTvProgram;", "Lcom/iloen/melon/sns/model/SharableBase;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SharableTvProgram extends SharableBase {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public String a;
    public String b;
    public String d;
    public ShareLinkData e;

    static {
        SharableTvProgram.CREATOR = new e(11);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.a;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        q.f(ContsTypeCode.TV_PROGRAM, "TV_PROGRAM");
        return ContsTypeCode.TV_PROGRAM;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        return this.d == null ? this.getDefaultPostEditImageUrl() : this.d;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        if(Y.a(MelonAppBase.Companion) == null) {
            return null;
        }
        q.f("멜론TV \'%1$s\' - 감상해보세요.", "getString(...)");
        return this.makeMessage(snsTarget0, String.format("멜론TV \'%1$s\' - 감상해보세요.", Arrays.copyOf(new Object[]{this.b}, 1)));
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        if(Y.a(MelonAppBase.Companion) == null) {
            return null;
        }
        String s = this.b == null ? "" : this.b;
        q.f("멜론TV", "getString(...)");
        return new String[]{s, "멜론TV"};
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayTitle(SnsTarget snsTarget0) {
        return null;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "radioprogram";
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
        return this.d == null ? this.getDefaultPostEditImageUrl() : this.d;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareLinkFacebook() {
        return this.e == null ? null : this.e.b;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareLinkKakao() {
        return this.e == null ? null : this.e.d;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareLinkNormal() {
        return this.e == null ? null : this.e.a;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareLinkTwitter() {
        return this.e == null ? null : this.e.c;
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
        q.g(parcel0, "dest");
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.d);
        parcel0.writeParcelable(this.e, v);
    }
}

