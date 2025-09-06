package com.google.protobuf;

import H0.b;
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

public abstract class n2 {
    public static final char[] a;

    static {
        char[] arr_c = new char[80];
        n2.a = arr_c;
        Arrays.fill(arr_c, ' ');
    }

    public static void a(int v, StringBuilder stringBuilder0) {
        while(true) {
            int v1 = 80;
            if(v <= 0) {
                break;
            }
            if(v <= 80) {
                v1 = v;
            }
            stringBuilder0.append(n2.a, 0, v1);
            v -= v1;
        }
    }

    public static void b(StringBuilder stringBuilder0, int v, String s, Object object0) {
        if(object0 instanceof List) {
            for(Object object1: ((List)object0)) {
                n2.b(stringBuilder0, v, s, object1);
            }
            return;
        }
        if(object0 instanceof Map) {
            for(Object object2: ((Map)object0).entrySet()) {
                n2.b(stringBuilder0, v, s, ((Map.Entry)object2));
            }
            return;
        }
        stringBuilder0.append('\n');
        n2.a(v, stringBuilder0);
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
            stringBuilder0.append(h.B(o.e(((String)object0))));
            stringBuilder0.append('\"');
            return;
        }
        if(object0 instanceof o) {
            stringBuilder0.append(": \"");
            stringBuilder0.append(h.B(((o)object0)));
            stringBuilder0.append('\"');
            return;
        }
        if(object0 instanceof A1) {
            stringBuilder0.append(" {");
            n2.c(((A1)object0), stringBuilder0, v + 2);
            stringBuilder0.append("\n");
            n2.a(v, stringBuilder0);
            stringBuilder0.append("}");
            return;
        }
        if(object0 instanceof Map.Entry) {
            stringBuilder0.append(" {");
            n2.b(stringBuilder0, v + 2, "key", ((Map.Entry)object0).getKey());
            n2.b(stringBuilder0, v + 2, "value", ((Map.Entry)object0).getValue());
            stringBuilder0.append("\n");
            n2.a(v, stringBuilder0);
            stringBuilder0.append("}");
            return;
        }
        stringBuilder0.append(": ");
        stringBuilder0.append(object0);
    }

    public static void c(A1 a10, StringBuilder stringBuilder0, int v) {
        int v3;
        HashSet hashSet0 = new HashSet();
        HashMap hashMap0 = new HashMap();
        TreeMap treeMap0 = new TreeMap();
        Method[] arr_method = a10.getClass().getDeclaredMethods();
        for(int v2 = 0; v2 < arr_method.length; ++v2) {
            Method method0 = arr_method[v2];
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
                    n2.b(stringBuilder0, v, b.d(4, 0, s), A1.invokeOrDie(method1, a10, new Object[0]));
                    continue;
                }
            }
            if(s.endsWith("Map") && !s.equals("Map")) {
                Method method2 = (Method)map$Entry0.getValue();
                if(method2 != null && method2.getReturnType().equals(Map.class) && !method2.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method2.getModifiers())) {
                    n2.b(stringBuilder0, v, b.d(3, 0, s), A1.invokeOrDie(method2, a10, new Object[0]));
                    continue;
                }
            }
            if(hashSet0.contains("set" + s) && (!s.endsWith("Bytes") || !treeMap0.containsKey("get" + s.substring(0, s.length() - 5)))) {
                Method method3 = (Method)map$Entry0.getValue();
                Method method4 = (Method)hashMap0.get("has" + s);
                if(method3 != null) {
                    boolean z = true;
                    Object object1 = A1.invokeOrDie(method3, a10, new Object[0]);
                    if(method4 == null) {
                        if(object1 instanceof Boolean) {
                            v3 = !((Boolean)object1).booleanValue();
                        }
                        else {
                            if(!(object1 instanceof Integer)) {
                                if(!(object1 instanceof Float)) {
                                    if(!(object1 instanceof Double)) {
                                        if(object1 instanceof String) {
                                            v3 = object1.equals("");
                                            goto label_71;
                                        }
                                        else if(object1 instanceof o) {
                                            v3 = object1.equals(o.b);
                                            goto label_71;
                                        }
                                        else if(!(object1 instanceof l2)) {
                                            if(object1 instanceof Enum && ((Enum)object1).ordinal() == 0) {
                                                v3 = 1;
                                                goto label_71;
                                            }
                                        }
                                        else if(object1 == ((l2)object1).getDefaultInstanceForType()) {
                                            v3 = 1;
                                            goto label_71;
                                        }
                                    }
                                    else if(Double.doubleToRawLongBits(((double)(((Double)object1)))) == 0L) {
                                        v3 = 1;
                                        goto label_71;
                                    }
                                }
                                else if(Float.floatToRawIntBits(((float)(((Float)object1)))) == 0) {
                                    v3 = 1;
                                    goto label_71;
                                }
                            }
                            else if(((int)(((Integer)object1))) == 0) {
                                v3 = 1;
                                goto label_71;
                            }
                            v3 = 0;
                        }
                    label_71:
                        if(v3 != 0) {
                            z = false;
                        }
                    }
                    else {
                        z = ((Boolean)A1.invokeOrDie(method4, a10, new Object[0])).booleanValue();
                    }
                    if(z) {
                        n2.b(stringBuilder0, v, s, object1);
                    }
                }
            }
        }
        if(a10 instanceof GeneratedMessageLite.ExtendableMessage) {
            Iterator iterator1 = ((GeneratedMessageLite.ExtendableMessage)a10).extensions.k();
            while(iterator1.hasNext()) {
                Object object2 = iterator1.next();
                StringBuilder stringBuilder1 = new StringBuilder("[");
                n2.b(stringBuilder0, v, x.g(((x1)((Map.Entry)object2).getKey()).a, "]", stringBuilder1), ((Map.Entry)object2).getValue());
            }
        }
        S2 s20 = a10.unknownFields;
        if(s20 != null) {
            for(int v1 = 0; v1 < s20.a; ++v1) {
                n2.b(stringBuilder0, v, String.valueOf(s20.b[v1] >>> 3), s20.c[v1]);
            }
        }
    }
}

