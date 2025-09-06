package k;

import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem;

public final class p implements MenuItem.OnActionExpandListener {
    public final MenuItem.OnActionExpandListener a;
    public final r b;

    public p(r r0, MenuItem.OnActionExpandListener menuItem$OnActionExpandListener0) {
        this.b = r0;
        this.a = menuItem$OnActionExpandListener0;
    }

    @Override  // android.view.MenuItem$OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem0) {
        MenuItem menuItem1 = this.b.k(menuItem0);
        return this.a.onMenuItemActionCollapse(menuItem1);
    }

    @Override  // android.view.MenuItem$OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem0) {
        MenuItem menuItem1 = this.b.k(menuItem0);
        return this.a.onMenuItemActionExpand(menuItem1);
    }
}

