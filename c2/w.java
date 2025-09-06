package c2;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.n;
import androidx.datastore.preferences.protobuf.m;
import d2.c;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;

public abstract class W {
    public static WeakHashMap a = null;
    public static Method b = null;
    public static Field c = null;
    public static boolean d = false;
    public static final int[] e;
    public static final G f;
    public static final I g;

    static {
        W.e = new int[]{0x7F0A002E, 0x7F0A002F, 0x7F0A003A, 0x7F0A0045, 0x7F0A0048, 0x7F0A0049, 0x7F0A004A, 0x7F0A004B, 0x7F0A004C, 0x7F0A004D, 0x7F0A0030, 0x7F0A0031, 0x7F0A0032, 0x7F0A0033, 0x7F0A0034, 0x7F0A0035, 0x7F0A0036, 0x7F0A0037, 0x7F0A0038, 0x7F0A0039, 0x7F0A003B, 0x7F0A003C, 0x7F0A003D, 0x7F0A003E, 0x7F0A003F, 0x7F0A0040, 0x7F0A0041, 0x7F0A0042, 0x7F0A0043, 0x7F0A0044, 0x7F0A0046, 0x7F0A0047};  // id:accessibility_custom_action_0
        W.f = new G();  // 初始化器: Ljava/lang/Object;-><init>()V
        W.g = new I();
    }

    public static c0 a(View view0) {
        if(W.a == null) {
            W.a = new WeakHashMap();
        }
        c0 c00 = (c0)W.a.get(view0);
        if(c00 == null) {
            c00 = new c0(view0);
            W.a.put(view0, c00);
        }
        return c00;
    }

    public static B0 b(View view0, B0 b00) {
        int v = Build.VERSION.SDK_INT;
        WindowInsets windowInsets0 = b00.g();
        if(windowInsets0 != null) {
            WindowInsets windowInsets1 = v < 30 ? K.a(view0, windowInsets0) : T.a(view0, windowInsets0);
            return windowInsets1.equals(windowInsets0) ? b00 : B0.h(view0, windowInsets1);
        }
        return b00;
    }

    public static boolean c(View view0, KeyEvent keyEvent0) {
        if(Build.VERSION.SDK_INT < 28) {
            V v0 = (V)view0.getTag(0x7F0A0B35);  // id:tag_unhandled_key_event_manager
            if(v0 == null) {
                v0 = new V();  // 初始化器: Ljava/lang/Object;-><init>()V
                v0.a = null;
                v0.b = null;
                v0.c = null;
                view0.setTag(0x7F0A0B35, v0);  // id:tag_unhandled_key_event_manager
            }
            if(keyEvent0.getAction() == 0) {
                WeakHashMap weakHashMap0 = v0.a;
                if(weakHashMap0 != null) {
                    weakHashMap0.clear();
                }
                ArrayList arrayList0 = V.d;
                if(!arrayList0.isEmpty()) {
                    synchronized(arrayList0) {
                        if(v0.a == null) {
                            v0.a = new WeakHashMap();
                        }
                        for(int v2 = arrayList0.size() - 1; v2 >= 0; --v2) {
                            ArrayList arrayList1 = V.d;
                            View view1 = (View)((WeakReference)arrayList1.get(v2)).get();
                            if(view1 == null) {
                                arrayList1.remove(v2);
                            }
                            else {
                                v0.a.put(view1, Boolean.TRUE);
                                for(ViewParent viewParent0 = view1.getParent(); viewParent0 instanceof View; viewParent0 = viewParent0.getParent()) {
                                    v0.a.put(((View)viewParent0), Boolean.TRUE);
                                }
                            }
                        }
                    }
                }
            }
            View view2 = v0.a(view0);
            if(keyEvent0.getAction() == 0) {
                int v3 = keyEvent0.getKeyCode();
                if(view2 != null && !KeyEvent.isModifierKey(v3)) {
                    if(v0.b == null) {
                        v0.b = new SparseArray();
                    }
                    v0.b.put(v3, new WeakReference(view2));
                }
            }
            return view2 != null;
        }
        return false;
    }

    public static View.AccessibilityDelegate d(View view0) {
        if(Build.VERSION.SDK_INT >= 29) {
            return S.a(view0);
        }
        if(!W.d) {
            if(W.c == null) {
                try {
                    Field field0 = View.class.getDeclaredField("mAccessibilityDelegate");
                    W.c = field0;
                    field0.setAccessible(true);
                }
                catch(Throwable unused_ex) {
                    W.d = true;
                    return null;
                }
            }
            try {
                Object object0 = W.c.get(view0);
                if(object0 instanceof View.AccessibilityDelegate) {
                    return (View.AccessibilityDelegate)object0;
                }
            }
            catch(Throwable unused_ex) {
                W.d = true;
            }
        }
        return null;
    }

    public static CharSequence e(View view0) {
        if(Build.VERSION.SDK_INT >= 28) {
            return Q.a(view0);
        }
        CharSequence charSequence0 = view0.getTag(0x7F0A0B21);  // id:tag_accessibility_pane_title
        return !CharSequence.class.isInstance(charSequence0) ? null : charSequence0;
    }

    public static ArrayList f(View view0) {
        ArrayList arrayList0 = (ArrayList)view0.getTag(0x7F0A0B1E);  // id:tag_accessibility_actions
        if(arrayList0 == null) {
            arrayList0 = new ArrayList();
            view0.setTag(0x7F0A0B1E, arrayList0);  // id:tag_accessibility_actions
        }
        return arrayList0;
    }

    public static String[] g(AppCompatEditText appCompatEditText0) {
        return Build.VERSION.SDK_INT < 0x1F ? ((String[])appCompatEditText0.getTag(0x7F0A0B2C)) : U.a(appCompatEditText0);  // id:tag_on_receive_content_mime_types
    }

    public static F0 h(View view0) {
        if(Build.VERSION.SDK_INT >= 30) {
            return T.c(view0);
        }
        for(Context context0 = view0.getContext(); context0 instanceof ContextWrapper; context0 = ((ContextWrapper)context0).getBaseContext()) {
            if(context0 instanceof Activity) {
                Window window0 = ((Activity)context0).getWindow();
                return window0 == null ? null : new F0(window0, view0);
            }
        }
        return null;
    }

    public static void i(View view0, int v) {
        AccessibilityManager accessibilityManager0 = (AccessibilityManager)view0.getContext().getSystemService("accessibility");
        if(accessibilityManager0.isEnabled()) {
            boolean z = W.e(view0) != null && view0.isShown() && view0.getWindowVisibility() == 0;
            int v1 = 0x20;
            if(view0.getAccessibilityLiveRegion() != 0 || z) {
                goto label_22;
            }
            if(v == 0x20) {
                AccessibilityEvent accessibilityEvent0 = AccessibilityEvent.obtain();
                view0.onInitializeAccessibilityEvent(accessibilityEvent0);
                accessibilityEvent0.setEventType(0x20);
                accessibilityEvent0.setContentChangeTypes(0x20);
                accessibilityEvent0.setSource(view0);
                view0.onPopulateAccessibilityEvent(accessibilityEvent0);
                accessibilityEvent0.getText().add(W.e(view0));
                accessibilityManager0.sendAccessibilityEvent(accessibilityEvent0);
                return;
            }
            if(view0.getParent() != null) {
                ViewParent viewParent0 = view0.getParent();
                try {
                    viewParent0.notifySubtreeAccessibilityStateChanged(view0, view0, v);
                }
                catch(AbstractMethodError abstractMethodError0) {
                    Log.e("ViewCompat", view0.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", abstractMethodError0);
                }
                return;
            label_22:
                AccessibilityEvent accessibilityEvent1 = AccessibilityEvent.obtain();
                if(!z) {
                    v1 = 0x800;
                }
                accessibilityEvent1.setEventType(v1);
                accessibilityEvent1.setContentChangeTypes(v);
                if(z) {
                    accessibilityEvent1.getText().add(W.e(view0));
                    if(view0.getImportantForAccessibility() == 0) {
                        view0.setImportantForAccessibility(1);
                    }
                }
                view0.sendAccessibilityEventUnchecked(accessibilityEvent1);
            }
        }
    }

    public static B0 j(View view0, B0 b00) {
        WindowInsets windowInsets0 = b00.g();
        if(windowInsets0 != null) {
            WindowInsets windowInsets1 = K.b(view0, windowInsets0);
            return windowInsets1.equals(windowInsets0) ? b00 : B0.h(view0, windowInsets1);
        }
        return b00;
    }

    public static g k(View view0, g g0) {
        if(Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + g0 + ", view=" + view0.getClass().getSimpleName() + "[" + view0.getId() + "]");
        }
        if(Build.VERSION.SDK_INT >= 0x1F) {
            return U.b(view0, g0);
        }
        n n0 = (n)view0.getTag(0x7F0A0B2B);  // id:tag_on_receive_content_listener
        w w0 = W.f;
        if(n0 != null) {
            g g1 = n.a(view0, g0);
            if(g1 == null) {
                return null;
            }
            if(view0 instanceof w) {
                w0 = (w)view0;
            }
            return w0.a(g1);
        }
        if(view0 instanceof w) {
            w0 = (w)view0;
        }
        return w0.a(g0);
    }

    public static void l(View view0, int v) {
        ArrayList arrayList0 = W.f(view0);
        for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
            if(((c)arrayList0.get(v1)).a() == v) {
                arrayList0.remove(v1);
                return;
            }
        }
    }

    public static void m(View view0, c c0, String s, d2.n n0) {
        b b0;
        if(n0 == null && s == null) {
            W.l(view0, c0.a());
            W.i(view0, 0);
            return;
        }
        c c1 = new c(null, c0.b, s, n0, c0.c);
        View.AccessibilityDelegate view$AccessibilityDelegate0 = W.d(view0);
        if(view$AccessibilityDelegate0 == null) {
            b0 = null;
        }
        else {
            b0 = view$AccessibilityDelegate0 instanceof a ? ((a)view$AccessibilityDelegate0).a : new b(view$AccessibilityDelegate0);
        }
        if(b0 == null) {
            b0 = new b();
        }
        W.o(view0, b0);
        W.l(view0, c1.a());
        W.f(view0).add(c1);
        W.i(view0, 0);
    }

    public static void n(View view0, Context context0, int[] arr_v, AttributeSet attributeSet0, TypedArray typedArray0, int v) {
        if(Build.VERSION.SDK_INT >= 29) {
            S.b(view0, context0, arr_v, attributeSet0, typedArray0, v, 0);
        }
    }

    public static void o(View view0, b b0) {
        if(b0 == null && W.d(view0) instanceof a) {
            b0 = new b();
        }
        if(view0.getImportantForAccessibility() == 0) {
            view0.setImportantForAccessibility(1);
        }
        view0.setAccessibilityDelegate((b0 == null ? null : b0.getBridge()));
    }

    public static void p(View view0, CharSequence charSequence0) {
        new H(0x7F0A0B21, CharSequence.class, 8, 28, 1).h(view0, charSequence0);  // id:tag_accessibility_pane_title
        I i0 = W.g;
        if(charSequence0 != null) {
            boolean z = view0.isShown() && view0.getWindowVisibility() == 0;
            i0.a.put(view0, Boolean.valueOf(z));
            view0.addOnAttachStateChangeListener(i0);
            if(view0.isAttachedToWindow()) {
                view0.getViewTreeObserver().addOnGlobalLayoutListener(i0);
            }
            return;
        }
        i0.a.remove(view0);
        view0.removeOnAttachStateChangeListener(i0);
        view0.getViewTreeObserver().removeOnGlobalLayoutListener(i0);
    }

    public static void q(View view0, m m0) {
        i0 i00 = null;
        if(Build.VERSION.SDK_INT >= 30) {
            if(m0 != null) {
                i00 = new i0(m0);
            }
            view0.setWindowInsetsAnimationCallback(i00);
            return;
        }
        if(m0 != null) {
            i00 = new f0(view0, m0);
        }
        view0.setTag(0x7F0A0B37, i00);  // id:tag_window_insets_animation_callback
        if(view0.getTag(0x7F0A0B23) == null && view0.getTag(0x7F0A0B2A) == null) {  // id:tag_compat_insets_dispatch
            view0.setOnApplyWindowInsetsListener(((View.OnApplyWindowInsetsListener)i00));
        }
    }
}

