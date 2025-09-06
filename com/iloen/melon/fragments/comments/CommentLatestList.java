package com.iloen.melon.fragments.comments;

import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001A\u00020\u00022\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\r\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000BH&¢\u0006\u0004\b\r\u0010\u000EJ)\u0010\u0014\u001A\u00020\u00022\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u000F2\b\b\u0002\u0010\u0013\u001A\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0018\u001A\u00020\u00172\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u0016\u001A\u00020\u000BH&¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001B\u001A\u00020\u001AH&¢\u0006\u0004\b\u001B\u0010\u001CR\u0014\u0010 \u001A\u00020\u001D8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010\"\u001A\u00020\u001A8&X¦\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u001CR\u0014\u0010&\u001A\u00020#8&X¦\u0004¢\u0006\u0006\u001A\u0004\b$\u0010%¨\u0006\'À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/comments/CommentLatestList;", "", "Lie/H;", "registerCommentViewModelObserver", "()V", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;", "infoCmtContsRes", "updateCommentCountView", "(Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;)V", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "loadPgnRes", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "listCmtRes", "updateCommentListView", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)V", "", "bbsChannelSeq", "bbsContsRefValue", "", "includeCountApi", "requestCommentApis", "(Ljava/lang/String;Ljava/lang/String;Z)V", "cmtRes", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel;", "getCmtResViewModel", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)Lcom/iloen/melon/net/v3x/comments/CmtResViewModel;", "Lcom/iloen/melon/fragments/comments/CommentActionImpl;", "getCommentActionListener", "()Lcom/iloen/melon/fragments/comments/CommentActionImpl;", "Lcom/iloen/melon/fragments/comments/CommentViewModel;", "getCommentViewModel", "()Lcom/iloen/melon/fragments/comments/CommentViewModel;", "commentViewModel", "getCommentActionImpl", "commentActionImpl", "", "getCommentAdapterPosition", "()I", "commentAdapterPosition", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface CommentLatestList {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class DefaultImpls {
        public static void requestCommentApis$default(CommentLatestList commentLatestList0, String s, String s1, boolean z, int v, Object object0) {
            CommentLatestList.requestCommentApis$default(commentLatestList0, s, s1, z, v, object0);
        }
    }

    @NotNull
    CmtResViewModel getCmtResViewModel(@NotNull LoadPgnRes arg1, @NotNull ListCmtRes arg2);

    @NotNull
    CommentActionImpl getCommentActionImpl();

    @NotNull
    CommentActionImpl getCommentActionListener();

    int getCommentAdapterPosition();

    @NotNull
    CommentViewModel getCommentViewModel();

    void registerCommentViewModelObserver();

    void requestCommentApis(@NotNull String arg1, @NotNull String arg2, boolean arg3);

    static void requestCommentApis$default(CommentLatestList commentLatestList0, String s, String s1, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestCommentApis");
        }
        if((v & 4) != 0) {
            z = true;
        }
        commentLatestList0.requestCommentApis(s, s1, z);
    }

    void updateCommentCountView(@Nullable InformCmtContsSummRes arg1);

    void updateCommentListView(@NotNull LoadPgnRes arg1, @NotNull ListCmtRes arg2);
}

