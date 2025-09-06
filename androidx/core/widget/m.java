package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.Editable;
import android.view.ActionMode.Callback;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class m implements ActionMode.Callback {
    public final ActionMode.Callback a;
    public final TextView b;
    public Class c;
    public Method d;
    public boolean e;
    public boolean f;

    public m(ActionMode.Callback actionMode$Callback0, TextView textView0) {
        this.a = actionMode$Callback0;
        this.b = textView0;
        this.f = false;
    }

    @Override  // android.view.ActionMode$Callback
    public final boolean onActionItemClicked(ActionMode actionMode0, MenuItem menuItem0) {
        return this.a.onActionItemClicked(actionMode0, menuItem0);
    }

    @Override  // android.view.ActionMode$Callback
    public final boolean onCreateActionMode(ActionMode actionMode0, Menu menu0) {
        return this.a.onCreateActionMode(actionMode0, menu0);
    }

    @Override  // android.view.ActionMode$Callback
    public final void onDestroyActionMode(ActionMode actionMode0) {
        this.a.onDestroyActionMode(actionMode0);
    }

    @Override  // android.view.ActionMode$Callback
    public final boolean onPrepareActionMode(ActionMode actionMode0, Menu menu0) {
        TextView textView0 = this.b;
        Context context0 = textView0.getContext();
        PackageManager packageManager0 = context0.getPackageManager();
        Class class0 = Integer.TYPE;
        if(!this.f) {
            try {
                this.f = true;
                Class class1 = Class.forName("com.android.internal.view.menu.MenuBuilder");
                this.c = class1;
                this.d = class1.getDeclaredMethod("removeItemAt", class0);
                this.e = true;
            }
            catch(ClassNotFoundException | NoSuchMethodException unused_ex) {
                this.c = null;
                this.d = null;
                this.e = false;
            }
        }
        try {
            Method method0 = !this.e || !this.c.isInstance(menu0) ? menu0.getClass().getDeclaredMethod("removeItemAt", class0) : this.d;
            for(int v = menu0.size() - 1; v >= 0; --v) {
                MenuItem menuItem0 = menu0.getItem(v);
                if(menuItem0.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(menuItem0.getIntent().getAction())) {
                    method0.invoke(menu0, v);
                }
            }
        }
        catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException unused_ex) {
            return this.a.onPrepareActionMode(actionMode0, menu0);
        }
        ArrayList arrayList0 = new ArrayList();
        if(context0 instanceof Activity) {
            for(Object object0: packageManager0.queryIntentActivities(new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain"), 0)) {
                ResolveInfo resolveInfo0 = (ResolveInfo)object0;
                if("com.iloen.melon".equals(resolveInfo0.activityInfo.packageName) || resolveInfo0.activityInfo.exported && (resolveInfo0.activityInfo.permission == null || context0.checkSelfPermission(resolveInfo0.activityInfo.permission) == 0)) {
                    arrayList0.add(resolveInfo0);
                }
            }
        }
        for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
            ResolveInfo resolveInfo1 = (ResolveInfo)arrayList0.get(v1);
            menu0.add(0, 0, v1 + 100, resolveInfo1.loadLabel(packageManager0)).setIntent(new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain").putExtra("android.intent.extra.PROCESS_TEXT_READONLY", ((boolean)((!(textView0 instanceof Editable) || !textView0.onCheckIsTextEditor() || !textView0.isEnabled() ? 0 : 1) ^ 1))).setClassName(resolveInfo1.activityInfo.packageName, resolveInfo1.activityInfo.name)).setShowAsAction(1);
        }
        return this.a.onPrepareActionMode(actionMode0, menu0);
    }
}

