package l4;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class b extends Handler {
    public final ArrayList a;
    public final ArrayList b;
    public final h c;

    public b(h h0) {
        this.c = h0;
        super();
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public static void a(I i0, int v, Object object0, int v1) {
        O o1;
        O o0;
        Q q0 = i0.a;
        H h0 = i0.b;
        switch(0xFF00 & v) {
            case 0x100: {
                if(v == 0x106 || v == 0x108) {
                    o1 = ((g)object0).a;
                    o0 = ((g)object0).b;
                }
                else {
                    if(v != 0x109 && v != 0x10A) {
                        o0 = (O)object0;
                        o1 = null;
                        goto label_21;
                    }
                    object0.getClass();
                    throw new ClassCastException();
                }
            label_21:
                int v2 = 1;
                if(o0 != null) {
                    if((i0.d & 2) == 0 && !o0.h(i0.c)) {
                        T t0 = Q.c().v;
                        v2 = !(t0 == null ? false : t0.c) || !o0.d() || v != 0x106 || v1 != 3 || o1 == null ? 0 : true ^ o1.d();
                    }
                    if(v2 != 0) {
                        switch(v) {
                            case 0x101: {
                                h0.onRouteAdded(q0, o0);
                                return;
                            }
                            case 0x102: {
                                h0.onRouteRemoved(q0, o0);
                                return;
                            }
                            case 0x103: {
                                h0.onRouteChanged(q0, o0);
                                return;
                            }
                            case 260: {
                                h0.onRouteVolumeChanged(q0, o0);
                                return;
                            }
                            case 0x105: {
                                return;
                            }
                            case 0x106: {
                                h0.onRouteSelected(q0, o0, v1, o0);
                                return;
                            }
                            case 0x107: {
                                h0.onRouteUnselected(q0, o0, v1);
                                return;
                            }
                            case 0x108: {
                                h0.onRouteSelected(q0, o0, v1, o1);
                                return;
                            }
                            case 0x109: {
                                h0.onRouteConnected(q0, o1, o0);
                                return;
                            }
                            case 0x10A: {
                                h0.onRouteDisconnected(q0, o1, o0, v1);
                                return;
                            }
                            default: {
                                return;
                            }
                        }
                    }
                }
                break;
            }
            case 0x200: {
                switch(v) {
                    case 0x201: {
                        h0.onProviderAdded(q0, ((N)object0));
                        return;
                    }
                    case 0x202: {
                        h0.onProviderRemoved(q0, ((N)object0));
                        return;
                    }
                    case 0x203: {
                        h0.onProviderChanged(q0, ((N)object0));
                        return;
                    }
                    default: {
                        return;
                    }
                }
            }
            case 0x300: {
                if(v == 0x301) {
                    h0.onRouterParamsChanged(q0, ((T)object0));
                    return;
                }
                break;
            }
        }
    }

    public final void b(int v, Object object0) {
        this.obtainMessage(v, object0).sendToTarget();
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        ArrayList arrayList0 = this.a;
        h h0 = this.c;
        ArrayList arrayList1 = h0.i;
        int v = message0.what;
        Object object0 = message0.obj;
        int v1 = message0.arg1;
        if(v == 0x103 && h0.g().c.equals(((O)object0).c)) {
            h0.r(true);
        }
        ArrayList arrayList2 = this.b;
        switch(v) {
            case 0x101: {
                h0.t.o(((O)object0));
                break;
            }
            case 0x102: {
                h0.t.p(((O)object0));
                break;
            }
            case 0x103: {
                W w0 = h0.t;
                w0.getClass();
                if(((O)object0).c() != w0) {
                    int v2 = w0.k(((O)object0));
                    if(v2 >= 0) {
                        W.t(((Z)w0.B.get(v2)));
                    }
                }
                break;
            }
            case 0x106: {
                O o0 = ((g)object0).b;
                if(((g)object0).c) {
                    h0.t.q(o0);
                }
                if(h0.w != null && o0.d()) {
                    for(Object object1: arrayList2) {
                        h0.t.p(((O)object1));
                    }
                    arrayList2.clear();
                }
                break;
            }
            case 0x108: {
                O o1 = ((g)object0).b;
                arrayList2.add(o1);
                h0.t.o(o1);
                if(((g)object0).c) {
                    h0.t.q(o1);
                }
            }
        }
        try {
            int v4 = arrayList1.size();
            while(true) {
                --v4;
                if(v4 < 0) {
                    break;
                }
                Q q0 = (Q)((WeakReference)arrayList1.get(v4)).get();
                if(q0 == null) {
                    arrayList1.remove(v4);
                }
                else {
                    arrayList0.addAll(q0.b);
                }
            }
            for(Object object2: arrayList0) {
                b.a(((I)object2), v, object0, v1);
            }
        }
        finally {
            arrayList0.clear();
        }
    }
}

