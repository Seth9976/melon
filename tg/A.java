package tg;

import ie.H;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import jeb.synthetic.TWR;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;

public class a implements m {
    public final int a;
    public static final a b;
    public static final a c;
    public static final a d;
    public static final a e;
    public static final a f;
    public static final a g;

    static {
        a.b = new a(0);
        a.c = new a(1);
        a.d = new a(2);
        a.e = new a(3);
        a.f = new a(4);
        a.g = new a(5);
    }

    public a(int v) {
        this.a = v;
        super();
    }

    public List a(Executor executor0) {
        return Collections.singletonList(new o(executor0));
    }

    public List b() {
        return Collections.EMPTY_LIST;
    }

    public String c(Method method0, int v) {
        return "parameter #" + (v + 1);
    }

    public Object d(Class class0, Method method0, Object object0, Object[] arr_object) {
        throw new AssertionError();
    }

    public boolean e(Method method0) {
        return false;
    }

    @Override  // tg.m
    public Object l(Object object0) {
        switch(this.a) {
            case 0: {
                return object0.toString();
            }
            case 1: {
                try {
                    TWR.declareResource(((ResponseBody)object0));
                    TWR.useResource$NT(((ResponseBody)object0));
                    Buffer buffer0 = new Buffer();
                    ((ResponseBody)object0).source().readAll(buffer0);
                    return ResponseBody.create(((ResponseBody)object0).contentType(), ((ResponseBody)object0).contentLength(), buffer0);
                }
                catch(Throwable throwable0) {
                    TWR.moot$NT();
                    throw throwable0;
                }
            }
            case 2: {
                return (RequestBody)object0;
            }
            case 3: {
                return (ResponseBody)object0;
            }
            case 4: {
                ((ResponseBody)object0).close();
                return H.a;
            }
            default: {
                ((ResponseBody)object0).close();
                return null;
            }
        }
    }
}

