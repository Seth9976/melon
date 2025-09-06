package va;

import com.iloen.melon.LoginUser;
import com.iloen.melon.utils.datastore.LoginUserPreferencesSerializer;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import java.io.IOException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.i;
import we.o;

public final class n0 extends i implements o {
    public FlowCollector B;
    public Throwable D;
    public final I0 E;
    public final int r;
    public int w;

    public n0(I0 i00, Continuation continuation0, int v) {
        this.r = v;
        this.E = i00;
        super(3, continuation0);
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        switch(this.r) {
            case 0: {
                n0 n01 = new n0(this.E, ((Continuation)object2), 0);
                n01.B = (FlowCollector)object0;
                n01.D = (Throwable)object1;
                return n01.invokeSuspend(H.a);
            }
            case 1: {
                n0 n02 = new n0(this.E, ((Continuation)object2), 1);
                n02.B = (FlowCollector)object0;
                n02.D = (Throwable)object1;
                return n02.invokeSuspend(H.a);
            }
            case 2: {
                n0 n03 = new n0(this.E, ((Continuation)object2), 2);
                n03.B = (FlowCollector)object0;
                n03.D = (Throwable)object1;
                return n03.invokeSuspend(H.a);
            }
            case 3: {
                n0 n04 = new n0(this.E, ((Continuation)object2), 3);
                n04.B = (FlowCollector)object0;
                n04.D = (Throwable)object1;
                return n04.invokeSuspend(H.a);
            }
            default: {
                n0 n00 = new n0(this.E, ((Continuation)object2), 4);
                n00.B = (FlowCollector)object0;
                n00.D = (Throwable)object1;
                return n00.invokeSuspend(H.a);
            }
        }
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        switch(this.r) {
            case 0: {
                FlowCollector flowCollector1 = this.B;
                Throwable throwable1 = this.D;
                a a1 = a.a;
                switch(this.w) {
                    case 0: {
                        n.D(object0);
                        if(!(throwable1 instanceof IOException)) {
                            throw throwable1;
                        }
                        LogU.error$default(this.E.b, "getAutoLoginIntervalTimeForDeveloper()", throwable1, false, 4, null);
                        LoginUser loginUser1 = LoginUserPreferencesSerializer.INSTANCE.createDefaultValue();
                        this.B = null;
                        this.D = null;
                        this.w = 1;
                        return flowCollector1.emit(loginUser1, this) != a1 ? H.a : a1;
                    }
                    case 1: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 1: {
                FlowCollector flowCollector2 = this.B;
                Throwable throwable2 = this.D;
                a a2 = a.a;
                switch(this.w) {
                    case 0: {
                        n.D(object0);
                        if(!(throwable2 instanceof IOException)) {
                            throw throwable2;
                        }
                        LogU.error$default(this.E.b, "getAutoLoginSuccessTime()", throwable2, false, 4, null);
                        LoginUser loginUser2 = LoginUserPreferencesSerializer.INSTANCE.createDefaultValue();
                        this.B = null;
                        this.D = null;
                        this.w = 1;
                        return flowCollector2.emit(loginUser2, this) != a2 ? H.a : a2;
                    }
                    case 1: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 2: {
                FlowCollector flowCollector3 = this.B;
                Throwable throwable3 = this.D;
                a a3 = a.a;
                switch(this.w) {
                    case 0: {
                        n.D(object0);
                        if(!(throwable3 instanceof IOException)) {
                            throw throwable3;
                        }
                        LogU.error$default(this.E.b, "getLoginUserFlow()", throwable3, false, 4, null);
                        LoginUser loginUser3 = LoginUserPreferencesSerializer.INSTANCE.createDefaultValue();
                        this.B = null;
                        this.D = null;
                        this.w = 1;
                        return flowCollector3.emit(loginUser3, this) != a3 ? H.a : a3;
                    }
                    case 1: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            case 3: {
                FlowCollector flowCollector4 = this.B;
                Throwable throwable4 = this.D;
                a a4 = a.a;
                switch(this.w) {
                    case 0: {
                        n.D(object0);
                        if(!(throwable4 instanceof IOException)) {
                            throw throwable4;
                        }
                        LogU.error$default(this.E.b, "getMemberKeyFlow()", throwable4, false, 4, null);
                        LoginUser loginUser4 = LoginUserPreferencesSerializer.INSTANCE.createDefaultValue();
                        this.B = null;
                        this.D = null;
                        this.w = 1;
                        return flowCollector4.emit(loginUser4, this) != a4 ? H.a : a4;
                    }
                    case 1: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
            default: {
                FlowCollector flowCollector0 = this.B;
                Throwable throwable0 = this.D;
                a a0 = a.a;
                switch(this.w) {
                    case 0: {
                        n.D(object0);
                        if(!(throwable0 instanceof IOException)) {
                            throw throwable0;
                        }
                        LogU.error$default(this.E.b, "getTokenFlow()", throwable0, false, 4, null);
                        LoginUser loginUser0 = LoginUserPreferencesSerializer.INSTANCE.createDefaultValue();
                        this.B = null;
                        this.D = null;
                        this.w = 1;
                        return flowCollector0.emit(loginUser0, this) != a0 ? H.a : a0;
                    }
                    case 1: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }
    }
}

