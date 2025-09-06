package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public abstract class zzkq implements zznk {
    @Override
    public Object clone() {
        return this.zzaR();
    }

    private static void zza(List list0, int v) {
        String s = "Element at index " + (list0.size() - v) + " is null.";
        int v1 = list0.size();
        while(true) {
            --v1;
            if(v1 < v) {
                break;
            }
            list0.remove(v1);
        }
        throw new NullPointerException(s);
    }

    public abstract zzkq zzaR();

    public zzkq zzaS(byte[] arr_b, int v, int v1) {
        throw null;
    }

    public zzkq zzaT(byte[] arr_b, int v, int v1, zzlq zzlq0) {
        throw null;
    }

    public static void zzaU(Iterable iterable0, List list0) {
        iterable0.getClass();
        if(iterable0 instanceof zzmw) {
            List list1 = ((zzmw)iterable0).zza();
            int v1 = list0.size();
            for(Object object0: list1) {
                if(object0 == null) {
                    String s = "Element at index " + (((zzmw)list0).size() - v1) + " is null.";
                    int v2 = ((zzmw)list0).size();
                    while(true) {
                        --v2;
                        if(v2 < v1) {
                            break;
                        }
                        ((zzmw)list0).remove(v2);
                    }
                    throw new NullPointerException(s);
                }
                if(object0 instanceof zzlg) {
                    zzlg zzlg0 = (zzlg)object0;
                    ((zzmw)list0).zzb();
                }
                else if(object0 instanceof byte[]) {
                    zzlg.zzh(((byte[])object0), 0, ((byte[])object0).length);
                    ((zzmw)list0).zzb();
                }
                else {
                    ((zzmw)list0).add(((String)object0));
                }
            }
            return;
        }
        if(!(iterable0 instanceof zzns)) {
            if(iterable0 instanceof Collection) {
                int v3 = ((Collection)iterable0).size();
                if(list0 instanceof ArrayList) {
                    ((ArrayList)list0).ensureCapacity(list0.size() + v3);
                }
                else if(list0 instanceof zznu) {
                    ((zznu)list0).zze(list0.size() + v3);
                }
            }
            int v4 = list0.size();
            if(iterable0 instanceof List && iterable0 instanceof RandomAccess) {
                int v5 = ((List)iterable0).size();
                for(int v = 0; v < v5; ++v) {
                    Object object1 = ((List)iterable0).get(v);
                    if(object1 == null) {
                        zzkq.zza(list0, v4);
                    }
                    list0.add(object1);
                }
                return;
            }
            for(Object object2: iterable0) {
                if(object2 == null) {
                    zzkq.zza(list0, v4);
                }
                list0.add(object2);
            }
            return;
        }
        list0.addAll(((Collection)iterable0));
    }

    @Override  // com.google.android.gms.internal.measurement.zznk
    public final zznk zzaV(byte[] arr_b, zzlq zzlq0) {
        return this.zzaT(arr_b, 0, arr_b.length, zzlq0);
    }

    @Override  // com.google.android.gms.internal.measurement.zznk
    public final zznk zzaW(byte[] arr_b) {
        return this.zzaS(arr_b, 0, arr_b.length);
    }
}

