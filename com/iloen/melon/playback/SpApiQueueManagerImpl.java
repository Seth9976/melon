package com.iloen.melon.playback;

import A8.b;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import ie.H;
import java.util.concurrent.CancellationException;
import je.m;
import je.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;
import we.n;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B+\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0007\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0013\u0010\r\u001A\u00020\u0005*\u00020\fH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ+\u0010\u0013\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\f2\b\b\u0002\u0010\u0011\u001A\u00020\u00102\b\b\u0002\u0010\u0012\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u0017H\u0002\u00A2\u0006\u0004\b\u0016\u0010\u0019J\u0019\u0010\u001B\u001A\u00020\b2\b\b\u0002\u0010\u001A\u001A\u00020\u0017H\u0002\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001E\u001A\u00020\u00172\u0006\u0010\u001D\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0017\u0010 \u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b \u0010!J\u000F\u0010\"\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\"\u0010#J\u001D\u0010$\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0005\u00A2\u0006\u0004\b$\u0010%J\u0019\u0010&\u001A\u0004\u0018\u00010\f2\u0006\u0010\u000F\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b&\u0010\'J\u000F\u0010(\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b(\u0010)J\u0017\u0010*\u001A\u00020\b2\u0006\u0010\u001A\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b*\u0010\u001CJ\u0019\u0010+\u001A\u0004\u0018\u00010\f2\u0006\u0010\u000F\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b+\u0010\'R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010,R\u001C\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\t\u0010-R\u0014\u0010.\u001A\u00020\u00158\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001A\u00020\u00158\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b0\u0010/R\u0014\u00102\u001A\u0002018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b2\u00103R\u001A\u00105\u001A\b\u0012\u0004\u0012\u00020\u0005048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00107\u001A\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u00108R\u0018\u00109\u001A\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b9\u0010,\u00A8\u0006;"}, d2 = {"Lcom/iloen/melon/playback/SpApiQueueManagerImpl;", "Lcom/iloen/melon/playback/SpApiQueueManager;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/flow/Flow;", "", "thresholdFlow", "Lkotlin/Function0;", "Lie/H;", "doWhenOverThreshold", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/Flow;Lwe/a;)V", "Lcom/iloen/melon/playback/SpApiQueueBaseTask;", "getEnqueuePosition", "(Lcom/iloen/melon/playback/SpApiQueueBaseTask;)I", "task", "", "delayTime", "retryCnt", "executeTask", "(Lcom/iloen/melon/playback/SpApiQueueBaseTask;JI)V", "", "check", "", "message", "(ZLjava/lang/String;)V", "from", "logQueueForDebug", "(Ljava/lang/String;)V", "taskPriority", "convertTaskPriorityToString", "(I)Ljava/lang/String;", "enqueue", "(Lcom/iloen/melon/playback/SpApiQueueBaseTask;)V", "start", "()V", "retry", "(Lcom/iloen/melon/playback/SpApiQueueBaseTask;I)V", "dequeue", "(Lcom/iloen/melon/playback/SpApiQueueBaseTask;)Lcom/iloen/melon/playback/SpApiQueueBaseTask;", "peek", "()Lcom/iloen/melon/playback/SpApiQueueBaseTask;", "clear", "dequeueAndClear", "Lkotlinx/coroutines/CoroutineScope;", "Lwe/a;", "debug", "Z", "verbose", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Lkotlinx/coroutines/flow/StateFlow;", "threshold", "Lkotlinx/coroutines/flow/StateFlow;", "runningTask", "Lcom/iloen/melon/playback/SpApiQueueBaseTask;", "runningTaskScope", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SpApiQueueManagerImpl extends SpApiQueueManager {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/playback/SpApiQueueManagerImpl$Companion;", "", "<init>", "()V", "TAG", "", "THRESHOLD_MIN", "", "RETRY_DELAY_TIME", "", "RETRY_MAX_COUNT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final long RETRY_DELAY_TIME = 5000L;
    private static final int RETRY_MAX_COUNT = 5;
    @NotNull
    private static final String TAG = "SpApiQueueManagerImpl";
    private static final int THRESHOLD_MIN = 1;
    @NotNull
    private final CoroutineScope coroutineScope;
    private final boolean debug;
    @NotNull
    private a doWhenOverThreshold;
    @NotNull
    private final LogU log;
    @Nullable
    private SpApiQueueBaseTask runningTask;
    @Nullable
    private CoroutineScope runningTaskScope;
    @NotNull
    private final StateFlow threshold;
    private final boolean verbose;

    static {
        SpApiQueueManagerImpl.Companion = new Companion(null);
        SpApiQueueManagerImpl.$stable = 8;
    }

    public SpApiQueueManagerImpl(@NotNull CoroutineScope coroutineScope0, @NotNull Flow flow0, @NotNull a a0) {
        q.g(coroutineScope0, "coroutineScope");
        q.g(flow0, "thresholdFlow");
        q.g(a0, "doWhenOverThreshold");
        super();
        this.coroutineScope = coroutineScope0;
        this.doWhenOverThreshold = a0;
        boolean z = false;
        this.debug = false;
        if(!b.e()) {
            z = MelonPrefs.getInstance().getBoolean("SP_QUEUE_VERBOSE_LOGGING", false);
        }
        this.verbose = z;
        this.log = new LogU("SpApiQueueManagerImpl");
        this.threshold = FlowKt.stateIn(flow0, coroutineScope0, SharingStarted.Companion.getEagerly(), 5);
    }

    private final void check(boolean z, String s) {
        if(!z) {
            LogU.error$default(this.log, s, null, false, 6, null);
        }
    }

    @Override  // com.iloen.melon.playback.SpApiQueueManager
    public void clear(@NotNull String s) {
        synchronized(this) {
            q.g(s, "from");
            LogU.debug$default(this.log, "clear() - from: " + s, null, false, 6, null);
            if(this.runningTask == null) {
                this.getRequestList().clear();
            }
            else {
                this.check(q.b(this.peek(), this.runningTask), "dequeue() lastTask is not same as task.");
                this.getRequestList().clear();
                SpApiQueueBaseTask spApiQueueBaseTask0 = this.runningTask;
                q.d(spApiQueueBaseTask0);
                this.getRequestList().addLast(spApiQueueBaseTask0);
                CoroutineScope coroutineScope0 = this.runningTaskScope;
                if(coroutineScope0 != null) {
                    CoroutineScopeKt.cancel$default(coroutineScope0, "clear from " + s, null, 2, null);
                }
            }
        }
    }

    private final String convertTaskPriorityToString(int v) {
        switch(v) {
            case 0: {
                return "PRIORITY_HIGH";
            }
            case 1: {
                return "PRIORITY_DEFAULT";
            }
            default: {
                return "PRIORITY_UNKNOWN";
            }
        }
    }

    @Override  // com.iloen.melon.playback.SpApiQueueManager
    @Nullable
    public SpApiQueueBaseTask dequeue(@NotNull SpApiQueueBaseTask spApiQueueBaseTask0) {
        SpApiQueueBaseTask spApiQueueBaseTask1;
        synchronized(this) {
            q.g(spApiQueueBaseTask0, "task");
            LogU.debug$default(this.log, "dequeue() - task: " + spApiQueueBaseTask0, null, false, 6, null);
            spApiQueueBaseTask1 = null;
            if(this.peek() == spApiQueueBaseTask0) {
                this.runningTask = null;
                m m0 = this.getRequestList();
                if(!m0.isEmpty()) {
                    spApiQueueBaseTask1 = m0.removeLast();
                }
                this.logQueueForDebug("After dequeue");
            }
            else {
                this.logQueueForDebug("After dequeue");
                this.check(false, "dequeue() lastTask is not same as task.");
            }
        }
        return spApiQueueBaseTask1;
    }

    @Override  // com.iloen.melon.playback.SpApiQueueManager
    @Nullable
    public SpApiQueueBaseTask dequeueAndClear(@NotNull SpApiQueueBaseTask spApiQueueBaseTask0) {
        synchronized(this) {
            q.g(spApiQueueBaseTask0, "task");
            LogU.debug$default(this.log, "dequeueAndClear() - task: " + spApiQueueBaseTask0, null, false, 6, null);
            SpApiQueueBaseTask spApiQueueBaseTask1 = this.dequeue(spApiQueueBaseTask0);
            this.clear(spApiQueueBaseTask0.getTaskDesc());
            return spApiQueueBaseTask1;
        }
    }

    @Override  // com.iloen.melon.playback.SpApiQueueManager
    public void enqueue(@NotNull SpApiQueueBaseTask spApiQueueBaseTask0) {
        synchronized(this) {
            q.g(spApiQueueBaseTask0, "task");
            LogU.debug$default(this.log, "enqueue() - task: " + spApiQueueBaseTask0, null, false, 6, null);
            SpApiQueueBaseTask spApiQueueBaseTask1 = this.runningTask;
            if(spApiQueueBaseTask1 != null) {
                this.check(q.b(spApiQueueBaseTask1, this.peek()), "enqueue() running task is not last task.");
            }
            this.getRequestList().add(this.getEnqueuePosition(spApiQueueBaseTask0), spApiQueueBaseTask0);
            this.logQueueForDebug("After Enqueue");
            this.start();
        }
    }

    private final void executeTask(SpApiQueueBaseTask spApiQueueBaseTask0, long v, int v1) {
        if(this.runningTask != spApiQueueBaseTask0) {
            this.runningTask = spApiQueueBaseTask0;
            this.runningTaskScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        }
        this.check(this.runningTaskScope != null, "runningTaskScope is null.");
        if(this.runningTaskScope == null) {
            this.runningTaskScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        }
        CoroutineScope coroutineScope0 = this.runningTaskScope;
        if(coroutineScope0 != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getMain(), null, new n(this, spApiQueueBaseTask0, v1, null) {
                final long $delayTime;
                final int $retryCnt;
                final SpApiQueueBaseTask $task;
                private Object L$0;
                int label;

                {
                    this.$delayTime = v;
                    SpApiQueueManagerImpl.this = spApiQueueManagerImpl0;
                    this.$task = spApiQueueBaseTask0;
                    this.$retryCnt = v1;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    Continuation continuation1 = new com.iloen.melon.playback.SpApiQueueManagerImpl.executeTask.1(this.$delayTime, SpApiQueueManagerImpl.this, this.$task, this.$retryCnt, continuation0);
                    continuation1.L$0 = object0;
                    return continuation1;
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.playback.SpApiQueueManagerImpl.executeTask.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                    ne.a a0 = ne.a.a;
                    try {
                        switch(this.label) {
                            case 0: {
                                goto label_4;
                            }
                            case 1: {
                                goto label_11;
                            }
                            case 2: {
                                goto label_18;
                            }
                        }
                    }
                    catch(CancellationException unused_ex) {
                        goto label_27;
                    }
                    catch(Exception exception0) {
                        goto label_36;
                    }
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                label_4:
                    d5.n.D(object0);
                    try {
                        long v = this.$delayTime;
                        if(v > 0L) {
                            this.L$0 = coroutineScope0;
                            this.label = 1;
                            if(DelayKt.delay(v, this) == a0) {
                                return a0;
                            }
                            goto label_12;
                        label_11:
                            d5.n.D(object0);
                        }
                    label_12:
                        SpApiQueueManagerImpl.this.logQueueForDebug("Execute - " + this.$task);
                        this.L$0 = coroutineScope0;
                        this.label = 2;
                        object0 = this.$task.execute(this);
                        if(object0 == a0) {
                            return a0;
                        label_18:
                            d5.n.D(object0);
                        }
                        CoroutineScopeKt.ensureActive(coroutineScope0);
                        synchronized(SpApiQueueManagerImpl.this) {
                            ((a)object0).invoke();
                        }
                    }
                    catch(CancellationException unused_ex) {
                    label_27:
                        synchronized(SpApiQueueManagerImpl.this) {
                            LogU.debug$default(SpApiQueueManagerImpl.this.log, "executeTask() CancellationException, retryCnt " + this.$retryCnt, null, false, 6, null);
                            SpApiQueueManagerImpl.this.dequeue(this.$task);
                        }
                    }
                    catch(Exception exception0) {
                    label_36:
                        SpApiQueueManagerImpl spApiQueueManagerImpl0 = SpApiQueueManagerImpl.this;
                        int v3 = this.$retryCnt;
                        SpApiQueueBaseTask spApiQueueBaseTask0 = this.$task;
                        synchronized(spApiQueueManagerImpl0) {
                            if(spApiQueueManagerImpl0.debug || spApiQueueManagerImpl0.verbose) {
                                LogU.error$default(spApiQueueManagerImpl0.log, "executeTask() onFailure - " + exception0 + ", retryCnt " + v3, null, false, 6, null);
                                exception0.printStackTrace();
                            }
                            if(v3 < 5) {
                                spApiQueueManagerImpl0.retry(spApiQueueBaseTask0, v3 + 1);
                            }
                            else {
                                spApiQueueManagerImpl0.runningTask = null;
                            }
                        }
                    }
                    return H.a;
                }
            }, 2, null);
        }
    }

    public static void executeTask$default(SpApiQueueManagerImpl spApiQueueManagerImpl0, SpApiQueueBaseTask spApiQueueBaseTask0, long v, int v1, int v2, Object object0) {
        if((v2 & 2) != 0) {
            v = 0L;
        }
        if((v2 & 4) != 0) {
            v1 = 0;
        }
        spApiQueueManagerImpl0.executeTask(spApiQueueBaseTask0, v, v1);
    }

    private final int getEnqueuePosition(SpApiQueueBaseTask spApiQueueBaseTask0) {
        synchronized(this) {
            if(spApiQueueBaseTask0.getPriority() == 0) {
                return this.runningTask == null ? this.getRequestList().b() : this.getRequestList().b() - 1;
            }
            return 0;
        }
    }

    private final void logQueueForDebug(String s) {
        if(this.verbose) {
            StringBuilder stringBuilder0 = new StringBuilder("----------------------\n");
            if(s.length() > 0) {
                stringBuilder0.append("[" + s + "]");
            }
            stringBuilder0.append("\n---Queue start\n");
            for(Object object0: p.C0(this.getRequestList())) {
                stringBuilder0.append("  ");
                stringBuilder0.append(((SpApiQueueBaseTask)object0).getTaskDesc() + ", " + this.convertTaskPriorityToString(((SpApiQueueBaseTask)object0).getPriority()));
                stringBuilder0.append("\n");
            }
            stringBuilder0.append("---Queue End\n-----------------------");
            String s1 = stringBuilder0.toString();
            q.f(s1, "toString(...)");
            LogU.debug$default(this.log, s1, null, false, 6, null);
        }
    }

    public static void logQueueForDebug$default(SpApiQueueManagerImpl spApiQueueManagerImpl0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            s = "";
        }
        spApiQueueManagerImpl0.logQueueForDebug(s);
    }

    @Override  // com.iloen.melon.playback.SpApiQueueManager
    @NotNull
    public SpApiQueueBaseTask peek() {
        synchronized(this) {
            return (SpApiQueueBaseTask)this.getRequestList().last();
        }
    }

    public final void retry(@NotNull SpApiQueueBaseTask spApiQueueBaseTask0, int v) {
        synchronized(this) {
            q.g(spApiQueueBaseTask0, "task");
            LogU.debug$default(this.log, "retry() - task: " + spApiQueueBaseTask0 + ", retryCnt: " + v, null, false, 6, null);
            if(this.peek() != spApiQueueBaseTask0 || this.runningTask != spApiQueueBaseTask0) {
                this.check(false, "retry() task is not the last task or runningTask.");
            }
            else {
                int v1 = this.getRemainedCount();
                Object object0 = this.threshold.getValue();
                LogU.debug$default(this.log, "retry() - remainedCount: " + v1 + ", threshold: " + object0, null, false, 6, null);
                int v2 = this.getRemainedCount();
                int v3 = ((Number)this.threshold.getValue()).intValue();
                if(v3 < 1) {
                    v3 = 1;
                }
                if(v2 > v3) {
                    this.runningTask = null;
                    this.doWhenOverThreshold.invoke();
                }
                else {
                    this.executeTask(spApiQueueBaseTask0, 5000L, v);
                }
            }
        }
    }

    @Override  // com.iloen.melon.playback.SpApiQueueManager
    public void start() {
        synchronized(this) {
            if(this.runningTask != null) {
                LogU.debug$default(this.log, "start() skipped because runningTask is existed.", null, false, 6, null);
                return;
            }
            if(this.isEmpty()) {
                LogU.debug$default(this.log, "start() skipped because queue is empty.", null, false, 6, null);
                return;
            }
            int v1 = this.getRemainedCount();
            int v2 = ((Number)this.threshold.getValue()).intValue();
            if(v2 < 1) {
                v2 = 1;
            }
            if(v1 > v2) {
                this.doWhenOverThreshold.invoke();
            }
            else {
                SpApiQueueManagerImpl.executeTask$default(this, this.peek(), 0L, 0, 6, null);
            }
        }
    }
}

