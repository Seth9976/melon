package Cc;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import we.a;

public final class c0 implements FlowCollector {
    public final int a;
    public final a b;

    public c0(int v, a a0) {
        this.a = v;
        this.b = a0;
        super();
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        switch(this.a) {
            case 0: {
                if(((Boolean)object0).booleanValue()) {
                    this.b.invoke();
                }
                return H.a;
            }
            case 1: {
                ((Boolean)object0).booleanValue();
                a a1 = this.b;
                if(a1 != null) {
                    a1.invoke();
                }
                return H.a;
            }
            case 2: {
                ((Boolean)object0).booleanValue();
                a a2 = this.b;
                if(a2 != null) {
                    a2.invoke();
                }
                return H.a;
            }
            case 3: {
                ((Boolean)object0).booleanValue();
                a a3 = this.b;
                if(a3 != null) {
                    a3.invoke();
                }
                return H.a;
            }
            case 4: {
                ((Boolean)object0).booleanValue();
                this.b.invoke();
                return H.a;
            }
            case 5: {
                ((Boolean)object0).booleanValue();
                a a4 = this.b;
                if(a4 != null) {
                    a4.invoke();
                }
                return H.a;
            }
            case 6: {
                ((Boolean)object0).booleanValue();
                a a5 = this.b;
                if(a5 != null) {
                    a5.invoke();
                }
                return H.a;
            }
            case 7: {
                ((Boolean)object0).booleanValue();
                a a6 = this.b;
                if(a6 != null) {
                    a6.invoke();
                }
                return H.a;
            }
            case 8: {
                ((Boolean)object0).booleanValue();
                a a7 = this.b;
                if(a7 != null) {
                    a7.invoke();
                }
                return H.a;
            }
            default: {
                ((Boolean)object0).booleanValue();
                a a0 = this.b;
                if(a0 != null) {
                    a0.invoke();
                }
                return H.a;
            }
        }
    }
}

