package com.kakao.emoticon.net.response;

import S7.b;
import java.util.Set;
import je.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000F\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u000EHÖ\u0001J\t\u0010\u000F\u001A\u00020\u0004HÖ\u0001R\u001C\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/kakao/emoticon/net/response/Keyboard;", "", "tabItemIds", "", "", "(Ljava/util/Set;)V", "getTabItemIds", "()Ljava/util/Set;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class Keyboard {
    @b("tab_item_ids")
    @NotNull
    private final Set tabItemIds;

    public Keyboard() {
        this(null, 1, null);
    }

    public Keyboard(@NotNull Set set0) {
        q.g(set0, "tabItemIds");
        super();
        this.tabItemIds = set0;
    }

    public Keyboard(Set set0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            set0 = y.a;
        }
        this(set0);
    }

    @NotNull
    public final Set component1() {
        return this.tabItemIds;
    }

    @NotNull
    public final Keyboard copy(@NotNull Set set0) {
        q.g(set0, "tabItemIds");
        return new Keyboard(set0);
    }

    public static Keyboard copy$default(Keyboard keyboard0, Set set0, int v, Object object0) {
        if((v & 1) != 0) {
            set0 = keyboard0.tabItemIds;
        }
        return keyboard0.copy(set0);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof Keyboard && q.b(this.tabItemIds, ((Keyboard)object0).tabItemIds);
    }

    @NotNull
    public final Set getTabItemIds() {
        return this.tabItemIds;
    }

    @Override
    public int hashCode() {
        return this.tabItemIds == null ? 0 : this.tabItemIds.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "Keyboard(tabItemIds=" + this.tabItemIds + ")";
    }
}

