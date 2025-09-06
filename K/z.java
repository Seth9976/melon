package k;

import Q0.a;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.collection.V;

public class z extends a implements Menu {
    public final MenuBuilder c;

    public z(Context context0, MenuBuilder menuBuilder0) {
        super(context0);
        if(menuBuilder0 == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.c = menuBuilder0;
    }

    @Override  // android.view.Menu
    public final MenuItem add(int v) {
        return this.k(this.c.add(v));
    }

    @Override  // android.view.Menu
    public final MenuItem add(int v, int v1, int v2, int v3) {
        return this.k(this.c.add(v, v1, v2, v3));
    }

    @Override  // android.view.Menu
    public final MenuItem add(int v, int v1, int v2, CharSequence charSequence0) {
        return this.k(this.c.add(v, v1, v2, charSequence0));
    }

    @Override  // android.view.Menu
    public final MenuItem add(CharSequence charSequence0) {
        return this.k(this.c.add(charSequence0));
    }

    @Override  // android.view.Menu
    public final int addIntentOptions(int v, int v1, int v2, ComponentName componentName0, Intent[] arr_intent, Intent intent0, int v3, MenuItem[] arr_menuItem) {
        MenuItem[] arr_menuItem1 = arr_menuItem == null ? null : new MenuItem[arr_menuItem.length];
        int v4 = this.c.addIntentOptions(v, v1, v2, componentName0, arr_intent, intent0, v3, arr_menuItem1);
        if(arr_menuItem1 != null) {
            for(int v5 = 0; v5 < arr_menuItem1.length; ++v5) {
                arr_menuItem[v5] = this.k(arr_menuItem1[v5]);
            }
        }
        return v4;
    }

    @Override  // android.view.Menu
    public final SubMenu addSubMenu(int v) {
        return this.c.addSubMenu(v);
    }

    @Override  // android.view.Menu
    public final SubMenu addSubMenu(int v, int v1, int v2, int v3) {
        return this.c.addSubMenu(v, v1, v2, v3);
    }

    @Override  // android.view.Menu
    public final SubMenu addSubMenu(int v, int v1, int v2, CharSequence charSequence0) {
        return this.c.addSubMenu(v, v1, v2, charSequence0);
    }

    @Override  // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence0) {
        return this.c.addSubMenu(charSequence0);
    }

    @Override  // android.view.Menu
    public final void clear() {
        V v0 = (V)this.b;
        if(v0 != null) {
            v0.clear();
        }
        this.c.clear();
    }

    @Override  // android.view.Menu
    public final void close() {
        this.c.close();
    }

    @Override  // android.view.Menu
    public final MenuItem findItem(int v) {
        return this.k(this.c.findItem(v));
    }

    @Override  // android.view.Menu
    public final MenuItem getItem(int v) {
        return this.k(this.c.getItem(v));
    }

    @Override  // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.c.hasVisibleItems();
    }

    @Override  // android.view.Menu
    public final boolean isShortcutKey(int v, KeyEvent keyEvent0) {
        return this.c.isShortcutKey(v, keyEvent0);
    }

    @Override  // android.view.Menu
    public final boolean performIdentifierAction(int v, int v1) {
        return this.c.performIdentifierAction(v, v1);
    }

    @Override  // android.view.Menu
    public final boolean performShortcut(int v, KeyEvent keyEvent0, int v1) {
        return this.c.performShortcut(v, keyEvent0, v1);
    }

    @Override  // android.view.Menu
    public final void removeGroup(int v) {
        if(((V)this.b) != null) {
            for(int v1 = 0; v1 < ((V)this.b).size(); ++v1) {
                if(((U1.a)((V)this.b).keyAt(v1)).getGroupId() == v) {
                    ((V)this.b).removeAt(v1);
                    --v1;
                }
            }
        }
        this.c.removeGroup(v);
    }

    @Override  // android.view.Menu
    public final void removeItem(int v) {
        if(((V)this.b) != null) {
            for(int v1 = 0; v1 < ((V)this.b).size(); ++v1) {
                if(((U1.a)((V)this.b).keyAt(v1)).getItemId() == v) {
                    ((V)this.b).removeAt(v1);
                    break;
                }
            }
        }
        this.c.removeItem(v);
    }

    @Override  // android.view.Menu
    public final void setGroupCheckable(int v, boolean z, boolean z1) {
        this.c.setGroupCheckable(v, z, z1);
    }

    @Override  // android.view.Menu
    public final void setGroupEnabled(int v, boolean z) {
        this.c.setGroupEnabled(v, z);
    }

    @Override  // android.view.Menu
    public final void setGroupVisible(int v, boolean z) {
        this.c.setGroupVisible(v, z);
    }

    @Override  // android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.c.setQwertyMode(z);
    }

    @Override  // android.view.Menu
    public final int size() {
        return this.c.size();
    }
}

