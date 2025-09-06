package com.iloen.melon.playback.playlist.add;

import Ma.c;
import android.net.Uri;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.SmartVoiceNewSongListReq.Params;
import com.iloen.melon.net.v4x.request.SmartVoiceNewSongListReq;
import com.iloen.melon.net.v4x.response.HourlyChartListRes;
import com.iloen.melon.net.v4x.response.NewSongListRes;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.request.ChartHitsSmartVoiceSongChartListReq;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.w;
import k8.Y;
import k8.a;
import k8.b;
import k8.o;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082@¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082@¢\u0006\u0004\b\u000B\u0010\nJ \u0010\r\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\f\u001A\u0004\u0018\u00010\u0002H\u0082@¢\u0006\u0004\b\r\u0010\u000EJ9\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\u0010\u0010\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u000F\u0018\u00010\u00072\u0006\u0010\u0011\u001A\u00020\u00022\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@¢\u0006\u0004\b\u0016\u0010\nR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001A\u0004\b\u001A\u0010\u0019R\u0017\u0010\u001C\u001A\u00020\u001B8\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010#\u001A\u00020 8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/TaskGetPlayablesFromServiceScheme;", "Lkotlinx/coroutines/CoroutineScope;", "", "mUriString", "mMenuId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "", "Lcom/iloen/melon/playback/Playable;", "executeInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTop100", "areaFlag", "getNewSong", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/melon/net/res/common/SongInfoBase;", "list", "menuId", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElements", "getPlayables", "(Ljava/util/List;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)Ljava/util/List;", "execute", "Ljava/lang/String;", "getMUriString", "()Ljava/lang/String;", "getMMenuId", "Lk8/a;", "blockingProgressDialogManage", "Lk8/a;", "getBlockingProgressDialogManage", "()Lk8/a;", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TaskGetPlayablesFromServiceScheme implements CoroutineScope {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/TaskGetPlayablesFromServiceScheme$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
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
    private static final String TAG = "TaskGetPlayablesFromServiceScheme";
    @NotNull
    private final a blockingProgressDialogManage;
    @NotNull
    private final String mMenuId;
    @NotNull
    private final String mUriString;

    static {
        TaskGetPlayablesFromServiceScheme.Companion = new Companion(null);
        TaskGetPlayablesFromServiceScheme.$stable = 8;
    }

    public TaskGetPlayablesFromServiceScheme(@NotNull String s, @NotNull String s1) {
        q.g(s, "mUriString");
        q.g(s1, "mMenuId");
        super();
        this.mUriString = s;
        this.mMenuId = s1;
        this.blockingProgressDialogManage = ((o)(((c)Y.f(MelonAppBase.Companion, c.class)))).d();
    }

    @Nullable
    public final Object execute(@NotNull Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO(), new n(null) {
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            int label;

            {
                TaskGetPlayablesFromServiceScheme.this = taskGetPlayablesFromServiceScheme0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.playlist.add.TaskGetPlayablesFromServiceScheme.execute.2(TaskGetPlayablesFromServiceScheme.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.playlist.add.TaskGetPlayablesFromServiceScheme.execute.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                List list0;
                Throwable throwable1;
                String s1;
                Object object1;
                L0 l01;
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        l01 = TaskGetPlayablesFromServiceScheme.this.getBlockingProgressDialogManage();
                        TaskGetPlayablesFromServiceScheme taskGetPlayablesFromServiceScheme0 = TaskGetPlayablesFromServiceScheme.this;
                        if(l01 == null) {
                            this.L$0 = null;
                            this.L$1 = null;
                            this.I$0 = 0;
                            this.I$1 = 0;
                            this.label = 1;
                            object0 = taskGetPlayablesFromServiceScheme0.executeInternal(this);
                            return object0 == a0 ? a0 : ((List)object0);
                        }
                        ((b)l01).a("TaskGetPlayablesFromServiceScheme true", true);
                        try {
                            this.L$0 = l01;
                            this.L$1 = "TaskGetPlayablesFromServiceScheme";
                            this.I$0 = 0;
                            this.I$1 = 0;
                            this.label = 2;
                            object1 = taskGetPlayablesFromServiceScheme0.executeInternal(this);
                        }
                        catch(Throwable throwable0) {
                            s1 = "TaskGetPlayablesFromServiceScheme";
                            throwable1 = throwable0;
                            break;
                        }
                        if(object1 == a0) {
                            return a0;
                        }
                        s1 = "TaskGetPlayablesFromServiceScheme";
                        object0 = object1;
                        list0 = (List)object0;
                        goto label_44;
                    }
                    case 1: {
                        String s = (String)this.L$1;
                        L0 l00 = (L0)this.L$0;
                        d5.n.D(object0);
                        return (List)object0;
                    }
                    case 2: {
                        s1 = (String)this.L$1;
                        l01 = (L0)this.L$0;
                        try {
                            d5.n.D(object0);
                            list0 = (List)object0;
                            goto label_44;
                        }
                        catch(Throwable throwable1) {
                        }
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                Y.v(s1, " false", l01, false);
                throw throwable1;
            label_44:
                Y.v(s1, " false", l01, false);
                return list0;
            }
        }, continuation0);
    }

    private final Object executeInternal(Continuation continuation0) {
        Uri uri0 = Uri.parse(this.mUriString);
        String s = uri0.getQueryParameter("service");
        String s1 = uri0.getQueryParameter("type");
        if(q.b(s, "chart")) {
            if(!"top100".equals(s1) && !"24hits".equals(s1)) {
                throw new AddNormalException("No matched service scheme");
            }
            return this.getTop100(continuation0);
        }
        if(q.b(s, "new")) {
            if(!"song".equals(s1)) {
                throw new AddNormalException("No matched service scheme");
            }
            return this.getNewSong(uri0.getQueryParameter("areaFlg"), continuation0);
        }
        LogU.Companion.d("TaskGetPlayablesFromServiceScheme", "No matched service scheme");
        throw new AddNormalException("No matched service scheme");
    }

    @NotNull
    public final a getBlockingProgressDialogManage() {
        return this.blockingProgressDialogManage;
    }

    @Override  // kotlinx.coroutines.CoroutineScope
    @NotNull
    public i getCoroutineContext() {
        return Dispatchers.getIO();
    }

    @NotNull
    public final String getMMenuId() {
        return this.mMenuId;
    }

    @NotNull
    public final String getMUriString() {
        return this.mUriString;
    }

    private final Object getNewSong(String s, Continuation continuation0) {
        com.iloen.melon.playback.playlist.add.TaskGetPlayablesFromServiceScheme.getNewSong.1 taskGetPlayablesFromServiceScheme$getNewSong$10;
        String s1 = "I";
        if(continuation0 instanceof com.iloen.melon.playback.playlist.add.TaskGetPlayablesFromServiceScheme.getNewSong.1) {
            taskGetPlayablesFromServiceScheme$getNewSong$10 = (com.iloen.melon.playback.playlist.add.TaskGetPlayablesFromServiceScheme.getNewSong.1)continuation0;
            int v = taskGetPlayablesFromServiceScheme$getNewSong$10.label;
            if((v & 0x80000000) == 0) {
                taskGetPlayablesFromServiceScheme$getNewSong$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getNewSong(null, this);
                    }
                };
            }
            else {
                taskGetPlayablesFromServiceScheme$getNewSong$10.label = v ^ 0x80000000;
            }
        }
        else {
            taskGetPlayablesFromServiceScheme$getNewSong$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getNewSong(null, this);
                }
            };
        }
        Object object0 = taskGetPlayablesFromServiceScheme$getNewSong$10.result;
        ne.a a0 = ne.a.a;
        switch(taskGetPlayablesFromServiceScheme$getNewSong$10.label) {
            case 0: {
                d5.n.D(object0);
                Y.w("getNewSong() - areaFlag: ", s, LogU.Companion, "TaskGetPlayablesFromServiceScheme");
                try {
                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                    Params smartVoiceNewSongListReq$Params0 = new Params();
                    if(!"I".equals(s)) {
                        s1 = "O";
                    }
                    smartVoiceNewSongListReq$Params0.areaFlg = s1;
                    smartVoiceNewSongListReq$Params0.startIndex = 1;
                    smartVoiceNewSongListReq$Params0.pageSize = 100;
                    MelonAppBase.Companion.getClass();
                    com.iloen.melon.playback.playlist.add.TaskGetPlayablesFromServiceScheme.getNewSong.res.1 taskGetPlayablesFromServiceScheme$getNewSong$res$10 = new n(requestFuture0, null) {
                        final RequestFuture $future;
                        final SmartVoiceNewSongListReq $request;
                        int label;

                        {
                            this.$request = smartVoiceNewSongListReq0;
                            this.$future = requestFuture0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.add.TaskGetPlayablesFromServiceScheme.getNewSong.res.1(this.$request, this.$future, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.add.TaskGetPlayablesFromServiceScheme.getNewSong.res.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            d5.n.D(object0);
                            return RequestBuilder.newInstance(this.$request).tag("TaskGetPlayablesFromServiceScheme").listener(this.$future).errorListener(this.$future).requestSync(this.$future);
                        }
                    };
                    taskGetPlayablesFromServiceScheme$getNewSong$10.L$0 = null;
                    taskGetPlayablesFromServiceScheme$getNewSong$10.L$1 = null;
                    taskGetPlayablesFromServiceScheme$getNewSong$10.L$2 = null;
                    taskGetPlayablesFromServiceScheme$getNewSong$10.L$3 = null;
                    taskGetPlayablesFromServiceScheme$getNewSong$10.label = 1;
                    object0 = BuildersKt.withContext(Dispatchers.getIO(), taskGetPlayablesFromServiceScheme$getNewSong$res$10, taskGetPlayablesFromServiceScheme$getNewSong$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_38;
                }
                catch(VolleyError volleyError0) {
                    break;
                }
            }
            case 1: {
                SmartVoiceNewSongListReq smartVoiceNewSongListReq0 = (SmartVoiceNewSongListReq)taskGetPlayablesFromServiceScheme$getNewSong$10.L$3;
                Params smartVoiceNewSongListReq$Params1 = (Params)taskGetPlayablesFromServiceScheme$getNewSong$10.L$2;
                RequestFuture requestFuture1 = (RequestFuture)taskGetPlayablesFromServiceScheme$getNewSong$10.L$1;
                String s2 = (String)taskGetPlayablesFromServiceScheme$getNewSong$10.L$0;
                try {
                    d5.n.D(object0);
                label_38:
                    if(!(((HttpResponse)object0) instanceof NewSongListRes) || !((NewSongListRes)(((HttpResponse)object0))).isSuccessful()) {
                        throw new AddNormalException("No matched service scheme");
                    }
                    if(((NewSongListRes)(((HttpResponse)object0))).response != null) {
                        ArrayList arrayList0 = ((NewSongListRes)(((HttpResponse)object0))).response.songList;
                        if(arrayList0 != null && !arrayList0.isEmpty()) {
                            return this.getPlayables(arrayList0, this.mMenuId, null);
                        }
                    }
                    return w.a;
                }
                catch(VolleyError volleyError0) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.Companion.e("TaskGetPlayablesFromServiceScheme", "playNewSong() " + volleyError0, volleyError0);
        throw new AddNormalException("No matched service scheme");
    }

    private final List getPlayables(List list0, String s, StatsElementsBase statsElementsBase0) {
        if(list0 != null && !list0.isEmpty()) {
            List list1 = Playable.getListFromSongBaseArrayOnlyCanService(list0, s, statsElementsBase0);
            q.d(list1);
            return list1;
        }
        LogU.Companion.w("TaskGetPlayablesFromServiceScheme", "No item to play");
        throw new AddNormalException("No item to play");
    }

    private final Object getTop100(Continuation continuation0) {
        com.iloen.melon.playback.playlist.add.TaskGetPlayablesFromServiceScheme.getTop100.1 taskGetPlayablesFromServiceScheme$getTop100$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.add.TaskGetPlayablesFromServiceScheme.getTop100.1) {
            taskGetPlayablesFromServiceScheme$getTop100$10 = (com.iloen.melon.playback.playlist.add.TaskGetPlayablesFromServiceScheme.getTop100.1)continuation0;
            int v = taskGetPlayablesFromServiceScheme$getTop100$10.label;
            if((v & 0x80000000) == 0) {
                taskGetPlayablesFromServiceScheme$getTop100$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getTop100(this);
                    }
                };
            }
            else {
                taskGetPlayablesFromServiceScheme$getTop100$10.label = v ^ 0x80000000;
            }
        }
        else {
            taskGetPlayablesFromServiceScheme$getTop100$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getTop100(this);
                }
            };
        }
        Object object0 = taskGetPlayablesFromServiceScheme$getTop100$10.result;
        ne.a a0 = ne.a.a;
        switch(taskGetPlayablesFromServiceScheme$getTop100$10.label) {
            case 0: {
                d5.n.D(object0);
                LogU.Companion.d("TaskGetPlayablesFromServiceScheme", "getTop100()");
                try {
                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                    MelonAppBase.Companion.getClass();
                    com.iloen.melon.playback.playlist.add.TaskGetPlayablesFromServiceScheme.getTop100.res.1 taskGetPlayablesFromServiceScheme$getTop100$res$10 = new n(requestFuture0, null) {
                        final RequestFuture $future;
                        final ChartHitsSmartVoiceSongChartListReq $request;
                        int label;

                        {
                            this.$request = chartHitsSmartVoiceSongChartListReq0;
                            this.$future = requestFuture0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.add.TaskGetPlayablesFromServiceScheme.getTop100.res.1(this.$request, this.$future, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.add.TaskGetPlayablesFromServiceScheme.getTop100.res.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            d5.n.D(object0);
                            return RequestBuilder.newInstance(this.$request).tag("TaskGetPlayablesFromServiceScheme").listener(this.$future).errorListener(this.$future).requestSync(this.$future);
                        }
                    };
                    taskGetPlayablesFromServiceScheme$getTop100$10.L$0 = null;
                    taskGetPlayablesFromServiceScheme$getTop100$10.L$1 = null;
                    taskGetPlayablesFromServiceScheme$getTop100$10.label = 1;
                    object0 = BuildersKt.withContext(Dispatchers.getIO(), taskGetPlayablesFromServiceScheme$getTop100$res$10, taskGetPlayablesFromServiceScheme$getTop100$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_27;
                }
                catch(VolleyError volleyError0) {
                    break;
                }
            }
            case 1: {
                ChartHitsSmartVoiceSongChartListReq chartHitsSmartVoiceSongChartListReq0 = (ChartHitsSmartVoiceSongChartListReq)taskGetPlayablesFromServiceScheme$getTop100$10.L$1;
                RequestFuture requestFuture1 = (RequestFuture)taskGetPlayablesFromServiceScheme$getTop100$10.L$0;
                try {
                    d5.n.D(object0);
                label_27:
                    if(!(((HttpResponse)object0) instanceof HourlyChartListRes) || !((HourlyChartListRes)(((HttpResponse)object0))).isSuccessful()) {
                        throw new AddNormalException("No matched service scheme");
                    }
                    if(((HourlyChartListRes)(((HttpResponse)object0))).response != null) {
                        ArrayList arrayList0 = ((HourlyChartListRes)(((HttpResponse)object0))).response.chartList;
                        if(arrayList0 != null && !arrayList0.isEmpty()) {
                            return this.getPlayables(arrayList0, this.mMenuId, null);
                        }
                    }
                    return w.a;
                }
                catch(VolleyError volleyError0) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.Companion.e("TaskGetPlayablesFromServiceScheme", "playRealtimeChart() " + volleyError0, volleyError0);
        throw new AddNormalException("No matched service scheme");
    }
}

