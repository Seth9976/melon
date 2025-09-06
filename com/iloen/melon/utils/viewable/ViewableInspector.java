package com.iloen.melon.utils.viewable;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import java.util.Arrays;

public class ViewableInspector {
    static class ScaledAlphaChecker extends ViewIntersectionChecker {
        public final float c;
        public final float[][] d;

        public ScaledAlphaChecker(int v, int v1, int v2, int v3, float f) {
            super(v, v1);
            this.c = f;
            this.d = new float[v2][v3];
        }

        @Override  // com.iloen.melon.utils.viewable.ViewableInspector$ViewIntersectionChecker
        public void checkIntersection(View view0, int v, int v1, int v2, int v3) {
            float f = view0.getAlpha();
            while(v < v1) {
                for(int v4 = v2; v4 < v3; ++v4) {
                    float[] arr_f = this.d[v];
                    float f1 = arr_f[v4];
                    arr_f[v4] = (1.0f - f1) * f + f1;
                }
                ++v;
            }
        }

        @Override  // com.iloen.melon.utils.viewable.ViewableInspector$ViewIntersectionChecker
        public int getIntersectionSize() {
            float[][] arr2_f = this.d;
            int v1 = 0;
            for(int v = 0; v < arr2_f.length; ++v) {
                float[] arr_f = arr2_f[v];
                for(int v2 = 0; v2 < arr_f.length; ++v2) {
                    if(arr_f[v2] > this.c) {
                        ++v1;
                    }
                }
            }
            return v1;
        }
    }

    static class ScaledChecker extends ViewIntersectionChecker {
        public final boolean[][] c;

        public ScaledChecker(int v, int v1, int v2, int v3) {
            super(v, v1);
            this.c = new boolean[v2][v3];
        }

        @Override  // com.iloen.melon.utils.viewable.ViewableInspector$ViewIntersectionChecker
        public void checkIntersection(View view0, int v, int v1, int v2, int v3) {
            while(v < v1) {
                Arrays.fill(this.c[v], v2, v3, true);
                ++v;
            }
        }

        @Override  // com.iloen.melon.utils.viewable.ViewableInspector$ViewIntersectionChecker
        public int getIntersectionSize() {
            boolean[][] arr2_z = this.c;
            int v1 = 0;
            for(int v = 0; v < arr2_z.length; ++v) {
                boolean[] arr_z = arr2_z[v];
                for(int v2 = 0; v2 < arr_z.length; ++v2) {
                    if(arr_z[v2]) {
                        ++v1;
                    }
                }
            }
            return v1;
        }
    }

    static abstract class ViewIntersectionChecker implements Callback {
        public final int a;
        public final int b;

        public ViewIntersectionChecker(int v, int v1) {
            this.a = v;
            this.b = v1;
        }

        public abstract void checkIntersection(View arg1, int arg2, int arg3, int arg4, int arg5);

        public abstract int getIntersectionSize();

        @Override  // com.iloen.melon.utils.viewable.ViewIntersectionFinder$Callback
        public boolean isTransparentView(View view0) {
            if(!view0.isShown() || view0.getAlpha() <= 0.0f) {
                return true;
            }
            if(view0.getClass() == View.class) {
                Drawable drawable0 = view0.getBackground();
                if(drawable0 == null || drawable0.getAlpha() == 0) {
                    Drawable drawable1 = view0.getForeground();
                    return drawable1 == null || drawable1.getAlpha() == 0;
                }
            }
            return false;
        }

        @Override  // com.iloen.melon.utils.viewable.ViewIntersectionFinder$Callback
        public boolean isTransparentViewGroup(ViewGroup viewGroup0) {
            Drawable drawable0 = viewGroup0.getBackground();
            if(drawable0 == null || drawable0.getAlpha() == 0) {
                Drawable drawable1 = viewGroup0.getForeground();
                return drawable1 == null || drawable1.getAlpha() == 0;
            }
            return false;
        }

        @Override  // com.iloen.melon.utils.viewable.ViewIntersectionFinder$Callback
        public void onFound(View view0, Rect rect0) {
            this.checkIntersection(view0, ((int)(((float)(rect0.left - this.a)) * 0.125f)), ((int)(((float)(rect0.right - this.a)) * 0.125f)), ((int)(((float)(rect0.top - this.b)) * 0.125f)), ((int)(((float)(rect0.bottom - this.b)) * 0.125f)));
        }
    }

    public static boolean isViewable(View view0, int v, int v1, float f, float f1, boolean z) {
        int v11;
        int v2 = view0.getWidth();
        int v3 = view0.getHeight();
        if(v2 >= v && v3 >= v1) {
            Rect rect0 = ViewIntersectionFinder.getVisibleRect(view0, new Rect());
            rect0.left = Math.max(rect0.left, 0);
            rect0.top = Math.max(rect0.top, 0);
            rect0.right = Math.min(rect0.right, ScreenUtils.getScreenWidth(view0.getContext()));
            rect0.bottom = Math.min(rect0.bottom, ScreenUtils.getScreenHeight(view0.getContext()));
            int v4 = rect0.width();
            if(((float)(rect0.height() * v4)) / ((float)Math.max(v2 * v3, 1)) >= f) {
                int v5 = (int)(((float)view0.getWidth()) * 0.125f);
                int v6 = (int)(((float)view0.getHeight()) * 0.125f);
                int v7 = v5 * v6;
                float f2 = 0.0f;
                if(v5 > 0 && v6 > 0) {
                    int v8 = (int)(((float)rect0.width()) * 0.125f);
                    int v9 = (int)(((float)rect0.height()) * 0.125f);
                    int v10 = v8 * v9;
                    if(v8 > 0 && v9 > 0 && v7 >= v10) {
                        if(z) {
                            v11 = 0;
                        }
                        else {
                            ScaledChecker viewableInspector$ScaledChecker0 = f1 <= 0.0f ? new ScaledChecker(rect0.left, rect0.top, v8, v9) : new ScaledAlphaChecker(rect0.left, rect0.top, v8, v9, f1);
                            try {
                                ViewIntersectionFinder.find(view0, rect0, viewableInspector$ScaledChecker0);
                            }
                            catch(Throwable throwable0) {
                                LogU.v("ViewableInspector", "Failed to get viewable ratio: " + throwable0 + " " + throwable0);
                            }
                            v11 = viewableInspector$ScaledChecker0.getIntersectionSize();
                        }
                        f2 = ((float)(v10 - v11)) / ((float)v7);
                    }
                }
                return f2 >= f;
            }
        }
        return false;
    }
}

