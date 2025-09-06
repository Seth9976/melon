package S1;

import android.graphics.Path;
import android.util.Log;
import com.google.firebase.b;

public final class f {
    public char a;
    public final float[] b;

    public f(char c, float[] arr_f) {
        this.a = c;
        this.b = arr_f;
    }

    public f(f f0) {
        this.a = f0.a;
        this.b = b.u(f0.b, f0.b.length);
    }

    public static void a(Path path0, float f, float f1, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z1) {
        double f25;
        double f24;
        double f7 = Math.toRadians(f6);
        double f8 = Math.cos(f7);
        double f9 = Math.sin(f7);
        double f10 = (((double)f1) * f9 + ((double)f) * f8) / ((double)f4);
        double f11 = (((double)f1) * f8 + ((double)(-f)) * f9) / ((double)f5);
        double f12 = (((double)f3) * f9 + ((double)f2) * f8) / ((double)f4);
        double f13 = (((double)f3) * f8 + ((double)(-f2)) * f9) / ((double)f5);
        double f14 = f10 - f12;
        double f15 = f11 - f13;
        double f16 = (f10 + f12) / 2.0;
        double f17 = (f11 + f13) / 2.0;
        double f18 = f15 * f15 + f14 * f14;
        if(Double.compare(f18, 0.0) == 0) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double f19 = 1.0 / f18 - 0.25;
        if(f19 < 0.0) {
            Log.w("PathParser", "Points are too far apart " + f18);
            double f20 = Math.sqrt(f18);
            f.a(path0, f, f1, f2, f3, f4 * ((float)(f20 / 1.99999)), ((float)(f20 / 1.99999)) * f5, f6, z, z1);
            return;
        }
        double f21 = Math.sqrt(f19);
        double f22 = f21 * f14;
        double f23 = f21 * f15;
        if(z == z1) {
            f24 = f16 - f23;
            f25 = f17 + f22;
        }
        else {
            f24 = f16 + f23;
            f25 = f17 - f22;
        }
        double f26 = Math.atan2(f11 - f25, f10 - f24);
        double f27 = Math.atan2(f13 - f25, f12 - f24) - f26;
        int v = Double.compare(f27, 0.0);
        if(z1 != v >= 0) {
            f27 = v <= 0 ? f27 + 6.283185 : f27 - 6.283185;
        }
        double f28 = f24 * ((double)f4);
        double f29 = f25 * ((double)f5);
        int v1 = (int)Math.ceil(Math.abs(f27 * 4.0 / 3.141593));
        double f30 = Math.cos(f7);
        double f31 = Math.sin(f7);
        double f32 = Math.cos(f26);
        double f33 = Math.sin(f26);
        double f34 = -((double)f4) * f30;
        double f35 = ((double)f5) * f31;
        double f36 = f34 * f33 - f35 * f32;
        double f37 = -((double)f4) * f31;
        double f38 = ((double)f5) * f30;
        double f39 = f32 * f38 + f33 * f37;
        double f40 = (double)f;
        double f41 = (double)f1;
        int v2 = 0;
        double f42 = f26;
        while(v2 < v1) {
            double f43 = f42 + f27 / ((double)v1);
            double f44 = Math.sin(f43);
            double f45 = Math.cos(f43);
            double f46 = ((double)f4) * f30 * f45 + (f28 * f8 - f29 * f9) - f35 * f44;
            double f47 = f38 * f44 + (((double)f4) * f31 * f45 + (f29 * f8 + f28 * f9));
            double f48 = f34 * f44 - f35 * f45;
            double f49 = f45 * f38 + f44 * f37;
            double f50 = f43 - f42;
            double f51 = Math.tan(f50 / 2.0);
            double f52 = (Math.sqrt(f51 * 3.0 * f51 + 4.0) - 1.0) * Math.sin(f50) / 3.0;
            path0.rLineTo(0.0f, 0.0f);
            path0.cubicTo(((float)(f36 * f52 + f40)), ((float)(f39 * f52 + f41)), ((float)(f46 - f52 * f48)), ((float)(f47 - f52 * f49)), ((float)f46), ((float)f47));
            ++v2;
            f41 = f47;
            f42 = f43;
            f39 = f49;
            f40 = f46;
            f36 = f48;
        }
    }

    public static void b(f[] arr_f, Path path0) {
        float f21;
        float f16;
        f f15;
        int v5;
        float[] arr_f2;
        float f18;
        float f17;
        float f38;
        float f37;
        float f36;
        float f35;
        float f34;
        int v8;
        f f29;
        int v7;
        int v6;
        int v3;
        float f = 0.0f;
        float f1 = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int v = 0;
        int v1 = 109;
        while(v < arr_f.length) {
            f f6 = arr_f[v];
            int v2 = f6.a;
            float[] arr_f1 = f6.b;
            float f7 = f;
            float f8 = f1;
            float f9 = f2;
            float f10 = f3;
            switch(v2) {
                case 65: 
                case 97: {
                    v3 = 7;
                    break;
                }
                case 67: 
                case 99: {
                    v3 = 6;
                    break;
                }
                case 81: 
                case 83: 
                case 0x71: 
                case 0x73: {
                    v3 = 4;
                    break;
                }
                case 72: 
                case 86: 
                case 104: 
                case 0x76: {
                    v3 = 1;
                    break;
                }
                case 90: 
                case 0x7A: {
                    path0.close();
                    path0.moveTo(f4, f5);
                    f7 = f4;
                    f9 = f7;
                    f8 = f5;
                    f10 = f8;
                    v3 = 2;
                    break;
                }
                default: {
                    v3 = 2;
                }
            }
            float f11 = f4;
            float f12 = f5;
            float f13 = f7;
            float f14 = f8;
            int v4 = 0;
            while(v4 < arr_f1.length) {
                switch(v2) {
                    case 65: {
                        arr_f2 = arr_f1;
                        v5 = v4;
                        f15 = f6;
                        v6 = v;
                        v7 = 65;
                        f.a(path0, f13, f14, arr_f2[v5 + 5], arr_f2[v5 + 6], arr_f2[v5], arr_f2[v5 + 1], arr_f2[v5 + 2], ((boolean)(arr_f2[v5 + 3] == 0.0f ? 0 : 1)), ((boolean)(arr_f2[v5 + 4] == 0.0f ? 0 : 1)));
                        f9 = arr_f2[v5 + 5];
                        f21 = arr_f2[v5 + 6];
                        f10 = f21;
                        f16 = f9;
                        break;
                    }
                    case 67: {
                        arr_f2 = arr_f1;
                        v5 = v4;
                        v6 = v;
                        f15 = f6;
                        v7 = 67;
                        path0.cubicTo(arr_f2[v5], arr_f2[v5 + 1], arr_f2[v5 + 2], arr_f2[v5 + 3], arr_f2[v5 + 4], arr_f2[v5 + 5]);
                        float f22 = arr_f2[v5 + 4];
                        float f23 = arr_f2[v5 + 5];
                        f9 = arr_f2[v5 + 2];
                        f10 = arr_f2[v5 + 3];
                        f21 = f23;
                        f16 = f22;
                        break;
                    }
                    case 72: {
                        arr_f2 = arr_f1;
                        v5 = v4;
                        f15 = f6;
                        v7 = 72;
                        f21 = f14;
                        v6 = v;
                        path0.lineTo(arr_f2[v5], f21);
                        f16 = arr_f2[v5];
                        break;
                    }
                    case 76: {
                        arr_f2 = arr_f1;
                        v5 = v4;
                        path0.lineTo(arr_f2[v5], arr_f2[v5 + 1]);
                        f16 = arr_f2[v5];
                        f21 = arr_f2[v5 + 1];
                        v6 = v;
                        f15 = f6;
                        v7 = v2;
                        break;
                    }
                    case 77: {
                        arr_f2 = arr_f1;
                        v5 = v4;
                        f16 = arr_f2[v5];
                        f21 = arr_f2[v5 + 1];
                        if(v5 > 0) {
                            path0.lineTo(f16, f21);
                        }
                        else {
                            path0.moveTo(f16, f21);
                            f11 = f16;
                            f12 = f21;
                        }
                        v6 = v;
                        f15 = f6;
                        v7 = v2;
                        break;
                    }
                    case 81: {
                        arr_f2 = arr_f1;
                        v5 = v4;
                        v6 = v;
                        f15 = f6;
                        v7 = 81;
                        path0.quadTo(arr_f2[v5], arr_f2[v5 + 1], arr_f2[v5 + 2], arr_f2[v5 + 3]);
                        f9 = arr_f2[v5];
                        f10 = arr_f2[v5 + 1];
                        f16 = arr_f2[v5 + 2];
                        f21 = arr_f2[v5 + 3];
                        break;
                    }
                    case 83: {
                        arr_f2 = arr_f1;
                        v5 = v4;
                        if(v1 == 99 || v1 == 0x73 || v1 == 67 || v1 == 83) {
                            f13 = f13 * 2.0f - f9;
                            f14 = f14 * 2.0f - f10;
                        }
                        path0.cubicTo(f13, f14, arr_f2[v5], arr_f2[v5 + 1], arr_f2[v5 + 2], arr_f2[v5 + 3]);
                        f9 = arr_f2[v5];
                        f10 = arr_f2[v5 + 1];
                        f16 = arr_f2[v5 + 2];
                        f21 = arr_f2[v5 + 3];
                        v6 = v;
                        f15 = f6;
                        v7 = v2;
                        break;
                    }
                    case 84: {
                        arr_f2 = arr_f1;
                        v5 = v4;
                        if(v1 == 81 || v1 == 84 || v1 == 0x71 || v1 == 0x74) {
                            f13 = f13 * 2.0f - f9;
                            f14 = f14 * 2.0f - f10;
                        }
                        path0.quadTo(f13, f14, arr_f2[v5], arr_f2[v5 + 1]);
                        f16 = arr_f2[v5];
                        f21 = arr_f2[v5 + 1];
                        f15 = f6;
                        f9 = f13;
                        f10 = f14;
                        v6 = v;
                        v7 = v2;
                        break;
                    }
                    case 86: {
                        arr_f2 = arr_f1;
                        v5 = v4;
                        v6 = v;
                        f15 = f6;
                        f16 = f13;
                        v7 = 86;
                        path0.lineTo(f16, arr_f2[v5]);
                        f21 = arr_f2[v5];
                        break;
                    }
                    case 97: {
                        arr_f2 = arr_f1;
                        v5 = v4;
                        float f24 = arr_f2[v5 + 5] + f13;
                        float f25 = arr_f2[v5 + 6] + f14;
                        float f26 = arr_f2[v5];
                        float f27 = arr_f2[v5 + 1];
                        float f28 = arr_f2[v5 + 2];
                        if(arr_f2[v5 + 3] == 0.0f) {
                            f29 = f6;
                            v8 = 0;
                        }
                        else {
                            f29 = f6;
                            v8 = 1;
                        }
                        f15 = f29;
                        v7 = 97;
                        v6 = v;
                        f.a(path0, f13, f14, f24, f25, f26, f27, f28, ((boolean)v8), ((boolean)(Float.compare(arr_f2[v5 + 4], 0.0f) == 0 ? 0 : 1)));
                        f16 = f13 + arr_f2[v5 + 5];
                        f21 = f14 + arr_f2[v5 + 6];
                        f9 = f16;
                        f10 = f21;
                        break;
                    }
                    case 99: {
                        arr_f2 = arr_f1;
                        v5 = v4;
                        path0.rCubicTo(arr_f2[v5], arr_f2[v5 + 1], arr_f2[v5 + 2], arr_f2[v5 + 3], arr_f2[v5 + 4], arr_f2[v5 + 5]);
                        float f30 = arr_f2[v5 + 2] + f13;
                        float f31 = arr_f2[v5 + 3] + f14;
                        f13 += arr_f2[v5 + 4];
                        f14 += arr_f2[v5 + 5];
                        f9 = f30;
                        f10 = f31;
                        goto label_252;
                    }
                    case 104: {
                        arr_f2 = arr_f1;
                        v5 = v4;
                        path0.rLineTo(arr_f2[v5], 0.0f);
                        f13 += arr_f2[v5];
                        goto label_252;
                    }
                    case 108: {
                        arr_f2 = arr_f1;
                        v5 = v4;
                        path0.rLineTo(arr_f2[v5], arr_f2[v5 + 1]);
                        f13 += arr_f2[v5];
                        f14 += arr_f2[v5 + 1];
                        goto label_252;
                    }
                    case 109: {
                        arr_f2 = arr_f1;
                        v5 = v4;
                        float f32 = arr_f2[v5];
                        f13 += f32;
                        float f33 = arr_f2[v5 + 1];
                        f14 += f33;
                        if(v5 > 0) {
                            path0.rLineTo(f32, f33);
                            goto label_252;
                        }
                        else {
                            path0.rMoveTo(f32, f33);
                            f15 = f6;
                            f16 = f13;
                            f11 = f16;
                            f21 = f14;
                            f12 = f21;
                            v6 = v;
                            v7 = v2;
                            break;
                        }
                        goto label_223;
                    }
                    case 0x71: {
                    label_223:
                        arr_f2 = arr_f1;
                        v5 = v4;
                        path0.rQuadTo(arr_f2[v5], arr_f2[v5 + 1], arr_f2[v5 + 2], arr_f2[v5 + 3]);
                        f34 = arr_f2[v5] + f13;
                        f35 = arr_f2[v5 + 1] + f14;
                        f13 += arr_f2[v5 + 2];
                        f36 = arr_f2[v5 + 3];
                        f14 += f36;
                        f9 = f34;
                        f10 = f35;
                        goto label_252;
                    }
                    case 0x73: {
                        if(v1 == 99 || v1 == 0x73 || v1 == 67 || v1 == 83) {
                            f38 = f14 - f10;
                            f37 = f13 - f9;
                        }
                        else {
                            f37 = 0.0f;
                            f38 = 0.0f;
                        }
                        arr_f2 = arr_f1;
                        v5 = v4;
                        path0.rCubicTo(f37, f38, arr_f1[v4], arr_f1[v4 + 1], arr_f1[v4 + 2], arr_f1[v4 + 3]);
                        f34 = arr_f2[v5] + f13;
                        f35 = arr_f2[v4 + 1] + f14;
                        f13 += arr_f2[v4 + 2];
                        f36 = arr_f2[v4 + 3];
                        f14 += f36;
                        f9 = f34;
                        f10 = f35;
                        goto label_252;
                    }
                    case 0x76: {
                        arr_f2 = arr_f1;
                        v5 = v4;
                        path0.rLineTo(0.0f, arr_f2[v5]);
                        f14 += arr_f2[v5];
                    label_252:
                        f15 = f6;
                        f16 = f13;
                        f21 = f14;
                        v6 = v;
                        v7 = v2;
                        break;
                    }
                    default: {
                        if(v2 == 0x74) {
                            if(v1 == 0x71 || v1 == 0x74 || v1 == 81 || v1 == 84) {
                                f18 = f13 - f9;
                                f17 = f14 - f10;
                            }
                            else {
                                f17 = 0.0f;
                                f18 = 0.0f;
                            }
                            path0.rQuadTo(f18, f17, arr_f1[v4], arr_f1[v4 + 1]);
                            float f19 = f17 + f14;
                            float f20 = f13 + arr_f1[v4];
                            f14 += arr_f1[v4 + 1];
                            f10 = f19;
                            arr_f2 = arr_f1;
                            v5 = v4;
                            f15 = f6;
                            f16 = f20;
                            f9 = f18 + f13;
                        }
                        else {
                            arr_f2 = arr_f1;
                            v5 = v4;
                            f15 = f6;
                            f16 = f13;
                        }
                        f21 = f14;
                        v6 = v;
                        v7 = v2;
                        break;
                    }
                }
                v4 = v5 + v3;
                f6 = f15;
                v2 = v7;
                v = v6;
                f13 = f16;
                f14 = f21;
                v1 = v2;
                arr_f1 = arr_f2;
            }
            f = f13;
            f1 = f14;
            f2 = f9;
            f3 = f10;
            f4 = f11;
            f5 = f12;
            v1 = f6.a;
            ++v;
        }
    }
}

