package androidx.recyclerview.widget;

import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

public final class g0 implements Runnable {
    public final int a;
    public final RecyclerView b;

    public g0(RecyclerView recyclerView0, int v) {
        this.a = v;
        this.b = recyclerView0;
        super();
    }

    @Override
    public final void run() {
        RecyclerView recyclerView0 = this.b;
        if(this.a != 0) {
            q0 q00 = recyclerView0.l0;
            if(q00 != null) {
                long v = ((q)q00).d;
                ArrayList arrayList0 = ((q)q00).h;
                boolean z = arrayList0.isEmpty();
                ArrayList arrayList1 = ((q)q00).j;
                boolean z1 = arrayList1.isEmpty();
                ArrayList arrayList2 = ((q)q00).k;
                boolean z2 = arrayList2.isEmpty();
                ArrayList arrayList3 = ((q)q00).i;
                boolean z3 = arrayList3.isEmpty();
                if(!z || !z1 || !z3 || !z2) {
                    for(Object object0: arrayList0) {
                        ViewPropertyAnimator viewPropertyAnimator0 = ((O0)object0).itemView.animate();
                        ((q)q00).q.add(((O0)object0));
                        viewPropertyAnimator0.setDuration(v).alpha(0.0f).setListener(new l(((q)q00), ((O0)object0), viewPropertyAnimator0, ((O0)object0).itemView)).start();
                    }
                    arrayList0.clear();
                    if(!z1) {
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.addAll(arrayList1);
                        ((q)q00).m.add(arrayList4);
                        arrayList1.clear();
                        k k0 = new k(((q)q00), arrayList4, 0);
                        if(z) {
                            k0.run();
                        }
                        else {
                            ((p)arrayList4.get(0)).a.itemView.postOnAnimationDelayed(k0, v);
                        }
                    }
                    if(!z2) {
                        ArrayList arrayList5 = new ArrayList();
                        arrayList5.addAll(arrayList2);
                        ((q)q00).n.add(arrayList5);
                        arrayList2.clear();
                        k k1 = new k(((q)q00), arrayList5, 1);
                        if(z) {
                            k1.run();
                        }
                        else {
                            ((o)arrayList5.get(0)).a.itemView.postOnAnimationDelayed(k1, v);
                        }
                    }
                    if(!z3) {
                        long v1 = 0L;
                        ArrayList arrayList6 = new ArrayList();
                        arrayList6.addAll(arrayList3);
                        ((q)q00).l.add(arrayList6);
                        arrayList3.clear();
                        k k2 = new k(((q)q00), arrayList6, 2);
                        if(!z || !z1 || !z2) {
                            if(z) {
                                v = 0L;
                            }
                            long v2 = z1 ? 0L : ((q)q00).e;
                            if(!z2) {
                                v1 = ((q)q00).f;
                            }
                            ((O0)arrayList6.get(0)).itemView.postOnAnimationDelayed(k2, Math.max(v2, v1) + v);
                        }
                        else {
                            k2.run();
                        }
                    }
                }
            }
            recyclerView0.J0 = false;
            return;
        }
        if(recyclerView0.G && !recyclerView0.isLayoutRequested()) {
            if(!recyclerView0.D) {
                recyclerView0.requestLayout();
                return;
            }
            if(recyclerView0.N) {
                recyclerView0.M = true;
                return;
            }
            recyclerView0.n();
        }
    }
}

