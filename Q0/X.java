package Q0;

import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import androidx.media3.session.a0;
import com.google.android.material.search.SearchBar;
import com.google.android.material.textfield.k;
import d2.b;
import k.B;
import k.f;

public final class x implements View.OnAttachStateChangeListener {
    public final int a;
    public final Object b;

    public x(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    private final void a(View view0) {
    }

    private final void b(View view0) {
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view0) {
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                ((C)object0).d.addAccessibilityStateChangeListener(((C)object0).f);
                ((C)object0).d.addTouchExplorationStateChangeListener(((C)object0).g);
                return;
            }
            case 1: {
                b b0 = new b(((SearchBar)object0).H0);
                ((SearchBar)object0).G0.addTouchExplorationStateChangeListener(b0);
                return;
            }
            case 2: {
                AccessibilityManager accessibilityManager0 = ((k)object0).E;
                if(((k)object0).G != null && accessibilityManager0 != null && ((k)object0).isAttachedToWindow()) {
                    accessibilityManager0.addTouchExplorationStateChangeListener(new b(((k)object0).G));
                }
            }
        }
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view0) {
        switch(this.a) {
            case 0: {
                ((C)this.b).i.removeCallbacks(((C)this.b).J);
                ((C)this.b).d.removeAccessibilityStateChangeListener(((C)this.b).f);
                ((C)this.b).d.removeTouchExplorationStateChangeListener(((C)this.b).g);
                return;
            }
            case 1: {
                b b1 = new b(((SearchBar)this.b).H0);
                ((SearchBar)this.b).G0.removeTouchExplorationStateChangeListener(b1);
                return;
            }
            case 2: {
                k k0 = (k)this.b;
                a0 a00 = k0.G;
                if(a00 != null) {
                    AccessibilityManager accessibilityManager0 = k0.E;
                    if(accessibilityManager0 != null) {
                        accessibilityManager0.removeTouchExplorationStateChangeListener(new b(a00));
                    }
                }
                return;
            }
            case 3: {
                f f0 = (f)this.b;
                ViewTreeObserver viewTreeObserver1 = f0.N;
                if(viewTreeObserver1 != null) {
                    if(!viewTreeObserver1.isAlive()) {
                        f0.N = view0.getViewTreeObserver();
                    }
                    f0.N.removeGlobalOnLayoutListener(f0.i);
                }
                view0.removeOnAttachStateChangeListener(this);
                return;
            }
            default: {
                B b0 = (B)this.b;
                ViewTreeObserver viewTreeObserver0 = b0.o;
                if(viewTreeObserver0 != null) {
                    if(!viewTreeObserver0.isAlive()) {
                        b0.o = view0.getViewTreeObserver();
                    }
                    b0.o.removeGlobalOnLayoutListener(b0.i);
                }
                view0.removeOnAttachStateChangeListener(this);
            }
        }
    }
}

