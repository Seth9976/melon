package androidx.compose.ui.tooling;

import B2.p;
import I.L0;
import Tf.o;
import U4.x;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;
import c.c;
import e1.u;
import kotlin.Metadata;
import m0.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\'\u0010\f\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/tooling/PreviewActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "", "composableFqn", "Lie/H;", "setComposableContent", "(Ljava/lang/String;)V", "className", "methodName", "parameterProvider", "setParameterizedContent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "TAG", "Ljava/lang/String;", "ui-tooling_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class PreviewActivity extends ComponentActivity {
    public static final int $stable;
    @NotNull
    private final String TAG;

    public PreviewActivity() {
        this.TAG = "PreviewActivity";
    }

    @Override  // androidx.activity.ComponentActivity
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        if((this.getApplicationInfo().flags & 2) == 0) {
            Log.d(this.TAG, "Application is not debuggable. Compose Preview not allowed.");
            this.finish();
            return;
        }
        Intent intent0 = this.getIntent();
        if(intent0 != null) {
            String s = intent0.getStringExtra("composable");
            if(s != null) {
                this.setComposableContent(s);
            }
        }
    }

    private final void setComposableContent(String s) {
        x.w("PreviewActivity has composable ", s, this.TAG);
        String s1 = o.c1('.', s, s);
        String s2 = o.Y0('.', s, s);
        String s3 = this.getIntent().getStringExtra("parameterProviderClassName");
        if(s3 != null) {
            this.setParameterizedContent(s1, s2, s3);
            return;
        }
        Log.d(this.TAG, "Previewing \'" + s2 + "\' without a parameter provider.");
        c.a(this, new b(0xCDE50CFC, new p(23, s1, s2), true));
    }

    private final void setParameterizedContent(String s, String s1, String s2) {
        Log.d(this.TAG, "Previewing \'" + s1 + "\' with parameter provider: \'" + s2 + '\'');
        Class class0 = u.n(s2);
        c.a(this, new b(-1901447514, new L0(s, s1, u.x(this.getIntent().getIntExtra("parameterProviderIndex", -1), class0), 6), true));
    }
}

