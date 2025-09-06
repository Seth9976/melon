package com.iloen.melon.player.playlist.search;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ$\u0010\n\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\r\u001A\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000F\u0010\bJ\u001A\u0010\u0012\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\bR\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001A\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/player/playlist/search/IndexInfo;", "", "", "start", "end", "<init>", "(II)V", "component1", "()I", "component2", "copy", "(II)Lcom/iloen/melon/player/playlist/search/IndexInfo;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getStart", "b", "getEnd", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class IndexInfo {
    public static final int $stable;
    public final int a;
    public final int b;

    public IndexInfo(int v, int v1) {
        this.a = v;
        this.b = v1;
    }

    public final int component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final IndexInfo copy(int v, int v1) {
        return new IndexInfo(v, v1);
    }

    public static IndexInfo copy$default(IndexInfo indexInfo0, int v, int v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = indexInfo0.a;
        }
        if((v2 & 2) != 0) {
            v1 = indexInfo0.b;
        }
        return indexInfo0.copy(v, v1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof IndexInfo)) {
            return false;
        }
        return this.a == ((IndexInfo)object0).a ? this.b == ((IndexInfo)object0).b : false;
    }

    public final int getEnd() {
        return this.b;
    }

    public final int getStart() {
        return this.a;
    }

    @Override
    public int hashCode() {
        return this.b + this.a * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "IndexInfo(start=" + this.a + ", end=" + this.b + ")";
    }
}

