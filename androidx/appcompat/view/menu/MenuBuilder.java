package androidx.appcompat.view.menu;

import P1.a;
import P1.c;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ActionProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import k.C;
import k.j;
import k.m;
import k.w;

public class MenuBuilder implements Menu {
    public final Context a;
    public final Resources b;
    public boolean c;
    public final boolean d;
    public j e;
    public final ArrayList f;
    public final ArrayList g;
    public boolean h;
    public final ArrayList i;
    public final ArrayList j;
    public boolean k;
    public int l;
    public CharSequence m;
    public Drawable n;
    public View o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public final ArrayList t;
    public final CopyOnWriteArrayList u;
    public m v;
    public boolean w;
    public boolean x;
    public static final int[] y;

    static {
        MenuBuilder.y = new int[]{1, 4, 5, 3, 2, 0};
    }

    public MenuBuilder(Context context0) {
        boolean z1;
        boolean z = false;
        this.l = 0;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = new ArrayList();
        this.u = new CopyOnWriteArrayList();
        this.w = false;
        this.a = context0;
        Resources resources0 = context0.getResources();
        this.b = resources0;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = true;
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = true;
        if(resources0.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration0 = ViewConfiguration.get(context0);
            if(Build.VERSION.SDK_INT >= 28) {
                z1 = a.q(viewConfiguration0);
            }
            else {
                Resources resources1 = context0.getResources();
                int v = resources1.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                z1 = v != 0 && resources1.getBoolean(v);
            }
            if(z1) {
                z = true;
            }
        }
        this.d = z;
    }

    public m a(int v, int v1, int v2, CharSequence charSequence0) {
        int v6;
        int v3 = (0xFFFF0000 & v2) >> 16;
        if(v3 < 0 || v3 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int v4 = MenuBuilder.y[v3] << 16 | 0xFFFF & v2;
        m m0 = new m(this, v, v1, v2, v4, charSequence0, this.l);
        ArrayList arrayList0 = this.f;
        for(int v5 = arrayList0.size() - 1; true; --v5) {
            v6 = 0;
            if(v5 < 0) {
                break;
            }
            if(((m)arrayList0.get(v5)).d <= v4) {
                v6 = v5 + 1;
                break;
            }
        }
        arrayList0.add(v6, m0);
        this.p(true);
        return m0;
    }

    @Override  // android.view.Menu
    public final MenuItem add(int v) {
        return this.a(0, 0, 0, this.b.getString(v));
    }

    @Override  // android.view.Menu
    public final MenuItem add(int v, int v1, int v2, int v3) {
        return this.a(v, v1, v2, this.b.getString(v3));
    }

    @Override  // android.view.Menu
    public final MenuItem add(int v, int v1, int v2, CharSequence charSequence0) {
        return this.a(v, v1, v2, charSequence0);
    }

    @Override  // android.view.Menu
    public final MenuItem add(CharSequence charSequence0) {
        return this.a(0, 0, 0, charSequence0);
    }

    @Override  // android.view.Menu
    public final int addIntentOptions(int v, int v1, int v2, ComponentName componentName0, Intent[] arr_intent, Intent intent0, int v3, MenuItem[] arr_menuItem) {
        PackageManager packageManager0 = this.a.getPackageManager();
        List list0 = packageManager0.queryIntentActivityOptions(componentName0, arr_intent, intent0, 0);
        int v5 = list0 == null ? 0 : list0.size();
        if((v3 & 1) == 0) {
            this.removeGroup(v);
        }
        for(int v4 = 0; v4 < v5; ++v4) {
            ResolveInfo resolveInfo0 = (ResolveInfo)list0.get(v4);
            Intent intent1 = new Intent((resolveInfo0.specificIndex >= 0 ? arr_intent[resolveInfo0.specificIndex] : intent0));
            intent1.setComponent(new ComponentName(resolveInfo0.activityInfo.applicationInfo.packageName, resolveInfo0.activityInfo.name));
            m m0 = this.a(v, v1, v2, resolveInfo0.loadLabel(packageManager0));
            m0.setIcon(resolveInfo0.loadIcon(packageManager0));
            m0.g = intent1;
            if(arr_menuItem != null) {
                int v6 = resolveInfo0.specificIndex;
                if(v6 >= 0) {
                    arr_menuItem[v6] = m0;
                }
            }
        }
        return v5;
    }

    @Override  // android.view.Menu
    public final SubMenu addSubMenu(int v) {
        return this.addSubMenu(0, 0, 0, this.b.getString(v));
    }

    @Override  // android.view.Menu
    public final SubMenu addSubMenu(int v, int v1, int v2, int v3) {
        return this.addSubMenu(v, v1, v2, this.b.getString(v3));
    }

    @Override  // android.view.Menu
    public SubMenu addSubMenu(int v, int v1, int v2, CharSequence charSequence0) {
        m m0 = this.a(v, v1, v2, charSequence0);
        C c0 = new C(this.a, this, m0);
        m0.o = c0;
        c0.setHeaderTitle(m0.e);
        return c0;
    }

    @Override  // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence0) {
        return this.addSubMenu(0, 0, 0, charSequence0);
    }

    public final void b(w w0, Context context0) {
        WeakReference weakReference0 = new WeakReference(w0);
        this.u.add(weakReference0);
        w0.k(context0, this);
        this.k = true;
    }

    public final void c(boolean z) {
        if(this.s) {
            return;
        }
        this.s = true;
        CopyOnWriteArrayList copyOnWriteArrayList0 = this.u;
        for(Object object0: copyOnWriteArrayList0) {
            WeakReference weakReference0 = (WeakReference)object0;
            w w0 = (w)weakReference0.get();
            if(w0 == null) {
                copyOnWriteArrayList0.remove(weakReference0);
            }
            else {
                w0.b(this, z);
            }
        }
        this.s = false;
    }

    @Override  // android.view.Menu
    public final void clear() {
        m m0 = this.v;
        if(m0 != null) {
            this.d(m0);
        }
        this.f.clear();
        this.p(true);
    }

    public final void clearHeader() {
        this.n = null;
        this.m = null;
        this.o = null;
        this.p(false);
    }

    @Override  // android.view.Menu
    public final void close() {
        this.c(true);
    }

    public boolean d(m m0) {
        CopyOnWriteArrayList copyOnWriteArrayList0 = this.u;
        boolean z = false;
        if(!copyOnWriteArrayList0.isEmpty() && this.v == m0) {
            this.y();
            for(Object object0: copyOnWriteArrayList0) {
                WeakReference weakReference0 = (WeakReference)object0;
                w w0 = (w)weakReference0.get();
                if(w0 == null) {
                    copyOnWriteArrayList0.remove(weakReference0);
                }
                else {
                    z = w0.c(m0);
                    if(z) {
                        break;
                    }
                }
            }
            this.x();
            if(z) {
                this.v = null;
            }
        }
        return z;
    }

    public boolean e(MenuBuilder menuBuilder0, MenuItem menuItem0) {
        return this.e != null && this.e.c(menuBuilder0, menuItem0);
    }

    public boolean f(m m0) {
        CopyOnWriteArrayList copyOnWriteArrayList0 = this.u;
        boolean z = false;
        if(copyOnWriteArrayList0.isEmpty()) {
            return false;
        }
        this.y();
        for(Object object0: copyOnWriteArrayList0) {
            WeakReference weakReference0 = (WeakReference)object0;
            w w0 = (w)weakReference0.get();
            if(w0 == null) {
                copyOnWriteArrayList0.remove(weakReference0);
            }
            else {
                z = w0.f(m0);
                if(z) {
                    break;
                }
            }
        }
        this.x();
        if(z) {
            this.v = m0;
        }
        return z;
    }

    @Override  // android.view.Menu
    public final MenuItem findItem(int v) {
        ArrayList arrayList0 = this.f;
        int v1 = arrayList0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            MenuItem menuItem0 = (m)arrayList0.get(v2);
            if(menuItem0.a == v) {
                return menuItem0;
            }
            if(((m)menuItem0).hasSubMenu()) {
                MenuItem menuItem1 = menuItem0.o.findItem(v);
                if(menuItem1 != null) {
                    return menuItem1;
                }
            }
        }
        return null;
    }

    public final m g(int v, KeyEvent keyEvent0) {
        ArrayList arrayList0 = this.t;
        arrayList0.clear();
        this.h(arrayList0, v, keyEvent0);
        if(arrayList0.isEmpty()) {
            return null;
        }
        int v1 = keyEvent0.getMetaState();
        KeyCharacterMap.KeyData keyCharacterMap$KeyData0 = new KeyCharacterMap.KeyData();
        keyEvent0.getKeyData(keyCharacterMap$KeyData0);
        int v2 = arrayList0.size();
        if(v2 == 1) {
            return (m)arrayList0.get(0);
        }
        boolean z = this.n();
        for(int v3 = 0; v3 < v2; ++v3) {
            m m0 = (m)arrayList0.get(v3);
            int v4 = z ? m0.j : m0.h;
            if(v4 == keyCharacterMap$KeyData0.meta[0] && (v1 & 2) == 0 || v4 == keyCharacterMap$KeyData0.meta[2] && (v1 & 2) != 0 || z && v4 == 8 && v == 67) {
                return m0;
            }
        }
        return null;
    }

    @Override  // android.view.Menu
    public final MenuItem getItem(int v) {
        return (MenuItem)this.f.get(v);
    }

    public final void h(List list0, int v, KeyEvent keyEvent0) {
        boolean z = this.n();
        int v1 = keyEvent0.getModifiers();
        KeyCharacterMap.KeyData keyCharacterMap$KeyData0 = new KeyCharacterMap.KeyData();
        if(keyEvent0.getKeyData(keyCharacterMap$KeyData0) || v == 67) {
            ArrayList arrayList0 = this.f;
            int v2 = arrayList0.size();
            for(int v3 = 0; v3 < v2; ++v3) {
                m m0 = (m)arrayList0.get(v3);
                if(m0.hasSubMenu()) {
                    m0.o.h(list0, v, keyEvent0);
                }
                int v4 = z ? m0.j : m0.h;
                if((v1 & 0x1100F) == ((z ? m0.k : m0.i) & 0x1100F) && v4 != 0 && ((v4 == keyCharacterMap$KeyData0.meta[0] || v4 == keyCharacterMap$KeyData0.meta[2] || z && v4 == 8 && v == 67) && m0.isEnabled())) {
                    list0.add(m0);
                }
            }
        }
    }

    @Override  // android.view.Menu
    public final boolean hasVisibleItems() {
        if(!this.x) {
            ArrayList arrayList0 = this.f;
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                if(((m)arrayList0.get(v1)).isVisible()) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final void i() {
        ArrayList arrayList0 = this.l();
        if(!this.k) {
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList0 = this.u;
        boolean z = false;
        for(Object object0: copyOnWriteArrayList0) {
            WeakReference weakReference0 = (WeakReference)object0;
            w w0 = (w)weakReference0.get();
            if(w0 == null) {
                copyOnWriteArrayList0.remove(weakReference0);
            }
            else {
                z |= w0.j();
            }
        }
        ArrayList arrayList1 = this.i;
        ArrayList arrayList2 = this.j;
        if(z) {
            arrayList1.clear();
            arrayList2.clear();
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                m m0 = (m)arrayList0.get(v1);
                if((m0.x & 0x20) == 0x20) {
                    arrayList1.add(m0);
                }
                else {
                    arrayList2.add(m0);
                }
            }
        }
        else {
            arrayList1.clear();
            arrayList2.clear();
            arrayList2.addAll(this.l());
        }
        this.k = false;
    }

    @Override  // android.view.Menu
    public final boolean isShortcutKey(int v, KeyEvent keyEvent0) {
        return this.g(v, keyEvent0) != null;
    }

    public String j() [...] // 潜在的解密器

    public MenuBuilder k() {
        return this;
    }

    public final ArrayList l() {
        ArrayList arrayList0 = this.g;
        if(!this.h) {
            return arrayList0;
        }
        arrayList0.clear();
        ArrayList arrayList1 = this.f;
        int v = arrayList1.size();
        for(int v1 = 0; v1 < v; ++v1) {
            m m0 = (m)arrayList1.get(v1);
            if(m0.isVisible()) {
                arrayList0.add(m0);
            }
        }
        this.h = false;
        this.k = true;
        return arrayList0;
    }

    public boolean m() {
        return this.w;
    }

    public boolean n() {
        return this.c;
    }

    public boolean o() {
        return this.d;
    }

    public void p(boolean z) {
        if(this.p) {
            this.q = true;
            if(z) {
                this.r = true;
            }
        }
        else {
            if(z) {
                this.h = true;
                this.k = true;
            }
            CopyOnWriteArrayList copyOnWriteArrayList0 = this.u;
            if(!copyOnWriteArrayList0.isEmpty()) {
                this.y();
                for(Object object0: copyOnWriteArrayList0) {
                    WeakReference weakReference0 = (WeakReference)object0;
                    w w0 = (w)weakReference0.get();
                    if(w0 == null) {
                        copyOnWriteArrayList0.remove(weakReference0);
                    }
                    else {
                        w0.i(z);
                    }
                }
                this.x();
            }
        }
    }

    @Override  // android.view.Menu
    public final boolean performIdentifierAction(int v, int v1) {
        return this.q(this.findItem(v), null, v1);
    }

    @Override  // android.view.Menu
    public final boolean performShortcut(int v, KeyEvent keyEvent0, int v1) {
        m m0 = this.g(v, keyEvent0);
        boolean z = m0 == null ? false : this.q(m0, null, v1);
        if((v1 & 2) != 0) {
            this.c(true);
        }
        return z;
    }

    public final boolean q(MenuItem menuItem0, w w0, int v) {
        boolean z1;
        boolean z = false;
        if(((m)menuItem0) != null && ((m)menuItem0).isEnabled()) {
            MenuBuilder menuBuilder0 = ((m)menuItem0).n;
            MenuItem.OnMenuItemClickListener menuItem$OnMenuItemClickListener0 = ((m)menuItem0).p;
            if(menuItem$OnMenuItemClickListener0 != null && menuItem$OnMenuItemClickListener0.onMenuItemClick(((m)menuItem0))) {
                z1 = true;
            }
            else if(!menuBuilder0.e(menuBuilder0, ((m)menuItem0))) {
                Intent intent0 = ((m)menuItem0).g;
                if(intent0 == null) {
                label_12:
                    ActionProvider actionProvider0 = ((m)menuItem0).A;
                    z1 = actionProvider0 != null && actionProvider0.e();
                }
                else {
                    try {
                        menuBuilder0.a.startActivity(intent0);
                        z1 = true;
                    }
                    catch(ActivityNotFoundException activityNotFoundException0) {
                        Log.e("MenuItemImpl", "Can\'t find activity to handle intent; ignoring", activityNotFoundException0);
                        goto label_12;
                    }
                }
            }
            else {
                z1 = true;
            }
            ActionProvider actionProvider1 = ((m)menuItem0).A;
            boolean z2 = actionProvider1 != null && actionProvider1.a();
            if(((m)menuItem0).e()) {
                z1 |= ((m)menuItem0).expandActionView();
                if(z1) {
                    this.c(true);
                    return true;
                }
            }
            else if(((m)menuItem0).hasSubMenu() || z2) {
                if((v & 4) == 0) {
                    this.c(false);
                }
                if(!((m)menuItem0).hasSubMenu()) {
                    C c0 = new C(this.a, this, ((m)menuItem0));
                    ((m)menuItem0).o = c0;
                    c0.setHeaderTitle(((m)menuItem0).e);
                }
                C c1 = ((m)menuItem0).o;
                if(z2) {
                    actionProvider1.f(c1);
                }
                CopyOnWriteArrayList copyOnWriteArrayList0 = this.u;
                if(!copyOnWriteArrayList0.isEmpty()) {
                    if(w0 != null) {
                        z = w0.g(c1);
                    }
                    for(Object object0: copyOnWriteArrayList0) {
                        WeakReference weakReference0 = (WeakReference)object0;
                        w w1 = (w)weakReference0.get();
                        if(w1 == null) {
                            copyOnWriteArrayList0.remove(weakReference0);
                        }
                        else if(!z) {
                            z = w1.g(c1);
                        }
                    }
                }
                z1 |= z;
                if(!z1) {
                    this.c(true);
                }
            }
            else if((v & 1) == 0) {
                this.c(true);
                return z1;
            }
            return z1;
        }
        return false;
    }

    public final void r(w w0) {
        CopyOnWriteArrayList copyOnWriteArrayList0 = this.u;
        for(Object object0: copyOnWriteArrayList0) {
            WeakReference weakReference0 = (WeakReference)object0;
            w w1 = (w)weakReference0.get();
            if(w1 == null || w1 == w0) {
                copyOnWriteArrayList0.remove(weakReference0);
            }
        }
    }

    @Override  // android.view.Menu
    public final void removeGroup(int v) {
        ArrayList arrayList0 = this.f;
        int v1 = arrayList0.size();
        int v3;
        for(v3 = 0; true; ++v3) {
            if(v3 >= v1) {
                v3 = -1;
                break;
            }
            if(((m)arrayList0.get(v3)).b == v) {
                break;
            }
        }
        if(v3 >= 0) {
            int v4 = arrayList0.size();
            for(int v2 = 0; v2 < v4 - v3 && ((m)arrayList0.get(v3)).b == v; ++v2) {
                ArrayList arrayList1 = this.f;
                if(v3 < arrayList1.size()) {
                    arrayList1.remove(v3);
                }
            }
            this.p(true);
        }
    }

    @Override  // android.view.Menu
    public final void removeItem(int v) {
        ArrayList arrayList0 = this.f;
        int v1 = arrayList0.size();
        int v2;
        for(v2 = 0; true; ++v2) {
            if(v2 >= v1) {
                v2 = -1;
                break;
            }
            if(((m)arrayList0.get(v2)).a == v) {
                break;
            }
        }
        if(v2 >= 0) {
            ArrayList arrayList1 = this.f;
            if(v2 < arrayList1.size()) {
                arrayList1.remove(v2);
                this.p(true);
            }
        }
    }

    public final void s(Bundle bundle0) {
        if(bundle0 != null) {
            SparseArray sparseArray0 = bundle0.getSparseParcelableArray("android:menu:actionviewstates");
            int v = this.f.size();
            for(int v1 = 0; v1 < v; ++v1) {
                MenuItem menuItem0 = this.getItem(v1);
                View view0 = menuItem0.getActionView();
                if(view0 != null && view0.getId() != -1) {
                    view0.restoreHierarchyState(sparseArray0);
                }
                if(menuItem0.hasSubMenu()) {
                    ((C)menuItem0.getSubMenu()).s(bundle0);
                }
            }
            int v2 = bundle0.getInt("android:menu:expandedactionview");
            if(v2 > 0) {
                MenuItem menuItem1 = this.findItem(v2);
                if(menuItem1 != null) {
                    menuItem1.expandActionView();
                }
            }
        }
    }

    @Override  // android.view.Menu
    public final void setGroupCheckable(int v, boolean z, boolean z1) {
        ArrayList arrayList0 = this.f;
        int v1 = arrayList0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            m m0 = (m)arrayList0.get(v2);
            if(m0.b == v) {
                m0.f(z1);
                m0.setCheckable(z);
            }
        }
    }

    @Override  // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.w = z;
    }

    @Override  // android.view.Menu
    public final void setGroupEnabled(int v, boolean z) {
        ArrayList arrayList0 = this.f;
        int v1 = arrayList0.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            m m0 = (m)arrayList0.get(v2);
            if(m0.b == v) {
                m0.setEnabled(z);
            }
        }
    }

    @Override  // android.view.Menu
    public final void setGroupVisible(int v, boolean z) {
        ArrayList arrayList0 = this.f;
        int v1 = arrayList0.size();
        boolean z1 = false;
        for(int v2 = 0; v2 < v1; ++v2) {
            m m0 = (m)arrayList0.get(v2);
            if(m0.b == v) {
                int v3 = m0.x;
                int v4 = v3 & -9 | (z ? 0 : 8);
                m0.x = v4;
                if(v3 != v4) {
                    z1 = true;
                }
            }
        }
        if(z1) {
            this.p(true);
        }
    }

    @Override  // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.c = z;
        this.p(false);
    }

    @Override  // android.view.Menu
    public final int size() {
        return this.f.size();
    }

    public final void t(Bundle bundle0) {
        SparseArray sparseArray0 = bundle0.getSparseParcelableArray("android:menu:presenters");
        if(sparseArray0 != null) {
            CopyOnWriteArrayList copyOnWriteArrayList0 = this.u;
            if(!copyOnWriteArrayList0.isEmpty()) {
                for(Object object0: copyOnWriteArrayList0) {
                    WeakReference weakReference0 = (WeakReference)object0;
                    w w0 = (w)weakReference0.get();
                    if(w0 == null) {
                        copyOnWriteArrayList0.remove(weakReference0);
                    }
                    else {
                        int v = w0.getId();
                        if(v > 0) {
                            Parcelable parcelable0 = (Parcelable)sparseArray0.get(v);
                            if(parcelable0 != null) {
                                w0.d(parcelable0);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void u(Bundle bundle0) {
        int v = this.f.size();
        SparseArray sparseArray0 = null;
        for(int v1 = 0; v1 < v; ++v1) {
            MenuItem menuItem0 = this.getItem(v1);
            View view0 = menuItem0.getActionView();
            if(view0 != null && view0.getId() != -1) {
                if(sparseArray0 == null) {
                    sparseArray0 = new SparseArray();
                }
                view0.saveHierarchyState(sparseArray0);
                if(menuItem0.isActionViewExpanded()) {
                    bundle0.putInt("android:menu:expandedactionview", menuItem0.getItemId());
                }
            }
            if(menuItem0.hasSubMenu()) {
                ((C)menuItem0.getSubMenu()).u(bundle0);
            }
        }
        if(sparseArray0 != null) {
            bundle0.putSparseParcelableArray("android:menu:actionviewstates", sparseArray0);
        }
    }

    public final void v(Bundle bundle0) {
        CopyOnWriteArrayList copyOnWriteArrayList0 = this.u;
        if(copyOnWriteArrayList0.isEmpty()) {
            return;
        }
        SparseArray sparseArray0 = new SparseArray();
        for(Object object0: copyOnWriteArrayList0) {
            WeakReference weakReference0 = (WeakReference)object0;
            w w0 = (w)weakReference0.get();
            if(w0 == null) {
                copyOnWriteArrayList0.remove(weakReference0);
            }
            else {
                int v = w0.getId();
                if(v > 0) {
                    Parcelable parcelable0 = w0.e();
                    if(parcelable0 != null) {
                        sparseArray0.put(v, parcelable0);
                    }
                }
            }
        }
        bundle0.putSparseParcelableArray("android:menu:presenters", sparseArray0);
    }

    public final void w(int v, CharSequence charSequence0, int v1, Drawable drawable0, View view0) {
        if(view0 == null) {
            if(v > 0) {
                this.m = this.b.getText(v);
            }
            else if(charSequence0 != null) {
                this.m = charSequence0;
            }
            if(v1 > 0) {
                this.n = c.getDrawable(this.a, v1);
            }
            else if(drawable0 != null) {
                this.n = drawable0;
            }
            this.o = null;
        }
        else {
            this.o = view0;
            this.m = null;
            this.n = null;
        }
        this.p(false);
    }

    public final void x() {
        this.p = false;
        if(this.q) {
            this.q = false;
            this.p(this.r);
        }
    }

    public final void y() {
        if(!this.p) {
            this.p = true;
            this.q = false;
            this.r = false;
        }
    }
}

