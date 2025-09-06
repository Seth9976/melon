package androidx.fragment.app;

import U4.x;
import android.util.Log;
import androidx.lifecycle.m0;
import androidx.lifecycle.q0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class o0 extends m0 {
    public final HashMap a;
    public final HashMap b;
    public final HashMap c;
    public final boolean d;
    public boolean e;
    public boolean f;
    public static final n0 g;

    static {
        o0.g = new n0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public o0(boolean z) {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.e = false;
        this.f = false;
        this.d = z;
    }

    public final void b(I i0) {
        if(!this.f) {
            HashMap hashMap0 = this.a;
            if(!hashMap0.containsKey(i0.mWho)) {
                hashMap0.put(i0.mWho, i0);
                if(l0.P(2)) {
                    Log.v("FragmentManager", "Updating retained Fragments: Added " + i0);
                }
            }
        }
        else if(l0.P(2)) {
            Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
        }
    }

    public final void c(I i0, boolean z) {
        if(l0.P(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + i0);
        }
        this.e(i0.mWho, z);
    }

    public final void d(String s, boolean z) {
        if(l0.P(3)) {
            x.w("Clearing non-config state for saved state of Fragment ", s, "FragmentManager");
        }
        this.e(s, z);
    }

    public final void e(String s, boolean z) {
        HashMap hashMap0 = this.b;
        o0 o00 = (o0)hashMap0.get(s);
        if(o00 != null) {
            if(z) {
                ArrayList arrayList0 = new ArrayList();
                arrayList0.addAll(o00.b.keySet());
                for(Object object0: arrayList0) {
                    o00.d(((String)object0), true);
                }
            }
            o00.onCleared();
            hashMap0.remove(s);
        }
        HashMap hashMap1 = this.c;
        q0 q00 = (q0)hashMap1.get(s);
        if(q00 != null) {
            q00.a();
            hashMap1.remove(s);
        }
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return o0.class == class0 && this.a.equals(((o0)object0).a) && this.b.equals(((o0)object0).b) && this.c.equals(((o0)object0).c);
        }
        return false;
    }

    public final void f(I i0) {
        if(this.f) {
            if(l0.P(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        }
        else if(this.a.remove(i0.mWho) != null && l0.P(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + i0);
        }
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override  // androidx.lifecycle.m0
    public final void onCleared() {
        if(l0.P(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.e = true;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("FragmentManagerViewModel{");
        stringBuilder0.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder0.append("} Fragments (");
        Iterator iterator0 = this.a.values().iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            stringBuilder0.append(object0);
            if(iterator0.hasNext()) {
                stringBuilder0.append(", ");
            }
        }
        stringBuilder0.append(") Child Non Config (");
        Iterator iterator1 = this.b.keySet().iterator();
        while(iterator1.hasNext()) {
            Object object1 = iterator1.next();
            stringBuilder0.append(((String)object1));
            if(iterator1.hasNext()) {
                stringBuilder0.append(", ");
            }
        }
        stringBuilder0.append(") ViewModelStores (");
        Iterator iterator2 = this.c.keySet().iterator();
        while(iterator2.hasNext()) {
            Object object2 = iterator2.next();
            stringBuilder0.append(((String)object2));
            if(iterator2.hasNext()) {
                stringBuilder0.append(", ");
            }
        }
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

