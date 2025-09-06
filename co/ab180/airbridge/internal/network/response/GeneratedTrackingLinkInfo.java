package co.ab180.airbridge.internal.network.response;

import U4.x;
import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.j;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(j.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0006\u001A\u00020\u00022\b\b\u0002\u0010\u0007\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001A\u00020\u000BHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001A\u0010\u0010\u001A\u00020\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0006\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001A\u0004\b\u0013\u0010\u0004R\u001C\u0010\u0007\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001A\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lco/ab180/airbridge/internal/network/response/GeneratedTrackingLinkInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "shortURL", "qrcodeURL", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lco/ab180/airbridge/internal/network/response/GeneratedTrackingLinkInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getShortURL", "getQrcodeURL", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class GeneratedTrackingLinkInfo {
    @d("qrcodeURL")
    @NotNull
    private final String qrcodeURL;
    @d("shortURL")
    @NotNull
    private final String shortURL;

    public GeneratedTrackingLinkInfo(@NotNull String s, @NotNull String s1) {
        this.shortURL = s;
        this.qrcodeURL = s1;
    }

    @NotNull
    public final String component1() {
        return this.shortURL;
    }

    @NotNull
    public final String component2() {
        return this.qrcodeURL;
    }

    @NotNull
    public final GeneratedTrackingLinkInfo copy(@NotNull String s, @NotNull String s1) {
        return new GeneratedTrackingLinkInfo(s, s1);
    }

    public static GeneratedTrackingLinkInfo copy$default(GeneratedTrackingLinkInfo generatedTrackingLinkInfo0, String s, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = generatedTrackingLinkInfo0.shortURL;
        }
        if((v & 2) != 0) {
            s1 = generatedTrackingLinkInfo0.qrcodeURL;
        }
        return generatedTrackingLinkInfo0.copy(s, s1);
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof GeneratedTrackingLinkInfo && q.b(this.shortURL, ((GeneratedTrackingLinkInfo)object0).shortURL) && q.b(this.qrcodeURL, ((GeneratedTrackingLinkInfo)object0).qrcodeURL);
    }

    @NotNull
    public final String getQrcodeURL() {
        return this.qrcodeURL;
    }

    @NotNull
    public final String getShortURL() {
        return this.shortURL;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.shortURL == null ? 0 : this.shortURL.hashCode();
        String s = this.qrcodeURL;
        if(s != null) {
            v = s.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("GeneratedTrackingLinkInfo(shortURL=");
        stringBuilder0.append(this.shortURL);
        stringBuilder0.append(", qrcodeURL=");
        return x.m(stringBuilder0, this.qrcodeURL, ")");
    }
}

