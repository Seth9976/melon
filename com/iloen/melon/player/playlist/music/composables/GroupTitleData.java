package com.iloen.melon.player.playlist.music.composables;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0018\u0010\u0006\u001A\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tJ\"\u0010\n\u001A\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ\u001C\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u000BJB\u0010\r\u001A\u00020\u00002\u001A\b\u0002\u0010\u0006\u001A\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\u0014\b\u0002\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001A\u0010\u0015\u001A\u00020\u00142\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R)\u0010\u0006\u001A\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u000BR#\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u0018\u001A\u0004\b\u001B\u0010\u000B¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/player/playlist/music/composables/GroupTitleData;", "", "", "", "", "", "titleIndicesMap", "firstIndexTitleMap", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "component1", "()Ljava/util/Map;", "component2", "copy", "(Ljava/util/Map;Ljava/util/Map;)Lcom/iloen/melon/player/playlist/music/composables/GroupTitleData;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/util/Map;", "getTitleIndicesMap", "b", "getFirstIndexTitleMap", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class GroupTitleData {
    public static final int $stable = 8;
    public final Map a;
    public final Map b;

    public GroupTitleData(@NotNull Map map0, @NotNull Map map1) {
        q.g(map0, "titleIndicesMap");
        q.g(map1, "firstIndexTitleMap");
        super();
        this.a = map0;
        this.b = map1;
    }

    @NotNull
    public final Map component1() {
        return this.a;
    }

    @NotNull
    public final Map component2() {
        return this.b;
    }

    @NotNull
    public final GroupTitleData copy(@NotNull Map map0, @NotNull Map map1) {
        q.g(map0, "titleIndicesMap");
        q.g(map1, "firstIndexTitleMap");
        return new GroupTitleData(map0, map1);
    }

    public static GroupTitleData copy$default(GroupTitleData groupTitleData0, Map map0, Map map1, int v, Object object0) {
        if((v & 1) != 0) {
            map0 = groupTitleData0.a;
        }
        if((v & 2) != 0) {
            map1 = groupTitleData0.b;
        }
        return groupTitleData0.copy(map0, map1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof GroupTitleData)) {
            return false;
        }
        return q.b(this.a, ((GroupTitleData)object0).a) ? q.b(this.b, ((GroupTitleData)object0).b) : false;
    }

    @NotNull
    public final Map getFirstIndexTitleMap() {
        return this.b;
    }

    @NotNull
    public final Map getTitleIndicesMap() {
        return this.a;
    }

    @Override
    public int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "GroupTitleData(titleIndicesMap=" + this.a + ", firstIndexTitleMap=" + this.b + ")";
    }
}

