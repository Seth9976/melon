package com.iloen.melon.player.video;

import A7.d;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\r\b\u0082\b\u0018\u0000 !2\u00020\u0001:\u0001!B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000B\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000B\u0010\nJ\u0010\u0010\f\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\nJ8\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u0010\u0010\u0011\u001A\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\nJ\u001A\u0010\u0016\u001A\u00020\u00152\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\nR\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u0019\u001A\u0004\b\u001C\u0010\nR\u0017\u0010\u0005\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001D\u0010\u0019\u001A\u0004\b\u001E\u0010\nR\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001F\u0010\u0019\u001A\u0004\b \u0010\n¨\u0006\""}, d2 = {"Lcom/iloen/melon/player/video/HeightInfoForFocusable;", "", "", "maxVideoHeight", "minVideoHeight", "peekHeight", "bottomSheetMaxHeight", "<init>", "(IIII)V", "component1", "()I", "component2", "component3", "component4", "copy", "(IIII)Lcom/iloen/melon/player/video/HeightInfoForFocusable;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getMaxVideoHeight", "b", "getMinVideoHeight", "c", "getPeekHeight", "d", "getBottomSheetMaxHeight", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
final class HeightInfoForFocusable {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/video/HeightInfoForFocusable$Companion;", "", "Lcom/iloen/melon/player/video/HeightInfoForFocusable;", "getEmpty", "()Lcom/iloen/melon/player/video/HeightInfoForFocusable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final HeightInfoForFocusable getEmpty() {
            return new HeightInfoForFocusable(0, 0, 0, 0);
        }
    }

    @NotNull
    public static final Companion Companion;
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    static {
        HeightInfoForFocusable.Companion = new Companion(null);
    }

    public HeightInfoForFocusable(int v, int v1, int v2, int v3) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
    }

    public final int component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    @NotNull
    public final HeightInfoForFocusable copy(int v, int v1, int v2, int v3) {
        return new HeightInfoForFocusable(v, v1, v2, v3);
    }

    public static HeightInfoForFocusable copy$default(HeightInfoForFocusable heightInfoForFocusable0, int v, int v1, int v2, int v3, int v4, Object object0) {
        if((v4 & 1) != 0) {
            v = heightInfoForFocusable0.a;
        }
        if((v4 & 2) != 0) {
            v1 = heightInfoForFocusable0.b;
        }
        if((v4 & 4) != 0) {
            v2 = heightInfoForFocusable0.c;
        }
        if((v4 & 8) != 0) {
            v3 = heightInfoForFocusable0.d;
        }
        return heightInfoForFocusable0.copy(v, v1, v2, v3);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof HeightInfoForFocusable)) {
            return false;
        }
        if(this.a != ((HeightInfoForFocusable)object0).a) {
            return false;
        }
        if(this.b != ((HeightInfoForFocusable)object0).b) {
            return false;
        }
        return this.c == ((HeightInfoForFocusable)object0).c ? this.d == ((HeightInfoForFocusable)object0).d : false;
    }

    public final int getBottomSheetMaxHeight() {
        return this.d;
    }

    public final int getMaxVideoHeight() {
        return this.a;
    }

    public final int getMinVideoHeight() {
        return this.b;
    }

    public final int getPeekHeight() {
        return this.c;
    }

    @Override
    public int hashCode() {
        return this.d + d.b(this.c, d.b(this.b, this.a * 0x1F, 0x1F), 0x1F);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = o.t(this.a, this.b, "HeightInfoForFocusable(maxVideoHeight=", ", minVideoHeight=", ", peekHeight=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", bottomSheetMaxHeight=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

