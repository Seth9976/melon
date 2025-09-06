package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0014\u0018\u0000 F2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003GFHB\t\b\u0016\u00A2\u0006\u0004\b\u0003\u0010\u0004B\u0017\b\u0016\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00020\u0005\u00A2\u0006\u0004\b\u0003\u0010\u0007B\u001D\b\u0016\u0012\u0012\u0010\u0006\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00020\b\"\u00020\u0002\u00A2\u0006\u0004\b\u0003\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0000\u00A2\u0006\u0004\b\u0003\u0010\nJ\u0015\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000B\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0015\u0010\u0010\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000B\u00A2\u0006\u0004\b\u0010\u0010\u000FJ\u0017\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0011\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0004J\u0018\u0010\u0019\u001A\u00020\u00022\u0006\u0010\u0016\u001A\u00020\u0015H\u0096\u0002\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001B\u001A\u00020\u00022\u0006\u0010\u0016\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001AJ \u0010\u001C\u001A\u00020\u00022\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0011\u001A\u00020\u0002H\u0096\u0002\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0013\u0010 \u001A\b\u0012\u0004\u0012\u00020\u001F0\u001E\u00A2\u0006\u0004\b \u0010!J\r\u0010#\u001A\u00020\"\u00A2\u0006\u0004\b#\u0010$J\u0015\u0010%\u001A\b\u0012\u0004\u0012\u00020\u001F0\u001EH\u0002\u00A2\u0006\u0004\b%\u0010!J\u000F\u0010&\u001A\u00020\"H\u0002\u00A2\u0006\u0004\b&\u0010$R$\u0010(\u001A\u0004\u0018\u00010\'8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b(\u0010)\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u0010.\u001A\u00020\u00158\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0017\u00101\u001A\u0002008\u0006\u00A2\u0006\f\n\u0004\b1\u00102\u001A\u0004\b3\u00104R0\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u0002052\f\u00106\u001A\b\u0012\u0004\u0012\u00020\u0002058\u0006@BX\u0086\u000E\u00A2\u0006\f\n\u0004\b\u0006\u00107\u001A\u0004\b8\u0010!R0\u00109\u001A\b\u0012\u0004\u0012\u00020\u000B052\f\u00106\u001A\b\u0012\u0004\u0012\u00020\u000B058\u0006@BX\u0086\u000E\u00A2\u0006\f\n\u0004\b9\u00107\u001A\u0004\b:\u0010!R$\u0010;\u001A\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b;\u00102\u001A\u0004\b<\u00104\"\u0004\b=\u0010>R$\u0010C\u001A\u00020\u00152\u0006\u0010.\u001A\u00020\u00158F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0014\u0010E\u001A\u00020\u00158VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bD\u0010@\u00A8\u0006I"}, d2 = {"Lcom/facebook/GraphRequestBatch;", "Ljava/util/AbstractList;", "Lcom/facebook/GraphRequest;", "<init>", "()V", "", "requests", "(Ljava/util/Collection;)V", "", "([Lcom/facebook/GraphRequest;)V", "(Lcom/facebook/GraphRequestBatch;)V", "Lcom/facebook/GraphRequestBatch$Callback;", "callback", "Lie/H;", "addCallback", "(Lcom/facebook/GraphRequestBatch$Callback;)V", "removeCallback", "element", "", "add", "(Lcom/facebook/GraphRequest;)Z", "", "index", "(ILcom/facebook/GraphRequest;)V", "clear", "get", "(I)Lcom/facebook/GraphRequest;", "removeAt", "set", "(ILcom/facebook/GraphRequest;)Lcom/facebook/GraphRequest;", "", "Lcom/facebook/GraphResponse;", "executeAndWait", "()Ljava/util/List;", "Lcom/facebook/GraphRequestAsyncTask;", "executeAsync", "()Lcom/facebook/GraphRequestAsyncTask;", "executeAndWaitImpl", "executeAsyncImpl", "Landroid/os/Handler;", "callbackHandler", "Landroid/os/Handler;", "getCallbackHandler", "()Landroid/os/Handler;", "setCallbackHandler", "(Landroid/os/Handler;)V", "timeoutInMilliseconds", "I", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "", "<set-?>", "Ljava/util/List;", "getRequests", "callbacks", "getCallbacks", "batchApplicationId", "getBatchApplicationId", "setBatchApplicationId", "(Ljava/lang/String;)V", "getTimeout", "()I", "setTimeout", "(I)V", "timeout", "getSize", "size", "Companion", "Callback", "OnProgressCallback", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class GraphRequestBatch extends AbstractList {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/GraphRequestBatch$Callback;", "", "Lcom/facebook/GraphRequestBatch;", "batch", "Lie/H;", "onBatchCompleted", "(Lcom/facebook/GraphRequestBatch;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Callback {
        void onBatchCompleted(@NotNull GraphRequestBatch arg1);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/GraphRequestBatch$Companion;", "", "()V", "idGenerator", "Ljava/util/concurrent/atomic/AtomicInteger;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\'\u0010\b\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/facebook/GraphRequestBatch$OnProgressCallback;", "Lcom/facebook/GraphRequestBatch$Callback;", "Lcom/facebook/GraphRequestBatch;", "batch", "", "current", "max", "Lie/H;", "onBatchProgress", "(Lcom/facebook/GraphRequestBatch;JJ)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface OnProgressCallback extends Callback {
        void onBatchProgress(@NotNull GraphRequestBatch arg1, long arg2, long arg3);
    }

    @NotNull
    public static final Companion Companion;
    @Nullable
    private String batchApplicationId;
    @Nullable
    private Handler callbackHandler;
    @NotNull
    private List callbacks;
    @NotNull
    private final String id;
    @NotNull
    private static final AtomicInteger idGenerator;
    @NotNull
    private List requests;
    private int timeoutInMilliseconds;

    static {
        GraphRequestBatch.Companion = new Companion(null);
        GraphRequestBatch.idGenerator = new AtomicInteger();
    }

    public GraphRequestBatch() {
        this.id = "1";
        this.callbacks = new ArrayList();
        this.requests = new ArrayList();
    }

    public GraphRequestBatch(@NotNull GraphRequestBatch graphRequestBatch0) {
        q.g(graphRequestBatch0, "requests");
        super();
        this.id = "1";
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(graphRequestBatch0);
        this.callbackHandler = graphRequestBatch0.callbackHandler;
        this.timeoutInMilliseconds = graphRequestBatch0.timeoutInMilliseconds;
        this.callbacks = new ArrayList(graphRequestBatch0.callbacks);
    }

    public GraphRequestBatch(@NotNull Collection collection0) {
        q.g(collection0, "requests");
        super();
        this.id = "1";
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(collection0);
    }

    public GraphRequestBatch(@NotNull GraphRequest[] arr_graphRequest) {
        q.g(arr_graphRequest, "requests");
        super();
        this.id = "1";
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(n.N(arr_graphRequest));
    }

    public void add(int v, @NotNull GraphRequest graphRequest0) {
        q.g(graphRequest0, "element");
        this.requests.add(v, graphRequest0);
    }

    @Override
    public void add(int v, Object object0) {
        this.add(v, ((GraphRequest)object0));
    }

    public boolean add(@NotNull GraphRequest graphRequest0) {
        q.g(graphRequest0, "element");
        return this.requests.add(graphRequest0);
    }

    @Override
    public boolean add(Object object0) {
        return this.add(((GraphRequest)object0));
    }

    public final void addCallback(@NotNull Callback graphRequestBatch$Callback0) {
        q.g(graphRequestBatch$Callback0, "callback");
        if(!this.callbacks.contains(graphRequestBatch$Callback0)) {
            this.callbacks.add(graphRequestBatch$Callback0);
        }
    }

    @Override
    public void clear() {
        this.requests.clear();
    }

    public boolean contains(GraphRequest graphRequest0) {
        return super.contains(graphRequest0);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean contains(Object object0) {
        return (object0 == null ? true : object0 instanceof GraphRequest) ? this.contains(((GraphRequest)object0)) : false;
    }

    @NotNull
    public final List executeAndWait() {
        return this.executeAndWaitImpl();
    }

    private final List executeAndWaitImpl() {
        return GraphRequest.Companion.executeBatchAndWait(this);
    }

    @NotNull
    public final GraphRequestAsyncTask executeAsync() {
        return this.executeAsyncImpl();
    }

    private final GraphRequestAsyncTask executeAsyncImpl() {
        return GraphRequest.Companion.executeBatchAsync(this);
    }

    @NotNull
    public GraphRequest get(int v) {
        return (GraphRequest)this.requests.get(v);
    }

    @Override
    public Object get(int v) {
        return this.get(v);
    }

    @Nullable
    public final String getBatchApplicationId() {
        return this.batchApplicationId;
    }

    @Nullable
    public final Handler getCallbackHandler() {
        return this.callbackHandler;
    }

    @NotNull
    public final List getCallbacks() {
        return this.callbacks;
    }

    @NotNull
    public final String getId() [...] // 潜在的解密器

    @NotNull
    public final List getRequests() {
        return this.requests;
    }

    public int getSize() {
        return this.requests.size();
    }

    public final int getTimeout() {
        return this.timeoutInMilliseconds;
    }

    public int indexOf(GraphRequest graphRequest0) {
        return super.indexOf(graphRequest0);
    }

    // 去混淆评级： 低(20)
    @Override
    public final int indexOf(Object object0) {
        return (object0 == null ? true : object0 instanceof GraphRequest) ? this.indexOf(((GraphRequest)object0)) : -1;
    }

    public int lastIndexOf(GraphRequest graphRequest0) {
        return super.lastIndexOf(graphRequest0);
    }

    // 去混淆评级： 低(20)
    @Override
    public final int lastIndexOf(Object object0) {
        return (object0 == null ? true : object0 instanceof GraphRequest) ? this.lastIndexOf(((GraphRequest)object0)) : -1;
    }

    public final GraphRequest remove(int v) {
        return this.removeAt(v);
    }

    @Override
    public Object remove(int v) {
        return this.remove(v);
    }

    public boolean remove(GraphRequest graphRequest0) {
        return super.remove(graphRequest0);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean remove(Object object0) {
        return (object0 == null ? true : object0 instanceof GraphRequest) ? this.remove(((GraphRequest)object0)) : false;
    }

    @NotNull
    public GraphRequest removeAt(int v) {
        return (GraphRequest)this.requests.remove(v);
    }

    public final void removeCallback(@NotNull Callback graphRequestBatch$Callback0) {
        q.g(graphRequestBatch$Callback0, "callback");
        this.callbacks.remove(graphRequestBatch$Callback0);
    }

    @NotNull
    public GraphRequest set(int v, @NotNull GraphRequest graphRequest0) {
        q.g(graphRequest0, "element");
        return (GraphRequest)this.requests.set(v, graphRequest0);
    }

    @Override
    public Object set(int v, Object object0) {
        return this.set(v, ((GraphRequest)object0));
    }

    public final void setBatchApplicationId(@Nullable String s) {
        this.batchApplicationId = s;
    }

    public final void setCallbackHandler(@Nullable Handler handler0) {
        this.callbackHandler = handler0;
    }

    public final void setTimeout(int v) {
        if(v < 0) {
            throw new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.");
        }
        this.timeoutInMilliseconds = v;
    }

    @Override
    public final int size() {
        return this.getSize();
    }
}

