package com.iloen.melon.sns.model;

import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import t9.D;
import t9.K;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/iloen/melon/sns/model/SharableCast;", "Lcom/iloen/melon/sns/model/SharableBase;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SharableCast extends SharableBase {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public String a;
    public String b;
    public String d;
    public String e;

    static {
        SharableCast.CREATOR = new e(15);
    }

    public final String a(SnsTarget snsTarget0, boolean z) {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(snsTarget0 instanceof D || snsTarget0 instanceof K) {
            String s = this.e;
            if(s != null) {
                if(s.length() < 12) {
                    stringBuilder0.append(s);
                }
                else {
                    String s1 = s.substring(0, 12);
                    q.f(s1, "substring(...)");
                    stringBuilder0.append(s1);
                    stringBuilder0.append("...");
                }
            }
            MelonAppBase.Companion.getClass();
            stringBuilder0.append("의 캐스트");
            stringBuilder0.append(" ");
        }
        if(z) {
            stringBuilder0.append("\'");
        }
        String s2 = this.b;
        if(s2 != null) {
            stringBuilder0.append(s2);
            if(stringBuilder0.length() > 67) {
                stringBuilder0.delete(67, stringBuilder0.length());
                stringBuilder0.append("...");
            }
            if(z) {
                stringBuilder0.append("\'");
                MelonAppBase.Companion.getClass();
                stringBuilder0.append(" 들어볼래요? - 멜론 스테이션");
            }
        }
        return stringBuilder0.toString();
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
            s = this.getDefaultPostEditImageUrl();
            q.f(s, "getDefaultPostEditImageUrl(...)");
        }
        return s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        if(Y.a(MelonAppBase.Companion) == null) {
            LogU.Companion.e("SharableCast", "getDisplayMessage() invalid context");
            return null;
        }
        String s = this.b == null ? null : this.a(snsTarget0, true);
        if(TextUtils.isEmpty(s)) {
            LogU.Companion.e("SharableCast", "getDisplayMessage() invalid channelName");
            return null;
        }
        return this.makeMessage(snsTarget0, s);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        String s = this.getShareTitle(snsTarget0);
        return s == null ? null : new String[]{s, Z.m(MelonAppBase.Companion, 0x7F130A4A, "getString(...)")};  // string:sns_share_melon_station "멜론 스테이션"
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayTitle(SnsTarget snsTarget0) {
        return null;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "radiocast";
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getShareGatePageUrl(SnsTarget snsTarget0, boolean z) {
        q.g(snsTarget0, "target");
        StringBuilder stringBuilder0 = new StringBuilder("https://m2.melon.com/pda/msvc/snsGatePage.jsp?type=radiocast&sId=");
        stringBuilder0.append(StringUtils.getNotNullString(this.a));
        stringBuilder0.append("&ref=");
        stringBuilder0.append(snsTarget0.getId());
        if(z) {
            String s = this.getShortenUrl(stringBuilder0.toString());
            q.f(s, "getShortenUrl(...)");
            return s;
        }
        String s1 = stringBuilder0.toString();
        q.f(s1, "toString(...)");
        return s1;
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

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        return this.b == null ? null : this.a(snsTarget0, false);
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
    }
}

