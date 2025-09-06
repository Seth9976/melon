package com.iloen.melon.utils.image;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import java.security.MessageDigest;

public class MelonBlurTransformation implements Transformation {
    public static int DEFAULT_DOWN_SAMPLING;
    public static int MAX_RADIUS;
    public final BitmapPool a;
    public final int b;
    public final int c;
    public static final byte[] d;

    static {
        MelonBlurTransformation.d = new byte[]{99, 0x6F, 109, 46, 107, 101, 0x76, 105, 110, 46, 103, 108, 105, 100, 101, 0x74, 101, 0x73, 0x74, 46, 66, 108, 0x75, 0x72, 84, 0x72, 97, 110, 0x73, 102, 0x6F, 0x72, 109, 97, 0x74, 105, 0x6F, 110};
        MelonBlurTransformation.MAX_RADIUS = 25;
        MelonBlurTransformation.DEFAULT_DOWN_SAMPLING = 1;
    }

    public MelonBlurTransformation(Context context0) {
        this(Glide.get(context0).getBitmapPool(), MelonBlurTransformation.MAX_RADIUS, MelonBlurTransformation.DEFAULT_DOWN_SAMPLING);
    }

    public MelonBlurTransformation(Context context0, int v) {
        this(Glide.get(context0).getBitmapPool(), v, MelonBlurTransformation.DEFAULT_DOWN_SAMPLING);
    }

    public MelonBlurTransformation(Context context0, int v, int v1) {
        this(Glide.get(context0).getBitmapPool(), v, v1);
    }

    public MelonBlurTransformation(BitmapPool bitmapPool0, int v, int v1) {
        this.a = bitmapPool0;
        this.b = v;
        this.c = v1;
    }

    @Override  // com.bumptech.glide.load.Key
    public boolean equals(Object object0) {
        return object0 instanceof MelonBlurTransformation && ((MelonBlurTransformation)object0).b == this.b && ((MelonBlurTransformation)object0).c == this.c;
    }

    @Override  // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.c * 10 + (this.b * 100 - 0x41A0911F);
    }

    @Override  // com.bumptech.glide.load.Transformation
    public Resource transform(Context context0, Resource resource0, int v, int v1) {
        int v35;
        Bitmap bitmap0 = (Bitmap)resource0.get();
        int v2 = bitmap0.getWidth();
        int v3 = bitmap0.getHeight();
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap0, v2 / this.c, v3 / this.c, true);
        int v4 = this.b;
        if(v4 < 1) {
            return BitmapResource.obtain(null, this.a);
        }
        int v5 = bitmap1.getWidth();
        int v6 = bitmap1.getHeight();
        int v7 = v5 * v6;
        int[] arr_v = new int[v7];
        bitmap1.getPixels(arr_v, 0, v5, 0, 0, v5, v6);
        int v8 = v4 + v4;
        int[] arr_v1 = new int[v7];
        int[] arr_v2 = new int[v7];
        int[] arr_v3 = new int[v7];
        int[] arr_v4 = new int[Math.max(v5, v6)];
        int v9 = v8 + 2 >> 1;
        int v10 = v9 * v9;
        int[] arr_v5 = new int[v10 * 0x100];
        for(int v11 = 0; v11 < v10 * 0x100; ++v11) {
            arr_v5[v11] = v11 / v10;
        }
        int[][] arr2_v = new int[v8 + 1][3];
        int v13 = 0;
        int v14 = 0;
        for(int v12 = 0; v12 < v6; ++v12) {
            int v15 = -v4;
            int v16 = 0;
            int v17 = 0;
            int v18 = 0;
            int v19 = 0;
            int v20 = 0;
            int v21 = 0;
            int v22 = 0;
            int v23 = 0;
            int v24 = 0;
            while(v15 <= v4) {
                int v25 = arr_v[Math.min(v5 - 1, Math.max(v15, 0)) + v13];
                int[] arr_v6 = arr2_v[v15 + v4];
                arr_v6[0] = (v25 & 0xFF0000) >> 16;
                arr_v6[1] = (v25 & 0xFF00) >> 8;
                arr_v6[2] = v25 & 0xFF;
                int v26 = v4 + 1 - Math.abs(v15);
                int v27 = arr_v6[0];
                v24 = v27 * v26 + v24;
                int v28 = arr_v6[1];
                v16 = v28 * v26 + v16;
                int v29 = arr_v6[2];
                v17 = v26 * v29 + v17;
                if(v15 > 0) {
                    v21 += v27;
                    v22 += v28;
                    v23 += v29;
                }
                else {
                    v18 += v27;
                    v19 += v28;
                    v20 += v29;
                }
                ++v15;
            }
            int v30 = v4;
            for(int v31 = 0; v31 < v5; v31 = v35 + 1) {
                arr_v1[v13] = arr_v5[v24];
                arr_v2[v13] = arr_v5[v16];
                arr_v3[v13] = arr_v5[v17];
                int[] arr_v7 = arr2_v[(v30 - v4 + (v8 + 1)) % (v8 + 1)];
                int v32 = v18 - arr_v7[0];
                int v33 = v19 - arr_v7[1];
                int v34 = v20 - arr_v7[2];
                if(v12 == 0) {
                    v35 = v31;
                    arr_v4[v35] = Math.min(v31 + v4 + 1, v5 - 1);
                }
                else {
                    v35 = v31;
                }
                int v36 = arr_v[v14 + arr_v4[v35]];
                int v37 = (v36 & 0xFF0000) >> 16;
                arr_v7[0] = v37;
                int v38 = (v36 & 0xFF00) >> 8;
                arr_v7[1] = v38;
                arr_v7[2] = v36 & 0xFF;
                int v39 = v21 + v37;
                int v40 = v22 + v38;
                int v41 = v23 + (v36 & 0xFF);
                v24 = v24 - v18 + v39;
                v16 = v16 - v19 + v40;
                v17 = v17 - v20 + v41;
                v30 = (v30 + 1) % (v8 + 1);
                int[] arr_v8 = arr2_v[v30 % (v8 + 1)];
                int v42 = arr_v8[0];
                v18 = v32 + v42;
                int v43 = arr_v8[1];
                v19 = v33 + v43;
                v20 = v34 + arr_v8[2];
                v21 = v39 - v42;
                v22 = v40 - v43;
                v23 = v41 - arr_v8[2];
                ++v13;
            }
            v14 += v5;
        }
        for(int v44 = 0; v44 < v5; ++v44) {
            int v45 = -v4;
            int v46 = v45 * v5;
            int v47 = 0;
            int v48 = 0;
            int v49 = 0;
            int v50 = 0;
            int v51 = 0;
            int v52 = 0;
            int v53 = 0;
            int v54 = 0;
            int v55 = 0;
            while(v45 <= v4) {
                int v56 = Math.max(0, v46) + v44;
                int[] arr_v9 = arr2_v[v45 + v4];
                arr_v9[0] = arr_v1[v56];
                arr_v9[1] = arr_v2[v56];
                arr_v9[2] = arr_v3[v56];
                int v57 = v4 + 1 - Math.abs(v45);
                v54 = arr_v1[v56] * v57 + v54;
                v55 = arr_v2[v56] * v57 + v55;
                v47 = arr_v3[v56] * v57 + v47;
                if(v45 > 0) {
                    v51 += arr_v9[0];
                    v52 += arr_v9[1];
                    v53 += arr_v9[2];
                }
                else {
                    v48 += arr_v9[0];
                    v49 += arr_v9[1];
                    v50 += arr_v9[2];
                }
                if(v45 < v6 - 1) {
                    v46 += v5;
                }
                ++v45;
            }
            int v58 = v54;
            int v59 = v55;
            int v60 = v4;
            int v62 = v44;
            for(int v61 = 0; v61 < v6; ++v61) {
                arr_v[v62] = arr_v[v62] & 0xFF000000 | arr_v5[v58] << 16 | arr_v5[v59] << 8 | arr_v5[v47];
                int[] arr_v10 = arr2_v[(v60 - v4 + (v8 + 1)) % (v8 + 1)];
                int v63 = v48 - arr_v10[0];
                int v64 = v49 - arr_v10[1];
                int v65 = v50 - arr_v10[2];
                if(v44 == 0) {
                    arr_v4[v61] = Math.min(v61 + (v4 + 1), v6 - 1) * v5;
                }
                int v66 = arr_v4[v61] + v44;
                int v67 = arr_v1[v66];
                arr_v10[0] = v67;
                int v68 = arr_v2[v66];
                arr_v10[1] = v68;
                int v69 = arr_v3[v66];
                arr_v10[2] = v69;
                int v70 = v51 + v67;
                int v71 = v52 + v68;
                int v72 = v53 + v69;
                v58 = v58 - v48 + v70;
                v59 = v59 - v49 + v71;
                v47 = v47 - v50 + v72;
                v60 = (v60 + 1) % (v8 + 1);
                int[] arr_v11 = arr2_v[v60];
                int v73 = arr_v11[0];
                v48 = v63 + v73;
                int v74 = arr_v11[1];
                v49 = v64 + v74;
                v50 = v65 + arr_v11[2];
                v51 = v70 - v73;
                v52 = v71 - v74;
                v53 = v72 - arr_v11[2];
                v62 += v5;
            }
        }
        bitmap1.setPixels(arr_v, 0, v5, 0, 0, v5, v6);
        return BitmapResource.obtain(bitmap1, this.a);
    }

    @Override  // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest0) {
        messageDigest0.update(MelonBlurTransformation.d);
    }
}

