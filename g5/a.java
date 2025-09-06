package g5;

import E9.w;
import android.database.Cursor;
import androidx.room.O;
import androidx.work.impl.WorkDatabase_Impl;
import d5.g;
import d5.i;
import d5.j;
import d5.l;
import d5.t;
import d5.v;
import java.util.ArrayList;
import je.p;
import kotlin.jvm.internal.q;

public abstract class a {
    public static final String a;

    // 去混淆评级： 低(20)
    static {
        q.f("WM-DiagnosticsWrkr", "tagWithPrefix(\"DiagnosticsWrkr\")");
        a.a = "WM-DiagnosticsWrkr";
    }

    public static final String a(l l0, v v0, i i0, ArrayList arrayList0) {
        ArrayList arrayList1;
        StringBuilder stringBuilder0 = new StringBuilder("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        for(Object object0: arrayList0) {
            j j0 = t.i(((d5.q)object0));
            String s = ((d5.q)object0).a;
            g g0 = i0.f(j0);
            Integer integer0 = g0 == null ? null : g0.c;
            l0.getClass();
            O o0 = O.c(1, "SELECT name FROM workname WHERE work_spec_id=?");
            o0.k(1, s);
            WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)l0.b;
            workDatabase_Impl0.assertNotSuspendingTransaction();
            Cursor cursor0 = w.R(workDatabase_Impl0, o0, false);
            try {
                arrayList1 = new ArrayList(cursor0.getCount());
                while(cursor0.moveToNext()) {
                    arrayList1.add(cursor0.getString(0));
                }
            }
            finally {
                cursor0.close();
                o0.release();
            }
            String s1 = p.q0(arrayList1, ",", null, null, null, 62);
            String s2 = p.q0(v0.O(s), ",", null, null, null, 62);
            StringBuilder stringBuilder1 = com.iloen.melon.utils.a.n("\n", s, "\t ");
            stringBuilder1.append(((d5.q)object0).c);
            stringBuilder1.append("\t ");
            stringBuilder1.append(integer0);
            stringBuilder1.append("\t ");
            stringBuilder1.append(((d5.q)object0).b.name());
            stringBuilder1.append("\t ");
            stringBuilder1.append(s1);
            stringBuilder1.append("\t ");
            stringBuilder1.append(s2);
            stringBuilder1.append('\t');
            stringBuilder0.append(stringBuilder1.toString());
        }
        String s3 = stringBuilder0.toString();
        q.f(s3, "StringBuilder().apply(builderAction).toString()");
        return s3;
    }
}

