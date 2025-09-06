package i.n.i.b.a.s.e;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

class mv extends GLSurfaceView {
    public mv(Context context0) {
        this(context0, null);
    }

    public mv(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.setEGLContextClientVersion(3);
        this.setRenderer(new P6());
        this.setRenderMode(0);
    }
}

