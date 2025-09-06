package com.google.android.gms.internal.play_billing;

import U4.x;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.TreeMap;

final class zzee {
    private static final char[] zza;

    static {
        char[] arr_c = new char[80];
        zzee.zza = arr_c;
        Arrays.fill(arr_c, ' ');
    }

    public static String zza(zzec zzec0, String s) {
        StringBuilder stringBuilder0 = x.p("# ", s);
        zzee.zzd(zzec0, stringBuilder0, 0);
        return stringBuilder0.toString();
    }

    public static void zzb(StringBuilder stringBuilder0, int v, String s, Object object0) {
        if(object0 instanceof List) {
            for(Object object1: ((List)object0)) {
                zzee.zzb(stringBuilder0, v, s, object1);
            }
            return;
        }
        if(object0 instanceof Map) {
            for(Object object2: ((Map)object0).entrySet()) {
                zzee.zzb(stringBuilder0, v, s, ((Map.Entry)object2));
            }
            return;
        }
        stringBuilder0.append('\n');
        zzee.zzc(v, stringBuilder0);
        if(!s.isEmpty()) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(Character.toLowerCase(s.charAt(0)));
            for(int v1 = 1; v1 < s.length(); ++v1) {
                int v2 = s.charAt(v1);
                if(Character.isUpperCase(((char)v2))) {
                    stringBuilder1.append("_");
                }
                stringBuilder1.append(Character.toLowerCase(((char)v2)));
            }
            s = stringBuilder1.toString();
        }
        stringBuilder0.append(s);
        if(object0 instanceof String) {
            stringBuilder0.append(": \"");
            stringBuilder0.append(zzfd.zza(new zzbn(((String)object0).getBytes(zzda.zzb))));
            stringBuilder0.append('\"');
            return;
        }
        if(object0 instanceof zzbq) {
            stringBuilder0.append(": \"");
            stringBuilder0.append(zzfd.zza(((zzbq)object0)));
            stringBuilder0.append('\"');
            return;
        }
        if(object0 instanceof zzcs) {
            stringBuilder0.append(" {");
            zzee.zzd(((zzcs)object0), stringBuilder0, v + 2);
            stringBuilder0.append("\n");
            zzee.zzc(v, stringBuilder0);
            stringBuilder0.append("}");
            return;
        }
        if(object0 instanceof Map.Entry) {
            stringBuilder0.append(" {");
            zzee.zzb(stringBuilder0, v + 2, "key", ((Map.Entry)object0).getKey());
            zzee.zzb(stringBuilder0, v + 2, "value", ((Map.Entry)object0).getValue());
            stringBuilder0.append("\n");
            zzee.zzc(v, stringBuilder0);
            stringBuilder0.append("}");
            return;
        }
        stringBuilder0.append(": ");
        stringBuilder0.append(object0);
    }

    private static void zzc(int v, StringBuilder stringBuilder0) {
        while(true) {
            int v1 = 80;
            if(v <= 0) {
                break;
            }
            if(v <= 80) {
                v1 = v;
            }
            stringBuilder0.append(zzee.zza, 0, v1);
            v -= v1;
        }
    }

    private static void zzd(zzec zzec0, StringBuilder stringBuilder0, int v) {
        boolean z;
        HashSet hashSet0 = new HashSet();
        HashMap hashMap0 = new HashMap();
        TreeMap treeMap0 = new TreeMap();
        Method[] arr_method = zzec0.getClass().getDeclaredMethods();
        for(int v1 = 0; v1 < arr_method.length; ++v1) {
            Method method0 = arr_method[v1];
            if(!Modifier.isStatic(method0.getModifiers()) && method0.getName().length() >= 3) {
                if(method0.getName().startsWith("set")) {
                    hashSet0.add(method0.getName());
                }
                else if(Modifier.isPublic(method0.getModifiers()) && method0.getParameterTypes().length == 0) {
                    if(method0.getName().startsWith("has")) {
                        hashMap0.put(method0.getName(), method0);
                    }
                    else if(method0.getName().startsWith("get")) {
                        treeMap0.put(method0.getName(), method0);
                    }
                }
            }
        }
        for(Object object0: treeMap0.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            String s = ((String)map$Entry0.getKey()).substring(3);
            if(s.endsWith("List") && !s.endsWith("OrBuilderList") && !s.equals("List")) {
                Method method1 = (Method)map$Entry0.getValue();
                if(method1 != null && method1.getReturnType().equals(List.class)) {
                    zzee.zzb(stringBuilder0, v, s.substring(0, s.length() - 4), zzcs.zzp(method1, zzec0, new Object[0]));
                    continue;
                }
            }
            if(s.endsWith("Map") && !s.equals("Map")) {
                Method method2 = (Method)map$Entry0.getValue();
                if(method2 != null && method2.getReturnType().equals(Map.class) && !method2.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method2.getModifiers())) {
                    zzee.zzb(stringBuilder0, v, s.substring(0, s.length() - 3), zzcs.zzp(method2, zzec0, new Object[0]));
                    continue;
                }
            }
            if(hashSet0.contains("set" + s) && (!s.endsWith("Bytes") || !treeMap0.containsKey("get" + s.substring(0, s.length() - 5)))) {
                Method method3 = (Method)map$Entry0.getValue();
                Method method4 = (Method)hashMap0.get("has" + s);
                if(method3 != null) {
                    Object object1 = zzcs.zzp(method3, zzec0, new Object[0]);
                    if(method4 == null) {
                        if(object1 instanceof Boolean) {
                            if(!((Boolean)object1).booleanValue()) {
                                continue;
                            }
                            goto label_65;
                        }
                        else if(object1 instanceof Integer) {
                            if(((int)(((Integer)object1))) == 0) {
                                continue;
                            }
                            goto label_65;
                        }
                        else if(object1 instanceof Float) {
                            if(Float.floatToRawIntBits(((float)(((Float)object1)))) == 0) {
                                continue;
                            }
                            goto label_65;
                        }
                        else if(object1 instanceof Double) {
                            if(Double.doubleToRawLongBits(((double)(((Double)object1)))) == 0L) {
                                continue;
                            }
                            goto label_65;
                        }
                        else if(object1 instanceof String) {
                            z = object1.equals("");
                            goto label_57;
                        }
                        else {
                            if(object1 instanceof zzbq) {
                                z = object1.equals(zzbq.zzb);
                            label_57:
                                if(z) {
                                    continue;
                                }
                            }
                            else if(object1 instanceof zzec) {
                                if(object1 == ((zzec)object1).zzh()) {
                                    continue;
                                }
                            }
                            else if(object1 instanceof Enum && ((Enum)object1).ordinal() == 0) {
                                continue;
                            }
                            goto label_65;
                        }
                        goto label_64;
                    }
                    else {
                    label_64:
                        if(((Boolean)zzcs.zzp(method4, zzec0, new Object[0])).booleanValue()) {
                            goto label_65;
                        }
                        continue;
                    }
                label_65:
                    zzee.zzb(stringBuilder0, v, s, object1);
                }
            }
        }
        if(zzec0 instanceof zzco) {
            Iterator iterator1 = ((zzco)zzec0).zzb.zzf();
            if(iterator1.hasNext()) {
                Object object2 = iterator1.next();
                zzcp zzcp0 = (zzcp)((Map.Entry)object2).getKey();
                throw null;
            }
        }
        zzfg zzfg0 = ((zzcs)zzec0).zzc;
        if(zzfg0 != null) {
            zzfg0.zzi(stringBuilder0, v);
        }
    }
}

