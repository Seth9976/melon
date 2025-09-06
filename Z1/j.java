package Z1;

import android.os.Process;

public final class j extends Thread {
    public final int a;

    public j(Runnable runnable0) {
        super(runnable0, "fonts-androidx");
        this.a = 10;
    }

    @Override
    public final void run() {
        Process.setThreadPriority(this.a);
        super.run();
    }
}

