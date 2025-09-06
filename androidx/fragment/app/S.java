package androidx.fragment.app;

import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface;

public final class s implements DialogInterface.OnCancelListener {
    public final w a;

    public s(w w0) {
        this.a = w0;
    }

    @Override  // android.content.DialogInterface$OnCancelListener
    public final void onCancel(DialogInterface dialogInterface0) {
        w w0 = this.a;
        if(w0.mDialog != null) {
            w0.onCancel(w0.mDialog);
        }
    }
}

