package x2;

import android.os.Handler;
import android.widget.EditText;
import java.lang.ref.WeakReference;
import v2.f;

public final class h extends f implements Runnable {
    public final WeakReference a;

    public h(EditText editText0) {
        this.a = new WeakReference(editText0);
    }

    @Override  // v2.f
    public final void b() {
        EditText editText0 = (EditText)this.a.get();
        if(editText0 != null) {
            Handler handler0 = editText0.getHandler();
            if(handler0 != null) {
                handler0.post(this);
            }
        }
    }

    @Override
    public final void run() {
        i.a(((EditText)this.a.get()), 1);
    }
}

