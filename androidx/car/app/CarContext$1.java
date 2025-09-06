package androidx.car.app;

import androidx.lifecycle.s;
import androidx.lifecycle.t;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

class CarContext.1 extends Stub {
    final Executor val$executor;
    final t val$lifecycle;
    final i val$listener;

    public CarContext.1(CarContext carContext0, t t0, Executor executor0, i i0) {
        CarContext.this = carContext0;
        this.val$lifecycle = t0;
        this.val$executor = executor0;
        super();
    }

    public static void C0(List list0, List list1) {
        CarContext.1.lambda$onRequestPermissionsResult$0(null, list0, list1);
    }

    private static void lambda$onRequestPermissionsResult$0(i i0, List list0, List list1) {
        i0.a();
    }

    @Override  // androidx.car.app.IOnRequestPermissionsListener
    public void onRequestPermissionsResult(String[] arr_s, String[] arr_s1) {
        if(this.val$lifecycle.b().compareTo(s.c) >= 0) {
            g g0 = new g(1, Arrays.asList(arr_s), Arrays.asList(arr_s1));
            this.val$executor.execute(g0);
        }
    }
}

