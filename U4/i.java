package U4;

import E9.h;
import d8.d;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import je.n;
import je.p;
import kotlin.jvm.internal.q;

public final class i {
    public final HashMap a;
    public static final i b;

    static {
        i i0 = new i(new LinkedHashMap());
        h.X(i0);
        i.b = i0;
    }

    public i(i i0) {
        q.g(i0, "other");
        super();
        this.a = new HashMap(i0.a);
    }

    public i(LinkedHashMap linkedHashMap0) {
        q.g(linkedHashMap0, "values");
        super();
        this.a = new HashMap(linkedHashMap0);
    }

    public static final i a(byte[] arr_b) {
        DataInputStream dataInputStream0;
        ObjectInputStream objectInputStream0;
        int v;
        ByteArrayInputStream byteArrayInputStream0;
        q.g(arr_b, "bytes");
        if(arr_b.length > 0x2800) {
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        }
        if(arr_b.length == 0) {
            return i.b;
        }
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        try {
            boolean z = true;
            byteArrayInputStream0 = new ByteArrayInputStream(arr_b);
            byte[] arr_b1 = new byte[2];
            byteArrayInputStream0.read(arr_b1);
            v = 0;
            if(arr_b1[0] != -84 || arr_b1[1] != -19) {
                z = false;
            }
            byteArrayInputStream0.reset();
            if(z) {
                objectInputStream0 = new ObjectInputStream(byteArrayInputStream0);
                goto label_15;
            }
            goto label_27;
        }
        catch(IOException iOException0) {
            w.e().d("WM-Data", "Error in Data#fromByteArray: ", iOException0);
            return new i(linkedHashMap0);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            w.e().d("WM-Data", "Error in Data#fromByteArray: ", classNotFoundException0);
            return new i(linkedHashMap0);
        }
        try {
        label_15:
            int v1 = objectInputStream0.readInt();
            while(true) {
                if(v >= v1) {
                    goto label_25;
                }
                String s = objectInputStream0.readUTF();
                q.f(s, "readUTF()");
                linkedHashMap0.put(s, objectInputStream0.readObject());
                ++v;
            }
        }
        catch(Throwable throwable0) {
            try {
                d.l(objectInputStream0, throwable0);
                throw throwable0;
            label_25:
                objectInputStream0.close();
            }
            catch(IOException iOException0) {
                w.e().d("WM-Data", "Error in Data#fromByteArray: ", iOException0);
                return new i(linkedHashMap0);
            }
            catch(ClassNotFoundException classNotFoundException0) {
                w.e().d("WM-Data", "Error in Data#fromByteArray: ", classNotFoundException0);
                return new i(linkedHashMap0);
            }
        }
        return new i(linkedHashMap0);
        try {
        label_27:
            dataInputStream0 = new DataInputStream(byteArrayInputStream0);
        }
        catch(IOException iOException0) {
            w.e().d("WM-Data", "Error in Data#fromByteArray: ", iOException0);
            return new i(linkedHashMap0);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            w.e().d("WM-Data", "Error in Data#fromByteArray: ", classNotFoundException0);
            return new i(linkedHashMap0);
        }
        try {
            int v2 = dataInputStream0.readShort();
            if(v2 != 0xFFFFABEF) {
                throw new IllegalStateException(("Magic number doesn\'t match: " + v2).toString());
            }
            int v3 = dataInputStream0.readShort();
            if(v3 != 1) {
                throw new IllegalStateException(("Unsupported version number: " + v3).toString());
            }
            int v4 = dataInputStream0.readInt();
            while(true) {
                if(v >= v4) {
                    goto label_45;
                }
                Serializable serializable0 = h.v(dataInputStream0, dataInputStream0.readByte());
                String s1 = dataInputStream0.readUTF();
                q.f(s1, "key");
                linkedHashMap0.put(s1, serializable0);
                ++v;
            }
        }
        catch(Throwable throwable1) {
            try {
                d.l(dataInputStream0, throwable1);
                throw throwable1;
            label_45:
                dataInputStream0.close();
                return new i(linkedHashMap0);
            }
            catch(IOException iOException0) {
            }
            catch(ClassNotFoundException classNotFoundException0) {
                w.e().d("WM-Data", "Error in Data#fromByteArray: ", classNotFoundException0);
                return new i(linkedHashMap0);
            }
        }
        w.e().d("WM-Data", "Error in Data#fromByteArray: ", iOException0);
        return new i(linkedHashMap0);
    }

    public final boolean b(String s) {
        Object object0 = this.a.get(s);
        if(object0 != null) {
            Class class0 = object0.getClass();
            return String.class.isAssignableFrom(class0);
        }
        return false;
    }

    @Override
    public final boolean equals(Object object0) {
        boolean z;
        if(this != object0) {
            if(object0 != null) {
                Class class0 = object0.getClass();
                if(i.class.equals(class0)) {
                    HashMap hashMap0 = ((i)object0).a;
                    HashMap hashMap1 = this.a;
                    Set set0 = hashMap1.keySet();
                    if(q.b(set0, hashMap0.keySet())) {
                        Iterator iterator0 = set0.iterator();
                        while(true) {
                            if(!iterator0.hasNext()) {
                                return true;
                            }
                            Object object1 = iterator0.next();
                            Object object2 = hashMap1.get(((String)object1));
                            Object object3 = hashMap0.get(((String)object1));
                            if(object2 == null || object3 == null) {
                                z = object2 == object3;
                            }
                            else if(!(object2 instanceof Object[]) || !(object3 instanceof Object[])) {
                                z = object2.equals(object3);
                            }
                            else {
                                z = n.R(((Object[])object2), ((Object[])object3));
                            }
                            if(z) {
                                continue;
                            }
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        for(Object object0: this.a.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            Object object1 = map$Entry0.getValue();
            v += (object1 instanceof Object[] ? Objects.hashCode(map$Entry0.getKey()) ^ Arrays.deepHashCode(((Object[])object1)) : map$Entry0.hashCode());
        }
        return v * 0x1F;
    }

    @Override
    public final String toString() {
        String s = "Data {" + p.q0(this.a.entrySet(), null, null, null, U4.h.f, 0x1F) + "}";
        q.f(s, "StringBuilder().apply(builderAction).toString()");
        return s;
    }
}

