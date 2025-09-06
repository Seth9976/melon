package com.iloen.melon.player.video.cheer;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0007\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001A\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\fj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/player/video/cheer/CheerUnit;", "", "", "a", "J", "getNum", "()J", "num", "", "b", "Ljava/lang/String;", "getUnit", "()Ljava/lang/String;", "unit", "K_1", "K_10", "M", "OVER", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CheerUnit extends Enum {
    public static final enum CheerUnit K_1;
    public static final enum CheerUnit K_10;
    public static final enum CheerUnit M;
    public static final enum CheerUnit OVER;
    public final long a;
    public final String b;
    public static final CheerUnit[] c;
    public static final b d;

    static {
        CheerUnit.K_1 = new CheerUnit(0, "K_1", "K", 1000L);
        CheerUnit.K_10 = new CheerUnit(1, "K_10", "0K", 10000L);
        CheerUnit.M = new CheerUnit(2, "M", "M", 1000000L);
        CheerUnit.OVER = new CheerUnit(3, "OVER", "+++", 1000000000L);
        CheerUnit[] arr_cheerUnit = {CheerUnit.K_1, CheerUnit.K_10, CheerUnit.M, CheerUnit.OVER};
        CheerUnit.c = arr_cheerUnit;
        q.g(arr_cheerUnit, "entries");
        CheerUnit.d = new b(arr_cheerUnit);
    }

    public CheerUnit(int v, String s, String s1, long v1) {
        super(s, v);
        this.a = v1;
        this.b = s1;
    }

    @NotNull
    public static a getEntries() {
        return CheerUnit.d;
    }

    public final long getNum() {
        return this.a;
    }

    @NotNull
    public final String getUnit() {
        return this.b;
    }

    public static CheerUnit valueOf(String s) {
        return (CheerUnit)Enum.valueOf(CheerUnit.class, s);
    }

    public static CheerUnit[] values() {
        return (CheerUnit[])CheerUnit.c.clone();
    }
}

