package k;

import U1.a;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ActionProvider;
import d5.w;
import i.n.i.b.a.s.e.Ga;
import java.util.ArrayList;

public final class m implements a {
    public ActionProvider A;
    public MenuItem.OnActionExpandListener B;
    public boolean C;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public CharSequence e;
    public CharSequence f;
    public Intent g;
    public char h;
    public int i;
    public char j;
    public int k;
    public Drawable l;
    public int m;
    public final MenuBuilder n;
    public C o;
    public MenuItem.OnMenuItemClickListener p;
    public CharSequence q;
    public CharSequence r;
    public ColorStateList s;
    public PorterDuff.Mode t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public int y;
    public View z;

    public m(MenuBuilder menuBuilder0, int v, int v1, int v2, int v3, CharSequence charSequence0, int v4) {
        this.i = 0x1000;
        this.k = 0x1000;
        this.m = 0;
        this.s = null;
        this.t = null;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = 16;
        this.C = false;
        this.n = menuBuilder0;
        this.a = v1;
        this.b = v;
        this.c = v2;
        this.d = v3;
        this.e = charSequence0;
        this.y = v4;
    }

    @Override  // U1.a
    public final ActionProvider a() {
        return this.A;
    }

    @Override  // U1.a
    public final a b(ActionProvider actionProvider0) {
        ActionProvider actionProvider1 = this.A;
        if(actionProvider1 != null) {
            actionProvider1.c = null;
            actionProvider1.b = null;
        }
        this.z = null;
        this.A = actionProvider0;
        this.n.p(true);
        ActionProvider actionProvider2 = this.A;
        if(actionProvider2 != null) {
            actionProvider2.h(new Ga(this, 23));
        }
        return this;
    }

    public static void c(int v, int v1, String s, StringBuilder stringBuilder0) {
        if((v & v1) == v1) {
            stringBuilder0.append(s);
        }
    }

    @Override  // android.view.MenuItem
    public final boolean collapseActionView() {
        if((this.y & 8) == 0) {
            return false;
        }
        if(this.z == null) {
            return true;
        }
        return this.B == null || this.B.onMenuItemActionCollapse(this) ? this.n.d(this) : false;
    }

    public final Drawable d(Drawable drawable0) {
        if(drawable0 != null && this.w && (this.u || this.v)) {
            drawable0 = drawable0.mutate();
            if(this.u) {
                drawable0.setTintList(this.s);
            }
            if(this.v) {
                drawable0.setTintMode(this.t);
            }
            this.w = false;
        }
        return drawable0;
    }

    public final boolean e() {
        if((this.y & 8) != 0) {
            if(this.z == null) {
                ActionProvider actionProvider0 = this.A;
                if(actionProvider0 != null) {
                    this.z = actionProvider0.d(this);
                }
            }
            return this.z != null;
        }
        return false;
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.MenuItem
    public final boolean expandActionView() {
        return this.e() && (this.B == null || this.B.onMenuItemActionExpand(this)) ? this.n.f(this) : false;
    }

    public final void f(boolean z) {
        this.x = (z ? 4 : 0) | this.x & -5;
    }

    public final void g(boolean z) {
        if(z) {
            this.x |= 0x20;
            return;
        }
        this.x &= -33;
    }

    @Override  // android.view.MenuItem
    public final android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override  // android.view.MenuItem
    public final View getActionView() {
        View view0 = this.z;
        if(view0 != null) {
            return view0;
        }
        ActionProvider actionProvider0 = this.A;
        if(actionProvider0 != null) {
            View view1 = actionProvider0.d(this);
            this.z = view1;
            return view1;
        }
        return null;
    }

    @Override  // U1.a
    public final int getAlphabeticModifiers() {
        return this.k;
    }

    @Override  // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.j;
    }

    @Override  // U1.a
    public final CharSequence getContentDescription() {
        return this.q;
    }

    @Override  // android.view.MenuItem
    public final int getGroupId() {
        return this.b;
    }

    @Override  // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable0 = this.l;
        if(drawable0 != null) {
            return this.d(drawable0);
        }
        int v = this.m;
        if(v != 0) {
            Drawable drawable1 = w.B(this.n.a, v);
            this.m = 0;
            this.l = drawable1;
            return this.d(drawable1);
        }
        return null;
    }

    @Override  // U1.a
    public final ColorStateList getIconTintList() {
        return this.s;
    }

    @Override  // U1.a
    public final PorterDuff.Mode getIconTintMode() {
        return this.t;
    }

    @Override  // android.view.MenuItem
    public final Intent getIntent() {
        return this.g;
    }

    @Override  // android.view.MenuItem
    public final int getItemId() {
        return this.a;
    }

    @Override  // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override  // U1.a
    public final int getNumericModifiers() {
        return this.i;
    }

    @Override  // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.h;
    }

    @Override  // android.view.MenuItem
    public final int getOrder() {
        return this.c;
    }

    @Override  // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.o;
    }

    @Override  // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.e;
    }

    @Override  // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        return this.f == null ? this.e : this.f;
    }

    @Override  // U1.a
    public final CharSequence getTooltipText() {
        return this.r;
    }

    @Override  // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.o != null;
    }

    @Override  // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.C;
    }

    @Override  // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.x & 1) == 1;
    }

    @Override  // android.view.MenuItem
    public final boolean isChecked() {
        return (this.x & 2) == 2;
    }

    @Override  // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.x & 16) != 0;
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.MenuItem
    public final boolean isVisible() {
        return this.A == null || !this.A.g() ? (this.x & 8) == 0 : (this.x & 8) == 0 && this.A.b();
    }

    @Override  // android.view.MenuItem
    public final MenuItem setActionProvider(android.view.ActionProvider actionProvider0) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override  // android.view.MenuItem
    public final MenuItem setActionView(int v) {
        View view0 = LayoutInflater.from(this.n.a).inflate(v, new LinearLayout(this.n.a), false);
        this.z = view0;
        this.A = null;
        if(view0 != null && view0.getId() == -1) {
            int v1 = this.a;
            if(v1 > 0) {
                view0.setId(v1);
            }
        }
        this.n.k = true;
        this.n.p(true);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setActionView(View view0) {
        this.z = view0;
        this.A = null;
        if(view0 != null && view0.getId() == -1) {
            int v = this.a;
            if(v > 0) {
                view0.setId(v);
            }
        }
        this.n.k = true;
        this.n.p(true);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c) {
        if(this.j == c) {
            return this;
        }
        this.j = Character.toLowerCase(c);
        this.n.p(false);
        return this;
    }

    @Override  // U1.a
    public final MenuItem setAlphabeticShortcut(char c, int v) {
        if(this.j == c && this.k == v) {
            return this;
        }
        this.j = Character.toLowerCase(c);
        this.k = KeyEvent.normalizeMetaState(v);
        this.n.p(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        int v = this.x;
        int v1 = z | v & -2;
        this.x = v1;
        if(v != v1) {
            this.n.p(false);
        }
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        int v = this.x;
        int v1 = 2;
        if((v & 4) != 0) {
            MenuBuilder menuBuilder0 = this.n;
            ArrayList arrayList0 = menuBuilder0.f;
            int v2 = arrayList0.size();
            menuBuilder0.y();
            for(int v3 = 0; v3 < v2; ++v3) {
                m m0 = (m)arrayList0.get(v3);
                if(m0.b == this.b && (m0.x & 4) != 0 && m0.isCheckable()) {
                    int v4 = m0.x;
                    int v5 = (m0 == this ? 0 : 2) | v4 & -3;
                    m0.x = v5;
                    if(v4 != v5) {
                        m0.n.p(false);
                    }
                }
            }
            menuBuilder0.x();
            return this;
        }
        if(!z) {
            v1 = 0;
        }
        int v6 = v & -3 | v1;
        this.x = v6;
        if(v != v6) {
            this.n.p(false);
        }
        return this;
    }

    @Override  // U1.a
    public final a setContentDescription(CharSequence charSequence0) {
        this.q = charSequence0;
        this.n.p(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence0) {
        this.setContentDescription(charSequence0);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        if(z) {
            this.x |= 16;
        }
        else {
            this.x &= -17;
        }
        this.n.p(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setIcon(int v) {
        this.l = null;
        this.m = v;
        this.w = true;
        this.n.p(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable0) {
        this.m = 0;
        this.l = drawable0;
        this.w = true;
        this.n.p(false);
        return this;
    }

    @Override  // U1.a
    public final MenuItem setIconTintList(ColorStateList colorStateList0) {
        this.s = colorStateList0;
        this.u = true;
        this.w = true;
        this.n.p(false);
        return this;
    }

    @Override  // U1.a
    public final MenuItem setIconTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.t = porterDuff$Mode0;
        this.v = true;
        this.w = true;
        this.n.p(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setIntent(Intent intent0) {
        this.g = intent0;
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c) {
        if(this.h == c) {
            return this;
        }
        this.h = c;
        this.n.p(false);
        return this;
    }

    @Override  // U1.a
    public final MenuItem setNumericShortcut(char c, int v) {
        if(this.h == c && this.i == v) {
            return this;
        }
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(v);
        this.n.p(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener menuItem$OnActionExpandListener0) {
        this.B = menuItem$OnActionExpandListener0;
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItem$OnMenuItemClickListener0) {
        this.p = menuItem$OnMenuItemClickListener0;
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c1) {
        this.h = c;
        this.j = Character.toLowerCase(c1);
        this.n.p(false);
        return this;
    }

    @Override  // U1.a
    public final MenuItem setShortcut(char c, char c1, int v, int v1) {
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(v);
        this.j = Character.toLowerCase(c1);
        this.k = KeyEvent.normalizeMetaState(v1);
        this.n.p(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public final void setShowAsAction(int v) {
        if((v & 3) != 0 && (v & 3) != 1 && (v & 3) != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.y = v;
        this.n.k = true;
        this.n.p(true);
    }

    @Override  // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int v) {
        this.setShowAsAction(v);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setTitle(int v) {
        this.setTitle(this.n.a.getString(v));
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence0) {
        this.e = charSequence0;
        this.n.p(false);
        C c0 = this.o;
        if(c0 != null) {
            c0.setHeaderTitle(charSequence0);
        }
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence0) {
        this.f = charSequence0;
        this.n.p(false);
        return this;
    }

    @Override  // U1.a
    public final a setTooltipText(CharSequence charSequence0) {
        this.r = charSequence0;
        this.n.p(false);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence0) {
        this.setTooltipText(charSequence0);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        int v = this.x;
        int v1 = (z ? 0 : 8) | v & -9;
        this.x = v1;
        if(v != v1) {
            this.n.h = true;
            this.n.p(true);
        }
        return this;
    }

    @Override
    public final String toString() {
        return this.e == null ? null : this.e.toString();
    }
}

