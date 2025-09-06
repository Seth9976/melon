package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.Objects;
import javax.annotation.CheckForNull;

final class zzat extends zzal {
    static final zzal zza;
    final transient Object[] zzb;
    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    static {
        zzat.zza = new zzat(null, new Object[0], 0);
    }

    private zzat(@CheckForNull Object object0, Object[] arr_object, int v) {
        this.zzc = object0;
        this.zzb = arr_object;
        this.zzd = v;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzal
    @CheckForNull
    public final Object get(@CheckForNull Object object0) {
        Object object2;
        if(object0 != null) {
            Object[] arr_object = this.zzb;
            if(this.zzd == 1) {
                Object object1 = arr_object[0];
                Objects.requireNonNull(object1);
                if(object1.equals(object0)) {
                    object2 = arr_object[1];
                    Objects.requireNonNull(object2);
                    return object2 == null ? null : object2;
                }
            }
            else {
                Object object3 = this.zzc;
                if(object3 != null) {
                    if(object3 instanceof byte[]) {
                        int v = ((byte[])object3).length - 1;
                        for(int v1 = zzae.zza(object0.hashCode()); true; v1 = v2 + 1) {
                            int v2 = v1 & v;
                            int v3 = ((byte[])object3)[v2] & 0xFF;
                            if(v3 == 0xFF) {
                                break;
                            }
                            if(object0.equals(arr_object[v3])) {
                                object2 = arr_object[v3 ^ 1];
                                return object2 == null ? null : object2;
                            }
                        }
                    }
                    else if(object3 instanceof short[]) {
                        int v4 = ((short[])object3).length - 1;
                        for(int v5 = zzae.zza(object0.hashCode()); true; v5 = v6 + 1) {
                            int v6 = v5 & v4;
                            int v7 = (char)((short[])object3)[v6];
                            if(v7 == 0xFFFF) {
                                break;
                            }
                            if(object0.equals(arr_object[v7])) {
                                object2 = arr_object[v7 ^ 1];
                                return object2 == null ? null : object2;
                            }
                        }
                    }
                    else {
                        int v8 = ((int[])object3).length - 1;
                        for(int v9 = zzae.zza(object0.hashCode()); true; v9 = v10 + 1) {
                            int v10 = v9 & v8;
                            int v11 = ((int[])object3)[v10];
                            if(v11 == -1) {
                                break;
                            }
                            if(object0.equals(arr_object[v11])) {
                                object2 = arr_object[v11 ^ 1];
                                return object2 == null ? null : object2;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public final int size() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzal
    public final zzaf zza() {
        return new zzas(this.zzb, 1, this.zzd);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzal
    public final zzam zzd() {
        return new zzaq(this, this.zzb, 0, this.zzd);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzal
    public final zzam zze() {
        return new zzar(this, new zzas(this.zzb, 0, this.zzd));
    }

    public static zzat zzg(int v, Object[] arr_object, zzak zzak0) {
        byte[] arr_b = null;
        switch(v) {
            case 0: {
                return (zzat)zzat.zza;
            }
            case 1: {
                Object object10 = arr_object[0];
                Objects.requireNonNull(object10);
                Object object11 = arr_object[1];
                Objects.requireNonNull(object11);
                zzad.zza(object10, object11);
                return new zzat(null, arr_object, 1);
            }
            default: {
                int v1 = 0x40000000;
                zzaa.zzb(v, arr_object.length >> 1, "index");
                int v2 = Math.max(v, 2);
                if(v2 < 0x2CCCCCCC) {
                    v1 = Integer.highestOneBit(v2 - 1);
                    while(true) {
                        v1 += v1;
                        if(((double)v1) * 0.7 >= ((double)v2)) {
                            goto label_11;
                        }
                    }
                }
                if(v2 >= 0x40000000) {
                    throw new IllegalArgumentException("collection too large");
                }
            label_11:
                if(v1 <= 0x80) {
                    byte[] arr_b1 = new byte[v1];
                    Arrays.fill(arr_b1, -1);
                    int v4 = 0;
                    for(int v3 = 0; v3 < v; ++v3) {
                        int v5 = v4 + v4;
                        int v6 = v3 + v3;
                        Object object0 = arr_object[v6];
                        Objects.requireNonNull(object0);
                        Object object1 = arr_object[v6 ^ 1];
                        Objects.requireNonNull(object1);
                        zzad.zza(object0, object1);
                        for(int v7 = zzae.zza(object0.hashCode()); true; v7 = v8 + 1) {
                            int v8 = v7 & v1 - 1;
                            int v9 = arr_b1[v8] & 0xFF;
                            if(v9 == 0xFF) {
                                arr_b1[v8] = (byte)v5;
                                if(v4 < v3) {
                                    arr_object[v5] = object0;
                                    arr_object[v5 ^ 1] = object1;
                                }
                                ++v4;
                                break;
                            }
                            if(object0.equals(arr_object[v9])) {
                                Object object2 = arr_object[v9 ^ 1];
                                Objects.requireNonNull(object2);
                                zzaj zzaj0 = new zzaj(object0, object1, object2);
                                arr_object[v9 ^ 1] = object1;
                                arr_b = zzaj0;
                                break;
                            }
                        }
                    }
                    arr_b = v4 == v ? arr_b1 : new Object[]{arr_b1, v4, arr_b};
                }
                else if(v1 <= 0x8000) {
                    short[] arr_v = new short[v1];
                    Arrays.fill(arr_v, -1);
                    int v11 = 0;
                    for(int v10 = 0; v10 < v; ++v10) {
                        int v12 = v11 + v11;
                        int v13 = v10 + v10;
                        Object object3 = arr_object[v13];
                        Objects.requireNonNull(object3);
                        Object object4 = arr_object[v13 ^ 1];
                        Objects.requireNonNull(object4);
                        zzad.zza(object3, object4);
                        for(int v14 = zzae.zza(object3.hashCode()); true; v14 = v15 + 1) {
                            int v15 = v14 & v1 - 1;
                            int v16 = (char)arr_v[v15];
                            if(v16 == 0xFFFF) {
                                arr_v[v15] = (short)v12;
                                if(v11 < v10) {
                                    arr_object[v12] = object3;
                                    arr_object[v12 ^ 1] = object4;
                                }
                                ++v11;
                                break;
                            }
                            if(object3.equals(arr_object[v16])) {
                                Object object5 = arr_object[v16 ^ 1];
                                Objects.requireNonNull(object5);
                                zzaj zzaj1 = new zzaj(object3, object4, object5);
                                arr_object[v16 ^ 1] = object4;
                                arr_b = zzaj1;
                                break;
                            }
                        }
                    }
                    arr_b = v11 == v ? arr_v : new Object[]{arr_v, v11, arr_b};
                }
                else {
                    int[] arr_v1 = new int[v1];
                    Arrays.fill(arr_v1, -1);
                    int v18 = 0;
                    for(int v17 = 0; v17 < v; ++v17) {
                        int v19 = v18 + v18;
                        int v20 = v17 + v17;
                        Object object6 = arr_object[v20];
                        Objects.requireNonNull(object6);
                        Object object7 = arr_object[v20 ^ 1];
                        Objects.requireNonNull(object7);
                        zzad.zza(object6, object7);
                        for(int v21 = zzae.zza(object6.hashCode()); true; v21 = v22 + 1) {
                            int v22 = v21 & v1 - 1;
                            int v23 = arr_v1[v22];
                            if(v23 == -1) {
                                arr_v1[v22] = v19;
                                if(v18 < v17) {
                                    arr_object[v19] = object6;
                                    arr_object[v19 ^ 1] = object7;
                                }
                                ++v18;
                                break;
                            }
                            if(object6.equals(arr_object[v23])) {
                                Object object8 = arr_object[v23 ^ 1];
                                Objects.requireNonNull(object8);
                                zzaj zzaj2 = new zzaj(object6, object7, object8);
                                arr_object[v23 ^ 1] = object7;
                                arr_b = zzaj2;
                                break;
                            }
                        }
                    }
                    arr_b = v18 == v ? arr_v1 : new Object[]{arr_v1, v18, arr_b};
                }
                if(arr_b instanceof Object[]) {
                    zzaj zzaj3 = (zzaj)((Object[])arr_b)[2];
                    if(zzak0 == null) {
                        throw zzaj3.zza();
                    }
                    zzak0.zzc = zzaj3;
                    Object object9 = ((Object[])arr_b)[0];
                    int v24 = (int)(((Integer)((Object[])arr_b)[1]));
                    return new zzat(object9, Arrays.copyOf(arr_object, v24 + v24), v24);
                }
                return new zzat(arr_b, arr_object, v);
            }
        }
    }
}

