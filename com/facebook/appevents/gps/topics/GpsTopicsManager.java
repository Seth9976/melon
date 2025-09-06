package com.facebook.appevents.gps.topics;

import android.adservices.topics.GetTopicsRequest.Builder;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.OutcomeReceiver;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import d3.g;
import ie.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u001B\u0010\t\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001D\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000F\u001A\u00020\u000EH\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u000B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001B\u0010\u001C\u001A\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001E\u001A\u00020\u001D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2 = {"Lcom/facebook/appevents/gps/topics/GpsTopicsManager;", "", "<init>", "()V", "Lie/H;", "enableTopicsObservation", "Ljava/util/concurrent/CompletableFuture;", "", "Lcom/facebook/appevents/gps/topics/TopicData;", "getTopics", "()Ljava/util/concurrent/CompletableFuture;", "", "shouldObserveTopics", "()Z", "Landroid/adservices/topics/GetTopicsResponse;", "response", "processObservedTopics", "(Landroid/adservices/topics/GetTopicsResponse;)Ljava/util/List;", "RECORD_OBSERVATION", "Z", "", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/Executor;", "executor$delegate", "Lie/j;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isTopicsObservationEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class GpsTopicsManager {
    @NotNull
    public static final GpsTopicsManager INSTANCE = null;
    private static final boolean RECORD_OBSERVATION = true;
    @NotNull
    private static final String TAG;
    @NotNull
    private static final j executor$delegate;
    @NotNull
    private static final AtomicBoolean isTopicsObservationEnabled;

    static {
        GpsTopicsManager.INSTANCE = new GpsTopicsManager();
        String s = GpsTopicsManager.class.toString();
        q.f(s, "GpsTopicsManager::class.java.toString()");
        GpsTopicsManager.TAG = s;
        GpsTopicsManager.executor$delegate = g.Q(GpsTopicsManager.executor.2.INSTANCE);
        GpsTopicsManager.isTopicsObservationEnabled = new AtomicBoolean(false);
    }

    // 去混淆评级： 低(20)
    public static final String access$getTAG$p() {
        return CrashShieldHandler.isObjectCrashing(GpsTopicsManager.class) ? null : GpsTopicsManager.TAG;
    }

    public static final List access$processObservedTopics(GpsTopicsManager gpsTopicsManager0, GetTopicsResponse getTopicsResponse0) {
        Class class0 = GpsTopicsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return gpsTopicsManager0.processObservedTopics(getTopicsResponse0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public static final void enableTopicsObservation() {
        Class class0 = GpsTopicsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            GpsTopicsManager.isTopicsObservationEnabled.set(true);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private final Executor getExecutor() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Object object0 = GpsTopicsManager.executor$delegate.getValue();
            q.f(object0, "<get-executor>(...)");
            return (Executor)object0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @TargetApi(34)
    @NotNull
    public static final CompletableFuture getTopics() {
        CompletableFuture completableFuture1;
        Class class0 = GpsTopicsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            if(!GpsTopicsManager.shouldObserveTopics()) {
                CompletableFuture completableFuture0 = CompletableFuture.completedFuture(w.a);
                q.f(completableFuture0, "completedFuture(emptyList())");
                return completableFuture0;
            }
            completableFuture1 = new CompletableFuture();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
        try {
            Context context0 = FacebookSdk.getApplicationContext();
            com.facebook.appevents.gps.topics.GpsTopicsManager.getTopics.callback.1 gpsTopicsManager$getTopics$callback$10 = new OutcomeReceiver() {
                public void onError(@NotNull Exception exception0) {
                    q.g(exception0, "error");
                    Log.w(GpsTopicsManager.access$getTAG$p(), "GPS_TOPICS_OBSERVATION_FAILURE", exception0);
                    completableFuture1.completeExceptionally(exception0);
                }

                @Override  // android.os.OutcomeReceiver
                public void onError(Throwable throwable0) {
                    this.onError(((Exception)throwable0));
                }

                public void onResult(@NotNull GetTopicsResponse getTopicsResponse0) {
                    q.g(getTopicsResponse0, "response");
                    try {
                        List list0 = GpsTopicsManager.access$processObservedTopics(GpsTopicsManager.INSTANCE, getTopicsResponse0);
                        completableFuture1.complete(list0);
                    }
                    catch(Throwable throwable0) {
                        Log.w(GpsTopicsManager.access$getTAG$p(), "GPS_TOPICS_PROCESSING_FAILURE", throwable0);
                        completableFuture1.completeExceptionally(throwable0);
                    }
                }

                @Override  // android.os.OutcomeReceiver
                public void onResult(Object object0) {
                    this.onResult(((GetTopicsResponse)object0));
                }
            };
            Builder getTopicsRequest$Builder0 = new Builder();
            getTopicsRequest$Builder0.setShouldRecordObservation(true);
            getTopicsRequest$Builder0.setAdsSdkName("com.iloen.melon");
            TopicsManager topicsManager0 = (TopicsManager)context0.getSystemService(TopicsManager.class);
            if(topicsManager0 != null) {
                topicsManager0.getTopics(getTopicsRequest$Builder0.build(), GpsTopicsManager.INSTANCE.getExecutor(), gpsTopicsManager$getTopics$callback$10);
                return completableFuture1;
            }
            return completableFuture1;
        }
        catch(Throwable throwable1) {
            try {
                Log.w(GpsTopicsManager.TAG, "GPS_TOPICS_OBSERVATION_FAILURE", throwable1);
                completableFuture1.completeExceptionally(throwable1);
                return completableFuture1;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    @TargetApi(34)
    private final List processObservedTopics(GetTopicsResponse getTopicsResponse0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            List list0 = getTopicsResponse0.getTopics();
            q.f(list0, "response.topics");
            List list1 = new ArrayList(je.q.Q(10, list0));
            for(Object object0: list0) {
                list1.add(new TopicData(((Topic)object0).getTaxonomyVersion(), ((Topic)object0).getModelVersion(), ((Topic)object0).getTopicId()));
            }
            return list1;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    public static final boolean shouldObserveTopics() {
        Class class0 = GpsTopicsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            return !GpsTopicsManager.isTopicsObservationEnabled.get() ? false : true;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }
}

