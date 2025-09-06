package androidx.fragment.app;

import P4.a;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import kotlin.jvm.internal.q;

public final class e extends j {
    public final boolean b;
    public boolean c;
    public N d;

    public e(L0 l00, boolean z) {
        q.g(l00, "operation");
        super(l00);
        this.b = z;
    }

    public final N b(Context context0) {
        N n1;
        int v2;
        int v1;
        if(this.c) {
            return this.d;
        }
        I i0 = this.a.c;
        boolean z = this.a.a == 2;
        int v = i0.getNextTransition();
        if(!this.b) {
            v1 = z ? i0.getEnterAnim() : i0.getExitAnim();
        }
        else if(z) {
            v1 = i0.getPopEnterAnim();
        }
        else {
            v1 = i0.getPopExitAnim();
        }
        i0.setAnimations(0, 0, 0, 0);
        N n0 = null;
        if(i0.mContainer != null && i0.mContainer.getTag(0x7F0A0DD8) != null) {  // id:visible_removing_fragment_view_tag
            i0.mContainer.setTag(0x7F0A0DD8, null);  // id:visible_removing_fragment_view_tag
        }
        if(i0.mContainer == null || i0.mContainer.getLayoutTransition() == null) {
            if(v1 == 0) {
                switch(v) {
                    case 0: {
                        break;
                    }
                    case 0x1001: {
                        v2 = z ? 0x7F020008 : 0x7F020009;  // animator:fragment_open_enter
                        v1 = v2;
                        break;
                    }
                    case 0x1003: {
                        v2 = z ? 0x7F020006 : 0x7F020007;  // animator:fragment_fade_enter
                        v1 = v2;
                        break;
                    }
                    case 4100: {
                        v2 = z ? a.D(context0, 0x10100B8) : a.D(context0, 0x10100B9);
                        v1 = v2;
                        break;
                    }
                    case 0x2002: {
                        v2 = z ? 0x7F020004 : 0x7F020005;  // animator:fragment_close_enter
                        v1 = v2;
                        break;
                    }
                    case 0x2005: {
                        v2 = z ? a.D(context0, 0x10100BA) : a.D(context0, 0x10100BB);
                        v1 = v2;
                        break;
                    }
                    default: {
                        v1 = -1;
                    }
                }
            }
            if(v1 != 0) {
                boolean z1 = "anim".equals(context0.getResources().getResourceTypeName(v1));
                if(z1) {
                    try {
                        Animation animation0 = AnimationUtils.loadAnimation(context0, v1);
                        if(animation0 != null) {
                            n1 = new N(animation0);
                            n0 = n1;
                            this.d = n0;
                            this.c = true;
                            return n0;
                        }
                        this.d = n0;
                        this.c = true;
                        return n0;
                    }
                    catch(Resources.NotFoundException resources$NotFoundException0) {
                    }
                    catch(RuntimeException unused_ex) {
                        goto label_52;
                    }
                    throw resources$NotFoundException0;
                }
                else {
                    try {
                    label_52:
                        Animator animator0 = AnimatorInflater.loadAnimator(context0, v1);
                        if(animator0 != null) {
                            n1 = new N(animator0);
                            n0 = n1;
                            this.d = n0;
                            this.c = true;
                            return n0;
                        }
                    }
                    catch(RuntimeException runtimeException0) {
                        if(z1) {
                            throw runtimeException0;
                        }
                        Animation animation1 = AnimationUtils.loadAnimation(context0, v1);
                        if(animation1 != null) {
                            n0 = new N(animation1);
                        }
                    }
                    this.d = n0;
                    this.c = true;
                    return n0;
                }
            }
        }
        this.d = n0;
        this.c = true;
        return n0;
    }
}

