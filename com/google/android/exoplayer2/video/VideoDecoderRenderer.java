package com.google.android.exoplayer2.video;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLSurfaceView;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class VideoDecoderRenderer implements GLSurfaceView.Renderer, VideoDecoderOutputBufferRenderer {
    private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n";
    private static final String[] TEXTURE_UNIFORMS = null;
    private static final FloatBuffer TEXTURE_VERTICES = null;
    private static final String VERTEX_SHADER = "varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n";
    private int colorMatrixLocation;
    private static final float[] kColorConversion2020;
    private static final float[] kColorConversion601;
    private static final float[] kColorConversion709;
    private final AtomicReference pendingOutputBufferReference;
    private int[] previousStrides;
    private int[] previousWidths;
    private int program;
    private VideoDecoderOutputBuffer renderedOutputBuffer;
    private final GLSurfaceView surfaceView;
    private int[] texLocations;
    private FloatBuffer[] textureCoords;
    private final int[] yuvTextures;

    static {
        VideoDecoderRenderer.kColorConversion601 = new float[]{1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
        VideoDecoderRenderer.kColorConversion709 = new float[]{1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};
        VideoDecoderRenderer.kColorConversion2020 = new float[]{1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};
        VideoDecoderRenderer.TEXTURE_UNIFORMS = new String[]{"y_tex", "u_tex", "v_tex"};
        VideoDecoderRenderer.TEXTURE_VERTICES = GlUtil.createBuffer(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
    }

    public VideoDecoderRenderer(GLSurfaceView gLSurfaceView0) {
        this.yuvTextures = new int[3];
        this.surfaceView = gLSurfaceView0;
        this.pendingOutputBufferReference = new AtomicReference();
        this.textureCoords = new FloatBuffer[3];
        this.texLocations = new int[3];
        this.previousWidths = new int[3];
        this.previousStrides = new int[3];
        for(int v = 0; v < 3; ++v) {
            int[] arr_v = this.previousWidths;
            this.previousStrides[v] = -1;
            arr_v[v] = -1;
        }
    }

    @Override  // android.opengl.GLSurfaceView$Renderer
    public void onDrawFrame(GL10 gL100) {
        VideoDecoderOutputBuffer videoDecoderOutputBuffer0 = (VideoDecoderOutputBuffer)this.pendingOutputBufferReference.getAndSet(null);
        if(videoDecoderOutputBuffer0 == null && this.renderedOutputBuffer == null) {
            return;
        }
        if(videoDecoderOutputBuffer0 != null) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer1 = this.renderedOutputBuffer;
            if(videoDecoderOutputBuffer1 != null) {
                videoDecoderOutputBuffer1.release();
            }
            this.renderedOutputBuffer = videoDecoderOutputBuffer0;
        }
        VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = this.renderedOutputBuffer;
        float[] arr_f = VideoDecoderRenderer.kColorConversion709;
        switch(videoDecoderOutputBuffer2.colorspace) {
            case 1: {
                arr_f = VideoDecoderRenderer.kColorConversion601;
                break;
            }
            case 3: {
                arr_f = VideoDecoderRenderer.kColorConversion2020;
            }
        }
        GLES20.glUniformMatrix3fv(this.colorMatrixLocation, 1, false, arr_f, 0);
        for(int v = 0; v < 3; ++v) {
            int v1 = v == 0 ? videoDecoderOutputBuffer2.height : (videoDecoderOutputBuffer2.height + 1) / 2;
            GLES20.glActiveTexture(v + 0x84C0);
            GLES20.glBindTexture(0xDE1, this.yuvTextures[v]);
            GLES20.glPixelStorei(0xCF5, 1);
            GLES20.glTexImage2D(0xDE1, 0, 6409, videoDecoderOutputBuffer2.yuvStrides[v], v1, 0, 6409, 0x1401, videoDecoderOutputBuffer2.yuvPlanes[v]);
        }
        int[] arr_v = new int[3];
        arr_v[0] = videoDecoderOutputBuffer2.width;
        int v2 = (videoDecoderOutputBuffer2.width + 1) / 2;
        arr_v[2] = v2;
        arr_v[1] = v2;
        for(int v3 = 0; v3 < 3; ++v3) {
            if(this.previousWidths[v3] != arr_v[v3] || this.previousStrides[v3] != videoDecoderOutputBuffer2.yuvStrides[v3]) {
                Assertions.checkState(videoDecoderOutputBuffer2.yuvStrides[v3] != 0);
                float f = ((float)arr_v[v3]) / ((float)videoDecoderOutputBuffer2.yuvStrides[v3]);
                FloatBuffer[] arr_floatBuffer = this.textureCoords;
                arr_floatBuffer[v3] = GlUtil.createBuffer(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f, 0.0f, f, 1.0f});
                GLES20.glVertexAttribPointer(this.texLocations[v3], 2, 0x1406, false, 0, this.textureCoords[v3]);
                this.previousWidths[v3] = arr_v[v3];
                this.previousStrides[v3] = videoDecoderOutputBuffer2.yuvStrides[v3];
            }
        }
        GLES20.glClear(0x4000);
        GLES20.glDrawArrays(5, 0, 4);
        GlUtil.checkGlError();
    }

    @Override  // android.opengl.GLSurfaceView$Renderer
    public void onSurfaceChanged(GL10 gL100, int v, int v1) {
        GLES20.glViewport(0, 0, v, v1);
    }

    @Override  // android.opengl.GLSurfaceView$Renderer
    public void onSurfaceCreated(GL10 gL100, EGLConfig eGLConfig0) {
        int v = GlUtil.compileProgram("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
        this.program = v;
        GLES20.glUseProgram(v);
        int v1 = GLES20.glGetAttribLocation(this.program, "in_pos");
        GLES20.glEnableVertexAttribArray(v1);
        GLES20.glVertexAttribPointer(v1, 2, 0x1406, false, 0, VideoDecoderRenderer.TEXTURE_VERTICES);
        int[] arr_v = this.texLocations;
        arr_v[0] = GLES20.glGetAttribLocation(this.program, "in_tc_y");
        GLES20.glEnableVertexAttribArray(this.texLocations[0]);
        int[] arr_v1 = this.texLocations;
        arr_v1[1] = GLES20.glGetAttribLocation(this.program, "in_tc_u");
        GLES20.glEnableVertexAttribArray(this.texLocations[1]);
        int[] arr_v2 = this.texLocations;
        arr_v2[2] = GLES20.glGetAttribLocation(this.program, "in_tc_v");
        GLES20.glEnableVertexAttribArray(this.texLocations[2]);
        GlUtil.checkGlError();
        this.colorMatrixLocation = GLES20.glGetUniformLocation(this.program, "mColorConversion");
        GlUtil.checkGlError();
        this.setupTextures();
        GlUtil.checkGlError();
    }

    @Override  // com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer
    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer0) {
        VideoDecoderOutputBuffer videoDecoderOutputBuffer1 = (VideoDecoderOutputBuffer)this.pendingOutputBufferReference.getAndSet(videoDecoderOutputBuffer0);
        if(videoDecoderOutputBuffer1 != null) {
            videoDecoderOutputBuffer1.release();
        }
        this.surfaceView.requestRender();
    }

    private void setupTextures() {
        GLES20.glGenTextures(3, this.yuvTextures, 0);
        for(int v = 0; v < 3; ++v) {
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.program, VideoDecoderRenderer.TEXTURE_UNIFORMS[v]), v);
            GLES20.glActiveTexture(v + 0x84C0);
            GLES20.glBindTexture(0xDE1, this.yuvTextures[v]);
            GLES20.glTexParameterf(0xDE1, 0x2801, 9729.0f);
            GLES20.glTexParameterf(0xDE1, 0x2800, 9729.0f);
            GLES20.glTexParameterf(0xDE1, 0x2802, 33071.0f);
            GLES20.glTexParameterf(0xDE1, 0x2803, 33071.0f);
        }
        GlUtil.checkGlError();
    }
}

