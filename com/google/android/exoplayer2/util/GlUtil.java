package com.google.android.exoplayer2.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.text.TextUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class GlUtil {
    public static final class Attribute {
        private Buffer buffer;
        private final int index;
        private final int location;
        public final String name;
        private int size;

        public Attribute(int v, int v1) {
            int[] arr_v = new int[1];
            GLES20.glGetProgramiv(v, 0x8B8A, arr_v, 0);
            int v2 = arr_v[0];
            byte[] arr_b = new byte[v2];
            GLES20.glGetActiveAttrib(v, v1, v2, new int[1], 0, new int[1], 0, new int[1], 0, arr_b, 0);
            String s = new String(arr_b, 0, GlUtil.strlen(arr_b));
            this.name = s;
            this.location = GLES20.glGetAttribLocation(v, s);
            this.index = v1;
        }

        public void bind() {
            Object object0 = Assertions.checkNotNull(this.buffer, "call setBuffer before bind");
            GLES20.glBindBuffer(0x8892, 0);
            GLES20.glVertexAttribPointer(this.location, this.size, 0x1406, false, 0, ((Buffer)object0));
            GLES20.glEnableVertexAttribArray(this.index);
            GlUtil.checkGlError();
        }

        public void setBuffer(float[] arr_f, int v) {
            this.buffer = GlUtil.createBuffer(arr_f);
            this.size = v;
        }
    }

    public static final class Uniform {
        private final int location;
        public final String name;
        private int texId;
        private final int type;
        private int unit;
        private final float[] value;

        public Uniform(int v, int v1) {
            int[] arr_v = new int[1];
            GLES20.glGetProgramiv(v, 0x8B87, arr_v, 0);
            int[] arr_v1 = new int[1];
            int v2 = arr_v[0];
            byte[] arr_b = new byte[v2];
            GLES20.glGetActiveUniform(v, v1, v2, new int[1], 0, new int[1], 0, arr_v1, 0, arr_b, 0);
            String s = new String(arr_b, 0, GlUtil.strlen(arr_b));
            this.name = s;
            this.location = GLES20.glGetUniformLocation(v, s);
            this.type = arr_v1[0];
            this.value = new float[1];
        }

        public void bind() {
            if(this.type == 0x1406) {
                GLES20.glUniform1fv(this.location, 1, this.value, 0);
                GlUtil.checkGlError();
                return;
            }
            if(this.texId == 0) {
                throw new IllegalStateException("call setSamplerTexId before bind");
            }
            GLES20.glActiveTexture(this.unit + 0x84C0);
            int v = this.type;
            if(v == 0x8D66) {
                GLES20.glBindTexture(0x8D65, this.texId);
            }
            else if(v == 0x8B5E) {
                GLES20.glBindTexture(0xDE1, this.texId);
            }
            else {
                throw new IllegalStateException("unexpected uniform type: " + this.type);
            }
            GLES20.glUniform1i(this.location, this.unit);
            GLES20.glTexParameteri(0xDE1, 0x2800, 0x2601);
            GLES20.glTexParameteri(0xDE1, 0x2801, 0x2601);
            GLES20.glTexParameteri(0xDE1, 0x2802, 0x812F);
            GLES20.glTexParameteri(0xDE1, 0x2803, 0x812F);
            GlUtil.checkGlError();
        }

        public void setFloat(float f) {
            this.value[0] = f;
        }

        public void setSamplerTexId(int v, int v1) {
            this.texId = v;
            this.unit = v1;
        }
    }

    private static final String EXTENSION_PROTECTED_CONTENT = "EGL_EXT_protected_content";
    private static final String EXTENSION_SURFACELESS_CONTEXT = "EGL_KHR_surfaceless_context";
    private static final String TAG = "GlUtil";

    private static void addShader(int v, String s, int v1) {
        int v2 = GLES20.glCreateShader(v);
        GLES20.glShaderSource(v2, s);
        GLES20.glCompileShader(v2);
        int[] arr_v = {0};
        GLES20.glGetShaderiv(v2, 0x8B81, arr_v, 0);
        if(arr_v[0] != 1) {
            GlUtil.throwGlError((GLES20.glGetShaderInfoLog(v2) + ", source: " + s));
        }
        GLES20.glAttachShader(v1, v2);
        GLES20.glDeleteShader(v2);
        GlUtil.checkGlError();
    }

    public static void checkGlError() {
        int v;
        while((v = GLES20.glGetError()) != 0) {
            String s = GLU.gluErrorString(v);
            Log.e("GlUtil", (s.length() == 0 ? new String("glError ") : "glError " + s));
        }
    }

    public static int compileProgram(String s, String s1) {
        int v = GLES20.glCreateProgram();
        GlUtil.checkGlError();
        GlUtil.addShader(0x8B31, s, v);
        GlUtil.addShader(0x8B30, s1, v);
        GLES20.glLinkProgram(v);
        int[] arr_v = {0};
        GLES20.glGetProgramiv(v, 0x8B82, arr_v, 0);
        if(arr_v[0] != 1) {
            String s2 = GLES20.glGetProgramInfoLog(v);
            GlUtil.throwGlError((s2.length() == 0 ? new String("Unable to link shader program: \n") : "Unable to link shader program: \n" + s2));
        }
        GlUtil.checkGlError();
        return v;
    }

    public static int compileProgram(String[] arr_s, String[] arr_s1) {
        return GlUtil.compileProgram(TextUtils.join("\n", arr_s), TextUtils.join("\n", arr_s1));
    }

    public static FloatBuffer createBuffer(int v) {
        return ByteBuffer.allocateDirect(v * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer createBuffer(float[] arr_f) {
        return (FloatBuffer)GlUtil.createBuffer(arr_f.length).put(arr_f).flip();
    }

    public static int createExternalTexture() {
        int[] arr_v = new int[1];
        GLES20.glGenTextures(1, IntBuffer.wrap(arr_v));
        GLES20.glBindTexture(0x8D65, arr_v[0]);
        GLES20.glTexParameteri(0x8D65, 0x2801, 0x2601);
        GLES20.glTexParameteri(0x8D65, 0x2800, 0x2601);
        GLES20.glTexParameteri(0x8D65, 0x2802, 0x812F);
        GLES20.glTexParameteri(0x8D65, 0x2803, 0x812F);
        GlUtil.checkGlError();
        return arr_v[0];
    }

    public static Attribute[] getAttributes(int v) {
        int[] arr_v = new int[1];
        GLES20.glGetProgramiv(v, 0x8B89, arr_v, 0);
        if(arr_v[0] != 2) {
            throw new IllegalStateException("expected two attributes");
        }
        Attribute[] arr_glUtil$Attribute = new Attribute[2];
        for(int v1 = 0; v1 < arr_v[0]; ++v1) {
            arr_glUtil$Attribute[v1] = new Attribute(v, v1);
        }
        return arr_glUtil$Attribute;
    }

    public static Uniform[] getUniforms(int v) {
        int[] arr_v = new int[1];
        GLES20.glGetProgramiv(v, 0x8B86, arr_v, 0);
        Uniform[] arr_glUtil$Uniform = new Uniform[arr_v[0]];
        for(int v1 = 0; v1 < arr_v[0]; ++v1) {
            arr_glUtil$Uniform[v1] = new Uniform(v, v1);
        }
        return arr_glUtil$Uniform;
    }

    @TargetApi(24)
    public static boolean isProtectedContentExtensionSupported(Context context0) {
        int v = Util.SDK_INT;
        if(v < 24) {
            return false;
        }
        if(v < 26 && ("samsung".equals(Util.MANUFACTURER) || "XT1650".equals(Util.MODEL))) {
            return false;
        }
        if(v < 26 && !context0.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
            return false;
        }
        String s = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 0x3055);
        return s != null && s.contains("EGL_EXT_protected_content");
    }

    @TargetApi(17)
    public static boolean isSurfacelessContextExtensionSupported() {
        if(Util.SDK_INT < 17) {
            return false;
        }
        String s = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 0x3055);
        return s != null && s.contains("EGL_KHR_surfaceless_context");
    }

    private static int strlen(byte[] arr_b) {
        for(int v = 0; v < arr_b.length; ++v) {
            if(arr_b[v] == 0) {
                return v;
            }
        }
        return arr_b.length;
    }

    private static void throwGlError(String s) {
        Log.e("GlUtil", s);
    }
}

