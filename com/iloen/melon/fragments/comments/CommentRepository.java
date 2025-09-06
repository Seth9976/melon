package com.iloen.melon.fragments.comments;

import com.iloen.melon.net.v3x.comments.InformCmtContsSummReq.Params;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H&J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\nH&J\u0018\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\tH&¨\u0006\u000EÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/comments/CommentRepository;", "", "fetchCommentCountAndStatus", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;", "requestTag", "", "params", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummReq$Params;", "fetchLoadPgn", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "Lcom/iloen/melon/net/v3x/comments/LoadPgnReq$Params;", "fetchListCmt", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "loadPgnRes", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface CommentRepository {
    @NotNull
    InformCmtContsSummRes fetchCommentCountAndStatus(@NotNull String arg1, @NotNull Params arg2);

    @NotNull
    ListCmtRes fetchListCmt(@NotNull String arg1, @NotNull LoadPgnRes arg2);

    @NotNull
    LoadPgnRes fetchLoadPgn(@NotNull String arg1, @NotNull com.iloen.melon.net.v3x.comments.LoadPgnReq.Params arg2);
}

