package com.iloen.melon.sns.model;

import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;
import java.util.Arrays;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/iloen/melon/sns/model/SharableHighlight;", "Lcom/iloen/melon/sns/model/SharableBase;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SharableHighlight extends SharableBase {
    @NotNull
    public static final Parcelable.Creator CREATOR = null;
    public final String a;
    public final String b;
    public final String d;
    public final String e;
    public final String f;
    private static final long serialVersionUID = 0x103DE72E79102C3FL;

    static {
        SharableHighlight.CREATOR = new e(19);
    }

    public SharableHighlight(String s, String s1, String s2, String s3, String s4) {
        this.a = s;
        this.b = s1;
        this.d = s2;
        this.e = s3;
        this.f = s4;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getContentId() {
        return this.a == null ? "" : this.a;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final ContsTypeCode getContsTypeCode() {
        q.f(ContsTypeCode.SONG, "SONG");
        return ContsTypeCode.SONG;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDefaultShareLinkPageUrl(SnsTarget snsTarget0) {
        q.g(snsTarget0, "target");
        String s = snsTarget0.getId();
        StringBuilder stringBuilder0 = new StringBuilder("https://m2.melon.com/pda/msvc/snsGatePage.jsp?type=son&sId=");
        stringBuilder0.append(this.getContentId());
        stringBuilder0.append("&ref=");
        stringBuilder0.append(s);
        stringBuilder0.append("&imageUrl=");
        stringBuilder0.append(this.e);
        stringBuilder0.append("&subType=lyric");
        if(TextUtils.equals("facebook", s)) {
            stringBuilder0.append("&timestamp=");
            stringBuilder0.append(System.currentTimeMillis());
        }
        String s1 = stringBuilder0.toString();
        q.f(s1, "toString(...)");
        return s1;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final String getDisplayImageUrl(SnsTarget snsTarget0) {
        String s = this.e;
        if(TextUtils.isEmpty(s)) {
            String s1 = this.getDefaultPostEditImageUrl();
            q.f(s1, "getDefaultPostEditImageUrl(...)");
            return s1;
        }
        return s == null ? "" : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getDisplayMessage(SnsTarget snsTarget0) {
        if(Y.a(MelonAppBase.Companion) != null) {
            String s = this.getTextLimitForLength(this.b, 57);
            String s1 = this.getTextLimitForLength(this.d, 27);
            q.f("%1$s - %2$s 하이라이팅 가사를 만나보세요! ", "getString(...)");
            return this.makeMessage(snsTarget0, String.format("%1$s - %2$s 하이라이팅 가사를 만나보세요! ", Arrays.copyOf(new Object[]{s, s1}, 2)));
        }
        return null;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        String s = "";
        String s1 = this.b == null ? "" : this.b;
        String s2 = this.d;
        if(s2 != null) {
            s = s2;
        }
        return new String[]{s1, s};
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getPageTypeCode() {
        return "son";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareImageUrl(SnsTarget snsTarget0) {
        String s = this.e;
        if(TextUtils.isEmpty(s)) {
            String s1 = this.getDefaultPostImageUrl();
            q.f(s1, "getDefaultPostImageUrl(...)");
            return s1;
        }
        return s == null ? "" : s;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public final String getShareTitle(SnsTarget snsTarget0) {
        return va.e.c(this.getTextLimitForLength(this.b, 57), " - ", this.getTextLimitForLength(this.d, 27));
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public final boolean isShowInstagram() {
        return true;
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

