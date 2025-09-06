package o;

import android.util.Log;
import java.util.concurrent.ArrayBlockingQueue;

public final class b extends Thread {
    public ArrayBlockingQueue a;
    public static final int b;

    static {
        b b0 = new b();  // 初始化器: Ljava/lang/Thread;-><init>()V
        b0.a = new ArrayBlockingQueue(10);
        b0.start();
    }

    @Override
    public final void run() {
        while(true) {
            try {
                if(this.a.take() != null) {
                    throw new ClassCastException();
                }
                break;
            }
            catch(InterruptedException interruptedException0) {
                Log.w("AsyncLayoutInflater", interruptedException0);
            }
        }
        try {
        }
        catch(RuntimeException runtimeException0) {
            Log.w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", runtimeException0);
        }
        throw null;
    }
}

