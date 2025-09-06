package co.ab180.airbridge.internal.network.model;

import U4.x;
import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.z;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(z.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\t\b\u0081\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0007\u001A\u00020\u0002\u0012\u0006\u0010\b\u001A\u00020\u0002\u0012\u0006\u0010\t\u001A\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001A\u00020\u00002\b\b\u0002\u0010\u0007\u001A\u00020\u00022\b\b\u0002\u0010\b\u001A\u00020\u00022\b\b\u0002\u0010\t\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\r\u001A\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0004J\u001A\u0010\u0012\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001C\u0010\t\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001A\u0004\b\u0015\u0010\u0004R\u001C\u0010\b\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001A\u0004\b\u0016\u0010\u0004R\u001C\u0010\u0007\u001A\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001A\u0004\b\u0017\u0010\u0004¨\u0006\u001A"}, d2 = {"Lco/ab180/airbridge/internal/network/model/ScreenInfo;", "", "", "component1", "()I", "component2", "component3", "width", "height", "density", "copy", "(III)Lco/ab180/airbridge/internal/network/model/ScreenInfo;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getDensity", "getHeight", "getWidth", "<init>", "(III)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class ScreenInfo {
    @d("density")
    private final int density;
    @d("height")
    private final int height;
    @d("width")
    private final int width;

    public ScreenInfo(int v, int v1, int v2) {
        this.width = v;
        this.height = v1;
        this.density = v2;
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final int component3() {
        return this.density;
    }

    @NotNull
    public final ScreenInfo copy(int v, int v1, int v2) {
        return new ScreenInfo(v, v1, v2);
    }

    public static ScreenInfo copy$default(ScreenInfo screenInfo0, int v, int v1, int v2, int v3, Object object0) {
        if((v3 & 1) != 0) {
            v = screenInfo0.width;
        }
        if((v3 & 2) != 0) {
            v1 = screenInfo0.height;
        }
        if((v3 & 4) != 0) {
            v2 = screenInfo0.density;
        }
        return screenInfo0.copy(v, v1, v2);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof ScreenInfo && this.width == ((ScreenInfo)object0).width && this.height == ((ScreenInfo)object0).height && this.density == ((ScreenInfo)object0).density;
    }

    public final int getDensity() {
        return this.density;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    @Override
    public int hashCode() {
        return this.density + A7.d.b(this.height, this.width * 0x1F, 0x1F);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ScreenInfo(width=");
        stringBuilder0.append(this.width);
        stringBuilder0.append(", height=");
        stringBuilder0.append(this.height);
        stringBuilder0.append(", density=");
        return x.g(this.density, ")", stringBuilder0);
    }
}

