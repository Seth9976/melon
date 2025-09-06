package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.ShareActionProvider;
import c2.c;
import i.n.i.b.a.s.e.Ga;
import k.C;
import k.m;

public abstract class ActionProvider {
    public final Context a;
    public c b;
    public Ga c;

    public ActionProvider(Context context0) {
        this.a = context0;
    }

    public boolean a() {
        return this instanceof ShareActionProvider;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(m m0) {
        return this.c();
    }

    public boolean e() {
        return false;
    }

    public void f(C c0) {
    }

    public boolean g() {
        return false;
    }

    public void h(Ga ga0) {
        if(this.c != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + this.getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.c = ga0;
    }
}

