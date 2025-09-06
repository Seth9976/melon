package p;

import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsCallback;
import androidx.browser.customtabs.CustomTabsService;
import java.util.NoSuchElementException;

public final class h implements IBinder.DeathRecipient {
    public final i a;
    public final m b;

    public h(i i0, m m0) {
        this.a = i0;
        this.b = m0;
    }

    @Override  // android.os.IBinder$DeathRecipient
    public final void binderDied() {
        CustomTabsService customTabsService0 = this.a.a;
        customTabsService0.getClass();
        try {
            synchronized(customTabsService0.a) {
                ICustomTabsCallback iCustomTabsCallback0 = this.b.a;
                IBinder iBinder0 = iCustomTabsCallback0 == null ? null : iCustomTabsCallback0.asBinder();
                if(iBinder0 == null) {
                    return;
                }
                iBinder0.unlinkToDeath(((IBinder.DeathRecipient)customTabsService0.a.get(iBinder0)), 0);
                customTabsService0.a.remove(iBinder0);
            }
        }
        catch(NoSuchElementException unused_ex) {
        }
    }
}

