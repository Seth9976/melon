package com.iloen.melon.sns.model;

import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import t9.D;
import t9.K;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/iloen/melon/sns/model/SharableCastEpisode;", "Lcom/iloen/melon/sns/model/SharableBase;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SharableCastEpisode extends SharableBase {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public String a;
    public String b;
    public String d;
    public String e;
    public ShareLinkData f;

    static {
        SharableCastEpisode.CREATOR = new e(16);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.a;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        q.f(ContsTypeCode.RADIO_CAST, "RADIO_CAST");
        return ContsTypeCode.RADIO_CAST;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        String s = this.d;
        if(s == null) {
            s = this.getDefaultPostRadioImageUrl();
            q.f(s, "getDefaultPostRadioImageUrl(...)");
        }
        return s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        String s = this.b;
        if(Y.a(MelonAppBase.Companion) != null) {
            if(s != null) {
                StringBuilder stringBuilder0 = new StringBuilder();
                if(snsTarget0 instanceof D || snsTarget0 instanceof K) {
                    String s1 = this.e;
                    if(s1 != null) {
                        if(s1.length() < 12) {
                            stringBuilder0.append(s1);
                        }
                        else {
                            String s2 = s1.substring(0, 12);
                            q.f(s2, "substring(...)");
                            stringBuilder0.append(s2);
                            stringBuilder0.append("...");
                        }
                    }
                    stringBuilder0.append("의 캐스트");
                    stringBuilder0.append(" ");
                }
                stringBuilder0.append("\'");
                stringBuilder0.append(s);
                if(stringBuilder0.length() > 67) {
                    stringBuilder0.delete(67, stringBuilder0.length());
                    stringBuilder0.append("...");
                }
                stringBuilder0.append("\'");
                stringBuilder0.append(" 들어볼래요? - 멜론 스테이션");
                CharSequence charSequence0 = stringBuilder0.toString();
                return TextUtils.isEmpty(charSequence0) ? null : this.makeMessage(snsTarget0, ((String)charSequence0));
            }
            return TextUtils.isEmpty(null) ? null : this.makeMessage(snsTarget0, null);
        }
        return null;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        if(Y.a(MelonAppBase.Companion) == null) {
            return null;
        }
        String s = this.b == null ? "" : this.b;
        q.f("멜론 스테이션", "getString(...)");
        return new String[]{s, "멜론 스테이션"};
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayTitle(SnsTarget snsTarget0) {
        return null;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "stationepsd";
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
        String s = this.d;
        if(s == null) {
            s = this.getDefaultPostRadioImageUrl();
            q.f(s, "getDefaultPostRadioImageUrl(...)");
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

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.d);
        parcel0.writeString(this.e);
        parcel0.writeParcelable(this.f, v);
    }
}

