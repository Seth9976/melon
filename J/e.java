package j;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import k.z;

public final class e extends ActionMode {
    public final Context a;
    public final b b;

    public e(Context context0, b b0) {
        this.a = context0;
        this.b = b0;
    }

    @Override  // android.view.ActionMode
    public final void finish() {
        this.b.a();
    }

    @Override  // android.view.ActionMode
    public final View getCustomView() {
        return this.b.b();
    }

    @Override  // android.view.ActionMode
    public final Menu getMenu() {
        MenuBuilder menuBuilder0 = this.b.d();
        return new z(this.a, menuBuilder0);
    }

    @Override  // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.b.e();
    }

    @Override  // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.b.f();
    }

    @Override  // android.view.ActionMode
    public final Object getTag() {
        return this.b.a;
    }

    @Override  // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.b.g();
    }

    @Override  // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.b.b;
    }

    @Override  // android.view.ActionMode
    public final void invalidate() {
        this.b.h();
    }

    @Override  // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.b.i();
    }

    @Override  // android.view.ActionMode
    public final void setCustomView(View view0) {
        this.b.k(view0);
    }

    @Override  // android.view.ActionMode
    public final void setSubtitle(int v) {
        this.b.l(v);
    }

    @Override  // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence0) {
        this.b.m(charSequence0);
    }

    @Override  // android.view.ActionMode
    public final void setTag(Object object0) {
        this.b.a = object0;
    }

    @Override  // android.view.ActionMode
    public final void setTitle(int v) {
        this.b.n(v);
    }

    @Override  // android.view.ActionMode
    public final void setTitle(CharSequence charSequence0) {
        this.b.o(charSequence0);
    }

    @Override  // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z) {
        this.b.p(z);
    }
}

