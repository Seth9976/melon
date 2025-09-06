package z3;

import A1.k;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;
import androidx.media3.exoplayer.video.VideoDecoderGLSurfaceView;
import e3.b;
import e3.i;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class h implements GLSurfaceView.Renderer {
    public final VideoDecoderGLSurfaceView a;
    public final int[] b;
    public final int[] c;
    public final int[] d;
    public final int[] e;
    public final AtomicReference f;
    public k g;
    public static final String[] h;
    public static final FloatBuffer i;

    static {
        h.h = new String[]{"y_tex", "u_tex", "v_tex"};
        h.i = b.m(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
    }

    public h(VideoDecoderGLSurfaceView videoDecoderGLSurfaceView0) {
        this.a = videoDecoderGLSurfaceView0;
        this.b = new int[3];
        this.c = new int[3];
        this.d = new int[3];
        this.e = new int[3];
        this.f = new AtomicReference();
        for(int v = 0; v < 3; ++v) {
            this.e[v] = -1;
            this.d[v] = -1;
        }
    }

    public final void a() {
        try {
            int[] arr_v = this.b;
            GLES20.glGenTextures(3, arr_v, 0);
            for(int v = 0; v < 3; ++v) {
                GLES20.glUniform1i(GLES20.glGetUniformLocation(this.g.b, h.h[v]), v);
                GLES20.glActiveTexture(v + 0x84C0);
                b.b(0xDE1, arr_v[v]);
            }
            b.e();
            return;
        }
        catch(i i0) {
        }
        Log.e("VideoDecoderGLSV", "Failed to set up the textures", i0);
    }

    @Override  // android.opengl.GLSurfaceView$Renderer
    public final void onDrawFrame(GL10 gL100) {
        if(this.f.getAndSet(null) != null) {
            throw new ClassCastException();
        }
    }

    @Override  // android.opengl.GLSurfaceView$Renderer
    public final void onSurfaceChanged(GL10 gL100, int v, int v1) {
        GLES20.glViewport(0, 0, v, v1);
    }

    @Override  // android.opengl.GLSurfaceView$Renderer
    public final void onSurfaceCreated(GL10 gL100, EGLConfig eGLConfig0) {
        try {
            k k0 = new k("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.g = k0;
            GLES20.glVertexAttribPointer(k0.f("in_pos"), 2, 0x1406, false, 0, h.i);
            this.c[0] = this.g.f("in_tc_y");
            this.c[1] = this.g.f("in_tc_u");
            this.c[2] = this.g.f("in_tc_v");
            GLES20.glGetUniformLocation(this.g.b, "mColorConversion");
            b.e();
            this.a();
            b.e();
        }
        catch(i i0) {
            Log.e("VideoDecoderGLSV", "Failed to set up the textures and program", i0);
        }
    }
}

