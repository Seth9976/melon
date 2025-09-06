package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001E\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 *2\u001A\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001*B\u0019\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007\u00A2\u0006\u0004\b\t\u0010\nB\u001D\b\u0016\u0012\u0012\u0010\b\u001A\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000B\"\u00020\f\u00A2\u0006\u0004\b\t\u0010\rB\u0017\b\u0016\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\f0\u000E\u00A2\u0006\u0004\b\t\u0010\u000FB\u0011\b\u0016\u0012\u0006\u0010\b\u001A\u00020\u0007\u00A2\u0006\u0004\b\t\u0010\u0010B\'\b\u0016\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\u0012\u0010\b\u001A\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000B\"\u00020\f\u00A2\u0006\u0004\b\t\u0010\u0011B!\b\u0016\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\f0\u000E\u00A2\u0006\u0004\b\t\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0017\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001D\u0010\u001A\u001A\u00020\u00162\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJ+\u0010\u001D\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0012\u0010\u001C\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000B\"\u00020\u0002H\u0017\u00A2\u0006\u0004\b\u001D\u0010\u001ER\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0006\u0010\u001FR\u0017\u0010\b\u001A\u00020\u00078\u0006\u00A2\u0006\f\n\u0004\b\b\u0010 \u001A\u0004\b!\u0010\"R4\u0010&\u001A\n\u0018\u00010#j\u0004\u0018\u0001`$2\u000E\u0010%\u001A\n\u0018\u00010#j\u0004\u0018\u0001`$8\u0004@BX\u0084\u000E\u00A2\u0006\f\n\u0004\b&\u0010\'\u001A\u0004\b(\u0010)\u00A8\u0006+"}, d2 = {"Lcom/facebook/GraphRequestAsyncTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "Lcom/facebook/GraphResponse;", "Ljava/net/HttpURLConnection;", "connection", "Lcom/facebook/GraphRequestBatch;", "requests", "<init>", "(Ljava/net/HttpURLConnection;Lcom/facebook/GraphRequestBatch;)V", "", "Lcom/facebook/GraphRequest;", "([Lcom/facebook/GraphRequest;)V", "", "(Ljava/util/Collection;)V", "(Lcom/facebook/GraphRequestBatch;)V", "(Ljava/net/HttpURLConnection;[Lcom/facebook/GraphRequest;)V", "(Ljava/net/HttpURLConnection;Ljava/util/Collection;)V", "", "toString", "()Ljava/lang/String;", "Lie/H;", "onPreExecute", "()V", "result", "onPostExecute", "(Ljava/util/List;)V", "params", "doInBackground", "([Ljava/lang/Void;)Ljava/util/List;", "Ljava/net/HttpURLConnection;", "Lcom/facebook/GraphRequestBatch;", "getRequests", "()Lcom/facebook/GraphRequestBatch;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<set-?>", "exception", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class GraphRequestAsyncTask extends AsyncTask {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/GraphRequestAsyncTask$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion;
    private static final String TAG;
    @Nullable
    private final HttpURLConnection connection;
    @Nullable
    private Exception exception;
    @NotNull
    private final GraphRequestBatch requests;

    static {
        GraphRequestAsyncTask.Companion = new Companion(null);
        GraphRequestAsyncTask.TAG = GraphRequestAsyncTask.class.getCanonicalName();
    }

    public GraphRequestAsyncTask(@NotNull GraphRequestBatch graphRequestBatch0) {
        q.g(graphRequestBatch0, "requests");
        this(null, graphRequestBatch0);
    }

    public GraphRequestAsyncTask(@Nullable HttpURLConnection httpURLConnection0, @NotNull GraphRequestBatch graphRequestBatch0) {
        q.g(graphRequestBatch0, "requests");
        super();
        this.connection = httpURLConnection0;
        this.requests = graphRequestBatch0;
    }

    public GraphRequestAsyncTask(@Nullable HttpURLConnection httpURLConnection0, @NotNull Collection collection0) {
        q.g(collection0, "requests");
        this(httpURLConnection0, new GraphRequestBatch(collection0));
    }

    public GraphRequestAsyncTask(@Nullable HttpURLConnection httpURLConnection0, @NotNull GraphRequest[] arr_graphRequest) {
        q.g(arr_graphRequest, "requests");
        this(httpURLConnection0, new GraphRequestBatch(((GraphRequest[])Arrays.copyOf(arr_graphRequest, arr_graphRequest.length))));
    }

    public GraphRequestAsyncTask(@NotNull Collection collection0) {
        q.g(collection0, "requests");
        this(null, new GraphRequestBatch(collection0));
    }

    public GraphRequestAsyncTask(@NotNull GraphRequest[] arr_graphRequest) {
        q.g(arr_graphRequest, "requests");
        this(null, new GraphRequestBatch(((GraphRequest[])Arrays.copyOf(arr_graphRequest, arr_graphRequest.length))));
    }

    @Override  // android.os.AsyncTask
    public Object doInBackground(Object[] arr_object) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.doInBackground(((Void[])arr_object));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @Nullable
    public List doInBackground(@NotNull Void[] arr_void) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            q.g(arr_void, "params");
            try {
                return this.connection == null ? this.requests.executeAndWait() : GraphRequest.Companion.executeConnectionAndWait(this.connection, this.requests);
            }
            catch(Exception exception0) {
            }
            this.exception = exception0;
            return null;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    @Nullable
    public final Exception getException() {
        return this.exception;
    }

    @NotNull
    public final GraphRequestBatch getRequests() {
        return this.requests;
    }

    @Override  // android.os.AsyncTask
    public void onPostExecute(Object object0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.onPostExecute(((List)object0));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public void onPostExecute(@NotNull List list0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                q.g(list0, "result");
                super.onPostExecute(list0);
                Exception exception0 = this.exception;
                if(exception0 != null) {
                    String s = String.format("onPostExecute: exception encountered during request: %s", Arrays.copyOf(new Object[]{exception0.getMessage()}, 1));
                    Utility.logd(GraphRequestAsyncTask.TAG, s);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    @Override  // android.os.AsyncTask
    public void onPreExecute() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                super.onPreExecute();
                if(this.requests.getCallbackHandler() == null) {
                    Handler handler0 = Thread.currentThread() instanceof HandlerThread ? new Handler() : new Handler(Looper.getMainLooper());
                    this.requests.setCallbackHandler(handler0);
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    @Override
    @NotNull
    public String toString() {
        String s = "{RequestAsyncTask:  connection: " + this.connection + ", requests: " + this.requests + "}";
        q.f(s, "StringBuilder()\n        …(\"}\")\n        .toString()");
        return s;
    }
}

