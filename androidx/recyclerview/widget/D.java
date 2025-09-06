package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;

public abstract class d {
    public static final Object a;
    public static ExecutorService b;
    public static final r c;

    static {
        d.a = new Object();
        d.c = new r(0);
    }

    public static u a(s s0) {
        int v26;
        int v23;
        int v22;
        y y2;
        int v19;
        y y1;
        int v17;
        int v14;
        int v13;
        int v11;
        int v10;
        t t0;
        int v = s0.getOldListSize();
        int v1 = s0.getNewListSize();
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        x x0 = new x();  // 初始化器: Ljava/lang/Object;-><init>()V
        x0.a = 0;
        x0.b = v;
        x0.c = 0;
        x0.d = v1;
        arrayList1.add(x0);
        int v2 = (v + v1 + 1) / 2 * 2 + 1;
        int[] arr_v = new int[v2];
        int[] arr_v1 = new int[v2];
        ArrayList arrayList2 = new ArrayList();
        while(!arrayList1.isEmpty()) {
            y y0 = null;
            x x1 = (x)arrayList1.remove(arrayList1.size() - 1);
            if(x1.b() < 1 || x1.a() < 1) {
            label_116:
                if(y0 != null) {
                    if(y0.a() > 0) {
                        int v28 = y0.b;
                        int v29 = y0.d - v28;
                        int v30 = y0.a;
                        int v31 = y0.c - v30;
                        if(v29 == v31) {
                            t0 = new t(v30, v28, v31);
                        }
                        else if(y0.e) {
                            t0 = new t(v30, v28, y0.a());
                        }
                        else if(v29 > v31) {
                            t0 = new t(v30, v28 + 1, y0.a());
                        }
                        else {
                            t0 = new t(v30 + 1, v28, y0.a());
                        }
                        arrayList0.add(t0);
                    }
                    x x2 = arrayList2.isEmpty() ? new x() : ((x)arrayList2.remove(arrayList2.size() - 1));  // 初始化器: Ljava/lang/Object;-><init>()V
                    x2.a = x1.a;
                    x2.c = x1.c;
                    x2.b = y0.a;
                    x2.d = y0.b;
                    arrayList1.add(x2);
                    x1.b = x1.b;
                    x1.d = x1.d;
                    x1.a = y0.c;
                    x1.c = y0.d;
                    arrayList1.add(x1);
                    continue;
                }
            }
            else {
                int v3 = (x1.a() + x1.b() + 1) / 2;
                int v4 = 1 + v2 / 2;
                arr_v[v4] = x1.a;
                arr_v1[v4] = x1.b;
                int v5 = 0;
                while(true) {
                    if(v5 >= v3) {
                        goto label_116;
                    }
                    int v6 = Math.abs(x1.b() - x1.a()) % 2 == 1 ? 1 : 0;
                    int v7 = x1.b() - x1.a();
                    int v8 = -v5;
                    int v9 = v8;
                    while(true) {
                        if(v9 > v5) {
                            v17 = v3;
                            y1 = null;
                            break;
                        }
                        if(v9 == v8 || v9 != v5 && arr_v[v9 + 1 + v2 / 2] > arr_v[v9 - 1 + v2 / 2]) {
                            v10 = arr_v[v9 + 1 + v2 / 2];
                            v11 = v10;
                        }
                        else {
                            v10 = arr_v[v9 - 1 + v2 / 2];
                            v11 = v10 + 1;
                        }
                        int v12 = v11 - x1.a + x1.c - v9;
                        if(v5 == 0 || v11 != v10) {
                            v13 = v11;
                            v14 = v12;
                        }
                        else {
                            v13 = v11;
                            v14 = v12 - 1;
                        }
                        int v15 = v12;
                        int v16 = v13;
                        v17 = v3;
                        while(v16 < x1.b && v15 < x1.d && s0.areItemsTheSame(v16, v15)) {
                            ++v16;
                            ++v15;
                        }
                        arr_v[v9 + v2 / 2] = v16;
                        if(v6 == 0) {
                        label_62:
                            v19 = 0;
                        }
                        else {
                            int v18 = v7 - v9;
                            if(v18 >= v8 + 1 && v18 <= v5 - 1 && arr_v1[v18 + v2 / 2] <= v16) {
                                y1 = new y();  // 初始化器: Ljava/lang/Object;-><init>()V
                                y1.a = v10;
                                y1.b = v14;
                                y1.c = v16;
                                y1.d = v15;
                                y1.e = false;
                                break;
                            }
                            else {
                                v19 = v6;
                                goto label_63;
                            }
                            goto label_62;
                        }
                    label_63:
                        v9 += 2;
                        v3 = v17;
                        v6 = v19;
                    }
                    if(y1 == null) {
                        boolean z = (x1.b() - x1.a()) % 2 == 0;
                        int v20 = x1.b() - x1.a();
                        int v21 = v8;
                        while(true) {
                            y2 = null;
                            if(v21 > v5) {
                                break;
                            }
                            if(v21 == v8 || v21 != v5 && arr_v1[v21 + 1 + v2 / 2] < arr_v1[v21 - 1 + v2 / 2]) {
                                v22 = arr_v1[v21 + 1 + v2 / 2];
                                v23 = v22;
                            }
                            else {
                                v22 = arr_v1[v21 - 1 + v2 / 2];
                                v23 = v22 - 1;
                            }
                            int v24 = x1.d - (x1.b - v23 - v21);
                            int v25 = v5 == 0 || v23 != v22 ? v24 : v24 + 1;
                            while(true) {
                                if(v23 > x1.a && v24 > x1.c) {
                                    v26 = v20;
                                    if(s0.areItemsTheSame(v23 - 1, v24 - 1)) {
                                        --v23;
                                        --v24;
                                        v20 = v26;
                                        continue;
                                    }
                                    else {
                                        break;
                                    }
                                }
                                v26 = v20;
                                break;
                            }
                            arr_v1[v21 + v2 / 2] = v23;
                            if(z) {
                                int v27 = v26 - v21;
                                if(v27 >= v8 && v27 <= v5 && arr_v[v27 + v2 / 2] >= v23) {
                                    y2 = new y();  // 初始化器: Ljava/lang/Object;-><init>()V
                                    y2.a = v23;
                                    y2.b = v24;
                                    y2.c = v22;
                                    y2.d = v25;
                                    y2.e = true;
                                    break;
                                }
                            }
                            v21 += 2;
                            v20 = v26;
                        }
                        if(y2 == null) {
                            ++v5;
                            v3 = v17;
                            continue;
                        }
                        else {
                            y0 = y2;
                            goto label_116;
                        }
                    }
                    else {
                        y0 = y1;
                        goto label_116;
                    }
                    break;
                }
            }
            arrayList2.add(x1);
        }
        Collections.sort(arrayList0, d.c);
        return new u(s0, arrayList0, arr_v, arr_v1);
    }

    public static int b(K0 k00, d0 d00, View view0, View view1, w0 w00, boolean z) {
        if(w00.getChildCount() != 0 && k00.b() != 0 && view0 != null && view1 != null) {
            if(!z) {
                return Math.abs(w00.getPosition(view0) - w00.getPosition(view1)) + 1;
            }
            int v = d00.b(view1);
            int v1 = d00.e(view0);
            return Math.min(d00.l(), v - v1);
        }
        return 0;
    }

    public static int c(K0 k00, d0 d00, View view0, View view1, w0 w00, boolean z, boolean z1) {
        if(w00.getChildCount() != 0 && k00.b() != 0 && view0 != null && view1 != null) {
            int v = z1 ? Math.max(0, k00.b() - Math.max(w00.getPosition(view0), w00.getPosition(view1)) - 1) : Math.max(0, Math.min(w00.getPosition(view0), w00.getPosition(view1)));
            return z ? Math.round(((float)v) * (((float)Math.abs(d00.b(view1) - d00.e(view0))) / ((float)(Math.abs(w00.getPosition(view0) - w00.getPosition(view1)) + 1))) + ((float)(d00.k() - d00.e(view0)))) : v;
        }
        return 0;
    }

    public static int d(K0 k00, d0 d00, View view0, View view1, w0 w00, boolean z) {
        if(w00.getChildCount() != 0 && k00.b() != 0 && view0 != null && view1 != null) {
            return z ? ((int)(((float)(d00.b(view1) - d00.e(view0))) / ((float)(Math.abs(w00.getPosition(view0) - w00.getPosition(view1)) + 1)) * ((float)k00.b()))) : k00.b();
        }
        return 0;
    }
}

