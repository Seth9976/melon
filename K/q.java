package k;

import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MenuItem;

public final class q implements MenuItem.OnMenuItemClickListener {
    public final MenuItem.OnMenuItemClickListener a;
    public final r b;

    public q(r r0, MenuItem.OnMenuItemClickListener menuItem$OnMenuItemClickListener0) {
        this.b = r0;
        this.a = menuItem$OnMenuItemClickListener0;
    }

    @Override  // android.view.MenuItem$OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem0) {
        MenuItem menuItem1 = this.b.k(menuItem0);
        return this.a.onMenuItemClick(menuItem1);
    }
}

