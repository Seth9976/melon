package j;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import d5.v;
import java.lang.ref.WeakReference;
import k.j;

public final class d extends b implements j {
    public Context c;
    public ActionBarContextView d;
    public v e;
    public WeakReference f;
    public boolean g;
    public MenuBuilder h;

    @Override  // j.b
    public final void a() {
        if(this.g) {
            return;
        }
        this.g = true;
        this.e.e(this);
    }

    @Override  // j.b
    public final View b() {
        return this.f == null ? null : ((View)this.f.get());
    }

    @Override  // k.j
    public final boolean c(MenuBuilder menuBuilder0, MenuItem menuItem0) {
        return ((a)this.e.a).f(this, menuItem0);
    }

    @Override  // j.b
    public final MenuBuilder d() {
        return this.h;
    }

    @Override  // j.b
    public final MenuInflater e() {
        return new SupportMenuInflater(this.d.getContext());
    }

    @Override  // j.b
    public final CharSequence f() {
        return this.d.getSubtitle();
    }

    @Override  // j.b
    public final CharSequence g() {
        return this.d.getTitle();
    }

    @Override  // j.b
    public final void h() {
        this.e.m(this, this.h);
    }

    @Override  // j.b
    public final boolean i() {
        return this.d.D;
    }

    @Override  // k.j
    public final void j(MenuBuilder menuBuilder0) {
        this.h();
        this.d.j();
    }

    @Override  // j.b
    public final void k(View view0) {
        this.d.setCustomView(view0);
        this.f = view0 == null ? null : new WeakReference(view0);
    }

    @Override  // j.b
    public final void l(int v) {
        this.m(this.c.getString(v));
    }

    @Override  // j.b
    public final void m(CharSequence charSequence0) {
        this.d.setSubtitle(charSequence0);
    }

    @Override  // j.b
    public final void n(int v) {
        this.o(this.c.getString(v));
    }

    @Override  // j.b
    public final void o(CharSequence charSequence0) {
        this.d.setTitle(charSequence0);
    }

    @Override  // j.b
    public final void p(boolean z) {
        this.b = z;
        this.d.setTitleOptional(z);
    }
}

