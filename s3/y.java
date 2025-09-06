package s3;

import java.util.Arrays;
import java.util.Random;

public final class Y {
    public final Random a;
    public final int[] b;
    public final int[] c;

    public Y() {
        this(new Random());
    }

    public Y(Random random0) {
        this(new int[0], random0);
    }

    public Y(int[] arr_v, Random random0) {
        this.b = arr_v;
        this.a = random0;
        this.c = new int[arr_v.length];
        for(int v = 0; v < arr_v.length; ++v) {
            this.c[arr_v[v]] = v;
        }
    }

    public final Y a(int v, int v1) {
        Random random0;
        int[] arr_v2;
        int[] arr_v = new int[v1];
        int[] arr_v1 = new int[v1];
        for(int v3 = 0; true; ++v3) {
            arr_v2 = this.b;
            random0 = this.a;
            if(v3 >= v1) {
                break;
            }
            arr_v[v3] = random0.nextInt(arr_v2.length + 1);
            int v4 = random0.nextInt(v3 + 1);
            arr_v1[v3] = arr_v1[v4];
            arr_v1[v4] = v3 + v;
        }
        Arrays.sort(arr_v);
        int[] arr_v3 = new int[arr_v2.length + v1];
        int v5 = 0;
        int v6 = 0;
        for(int v2 = 0; v2 < arr_v2.length + v1; ++v2) {
            if(v5 >= v1 || v6 != arr_v[v5]) {
                int v7 = arr_v2[v6];
                arr_v3[v2] = v7;
                if(v7 >= v) {
                    arr_v3[v2] = v7 + v1;
                }
                ++v6;
            }
            else {
                arr_v3[v2] = arr_v1[v5];
                ++v5;
            }
        }
        return new Y(arr_v3, new Random(random0.nextLong()));
    }
}

