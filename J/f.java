package j;

import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MenuItem;
import java.lang.reflect.Method;

public final class f implements MenuItem.OnMenuItemClickListener {
    public Object a;
    public Method b;
    public static final Class[] c;

    static {
        f.c = new Class[]{MenuItem.class};
    }

    @Override  // android.view.MenuItem$OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem0) {
        try {
            Object object0 = this.a;
            Method method0 = this.b;
            if(method0.getReturnType() == Boolean.TYPE) {
                return ((Boolean)method0.invoke(object0, menuItem0)).booleanValue();
            }
            method0.invoke(object0, menuItem0);
            return true;
        }
        catch(Exception exception0) {
        }
        throw new RuntimeException(exception0);
    }
}

