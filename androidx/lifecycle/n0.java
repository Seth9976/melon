package androidx.lifecycle;

import R6.d;
import S2.c;
import android.app.Application;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.q;

public final class n0 extends p0 {
    public final Application b;
    public static n0 c;
    public static final d d;

    static {
        n0.d = new d(17);
    }

    public n0(Application application0) {
        q.g(application0, "application");
        this(application0, 0);
    }

    public n0(Application application0, int v) {
        this.b = application0;
    }

    public final m0 a(Class class0, Application application0) {
        m0 m00;
        if(a.class.isAssignableFrom(class0)) {
            try {
                m00 = (m0)class0.getConstructor(Application.class).newInstance(application0);
            }
            catch(NoSuchMethodException noSuchMethodException0) {
                throw new RuntimeException("Cannot create an instance of " + class0, noSuchMethodException0);
            }
            catch(IllegalAccessException illegalAccessException0) {
                throw new RuntimeException("Cannot create an instance of " + class0, illegalAccessException0);
            }
            catch(InstantiationException instantiationException0) {
                throw new RuntimeException("Cannot create an instance of " + class0, instantiationException0);
            }
            catch(InvocationTargetException invocationTargetException0) {
                throw new RuntimeException("Cannot create an instance of " + class0, invocationTargetException0);
            }
            q.d(m00);
            return m00;
        }
        return super.create(class0);
    }

    @Override  // androidx.lifecycle.p0
    public final m0 create(Class class0) {
        q.g(class0, "modelClass");
        Application application0 = this.b;
        if(application0 == null) {
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }
        return this.a(class0, application0);
    }

    @Override  // androidx.lifecycle.p0
    public final m0 create(Class class0, c c0) {
        q.g(c0, "extras");
        if(this.b != null) {
            return this.create(class0);
        }
        Application application0 = (Application)c0.a(n0.d);
        if(application0 != null) {
            return this.a(class0, application0);
        }
        if(a.class.isAssignableFrom(class0)) {
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }
        return P4.a.n(class0);
    }
}

