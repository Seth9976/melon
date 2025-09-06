package vd;

import android.content.Context;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface;
import android.view.KeyEvent;
import com.iloen.melon.utils.system.VolumeUtils;

public final class u implements DialogInterface.OnKeyListener {
    public final v a;

    public u(v v0) {
        this.a = v0;
    }

    @Override  // android.content.DialogInterface$OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface0, int v, KeyEvent keyEvent0) {
        v v1 = this.a;
        switch(v) {
            case 24: {
                Context context0 = v1.getContext();
                return VolumeUtils.Companion.shouldConsumeVolumeUpEvent(context0);
            }
            case 25: {
                Context context1 = v1.getContext();
                return VolumeUtils.Companion.shouldConsumeVolumeDownEvent(context1);
            }
            default: {
                return false;
            }
        }
    }
}

