package rf;

public abstract class B {
    public static final z a;
    public static final A b;

    static {
        B.a = new z();  // 初始化器: Ljava/lang/Object;-><init>()V
        B.b = new A();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static int a(int v, int v1) {
        return v > -12 || v1 > -65 ? -1 : v ^ v1 << 8;
    }

    public static int b(byte[] arr_b, int v, int v1) {
        int v2 = arr_b[v - 1];
        switch(v1 - v) {
            case 0: {
                return v2 <= -12 ? v2 : -1;
            }
            case 1: {
                return B.a(v2, arr_b[v]);
            }
            case 2: {
                int v3 = arr_b[v];
                int v4 = arr_b[v + 1];
                return v2 > -12 || v3 > -65 || v4 > -65 ? -1 : v4 << 16 ^ (v3 << 8 ^ v2);
            }
            default: {
                throw new AssertionError();
            }
        }
    }

    public static int c(byte[] arr_b, int v, int v1) {
        while(v < v1 && arr_b[v] >= 0) {
            ++v;
        }
        if(v >= v1) {
            return 0;
        }
        while(true) {
            if(v >= v1) {
                return 0;
            }
            int v2 = v + 1;
            int v3 = arr_b[v];
            if(v3 < 0) {
                if(v3 < 0xFFFFFFE0) {
                    if(v2 >= v1) {
                        return v3;
                    }
                    if(v3 >= -62) {
                        v += 2;
                        if(arr_b[v2] <= -65) {
                            continue;
                        }
                        return -1;
                    }
                }
                else if(v3 < -16) {
                    if(v2 >= v1 - 1) {
                        return B.b(arr_b, v2, v1);
                    }
                    int v4 = v + 2;
                    int v5 = arr_b[v2];
                    if(v5 <= -65 && (v3 != 0xFFFFFFE0 || v5 >= 0xFFFFFFA0) && (v3 != -19 || v5 < 0xFFFFFFA0)) {
                        v += 3;
                        if(arr_b[v4] <= -65) {
                            continue;
                        }
                        return -1;
                    }
                }
                else {
                    if(v2 >= v1 - 2) {
                        return B.b(arr_b, v2, v1);
                    }
                    int v6 = arr_b[v2];
                    if(v6 <= -65 && v6 + 0x70 + (v3 << 28) >> 30 == 0) {
                        int v7 = v + 3;
                        if(arr_b[v + 2] <= -65) {
                            v += 4;
                            if(arr_b[v7] > -65) {
                                return -1;
                            }
                            continue;
                        }
                    }
                }
                return -1;
            }
            v = v2;
        }
    }
}

