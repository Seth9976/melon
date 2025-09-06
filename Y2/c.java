package y2;

import U4.x;
import android.util.Log;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class c {
    public final int a;
    public final int b;
    public final long c;
    public final byte[] d;

    public c(long v, byte[] arr_b, int v1, int v2) {
        this.a = v1;
        this.b = v2;
        this.c = v;
        this.d = arr_b;
    }

    public c(byte[] arr_b, int v, int v1) {
        this(-1L, arr_b, v, v1);
    }

    public static c a(long v, ByteOrder byteOrder0) {
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(new byte[g.F[4]]);
        byteBuffer0.order(byteOrder0);
        byteBuffer0.putInt(((int)v));
        return new c(byteBuffer0.array(), 4, 1);
    }

    public static c b(e e0, ByteOrder byteOrder0) {
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(new byte[g.F[5]]);
        byteBuffer0.order(byteOrder0);
        byteBuffer0.putInt(((int)e0.a));
        byteBuffer0.putInt(((int)e0.b));
        return new c(byteBuffer0.array(), 5, 1);
    }

    public static c c(int v, ByteOrder byteOrder0) {
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(new byte[g.F[3]]);
        byteBuffer0.order(byteOrder0);
        byteBuffer0.putShort(((short)v));
        return new c(byteBuffer0.array(), 3, 1);
    }

    public final double d(ByteOrder byteOrder0) {
        Serializable serializable0 = this.g(byteOrder0);
        if(serializable0 == null) {
            throw new NumberFormatException("NULL can\'t be converted to a double value");
        }
        if(serializable0 instanceof String) {
            return Double.parseDouble(((String)serializable0));
        }
        if(serializable0 instanceof long[]) {
            if(((long[])serializable0).length != 1) {
                throw new NumberFormatException("There are more than one component");
            }
            return (double)((long[])serializable0)[0];
        }
        if(serializable0 instanceof int[]) {
            if(((int[])serializable0).length != 1) {
                throw new NumberFormatException("There are more than one component");
            }
            return (double)((int[])serializable0)[0];
        }
        if(serializable0 instanceof double[]) {
            if(((double[])serializable0).length != 1) {
                throw new NumberFormatException("There are more than one component");
            }
            return ((double[])serializable0)[0];
        }
        if(!(serializable0 instanceof e[])) {
            throw new NumberFormatException("Couldn\'t find a double value");
        }
        if(((e[])serializable0).length != 1) {
            throw new NumberFormatException("There are more than one component");
        }
        return ((double)((e[])serializable0)[0].a) / ((double)((e[])serializable0)[0].b);
    }

    public final int e(ByteOrder byteOrder0) {
        Serializable serializable0 = this.g(byteOrder0);
        if(serializable0 == null) {
            throw new NumberFormatException("NULL can\'t be converted to a integer value");
        }
        if(serializable0 instanceof String) {
            return Integer.parseInt(((String)serializable0));
        }
        if(serializable0 instanceof long[]) {
            if(((long[])serializable0).length != 1) {
                throw new NumberFormatException("There are more than one component");
            }
            return (int)((long[])serializable0)[0];
        }
        if(!(serializable0 instanceof int[])) {
            throw new NumberFormatException("Couldn\'t find a integer value");
        }
        if(((int[])serializable0).length != 1) {
            throw new NumberFormatException("There are more than one component");
        }
        return ((int[])serializable0)[0];
    }

    public final String f(ByteOrder byteOrder0) {
        Serializable serializable0 = this.g(byteOrder0);
        if(serializable0 != null) {
            if(serializable0 instanceof String) {
                return (String)serializable0;
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            int v = 0;
            if(serializable0 instanceof long[]) {
                while(v < ((long[])serializable0).length) {
                    stringBuilder0.append(((long[])serializable0)[v]);
                    ++v;
                    if(v != ((long[])serializable0).length) {
                        stringBuilder0.append(",");
                    }
                }
                return stringBuilder0.toString();
            }
            if(serializable0 instanceof int[]) {
                while(v < ((int[])serializable0).length) {
                    stringBuilder0.append(((int[])serializable0)[v]);
                    ++v;
                    if(v != ((int[])serializable0).length) {
                        stringBuilder0.append(",");
                    }
                }
                return stringBuilder0.toString();
            }
            if(serializable0 instanceof double[]) {
                while(v < ((double[])serializable0).length) {
                    stringBuilder0.append(((double[])serializable0)[v]);
                    ++v;
                    if(v != ((double[])serializable0).length) {
                        stringBuilder0.append(",");
                    }
                }
                return stringBuilder0.toString();
            }
            if(serializable0 instanceof e[]) {
                while(v < ((e[])serializable0).length) {
                    stringBuilder0.append(((e[])serializable0)[v].a);
                    stringBuilder0.append('/');
                    stringBuilder0.append(((e[])serializable0)[v].b);
                    ++v;
                    if(v != ((e[])serializable0).length) {
                        stringBuilder0.append(",");
                    }
                }
                return stringBuilder0.toString();
            }
        }
        return null;
    }

    public final Serializable g(ByteOrder byteOrder0) {
        Serializable serializable1;
        Serializable serializable0;
        int v1;
        int v;
        b b1;
        b b0;
        byte[] arr_b;
        try {
            arr_b = this.d;
            b0 = null;
            b1 = null;
            b1 = new b(arr_b);
            goto label_7;
        }
        catch(IOException iOException0) {
            goto label_96;
        }
        catch(Throwable throwable0) {
        }
        goto label_105;
        try {
        label_7:
            b1.c = byteOrder0;
            v = 0;
            v1 = this.b;
            switch(this.a) {
                case 3: {
                    goto label_48;
                }
                case 4: {
                    goto label_54;
                }
                case 5: {
                    goto label_60;
                }
                case 1: 
                case 6: {
                    goto label_16;
                }
                case 2: 
                case 7: {
                    goto label_27;
                }
                case 8: {
                    goto label_66;
                }
                case 9: {
                    goto label_72;
                }
                case 10: {
                    goto label_78;
                }
                case 11: {
                    goto label_84;
                }
                case 12: {
                    goto label_90;
                }
            }
        }
        catch(IOException iOException0) {
            goto label_96;
        }
        catch(Throwable throwable0) {
            goto label_104;
        }
        try {
            b1.close();
        }
        catch(IOException iOException1) {
            Log.e("ExifInterface", "IOException occurred while closing InputStream", iOException1);
        }
        return null;
        try {
        label_16:
            if(arr_b.length == 1) {
                int v2 = arr_b[0];
                if(v2 >= 0 && v2 <= 1) {
                    serializable0 = new String(new char[]{((char)(v2 + 0x30))});
                    goto label_20;
                }
            }
            serializable1 = new String(arr_b, g.O);
            goto label_111;
        }
        catch(IOException iOException0) {
            goto label_96;
        }
        catch(Throwable throwable0) {
            goto label_104;
        }
        try {
        label_20:
            b1.close();
        }
        catch(IOException iOException2) {
            Log.e("ExifInterface", "IOException occurred while closing InputStream", iOException2);
        }
        return serializable0;
        try {
            serializable1 = new String(arr_b, g.O);
            goto label_111;
        label_27:
            if(v1 >= g.G.length) {
                for(int v3 = 0; true; ++v3) {
                    byte[] arr_b1 = g.G;
                    if(v3 >= arr_b1.length) {
                        v = arr_b1.length;
                        break;
                    }
                    if(arr_b[v3] != arr_b1[v3]) {
                        break;
                    }
                }
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            while(v < v1) {
                int v4 = arr_b[v];
                if(v4 == 0) {
                    break;
                }
                if(v4 >= 0x20) {
                    stringBuilder0.append(((char)v4));
                }
                else {
                    stringBuilder0.append('?');
                }
                ++v;
            }
            serializable1 = stringBuilder0.toString();
            goto label_111;
        label_48:
            serializable1 = new int[v1];
            while(v < v1) {
                serializable1[v] = b1.readUnsignedShort();
                ++v;
            }
            goto label_111;
        label_54:
            serializable1 = new long[v1];
            while(v < v1) {
                serializable1[v] = ((long)b1.readInt()) & 0xFFFFFFFFL;
                ++v;
            }
            goto label_111;
        label_60:
            serializable1 = new e[v1];
            while(v < v1) {
                serializable1[v] = new e(((long)b1.readInt()) & 0xFFFFFFFFL, ((long)b1.readInt()) & 0xFFFFFFFFL);
                ++v;
            }
            goto label_111;
        label_66:
            serializable1 = new int[v1];
            while(v < v1) {
                serializable1[v] = b1.readShort();
                ++v;
            }
            goto label_111;
        label_72:
            serializable1 = new int[v1];
            while(v < v1) {
                serializable1[v] = b1.readInt();
                ++v;
            }
            goto label_111;
        label_78:
            serializable1 = new e[v1];
            while(v < v1) {
                serializable1[v] = new e(((long)b1.readInt()), ((long)b1.readInt()));
                ++v;
            }
            goto label_111;
        label_84:
            serializable1 = new double[v1];
            while(v < v1) {
                serializable1[v] = (double)b1.readFloat();
                ++v;
            }
        }
        catch(IOException iOException0) {
            goto label_96;
        }
        catch(Throwable throwable0) {
            goto label_104;
        }
        goto label_111;
        try {
            try {
            label_90:
                serializable1 = new double[v1];
                while(true) {
                    if(v >= v1) {
                        goto label_111;
                    }
                    serializable1[v] = b1.readDouble();
                    ++v;
                }
            }
            catch(IOException iOException0) {
            }
        label_96:
            Log.w("ExifInterface", "IOException occurred during reading a value", iOException0);
            if(b1 != null) {
                goto label_98;
            }
            return null;
        }
        catch(Throwable throwable0) {
            goto label_104;
        }
        try {
        label_98:
            b1.close();
            return null;
        }
        catch(IOException iOException3) {
            Log.e("ExifInterface", "IOException occurred while closing InputStream", iOException3);
        }
        return null;
    label_104:
        b0 = b1;
    label_105:
        if(b0 != null) {
            try {
                b0.close();
            }
            catch(IOException iOException4) {
                Log.e("ExifInterface", "IOException occurred while closing InputStream", iOException4);
            }
        }
        throw throwable0;
        try {
        label_111:
            b1.close();
        }
        catch(IOException iOException5) {
            Log.e("ExifInterface", "IOException occurred while closing InputStream", iOException5);
        }
        return serializable1;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("(");
        stringBuilder0.append(g.E[this.a]);
        stringBuilder0.append(", data length:");
        return x.g(this.d.length, ")", stringBuilder0);
    }
}

