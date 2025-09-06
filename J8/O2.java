package J8;

import Q4.a;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.VideoOverlayView;
import com.iloen.melon.playback.VideoSurfaceView;

public final class o2 implements a {
    public final ConstraintLayout a;
    public final View b;
    public final ImageButton c;
    public final ConstraintLayout d;
    public final CheckableImageView e;
    public final View f;
    public final M3 g;
    public final VideoOverlayView h;
    public final ConstraintLayout i;
    public final ConstraintLayout j;
    public final ViewStub k;
    public final b l;
    public final MelonTextView m;
    public final MelonTextView n;
    public final ConstraintLayout o;
    public final MelonImageView p;
    public final VideoSurfaceView q;

    public o2(ConstraintLayout constraintLayout0, View view0, ImageButton imageButton0, ConstraintLayout constraintLayout1, CheckableImageView checkableImageView0, View view1, M3 m30, VideoOverlayView videoOverlayView0, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ViewStub viewStub0, b b0, MelonTextView melonTextView0, MelonTextView melonTextView1, ConstraintLayout constraintLayout4, MelonImageView melonImageView0, VideoSurfaceView videoSurfaceView0) {
        this.a = constraintLayout0;
        this.b = view0;
        this.c = imageButton0;
        this.d = constraintLayout1;
        this.e = checkableImageView0;
        this.f = view1;
        this.g = m30;
        this.h = videoOverlayView0;
        this.i = constraintLayout2;
        this.j = constraintLayout3;
        this.k = viewStub0;
        this.l = b0;
        this.m = melonTextView0;
        this.n = melonTextView1;
        this.o = constraintLayout4;
        this.p = melonImageView0;
        this.q = videoSurfaceView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

