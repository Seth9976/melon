package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

public final class k implements Runnable {
    public final int a;
    public final ArrayList b;
    public final q c;

    public k(q q0, ArrayList arrayList0, int v) {
        this.a = v;
        this.c = q0;
        this.b = arrayList0;
        super();
    }

    @Override
    public final void run() {
        q q0;
        q q2;
        q q1;
        switch(this.a) {
            case 0: {
                ArrayList arrayList1 = this.b;
                Iterator iterator1 = arrayList1.iterator();
                while(true) {
                    boolean z1 = iterator1.hasNext();
                    q1 = this.c;
                    if(!z1) {
                        break;
                    }
                    Object object1 = iterator1.next();
                    O0 o00 = ((p)object1).a;
                    int v = ((p)object1).b;
                    int v1 = ((p)object1).c;
                    int v2 = ((p)object1).d;
                    int v3 = ((p)object1).e;
                    q1.getClass();
                    View view0 = o00.itemView;
                    int v4 = v2 - v;
                    int v5 = v3 - v1;
                    if(v4 != 0) {
                        view0.animate().translationX(0.0f);
                    }
                    if(v5 != 0) {
                        view0.animate().translationY(0.0f);
                    }
                    ViewPropertyAnimator viewPropertyAnimator1 = view0.animate();
                    q1.p.add(o00);
                    viewPropertyAnimator1.setDuration(q1.e).setListener(new m(q1, o00, v4, view0, v5, viewPropertyAnimator1)).start();
                }
                arrayList1.clear();
                q1.m.remove(arrayList1);
                return;
            }
            case 1: {
                ArrayList arrayList2 = this.b;
                Iterator iterator2 = arrayList2.iterator();
                while(true) {
                    boolean z2 = iterator2.hasNext();
                    q2 = this.c;
                    if(!z2) {
                        break;
                    }
                    Object object2 = iterator2.next();
                    o o0 = (o)object2;
                    ArrayList arrayList3 = q2.r;
                    long v6 = q2.f;
                    View view1 = null;
                    View view2 = o0.a == null ? null : o0.a.itemView;
                    O0 o01 = o0.b;
                    if(o01 != null) {
                        view1 = o01.itemView;
                    }
                    if(view2 != null) {
                        ViewPropertyAnimator viewPropertyAnimator2 = view2.animate().setDuration(v6);
                        arrayList3.add(o0.a);
                        viewPropertyAnimator2.translationX(((float)(o0.e - o0.c)));
                        viewPropertyAnimator2.translationY(((float)(o0.f - o0.d)));
                        viewPropertyAnimator2.alpha(0.0f).setListener(new n(q2, o0, viewPropertyAnimator2, view2, 0)).start();
                    }
                    if(view1 != null) {
                        ViewPropertyAnimator viewPropertyAnimator3 = view1.animate();
                        arrayList3.add(o0.b);
                        viewPropertyAnimator3.translationX(0.0f).translationY(0.0f).setDuration(v6).alpha(1.0f).setListener(new n(q2, o0, viewPropertyAnimator3, view1, 1)).start();
                    }
                }
                arrayList2.clear();
                q2.n.remove(arrayList2);
                return;
            }
            default: {
                ArrayList arrayList0 = this.b;
                Iterator iterator0 = arrayList0.iterator();
                while(true) {
                    boolean z = iterator0.hasNext();
                    q0 = this.c;
                    if(!z) {
                        break;
                    }
                    Object object0 = iterator0.next();
                    q0.getClass();
                    ViewPropertyAnimator viewPropertyAnimator0 = ((O0)object0).itemView.animate();
                    q0.o.add(((O0)object0));
                    viewPropertyAnimator0.alpha(1.0f).setDuration(q0.c).setListener(new l(q0, ((O0)object0), ((O0)object0).itemView, viewPropertyAnimator0)).start();
                }
                arrayList0.clear();
                q0.l.remove(arrayList0);
            }
        }
    }
}

