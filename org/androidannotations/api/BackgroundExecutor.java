package org.androidannotations.api;

import A7.d;
import U4.x;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class BackgroundExecutor {
    public static abstract class Task implements Runnable {
        private boolean executionAsked;
        private Future future;
        private String id;
        private AtomicBoolean managed;
        private long remainingDelay;
        private String serial;
        private long targetTimeMillis;

        public Task(String s, long v, String s1) {
            this.managed = new AtomicBoolean();
            if(!"".equals(s)) {
                this.id = s;
            }
            if(v > 0L) {
                this.remainingDelay = v;
                this.targetTimeMillis = SystemClock.elapsedRealtime() + v;
            }
            if(!"".equals(s1)) {
                this.serial = s1;
            }
        }

        public static String access$000(Task backgroundExecutor$Task0) {
            return backgroundExecutor$Task0.id;
        }

        public static String access$100(Task backgroundExecutor$Task0) {
            return backgroundExecutor$Task0.serial;
        }

        public static boolean access$200(Task backgroundExecutor$Task0) {
            return backgroundExecutor$Task0.executionAsked;
        }

        public static boolean access$202(Task backgroundExecutor$Task0, boolean z) {
            backgroundExecutor$Task0.executionAsked = z;
            return z;
        }

        public static Future access$300(Task backgroundExecutor$Task0) {
            return backgroundExecutor$Task0.future;
        }

        public static Future access$302(Task backgroundExecutor$Task0, Future future0) {
            backgroundExecutor$Task0.future = future0;
            return future0;
        }

        public static long access$400(Task backgroundExecutor$Task0) {
            return backgroundExecutor$Task0.remainingDelay;
        }

        public static AtomicBoolean access$500(Task backgroundExecutor$Task0) {
            return backgroundExecutor$Task0.managed;
        }

        public static void access$600(Task backgroundExecutor$Task0) {
            backgroundExecutor$Task0.postExecute();
        }

        public abstract void execute();

        private void postExecute() {
            if(this.id == null && this.serial == null) {
                return;
            }
            BackgroundExecutor.CURRENT_SERIAL.set(null);
            synchronized(BackgroundExecutor.class) {
                BackgroundExecutor.TASKS.remove(this);
                String s = this.serial;
                if(s != null) {
                    Task backgroundExecutor$Task0 = BackgroundExecutor.take(s);
                    if(backgroundExecutor$Task0 != null) {
                        if(backgroundExecutor$Task0.remainingDelay != 0L) {
                            backgroundExecutor$Task0.remainingDelay = Math.max(0L, backgroundExecutor$Task0.targetTimeMillis - SystemClock.elapsedRealtime());
                        }
                        BackgroundExecutor.execute(backgroundExecutor$Task0);
                    }
                }
            }
        }

        @Override
        public void run() {
            if(this.managed.getAndSet(true)) {
                return;
            }
            try {
                BackgroundExecutor.CURRENT_SERIAL.set(this.serial);
                this.execute();
            }
            finally {
                this.postExecute();
            }
        }
    }

    public interface WrongThreadListener {
        void onBgExpected(String[] arg1);

        void onUiExpected();

        void onWrongBgSerial(String arg1, String[] arg2);
    }

    private static final ThreadLocal CURRENT_SERIAL = null;
    public static final Executor DEFAULT_EXECUTOR = null;
    public static final WrongThreadListener DEFAULT_WRONG_THREAD_LISTENER = null;
    private static final String TAG = "BackgroundExecutor";
    private static final List TASKS;
    private static Executor executor;
    private static WrongThreadListener wrongThreadListener;

    static {
        ScheduledExecutorService scheduledExecutorService0 = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        BackgroundExecutor.DEFAULT_EXECUTOR = scheduledExecutorService0;
        BackgroundExecutor.executor = scheduledExecutorService0;
        org.androidannotations.api.BackgroundExecutor.1 backgroundExecutor$10 = new WrongThreadListener() {
            @Override  // org.androidannotations.api.BackgroundExecutor$WrongThreadListener
            public void onBgExpected(String[] arr_s) {
                throw arr_s.length == 0 ? new IllegalStateException("Method invocation is expected from a background thread, but it was called from the UI thread") : new IllegalStateException(x.m(new StringBuilder("Method invocation is expected from one of serials "), Arrays.toString(arr_s), ", but it was called from the UI thread"));
            }

            @Override  // org.androidannotations.api.BackgroundExecutor$WrongThreadListener
            public void onUiExpected() {
                throw new IllegalStateException("Method invocation is expected from the UI thread");
            }

            @Override  // org.androidannotations.api.BackgroundExecutor$WrongThreadListener
            public void onWrongBgSerial(String s, String[] arr_s) {
                if(s == null) {
                    s = "anonymous";
                }
                throw new IllegalStateException(d.n(new StringBuilder("Method invocation is expected from one of serials "), Arrays.toString(arr_s), ", but it was called from ", s, " serial"));
            }
        };
        BackgroundExecutor.DEFAULT_WRONG_THREAD_LISTENER = backgroundExecutor$10;
        BackgroundExecutor.wrongThreadListener = backgroundExecutor$10;
        BackgroundExecutor.TASKS = new ArrayList();
        BackgroundExecutor.CURRENT_SERIAL = new ThreadLocal();
    }

    public static void cancelAll(String s, boolean z) {
        synchronized(BackgroundExecutor.class) {
            for(int v1 = BackgroundExecutor.TASKS.size() - 1; v1 >= 0; --v1) {
                List list0 = BackgroundExecutor.TASKS;
                Task backgroundExecutor$Task0 = (Task)list0.get(v1);
                if(s.equals(Task.access$000(backgroundExecutor$Task0))) {
                    if(Task.access$300(backgroundExecutor$Task0) != null) {
                        Task.access$300(backgroundExecutor$Task0).cancel(z);
                        if(!Task.access$500(backgroundExecutor$Task0).getAndSet(true)) {
                            Task.access$600(backgroundExecutor$Task0);
                        }
                    }
                    else if(Task.access$200(backgroundExecutor$Task0)) {
                        Log.w("BackgroundExecutor", "A task with id " + Task.access$000(backgroundExecutor$Task0) + " cannot be cancelled (the executor set does not support it)");
                    }
                    else {
                        list0.remove(v1);
                    }
                }
            }
        }
    }

    public static void checkBgThread(String[] arr_s) {
        if(arr_s.length == 0) {
            if(Looper.getMainLooper().getThread() != Thread.currentThread()) {
                return;
            }
            BackgroundExecutor.wrongThreadListener.onBgExpected(arr_s);
            return;
        }
        String s = (String)BackgroundExecutor.CURRENT_SERIAL.get();
        if(s == null) {
            BackgroundExecutor.wrongThreadListener.onWrongBgSerial(null, arr_s);
            return;
        }
        for(int v = 0; v < arr_s.length; ++v) {
            if(arr_s[v].equals(s)) {
                return;
            }
        }
        BackgroundExecutor.wrongThreadListener.onWrongBgSerial(s, arr_s);
    }

    public static void checkUiThread() {
        if(Looper.getMainLooper().getThread() != Thread.currentThread()) {
            BackgroundExecutor.wrongThreadListener.onUiExpected();
        }
    }

    private static Future directExecute(Runnable runnable0, long v) {
        if(v > 0L) {
            Executor executor0 = BackgroundExecutor.executor;
            if(!(executor0 instanceof ScheduledExecutorService)) {
                throw new IllegalArgumentException("The executor set does not support scheduling");
            }
            return ((ScheduledExecutorService)executor0).schedule(runnable0, v, TimeUnit.MILLISECONDS);
        }
        Executor executor1 = BackgroundExecutor.executor;
        if(executor1 instanceof ExecutorService) {
            return ((ExecutorService)executor1).submit(runnable0);
        }
        executor1.execute(runnable0);
        return null;
    }

    public static void execute(Runnable runnable0) {
        BackgroundExecutor.directExecute(runnable0, 0L);
    }

    public static void execute(Runnable runnable0, long v) {
        BackgroundExecutor.directExecute(runnable0, v);
    }

    public static void execute(Runnable runnable0, String s, long v, String s1) {
        BackgroundExecutor.execute(new Task(s, v, s1) {
            @Override  // org.androidannotations.api.BackgroundExecutor$Task
            public void execute() {
                runnable0.run();
            }
        });
    }

    public static void execute(Runnable runnable0, String s, String s1) {
        BackgroundExecutor.execute(runnable0, s, 0L, s1);
    }

    public static void execute(Task backgroundExecutor$Task0) {
        synchronized(BackgroundExecutor.class) {
            if(Task.access$000(backgroundExecutor$Task0) != null || Task.access$100(backgroundExecutor$Task0) != null) {
                BackgroundExecutor.TASKS.add(backgroundExecutor$Task0);
            }
            if(Task.access$100(backgroundExecutor$Task0) == null || !BackgroundExecutor.hasSerialRunning(Task.access$100(backgroundExecutor$Task0))) {
                Task.access$202(backgroundExecutor$Task0, true);
                Task.access$302(backgroundExecutor$Task0, BackgroundExecutor.directExecute(backgroundExecutor$Task0, Task.access$400(backgroundExecutor$Task0)));
            }
        }
    }

    private static boolean hasSerialRunning(String s) {
        for(Object object0: BackgroundExecutor.TASKS) {
            if(Task.access$200(((Task)object0)) && s.equals(Task.access$100(((Task)object0)))) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public static void setExecutor(Executor executor0) {
        BackgroundExecutor.executor = executor0;
    }

    public static void setWrongThreadListener(WrongThreadListener backgroundExecutor$WrongThreadListener0) {
        BackgroundExecutor.wrongThreadListener = backgroundExecutor$WrongThreadListener0;
    }

    private static Task take(String s) {
        int v = BackgroundExecutor.TASKS.size();
        for(int v1 = 0; v1 < v; ++v1) {
            List list0 = BackgroundExecutor.TASKS;
            if(s.equals(Task.access$100(((Task)list0.get(v1))))) {
                return (Task)list0.remove(v1);
            }
        }
        return null;
    }
}

