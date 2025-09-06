package com.melon.net.res.v3;

import ba.s;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ*\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0012\u001A\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001A\u0010\u0017\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001A\u0004\b\u001A\u0010\tR\u001D\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001B\u001A\u0004\b\u001C\u0010\u000B¨\u0006\u001D"}, d2 = {"Lcom/melon/net/res/v3/CommentInfoUiModel;", "Lba/s;", "Lcom/melon/net/res/v3/CommentUiModel;", "comment", "", "replyList", "<init>", "(Lcom/melon/net/res/v3/CommentUiModel;Ljava/util/List;)V", "component1", "()Lcom/melon/net/res/v3/CommentUiModel;", "component2", "()Ljava/util/List;", "copy", "(Lcom/melon/net/res/v3/CommentUiModel;Ljava/util/List;)Lcom/melon/net/res/v3/CommentInfoUiModel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/melon/net/res/v3/CommentUiModel;", "getComment", "Ljava/util/List;", "getReplyList", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CommentInfoUiModel implements s {
    public static final int $stable = 8;
    @NotNull
    private final CommentUiModel comment;
    @NotNull
    private final List replyList;

    public CommentInfoUiModel(@NotNull CommentUiModel commentUiModel0, @NotNull List list0) {
        q.g(commentUiModel0, "comment");
        q.g(list0, "replyList");
        super();
        this.comment = commentUiModel0;
        this.replyList = list0;
    }

    @NotNull
    public final CommentUiModel component1() {
        return this.comment;
    }

    @NotNull
    public final List component2() {
        return this.replyList;
    }

    @NotNull
    public final CommentInfoUiModel copy(@NotNull CommentUiModel commentUiModel0, @NotNull List list0) {
        q.g(commentUiModel0, "comment");
        q.g(list0, "replyList");
        return new CommentInfoUiModel(commentUiModel0, list0);
    }

    public static CommentInfoUiModel copy$default(CommentInfoUiModel commentInfoUiModel0, CommentUiModel commentUiModel0, List list0, int v, Object object0) {
        if((v & 1) != 0) {
            commentUiModel0 = commentInfoUiModel0.comment;
        }
        if((v & 2) != 0) {
            list0 = commentInfoUiModel0.replyList;
        }
        return commentInfoUiModel0.copy(commentUiModel0, list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CommentInfoUiModel)) {
            return false;
        }
        return q.b(this.comment, ((CommentInfoUiModel)object0).comment) ? q.b(this.replyList, ((CommentInfoUiModel)object0).replyList) : false;
    }

    @NotNull
    public final CommentUiModel getComment() {
        return this.comment;
    }

    @NotNull
    public final List getReplyList() {
        return this.replyList;
    }

    @Override
    public int hashCode() {
        return this.replyList.hashCode() + this.comment.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "CommentInfoUiModel(comment=" + this.comment + ", replyList=" + this.replyList + ")";
    }
}

