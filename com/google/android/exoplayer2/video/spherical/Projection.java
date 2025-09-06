package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Projection {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DrawMode {
    }

    public static final class Mesh {
        private final SubMesh[] subMeshes;

        public Mesh(SubMesh[] arr_projection$SubMesh) {
            this.subMeshes = arr_projection$SubMesh;
        }

        public SubMesh getSubMesh(int v) {
            return this.subMeshes[v];
        }

        public int getSubMeshCount() {
            return this.subMeshes.length;
        }
    }

    public static final class SubMesh {
        public static final int VIDEO_TEXTURE_ID;
        public final int mode;
        public final float[] textureCoords;
        public final int textureId;
        public final float[] vertices;

        public SubMesh(int v, float[] arr_f, float[] arr_f1, int v1) {
            this.textureId = v;
            Assertions.checkArgument(((long)arr_f.length) * 2L == ((long)arr_f1.length) * 3L);
            this.vertices = arr_f;
            this.textureCoords = arr_f1;
            this.mode = v1;
        }

        public int getVertexCount() {
            return this.vertices.length / 3;
        }
    }

    public static final int DRAW_MODE_TRIANGLES = 0;
    public static final int DRAW_MODE_TRIANGLES_FAN = 2;
    public static final int DRAW_MODE_TRIANGLES_STRIP = 1;
    public static final int POSITION_COORDS_PER_VERTEX = 3;
    public static final int TEXTURE_COORDS_PER_VERTEX = 2;
    public final Mesh leftMesh;
    public final Mesh rightMesh;
    public final boolean singleMesh;
    public final int stereoMode;

    public Projection(Mesh projection$Mesh0, int v) {
        this(projection$Mesh0, projection$Mesh0, v);
    }

    public Projection(Mesh projection$Mesh0, Mesh projection$Mesh1, int v) {
        this.leftMesh = projection$Mesh0;
        this.rightMesh = projection$Mesh1;
        this.stereoMode = v;
        this.singleMesh = projection$Mesh0 == projection$Mesh1;
    }

    public static Projection createEquirectangular(float f, int v, int v1, float f1, float f2, int v2) {
        Assertions.checkArgument(Float.compare(f, 0.0f) > 0);
        Assertions.checkArgument(v >= 1);
        Assertions.checkArgument(v1 >= 1);
        Assertions.checkArgument(f1 > 0.0f && f1 <= 180.0f);
        Assertions.checkArgument(f2 > 0.0f && f2 <= 360.0f);
        float f3 = (float)Math.toRadians(f1);
        float f4 = (float)Math.toRadians(f2);
        float f5 = f3 / ((float)v);
        int v3 = ((v1 + 1) * 2 + 2) * v;
        float[] arr_f = new float[v3 * 3];
        float[] arr_f1 = new float[v3 * 2];
        int v5 = 0;
        int v6 = 0;
        for(int v4 = 0; v4 < v; ++v4) {
            float f6 = ((float)v4) * f5 - f3 / 2.0f;
            float f7 = ((float)(v4 + 1)) * f5 - f3 / 2.0f;
            for(int v7 = 0; v7 < v1 + 1; ++v7) {
                for(int v8 = 0; v8 < 2; ++v8) {
                    float f8 = v8 == 0 ? f6 : f7;
                    float f9 = ((float)v7) * (f4 / ((float)v1));
                    double f10 = (double)(f9 + 3.141593f - f4 / 2.0f);
                    arr_f[v5] = -((float)(Math.cos(f8) * (Math.sin(f10) * ((double)f))));
                    arr_f[v5 + 1] = (float)(Math.sin(f8) * ((double)f));
                    arr_f[v5 + 2] = (float)(Math.cos(f8) * (Math.cos(f10) * ((double)f)));
                    arr_f1[v6] = f9 / f4;
                    arr_f1[v6 + 1] = ((float)(v4 + v8)) * f5 / f3;
                    if((v7 != 0 || v8 != 0) && (v7 != v1 || v8 != 1)) {
                        v5 += 3;
                        v6 += 2;
                    }
                    else {
                        System.arraycopy(arr_f, v5, arr_f, v5 + 3, 3);
                        v5 += 6;
                        System.arraycopy(arr_f1, v6, arr_f1, v6 + 2, 2);
                        v6 += 4;
                    }
                }
            }
        }
        return new Projection(new Mesh(new SubMesh[]{new SubMesh(0, arr_f, arr_f1, 1)}), v2);
    }

    public static Projection createEquirectangular(int v) {
        return Projection.createEquirectangular(50.0f, 36, 72, 180.0f, 360.0f, v);
    }
}

