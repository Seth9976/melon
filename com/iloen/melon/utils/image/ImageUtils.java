package com.iloen.melon.utils.image;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.log.error.MelonDebug;
import com.iloen.melon.utils.system.ScreenUtils;

public class ImageUtils {
    public static enum ScaleType {
        CENTER_CROP,
        CENTER_INSIDE,
        FIT_XY;

    }

    public static final int DEFAULT_SIZE_LIST_ALBUM = 0x90;
    public static final float IMAGE_SIZE_MULTIFLIER_LOW = 0.7f;
    public static final int LIMIT_ANIMATABLE_SIZE_DEFAULT = 200;
    public static final int LIMIT_ANIMATABLE_SIZE_LARGE = 500;
    public static final int LIMIT_BITMAP_SIZE_BACKGROUND = 640;
    public static final int LIMIT_BITMAP_SIZE_BACKGROUND_LARGE = 1080;
    public static final int LIMIT_BITMAP_SIZE_BANNER_HEIGHT = 480;
    public static final int LIMIT_BITMAP_SIZE_BANNER_WIDTH = 0xA00;
    public static final Bitmap.Config a;
    public static Boolean b;

    static {
        ImageUtils.a = Bitmap.Config.ARGB_8888;
        ImageUtils.b = null;
    }

    public static Bitmap blurRenderScript(Context context0, Bitmap bitmap0, int v, float f) {
        int v1 = Math.round(((float)bitmap0.getWidth()) * f);
        int v2 = Math.round(((float)bitmap0.getHeight()) * f);
        RenderScript renderScript0 = RenderScript.create(context0);
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap0, v1, v2, false);
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap1.getWidth(), bitmap1.getHeight(), Bitmap.Config.ARGB_8888);
        Allocation allocation0 = Allocation.createFromBitmap(renderScript0, bitmap1);
        Allocation allocation1 = Allocation.createFromBitmap(renderScript0, bitmap2);
        ScriptIntrinsicBlur scriptIntrinsicBlur0 = ScriptIntrinsicBlur.create(renderScript0, Element.U8_4(renderScript0));
        scriptIntrinsicBlur0.setInput(allocation0);
        scriptIntrinsicBlur0.setRadius(((float)v));
        scriptIntrinsicBlur0.forEach(allocation1);
        allocation1.copyTo(bitmap2);
        renderScript0.destroy();
        allocation0.destroy();
        allocation1.destroy();
        return bitmap2;
    }

    public static Bitmap convertGlideDrawableToBitmap(Drawable drawable0) {
        if(drawable0 instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable0).getBitmap();
        }
        if(drawable0 instanceof TransitionDrawable) {
            int v = ((TransitionDrawable)drawable0).getNumberOfLayers();
            for(int v1 = 0; v1 < v; ++v1) {
                Drawable drawable1 = ((TransitionDrawable)drawable0).getDrawable(v1);
                if(drawable1 instanceof BitmapDrawable) {
                    return ((BitmapDrawable)drawable1).getBitmap();
                }
            }
        }
        return null;
    }

    public static Bitmap createBlurredBitmap(Context context0, int v, int v1, Bitmap bitmap0) {
        if(context0 != null && v >= 0 && bitmap0 != null) {
            return (Bitmap)new MelonBlurTransformation(context0, v, v1).transform(context0, new Resource() {
                public final Bitmap a;

                {
                    Bitmap bitmap0 = bitmap0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.a = bitmap0;
                }

                public Bitmap get() {
                    return this.a;
                }

                @Override  // com.bumptech.glide.load.engine.Resource
                public Object get() {
                    return this.get();
                }

                @Override  // com.bumptech.glide.load.engine.Resource
                public Class getResourceClass() {
                    return Bitmap.class;
                }

                @Override  // com.bumptech.glide.load.engine.Resource
                public int getSize() {
                    return this.a == null ? 0 : this.a.getByteCount();
                }

                @Override  // com.bumptech.glide.load.engine.Resource
                public void recycle() {
                    Bitmap bitmap0 = this.a;
                    if(!bitmap0.isRecycled()) {
                        bitmap0.recycle();
                    }
                }
            }, bitmap0.getWidth(), bitmap0.getHeight()).get();
        }
        LogU.w("ImageUtils", "createBlurredBitmap() : Invalid parameters");
        return null;
    }

    public static Bitmap createBlurredBitmap(Context context0, int v, Bitmap bitmap0) {
        return ImageUtils.createBlurredBitmap(context0, v, MelonBlurTransformation.DEFAULT_DOWN_SAMPLING, bitmap0);
    }

    public static Bitmap createCircledShortcutImage(Context context0, Bitmap bitmap0) {
        if(context0 != null && bitmap0 != null) {
            int v = (int)context0.getResources().getDimension(0x7F0702F7);  // dimen:melon_custom_shortcut_icon_size
            com.iloen.melon.utils.image.ImageUtils.1 imageUtils$10 = new Resource() {
                public final Bitmap a;

                {
                    Bitmap bitmap0 = Bitmap.createScaledBitmap(bitmap0, v, v, false);  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.a = bitmap0;
                }

                public Bitmap get() {
                    return this.a;
                }

                @Override  // com.bumptech.glide.load.engine.Resource
                public Object get() {
                    return this.get();
                }

                @Override  // com.bumptech.glide.load.engine.Resource
                public Class getResourceClass() {
                    return Bitmap.class;
                }

                @Override  // com.bumptech.glide.load.engine.Resource
                public int getSize() {
                    return 1;
                }

                @Override  // com.bumptech.glide.load.engine.Resource
                public void recycle() {
                    Bitmap bitmap0 = this.a;
                    if(!bitmap0.isRecycled()) {
                        bitmap0.recycle();
                    }
                }
            };
            int v1 = ScreenUtils.dipToPixel(context0, 4.0f);
            Bitmap bitmap1 = (Bitmap)new CircleCrop().transform(context0, imageUtils$10, v, v).get();
            ImageUtils.drawCircleLine(context0, bitmap1, 0x7F0603F2, v1);  // color:melon_green
            return bitmap1;
        }
        LogU.d("ImageUtils", "createCircledShortcut() >> parameter is invalid");
        return null;
    }

    public static void drawCircleLine(Context context0, Bitmap bitmap0, int v, int v1) {
        if(context0 != null && bitmap0 != null) {
            int v2 = bitmap0.getWidth();
            Canvas canvas0 = new Canvas(bitmap0);
            int v3 = ColorUtils.getColor(context0, v);
            Paint paint0 = new Paint();
            paint0.setAntiAlias(true);
            paint0.setColor(v3);
            paint0.setStyle(Paint.Style.STROKE);
            paint0.setStrokeWidth(((float)v1));
            float f = ((float)v2) / 2.0f;
            canvas0.drawCircle(f, f, f - ((float)v1) / 2.0f, paint0);
        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable0) {
        Bitmap bitmap0;
        Drawable drawable1;
        if(drawable0 == null) {
            return null;
        }
        if(drawable0 instanceof TransitionDrawable) {
            for(int v = 0; true; ++v) {
                drawable1 = null;
                if(v >= ((TransitionDrawable)drawable0).getNumberOfLayers()) {
                    break;
                }
                Drawable drawable2 = ((TransitionDrawable)drawable0).getDrawable(v);
                if(drawable2 instanceof BitmapDrawable) {
                    drawable1 = drawable2;
                    break;
                }
            }
            if(drawable1 != null) {
                return ImageUtils.drawableToBitmap(drawable1);
            }
        }
        else if(drawable0 instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable0).getBitmap();
        }
        try {
            Bitmap.Config bitmap$Config0 = ImageUtils.a;
            int v1 = 2;
            if(drawable0 instanceof ColorDrawable) {
                bitmap0 = Bitmap.createBitmap(2, 2, bitmap$Config0);
            }
            else {
                int v2 = drawable0.getIntrinsicWidth() <= 0 ? 2 : drawable0.getIntrinsicWidth();
                if(drawable0.getIntrinsicHeight() > 0) {
                    v1 = drawable0.getIntrinsicHeight();
                }
                bitmap0 = Bitmap.createBitmap(v2, v1, bitmap$Config0);
            }
            Canvas canvas0 = new Canvas(bitmap0);
            drawable0.setBounds(0, 0, canvas0.getWidth(), canvas0.getHeight());
            drawable0.draw(canvas0);
            return bitmap0;
        }
        catch(OutOfMemoryError unused_ex) {
            return null;
        }
    }

    public static Bitmap getCircledBitmap(Bitmap bitmap0, int v, int v1) {
        if(bitmap0 != null) {
            if(v > 0 && v1 > 0) {
                com.iloen.melon.utils.image.ImageUtils.3 imageUtils$30 = new Resource() {
                    public final Bitmap a;

                    {
                        Bitmap bitmap0 = bitmap0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.a = bitmap0;
                    }

                    public Bitmap get() {
                        return this.a;
                    }

                    @Override  // com.bumptech.glide.load.engine.Resource
                    public Object get() {
                        return this.get();
                    }

                    @Override  // com.bumptech.glide.load.engine.Resource
                    public Class getResourceClass() {
                        return Bitmap.class;
                    }

                    @Override  // com.bumptech.glide.load.engine.Resource
                    public int getSize() {
                        return this.a == null ? 0 : this.a.getByteCount();
                    }

                    @Override  // com.bumptech.glide.load.engine.Resource
                    public void recycle() {
                        Bitmap bitmap0 = this.a;
                        if(!bitmap0.isRecycled()) {
                            bitmap0.recycle();
                        }
                    }
                };
                try {
                    Resource resource0 = new CircleCrop().transform(MelonAppBase.instance.getContext(), imageUtils$30, v, v1);
                    return resource0 == null ? null : ((Bitmap)resource0.get());
                }
                catch(OutOfMemoryError outOfMemoryError0) {
                    MelonDebug.handleOutOfMemoryError(outOfMemoryError0);
                    throw new NullPointerException();
                }
            }
            LogU.w("ImageUtils", "getCircleResourceBitmap() invalid width or height");
            return null;
        }
        return null;
    }

    public static Bitmap getResourceBitmapImpl(int v) {
        try {
            Bitmap bitmap0 = BitmapFactory.decodeResource(MelonAppBase.instance.getContext().getResources(), v);
            if(bitmap0 != null) {
                return bitmap0;
            }
        }
        catch(OutOfMemoryError outOfMemoryError0) {
            MelonDebug.handleOutOfMemoryError(outOfMemoryError0);
        }
        LogU.e("ImageUtils", "getResourceBitmapImpl() invalid bitmap - resId:" + v);
        return null;
    }

    public static Uri getResourceUri(int v) {
        return Uri.parse(("android.resource://com.iloen.melon/" + v));
    }

    // 去混淆评级： 低(30)
    public static boolean isDownloadableImageUrl(String s) {
        return !TextUtils.isEmpty(s) && (s.startsWith("http://") || s.startsWith("https://"));
    }

    // 去混淆评级： 低(40)
    public static boolean isGifImage(String s) {
        return TextUtils.isEmpty(s) ? false : s.contains(".gif") || s.contains(".GIF");
    }
}

