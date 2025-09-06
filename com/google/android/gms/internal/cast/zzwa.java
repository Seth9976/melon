package com.google.android.gms.internal.cast;

import U4.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class zzwa implements zzyl {
    protected int zza;

    public zzwa() {
        this.zza = 0;
    }

    public final byte[] zzP() {
        try {
            int v = this.zzw();
            byte[] arr_b = new byte[v];
            zzwr zzwr0 = new zzwr(arr_b, 0, v);
            this.zzO(zzwr0);
            zzwr0.zzB();
            return arr_b;
        }
        catch(IOException iOException0) {
            throw new RuntimeException(x.k("Serializing ", this.getClass().getName(), " to a byte array threw an IOException (should never happen)."), iOException0);
        }
    }

    public int zzr(zzyv zzyv0) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.cast.zzyl
    public final zzwn zzs() {
        try {
            int v = this.zzw();
            byte[] arr_b = new byte[v];
            zzwr zzwr0 = new zzwr(arr_b, 0, v);
            this.zzO(zzwr0);
            zzwr0.zzB();
            return new zzwl(arr_b);
        }
        catch(IOException iOException0) {
            throw new RuntimeException(x.k("Serializing ", this.getClass().getName(), " to a ByteString threw an IOException (should never happen)."), iOException0);
        }
    }

    public static void zzt(Iterable iterable0, List list0) {
        int v = ((Collection)iterable0).size();
        if(list0 instanceof ArrayList) {
            ((ArrayList)list0).ensureCapacity(list0.size() + v);
        }
        else if(list0 instanceof zzyt) {
            ((zzyt)list0).zzf(list0.size() + v);
        }
        int v1 = list0.size();
        int v2 = ((List)iterable0).size();
        for(int v3 = 0; v3 < v2; ++v3) {
            Object object0 = ((List)iterable0).get(v3);
            if(object0 == null) {
                String s = "Element at index " + (list0.size() - v1) + " is null.";
                int v4 = list0.size();
                while(true) {
                    --v4;
                    if(v4 < v1) {
                        break;
                    }
                    list0.remove(v4);
                }
                throw new NullPointerException(s);
            }
            list0.add(object0);
        }
    }
}

