package com.iloen.melon.task;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {
    public final int a;

    public PriorityThreadFactory(int v) {
        this.a = v;
    }

    @Override
    public Thread newThread(Runnable runnable0) {
        return new Thread(new Runnable() {
            public final Runnable a;
            public final PriorityThreadFactory b;

            {
                Runnable runnable0 = runnable0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.b = priorityThreadFactory0;
                this.a = runnable0;
            }

            @Override
            public void run() {
                try {
                    Process.setThreadPriority(this.b.a);
                }
                catch(Throwable unused_ex) {
                }
                this.a.run();
            }
        });
    }
}

