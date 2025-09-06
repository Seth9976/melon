package androidx.appcompat.app;

import android.content.Context;
import com.iloen.melon.Hilt_MusicBrowserActivity;
import com.iloen.melon.activity.Hilt_BaseActivity;
import com.iloen.melon.activity.Hilt_CoverScreenActivity;
import com.iloen.melon.activity.Hilt_MelonAppSvcActivity;
import com.iloen.melon.activity.Hilt_PermissionSupportActivity;
import d.b;

public final class h implements b {
    public final int a;
    public final AppCompatActivity b;

    public h(AppCompatActivity appCompatActivity0, int v) {
        this.a = v;
        this.b = appCompatActivity0;
        super();
    }

    @Override  // d.b
    public final void onContextAvailable(Context context0) {
        switch(this.a) {
            case 0: {
                n n0 = this.b.getDelegate();
                n0.a();
                this.b.getSavedStateRegistry().a("androidx:appcompat");
                n0.e();
                return;
            }
            case 1: {
                ((Hilt_MusicBrowserActivity)this.b).inject();
                return;
            }
            case 2: {
                ((Hilt_BaseActivity)this.b).inject();
                return;
            }
            case 3: {
                ((Hilt_CoverScreenActivity)this.b).inject();
                return;
            }
            case 4: {
                ((Hilt_MelonAppSvcActivity)this.b).inject();
                return;
            }
            default: {
                ((Hilt_PermissionSupportActivity)this.b).inject();
            }
        }
    }
}

