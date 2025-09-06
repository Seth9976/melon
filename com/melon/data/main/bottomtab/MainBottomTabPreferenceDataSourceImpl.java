package com.melon.data.main.bottomtab;

import android.content.Context;
import com.iloen.melon.utils.datastore.MainBottomTabBadgePreferenceKeys;
import com.iloen.melon.utils.datastore.MainBottomTabDataStoreKt;
import d5.n;
import df.v;
import e.k;
import ie.H;
import ie.m;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import l2.i;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import pa.d;
import pa.e;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/melon/data/main/bottomtab/MainBottomTabPreferenceDataSourceImpl;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MainBottomTabPreferenceDataSourceImpl {
    public final i a;

    @Inject
    public MainBottomTabPreferenceDataSourceImpl(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.a = MainBottomTabDataStoreKt.getMainBottomTabBadgeDataStore(context0);
        Iterable iterable0 = k.A(new String[]{MainBottomTabBadgePreferenceKeys.INSTANCE.getAREA_CODE_FORYOU_TAB().a, MainBottomTabBadgePreferenceKeys.INSTANCE.getAREA_CODE_SEARCH_TAB().a, MainBottomTabBadgePreferenceKeys.INSTANCE.getAREA_CODE_LIBRARY_TAB().a, MainBottomTabBadgePreferenceKeys.INSTANCE.getAREA_CODE_MENU_TAB().a});
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
        for(Object object0: iterable0) {
            arrayList0.add(new m(((String)object0), v.K(((String)object0))));
        }
    }

    public final Object a(String s, c c0) {
        d d0;
        if(c0 instanceof d) {
            d0 = (d)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new d(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new d(this, c0);
        }
        Object object0 = d0.r;
        a a0 = a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                try {
                    e e0 = new e(s, null);
                    d0.B = 1;
                    if(k.n(this.a, e0, d0) == a0) {
                        return a0;
                    }
                }
                catch(Exception unused_ex) {
                }
                return H.a;
            }
            case 1: {
                try {
                    n.D(object0);
                }
                catch(Exception unused_ex) {
                }
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

