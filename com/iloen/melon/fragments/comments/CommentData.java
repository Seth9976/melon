package com.iloen.melon.fragments.comments;

import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/comments/CommentData;", "", "loadPgnRes", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "listCmtRes", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "<init>", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)V", "getLoadPgnRes", "()Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "getListCmtRes", "()Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CommentData {
    public static final int $stable = 8;
    @NotNull
    private final ListCmtRes listCmtRes;
    @NotNull
    private final LoadPgnRes loadPgnRes;

    public CommentData(@NotNull LoadPgnRes loadPgnRes0, @NotNull ListCmtRes listCmtRes0) {
        q.g(loadPgnRes0, "loadPgnRes");
        q.g(listCmtRes0, "listCmtRes");
        super();
        this.loadPgnRes = loadPgnRes0;
        this.listCmtRes = listCmtRes0;
    }

    @NotNull
    public final LoadPgnRes component1() {
        return this.loadPgnRes;
    }

    @NotNull
    public final ListCmtRes component2() {
        return this.listCmtRes;
    }

    @NotNull
    public final CommentData copy(@NotNull LoadPgnRes loadPgnRes0, @NotNull ListCmtRes listCmtRes0) {
        q.g(loadPgnRes0, "loadPgnRes");
        q.g(listCmtRes0, "listCmtRes");
        return new CommentData(loadPgnRes0, listCmtRes0);
    }

    public static CommentData copy$default(CommentData commentData0, LoadPgnRes loadPgnRes0, ListCmtRes listCmtRes0, int v, Object object0) {
        if((v & 1) != 0) {
            loadPgnRes0 = commentData0.loadPgnRes;
        }
        if((v & 2) != 0) {
            listCmtRes0 = commentData0.listCmtRes;
        }
        return commentData0.copy(loadPgnRes0, listCmtRes0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CommentData)) {
            return false;
        }
        return q.b(this.loadPgnRes, ((CommentData)object0).loadPgnRes) ? q.b(this.listCmtRes, ((CommentData)object0).listCmtRes) : false;
    }

    @NotNull
    public final ListCmtRes getListCmtRes() {
        return this.listCmtRes;
    }

    @NotNull
    public final LoadPgnRes getLoadPgnRes() {
        return this.loadPgnRes;
    }

    @Override
    public int hashCode() {
        return this.listCmtRes.hashCode() + this.loadPgnRes.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "CommentData(loadPgnRes=" + this.loadPgnRes + ", listCmtRes=" + this.listCmtRes + ")";
    }
}

