package com.iloen.melon.task.request;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.ContentsInfoPostImgReq;
import com.iloen.melon.net.v4x.response.ContentsInfoPostImgRes.RESPONSE;
import com.iloen.melon.net.v4x.response.ContentsInfoPostImgRes;
import com.iloen.melon.utils.log.LogU;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x8.f;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 \u001B2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001B\u001CB\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001C\u0010\u0010\u001A\u0004\u0018\u00010\u00022\b\u0010\u000F\u001A\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001A\u00020\n2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001A\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001A\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001A\u0004\b\u001A\u0010\u0018¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/task/request/PostImageAsyncCoroutine;", "Lx8/f;", "Ljava/lang/Void;", "", "contentId", "contentTypeCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/iloen/melon/task/request/PostImageAsyncCoroutine$OnPostImageAsyncCoroutineListener;", "listener", "Lie/H;", "setOnPostImageAsyncTaskListener", "(Lcom/iloen/melon/task/request/PostImageAsyncCoroutine$OnPostImageAsyncCoroutineListener;)V", "preTask", "()V", "param", "backgroundWork", "(Ljava/lang/Void;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "result", "postTask", "(Ljava/lang/Void;)V", "a", "Ljava/lang/String;", "getContentId", "()Ljava/lang/String;", "b", "getContentTypeCode", "Companion", "OnPostImageAsyncCoroutineListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PostImageAsyncCoroutine extends f {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/task/request/PostImageAsyncCoroutine$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\b\u001A\u00020\u00022\b\u0010\u0006\u001A\u0004\u0018\u00010\u00052\b\u0010\u0007\u001A\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/task/request/PostImageAsyncCoroutine$OnPostImageAsyncCoroutineListener;", "", "Lie/H;", "onTaskStart", "()V", "", "postImg", "postEditImg", "onTaskFinish", "(Ljava/lang/String;Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface OnPostImageAsyncCoroutineListener {
        void onTaskFinish(@Nullable String arg1, @Nullable String arg2);

        void onTaskStart();
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final String a;
    public final String b;
    public OnPostImageAsyncCoroutineListener c;
    public String d;
    public String e;

    static {
        PostImageAsyncCoroutine.Companion = new Companion(null);
        PostImageAsyncCoroutine.$stable = 8;
    }

    public PostImageAsyncCoroutine(@NotNull String s, @NotNull String s1) {
        q.g(s, "contentId");
        q.g(s1, "contentTypeCode");
        super();
        this.a = s;
        this.b = s1;
    }

    @Override  // x8.f
    public Object backgroundWork(Object object0, Continuation continuation0) {
        return this.backgroundWork(((Void)object0), continuation0);
    }

    @Nullable
    public Object backgroundWork(@Nullable Void void0, @NotNull Continuation continuation0) {
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        ContentsInfoPostImgReq contentsInfoPostImgReq0 = new ContentsInfoPostImgReq(Y.a(MelonAppBase.Companion), this.a, this.b);
        try {
            HttpResponse httpResponse0 = RequestBuilder.newInstance(contentsInfoPostImgReq0).tag("PostImgAsyncTask").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
            q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.ContentsInfoPostImgRes");
            if(((ContentsInfoPostImgRes)httpResponse0).isSuccessful()) {
                RESPONSE contentsInfoPostImgRes$RESPONSE0 = ((ContentsInfoPostImgRes)httpResponse0).response;
                if(contentsInfoPostImgRes$RESPONSE0 != null) {
                    this.d = contentsInfoPostImgRes$RESPONSE0.postImg;
                    this.e = contentsInfoPostImgRes$RESPONSE0.postEditImg;
                    return null;
                }
            }
        }
        catch(VolleyError unused_ex) {
            LogU.Companion.e("PostImgAsyncTask", "doInBackground() error");
        }
        return null;
    }

    @NotNull
    public final String getContentId() {
        return this.a;
    }

    @NotNull
    public final String getContentTypeCode() {
        return this.b;
    }

    @Override  // x8.f
    public void postTask(Object object0) {
        this.postTask(((Void)object0));
    }

    public void postTask(@Nullable Void void0) {
        super.postTask(void0);
        OnPostImageAsyncCoroutineListener postImageAsyncCoroutine$OnPostImageAsyncCoroutineListener0 = this.c;
        if(postImageAsyncCoroutine$OnPostImageAsyncCoroutineListener0 != null) {
            postImageAsyncCoroutine$OnPostImageAsyncCoroutineListener0.onTaskFinish(this.d, this.e);
        }
    }

    @Override  // x8.f
    public void preTask() {
        super.preTask();
        OnPostImageAsyncCoroutineListener postImageAsyncCoroutine$OnPostImageAsyncCoroutineListener0 = this.c;
        if(postImageAsyncCoroutine$OnPostImageAsyncCoroutineListener0 != null) {
            postImageAsyncCoroutine$OnPostImageAsyncCoroutineListener0.onTaskStart();
        }
    }

    public final void setOnPostImageAsyncTaskListener(@NotNull OnPostImageAsyncCoroutineListener postImageAsyncCoroutine$OnPostImageAsyncCoroutineListener0) {
        q.g(postImageAsyncCoroutine$OnPostImageAsyncCoroutineListener0, "listener");
        this.c = postImageAsyncCoroutine$OnPostImageAsyncCoroutineListener0;
    }
}

