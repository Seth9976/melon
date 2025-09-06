package com.iloen.melon.fragments.comments;

import android.app.Application;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummReq.Params;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummReq;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes;
import com.iloen.melon.net.v3x.comments.ListCmtReq;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnReq;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.PAGEINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.PAGINGINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J\u0018\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0010H\u0016J\u0018\u0010\u0011\u001A\u00020\u00122\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u000FH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/comments/CommentRepositoryImpl;", "Lcom/iloen/melon/fragments/comments/CommentRepository;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "getApplication", "()Landroid/app/Application;", "fetchCommentCountAndStatus", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;", "requestTag", "", "params", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummReq$Params;", "fetchLoadPgn", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "Lcom/iloen/melon/net/v3x/comments/LoadPgnReq$Params;", "fetchListCmt", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "loadPgnRes", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CommentRepositoryImpl implements CommentRepository {
    public static final int $stable = 8;
    @NotNull
    private final Application application;

    public CommentRepositoryImpl(@NotNull Application application0) {
        q.g(application0, "application");
        super();
        this.application = application0;
    }

    @Override  // com.iloen.melon.fragments.comments.CommentRepository
    @NotNull
    public InformCmtContsSummRes fetchCommentCountAndStatus(@NotNull String s, @NotNull Params informCmtContsSummReq$Params0) {
        q.g(s, "requestTag");
        q.g(informCmtContsSummReq$Params0, "params");
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        HttpResponse httpResponse0 = RequestBuilder.newInstance(new InformCmtContsSummReq(this.application, informCmtContsSummReq$Params0)).tag(s).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v3x.comments.InformCmtContsSummRes");
        return (InformCmtContsSummRes)httpResponse0;
    }

    @Override  // com.iloen.melon.fragments.comments.CommentRepository
    @NotNull
    public ListCmtRes fetchListCmt(@NotNull String s, @NotNull LoadPgnRes loadPgnRes0) {
        q.g(s, "requestTag");
        q.g(loadPgnRes0, "loadPgnRes");
        com.iloen.melon.net.v3x.comments.ListCmtReq.Params listCmtReq$Params0 = new com.iloen.melon.net.v3x.comments.ListCmtReq.Params();
        listCmtReq$Params0.chnlSeq = loadPgnRes0.result.chnlinfo.chnlseq;
        PAGEINFO loadPgnRes$result$PAGEINFO0 = loadPgnRes0.result.pageinfo;
        listCmtReq$Params0.contsRefValue = loadPgnRes$result$PAGEINFO0.contsrefvalue;
        PAGINGINFO loadPgnRes$result$PAGINGINFO0 = loadPgnRes0.result.paginginfo;
        listCmtReq$Params0.pageNo = loadPgnRes$result$PAGINGINFO0.firstpageno;
        listCmtReq$Params0.pageSize = 3;
        listCmtReq$Params0.sortType = 0;
        listCmtReq$Params0.srchType = -1;
        if(loadPgnRes0.result == null) {
            loadPgnRes$result$PAGINGINFO0 = null;
        }
        if(loadPgnRes$result$PAGINGINFO0 != null) {
            listCmtReq$Params0.startSeq = loadPgnRes$result$PAGEINFO0.startseq;
        }
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        HttpResponse httpResponse0 = RequestBuilder.newInstance(new ListCmtReq(this.application, listCmtReq$Params0)).tag(s).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v3x.comments.ListCmtRes");
        return (ListCmtRes)httpResponse0;
    }

    @Override  // com.iloen.melon.fragments.comments.CommentRepository
    @NotNull
    public LoadPgnRes fetchLoadPgn(@NotNull String s, @NotNull com.iloen.melon.net.v3x.comments.LoadPgnReq.Params loadPgnReq$Params0) {
        q.g(s, "requestTag");
        q.g(loadPgnReq$Params0, "params");
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        HttpResponse httpResponse0 = RequestBuilder.newInstance(new LoadPgnReq(this.application, loadPgnReq$Params0)).tag(s).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
        q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v3x.comments.LoadPgnRes");
        return (LoadPgnRes)httpResponse0;
    }

    @NotNull
    public final Application getApplication() {
        return this.application;
    }
}

