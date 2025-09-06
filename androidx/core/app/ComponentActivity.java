package androidx.core.app;

import De.I;
import N1.g;
import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.collection.V;
import androidx.lifecycle.D;
import androidx.lifecycle.F;
import androidx.lifecycle.Z;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import c2.l;
import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\n\u001A\u00020\t2\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\fH\u0017¢\u0006\u0004\b\u000F\u0010\u0010J\u0019\u0010\u0013\u001A\u00020\u000E2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001A\u00020\u000E2\u0006\u0010\u0015\u001A\u00020\u0011H\u0015¢\u0006\u0004\b\u0016\u0010\u0014J)\u0010\u001A\u001A\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0017*\u00020\f2\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0017¢\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001E\u001A\u00020\t2\u0006\u0010\u001D\u001A\u00020\u001CH\u0017¢\u0006\u0004\b\u001E\u0010\u001FJ\u0017\u0010 \u001A\u00020\t2\u0006\u0010\u001D\u001A\u00020\u001CH\u0016¢\u0006\u0004\b \u0010\u001FJ\u0017\u0010!\u001A\u00020\t2\u0006\u0010\u001D\u001A\u00020\u001CH\u0016¢\u0006\u0004\b!\u0010\u001FJ\u001F\u0010\"\u001A\u00020\t2\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0004¢\u0006\u0004\b\"\u0010\u000BR.\u0010$\u001A\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0018\u0012\u0004\u0012\u00020\f0#8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b$\u0010%\u0012\u0004\b&\u0010\u0005R\u001A\u0010(\u001A\u00020\'8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b(\u0010)\u0012\u0004\b*\u0010\u0005R\u0014\u0010.\u001A\u00020+8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b,\u0010-¨\u0006/"}, d2 = {"Landroidx/core/app/ComponentActivity;", "Landroid/app/Activity;", "Landroidx/lifecycle/D;", "Lc2/l;", "<init>", "()V", "", "", "args", "", "shouldSkipDump", "([Ljava/lang/String;)Z", "LN1/g;", "extraData", "Lie/H;", "putExtraData", "(LN1/g;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "T", "Ljava/lang/Class;", "extraDataClass", "getExtraData", "(Ljava/lang/Class;)LN1/g;", "Landroid/view/KeyEvent;", "event", "superDispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "dispatchKeyShortcutEvent", "dispatchKeyEvent", "shouldDumpInternalState", "Landroidx/collection/V;", "extraDataMap", "Landroidx/collection/V;", "getExtraDataMap$annotations", "Landroidx/lifecycle/F;", "lifecycleRegistry", "Landroidx/lifecycle/F;", "getLifecycleRegistry$annotations", "Landroidx/lifecycle/t;", "getLifecycle", "()Landroidx/lifecycle/t;", "lifecycle", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class ComponentActivity extends Activity implements D, l {
    @NotNull
    private final V extraDataMap;
    @NotNull
    private final F lifecycleRegistry;

    public ComponentActivity() {
        this.extraDataMap = new V(0);
        this.lifecycleRegistry = new F(this);
    }

    @Override  // android.app.Activity
    public boolean dispatchKeyEvent(@NotNull KeyEvent keyEvent0) {
        q.g(keyEvent0, "event");
        View view0 = this.getWindow().getDecorView();
        q.f(view0, "window.decorView");
        return I.A(view0, keyEvent0) ? true : I.B(this, view0, this, keyEvent0);
    }

    @Override  // android.app.Activity
    public boolean dispatchKeyShortcutEvent(@NotNull KeyEvent keyEvent0) {
        q.g(keyEvent0, "event");
        View view0 = this.getWindow().getDecorView();
        q.f(view0, "window.decorView");
        return I.A(view0, keyEvent0) ? true : super.dispatchKeyShortcutEvent(keyEvent0);
    }

    @d
    @Nullable
    public g getExtraData(@NotNull Class class0) {
        q.g(class0, "extraDataClass");
        if(this.extraDataMap.get(class0) != null) {
            throw new ClassCastException();
        }
        return null;
    }

    private static void getExtraDataMap$annotations() {
    }

    @Override  // androidx.lifecycle.D
    @NotNull
    public t getLifecycle() {
        return this.lifecycleRegistry;
    }

    private static void getLifecycleRegistry$annotations() {
    }

    @Override  // android.app.Activity
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        Z.b(this);
    }

    @Override  // android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        this.lifecycleRegistry.h(s.c);
        super.onSaveInstanceState(bundle0);
    }

    @d
    public void putExtraData(@NotNull g g0) {
        q.g(g0, "extraData");
        throw null;
    }

    public final boolean shouldDumpInternalState(@Nullable String[] arr_s) {
        return !this.shouldSkipDump(arr_s);
    }

    private final boolean shouldSkipDump(String[] arr_s) {
        if(arr_s != null && arr_s.length != 0) {
            String s = arr_s[0];
            switch(s.hashCode()) {
                case 0xD98C2911: {
                    return s.equals("--translation") && Build.VERSION.SDK_INT >= 0x1F;
                }
                case 0x5FD0F67: {
                    return s.equals("--dump-dumpable") ? Build.VERSION.SDK_INT >= 33 : false;
                }
                case 0x1C2B8816: {
                    return s.equals("--list-dumpables") ? Build.VERSION.SDK_INT >= 33 : false;
                }
                case 0x4519F64D: {
                    return s.equals("--contentcapture") && Build.VERSION.SDK_INT >= 29;
                }
                case 1455016274: {
                    return s.equals("--autofill");
                }
                default: {
                    return false;
                }
            }
        }
        return false;
    }

    @Override  // c2.l
    public boolean superDispatchKeyEvent(@NotNull KeyEvent keyEvent0) {
        q.g(keyEvent0, "event");
        return super.dispatchKeyEvent(keyEvent0);
    }
}

