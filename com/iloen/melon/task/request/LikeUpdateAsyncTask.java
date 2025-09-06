package com.iloen.melon.task.request;

import android.text.TextUtils;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.MelonError;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.MyMusicLikeInsertLikeReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicLikeInsertLikeReq;
import com.iloen.melon.net.v4x.response.MyMusicLikeInsertLikeRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MyMusicLikeInsertLikeRes;
import com.iloen.melon.net.v5x.request.MyMusicLikeDeleteLikeReq;
import com.iloen.melon.net.v5x.response.MyMusicLikeDeleteLikeRes;
import com.iloen.melon.utils.log.LogU;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x8.f;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 +2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002+,B9\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0011\u001A\u00020\u00032\b\u0010\u0010\u001A\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001A\u00020\r2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001A\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001A\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u0017\u001A\u0004\b\u001B\u0010\u0019R\u0017\u0010\u0006\u001A\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u0017\u001A\u0004\b\u001D\u0010\u0019R\u0017\u0010\b\u001A\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b\b\u0010 R\u0019\u0010\t\u001A\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b!\u0010\u0017\u001A\u0004\b\"\u0010\u0019R$\u0010*\u001A\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b$\u0010%\u001A\u0004\b&\u0010\'\"\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/iloen/melon/task/request/LikeUpdateAsyncTask;", "Lx8/f;", "Ljava/lang/Void;", "", "actTypeCode", "contsId", "contsTypeCode", "", "isLike", "menuId", "notificationType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "Lie/H;", "preTask", "()V", "param", "backgroundWork", "(Ljava/lang/Void;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "result", "postTask", "(Ljava/lang/String;)V", "a", "Ljava/lang/String;", "getActTypeCode", "()Ljava/lang/String;", "b", "getContsId", "c", "getContsTypeCode", "d", "Z", "()Z", "e", "getMenuId", "Lcom/iloen/melon/task/request/LikeUpdateAsyncTask$OnJobFinishListener;", "g", "Lcom/iloen/melon/task/request/LikeUpdateAsyncTask$OnJobFinishListener;", "getOnJobFinishListener", "()Lcom/iloen/melon/task/request/LikeUpdateAsyncTask$OnJobFinishListener;", "setOnJobFinishListener", "(Lcom/iloen/melon/task/request/LikeUpdateAsyncTask$OnJobFinishListener;)V", "onJobFinishListener", "Companion", "OnJobFinishListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LikeUpdateAsyncTask extends f {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/task/request/LikeUpdateAsyncTask$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\'\u0010\u000B\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\tH&¢\u0006\u0004\b\u000B\u0010\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/task/request/LikeUpdateAsyncTask$OnJobFinishListener;", "", "Lie/H;", "onStartAsyncTask", "()V", "", "errorMsg", "", "sumCount", "", "isLike", "onJobComplete", "(Ljava/lang/String;IZ)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface OnJobFinishListener {
        void onJobComplete(@NotNull String arg1, int arg2, boolean arg3);

        void onStartAsyncTask();
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;
    public final String f;
    public OnJobFinishListener g;
    public int h;
    public boolean i;

    static {
        LikeUpdateAsyncTask.Companion = new Companion(null);
        LikeUpdateAsyncTask.$stable = 8;
    }

    public LikeUpdateAsyncTask(@NotNull String s, @NotNull String s1, @NotNull String s2, boolean z, @Nullable String s3, @NotNull String s4) {
        q.g(s, "actTypeCode");
        q.g(s1, "contsId");
        q.g(s2, "contsTypeCode");
        q.g(s4, "notificationType");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = z;
        this.e = s3;
        this.f = s4;
        this.i = true;
    }

    @Override  // x8.f
    public Object backgroundWork(Object object0, Continuation continuation0) {
        return this.backgroundWork(((Void)object0), continuation0);
    }

    @Nullable
    public Object backgroundWork(@Nullable Void void0, @NotNull Continuation continuation0) {
        String s6;
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        String s = this.a;
        Y.w("backgroundWork() actTypeCode : ", s, logU$Companion0, "LikeUpdateAsyncTask");
        String s1 = this.b;
        Y.w("backgroundWork() contsId : ", s1, logU$Companion0, "LikeUpdateAsyncTask");
        String s2 = this.c;
        Y.w("backgroundWork() contsTypeCode : ", s2, logU$Companion0, "LikeUpdateAsyncTask");
        l1.B("backgroundWork() isLike : ", this.d, logU$Companion0, "LikeUpdateAsyncTask");
        String s3 = this.e;
        Y.w("backgroundWork() menuId : ", s3, logU$Companion0, "LikeUpdateAsyncTask");
        String s4 = this.f;
        Y.w("backgroundWork() notificationType : ", s4, logU$Companion0, "LikeUpdateAsyncTask");
        if(this.d) {
            RequestFuture requestFuture0 = RequestFuture.newFuture();
            Params myMusicLikeInsertLikeReq$Params0 = new Params();
            myMusicLikeInsertLikeReq$Params0.contsTypeCode = s2;
            myMusicLikeInsertLikeReq$Params0.actTypeCode = s;
            myMusicLikeInsertLikeReq$Params0.contsId = s1;
            myMusicLikeInsertLikeReq$Params0.menuId = s3;
            if(!TextUtils.isEmpty(s4)) {
                myMusicLikeInsertLikeReq$Params0.notificationType = s4;
            }
            MyMusicLikeInsertLikeReq myMusicLikeInsertLikeReq0 = new MyMusicLikeInsertLikeReq(Y.a(MelonAppBase.Companion), myMusicLikeInsertLikeReq$Params0);
            try {
                HttpResponse httpResponse0 = RequestBuilder.newInstance(myMusicLikeInsertLikeReq0).tag("LikeUpdateAsyncTask").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.MyMusicLikeInsertLikeRes");
                if(((MyMusicLikeInsertLikeRes)httpResponse0).isSuccessful()) {
                    RESPONSE myMusicLikeInsertLikeRes$RESPONSE0 = ((MyMusicLikeInsertLikeRes)httpResponse0).response;
                    if(myMusicLikeInsertLikeRes$RESPONSE0 != null) {
                        this.i = false;
                        int v = ProtocolUtils.parseInt(myMusicLikeInsertLikeRes$RESPONSE0.summcnt, 0);
                        this.h = v;
                        logU$Companion0.d("LikeUpdateAsyncTask", "backgroundWork() insert sumCount : " + v);
                        return "";
                    }
                }
                String s5 = MelonError.from(((MyMusicLikeInsertLikeRes)httpResponse0)).getMessage();
                return s5 == null ? "" : s5;
            }
            catch(VolleyError volleyError0) {
                s6 = volleyError0.getMessage();
                return s6 == null ? "" : s6;
            }
        }
        RequestFuture requestFuture1 = RequestFuture.newFuture();
        com.iloen.melon.net.v5x.request.MyMusicLikeDeleteLikeReq.Params myMusicLikeDeleteLikeReq$Params0 = new com.iloen.melon.net.v5x.request.MyMusicLikeDeleteLikeReq.Params();
        myMusicLikeDeleteLikeReq$Params0.contsTypeCode = s2;
        myMusicLikeDeleteLikeReq$Params0.actTypeCode = s;
        myMusicLikeDeleteLikeReq$Params0.contsId = s1;
        myMusicLikeDeleteLikeReq$Params0.menuId = s3;
        MyMusicLikeDeleteLikeReq myMusicLikeDeleteLikeReq0 = new MyMusicLikeDeleteLikeReq(Y.a(MelonAppBase.Companion), myMusicLikeDeleteLikeReq$Params0);
        try {
            HttpResponse httpResponse1 = RequestBuilder.newInstance(myMusicLikeDeleteLikeReq0).tag("LikeUpdateAsyncTask").listener(requestFuture1).errorListener(requestFuture1).requestSync(requestFuture1);
            q.e(httpResponse1, "null cannot be cast to non-null type com.iloen.melon.net.v5x.response.MyMusicLikeDeleteLikeRes");
            if(((MyMusicLikeDeleteLikeRes)httpResponse1).isSuccessful()) {
                com.iloen.melon.net.v5x.response.MyMusicLikeDeleteLikeRes.RESPONSE myMusicLikeDeleteLikeRes$RESPONSE0 = ((MyMusicLikeDeleteLikeRes)httpResponse1).response;
                if(myMusicLikeDeleteLikeRes$RESPONSE0 != null) {
                    this.i = false;
                    int v1 = ProtocolUtils.parseInt(myMusicLikeDeleteLikeRes$RESPONSE0.summcnt, 0);
                    this.h = v1;
                    logU$Companion0.d("LikeUpdateAsyncTask", "backgroundWork() delete sumCount : " + v1);
                    return "";
                }
            }
            String s7 = MelonError.from(((MyMusicLikeDeleteLikeRes)httpResponse1)).getMessage();
            return s7 == null ? "" : s7;
        }
        catch(VolleyError volleyError1) {
            s6 = volleyError1.getMessage();
            return s6 == null ? "" : s6;
        }
    }

    @NotNull
    public final String getActTypeCode() {
        return this.a;
    }

    @NotNull
    public final String getContsId() {
        return this.b;
    }

    @NotNull
    public final String getContsTypeCode() {
        return this.c;
    }

    @Nullable
    public final String getMenuId() {
        return this.e;
    }

    @Nullable
    public final OnJobFinishListener getOnJobFinishListener() {
        return this.g;
    }

    public final boolean isLike() {
        return this.d;
    }

    @Override  // x8.f
    public void postTask(Object object0) {
        this.postTask(((String)object0));
    }

    public void postTask(@Nullable String s) {
        if(!this.i) {
            OnJobFinishListener likeUpdateAsyncTask$OnJobFinishListener0 = this.g;
            if(likeUpdateAsyncTask$OnJobFinishListener0 != null) {
                if(s == null) {
                    s = "";
                }
                likeUpdateAsyncTask$OnJobFinishListener0.onJobComplete(s, this.h, this.d);
            }
        }
    }

    @Override  // x8.f
    public void preTask() {
        OnJobFinishListener likeUpdateAsyncTask$OnJobFinishListener0 = this.g;
        if(likeUpdateAsyncTask$OnJobFinishListener0 != null) {
            likeUpdateAsyncTask$OnJobFinishListener0.onStartAsyncTask();
        }
    }

    public final void setOnJobFinishListener(@Nullable OnJobFinishListener likeUpdateAsyncTask$OnJobFinishListener0) {
        this.g = likeUpdateAsyncTask$OnJobFinishListener0;
    }
}

