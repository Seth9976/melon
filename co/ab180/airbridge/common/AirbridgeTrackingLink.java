package co.ab180.airbridge.common;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0006\u001A\u00020\u00022\b\b\u0002\u0010\u0007\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0012\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0006\u001A\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001A\u0004\b\u0018\u0010\u0004¨\u0006\u001B"}, d2 = {"Lco/ab180/airbridge/common/AirbridgeTrackingLink;", "", "Landroid/net/Uri;", "component1", "()Landroid/net/Uri;", "component2", "shortURL", "qrcodeURL", "copy", "(Landroid/net/Uri;Landroid/net/Uri;)Lco/ab180/airbridge/common/AirbridgeTrackingLink;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Landroid/net/Uri;", "getQrcodeURL", "a", "getShortURL", "<init>", "(Landroid/net/Uri;Landroid/net/Uri;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class AirbridgeTrackingLink {
    @NotNull
    private final Uri a;
    @NotNull
    private final Uri b;

    public AirbridgeTrackingLink(@NotNull Uri uri0, @NotNull Uri uri1) {
        this.a = uri0;
        this.b = uri1;
    }

    @NotNull
    public final Uri component1() {
        return this.a;
    }

    @NotNull
    public final Uri component2() {
        return this.b;
    }

    @NotNull
    public final AirbridgeTrackingLink copy(@NotNull Uri uri0, @NotNull Uri uri1) {
        return new AirbridgeTrackingLink(uri0, uri1);
    }

    public static AirbridgeTrackingLink copy$default(AirbridgeTrackingLink airbridgeTrackingLink0, Uri uri0, Uri uri1, int v, Object object0) {
        if((v & 1) != 0) {
            uri0 = airbridgeTrackingLink0.a;
        }
        if((v & 2) != 0) {
            uri1 = airbridgeTrackingLink0.b;
        }
        return airbridgeTrackingLink0.copy(uri0, uri1);
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof AirbridgeTrackingLink && q.b(this.a, ((AirbridgeTrackingLink)object0).a) && q.b(this.b, ((AirbridgeTrackingLink)object0).b);
    }

    @NotNull
    public final Uri getQrcodeURL() {
        return this.b;
    }

    @NotNull
    public final Uri getShortURL() {
        return this.a;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        Uri uri0 = this.b;
        if(uri0 != null) {
            v = uri0.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "AirbridgeTrackingLink(shortURL=" + this.a + ", qrcodeURL=" + this.b + ")";
    }
}

