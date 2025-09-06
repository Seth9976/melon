package com.iloen.melon.fragments.comments;

import Vb.i;
import android.app.Application;
import androidx.lifecycle.K;
import androidx.lifecycle.a;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.e1;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummReq.Params;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import d3.g;
import ie.H;
import ie.j;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\'\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u0004\u0018\u00010\u000E¢\u0006\u0004\b\u000F\u0010\u0010J%\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u0006¢\u0006\u0004\b\f\u0010\u0011J\r\u0010\u0012\u001A\u00020\u000B¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u0006¢\u0006\u0004\b\u0012\u0010\rJ\r\u0010\u0014\u001A\u00020\u000B¢\u0006\u0004\b\u0014\u0010\u0013J%\u0010\u0014\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u0006¢\u0006\u0004\b\u0014\u0010\rR\u0014\u0010\u0016\u001A\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001A\u00020\u000E8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R!\u0010 \u001A\b\u0012\u0004\u0012\u00020\u001B0\u001A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001FR!\u0010$\u001A\b\u0012\u0004\u0012\u00020!0\u001A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001D\u001A\u0004\b#\u0010\u001FR\u0017\u0010(\u001A\b\u0012\u0004\u0012\u00020\u001B0%8F¢\u0006\u0006\u001A\u0004\b&\u0010\'R\u0017\u0010*\u001A\b\u0012\u0004\u0012\u00020!0%8F¢\u0006\u0006\u001A\u0004\b)\u0010\'¨\u0006,"}, d2 = {"Lcom/iloen/melon/fragments/comments/CommentViewModel;", "Landroidx/lifecycle/a;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "", "requestTag", "", "bbsChnlSeq", "bbsContentRefValue", "Lie/H;", "initParam", "(Ljava/lang/String;ILjava/lang/String;)V", "Lcom/iloen/melon/fragments/comments/BbsParam;", "getParam", "()Lcom/iloen/melon/fragments/comments/BbsParam;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "requestCountAndStatus", "()V", "requestList", "Lcom/iloen/melon/fragments/comments/CommentRepository;", "repository", "Lcom/iloen/melon/fragments/comments/CommentRepository;", "param", "Lcom/iloen/melon/fragments/comments/BbsParam;", "Lcom/iloen/melon/custom/e1;", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;", "_informCmtContsSum$delegate", "Lie/j;", "get_informCmtContsSum", "()Lcom/iloen/melon/custom/e1;", "_informCmtContsSum", "Lcom/iloen/melon/fragments/comments/CommentData;", "_commentData$delegate", "get_commentData", "_commentData", "Landroidx/lifecycle/K;", "getInformCmtContsSum", "()Landroidx/lifecycle/K;", "informCmtContsSum", "getCommentData", "commentData", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CommentViewModel extends a {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/comments/CommentViewModel$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "CommentViewModel";
    @NotNull
    private final j _commentData$delegate;
    @NotNull
    private final j _informCmtContsSum$delegate;
    private BbsParam param;
    @NotNull
    private final CommentRepository repository;

    static {
        CommentViewModel.Companion = new Companion(null);
        CommentViewModel.$stable = 8;
    }

    public CommentViewModel(@NotNull Application application0) {
        q.g(application0, "application");
        super(application0);
        this.repository = new CommentRepositoryImpl(application0);
        this._informCmtContsSum$delegate = g.Q(new i(21));
        this._commentData$delegate = g.Q(new i(22));
    }

    private static final e1 _commentData_delegate$lambda$1() {
        return new e1();
    }

    private static final e1 _informCmtContsSum_delegate$lambda$0() {
        return new e1();
    }

    @NotNull
    public final K getCommentData() {
        return this.get_commentData();
    }

    @NotNull
    public final K getInformCmtContsSum() {
        return this.get_informCmtContsSum();
    }

    @Nullable
    public final BbsParam getParam() {
        return this.param == null ? null : this.param;
    }

    private final e1 get_commentData() {
        return (e1)this._commentData$delegate.getValue();
    }

    private final e1 get_informCmtContsSum() {
        return (e1)this._informCmtContsSum$delegate.getValue();
    }

    private final void initParam(String s, int v, String s1) {
        this.param = new BbsParam(s, v, s1);
    }

    public final void initParam(@NotNull String s, @NotNull String s1, @NotNull String s2) {
        q.g(s, "requestTag");
        q.g(s1, "bbsChnlSeq");
        q.g(s2, "bbsContentRefValue");
        this.initParam(s, StringUtils.getNumberFromString(s1), s2);
    }

    public final void requestCountAndStatus() {
        if(this.param == null) {
            LogU.Companion.e("CommentViewModel", "Param is not initialized.");
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;

            {
                CommentViewModel.this = commentViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.comments.CommentViewModel.requestCountAndStatus.1(CommentViewModel.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.comments.CommentViewModel.requestCountAndStatus.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                e1 e11;
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        BbsParam bbsParam0 = CommentViewModel.this.param;
                        if(bbsParam0 != null) {
                            int v = bbsParam0.getBbsChnlSeq();
                            if(CommentViewModel.this.param != null) {
                                Integer integer0 = CmtHelper.getLatestComment(v, "");
                                int v1 = integer0 == null ? -1 : ((int)integer0);
                                Params informCmtContsSummReq$Params0 = new Params();
                                informCmtContsSummReq$Params0.chnlSeq = v;
                                if(CommentViewModel.this.param != null) {
                                    informCmtContsSummReq$Params0.contsRefValue = "";
                                    informCmtContsSummReq$Params0.latestCmtSeq = v1;
                                    Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(informCmtContsSummReq$Params0, null) {
                                        final Params $params;
                                        int label;

                                        {
                                            CommentViewModel.this = commentViewModel0;
                                            this.$params = informCmtContsSummReq$Params0;
                                            super(2, continuation0);
                                        }

                                        @Override  // oe.a
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            return new com.iloen.melon.fragments.comments.CommentViewModel.requestCountAndStatus.1.commentCountAndStatusDeferred.1(CommentViewModel.this, this.$params, continuation0);
                                        }

                                        @Override  // we.n
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                            return ((com.iloen.melon.fragments.comments.CommentViewModel.requestCountAndStatus.1.commentCountAndStatusDeferred.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            if(this.label != 0) {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                            d5.n.D(object0);
                                            CommentRepository commentRepository0 = CommentViewModel.this.repository;
                                            if(CommentViewModel.this.param != null) {
                                                return commentRepository0.fetchCommentCountAndStatus("", this.$params);
                                            }
                                            q.m("param");
                                            throw null;
                                        }
                                    }, 3, null);
                                    try {
                                        e1 e10 = CommentViewModel.this.get_informCmtContsSum();
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = e10;
                                        this.I$0 = v;
                                        this.I$1 = v1;
                                        this.label = 1;
                                        object0 = deferred0.await(this);
                                        if(object0 == a0) {
                                            return a0;
                                        }
                                        e11 = e10;
                                        goto label_38;
                                    }
                                    catch(Exception unused_ex) {
                                        break;
                                    }
                                }
                                q.m("param");
                                throw null;
                            }
                            q.m("param");
                            throw null;
                        }
                        q.m("param");
                        throw null;
                    }
                    case 1: {
                        e11 = (e1)this.L$2;
                        Deferred deferred1 = (Deferred)this.L$1;
                        Params informCmtContsSummReq$Params1 = (Params)this.L$0;
                        try {
                            d5.n.D(object0);
                        label_38:
                            e11.setValue(object0);
                        }
                        catch(Exception unused_ex) {
                        }
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return H.a;
            }
        }, 3, null);
    }

    public final void requestCountAndStatus(@NotNull String s, int v, @NotNull String s1) {
        q.g(s, "requestTag");
        q.g(s1, "bbsContentRefValue");
        this.initParam(s, v, s1);
        this.requestCountAndStatus();
    }

    public final void requestList() {
        if(this.param == null) {
            LogU.Companion.e("CommentViewModel", "Param is not initialized.");
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            {
                CommentViewModel.this = commentViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.comments.CommentViewModel.requestList.1(CommentViewModel.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.comments.CommentViewModel.requestList.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                LoadPgnRes loadPgnRes1;
                CommentViewModel commentViewModel1;
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.net.v3x.comments.LoadPgnReq.Params loadPgnReq$Params0 = new com.iloen.melon.net.v3x.comments.LoadPgnReq.Params();
                        CommentViewModel commentViewModel0 = CommentViewModel.this;
                        BbsParam bbsParam0 = commentViewModel0.param;
                        if(bbsParam0 != null) {
                            loadPgnReq$Params0.chnlSeq = bbsParam0.getBbsChnlSeq();
                            if(commentViewModel0.param != null) {
                                loadPgnReq$Params0.contsRefValue = "";
                                Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(loadPgnReq$Params0, null) {
                                    final com.iloen.melon.net.v3x.comments.LoadPgnReq.Params $params;
                                    int label;

                                    {
                                        CommentViewModel.this = commentViewModel0;
                                        this.$params = loadPgnReq$Params0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.fragments.comments.CommentViewModel.requestList.1.loadPgnDeferred.1(CommentViewModel.this, this.$params, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.comments.CommentViewModel.requestList.1.loadPgnDeferred.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        if(this.label != 0) {
                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                        }
                                        d5.n.D(object0);
                                        CommentRepository commentRepository0 = CommentViewModel.this.repository;
                                        if(CommentViewModel.this.param != null) {
                                            return commentRepository0.fetchLoadPgn("", this.$params);
                                        }
                                        q.m("param");
                                        throw null;
                                    }
                                }, 3, null);
                                try {
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.label = 1;
                                    object0 = deferred0.await(this);
                                    if(object0 == a0) {
                                        return a0;
                                    }
                                    goto label_25;
                                }
                                catch(Exception unused_ex) {
                                    return H.a;
                                }
                            }
                            q.m("param");
                            throw null;
                        }
                        q.m("param");
                        throw null;
                    }
                    case 1: {
                        Deferred deferred1 = (Deferred)this.L$1;
                        com.iloen.melon.net.v3x.comments.LoadPgnReq.Params loadPgnReq$Params1 = (com.iloen.melon.net.v3x.comments.LoadPgnReq.Params)this.L$0;
                        try {
                            d5.n.D(object0);
                        label_25:
                            LoadPgnRes loadPgnRes0 = (LoadPgnRes)object0;
                            if(!loadPgnRes0.isSuccessful()) {
                                loadPgnRes0 = null;
                            }
                            if(loadPgnRes0 != null) {
                                commentViewModel1 = CommentViewModel.this;
                                Deferred deferred2 = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(loadPgnRes0, null) {
                                    final LoadPgnRes $pgnInfo;
                                    int label;

                                    {
                                        CommentViewModel.this = commentViewModel0;
                                        this.$pgnInfo = loadPgnRes0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.fragments.comments.CommentViewModel.requestList.1.2.listCmtResDeferred.1(CommentViewModel.this, this.$pgnInfo, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.comments.CommentViewModel.requestList.1.2.listCmtResDeferred.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        if(this.label != 0) {
                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                        }
                                        d5.n.D(object0);
                                        CommentRepository commentRepository0 = CommentViewModel.this.repository;
                                        if(CommentViewModel.this.param != null) {
                                            return commentRepository0.fetchListCmt("", this.$pgnInfo);
                                        }
                                        q.m("param");
                                        throw null;
                                    }
                                }, 3, null);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = commentViewModel1;
                                this.L$4 = loadPgnRes0;
                                this.L$5 = null;
                                this.I$0 = 0;
                                this.label = 2;
                                Object object1 = deferred2.await(this);
                                if(object1 == a0) {
                                    return a0;
                                }
                                loadPgnRes1 = loadPgnRes0;
                                object0 = object1;
                                goto label_52;
                            }
                        }
                        catch(Exception unused_ex) {
                        }
                        return H.a;
                    }
                    case 2: {
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                Deferred deferred3 = (Deferred)this.L$5;
                loadPgnRes1 = (LoadPgnRes)this.L$4;
                commentViewModel1 = (CommentViewModel)this.L$3;
                LoadPgnRes loadPgnRes2 = (LoadPgnRes)this.L$2;
                Deferred deferred4 = (Deferred)this.L$1;
                com.iloen.melon.net.v3x.comments.LoadPgnReq.Params loadPgnReq$Params2 = (com.iloen.melon.net.v3x.comments.LoadPgnReq.Params)this.L$0;
                try {
                    d5.n.D(object0);
                label_52:
                    if(((ListCmtRes)object0).isSuccessful()) {
                        commentViewModel1.get_commentData().setValue(new CommentData(loadPgnRes1, ((ListCmtRes)object0)));
                    }
                }
                catch(Exception unused_ex) {
                }
                return H.a;
            }
        }, 3, null);
    }

    public final void requestList(@NotNull String s, int v, @NotNull String s1) {
        q.g(s, "requestTag");
        q.g(s1, "bbsContentRefValue");
        this.initParam(s, v, s1);
        this.requestList();
    }
}

