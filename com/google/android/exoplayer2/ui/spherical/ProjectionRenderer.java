package com.google.android.exoplayer2.ui.spherical;

import android.opengl.GLES20;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.video.spherical.Projection.SubMesh;
import com.google.android.exoplayer2.video.spherical.Projection;
import java.nio.FloatBuffer;

final class ProjectionRenderer {
    static class MeshData {
        private final int drawMode;
        private final FloatBuffer textureBuffer;
        private final FloatBuffer vertexBuffer;
        private final int vertexCount;

        public MeshData(SubMesh projection$SubMesh0) {
            this.vertexCount = projection$SubMesh0.getVertexCount();
            this.vertexBuffer = GlUtil.createBuffer(projection$SubMesh0.vertices);
            this.textureBuffer = GlUtil.createBuffer(projection$SubMesh0.textureCoords);
            switch(projection$SubMesh0.mode) {
                case 1: {
                    this.drawMode = 5;
                    return;
                }
                case 2: {
                    this.drawMode = 6;
                    return;
                }
                default: {
                    this.drawMode = 4;
                }
            }
        }

        public static FloatBuffer access$100(MeshData projectionRenderer$MeshData0) {
            return projectionRenderer$MeshData0.textureBuffer;
        }

        public static int access$200(MeshData projectionRenderer$MeshData0) {
            return projectionRenderer$MeshData0.drawMode;
        }

        public static int access$300(MeshData projectionRenderer$MeshData0) {
            return projectionRenderer$MeshData0.vertexCount;
        }
    }

    private static final String[] FRAGMENT_SHADER_CODE;
    private static final float[] TEX_MATRIX_BOTTOM;
    private static final float[] TEX_MATRIX_LEFT;
    private static final float[] TEX_MATRIX_RIGHT;
    private static final float[] TEX_MATRIX_TOP;
    private static final float[] TEX_MATRIX_WHOLE;
    private static final String[] VERTEX_SHADER_CODE;
    private MeshData leftMeshData;
    private int mvpMatrixHandle;
    private int positionHandle;
    private int program;
    private MeshData rightMeshData;
    private int stereoMode;
    private int texCoordsHandle;
    private int textureHandle;
    private int uTexMatrixHandle;

    static {
        ProjectionRenderer.VERTEX_SHADER_CODE = new String[]{"uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", "}"};
        ProjectionRenderer.FRAGMENT_SHADER_CODE = new String[]{"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", "}"};
        ProjectionRenderer.TEX_MATRIX_WHOLE = new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};
        ProjectionRenderer.TEX_MATRIX_TOP = new float[]{1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};
        ProjectionRenderer.TEX_MATRIX_BOTTOM = new float[]{1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};
        ProjectionRenderer.TEX_MATRIX_LEFT = new float[]{0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};
        ProjectionRenderer.TEX_MATRIX_RIGHT = new float[]{0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};
    }

    public void draw(int v, float[] arr_f, boolean z) {
        float[] arr_f1;
        MeshData projectionRenderer$MeshData0 = z ? this.rightMeshData : this.leftMeshData;
        if(projectionRenderer$MeshData0 == null) {
            return;
        }
        GLES20.glUseProgram(this.program);
        GlUtil.checkGlError();
        GLES20.glEnableVertexAttribArray(this.positionHandle);
        GLES20.glEnableVertexAttribArray(this.texCoordsHandle);
        GlUtil.checkGlError();
        int v1 = this.stereoMode;
        if(v1 != 1) {
            if(v1 != 2) {
                arr_f1 = ProjectionRenderer.TEX_MATRIX_WHOLE;
            }
            else if(z) {
                arr_f1 = ProjectionRenderer.TEX_MATRIX_RIGHT;
            }
            else {
                arr_f1 = ProjectionRenderer.TEX_MATRIX_LEFT;
            }
        }
        else if(z) {
            arr_f1 = ProjectionRenderer.TEX_MATRIX_BOTTOM;
        }
        else {
            arr_f1 = ProjectionRenderer.TEX_MATRIX_TOP;
        }
        GLES20.glUniformMatrix3fv(this.uTexMatrixHandle, 1, false, arr_f1, 0);
        GLES20.glUniformMatrix4fv(this.mvpMatrixHandle, 1, false, arr_f, 0);
        GLES20.glActiveTexture(0x84C0);
        GLES20.glBindTexture(0x8D65, v);
        GLES20.glUniform1i(this.textureHandle, 0);
        GlUtil.checkGlError();
        GLES20.glVertexAttribPointer(this.positionHandle, 3, 0x1406, false, 12, projectionRenderer$MeshData0.vertexBuffer);
        GlUtil.checkGlError();
        GLES20.glVertexAttribPointer(this.texCoordsHandle, 2, 0x1406, false, 8, MeshData.access$100(projectionRenderer$MeshData0));
        GlUtil.checkGlError();
        GLES20.glDrawArrays(MeshData.access$200(projectionRenderer$MeshData0), 0, MeshData.access$300(projectionRenderer$MeshData0));
        GlUtil.checkGlError();
        GLES20.glDisableVertexAttribArray(this.positionHandle);
        GLES20.glDisableVertexAttribArray(this.texCoordsHandle);
    }

    public void init() {
        int v = GlUtil.compileProgram(ProjectionRenderer.VERTEX_SHADER_CODE, ProjectionRenderer.FRAGMENT_SHADER_CODE);
        this.program = v;
        this.mvpMatrixHandle = GLES20.glGetUniformLocation(v, "uMvpMatrix");
        this.uTexMatrixHandle = GLES20.glGetUniformLocation(this.program, "uTexMatrix");
        this.positionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
        this.texCoordsHandle = GLES20.glGetAttribLocation(this.program, "aTexCoords");
        this.textureHandle = GLES20.glGetUniformLocation(this.program, "uTexture");
    }

    public static boolean isSupported(Projection projection0) {
        return projection0.leftMesh.getSubMeshCount() == 1 && projection0.leftMesh.getSubMesh(0).textureId == 0 && projection0.rightMesh.getSubMeshCount() == 1 && projection0.rightMesh.getSubMesh(0).textureId == 0;
    }

    public void setProjection(Projection projection0) {
        if(!ProjectionRenderer.isSupported(projection0)) {
            return;
        }
        this.stereoMode = projection0.stereoMode;
        MeshData projectionRenderer$MeshData0 = new MeshData(projection0.leftMesh.getSubMesh(0));
        this.leftMeshData = projectionRenderer$MeshData0;
        if(!projection0.singleMesh) {
            projectionRenderer$MeshData0 = new MeshData(projection0.rightMesh.getSubMesh(0));
        }
        this.rightMeshData = projectionRenderer$MeshData0;
    }

    public void shutdown() {
        int v = this.program;
        if(v != 0) {
            GLES20.glDeleteProgram(v);
        }
    }
}

