package je;

import androidx.appcompat.app.o;

public final class c {
    public static void a(int v, int v1, int v2) {
        if(v >= 0 && v1 <= v2) {
            if(v > v1) {
                throw new IllegalArgumentException("startIndex: " + v + " > endIndex: " + v1);
            }
            return;
        }
        StringBuilder stringBuilder0 = o.t(v, v1, "startIndex: ", ", endIndex: ", ", size: ");
        stringBuilder0.append(v2);
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    public static void b(int v, int v1) {
        if(v < 0 || v >= v1) {
            throw new IndexOutOfBoundsException("index: " + v + ", size: " + v1);
        }
    }

    public static void c(int v, int v1) {
        if(v < 0 || v > v1) {
            throw new IndexOutOfBoundsException("index: " + v + ", size: " + v1);
        }
    }

    public static void d(int v, int v1, int v2) {
        if(v >= 0 && v1 <= v2) {
            if(v > v1) {
                throw new IllegalArgumentException("fromIndex: " + v + " > toIndex: " + v1);
            }
            return;
        }
        StringBuilder stringBuilder0 = o.t(v, v1, "fromIndex: ", ", toIndex: ", ", size: ");
        stringBuilder0.append(v2);
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    public static int e(int v, int v1) {
        int v2 = v + (v >> 1) - v1 >= 0 ? v + (v >> 1) : v1;
        if(v2 - 0x7FFFFFF7 > 0) {
            return v1 <= 0x7FFFFFF7 ? 0x7FFFFFF7 : 0x7FFFFFFF;
        }
        return v2;
    }
}

