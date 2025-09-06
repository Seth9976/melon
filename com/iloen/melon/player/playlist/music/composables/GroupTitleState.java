package com.iloen.melon.player.playlist.music.composables;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000E\u0010\tJ\u0010\u0010\u000F\u001A\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000F\u0010\u000BJ\u001A\u0010\u0012\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u000B¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/player/playlist/music/composables/GroupTitleState;", "", "", "title", "", "count", "<init>", "(Ljava/lang/String;I)V", "component1", "()Ljava/lang/String;", "component2", "()I", "copy", "(Ljava/lang/String;I)Lcom/iloen/melon/player/playlist/music/composables/GroupTitleState;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getTitle", "b", "I", "getCount", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class GroupTitleState {
    public static final int $stable;
    public final String a;
    public final int b;

    public GroupTitleState(@NotNull String s, int v) {
        q.g(s, "title");
        super();
        this.a = s;
        this.b = v;
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final GroupTitleState copy(@NotNull String s, int v) {
        q.g(s, "title");
        return new GroupTitleState(s, v);
    }

    public static GroupTitleState copy$default(GroupTitleState groupTitleState0, String s, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = groupTitleState0.a;
        }
        if((v1 & 2) != 0) {
            v = groupTitleState0.b;
        }
        return groupTitleState0.copy(s, v);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof GroupTitleState)) {
            return false;
        }
        return q.b(this.a, ((GroupTitleState)object0).a) ? this.b == ((GroupTitleState)object0).b : false;
    }

    public final int getCount() {
        return this.b;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    @Override
    public int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "GroupTitleState(title=" + this.a + ", count=" + this.b + ")";
    }
}

