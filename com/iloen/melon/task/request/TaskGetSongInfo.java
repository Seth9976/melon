package com.iloen.melon.task.request;

import android.content.Context;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.CType;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.ContentsInfoListReq;
import com.iloen.melon.net.v4x.response.ContentsInfoListRes.Response;
import com.iloen.melon.net.v4x.response.ContentsInfoListRes;
import com.iloen.melon.net.v6x.request.SongInfoReq;
import com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE;
import com.iloen.melon.net.v6x.response.SongInfoRes;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.common.SongInfoBase;
import e.k;
import ie.H;
import ie.o;
import ie.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.n;
import je.w;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u001B2\u00020\u0001:\u0002\u001B\u001CB\u001F\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB!\b\u0016\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\t\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\nB\u001B\b\u0016\u0012\u0006\u0010\u000B\u001A\u00020\u0003\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\fJ\r\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FJ\u0016\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00100\u0002H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001A\u00020\r2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00100\u0002¢\u0006\u0004\b\u0019\u0010\u001A¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/task/request/TaskGetSongInfo;", "", "", "", "songIds", "Lcom/iloen/melon/constants/CType;", "cType", "<init>", "(Ljava/util/List;Lcom/iloen/melon/constants/CType;)V", "", "([Ljava/lang/String;Lcom/iloen/melon/constants/CType;)V", "songId", "(Ljava/lang/String;Lcom/iloen/melon/constants/CType;)V", "Lie/H;", "executeAsync", "()V", "Lcom/melon/net/res/common/SongInfoBase;", "execute", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/task/request/TaskGetSongInfo$ResultListener;", "listener", "setResultListener", "(Lcom/iloen/melon/task/request/TaskGetSongInfo$ResultListener;)V", "getSongInfo", "()Lcom/melon/net/res/common/SongInfoBase;", "getSongInfoList", "()Ljava/util/List;", "Companion", "ResultListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TaskGetSongInfo {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/task/request/TaskGetSongInfo$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001B\u0010\u0007\u001A\u00020\u00022\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/task/request/TaskGetSongInfo$ResultListener;", "", "Lie/H;", "onStartTask", "()V", "", "error", "onFinishTask", "(Ljava/lang/Throwable;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface ResultListener {
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public static final class DefaultImpls {
            public static void onFinishTask$default(ResultListener taskGetSongInfo$ResultListener0, Throwable throwable0, int v, Object object0) {
                ResultListener.onFinishTask$default(taskGetSongInfo$ResultListener0, throwable0, v, object0);
            }
        }

        void onFinishTask(@Nullable Throwable arg1);

        static void onFinishTask$default(ResultListener taskGetSongInfo$ResultListener0, Throwable throwable0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFinishTask");
            }
            if((v & 1) != 0) {
                throwable0 = null;
            }
            taskGetSongInfo$ResultListener0.onFinishTask(throwable0);
        }

        void onStartTask();
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final LogU a;
    public final MainCoroutineDispatcher b;
    public final CoroutineDispatcher c;
    public final List d;
    public final CType e;
    public ResultListener f;
    public List g;

    static {
        TaskGetSongInfo.Companion = new Companion(null);
        TaskGetSongInfo.$stable = 8;
    }

    public TaskGetSongInfo(@NotNull String s, @Nullable CType cType0) {
        q.g(s, "songId");
        this(k.z(s), cType0);
    }

    public TaskGetSongInfo(@NotNull List list0, @Nullable CType cType0) {
        q.g(list0, "songIds");
        super();
        this.a = new LogU("TaskGetSongInfo");
        this.b = Dispatchers.getMain();
        this.c = Dispatchers.getIO();
        this.d = list0;
        this.e = cType0;
        this.g = w.a;
    }

    public TaskGetSongInfo(@NotNull String[] arr_s, @Nullable CType cType0) {
        q.g(arr_s, "songIds");
        this(n.N(arr_s), cType0);
    }

    public final Object a(List list0, Continuation continuation0) {
        Iterator iterator0;
        int v1;
        TaskGetSongInfo.updateLocalContentDB.1 taskGetSongInfo$updateLocalContentDB$10;
        if(continuation0 instanceof TaskGetSongInfo.updateLocalContentDB.1) {
            taskGetSongInfo$updateLocalContentDB$10 = (TaskGetSongInfo.updateLocalContentDB.1)continuation0;
            int v = taskGetSongInfo$updateLocalContentDB$10.E;
            if((v & 0x80000000) == 0) {
                taskGetSongInfo$updateLocalContentDB$10 = new TaskGetSongInfo.updateLocalContentDB.1(this, continuation0);
            }
            else {
                taskGetSongInfo$updateLocalContentDB$10.E = v ^ 0x80000000;
            }
        }
        else {
            taskGetSongInfo$updateLocalContentDB$10 = new TaskGetSongInfo.updateLocalContentDB.1(this, continuation0);
        }
        Object object0 = taskGetSongInfo$updateLocalContentDB$10.B;
        a a0 = a.a;
        switch(taskGetSongInfo$updateLocalContentDB$10.E) {
            case 0: {
                d5.n.D(object0);
                v1 = 0;
                iterator0 = list0.iterator();
                break;
            }
            case 1: {
                v1 = taskGetSongInfo$updateLocalContentDB$10.w;
                iterator0 = taskGetSongInfo$updateLocalContentDB$10.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            String s = ((SongInfoBase)object1).songId;
            String s1 = ((SongInfoBase)object1).albumId;
            if(s1 == null) {
                s1 = "";
            }
            q.f("", "toString(...)");
            String s2 = ((SongInfoBase)object1).getArtistNames();
            String s3 = ((SongInfoBase)object1).albumName;
            TaskGetSongInfo.updateLocalContentDB.2.1 taskGetSongInfo$updateLocalContentDB$2$10 = new TaskGetSongInfo.updateLocalContentDB.2.1(s, s1, (s3 == null ? "" : s3), "", s2, null);
            taskGetSongInfo$updateLocalContentDB$10.r = iterator0;
            taskGetSongInfo$updateLocalContentDB$10.w = v1;
            taskGetSongInfo$updateLocalContentDB$10.E = 1;
            if(BuildersKt.withContext(this.c, taskGetSongInfo$updateLocalContentDB$2$10, taskGetSongInfo$updateLocalContentDB$10) == a0) {
                return a0;
            }
            if(false) {
                break;
            }
        }
        return H.a;
    }

    public static final Object access$updateLocalContentDB(TaskGetSongInfo taskGetSongInfo0, List list0, Continuation continuation0) {
        return taskGetSongInfo0.a(list0, continuation0);
    }

    @Nullable
    public final Object execute(@NotNull Continuation continuation0) {
        String s;
        com.iloen.melon.task.request.TaskGetSongInfo.execute.1 taskGetSongInfo$execute$10;
        if(continuation0 instanceof com.iloen.melon.task.request.TaskGetSongInfo.execute.1) {
            taskGetSongInfo$execute$10 = (com.iloen.melon.task.request.TaskGetSongInfo.execute.1)continuation0;
            int v = taskGetSongInfo$execute$10.E;
            if((v & 0x80000000) == 0) {
                taskGetSongInfo$execute$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public Object B;
                    public int E;
                    public List r;
                    public ArrayList w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.B = object0;
                        this.E |= 0x80000000;
                        return continuation0.execute(this);
                    }
                };
            }
            else {
                taskGetSongInfo$execute$10.E = v ^ 0x80000000;
            }
        }
        else {
            taskGetSongInfo$execute$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public Object B;
                public int E;
                public List r;
                public ArrayList w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.B = object0;
                    this.E |= 0x80000000;
                    return continuation0.execute(this);
                }
            };
        }
        Object object0 = taskGetSongInfo$execute$10.B;
        a a0 = a.a;
        switch(taskGetSongInfo$execute$10.E) {
            case 0: {
                d5.n.D(object0);
                List list1 = this.d;
                if(list1.isEmpty()) {
                    return w.a;
                }
                Context context0 = Y.a(MelonAppBase.Companion);
                CType cType0 = CType.SONG;
                CType cType1 = this.e;
                boolean z = q.b(cType1, cType0);
                CoroutineDispatcher coroutineDispatcher0 = this.c;
                if(!z || list1.size() != 1) {
                    if(cType1 == null) {
                        s = cType0.getValue();
                    }
                    else {
                        s = cType1.getValue();
                        if(s == null) {
                            s = cType0.getValue();
                        }
                    }
                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                    com.iloen.melon.task.request.TaskGetSongInfo.execute.fetchRes.2 taskGetSongInfo$execute$fetchRes$20 = new we.n(requestFuture0, null) {
                        public final RequestFuture B;
                        public Object r;
                        public final ContentsInfoListReq w;

                        {
                            this.w = contentsInfoListReq0;
                            this.B = requestFuture0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            Continuation continuation1 = new com.iloen.melon.task.request.TaskGetSongInfo.execute.fetchRes.2(this.w, this.B, continuation0);
                            continuation1.r = object0;
                            return continuation1;
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.task.request.TaskGetSongInfo.execute.fetchRes.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
                            d5.n.D(object0);
                            HttpResponse httpResponse0 = RequestBuilder.newInstance(this.w).tag(coroutineScope0.getClass().getSimpleName()).listener(this.B).errorListener(this.B).requestSync(this.B);
                            q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.ContentsInfoListRes");
                            return (ContentsInfoListRes)httpResponse0;
                        }
                    };
                    taskGetSongInfo$execute$10.E = 3;
                    object0 = BuildersKt.withContext(coroutineDispatcher0, taskGetSongInfo$execute$fetchRes$20, taskGetSongInfo$execute$10);
                    if(object0 != a0) {
                    label_60:
                        JobKt.ensureActive(taskGetSongInfo$execute$10.getContext());
                        Response contentsInfoListRes$Response0 = ((ContentsInfoListRes)object0).response;
                        ArrayList arrayList2 = contentsInfoListRes$Response0 == null ? null : contentsInfoListRes$Response0.contentsList;
                        if(!((ContentsInfoListRes)object0).isSuccessful() || arrayList2 == null || arrayList2.isEmpty()) {
                            throw new Exception("Failed to get songs info");
                        }
                        ArrayList arrayList3 = new ArrayList(arrayList2);
                        taskGetSongInfo$execute$10.r = null;
                        taskGetSongInfo$execute$10.w = arrayList3;
                        taskGetSongInfo$execute$10.E = 4;
                        if(this.a(arrayList3, taskGetSongInfo$execute$10) != a0) {
                            return arrayList3;
                        }
                    }
                }
                else {
                    com.iloen.melon.task.request.TaskGetSongInfo.execute.fetchRes.1 taskGetSongInfo$execute$fetchRes$10 = new we.n(((String)list1.get(0)), RequestFuture.newFuture(), null) {
                        public final String B;
                        public final RequestFuture D;
                        public Object r;
                        public final Context w;

                        {
                            this.w = context0;
                            this.B = s;
                            this.D = requestFuture0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            Continuation continuation1 = new com.iloen.melon.task.request.TaskGetSongInfo.execute.fetchRes.1(this.w, this.B, this.D, continuation0);
                            continuation1.r = object0;
                            return continuation1;
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.task.request.TaskGetSongInfo.execute.fetchRes.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
                            d5.n.D(object0);
                            HttpResponse httpResponse0 = RequestBuilder.newInstance(new SongInfoReq(this.w, this.B)).tag(coroutineScope0.getClass().getSimpleName()).listener(this.D).errorListener(this.D).requestSync(this.D);
                            q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.SongInfoRes");
                            return (SongInfoRes)httpResponse0;
                        }
                    };
                    taskGetSongInfo$execute$10.E = 1;
                    object0 = BuildersKt.withContext(coroutineDispatcher0, taskGetSongInfo$execute$fetchRes$10, taskGetSongInfo$execute$10);
                    if(object0 != a0) {
                    label_38:
                        JobKt.ensureActive(taskGetSongInfo$execute$10.getContext());
                        RESPONSE songInfoRes$RESPONSE0 = ((SongInfoRes)object0).response;
                        SongInfoBase songInfoBase0 = songInfoRes$RESPONSE0 == null ? null : songInfoRes$RESPONSE0.songInfo;
                        if(!((SongInfoRes)object0).isSuccessful() || songInfoBase0 == null) {
                            throw new Exception("Failed to get song info");
                        }
                        List list2 = k.z(songInfoBase0);
                        taskGetSongInfo$execute$10.r = list2;
                        taskGetSongInfo$execute$10.w = null;
                        taskGetSongInfo$execute$10.E = 2;
                        if(this.a(list2, taskGetSongInfo$execute$10) != a0) {
                            return list2;
                        }
                    }
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                goto label_38;
            }
            case 2: {
                List list0 = taskGetSongInfo$execute$10.r;
                d5.n.D(object0);
                return list0;
            }
            case 3: {
                d5.n.D(object0);
                goto label_60;
            }
            case 4: {
                ArrayList arrayList0 = taskGetSongInfo$execute$10.w;
                ArrayList arrayList1 = (ArrayList)taskGetSongInfo$execute$10.r;
                d5.n.D(object0);
                return arrayList0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public final void executeAsync() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.b), null, null, new we.n(null) {
            public int r;
            public final TaskGetSongInfo w;

            {
                this.w = taskGetSongInfo0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.task.request.TaskGetSongInfo.executeAsync.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.task.request.TaskGetSongInfo.executeAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                o o1;
                List list0;
                a a0 = a.a;
                TaskGetSongInfo taskGetSongInfo0 = this.w;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        try {
                            ResultListener taskGetSongInfo$ResultListener0 = taskGetSongInfo0.f;
                            if(taskGetSongInfo$ResultListener0 != null) {
                                taskGetSongInfo$ResultListener0.onStartTask();
                            }
                            this.r = 1;
                            object0 = taskGetSongInfo0.execute(this);
                            if(object0 == a0) {
                                return a0;
                            label_12:
                                d5.n.D(object0);
                            }
                            list0 = (List)object0;
                            goto label_17;
                        }
                        catch(Throwable throwable0) {
                        }
                        break;
                    }
                    case 1: {
                        goto label_12;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                list0 = d5.n.t(throwable0);
            label_17:
                H h0 = H.a;
                o o0 = null;
                if(!(list0 instanceof o)) {
                    taskGetSongInfo0.g = list0;
                    try {
                        ResultListener taskGetSongInfo$ResultListener1 = taskGetSongInfo0.f;
                        if(taskGetSongInfo$ResultListener1 == null) {
                            o1 = null;
                        }
                        else {
                            ResultListener.onFinishTask$default(taskGetSongInfo$ResultListener1, null, 1, null);
                            o1 = h0;
                        }
                    }
                    catch(Throwable throwable1) {
                        o1 = d5.n.t(throwable1);
                    }
                    Throwable throwable2 = p.a(o1);
                    if(throwable2 != null) {
                        LogU.error$default(taskGetSongInfo0.a, "execute() succeed but onFinishTask failed " + throwable2, null, false, 6, null);
                    }
                }
                Throwable throwable3 = p.a(list0);
                if(throwable3 != null) {
                    LogU.error$default(taskGetSongInfo0.a, "execute() failed " + throwable3, null, false, 6, null);
                    ResultListener taskGetSongInfo$ResultListener2 = taskGetSongInfo0.f;
                    if(taskGetSongInfo$ResultListener2 != null) {
                        try {
                            taskGetSongInfo$ResultListener2.onFinishTask(throwable3);
                            o0 = h0;
                        }
                        catch(Throwable throwable4) {
                            o0 = d5.n.t(throwable4);
                        }
                    }
                    Throwable throwable5 = p.a(o0);
                    if(throwable5 != null) {
                        LogU.error$default(taskGetSongInfo0.a, "execute() failed and onFinishTask failed " + throwable5, null, false, 6, null);
                    }
                }
                return h0;
            }
        }, 3, null);
    }

    @Nullable
    public final SongInfoBase getSongInfo() {
        return (SongInfoBase)je.p.m0(this.g);
    }

    @NotNull
    public final List getSongInfoList() {
        return this.g;
    }

    public final void setResultListener(@Nullable ResultListener taskGetSongInfo$ResultListener0) {
        this.f = taskGetSongInfo$ResultListener0;
    }
}

