package androidx.fragment.app;

import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;

public final class t implements DialogInterface.OnDismissListener {
    public final w a;

    public t(w w0) {
        this.a = w0;
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface0) {
        w w0 = this.a;
        if(w0.mDialog != null) {
            w0.onDismiss(w0.mDialog);
        }
    }
}

