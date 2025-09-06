package k;

import Q0.a;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

public final class r extends a implements MenuItem {
    public final U1.a c;
    public Method d;

    public r(Context context0, U1.a a0) {
        super(context0);
        if(a0 == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.c = a0;
    }

    @Override  // android.view.MenuItem
    public final boolean collapseActionView() {
        return this.c.collapseActionView();
    }

    @Override  // android.view.MenuItem
    public final boolean expandActionView() {
        return this.c.expandActionView();
    }

    @Override  // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        androidx.core.view.ActionProvider actionProvider0 = this.c.a();
        return actionProvider0 instanceof n ? ((n)actionProvider0).e : null;
    }

    @Override  // android.view.MenuItem
    public final View getActionView() {
        View view0 = this.c.getActionView();
        return view0 instanceof o ? ((View)((o)view0).a) : view0;
    }

    @Override  // android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.c.getAlphabeticModifiers();
    }

    @Override  // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.c.getAlphabeticShortcut();
    }

    @Override  // android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.c.getContentDescription();
    }

    @Override  // android.view.MenuItem
    public final int getGroupId() {
        return this.c.getGroupId();
    }

    @Override  // android.view.MenuItem
    public final Drawable getIcon() {
        return this.c.getIcon();
    }

    @Override  // android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.c.getIconTintList();
    }

    @Override  // android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.c.getIconTintMode();
    }

    @Override  // android.view.MenuItem
    public final Intent getIntent() {
        return this.c.getIntent();
    }

    @Override  // android.view.MenuItem
    public final int getItemId() {
        return this.c.getItemId();
    }

    @Override  // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.c.getMenuInfo();
    }

    @Override  // android.view.MenuItem
    public final int getNumericModifiers() {
        return this.c.getNumericModifiers();
    }

    @Override  // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.c.getNumericShortcut();
    }

    @Override  // android.view.MenuItem
    public final int getOrder() {
        return this.c.getOrder();
    }

    @Override  // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.c.getSubMenu();
    }

    @Override  // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.c.getTitle();
    }

    @Override  // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        return this.c.getTitleCondensed();
    }

    @Override  // android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.c.getTooltipText();
    }

    @Override  // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.c.hasSubMenu();
    }

    @Override  // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.c.isActionViewExpanded();
    }

    @Override  // android.view.MenuItem
    public final boolean isCheckable() {
        return this.c.isCheckable();
    }

    @Override  // android.view.MenuItem
    public final boolean isChecked() {
        return this.c.isChecked();
    }

    @Override  // android.view.MenuItem
    public final boolean isEnabled() {
        return this.c.isEnabled();
    }

    @Override  // android.view.MenuItem
    public final boolean isVisible() {
        return this.c.isVisible();
    }

    @Override  // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider0) {
        n n0 = new n(this, ((Context)this.a), actionProvider0);
        if(actionProvider0 == null) {
            n0 = null;
        }
        this.c.b(n0);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setActionView(int v) {
        U1.a a0 = this.c;
        a0.setActionView(v);
        View view0 = a0.getActionView();
        if(view0 instanceof CollapsibleActionView) {
            a0.setActionView(new o(view0));
        }
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setActionView(View view0) {
        if(view0 instanceof CollapsibleActionView) {
            view0 = new o(view0);
        }
        this.c.setActionView(view0);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c) {
        this.c.setAlphabeticShortcut(c);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c, int v) {
        this.c.setAlphabeticShortcut(c, v);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        this.c.setCheckable(z);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        this.c.setChecked(z);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence0) {
        this.c.setContentDescription(charSequence0);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        this.c.setEnabled(z);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setIcon(int v) {
        this.c.setIcon(v);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable0) {
        this.c.setIcon(drawable0);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList0) {
        this.c.setIconTintList(colorStateList0);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.c.setIconTintMode(porterDuff$Mode0);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setIntent(Intent intent0) {
        this.c.setIntent(intent0);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c) {
        this.c.setNumericShortcut(c);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c, int v) {
        this.c.setNumericShortcut(c, v);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener menuItem$OnActionExpandListener0) {
        p p0 = menuItem$OnActionExpandListener0 == null ? null : new p(this, menuItem$OnActionExpandListener0);
        this.c.setOnActionExpandListener(p0);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItem$OnMenuItemClickListener0) {
        q q0 = menuItem$OnMenuItemClickListener0 == null ? null : new q(this, menuItem$OnMenuItemClickListener0);
        this.c.setOnMenuItemClickListener(q0);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c1) {
        this.c.setShortcut(c, c1);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c1, int v, int v1) {
        this.c.setShortcut(c, c1, v, v1);
        return this;
    }

    @Override  // android.view.MenuItem
    public final void setShowAsAction(int v) {
        this.c.setShowAsAction(v);
    }

    @Override  // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int v) {
        this.c.setShowAsActionFlags(v);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setTitle(int v) {
        this.c.setTitle(v);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence0) {
        this.c.setTitle(charSequence0);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence0) {
        this.c.setTitleCondensed(charSequence0);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence0) {
        this.c.setTooltipText(charSequence0);
        return this;
    }

    @Override  // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        return this.c.setVisible(z);
    }
}

