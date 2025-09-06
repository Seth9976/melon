package com.iloen.melon.utils;

import H0.b;
import com.iloen.melon.custom.L0;
import com.iloen.melon.custom.l1;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;
import we.k;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A<\u0010\b\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0086H¢\u0006\u0004\b\b\u0010\t\u001AN\u0010\f\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u001E\b\u0004\u0010\u0007\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u00020\nH\u0086H¢\u0006\u0004\b\f\u0010\r\u001AF\u0010\u0010\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0086H¢\u0006\u0004\b\u0010\u0010\u0011\u001AX\u0010\u0012\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u001E\b\u0004\u0010\u0007\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u00020\nH\u0086H¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"T", "Lkotlinx/coroutines/sync/Mutex;", "", "owner", "", "caller", "Lkotlin/Function0;", "action", "withLockLogging", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Ljava/lang/String;Lwe/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "withReentrantLockLogging", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Ljava/lang/String;Lwe/k;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/custom/L0;", "progressUpdatable", "withLockLoggingAndProgress", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lcom/iloen/melon/custom/L0;Ljava/lang/String;Lwe/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withReentrantLockLoggingAndProgress", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Ljava/lang/String;Lcom/iloen/melon/custom/L0;Lwe/k;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class MutexLockUtilKt {
    @Nullable
    public static final Object withLockLogging(@NotNull Mutex mutex0, @Nullable Object object0, @NotNull String s, @NotNull a a0, @NotNull Continuation continuation0) {
        Object object4;
        long v2;
        Mutex mutex2;
        Object object2;
        Integer integer1;
        String s1;
        Mutex mutex1;
        a a2;
        DevLog devLog0;
        com.iloen.melon.utils.MutexLockUtilKt.withLockLogging.1 mutexLockUtilKt$withLockLogging$10;
        if(continuation0 instanceof com.iloen.melon.utils.MutexLockUtilKt.withLockLogging.1) {
            mutexLockUtilKt$withLockLogging$10 = (com.iloen.melon.utils.MutexLockUtilKt.withLockLogging.1)continuation0;
            int v = mutexLockUtilKt$withLockLogging$10.N;
            if((v & 0x80000000) == 0) {
                mutexLockUtilKt$withLockLogging$10 = new c(continuation0) {  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
                    public a B;
                    public Object D;
                    public DevLog E;
                    public Mutex G;
                    public Object I;
                    public Object M;
                    public int N;
                    public Mutex r;
                    public String w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.M = object0;
                        this.N |= 0x80000000;
                        return MutexLockUtilKt.withLockLogging(null, null, null, null, this);
                    }
                };
            }
            else {
                mutexLockUtilKt$withLockLogging$10.N = v ^ 0x80000000;
            }
        }
        else {
            mutexLockUtilKt$withLockLogging$10 = new c(continuation0) {  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
                public a B;
                public Object D;
                public DevLog E;
                public Mutex G;
                public Object I;
                public Object M;
                public int N;
                public Mutex r;
                public String w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.M = object0;
                    this.N |= 0x80000000;
                    return MutexLockUtilKt.withLockLogging(null, null, null, null, this);
                }
            };
        }
        Object object1 = mutexLockUtilKt$withLockLogging$10.M;
        ne.a a1 = ne.a.a;
        switch(mutexLockUtilKt$withLockLogging$10.N) {
            case 0: {
                n.D(object1);
                Integer integer0 = object0 == null ? "" : new Integer(object0.hashCode());
                StringBuilder stringBuilder0 = l1.t("Lock[", "] ", " try : ", mutex0.hashCode(), integer0);
                stringBuilder0.append(s);
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                devLog0 = DevLog.Companion.get("MutexLockUtil");
                l1.C(l1.t("Lock[", "] ", " try : ", mutex0.hashCode(), integer0), s, devLog0);
                mutexLockUtilKt$withLockLogging$10.r = mutex0;
                mutexLockUtilKt$withLockLogging$10.w = s;
                a2 = a0;
                mutexLockUtilKt$withLockLogging$10.B = a2;
                mutexLockUtilKt$withLockLogging$10.D = integer0;
                mutexLockUtilKt$withLockLogging$10.E = devLog0;
                mutexLockUtilKt$withLockLogging$10.G = mutex0;
                mutexLockUtilKt$withLockLogging$10.I = object0;
                mutexLockUtilKt$withLockLogging$10.N = 1;
                if(mutex0.lock(object0, mutexLockUtilKt$withLockLogging$10) == a1) {
                    return a1;
                }
                mutex1 = mutex0;
                s1 = s;
                integer1 = integer0;
                object2 = object0;
                mutex2 = mutex1;
                break;
            }
            case 1: {
                Object object3 = mutexLockUtilKt$withLockLogging$10.I;
                mutex2 = mutexLockUtilKt$withLockLogging$10.G;
                DevLog devLog1 = mutexLockUtilKt$withLockLogging$10.E;
                integer1 = mutexLockUtilKt$withLockLogging$10.D;
                a2 = mutexLockUtilKt$withLockLogging$10.B;
                s1 = mutexLockUtilKt$withLockLogging$10.w;
                mutex1 = mutexLockUtilKt$withLockLogging$10.r;
                n.D(object1);
                devLog0 = devLog1;
                object2 = object3;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            v2 = System.currentTimeMillis();
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + integer1 + " Lock obtain : " + s1, null, false, 6, null);
            devLog0.put("Lock[" + mutex1.hashCode() + "] " + integer1 + " Lock obtain : " + s1);
            object4 = a2.invoke();
        }
        catch(Throwable throwable0) {
            long v3 = System.currentTimeMillis() - v2;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + integer1 + " Lock return : " + s1 + " (" + v3 + "ms)", null, false, 6, null);
            devLog0.put("Lock[" + mutex1.hashCode() + "] " + integer1 + " Lock return : " + s1 + " (" + v3 + "ms)");
            throw throwable0;
        }
        finally {
            mutex2.unlock(object2);
        }
        long v4 = System.currentTimeMillis() - v2;
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + integer1 + " Lock return : " + s1 + " (" + v4 + "ms)", null, false, 6, null);
        devLog0.put("Lock[" + mutex1.hashCode() + "] " + integer1 + " Lock return : " + s1 + " (" + v4 + "ms)");
        return object4;
    }

    public static Object withLockLogging$default(Mutex mutex0, Object object0, String s, a a0, Continuation continuation0, int v, Object object1) {
        Object object3;
        Object object2 = (v & 1) == 0 ? object0 : null;
        Integer integer0 = object2 == null ? "" : object2.hashCode();
        StringBuilder stringBuilder0 = l1.t("Lock[", "] ", " try : ", mutex0.hashCode(), integer0);
        stringBuilder0.append(s);
        MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
        DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
        l1.C(l1.t("Lock[", "] ", " try : ", mutex0.hashCode(), integer0), s, devLog0);
        mutex0.lock(object2, continuation0);
        try {
            long v2 = System.currentTimeMillis();
            try {
                LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex0.hashCode() + "] " + integer0 + " Lock obtain : " + s, null, false, 6, null);
                devLog0.put("Lock[" + mutex0.hashCode() + "] " + integer0 + " Lock obtain : " + s);
                object3 = a0.invoke();
            }
            catch(Throwable throwable0) {
                long v3 = System.currentTimeMillis() - v2;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex0.hashCode() + "] " + integer0 + " Lock return : " + s + " (" + v3 + "ms)", null, false, 6, null);
                devLog0.put("Lock[" + mutex0.hashCode() + "] " + integer0 + " Lock return : " + s + " (" + v3 + "ms)");
                throw throwable0;
            }
            long v4 = System.currentTimeMillis() - v2;
            LogU.debug$default(mutexLockUtil0.getLog(), "Lock[" + mutex0.hashCode() + "] " + integer0 + " Lock return : " + s + " (" + v4 + "ms)", null, false, 6, null);
            devLog0.put("Lock[" + mutex0.hashCode() + "] " + integer0 + " Lock return : " + s + " (" + v4 + "ms)");
            return object3;
        }
        finally {
            mutex0.unlock(object2);
        }
    }

    @Nullable
    public static final Object withLockLoggingAndProgress(@NotNull Mutex mutex0, @Nullable Object object0, @Nullable L0 l00, @NotNull String s, @NotNull a a0, @NotNull Continuation continuation0) {
        long v3;
        Mutex mutex2;
        Object object2;
        String s1;
        DevLog devLog1;
        Integer integer1;
        Mutex mutex1;
        a a2;
        L0 l01;
        com.iloen.melon.utils.MutexLockUtilKt.withLockLoggingAndProgress.1 mutexLockUtilKt$withLockLoggingAndProgress$10;
        if(continuation0 instanceof com.iloen.melon.utils.MutexLockUtilKt.withLockLoggingAndProgress.1) {
            mutexLockUtilKt$withLockLoggingAndProgress$10 = (com.iloen.melon.utils.MutexLockUtilKt.withLockLoggingAndProgress.1)continuation0;
            int v = mutexLockUtilKt$withLockLoggingAndProgress$10.S;
            if((v & 0x80000000) == 0) {
                mutexLockUtilKt$withLockLoggingAndProgress$10 = new c(continuation0) {  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
                    public String B;
                    public a D;
                    public Object E;
                    public DevLog G;
                    public Mutex I;
                    public Object M;
                    public Object N;
                    public int S;
                    public Mutex r;
                    public L0 w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.N = object0;
                        this.S |= 0x80000000;
                        return MutexLockUtilKt.withLockLoggingAndProgress(null, null, null, null, null, this);
                    }
                };
            }
            else {
                mutexLockUtilKt$withLockLoggingAndProgress$10.S = v ^ 0x80000000;
            }
        }
        else {
            mutexLockUtilKt$withLockLoggingAndProgress$10 = new c(continuation0) {  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
                public String B;
                public a D;
                public Object E;
                public DevLog G;
                public Mutex I;
                public Object M;
                public Object N;
                public int S;
                public Mutex r;
                public L0 w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.N = object0;
                    this.S |= 0x80000000;
                    return MutexLockUtilKt.withLockLoggingAndProgress(null, null, null, null, null, this);
                }
            };
        }
        Object object1 = mutexLockUtilKt$withLockLoggingAndProgress$10.N;
        ne.a a1 = ne.a.a;
        switch(mutexLockUtilKt$withLockLoggingAndProgress$10.S) {
            case 0: {
                n.D(object1);
                Integer integer0 = object0 == null ? "" : new Integer(object0.hashCode());
                StringBuilder stringBuilder0 = l1.t("Lock[", "] ", " try : ", mutex0.hashCode(), integer0);
                stringBuilder0.append(s);
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                l1.C(l1.t("Lock[", "] ", " try : ", mutex0.hashCode(), integer0), s, devLog0);
                mutexLockUtilKt$withLockLoggingAndProgress$10.r = mutex0;
                mutexLockUtilKt$withLockLoggingAndProgress$10.w = l00;
                mutexLockUtilKt$withLockLoggingAndProgress$10.B = s;
                mutexLockUtilKt$withLockLoggingAndProgress$10.D = a0;
                mutexLockUtilKt$withLockLoggingAndProgress$10.E = integer0;
                mutexLockUtilKt$withLockLoggingAndProgress$10.G = devLog0;
                mutexLockUtilKt$withLockLoggingAndProgress$10.I = mutex0;
                mutexLockUtilKt$withLockLoggingAndProgress$10.M = object0;
                mutexLockUtilKt$withLockLoggingAndProgress$10.S = 1;
                if(mutex0.lock(object0, mutexLockUtilKt$withLockLoggingAndProgress$10) == a1) {
                    return a1;
                }
                l01 = l00;
                a2 = a0;
                mutex1 = mutex0;
                integer1 = integer0;
                devLog1 = devLog0;
                s1 = s;
                object2 = object0;
                mutex2 = mutex1;
                break;
            }
            case 1: {
                Object object3 = mutexLockUtilKt$withLockLoggingAndProgress$10.M;
                mutex2 = mutexLockUtilKt$withLockLoggingAndProgress$10.I;
                DevLog devLog2 = mutexLockUtilKt$withLockLoggingAndProgress$10.G;
                integer1 = mutexLockUtilKt$withLockLoggingAndProgress$10.E;
                a2 = mutexLockUtilKt$withLockLoggingAndProgress$10.D;
                s1 = mutexLockUtilKt$withLockLoggingAndProgress$10.B;
                l01 = mutexLockUtilKt$withLockLoggingAndProgress$10.w;
                mutex1 = mutexLockUtilKt$withLockLoggingAndProgress$10.r;
                n.D(object1);
                devLog1 = devLog2;
                object2 = object3;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            try {
                v3 = System.currentTimeMillis();
                if(l01 != null) {
                    l01.a(integer1 + " " + s1, true);
                }
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + integer1 + " Lock obtain : " + s1, null, false, 6, null);
                devLog1.put("Lock[" + mutex1.hashCode() + "] " + integer1 + " Lock obtain : " + s1);
                return a2.invoke();
            }
            finally {
                long v4 = System.currentTimeMillis() - v3;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex1.hashCode() + "] " + integer1 + " Lock return : " + s1 + " (" + v4 + "ms)", null, false, 6, null);
                devLog1.put("Lock[" + mutex1.hashCode() + "] " + integer1 + " Lock return : " + s1 + " (" + v4 + "ms)");
                if(l01 != null) {
                    l01.a(integer1 + " " + s1, false);
                }
            }
        }
        finally {
            mutex2.unlock(object2);
        }
    }

    public static Object withLockLoggingAndProgress$default(Mutex mutex0, Object object0, L0 l00, String s, a a0, Continuation continuation0, int v, Object object1) {
        Object object3;
        long v3;
        MutexLockUtil mutexLockUtil1;
        Object object2 = (v & 1) == 0 ? object0 : null;
        Integer integer0 = object2 == null ? "" : object2.hashCode();
        MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
        StringBuilder stringBuilder0 = l1.t("Lock[", "] ", " try : ", mutex0.hashCode(), integer0);
        stringBuilder0.append(s);
        LogU.debug$default(mutexLockUtil0.getLog(), stringBuilder0.toString(), null, false, 6, null);
        DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
        l1.C(l1.t("Lock[", "] ", " try : ", mutex0.hashCode(), integer0), s, devLog0);
        mutex0.lock(object2, continuation0);
        try {
            long v2 = System.currentTimeMillis();
            try {
                if(l00 == null) {
                    mutexLockUtil1 = mutexLockUtil0;
                    v3 = v2;
                }
                else {
                    mutexLockUtil1 = mutexLockUtil0;
                    v3 = v2;
                    l00.a(integer0 + " " + s, true);
                }
                LogU.debug$default(mutexLockUtil1.getLog(), "Lock[" + mutex0.hashCode() + "] " + integer0 + " Lock obtain : " + s, null, false, 6, null);
                devLog0.put("Lock[" + mutex0.hashCode() + "] " + integer0 + " Lock obtain : " + s);
                object3 = a0.invoke();
                goto label_33;
            }
            catch(Throwable throwable0) {
            }
            long v4 = System.currentTimeMillis() - v3;
            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "Lock[" + mutex0.hashCode() + "] " + integer0 + " Lock return : " + s + " (" + v4 + "ms)", null, false, 6, null);
            devLog0.put("Lock[" + mutex0.hashCode() + "] " + integer0 + " Lock return : " + s + " (" + v4 + "ms)");
            if(l00 != null) {
                l00.a(integer0 + " " + s, false);
            }
            throw throwable0;
        label_33:
            long v5 = System.currentTimeMillis() - v3;
            LogU.debug$default(mutexLockUtil1.getLog(), "Lock[" + mutex0.hashCode() + "] " + integer0 + " Lock return : " + s + " (" + v5 + "ms)", null, false, 6, null);
            devLog0.put("Lock[" + mutex0.hashCode() + "] " + integer0 + " Lock return : " + s + " (" + v5 + "ms)");
            if(l00 != null) {
                l00.a(integer0 + " " + s, false);
            }
            return object3;
        }
        finally {
            mutex0.unlock(object2);
        }
    }

    @Nullable
    public static final Object withReentrantLockLogging(@NotNull Mutex mutex0, @Nullable Object object0, @NotNull String s, @NotNull k k0, @NotNull Continuation continuation0) {
        Mutex mutex2;
        Object object3;
        long v2;
        Integer integer2;
        DevLog devLog1;
        Integer integer1;
        long v1;
        com.iloen.melon.utils.MutexLockUtilKt.withReentrantLockLogging.1 mutexLockUtilKt$withReentrantLockLogging$10;
        Mutex mutex1 = mutex0;
        String s1 = s;
        if(continuation0 instanceof com.iloen.melon.utils.MutexLockUtilKt.withReentrantLockLogging.1) {
            mutexLockUtilKt$withReentrantLockLogging$10 = (com.iloen.melon.utils.MutexLockUtilKt.withReentrantLockLogging.1)continuation0;
            int v = mutexLockUtilKt$withReentrantLockLogging$10.I;
            if((v & 0x80000000) == 0) {
                mutexLockUtilKt$withReentrantLockLogging$10 = new c(continuation0) {  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
                    public Object B;
                    public DevLog D;
                    public long E;
                    public Object G;
                    public int I;
                    public Mutex r;
                    public String w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.G = object0;
                        this.I |= 0x80000000;
                        return MutexLockUtilKt.withReentrantLockLogging(null, null, null, null, this);
                    }
                };
            }
            else {
                mutexLockUtilKt$withReentrantLockLogging$10.I = v ^ 0x80000000;
            }
        }
        else {
            mutexLockUtilKt$withReentrantLockLogging$10 = new c(continuation0) {  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
                public Object B;
                public DevLog D;
                public long E;
                public Object G;
                public int I;
                public Mutex r;
                public String w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.G = object0;
                    this.I |= 0x80000000;
                    return MutexLockUtilKt.withReentrantLockLogging(null, null, null, null, this);
                }
            };
        }
        Object object1 = mutexLockUtilKt$withReentrantLockLogging$10.G;
        ne.a a0 = ne.a.a;
        switch(mutexLockUtilKt$withReentrantLockLogging$10.I) {
            case 0: {
                n.D(object1);
                Integer integer0 = object0 == null ? "" : new Integer(object0.hashCode());
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " try : ", mutex1.hashCode(), integer0);
                stringBuilder0.append(s1);
                LogU.debug$default(mutexLockUtil0.getLog(), stringBuilder0.toString(), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " try : ", mutex1.hashCode(), integer0);
                stringBuilder1.append(s1);
                devLog0.put(stringBuilder1.toString());
                ReentrantMutexContextKey reentrantMutexContextKey0 = new ReentrantMutexContextKey(mutex1);
                if(mutexLockUtilKt$withReentrantLockLogging$10.getContext().get(reentrantMutexContextKey0) != null) {
                    try {
                        v1 = System.currentTimeMillis();
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex1.hashCode() + "] " + integer0 + " Lock obtain : " + s1, null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex1.hashCode() + "] " + integer0 + " Lock obtain : " + s1);
                        mutexLockUtilKt$withReentrantLockLogging$10.r = mutex1;
                        mutexLockUtilKt$withReentrantLockLogging$10.w = s1;
                        mutexLockUtilKt$withReentrantLockLogging$10.B = integer0;
                        mutexLockUtilKt$withReentrantLockLogging$10.D = devLog0;
                        mutexLockUtilKt$withReentrantLockLogging$10.E = v1;
                        mutexLockUtilKt$withReentrantLockLogging$10.I = 1;
                        object1 = k0.invoke(mutexLockUtilKt$withReentrantLockLogging$10);
                    }
                    catch(Throwable throwable0) {
                        integer1 = integer0;
                        devLog1 = devLog0;
                        goto label_76;
                    }
                    if(object1 == a0) {
                        return a0;
                    }
                    integer2 = integer0;
                    devLog1 = devLog0;
                    break;
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                com.iloen.melon.utils.MutexLockUtilKt.withReentrantLockLogging..inlined.withReentrantLock.1 mutexLockUtilKt$withReentrantLockLogging$$inlined$withReentrantLock$10 = new we.n(mutex1, object0, null, mutex0, integer0, s1, devLog0, k0) {
                    public int B;
                    public int D;
                    public final Mutex E;
                    public final Object G;
                    public final Mutex I;
                    public final Object M;
                    public final String N;
                    public final DevLog S;
                    public final k T;
                    public long V;
                    public Mutex r;
                    public Object w;

                    {
                        this.E = mutex0;
                        this.G = object0;
                        this.I = mutex1;
                        this.M = object1;
                        this.N = s;
                        this.S = devLog0;
                        this.T = k0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.utils.MutexLockUtilKt.withReentrantLockLogging..inlined.withReentrantLock.1(this.E, this.G, continuation0, this.I, this.M, this.N, this.S, this.T);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.MutexLockUtilKt.withReentrantLockLogging..inlined.withReentrantLock.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        Object object5;
                        Object object3;
                        int v;
                        Mutex mutex2;
                        ne.a a0 = ne.a.a;
                        DevLog devLog0 = this.S;
                        String s = this.N;
                        Object object1 = this.M;
                        Mutex mutex0 = this.I;
                        switch(this.D) {
                            case 0: {
                                n.D(object0);
                                Mutex mutex1 = this.E;
                                this.r = mutex1;
                                Object object2 = this.G;
                                this.w = object2;
                                this.B = 0;
                                this.D = 1;
                                if(mutex1.lock(object2, this) == a0) {
                                    return a0;
                                }
                                mutex2 = mutex1;
                                v = 0;
                                object3 = object2;
                                goto label_25;
                            }
                            case 1: {
                                v = this.B;
                                Object object4 = this.w;
                                Mutex mutex3 = this.r;
                                n.D(object0);
                                object3 = object4;
                                mutex2 = mutex3;
                                try {
                                label_25:
                                    long v1 = System.currentTimeMillis();
                                    try {
                                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock obtain : " + s, null, false, 6, null);
                                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock obtain : " + s);
                                        this.r = mutex2;
                                        this.w = object3;
                                        this.B = v;
                                        this.V = v1;
                                        this.D = 2;
                                        object5 = this.T.invoke(this);
                                    }
                                    catch(Throwable throwable1) {
                                        goto label_49;
                                    }
                                    if(object5 == a0) {
                                        return a0;
                                    }
                                    long v2 = v1;
                                    goto label_53;
                                    try {
                                    label_41:
                                        v2 = this.V;
                                        object3 = this.w;
                                        mutex2 = this.r;
                                        n.D(object0);
                                        object5 = object0;
                                        goto label_53;
                                    }
                                    catch(Throwable throwable1) {
                                        v1 = v2;
                                    }
                                label_49:
                                    long v3 = System.currentTimeMillis() - v1;
                                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock return : " + s + " (" + v3 + "ms)", null, false, 6, null);
                                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock return : " + s + " (" + v3 + "ms)");
                                    throw throwable1;
                                label_53:
                                    long v4 = System.currentTimeMillis() - v2;
                                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock return : " + s + " (" + v4 + "ms)", null, false, 6, null);
                                    devLog0.put("ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock return : " + s + " (" + v4 + "ms)");
                                    goto label_60;
                                }
                                catch(Throwable throwable0) {
                                }
                                break;
                            }
                            case 2: {
                                goto label_41;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        mutex2.unlock(object3);
                        throw throwable0;
                    label_60:
                        mutex2.unlock(object3);
                        return object5;
                    }

                    public final Object invokeSuspend$$forInline(Object object0) {
                        Object object3;
                        DevLog devLog0 = this.S;
                        String s = this.N;
                        Object object1 = this.M;
                        Mutex mutex0 = this.I;
                        Mutex mutex1 = this.E;
                        Object object2 = this.G;
                        mutex1.lock(object2, this);
                        try {
                            long v1 = System.currentTimeMillis();
                            try {
                                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock obtain : " + s, null, false, 6, null);
                                devLog0.put("ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock obtain : " + s);
                                object3 = this.T.invoke(this);
                            }
                            catch(Throwable throwable0) {
                                long v2 = System.currentTimeMillis() - v1;
                                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock return : " + s + " (" + v2 + "ms)", null, false, 6, null);
                                devLog0.put("ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock return : " + s + " (" + v2 + "ms)");
                                throw throwable0;
                            }
                            long v3 = System.currentTimeMillis() - v1;
                            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock return : " + s + " (" + v3 + "ms)", null, false, 6, null);
                            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock return : " + s + " (" + v3 + "ms)");
                            return object3;
                        }
                        finally {
                            mutex1.unlock(object2);
                        }
                    }
                };
                mutexLockUtilKt$withReentrantLockLogging$10.r = null;
                mutexLockUtilKt$withReentrantLockLogging$10.w = null;
                mutexLockUtilKt$withReentrantLockLogging$10.B = null;
                mutexLockUtilKt$withReentrantLockLogging$10.D = null;
                mutexLockUtilKt$withReentrantLockLogging$10.I = 2;
                Object object2 = BuildersKt.withContext(reentrantMutexContextElement0, mutexLockUtilKt$withReentrantLockLogging$$inlined$withReentrantLock$10, mutexLockUtilKt$withReentrantLockLogging$10);
                return object2 == a0 ? a0 : object2;
            }
            case 1: {
                try {
                    v2 = mutexLockUtilKt$withReentrantLockLogging$10.E;
                    devLog1 = mutexLockUtilKt$withReentrantLockLogging$10.D;
                    object3 = mutexLockUtilKt$withReentrantLockLogging$10.B;
                    s1 = mutexLockUtilKt$withReentrantLockLogging$10.w;
                    mutex2 = mutexLockUtilKt$withReentrantLockLogging$10.r;
                    n.D(object1);
                    integer2 = object3;
                    v1 = v2;
                    mutex1 = mutex2;
                    break;
                }
                catch(Throwable throwable0) {
                    integer1 = object3;
                    v1 = v2;
                    mutex1 = mutex2;
                }
            label_76:
                long v3 = System.currentTimeMillis() - v1;
                StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), integer1);
                b.t(v3, s1, " (", stringBuilder2);
                stringBuilder2.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
                StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), integer1);
                b.t(v3, s1, " (", stringBuilder3);
                l1.C(stringBuilder3, "ms)", devLog1);
                throw throwable0;
            }
            case 2: {
                n.D(object1);
                return object1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v4 = System.currentTimeMillis() - v1;
        StringBuilder stringBuilder4 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), integer2);
        b.t(v4, s1, " (", stringBuilder4);
        stringBuilder4.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder4.toString(), null, false, 6, null);
        StringBuilder stringBuilder5 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), integer2);
        b.t(v4, s1, " (", stringBuilder5);
        l1.C(stringBuilder5, "ms)", devLog1);
        return object1;
    }

    public static Object withReentrantLockLogging$default(Mutex mutex0, Object object0, String s, k k0, Continuation continuation0, int v, Object object1) {
        if((v & 1) != 0) {
            object0 = null;
        }
        Integer integer0 = object0 == null ? "" : object0.hashCode();
        StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " try : ", mutex0.hashCode(), integer0);
        stringBuilder0.append(s);
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
        DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
        StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " try : ", mutex0.hashCode(), integer0);
        stringBuilder1.append(s);
        devLog0.put(stringBuilder1.toString());
        new ReentrantMutexContextKey(mutex0);
        throw null;
    }

    @Nullable
    public static final Object withReentrantLockLoggingAndProgress(@NotNull Mutex mutex0, @Nullable Object object0, @NotNull String s, @Nullable L0 l00, @NotNull k k0, @NotNull Continuation continuation0) {
        String s2;
        L0 l02;
        Object object3;
        long v2;
        Integer integer2;
        Mutex mutex2;
        DevLog devLog1;
        Integer integer1;
        long v1;
        com.iloen.melon.utils.MutexLockUtilKt.withReentrantLockLoggingAndProgress.1 mutexLockUtilKt$withReentrantLockLoggingAndProgress$10;
        Mutex mutex1 = mutex0;
        String s1 = s;
        L0 l01 = l00;
        if(continuation0 instanceof com.iloen.melon.utils.MutexLockUtilKt.withReentrantLockLoggingAndProgress.1) {
            mutexLockUtilKt$withReentrantLockLoggingAndProgress$10 = (com.iloen.melon.utils.MutexLockUtilKt.withReentrantLockLoggingAndProgress.1)continuation0;
            int v = mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.M;
            if((v & 0x80000000) == 0) {
                mutexLockUtilKt$withReentrantLockLoggingAndProgress$10 = new c(continuation0) {  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
                    public L0 B;
                    public Object D;
                    public DevLog E;
                    public long G;
                    public Object I;
                    public int M;
                    public Mutex r;
                    public String w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.I = object0;
                        this.M |= 0x80000000;
                        return MutexLockUtilKt.withReentrantLockLoggingAndProgress(null, null, null, null, null, this);
                    }
                };
            }
            else {
                mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.M = v ^ 0x80000000;
            }
        }
        else {
            mutexLockUtilKt$withReentrantLockLoggingAndProgress$10 = new c(continuation0) {  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
                public L0 B;
                public Object D;
                public DevLog E;
                public long G;
                public Object I;
                public int M;
                public Mutex r;
                public String w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.I = object0;
                    this.M |= 0x80000000;
                    return MutexLockUtilKt.withReentrantLockLoggingAndProgress(null, null, null, null, null, this);
                }
            };
        }
        Object object1 = mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.I;
        ne.a a0 = ne.a.a;
        switch(mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.M) {
            case 0: {
                n.D(object1);
                Integer integer0 = object0 == null ? "" : new Integer(object0.hashCode());
                StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " try : ", mutex1.hashCode(), integer0);
                stringBuilder0.append(s1);
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " try : ", mutex1.hashCode(), integer0);
                stringBuilder1.append(s1);
                devLog0.put(stringBuilder1.toString());
                ReentrantMutexContextKey reentrantMutexContextKey0 = new ReentrantMutexContextKey(mutex1);
                if(mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.getContext().get(reentrantMutexContextKey0) != null) {
                    try {
                        v1 = System.currentTimeMillis();
                        if(l01 != null) {
                            l01.a(integer0 + " " + s1, true);
                        }
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex1.hashCode() + "] " + integer0 + " Lock obtain : " + s1, null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex1.hashCode() + "] " + integer0 + " Lock obtain : " + s1);
                        mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.r = mutex1;
                        mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.w = s1;
                        mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.B = l01;
                        mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.D = integer0;
                        mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.E = devLog0;
                        mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.G = v1;
                        mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.M = 1;
                        object1 = k0.invoke(mutexLockUtilKt$withReentrantLockLoggingAndProgress$10);
                    }
                    catch(Throwable throwable0) {
                        integer1 = integer0;
                        devLog1 = devLog0;
                        goto label_86;
                    }
                    if(object1 == a0) {
                        return a0;
                    }
                    mutex2 = mutex1;
                    integer2 = integer0;
                    v2 = v1;
                    devLog1 = devLog0;
                    break;
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                com.iloen.melon.utils.MutexLockUtilKt.withReentrantLockLoggingAndProgress..inlined.withReentrantLock.1 mutexLockUtilKt$withReentrantLockLoggingAndProgress$$inlined$withReentrantLock$10 = new we.n(mutex1, object0, null, l01, integer0, s1, mutex0, devLog0, k0) {
                    public int B;
                    public int D;
                    public final Mutex E;
                    public final Object G;
                    public final L0 I;
                    public final Object M;
                    public final String N;
                    public final Mutex S;
                    public final DevLog T;
                    public final k V;
                    public long W;
                    public Mutex r;
                    public Object w;

                    {
                        this.E = mutex0;
                        this.G = object0;
                        this.I = l00;
                        this.M = object1;
                        this.N = s;
                        this.S = mutex1;
                        this.T = devLog0;
                        this.V = k0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.utils.MutexLockUtilKt.withReentrantLockLoggingAndProgress..inlined.withReentrantLock.1(this.E, this.G, continuation0, this.I, this.M, this.N, this.S, this.T, this.V);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.MutexLockUtilKt.withReentrantLockLoggingAndProgress..inlined.withReentrantLock.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        long v3;
                        Mutex mutex3;
                        long v2;
                        Mutex mutex2;
                        Object object3;
                        Mutex mutex1;
                        long v1;
                        Object object2;
                        int v4;
                        ne.a a0 = ne.a.a;
                        int v = this.D;
                        DevLog devLog0 = this.T;
                        L0 l00 = this.I;
                        Mutex mutex0 = this.S;
                        String s = this.N;
                        Object object1 = this.M;
                        switch(v) {
                            case 0: {
                                n.D(object0);
                                mutex3 = this.E;
                                this.r = mutex3;
                                object2 = this.G;
                                this.w = object2;
                                this.B = 0;
                                this.D = 1;
                                if(mutex3.lock(object2, this) == a0) {
                                    return a0;
                                }
                                v4 = 0;
                                break;
                            }
                            case 1: {
                                object2 = this.w;
                                int v5 = this.B;
                                mutex3 = this.r;
                                n.D(object0);
                                v4 = v5;
                                break;
                            }
                            default: {
                                if(v == 2) {
                                    try {
                                        object2 = this.w;
                                        v1 = this.W;
                                        mutex1 = this.r;
                                        n.D(object0);
                                        object3 = object0;
                                        mutex2 = mutex1;
                                        v2 = v1;
                                        goto label_62;
                                    }
                                    catch(Throwable throwable0) {
                                        mutex3 = mutex1;
                                        v3 = v1;
                                        goto label_50;
                                    }
                                }
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        try {
                            v3 = System.currentTimeMillis();
                            if(l00 != null) {
                                goto label_39;
                            }
                            goto label_40;
                        }
                        catch(Throwable throwable1) {
                            mutex3.unlock(object2);
                            throw throwable1;
                        }
                        try {
                        label_39:
                            l00.a(object1 + " " + s, true);
                        label_40:
                            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock obtain : " + s, null, false, 6, null);
                            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock obtain : " + s);
                            this.r = mutex3;
                            this.w = object2;
                            this.B = v4;
                            this.W = v3;
                            this.D = 2;
                            object3 = this.V.invoke(this);
                            goto label_58;
                        }
                        catch(Throwable throwable0) {
                        }
                        try {
                        label_50:
                            long v6 = System.currentTimeMillis() - v3;
                            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock return : " + s + " (" + v6 + "ms)", null, false, 6, null);
                            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock return : " + s + " (" + v6 + "ms)");
                            if(l00 != null) {
                                l00.a(object1 + " " + s, false);
                            }
                            throw throwable0;
                        }
                        catch(Throwable throwable1) {
                        }
                        mutex3.unlock(object2);
                        throw throwable1;
                    label_58:
                        if(object3 == a0) {
                            return a0;
                        }
                        mutex2 = mutex3;
                        v2 = v3;
                        try {
                        label_62:
                            long v7 = System.currentTimeMillis() - v2;
                            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock return : " + s + " (" + v7 + "ms)", null, false, 6, null);
                            devLog0.put("ReentrantLock[" + mutex0.hashCode() + "] " + object1 + " Lock return : " + s + " (" + v7 + "ms)");
                            if(l00 != null) {
                                l00.a(object1 + " " + s, false);
                            }
                        }
                        catch(Throwable throwable1) {
                            mutex3 = mutex2;
                            mutex3.unlock(object2);
                            throw throwable1;
                        }
                        mutex2.unlock(object2);
                        return object3;
                    }

                    public final Object invokeSuspend$$forInline(Object object0) {
                        Object object2;
                        String s;
                        Mutex mutex1;
                        L0 l00;
                        DevLog devLog0;
                        long v2;
                        Mutex mutex0 = this.E;
                        Object object1 = this.G;
                        mutex0.lock(object1, this);
                        try {
                            try {
                                v2 = System.currentTimeMillis();
                                devLog0 = this.T;
                                l00 = this.I;
                                mutex1 = this.S;
                                s = this.N;
                                object2 = this.M;
                                if(l00 != null) {
                                    l00.a(object2 + " " + s, true);
                                }
                                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex1.hashCode() + "] " + object2 + " Lock obtain : " + s, null, false, 6, null);
                                devLog0.put("ReentrantLock[" + mutex1.hashCode() + "] " + object2 + " Lock obtain : " + s);
                                return this.V.invoke(this);
                            }
                            finally {
                                long v3 = System.currentTimeMillis() - v2;
                                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + mutex1.hashCode() + "] " + object2 + " Lock return : " + s + " (" + v3 + "ms)", null, false, 6, null);
                                devLog0.put("ReentrantLock[" + mutex1.hashCode() + "] " + object2 + " Lock return : " + s + " (" + v3 + "ms)");
                                if(l00 != null) {
                                    l00.a(object2 + " " + s, false);
                                }
                            }
                        }
                        finally {
                            mutex0.unlock(object1);
                        }
                    }
                };
                mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.r = null;
                mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.w = null;
                mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.B = null;
                mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.D = null;
                mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.E = null;
                mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.M = 2;
                Object object2 = BuildersKt.withContext(reentrantMutexContextElement0, mutexLockUtilKt$withReentrantLockLoggingAndProgress$$inlined$withReentrantLock$10, mutexLockUtilKt$withReentrantLockLoggingAndProgress$10);
                return object2 == a0 ? a0 : object2;
            }
            case 1: {
                try {
                    v2 = mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.G;
                    devLog1 = mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.E;
                    object3 = mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.D;
                    l02 = mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.B;
                    s2 = mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.w;
                    mutex2 = mutexLockUtilKt$withReentrantLockLoggingAndProgress$10.r;
                    n.D(object1);
                    integer2 = object3;
                    l01 = l02;
                    s1 = s2;
                    break;
                }
                catch(Throwable throwable0) {
                    integer1 = object3;
                    l01 = l02;
                    s1 = s2;
                    v1 = v2;
                    mutex1 = mutex2;
                }
            label_86:
                long v3 = System.currentTimeMillis() - v1;
                StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), integer1);
                b.t(v3, s1, " (", stringBuilder2);
                stringBuilder2.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
                StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), integer1);
                b.t(v3, s1, " (", stringBuilder3);
                l1.C(stringBuilder3, "ms)", devLog1);
                if(l01 != null) {
                    com.iloen.melon.utils.a.u(integer1, " ", s1, l01, false);
                }
                throw throwable0;
            }
            case 2: {
                n.D(object1);
                return object1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v4 = System.currentTimeMillis() - v2;
        StringBuilder stringBuilder4 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), integer2);
        b.t(v4, s1, " (", stringBuilder4);
        stringBuilder4.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder4.toString(), null, false, 6, null);
        StringBuilder stringBuilder5 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), integer2);
        b.t(v4, s1, " (", stringBuilder5);
        l1.C(stringBuilder5, "ms)", devLog1);
        if(l01 != null) {
            com.iloen.melon.utils.a.u(integer2, " ", s1, l01, false);
        }
        return object1;
    }

    public static Object withReentrantLockLoggingAndProgress$default(Mutex mutex0, Object object0, String s, L0 l00, k k0, Continuation continuation0, int v, Object object1) {
        if((v & 1) != 0) {
            object0 = null;
        }
        Integer integer0 = object0 == null ? "" : object0.hashCode();
        StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " try : ", mutex0.hashCode(), integer0);
        stringBuilder0.append(s);
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
        DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
        StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " try : ", mutex0.hashCode(), integer0);
        stringBuilder1.append(s);
        devLog0.put(stringBuilder1.toString());
        new ReentrantMutexContextKey(mutex0);
        throw null;
    }
}

