package androidx.glance.appwidget.action;

import E2.k;
import android.app.Activity;
import android.os.Bundle;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/glance/appwidget/action/InvisibleActionTrampolineActivity;", "Landroid/app/Activity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "glance-appwidget_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InvisibleActionTrampolineActivity extends Activity {
    public static final int $stable;

    @Override  // android.app.Activity
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        k.h(this, this.getIntent());
    }
}

