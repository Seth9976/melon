package com.iloen.melon.player.video.cheer;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\b\u0087\b\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CB\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000E\u0010\tJ\u0010\u0010\u0010\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u000B¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/player/video/cheer/CheerAnimationCnt;", "", "", "num", "Lcom/iloen/melon/player/video/cheer/CheerUnit;", "unit", "<init>", "(Ljava/lang/String;Lcom/iloen/melon/player/video/cheer/CheerUnit;)V", "component1", "()Ljava/lang/String;", "component2", "()Lcom/iloen/melon/player/video/cheer/CheerUnit;", "copy", "(Ljava/lang/String;Lcom/iloen/melon/player/video/cheer/CheerUnit;)Lcom/iloen/melon/player/video/cheer/CheerAnimationCnt;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getNum", "b", "Lcom/iloen/melon/player/video/cheer/CheerUnit;", "getUnit", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CheerAnimationCnt {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/player/video/cheer/CheerAnimationCnt$Companion;", "", "", "cnt", "Lcom/iloen/melon/player/video/cheer/CheerAnimationCnt;", "convertCheerAnimationCnt", "(J)Lcom/iloen/melon/player/video/cheer/CheerAnimationCnt;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final CheerAnimationCnt convertCheerAnimationCnt(long v) {
            CheerUnit cheerUnit0 = CheerUnit.OVER;
            if(v >= cheerUnit0.getNum()) {
                return new CheerAnimationCnt(String.valueOf(v / 100000L), cheerUnit0);
            }
            CheerUnit cheerUnit1 = CheerUnit.M;
            if(v >= cheerUnit1.getNum()) {
                DecimalFormat decimalFormat0 = new DecimalFormat("#.#");
                decimalFormat0.setRoundingMode(RoundingMode.FLOOR);
                String s = decimalFormat0.format(((double)v) / ((double)cheerUnit1.getNum()));
                q.f(s, "format(...)");
                return new CheerAnimationCnt(s, cheerUnit1);
            }
            return v < CheerUnit.K_10.getNum() ? new CheerAnimationCnt(String.valueOf(v / 1000L), CheerUnit.K_1) : new CheerAnimationCnt(String.valueOf(v / 10000L), CheerUnit.K_10);
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final String a;
    public final CheerUnit b;

    static {
        CheerAnimationCnt.Companion = new Companion(null);
    }

    public CheerAnimationCnt(@NotNull String s, @NotNull CheerUnit cheerUnit0) {
        q.g(s, "num");
        q.g(cheerUnit0, "unit");
        super();
        this.a = s;
        this.b = cheerUnit0;
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final CheerUnit component2() {
        return this.b;
    }

    @NotNull
    public final CheerAnimationCnt copy(@NotNull String s, @NotNull CheerUnit cheerUnit0) {
        q.g(s, "num");
        q.g(cheerUnit0, "unit");
        return new CheerAnimationCnt(s, cheerUnit0);
    }

    public static CheerAnimationCnt copy$default(CheerAnimationCnt cheerAnimationCnt0, String s, CheerUnit cheerUnit0, int v, Object object0) {
        if((v & 1) != 0) {
            s = cheerAnimationCnt0.a;
        }
        if((v & 2) != 0) {
            cheerUnit0 = cheerAnimationCnt0.b;
        }
        return cheerAnimationCnt0.copy(s, cheerUnit0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CheerAnimationCnt)) {
            return false;
        }
        return q.b(this.a, ((CheerAnimationCnt)object0).a) ? this.b == ((CheerAnimationCnt)object0).b : false;
    }

    @NotNull
    public final String getNum() {
        return this.a;
    }

    @NotNull
    public final CheerUnit getUnit() {
        return this.b;
    }

    @Override
    public int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "CheerAnimationCnt(num=" + this.a + ", unit=" + this.b + ")";
    }
}

