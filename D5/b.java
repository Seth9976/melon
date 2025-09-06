package d5;

import Df.u;
import H4.h;
import U4.c;
import U4.x;
import android.net.NetworkRequest;
import android.os.Build.VERSION;
import androidx.room.H;
import i.n.i.b.a.s.e.M3;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Set;
import je.p;
import k8.Y;
import kotlin.jvm.internal.q;

public final class b extends u {
    public final int e;

    public b(H h0) {
        this.e = 1;
        q.g(h0, "database");
        super(h0);
    }

    public b(H h0, boolean z, int v) {
        this.e = v;
        super(h0);
    }

    @Override  // Df.u
    public final String c() {
        switch(this.e) {
            case 0: {
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }
            case 1: {
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            }
            case 2: {
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
            }
            case 3: {
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            }
            case 4: {
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            }
            case 5: {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`trace_tag`,`required_network_type`,`required_network_request`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
            default: {
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
            }
        }
    }

    public final void o(h h0, Object object0) {
        byte[] arr_b1;
        int[] arr_v1;
        byte[] arr_b;
        int v2;
        int v1;
        int v = 3;
        switch(this.e) {
            case 0: {
                h0.k(1, ((a)object0).a);
                h0.k(2, ((a)object0).b);
                return;
            }
            case 1: {
                h0.k(1, ((d)object0).a);
                h0.a(2, ((long)((d)object0).b));
                return;
            }
            case 2: {
                h0.k(1, ((g)object0).a);
                h0.a(2, ((long)((g)object0).b));
                h0.a(3, ((long)((g)object0).c));
                return;
            }
            case 3: {
                h0.k(1, ((k)object0).a);
                h0.k(2, ((k)object0).b);
                return;
            }
            case 4: {
                throw new ClassCastException();
            }
            case 5: {
                d5.q q0 = (d5.q)object0;
                h0.k(1, q0.a);
                h0.a(2, ((long)w.R(q0.b)));
                h0.k(3, q0.c);
                h0.k(4, q0.d);
                h0.O(5, E9.h.X(q0.e));
                h0.O(6, E9.h.X(q0.f));
                h0.a(7, q0.g);
                h0.a(8, q0.h);
                h0.a(9, q0.i);
                h0.a(10, ((long)q0.k));
                Y.r(q0.l, "backoffPolicy");
                switch(e0.b.b(q0.l)) {
                    case 0: {
                        v1 = 0;
                        break;
                    }
                    case 1: {
                        v1 = 1;
                        break;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                h0.a(11, ((long)v1));
                h0.a(12, q0.m);
                h0.a(13, q0.n);
                h0.a(14, q0.o);
                h0.a(15, q0.p);
                h0.a(16, ((long)q0.q));
                Y.r(q0.r, "policy");
                switch(e0.b.b(q0.r)) {
                    case 0: {
                        v2 = 0;
                        break;
                    }
                    case 1: {
                        v2 = 1;
                        break;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                h0.a(17, ((long)v2));
                h0.a(18, ((long)q0.s));
                h0.a(19, ((long)q0.t));
                h0.a(20, q0.u);
                h0.a(21, ((long)q0.v));
                h0.a(22, ((long)q0.w));
                String s = q0.x;
                if(s == null) {
                    h0.b(23);
                }
                else {
                    h0.k(23, s);
                }
                U4.d d0 = q0.j;
                int v3 = d0.a;
                Y.r(v3, "networkType");
                switch(e0.b.b(v3)) {
                    case 0: {
                        v = 0;
                        break;
                    }
                    case 1: {
                        v = 1;
                        break;
                    }
                    case 2: {
                        v = 2;
                        break;
                    }
                    case 3: {
                        break;
                    }
                    case 4: {
                        v = 4;
                        break;
                    }
                    default: {
                        if(Build.VERSION.SDK_INT < 30 || v3 != 6) {
                            throw new IllegalArgumentException("Could not convert " + x.A(v3) + " to int");
                        }
                        v = 5;
                        break;
                    }
                }
                h0.a(24, ((long)v));
                e5.h h1 = d0.b;
                q.g(h1, "requestCompat");
                int v4 = Build.VERSION.SDK_INT;
                if(v4 < 28) {
                    arr_b = new byte[0];
                }
                else {
                    NetworkRequest networkRequest0 = (NetworkRequest)h1.a;
                    if(networkRequest0 == null) {
                        arr_b = new byte[0];
                    }
                    else {
                        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
                        try {
                            ObjectOutputStream objectOutputStream0 = new ObjectOutputStream(byteArrayOutputStream0);
                            if(v4 >= 0x1F) {
                                try {
                                    int[] arr_v = networkRequest0.getTransportTypes();
                                    q.f(arr_v, "request.transportTypes");
                                    goto label_100;
                                label_91:
                                    ArrayList arrayList0 = new ArrayList();
                                    for(int v5 = 0; v5 < 10; ++v5) {
                                        int v6 = new int[]{2, 0, 3, 6, 10, 9, 8, 4, 1, 5}[v5];
                                        if(com.iloen.melon.utils.system.a.x(networkRequest0, v6)) {
                                            arrayList0.add(v6);
                                        }
                                    }
                                    arr_v = p.O0(arrayList0);
                                label_100:
                                    if(Build.VERSION.SDK_INT < 0x1F) {
                                        ArrayList arrayList1 = new ArrayList();
                                        for(int v7 = 0; v7 < 30; ++v7) {
                                            int v8 = new int[]{17, 5, 2, 10, 29, 19, 3, 0x20, 7, 4, 12, 36, 23, 0, 33, 20, 11, 13, 18, 21, 15, 35, 34, 8, 1, 25, 14, 16, 6, 9}[v7];
                                            if(com.iloen.melon.utils.system.a.D(networkRequest0, v8)) {
                                                arrayList1.add(v8);
                                            }
                                        }
                                        arr_v1 = p.O0(arrayList1);
                                    }
                                    else {
                                        arr_v1 = networkRequest0.getCapabilities();
                                        q.f(arr_v1, "request.capabilities");
                                    }
                                    objectOutputStream0.writeInt(arr_v.length);
                                    for(int v9 = 0; v9 < arr_v.length; ++v9) {
                                        objectOutputStream0.writeInt(arr_v[v9]);
                                    }
                                    objectOutputStream0.writeInt(arr_v1.length);
                                    int v10 = 0;
                                    while(true) {
                                        if(v10 >= arr_v1.length) {
                                            goto label_128;
                                        }
                                        objectOutputStream0.writeInt(arr_v1[v10]);
                                        ++v10;
                                    }
                                }
                                catch(Throwable throwable1) {
                                    d8.d.l(objectOutputStream0, throwable1);
                                    throw throwable1;
                                }
                            }
                            else {
                                goto label_91;
                            }
                            goto label_100;
                        label_128:
                            objectOutputStream0.close();
                        }
                        catch(Throwable throwable0) {
                            d8.d.l(byteArrayOutputStream0, throwable0);
                            throw throwable0;
                        }
                        byteArrayOutputStream0.close();
                        arr_b = byteArrayOutputStream0.toByteArray();
                        q.f(arr_b, "outputStream.toByteArray()");
                    }
                }
                h0.O(25, arr_b);
                h0.a(26, ((long)d0.c));
                h0.a(27, ((long)d0.d));
                h0.a(28, ((long)d0.e));
                h0.a(29, ((long)d0.f));
                h0.a(30, d0.g);
                h0.a(0x1F, d0.h);
                Set set0 = d0.i;
                q.g(set0, "triggers");
                if(set0.isEmpty()) {
                    arr_b1 = new byte[0];
                }
                else {
                    ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
                    try {
                        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(byteArrayOutputStream1);
                        try {
                            objectOutputStream1.writeInt(set0.size());
                            for(Object object1: set0) {
                                objectOutputStream1.writeUTF(((c)object1).a.toString());
                                objectOutputStream1.writeBoolean(((c)object1).b);
                            }
                        }
                        catch(Throwable throwable3) {
                            d8.d.l(objectOutputStream1, throwable3);
                            throw throwable3;
                        }
                        objectOutputStream1.close();
                    }
                    catch(Throwable throwable2) {
                        d8.d.l(byteArrayOutputStream1, throwable2);
                        throw throwable2;
                    }
                    byteArrayOutputStream1.close();
                    arr_b1 = byteArrayOutputStream1.toByteArray();
                    q.f(arr_b1, "outputStream.toByteArray()");
                }
                h0.O(0x20, arr_b1);
                return;
            }
            default: {
                h0.k(1, ((d5.u)object0).a);
                h0.k(2, ((d5.u)object0).b);
            }
        }
    }

    public final void p(Object object0) {
        h h0 = this.a();
        try {
            this.o(h0, object0);
            h0.D();
        }
        finally {
            this.n(h0);
        }
    }
}

