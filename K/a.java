package k;

import P1.c;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.view.ActionProvider;

public final class a implements U1.a {
    public CharSequence a;
    public CharSequence b;
    public Intent c;
    public char d;
    public int e;
    public char f;
    public int g;
    public Drawable h;
    public Context i;
    public CharSequence j;
    public CharSequence k;
    public ColorStateList l;
    public PorterDuff.Mode m;
    public boolean n;
    public boolean o;
    public int p;

    @Override  // U1.a
    public final ActionProvider a() {
        return null;
    }

    @Override  // U1.a
    public final U1.a b(ActionProvider actionProvider0) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable0 = this.h;
        if(drawable0 != null && (this.n || this.o)) {
            this.h = drawable0;
            Drawable drawable1 = drawable0.mutate();
            this.h = drawable1;
            if(this.n) {
                drawable1.setTintList(this.l);
            }
            if(this.o) {
                this.h.setTintMode(this.m);
            }
        }
    }

    @Override  // android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override  // android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override  // android.view.MenuItem
    public final android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override  // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override  // U1.a
    public final int getAlphabeticModifiers() {
        return this.g;
    }

    @Override  // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f;
    }

    @Override  // U1.a
    public final CharSequence getContentDescription() {
        return this.j;
    }

    @Override  // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override  // android.view.MenuItem
    public final Drawable getIcon() {
        return this.h;
    }

    @Override  // U1.a
    public final ColorStateList getIconTintList() {
        return this.l;
    }

    @Override  // U1.a
    public final PorterDuff.Mode getIconTintMode() {
        return this.m;
    }

    @Override  // android.view.MenuItem
    public final Intent getIntent() {
        return this.c;
    }

    @Override  // android.view.MenuItem
    public final int getItemId() {
        return 0x102002C;
    }

    @Override  // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override  // U1.a
    public final int getNumericModifiers() {
        return this.e;
    }

    @Override  // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.d;
    }

    @Override  // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override  // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override  // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.a;
    }

    @Override  // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        return this.b == null ? this.a : this.b;
    }

    @Override  // U1.a
    public final CharSequence getTooltipText() {
        return this.k;
    }

    @Override  // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override  // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override  // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.p & 1) != 0;
    }

    @Override  // android.view.MenuItem
    public final boolean isChecked() {
        return (this.p & 2) != 0;
    }

    @Override  // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.p & 16) != 0;
    }

    @Override  // android.view.MenuItem
    public final boolean isVisible() {
        return (this.p & 8) == 0;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setActionProvider(android.view.ActionProvider actionProvider0) {
        throw new UnsupportedOperationException();
    }

    @Override  // android.view.MenuItem
    public final MenuItem setActionView(int v) {
        throw new UnsupportedOperationException();
    }

    @Override  // android.view.MenuItem
    public final MenuItem setActionView(View view0) {
        throw new UnsupportedOperationException();
    }

    @Override  // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c) {
        this.f = Character.toLowerCase(c);
        return this;
    }

    @Override  // U1.a
    public final MenuItem setAlphabeticShortcut(char c, int v) {
        this.f = Character.toLowerCase(c);
        this.g = KeyEvent.normalizeMetaState(v);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        this.p = z | this.p & -2;
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        this.p = (z ? 2 : 0) | this.p & -3;
        return this;
    }

    @Override  // U1.a
    public final U1.a setContentDescription(CharSequence charSequence0) {
        this.j = charSequence0;
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence0) {
        this.j = charSequence0;
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        this.p = (z ? 16 : 0) | this.p & -17;
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setIcon(int v) {
        this.h = c.getDrawable(this.i, v);
        this.c();
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable0) {
        this.h = drawable0;
        this.c();
        return this;
    }

    @Override  // U1.a
    public final MenuItem setIconTintList(ColorStateList colorStateList0) {
        this.l = colorStateList0;
        this.n = true;
        this.c();
        return this;
    }

    @Override  // U1.a
    public final MenuItem setIconTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.m = porterDuff$Mode0;
        this.o = true;
        this.c();
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setIntent(Intent intent0) {
        this.c = intent0;
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c) {
        this.d = c;
        return this;
    }

    @Override  // U1.a
    public final MenuItem setNumericShortcut(char c, int v) {
        this.d = c;
        this.e = KeyEvent.normalizeMetaState(v);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener menuItem$OnActionExpandListener0) {
        throw new UnsupportedOperationException();
    }

    @Override  // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItem$OnMenuItemClickListener0) {
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c1) {
        this.d = c;
        this.f = Character.toLowerCase(c1);
        return this;
    }

    @Override  // U1.a
    public final MenuItem setShortcut(char c, char c1, int v, int v1) {
        this.d = c;
        this.e = KeyEvent.normalizeMetaState(v);
        this.f = Character.toLowerCase(c1);
        this.g = KeyEvent.normalizeMetaState(v1);
        return this;
    }

    @Override  // android.view.MenuItem
    public final void setShowAsAction(int v) {
    }

    @Override  // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int v) {
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setTitle(int v) {
        this.a = this.i.getResources().getString(v);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence0) {
        this.a = charSequence0;
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence0) {
        this.b = charSequence0;
        return this;
    }

    @Override  // U1.a
    public final U1.a setTooltipText(CharSequence charSequence0) {
        this.k = charSequence0;
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence0) {
        this.k = charSequence0;
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        int v = 8;
        int v1 = this.p & 8;
        if(z) {
            v = 0;
        }
        this.p = v1 | v;
        return this;
    }
}

