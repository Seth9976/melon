package com.facebook.bolts;

import I7.k;
import b.l;
import com.facebook.appevents.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\r\u0018\u0000 Q*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003QRSB\t\b\u0010\u00A2\u0006\u0004\b\u0003\u0010\u0004B\u0013\b\u0012\u0012\b\u0010\u0005\u001A\u0004\u0018\u00018\u0000\u00A2\u0006\u0004\b\u0003\u0010\u0006B\u0011\b\u0012\u0012\u0006\u0010\b\u001A\u00020\u0007\u00A2\u0006\u0004\b\u0003\u0010\tJ\r\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\u000B\u0010\u0004J\u001D\u0010\u000B\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000E\u00A2\u0006\u0004\b\u000B\u0010\u0010J\u0019\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u0011\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00140\u0000\u00A2\u0006\u0004\b\u0015\u0010\u0013J;\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00140\u00002\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00070\u00162\u0018\u0010\u0019\u001A\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00000\u0018\u00A2\u0006\u0004\b\u001A\u0010\u001BJE\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00140\u00002\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00070\u00162\u0018\u0010\u0019\u001A\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00000\u00182\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C\u00A2\u0006\u0004\b\u001A\u0010\u001EJQ\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00140\u00002\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00070\u00162\u0018\u0010\u0019\u001A\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00000\u00182\b\b\u0002\u0010 \u001A\u00020\u001F2\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u001C\u00A2\u0006\u0004\b\u001A\u0010!J5\u0010#\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\"2\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\u0006\u0010 \u001A\u00020\u001F\u00A2\u0006\u0004\b#\u0010$J?\u0010#\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\"2\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\u0006\u0010 \u001A\u00020\u001F2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C\u00A2\u0006\u0004\b#\u0010%J-\u0010#\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\"2\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018\u00A2\u0006\u0004\b#\u0010&J7\u0010#\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\"2\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C\u00A2\u0006\u0004\b#\u0010\'J;\u0010(\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\"2\u0018\u0010\u0019\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u00182\u0006\u0010 \u001A\u00020\u001F\u00A2\u0006\u0004\b(\u0010$JE\u0010(\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\"2\u0018\u0010\u0019\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u00182\u0006\u0010 \u001A\u00020\u001F2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C\u00A2\u0006\u0004\b(\u0010%J3\u0010(\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\"2\u0018\u0010\u0019\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u0018\u00A2\u0006\u0004\b(\u0010&J=\u0010(\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\"2\u0018\u0010\u0019\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u00182\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C\u00A2\u0006\u0004\b(\u0010\'J5\u0010)\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\"2\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\u0006\u0010 \u001A\u00020\u001F\u00A2\u0006\u0004\b)\u0010$J?\u0010)\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\"2\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\u0006\u0010 \u001A\u00020\u001F2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C\u00A2\u0006\u0004\b)\u0010%J-\u0010)\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\"2\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018\u00A2\u0006\u0004\b)\u0010&J7\u0010)\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\"2\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C\u00A2\u0006\u0004\b)\u0010\'J;\u0010*\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\"2\u0018\u0010\u0019\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u00182\u0006\u0010 \u001A\u00020\u001F\u00A2\u0006\u0004\b*\u0010$JE\u0010*\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\"2\u0018\u0010\u0019\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u00182\u0006\u0010 \u001A\u00020\u001F2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C\u00A2\u0006\u0004\b*\u0010%J3\u0010*\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\"2\u0018\u0010\u0019\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u0018\u00A2\u0006\u0004\b*\u0010&J=\u0010*\u001A\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\"2\u0018\u0010\u0019\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u00182\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C\u00A2\u0006\u0004\b*\u0010\'J\r\u0010+\u001A\u00020\u0007\u00A2\u0006\u0004\b+\u0010,J\u0017\u0010-\u001A\u00020\u00072\b\u0010\u0005\u001A\u0004\u0018\u00018\u0000\u00A2\u0006\u0004\b-\u0010.J\u001D\u00102\u001A\u00020\u00072\u000E\u00101\u001A\n\u0018\u00010/j\u0004\u0018\u0001`0\u00A2\u0006\u0004\b2\u00103J\u000F\u00104\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b4\u0010\u0004R\u0014\u00106\u001A\u0002058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b6\u00107R\u001C\u0010:\u001A\n 9*\u0004\u0018\u000108088\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b>\u0010=R\u0018\u0010?\u001A\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010@R\u001E\u0010A\u001A\n\u0018\u00010/j\u0004\u0018\u0001`08\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010=R\u0018\u0010E\u001A\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010FR*\u0010H\u001A\u0016\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140\u0018\u0018\u00010G8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bH\u0010IR\u0011\u0010J\u001A\u00020\u00078F\u00A2\u0006\u0006\u001A\u0004\bJ\u0010,R\u0011\u0010K\u001A\u00020\u00078F\u00A2\u0006\u0006\u001A\u0004\bK\u0010,R\u0011\u0010L\u001A\u00020\u00078F\u00A2\u0006\u0006\u001A\u0004\bL\u0010,R\u0013\u0010\u0005\u001A\u0004\u0018\u00018\u00008F\u00A2\u0006\u0006\u001A\u0004\bM\u0010NR\u0019\u00101\u001A\n\u0018\u00010/j\u0004\u0018\u0001`08F\u00A2\u0006\u0006\u001A\u0004\bO\u0010P\u00A8\u0006T"}, d2 = {"Lcom/facebook/bolts/Task;", "TResult", "", "<init>", "()V", "result", "(Ljava/lang/Object;)V", "", "cancelled", "(Z)V", "Lie/H;", "waitForCompletion", "", "duration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "(JLjava/util/concurrent/TimeUnit;)Z", "TOut", "cast", "()Lcom/facebook/bolts/Task;", "Ljava/lang/Void;", "makeVoid", "Ljava/util/concurrent/Callable;", "predicate", "Lcom/facebook/bolts/Continuation;", "continuation", "continueWhile", "(Ljava/util/concurrent/Callable;Lcom/facebook/bolts/Continuation;)Lcom/facebook/bolts/Task;", "Lcom/facebook/bolts/CancellationToken;", "ct", "(Ljava/util/concurrent/Callable;Lcom/facebook/bolts/Continuation;Lcom/facebook/bolts/CancellationToken;)Lcom/facebook/bolts/Task;", "Ljava/util/concurrent/Executor;", "executor", "(Ljava/util/concurrent/Callable;Lcom/facebook/bolts/Continuation;Ljava/util/concurrent/Executor;Lcom/facebook/bolts/CancellationToken;)Lcom/facebook/bolts/Task;", "TContinuationResult", "continueWith", "(Lcom/facebook/bolts/Continuation;Ljava/util/concurrent/Executor;)Lcom/facebook/bolts/Task;", "(Lcom/facebook/bolts/Continuation;Ljava/util/concurrent/Executor;Lcom/facebook/bolts/CancellationToken;)Lcom/facebook/bolts/Task;", "(Lcom/facebook/bolts/Continuation;)Lcom/facebook/bolts/Task;", "(Lcom/facebook/bolts/Continuation;Lcom/facebook/bolts/CancellationToken;)Lcom/facebook/bolts/Task;", "continueWithTask", "onSuccess", "onSuccessTask", "trySetCancelled", "()Z", "trySetResult", "(Ljava/lang/Object;)Z", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "trySetError", "(Ljava/lang/Exception;)Z", "runContinuations", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "condition", "Ljava/util/concurrent/locks/Condition;", "completeField", "Z", "cancelledField", "resultField", "Ljava/lang/Object;", "errorField", "Ljava/lang/Exception;", "errorHasBeenObserved", "Lcom/facebook/bolts/UnobservedErrorNotifier;", "unobservedErrorNotifier", "Lcom/facebook/bolts/UnobservedErrorNotifier;", "", "continuations", "Ljava/util/List;", "isCompleted", "isCancelled", "isFaulted", "getResult", "()Ljava/lang/Object;", "getError", "()Ljava/lang/Exception;", "Companion", "TaskCompletionSource", "UnobservedExceptionHandler", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Task {
    @Metadata(d1 = {"\u0000\u008A\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\t\u0010\nJ%\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0001\u0010\u000B2\b\u0010\f\u001A\u0004\u0018\u00018\u0001H\u0007\u00A2\u0006\u0004\b\u000E\u0010\u000FJ+\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0001\u0010\u000B2\u000E\u0010\u0012\u001A\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011H\u0007\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001B\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0001\u0010\u000BH\u0007\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u001F\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\r2\u0006\u0010\u0018\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b\u0018\u0010\u001AJ)\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\r2\u0006\u0010\u0018\u001A\u00020\u00172\b\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\b\u0018\u0010\u001DJ1\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\r2\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u001F\u001A\u00020\u001E2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0001\u00A2\u0006\u0004\b \u0010!J+\u0010$\u001A\b\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0001\u0010\u000B2\u000E\u0010#\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\"H\u0007\u00A2\u0006\u0004\b$\u0010%J5\u0010$\u001A\b\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0001\u0010\u000B2\u000E\u0010#\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\"2\b\u0010&\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\b$\u0010\'J3\u0010)\u001A\b\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0001\u0010\u000B2\u000E\u0010#\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\"2\u0006\u0010\u001F\u001A\u00020(H\u0007\u00A2\u0006\u0004\b)\u0010*J=\u0010)\u001A\b\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0001\u0010\u000B2\u000E\u0010#\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\"2\u0006\u0010\u001F\u001A\u00020(2\b\u0010&\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\b)\u0010+J+\u0010)\u001A\b\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0001\u0010\u000B2\u000E\u0010#\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\"H\u0007\u00A2\u0006\u0004\b)\u0010%J5\u0010)\u001A\b\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0001\u0010\u000B2\u000E\u0010#\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\"2\b\u0010&\u001A\u0004\u0018\u00010\u001BH\u0007\u00A2\u0006\u0004\b)\u0010\'J5\u0010.\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\r\"\u0004\b\u0001\u0010\u000B2\u0012\u0010-\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0,H\u0007\u00A2\u0006\u0004\b.\u0010/J+\u00100\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\r2\u0010\u0010-\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0,H\u0007\u00A2\u0006\u0004\b0\u0010/J7\u00102\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u0001010\r\"\u0004\b\u0001\u0010\u000B2\u0012\u0010-\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0,H\u0007\u00A2\u0006\u0004\b2\u0010/J\'\u00103\u001A\b\u0012\u0004\u0012\u00020\u00190\r2\u0010\u0010-\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0,H\u0007\u00A2\u0006\u0004\b3\u0010/J]\u0010:\u001A\u00020\b\"\u0004\b\u0001\u00104\"\u0004\b\u0002\u0010\u000B2\f\u00106\u001A\b\u0012\u0004\u0012\u00028\u0001052\u0012\u00108\u001A\u000E\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0001072\f\u00109\u001A\b\u0012\u0004\u0012\u00028\u00020\r2\u0006\u0010\u001F\u001A\u00020(2\b\u0010&\u001A\u0004\u0018\u00010\u001BH\u0002\u00A2\u0006\u0004\b:\u0010;Jc\u0010<\u001A\u00020\b\"\u0004\b\u0001\u00104\"\u0004\b\u0002\u0010\u000B2\f\u00106\u001A\b\u0012\u0004\u0012\u00028\u0001052\u0018\u00108\u001A\u0014\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r072\f\u00109\u001A\b\u0012\u0004\u0012\u00028\u00020\r2\u0006\u0010\u001F\u001A\u00020(2\b\u0010&\u001A\u0004\u0018\u00010\u001BH\u0002\u00A2\u0006\u0004\b<\u0010;R\u0014\u0010>\u001A\u00020=8\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010@\u001A\u00020(8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010B\u001A\u0006\u0012\u0002\b\u00030\r8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bB\u0010CR\u001A\u0010E\u001A\b\u0012\u0004\u0012\u00020D0\r8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bE\u0010CR\u0018\u0010F\u001A\u0006\u0012\u0002\b\u00030\r8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bF\u0010CR\u001A\u0010G\u001A\b\u0012\u0004\u0012\u00020D0\r8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bG\u0010CR\u0014\u0010H\u001A\u00020(8\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\bH\u0010AR\u0018\u0010I\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bI\u0010J\u00A8\u0006K"}, d2 = {"Lcom/facebook/bolts/Task$Companion;", "", "<init>", "()V", "Lcom/facebook/bolts/Task$UnobservedExceptionHandler;", "getUnobservedExceptionHandler", "()Lcom/facebook/bolts/Task$UnobservedExceptionHandler;", "eh", "Lie/H;", "setUnobservedExceptionHandler", "(Lcom/facebook/bolts/Task$UnobservedExceptionHandler;)V", "TResult", "value", "Lcom/facebook/bolts/Task;", "forResult", "(Ljava/lang/Object;)Lcom/facebook/bolts/Task;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "forError", "(Ljava/lang/Exception;)Lcom/facebook/bolts/Task;", "cancelled", "()Lcom/facebook/bolts/Task;", "", "delay", "Ljava/lang/Void;", "(J)Lcom/facebook/bolts/Task;", "Lcom/facebook/bolts/CancellationToken;", "cancellationToken", "(JLcom/facebook/bolts/CancellationToken;)Lcom/facebook/bolts/Task;", "Ljava/util/concurrent/ScheduledExecutorService;", "executor", "delay$facebook_bolts_release", "(JLjava/util/concurrent/ScheduledExecutorService;Lcom/facebook/bolts/CancellationToken;)Lcom/facebook/bolts/Task;", "Ljava/util/concurrent/Callable;", "callable", "callInBackground", "(Ljava/util/concurrent/Callable;)Lcom/facebook/bolts/Task;", "ct", "(Ljava/util/concurrent/Callable;Lcom/facebook/bolts/CancellationToken;)Lcom/facebook/bolts/Task;", "Ljava/util/concurrent/Executor;", "call", "(Ljava/util/concurrent/Callable;Ljava/util/concurrent/Executor;)Lcom/facebook/bolts/Task;", "(Ljava/util/concurrent/Callable;Ljava/util/concurrent/Executor;Lcom/facebook/bolts/CancellationToken;)Lcom/facebook/bolts/Task;", "", "tasks", "whenAnyResult", "(Ljava/util/Collection;)Lcom/facebook/bolts/Task;", "whenAny", "", "whenAllResult", "whenAll", "TContinuationResult", "Lcom/facebook/bolts/TaskCompletionSource;", "tcs", "Lcom/facebook/bolts/Continuation;", "continuation", "task", "completeImmediately", "(Lcom/facebook/bolts/TaskCompletionSource;Lcom/facebook/bolts/Continuation;Lcom/facebook/bolts/Task;Ljava/util/concurrent/Executor;Lcom/facebook/bolts/CancellationToken;)V", "completeAfterTask", "Ljava/util/concurrent/ExecutorService;", "BACKGROUND_EXECUTOR", "Ljava/util/concurrent/ExecutorService;", "IMMEDIATE_EXECUTOR", "Ljava/util/concurrent/Executor;", "TASK_CANCELLED", "Lcom/facebook/bolts/Task;", "", "TASK_FALSE", "TASK_NULL", "TASK_TRUE", "UI_THREAD_EXECUTOR", "unobservedExceptionHandler", "Lcom/facebook/bolts/Task$UnobservedExceptionHandler;", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final void access$completeAfterTask(Companion task$Companion0, TaskCompletionSource taskCompletionSource0, Continuation continuation0, Task task0, Executor executor0, CancellationToken cancellationToken0) {
            task$Companion0.completeAfterTask(taskCompletionSource0, continuation0, task0, executor0, cancellationToken0);
        }

        public static final void access$completeImmediately(Companion task$Companion0, TaskCompletionSource taskCompletionSource0, Continuation continuation0, Task task0, Executor executor0, CancellationToken cancellationToken0) {
            task$Companion0.completeImmediately(taskCompletionSource0, continuation0, task0, executor0, cancellationToken0);
        }

        public static void b(ScheduledFuture scheduledFuture0, TaskCompletionSource taskCompletionSource0) {
            Companion.delay$lambda$1(scheduledFuture0, taskCompletionSource0);
        }

        public static Void c(AtomicBoolean atomicBoolean0, TaskCompletionSource taskCompletionSource0, Task task0) {
            return Companion.whenAny$lambda$4(atomicBoolean0, taskCompletionSource0, task0);
        }

        @NotNull
        public final Task call(@NotNull Callable callable0) {
            q.g(callable0, "callable");
            return this.call(callable0, Task.IMMEDIATE_EXECUTOR, null);
        }

        @NotNull
        public final Task call(@NotNull Callable callable0, @Nullable CancellationToken cancellationToken0) {
            q.g(callable0, "callable");
            return this.call(callable0, Task.IMMEDIATE_EXECUTOR, cancellationToken0);
        }

        @NotNull
        public final Task call(@NotNull Callable callable0, @NotNull Executor executor0) {
            q.g(callable0, "callable");
            q.g(executor0, "executor");
            return this.call(callable0, executor0, null);
        }

        @NotNull
        public final Task call(@NotNull Callable callable0, @NotNull Executor executor0, @Nullable CancellationToken cancellationToken0) {
            q.g(callable0, "callable");
            q.g(executor0, "executor");
            TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
            try {
                executor0.execute(new k(cancellationToken0, taskCompletionSource0, callable0, 21));
                return taskCompletionSource0.getTask();
            }
            catch(Exception exception0) {
                taskCompletionSource0.setError(new ExecutorException(exception0));
                return taskCompletionSource0.getTask();
            }
        }

        private static final void call$lambda$2(CancellationToken cancellationToken0, TaskCompletionSource taskCompletionSource0, Callable callable0) {
            q.g(taskCompletionSource0, "$tcs");
            q.g(callable0, "$callable");
            if(cancellationToken0 != null && cancellationToken0.isCancellationRequested()) {
                taskCompletionSource0.setCancelled();
                return;
            }
            try {
                taskCompletionSource0.setResult(callable0.call());
            }
            catch(CancellationException unused_ex) {
                taskCompletionSource0.setCancelled();
            }
            catch(Exception exception0) {
                taskCompletionSource0.setError(exception0);
            }
        }

        @NotNull
        public final Task callInBackground(@NotNull Callable callable0) {
            q.g(callable0, "callable");
            return this.call(callable0, Task.BACKGROUND_EXECUTOR, null);
        }

        @NotNull
        public final Task callInBackground(@NotNull Callable callable0, @Nullable CancellationToken cancellationToken0) {
            q.g(callable0, "callable");
            return this.call(callable0, Task.BACKGROUND_EXECUTOR, cancellationToken0);
        }

        @NotNull
        public final Task cancelled() {
            Task task0 = Task.TASK_CANCELLED;
            q.e(task0, "null cannot be cast to non-null type com.facebook.bolts.Task<TResult of com.facebook.bolts.Task.Companion.cancelled>");
            return task0;
        }

        private final void completeAfterTask(TaskCompletionSource taskCompletionSource0, Continuation continuation0, Task task0, Executor executor0, CancellationToken cancellationToken0) {
            try {
                executor0.execute(new d(cancellationToken0, taskCompletionSource0, continuation0, task0, 0));
            }
            catch(Exception exception0) {
                taskCompletionSource0.setError(new ExecutorException(exception0));
            }
        }

        private static final void completeAfterTask$lambda$7(CancellationToken cancellationToken0, TaskCompletionSource taskCompletionSource0, Continuation continuation0, Task task0) {
            q.g(taskCompletionSource0, "$tcs");
            q.g(continuation0, "$continuation");
            q.g(task0, "$task");
            if(cancellationToken0 != null && cancellationToken0.isCancellationRequested()) {
                taskCompletionSource0.setCancelled();
                return;
            }
            try {
                Task task1 = (Task)continuation0.then(task0);
                if(task1 == null || task1.continueWith(new a(cancellationToken0, taskCompletionSource0, 2)) == null) {
                    taskCompletionSource0.setResult(null);
                    return;
                }
                return;
            }
            catch(CancellationException unused_ex) {
            }
            catch(Exception exception0) {
                taskCompletionSource0.setError(exception0);
                return;
            }
            taskCompletionSource0.setCancelled();
        }

        private static final Void completeAfterTask$lambda$7$lambda$6(CancellationToken cancellationToken0, TaskCompletionSource taskCompletionSource0, Task task0) {
            q.g(taskCompletionSource0, "$tcs");
            q.g(task0, "task");
            if(cancellationToken0 != null && cancellationToken0.isCancellationRequested()) {
                taskCompletionSource0.setCancelled();
                return null;
            }
            if(task0.isCancelled()) {
                taskCompletionSource0.setCancelled();
                return null;
            }
            if(task0.isFaulted()) {
                taskCompletionSource0.setError(task0.getError());
                return null;
            }
            taskCompletionSource0.setResult(task0.getResult());
            return null;
        }

        private final void completeImmediately(TaskCompletionSource taskCompletionSource0, Continuation continuation0, Task task0, Executor executor0, CancellationToken cancellationToken0) {
            try {
                executor0.execute(new d(cancellationToken0, taskCompletionSource0, continuation0, task0, 1));
            }
            catch(Exception exception0) {
                taskCompletionSource0.setError(new ExecutorException(exception0));
            }
        }

        private static final void completeImmediately$lambda$5(CancellationToken cancellationToken0, TaskCompletionSource taskCompletionSource0, Continuation continuation0, Task task0) {
            q.g(taskCompletionSource0, "$tcs");
            q.g(continuation0, "$continuation");
            q.g(task0, "$task");
            if(cancellationToken0 != null && cancellationToken0.isCancellationRequested()) {
                taskCompletionSource0.setCancelled();
                return;
            }
            try {
                taskCompletionSource0.setResult(continuation0.then(task0));
            }
            catch(CancellationException unused_ex) {
                taskCompletionSource0.setCancelled();
            }
            catch(Exception exception0) {
                taskCompletionSource0.setError(exception0);
            }
        }

        public static void d(CancellationToken cancellationToken0, TaskCompletionSource taskCompletionSource0, Continuation continuation0, Task task0) {
            Companion.completeAfterTask$lambda$7(cancellationToken0, taskCompletionSource0, continuation0, task0);
        }

        @NotNull
        public final Task delay(long v) {
            return this.delay$facebook_bolts_release(v, BoltsExecutors.Companion.scheduled$facebook_bolts_release(), null);
        }

        @NotNull
        public final Task delay(long v, @Nullable CancellationToken cancellationToken0) {
            return this.delay$facebook_bolts_release(v, BoltsExecutors.Companion.scheduled$facebook_bolts_release(), cancellationToken0);
        }

        @NotNull
        public final Task delay$facebook_bolts_release(long v, @NotNull ScheduledExecutorService scheduledExecutorService0, @Nullable CancellationToken cancellationToken0) {
            q.g(scheduledExecutorService0, "executor");
            if(cancellationToken0 != null && cancellationToken0.isCancellationRequested()) {
                return this.cancelled();
            }
            if(v <= 0L) {
                return this.forResult(null);
            }
            TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
            ScheduledFuture scheduledFuture0 = scheduledExecutorService0.schedule(new c(taskCompletionSource0, 4), v, TimeUnit.MILLISECONDS);
            if(cancellationToken0 != null) {
                cancellationToken0.register(new l(12, scheduledFuture0, taskCompletionSource0));
            }
            return taskCompletionSource0.getTask();
        }

        private static final void delay$lambda$0(TaskCompletionSource taskCompletionSource0) {
            q.g(taskCompletionSource0, "$tcs");
            taskCompletionSource0.trySetResult(null);
        }

        private static final void delay$lambda$1(ScheduledFuture scheduledFuture0, TaskCompletionSource taskCompletionSource0) {
            q.g(taskCompletionSource0, "$tcs");
            scheduledFuture0.cancel(true);
            taskCompletionSource0.trySetCancelled();
        }

        public static Void e(CancellationToken cancellationToken0, TaskCompletionSource taskCompletionSource0, Task task0) {
            return Companion.completeAfterTask$lambda$7$lambda$6(cancellationToken0, taskCompletionSource0, task0);
        }

        public static void f(TaskCompletionSource taskCompletionSource0) {
            Companion.delay$lambda$0(taskCompletionSource0);
        }

        @NotNull
        public final Task forError(@Nullable Exception exception0) {
            TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
            taskCompletionSource0.setError(exception0);
            return taskCompletionSource0.getTask();
        }

        @NotNull
        public final Task forResult(@Nullable Object object0) {
            if(object0 == null) {
                Task task0 = Task.TASK_NULL;
                q.e(task0, "null cannot be cast to non-null type com.facebook.bolts.Task<TResult of com.facebook.bolts.Task.Companion.forResult>");
                return task0;
            }
            if(object0 instanceof Boolean) {
                Task task1 = ((Boolean)object0).booleanValue() ? Task.TASK_TRUE : Task.TASK_FALSE;
                q.e(task1, "null cannot be cast to non-null type com.facebook.bolts.Task<TResult of com.facebook.bolts.Task.Companion.forResult>");
                return task1;
            }
            TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
            taskCompletionSource0.setResult(object0);
            return taskCompletionSource0.getTask();
        }

        public static void g(CancellationToken cancellationToken0, TaskCompletionSource taskCompletionSource0, Continuation continuation0, Task task0) {
            Companion.completeImmediately$lambda$5(cancellationToken0, taskCompletionSource0, continuation0, task0);
        }

        @Nullable
        public final UnobservedExceptionHandler getUnobservedExceptionHandler() {
            return Task.unobservedExceptionHandler;
        }

        public static Void h(AtomicBoolean atomicBoolean0, TaskCompletionSource taskCompletionSource0, Task task0) {
            return Companion.whenAnyResult$lambda$3(atomicBoolean0, taskCompletionSource0, task0);
        }

        public final void setUnobservedExceptionHandler(@Nullable UnobservedExceptionHandler task$UnobservedExceptionHandler0) {
            Task.unobservedExceptionHandler = task$UnobservedExceptionHandler0;
        }

        @NotNull
        public final Task whenAll(@NotNull Collection collection0) {
            q.g(collection0, "tasks");
            if(collection0.isEmpty()) {
                return this.forResult(null);
            }
            TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
            ArrayList arrayList0 = new ArrayList();
            ReentrantLock reentrantLock0 = new ReentrantLock();
            AtomicInteger atomicInteger0 = new AtomicInteger(collection0.size());
            AtomicBoolean atomicBoolean0 = new AtomicBoolean(false);
            for(Object object0: collection0) {
                q.e(((Task)object0), "null cannot be cast to non-null type com.facebook.bolts.Task<kotlin.Any>");
                ((Task)object0).continueWith(new Continuation() {
                    @Override  // com.facebook.bolts.Continuation
                    public Object then(Task task0) {
                        return this.then(task0);
                    }

                    @Nullable
                    public final Void then(@NotNull Task task0) {
                        q.g(task0, "it");
                        if(task0.isFaulted()) {
                            atomicBoolean0.lock();
                            try {
                                Exception exception0 = task0.getError();
                                taskCompletionSource0.add(exception0);
                            }
                            finally {
                                atomicBoolean0.unlock();
                            }
                        }
                        if(task0.isCancelled()) {
                            atomicInteger0.set(true);
                        }
                        if(arrayList0.decrementAndGet() == 0) {
                            switch(taskCompletionSource0.size()) {
                                case 0: {
                                    if(atomicInteger0.get()) {
                                        this.$allFinished.setCancelled();
                                        return null;
                                    }
                                    this.$allFinished.setResult(null);
                                    break;
                                }
                                case 1: {
                                    Exception exception1 = (Exception)taskCompletionSource0.get(0);
                                    this.$allFinished.setError(exception1);
                                    return null;
                                }
                                default: {
                                    AggregateException aggregateException0 = new AggregateException(String.format("There were %d exceptions.", Arrays.copyOf(new Object[]{taskCompletionSource0.size()}, 1)), taskCompletionSource0);
                                    this.$allFinished.setError(aggregateException0);
                                    return null;
                                }
                            }
                        }
                        return null;
                    }
                });
            }
            return taskCompletionSource0.getTask();
        }

        @NotNull
        public final Task whenAllResult(@NotNull Collection collection0) {
            q.g(collection0, "tasks");
            return this.whenAll(collection0).onSuccess(new Continuation() {
                @Override  // com.facebook.bolts.Continuation
                public Object then(Task task0) {
                    return this.then(task0);
                }

                @NotNull
                public List then(@NotNull Task task0) {
                    q.g(task0, "task");
                    if(this.$tasks.isEmpty()) {
                        return w.a;
                    }
                    List list0 = new ArrayList();
                    for(Object object0: this.$tasks) {
                        list0.add(((Task)object0).getResult());
                    }
                    return list0;
                }
            });
        }

        @NotNull
        public final Task whenAny(@NotNull Collection collection0) {
            q.g(collection0, "tasks");
            if(collection0.isEmpty()) {
                return this.forResult(null);
            }
            TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
            AtomicBoolean atomicBoolean0 = new AtomicBoolean(false);
            for(Object object0: collection0) {
                q.e(((Task)object0), "null cannot be cast to non-null type com.facebook.bolts.Task<kotlin.Any>");
                ((Task)object0).continueWith(new e(atomicBoolean0, taskCompletionSource0, 1));
            }
            return taskCompletionSource0.getTask();
        }

        private static final Void whenAny$lambda$4(AtomicBoolean atomicBoolean0, TaskCompletionSource taskCompletionSource0, Task task0) {
            q.g(atomicBoolean0, "$isAnyTaskComplete");
            q.g(taskCompletionSource0, "$firstCompleted");
            q.g(task0, "it");
            if(atomicBoolean0.compareAndSet(false, true)) {
                taskCompletionSource0.setResult(task0);
                return null;
            }
            task0.getError();
            return null;
        }

        @NotNull
        public final Task whenAnyResult(@NotNull Collection collection0) {
            q.g(collection0, "tasks");
            if(collection0.isEmpty()) {
                return this.forResult(null);
            }
            TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
            AtomicBoolean atomicBoolean0 = new AtomicBoolean(false);
            for(Object object0: collection0) {
                ((Task)object0).continueWith(new e(atomicBoolean0, taskCompletionSource0, 0));
            }
            return taskCompletionSource0.getTask();
        }

        private static final Void whenAnyResult$lambda$3(AtomicBoolean atomicBoolean0, TaskCompletionSource taskCompletionSource0, Task task0) {
            q.g(atomicBoolean0, "$isAnyTaskComplete");
            q.g(taskCompletionSource0, "$firstCompleted");
            q.g(task0, "it");
            if(atomicBoolean0.compareAndSet(false, true)) {
                taskCompletionSource0.setResult(task0);
                return null;
            }
            task0.getError();
            return null;
        }
    }

    @ie.d
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/facebook/bolts/Task$TaskCompletionSource;", "Lcom/facebook/bolts/TaskCompletionSource;", "(Lcom/facebook/bolts/Task;)V", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public final class com.facebook.bolts.Task.TaskCompletionSource extends TaskCompletionSource {
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J#\u0010\u0007\u001A\u00020\u00062\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/facebook/bolts/Task$UnobservedExceptionHandler;", "", "Lcom/facebook/bolts/Task;", "t", "Lcom/facebook/bolts/UnobservedTaskException;", "e", "Lie/H;", "unobservedException", "(Lcom/facebook/bolts/Task;Lcom/facebook/bolts/UnobservedTaskException;)V", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface UnobservedExceptionHandler {
        void unobservedException(@NotNull Task arg1, @NotNull UnobservedTaskException arg2);
    }

    @NotNull
    public static final ExecutorService BACKGROUND_EXECUTOR;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final Executor IMMEDIATE_EXECUTOR;
    @NotNull
    private static final Task TASK_CANCELLED;
    @NotNull
    private static final Task TASK_FALSE;
    @NotNull
    private static final Task TASK_NULL;
    @NotNull
    private static final Task TASK_TRUE;
    @NotNull
    public static final Executor UI_THREAD_EXECUTOR;
    private boolean cancelledField;
    private boolean completeField;
    private final Condition condition;
    @Nullable
    private List continuations;
    @Nullable
    private Exception errorField;
    private boolean errorHasBeenObserved;
    @NotNull
    private final ReentrantLock lock;
    @Nullable
    private Object resultField;
    @Nullable
    private UnobservedErrorNotifier unobservedErrorNotifier;
    @Nullable
    private static volatile UnobservedExceptionHandler unobservedExceptionHandler;

    static {
        Task.Companion = new Companion(null);
        Task.BACKGROUND_EXECUTOR = BoltsExecutors.Companion.background();
        Task.IMMEDIATE_EXECUTOR = BoltsExecutors.Companion.immediate$facebook_bolts_release();
        Task.UI_THREAD_EXECUTOR = AndroidExecutors.Companion.uiThread();
        Task.TASK_NULL = new Task(null);
        Task.TASK_TRUE = new Task(Boolean.TRUE);
        Task.TASK_FALSE = new Task(Boolean.FALSE);
        Task.TASK_CANCELLED = new Task(true);
    }

    public Task() {
        ReentrantLock reentrantLock0 = new ReentrantLock();
        this.lock = reentrantLock0;
        this.condition = reentrantLock0.newCondition();
        this.continuations = new ArrayList();
    }

    private Task(Object object0) {
        ReentrantLock reentrantLock0 = new ReentrantLock();
        this.lock = reentrantLock0;
        this.condition = reentrantLock0.newCondition();
        this.continuations = new ArrayList();
        this.trySetResult(object0);
    }

    private Task(boolean z) {
        ReentrantLock reentrantLock0 = new ReentrantLock();
        this.lock = reentrantLock0;
        this.condition = reentrantLock0.newCondition();
        this.continuations = new ArrayList();
        if(z) {
            this.trySetCancelled();
            return;
        }
        this.trySetResult(null);
    }

    @NotNull
    public static final Task call(@NotNull Callable callable0) {
        return Task.Companion.call(callable0);
    }

    @NotNull
    public static final Task call(@NotNull Callable callable0, @Nullable CancellationToken cancellationToken0) {
        return Task.Companion.call(callable0, cancellationToken0);
    }

    @NotNull
    public static final Task call(@NotNull Callable callable0, @NotNull Executor executor0) {
        return Task.Companion.call(callable0, executor0);
    }

    @NotNull
    public static final Task call(@NotNull Callable callable0, @NotNull Executor executor0, @Nullable CancellationToken cancellationToken0) {
        return Task.Companion.call(callable0, executor0, cancellationToken0);
    }

    @NotNull
    public static final Task callInBackground(@NotNull Callable callable0) {
        return Task.Companion.callInBackground(callable0);
    }

    @NotNull
    public static final Task callInBackground(@NotNull Callable callable0, @Nullable CancellationToken cancellationToken0) {
        return Task.Companion.callInBackground(callable0, cancellationToken0);
    }

    @NotNull
    public static final Task cancelled() {
        return Task.Companion.cancelled();
    }

    @NotNull
    public final Task cast() {
        return this;
    }

    @NotNull
    public final Task continueWhile(@NotNull Callable callable0, @NotNull Continuation continuation0) {
        q.g(callable0, "predicate");
        q.g(continuation0, "continuation");
        return this.continueWhile(callable0, continuation0, Task.IMMEDIATE_EXECUTOR, null);
    }

    @NotNull
    public final Task continueWhile(@NotNull Callable callable0, @NotNull Continuation continuation0, @Nullable CancellationToken cancellationToken0) {
        q.g(callable0, "predicate");
        q.g(continuation0, "continuation");
        return this.continueWhile(callable0, continuation0, Task.IMMEDIATE_EXECUTOR, cancellationToken0);
    }

    @NotNull
    public final Task continueWhile(@NotNull Callable callable0, @NotNull Continuation continuation0, @NotNull Executor executor0, @Nullable CancellationToken cancellationToken0) {
        q.g(callable0, "predicate");
        q.g(continuation0, "continuation");
        q.g(executor0, "executor");
        com.facebook.bolts.Task.continueWhile.predicateContinuation.1 task$continueWhile$predicateContinuation$10 = new Continuation() {
            @NotNull
            public Task then(@NotNull Task task0) {
                q.g(task0, "task");
                if(callable0 != null && callable0.isCancellationRequested()) {
                    return Task.Companion.cancelled();
                }
                Object object0 = continuation0.call();
                q.f(object0, "predicate.call()");
                return ((Boolean)object0).booleanValue() ? Task.Companion.forResult(null).onSuccessTask(executor0, this.$executor).onSuccessTask(this, this.$executor) : Task.Companion.forResult(null);
            }

            @Override  // com.facebook.bolts.Continuation
            public Object then(Task task0) {
                return this.then(task0);
            }
        };
        return this.makeVoid().continueWithTask(task$continueWhile$predicateContinuation$10, executor0);
    }

    public static Task continueWhile$default(Task task0, Callable callable0, Continuation continuation0, Executor executor0, CancellationToken cancellationToken0, int v, Object object0) {
        if((v & 4) != 0) {
            executor0 = Task.IMMEDIATE_EXECUTOR;
        }
        if((v & 8) != 0) {
            cancellationToken0 = null;
        }
        return task0.continueWhile(callable0, continuation0, executor0, cancellationToken0);
    }

    @NotNull
    public final Task continueWith(@NotNull Continuation continuation0) {
        q.g(continuation0, "continuation");
        return this.continueWith(continuation0, Task.IMMEDIATE_EXECUTOR, null);
    }

    @NotNull
    public final Task continueWith(@NotNull Continuation continuation0, @Nullable CancellationToken cancellationToken0) {
        q.g(continuation0, "continuation");
        return this.continueWith(continuation0, Task.IMMEDIATE_EXECUTOR, cancellationToken0);
    }

    @NotNull
    public final Task continueWith(@NotNull Continuation continuation0, @NotNull Executor executor0) {
        q.g(continuation0, "continuation");
        q.g(executor0, "executor");
        return this.continueWith(continuation0, executor0, null);
    }

    @NotNull
    public final Task continueWith(@NotNull Continuation continuation0, @NotNull Executor executor0, @Nullable CancellationToken cancellationToken0) {
        q.g(continuation0, "continuation");
        q.g(executor0, "executor");
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            boolean z = this.isCompleted();
            if(!z) {
                List list0 = this.continuations;
                if(list0 != null) {
                    list0.add(new b(taskCompletionSource0, continuation0, executor0, cancellationToken0, 0));
                }
            }
        }
        finally {
            reentrantLock0.unlock();
        }
        if(z) {
            Companion.access$completeImmediately(Task.Companion, taskCompletionSource0, continuation0, this, executor0, cancellationToken0);
        }
        return taskCompletionSource0.getTask();
    }

    private static final Void continueWith$lambda$10$lambda$9(TaskCompletionSource taskCompletionSource0, Continuation continuation0, Executor executor0, CancellationToken cancellationToken0, Task task0) {
        q.g(taskCompletionSource0, "$tcs");
        q.g(continuation0, "$continuation");
        q.g(executor0, "$executor");
        q.g(task0, "task");
        Companion.access$completeImmediately(Task.Companion, taskCompletionSource0, continuation0, task0, executor0, cancellationToken0);
        return null;
    }

    @NotNull
    public final Task continueWithTask(@NotNull Continuation continuation0) {
        q.g(continuation0, "continuation");
        return this.continueWithTask(continuation0, Task.IMMEDIATE_EXECUTOR, null);
    }

    @NotNull
    public final Task continueWithTask(@NotNull Continuation continuation0, @Nullable CancellationToken cancellationToken0) {
        q.g(continuation0, "continuation");
        return this.continueWithTask(continuation0, Task.IMMEDIATE_EXECUTOR, cancellationToken0);
    }

    @NotNull
    public final Task continueWithTask(@NotNull Continuation continuation0, @NotNull Executor executor0) {
        q.g(continuation0, "continuation");
        q.g(executor0, "executor");
        return this.continueWithTask(continuation0, executor0, null);
    }

    @NotNull
    public final Task continueWithTask(@NotNull Continuation continuation0, @NotNull Executor executor0, @Nullable CancellationToken cancellationToken0) {
        q.g(continuation0, "continuation");
        q.g(executor0, "executor");
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            boolean z = this.isCompleted();
            if(!z) {
                List list0 = this.continuations;
                if(list0 != null) {
                    list0.add(new b(taskCompletionSource0, continuation0, executor0, cancellationToken0, 1));
                }
            }
        }
        finally {
            reentrantLock0.unlock();
        }
        if(z) {
            Companion.access$completeAfterTask(Task.Companion, taskCompletionSource0, continuation0, this, executor0, cancellationToken0);
        }
        return taskCompletionSource0.getTask();
    }

    private static final Void continueWithTask$lambda$12$lambda$11(TaskCompletionSource taskCompletionSource0, Continuation continuation0, Executor executor0, CancellationToken cancellationToken0, Task task0) {
        q.g(taskCompletionSource0, "$tcs");
        q.g(continuation0, "$continuation");
        q.g(executor0, "$executor");
        q.g(task0, "task");
        Companion.access$completeAfterTask(Task.Companion, taskCompletionSource0, continuation0, task0, executor0, cancellationToken0);
        return null;
    }

    public static Void d(TaskCompletionSource taskCompletionSource0, Continuation continuation0, Executor executor0, CancellationToken cancellationToken0, Task task0) {
        return Task.continueWith$lambda$10$lambda$9(taskCompletionSource0, continuation0, executor0, cancellationToken0, task0);
    }

    @NotNull
    public static final Task delay(long v) {
        return Task.Companion.delay(v);
    }

    @NotNull
    public static final Task delay(long v, @Nullable CancellationToken cancellationToken0) {
        return Task.Companion.delay(v, cancellationToken0);
    }

    @NotNull
    public static final Task delay$facebook_bolts_release(long v, @NotNull ScheduledExecutorService scheduledExecutorService0, @Nullable CancellationToken cancellationToken0) {
        return Task.Companion.delay$facebook_bolts_release(v, scheduledExecutorService0, cancellationToken0);
    }

    @NotNull
    public static final Task forError(@Nullable Exception exception0) {
        return Task.Companion.forError(exception0);
    }

    @NotNull
    public static final Task forResult(@Nullable Object object0) {
        return Task.Companion.forResult(object0);
    }

    @Nullable
    public final Exception getError() {
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(this.errorField != null) {
                this.errorHasBeenObserved = true;
                UnobservedErrorNotifier unobservedErrorNotifier0 = this.unobservedErrorNotifier;
                if(unobservedErrorNotifier0 != null) {
                    unobservedErrorNotifier0.setObserved();
                    this.unobservedErrorNotifier = null;
                }
            }
            return this.errorField;
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    @Nullable
    public final Object getResult() {
        this.lock.lock();
        Object object0 = this.resultField;
        this.lock.unlock();
        return object0;
    }

    @Nullable
    public static final UnobservedExceptionHandler getUnobservedExceptionHandler() {
        return Task.Companion.getUnobservedExceptionHandler();
    }

    public final boolean isCancelled() {
        this.lock.lock();
        boolean z = this.cancelledField;
        this.lock.unlock();
        return z;
    }

    public final boolean isCompleted() {
        this.lock.lock();
        boolean z = this.completeField;
        this.lock.unlock();
        return z;
    }

    public final boolean isFaulted() {
        this.lock.lock();
        boolean z = this.errorField != null;
        this.lock.unlock();
        return z;
    }

    @NotNull
    public final Task makeVoid() {
        return this.continueWithTask((Task task0) -> {
            q.g(task0, "task");
            if(task0.isCancelled()) {
                return Task.Companion.cancelled();
            }
            if(task0.isFaulted()) {
                Exception exception0 = task0.getError();
                return Task.Companion.forError(exception0);
            }
            return Task.Companion.forResult(null);
        });
    }

    // 检测为 Lambda 实现
    private static final Task makeVoid$lambda$8(Task task0) [...]

    @NotNull
    public final Task onSuccess(@NotNull Continuation continuation0) {
        q.g(continuation0, "continuation");
        return this.onSuccess(continuation0, Task.IMMEDIATE_EXECUTOR, null);
    }

    @NotNull
    public final Task onSuccess(@NotNull Continuation continuation0, @Nullable CancellationToken cancellationToken0) {
        q.g(continuation0, "continuation");
        return this.onSuccess(continuation0, Task.IMMEDIATE_EXECUTOR, cancellationToken0);
    }

    @NotNull
    public final Task onSuccess(@NotNull Continuation continuation0, @NotNull Executor executor0) {
        q.g(continuation0, "continuation");
        q.g(executor0, "executor");
        return this.onSuccess(continuation0, executor0, null);
    }

    @NotNull
    public final Task onSuccess(@NotNull Continuation continuation0, @NotNull Executor executor0, @Nullable CancellationToken cancellationToken0) {
        q.g(continuation0, "continuation");
        q.g(executor0, "executor");
        return this.continueWithTask(new a(cancellationToken0, continuation0, 1), executor0);
    }

    private static final Task onSuccess$lambda$13(CancellationToken cancellationToken0, Continuation continuation0, Task task0) {
        q.g(continuation0, "$continuation");
        q.g(task0, "task");
        if(cancellationToken0 != null && cancellationToken0.isCancellationRequested()) {
            return Task.Companion.cancelled();
        }
        if(task0.isFaulted()) {
            Exception exception0 = task0.getError();
            return Task.Companion.forError(exception0);
        }
        return task0.isCancelled() ? Task.Companion.cancelled() : task0.continueWith(continuation0);
    }

    @NotNull
    public final Task onSuccessTask(@NotNull Continuation continuation0) {
        q.g(continuation0, "continuation");
        return this.onSuccessTask(continuation0, Task.IMMEDIATE_EXECUTOR);
    }

    @NotNull
    public final Task onSuccessTask(@NotNull Continuation continuation0, @Nullable CancellationToken cancellationToken0) {
        q.g(continuation0, "continuation");
        return this.onSuccessTask(continuation0, Task.IMMEDIATE_EXECUTOR, cancellationToken0);
    }

    @NotNull
    public final Task onSuccessTask(@NotNull Continuation continuation0, @NotNull Executor executor0) {
        q.g(continuation0, "continuation");
        q.g(executor0, "executor");
        return this.onSuccessTask(continuation0, executor0, null);
    }

    @NotNull
    public final Task onSuccessTask(@NotNull Continuation continuation0, @NotNull Executor executor0, @Nullable CancellationToken cancellationToken0) {
        q.g(continuation0, "continuation");
        q.g(executor0, "executor");
        return this.continueWithTask(new a(cancellationToken0, continuation0, 0), executor0);
    }

    private static final Task onSuccessTask$lambda$14(CancellationToken cancellationToken0, Continuation continuation0, Task task0) {
        q.g(continuation0, "$continuation");
        q.g(task0, "task");
        if(cancellationToken0 != null && cancellationToken0.isCancellationRequested()) {
            return Task.Companion.cancelled();
        }
        if(task0.isFaulted()) {
            Exception exception0 = task0.getError();
            return Task.Companion.forError(exception0);
        }
        return task0.isCancelled() ? Task.Companion.cancelled() : task0.continueWithTask(continuation0);
    }

    private final void runContinuations() {
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            List list0 = this.continuations;
            if(list0 != null) {
                for(Object object0: list0) {
                    Continuation continuation0 = (Continuation)object0;
                    try {
                        continuation0.then(this);
                    }
                    catch(RuntimeException runtimeException0) {
                        throw runtimeException0;
                    }
                    catch(Throwable throwable0) {
                        throw new RuntimeException(throwable0);
                    }
                }
            }
            this.continuations = null;
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    public static final void setUnobservedExceptionHandler(@Nullable UnobservedExceptionHandler task$UnobservedExceptionHandler0) {
        Task.Companion.setUnobservedExceptionHandler(task$UnobservedExceptionHandler0);
    }

    public final boolean trySetCancelled() {
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(this.completeField) {
                return false;
            }
            this.completeField = true;
            this.cancelledField = true;
            this.condition.signalAll();
            this.runContinuations();
            return true;
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    public final boolean trySetError(@Nullable Exception exception0) {
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(this.completeField) {
                return false;
            }
            this.completeField = true;
            this.errorField = exception0;
            this.errorHasBeenObserved = false;
            this.condition.signalAll();
            this.runContinuations();
            if(!this.errorHasBeenObserved && Task.unobservedExceptionHandler != null) {
                this.unobservedErrorNotifier = new UnobservedErrorNotifier(this);
            }
            return true;
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    public final boolean trySetResult(@Nullable Object object0) {
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(this.completeField) {
                return false;
            }
            this.completeField = true;
            this.resultField = object0;
            this.condition.signalAll();
            this.runContinuations();
            return true;
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    public final void waitForCompletion() {
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(!this.isCompleted()) {
                this.condition.await();
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    public final boolean waitForCompletion(long v, @NotNull TimeUnit timeUnit0) {
        q.g(timeUnit0, "timeUnit");
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(!this.isCompleted()) {
                this.condition.await(v, timeUnit0);
            }
            return this.isCompleted();
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    @NotNull
    public static final Task whenAll(@NotNull Collection collection0) {
        return Task.Companion.whenAll(collection0);
    }

    @NotNull
    public static final Task whenAllResult(@NotNull Collection collection0) {
        return Task.Companion.whenAllResult(collection0);
    }

    @NotNull
    public static final Task whenAny(@NotNull Collection collection0) {
        return Task.Companion.whenAny(collection0);
    }

    @NotNull
    public static final Task whenAnyResult(@NotNull Collection collection0) {
        return Task.Companion.whenAnyResult(collection0);
    }
}

