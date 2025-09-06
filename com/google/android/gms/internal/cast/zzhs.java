package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.Objects;

final class zzhs extends zzhj {
    static final zzhj zza;
    final transient Object[] zzb;
    private final transient Object zzc;
    private final transient int zzd;

    static {
        zzhs.zza = new zzhs(null, new Object[0], 0);
    }

    private zzhs(Object object0, Object[] arr_object, int v) {
        this.zzc = object0;
        this.zzb = arr_object;
        this.zzd = v;
    }

    @Override  // com.google.android.gms.internal.cast.zzhj
    public final Object get(Object object0) {
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
                        for(int v1 = zzgz.zza(object0.hashCode()); true; v1 = v2 + 1) {
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
                        for(int v5 = zzgz.zza(object0.hashCode()); true; v5 = v6 + 1) {
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
                        for(int v9 = zzgz.zza(object0.hashCode()); true; v9 = v10 + 1) {
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

    @Override  // com.google.android.gms.internal.cast.zzhj
    public final zzhc zza() {
        return new zzhr(this.zzb, 1, this.zzd);
    }

    @Override  // com.google.android.gms.internal.cast.zzhj
    public final zzhk zze() {
        return new zzhp(this, this.zzb, 0, this.zzd);
    }

    @Override  // com.google.android.gms.internal.cast.zzhj
    public final zzhk zzf() {
        return new zzhq(this, new zzhr(this.zzb, 0, this.zzd));
    }

    public static zzhs zzh(int v, Object[] arr_object, zzhi zzhi0) {
        Object object0 = null;
        switch(v) {
            case 0: {
                return (zzhs)zzhs.zza;
            }
            case 1: {
                Object object11 = arr_object[0];
                Objects.requireNonNull(object11);
                Object object12 = arr_object[1];
                Objects.requireNonNull(object12);
                zzgx.zza(object11, object12);
                return new zzhs(null, arr_object, 1);
            }
            default: {
                zzgo.zzb(v, arr_object.length >> 1, "index");
                int v1 = zzhk.zzh(v);
                if(v1 <= 0x80) {
                    byte[] arr_b = new byte[v1];
                    Arrays.fill(arr_b, -1);
                    int v3 = 0;
                    for(int v2 = 0; v2 < v; ++v2) {
                        int v4 = v3 + v3;
                        int v5 = v2 + v2;
                        Object object1 = arr_object[v5];
                        Objects.requireNonNull(object1);
                        Object object2 = arr_object[v5 ^ 1];
                        Objects.requireNonNull(object2);
                        zzgx.zza(object1, object2);
                        for(int v6 = zzgz.zza(object1.hashCode()); true; v6 = v7 + 1) {
                            int v7 = v6 & v1 - 1;
                            int v8 = arr_b[v7] & 0xFF;
                            if(v8 == 0xFF) {
                                arr_b[v7] = (byte)v4;
                                if(v3 < v2) {
                                    arr_object[v4] = object1;
                                    arr_object[v4 ^ 1] = object2;
                                }
                                ++v3;
                                break;
                            }
                            if(object1.equals(arr_object[v8])) {
                                Object object3 = arr_object[v8 ^ 1];
                                Objects.requireNonNull(object3);
                                zzhh zzhh0 = new zzhh(object1, object2, object3);
                                arr_object[v8 ^ 1] = object2;
                                object0 = zzhh0;
                                break;
                            }
                        }
                    }
                    object0 = v3 == v ? arr_b : new Object[]{arr_b, v3, object0};
                }
                else if(v1 <= 0x8000) {
                    short[] arr_v = new short[v1];
                    Arrays.fill(arr_v, -1);
                    int v10 = 0;
                    for(int v9 = 0; v9 < v; ++v9) {
                        int v11 = v10 + v10;
                        int v12 = v9 + v9;
                        Object object4 = arr_object[v12];
                        Objects.requireNonNull(object4);
                        Object object5 = arr_object[v12 ^ 1];
                        Objects.requireNonNull(object5);
                        zzgx.zza(object4, object5);
                        for(int v13 = zzgz.zza(object4.hashCode()); true; v13 = v14 + 1) {
                            int v14 = v13 & v1 - 1;
                            int v15 = (char)arr_v[v14];
                            if(v15 == 0xFFFF) {
                                arr_v[v14] = (short)v11;
                                if(v10 < v9) {
                                    arr_object[v11] = object4;
                                    arr_object[v11 ^ 1] = object5;
                                }
                                ++v10;
                                break;
                            }
                            if(object4.equals(arr_object[v15])) {
                                Object object6 = arr_object[v15 ^ 1];
                                Objects.requireNonNull(object6);
                                zzhh zzhh1 = new zzhh(object4, object5, object6);
                                arr_object[v15 ^ 1] = object5;
                                object0 = zzhh1;
                                break;
                            }
                        }
                    }
                    object0 = v10 == v ? arr_v : new Object[]{arr_v, v10, object0};
                }
                else {
                    int[] arr_v1 = new int[v1];
                    Arrays.fill(arr_v1, -1);
                    int v17 = 0;
                    for(int v16 = 0; v16 < v; ++v16) {
                        int v18 = v17 + v17;
                        int v19 = v16 + v16;
                        Object object7 = arr_object[v19];
                        Objects.requireNonNull(object7);
                        Object object8 = arr_object[v19 ^ 1];
                        Objects.requireNonNull(object8);
                        zzgx.zza(object7, object8);
                        for(int v20 = zzgz.zza(object7.hashCode()); true; v20 = v21 + 1) {
                            int v21 = v20 & v1 - 1;
                            int v22 = arr_v1[v21];
                            if(v22 == -1) {
                                arr_v1[v21] = v18;
                                if(v17 < v16) {
                                    arr_object[v18] = object7;
                                    arr_object[v18 ^ 1] = object8;
                                }
                                ++v17;
                                break;
                            }
                            if(object7.equals(arr_object[v22])) {
                                Object object9 = arr_object[v22 ^ 1];
                                Objects.requireNonNull(object9);
                                zzhh zzhh2 = new zzhh(object7, object8, object9);
                                arr_object[v22 ^ 1] = object8;
                                object0 = zzhh2;
                                break;
                            }
                        }
                    }
                    object0 = v17 == v ? arr_v1 : new Object[]{arr_v1, v17, object0};
                }
                if(object0 instanceof Object[]) {
                    zzhi0.zzc = (zzhh)((Object[])object0)[2];
                    Object object10 = ((Object[])object0)[0];
                    int v23 = (int)(((Integer)((Object[])object0)[1]));
                    arr_object = Arrays.copyOf(arr_object, v23 + v23);
                    object0 = object10;
                    v = v23;
                }
                return new zzhs(object0, arr_object, v);
            }
        }
    }
}

