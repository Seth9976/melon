package com.iloen.melon.utils.image;

import Ad.w;
import Q1.c;
import U4.x;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.f0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.log.LogU;
import e.b;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;

public class ImageSelector {
    public interface ImageSelectorListener {
        void onFinishBackgroundLoading();

        void onImageSelectorCanceled(ImageSelector arg1, Request arg2);

        void onImageSelectorComplete(ImageSelector arg1, Request arg2, Uri arg3);

        void onStartBackgroundLoading();
    }

    public interface OnDefaultImageClick {
        void onDefaultImageClick();
    }

    public static final class PickType {
        public static final int PICK_FROM_CAMERA = 7001;
        public static final int PICK_FROM_CROP = 7002;
        public static final int PICK_FROM_FILE = 7000;

    }

    public static class Request {
        public final String a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final boolean f;
        public final boolean g;
        public int h;

        public Request(String s, int v, int v1, int v2, int v3, boolean z, boolean z1) {
            if(TextUtils.isEmpty(s)) {
                s = "e792119c-e8da-4473-b564-b50bac2b71ca";
            }
            this.a = s;
            this.b = v;
            this.c = v1;
            this.d = v2;
            this.e = v3;
            this.f = z;
            this.g = z1;
        }

        public final File a(Context context0) {
            return FileUtils.getDiskCacheDir(context0, this.a + ".jpg");
        }

        public String getTag() {
            return this.a;
        }

        public static Request newCoverImage(String s) {
            return new Request(s, 1000, 468, 1000, 468, true, false);
        }

        public static Request newLiveBackgroundImage(String s) {
            return new Request(s, 1200, 1600, 1200, 1600, false, true);
        }

        public static Request newNormalImage(String s) {
            return new Request(s, 0x400, 0x400, 1, 1, false, true);
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("Request {tag=");
            stringBuilder0.append(this.a);
            stringBuilder0.append(", output=");
            stringBuilder0.append(this.b);
            stringBuilder0.append("_");
            stringBuilder0.append(this.c);
            stringBuilder0.append(", aspect:");
            stringBuilder0.append(this.d);
            stringBuilder0.append("_");
            return x.g(this.e, "}", stringBuilder0);
        }
    }

    public final WeakReference a;
    public final Context b;
    public int c;
    public int d;
    public final LinkedList e;
    public final ArrayList f;
    public final b g;
    public final b h;
    public final b i;
    public final ImageSelectorListener j;

    public ImageSelector(I i0, ImageSelectorListener imageSelector$ImageSelectorListener0) {
        this.c = 1;
        this.d = 1;
        this.e = new LinkedList();
        this.f = new ArrayList();
        this.g = null;
        this.h = null;
        this.i = null;
        this.b = MelonAppBase.instance.getContext();
        this.a = i0 == null ? null : new WeakReference(i0);
        this.j = imageSelector$ImageSelectorListener0;
        I i1 = (I)this.a.get();
        if(i1 != null) {
            this.g = i1.registerForActivityResult(new f0(2), new a(this, 0));
            this.h = i1.registerForActivityResult(new f0(2), new a(this, 1));
            this.i = i1.registerForActivityResult(new f0(2), new a(this, 2));
        }
    }

    public final I a() {
        I i0 = this.a == null ? null : ((I)this.a.get());
        return i0 == null || !i0.isAdded() ? null : i0;
    }

    public final void b(Request imageSelector$Request0) {
        this.e.addLast(imageSelector$Request0);
        LogU.d("ImageSelector", "pushRequest " + imageSelector$Request0 + ", stackSize:" + this.e.size());
    }

    public final void c(I i0, Request imageSelector$Request0) {
        if(i0 != null) {
            Intent intent0 = new Intent("android.media.action.IMAGE_CAPTURE");
            intent0.setFlags(2);
            File file0 = imageSelector$Request0.a(this.b);
            intent0.putExtra("output", FileUtils.getFileUri(this.b, file0));
            try {
                this.h.b(intent0);
                this.b(imageSelector$Request0);
            }
            catch(Exception exception0) {
                H0.b.v(exception0, new StringBuilder("startCameraActivity() Exception:"), "ImageSelector");
            }
            return;
        }
        LogU.e("ImageSelector", "startCameraActivity() invalid fragment");
    }

    public void cleanUp() {
        ArrayList arrayList0 = this.f;
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            for(Object object0: arrayList0) {
                File file0 = (File)object0;
                if(file0.isFile() && file0.exists()) {
                    LogU.i("ImageSelector", "delete " + file0);
                    file0.delete();
                }
            }
            arrayList0.clear();
        }
    }

    public final void d(I i0, Uri uri0, Request imageSelector$Request0) {
        if(i0 != null) {
            if(uri0 != null) {
                FragmentActivity fragmentActivity0 = i0.getActivity();
                Uri uri1 = FileUtils.getFileUri(fragmentActivity0, imageSelector$Request0.a(fragmentActivity0));
                LogU.d("ImageSelector", "startCropImageActivity() croppedImageUri: " + uri0 + " ,mPhotoFileUri = " + uri1);
                Intent intent0 = new Intent();
                c.Y(intent0, "com.iloen.melon.activity.action.CROP", true);
                intent0.setDataAndType(uri0, "image/*");
                intent0.putExtra("outputX", imageSelector$Request0.b);
                intent0.putExtra("outputY", imageSelector$Request0.c);
                intent0.putExtra("aspectX", this.c);
                intent0.putExtra("aspectY", this.d);
                intent0.putExtra("highlightViewFitToScreen", imageSelector$Request0.f);
                intent0.putExtra("highlightViewResize", imageSelector$Request0.g);
                intent0.putExtra("scale", true);
                intent0.putExtra("output", uri1);
                try {
                    LogU.d("ImageSelector", "startCropImageActivity() requestCode:7002");
                    this.i.b(intent0);
                    this.b(imageSelector$Request0);
                }
                catch(Exception exception0) {
                    H0.b.v(exception0, new StringBuilder("startCropImageActivity() Exception:"), "ImageSelector");
                }
                return;
            }
            LogU.e("ImageSelector", "startCropImageActivity() invalid Uri");
            return;
        }
        LogU.e("ImageSelector", "startCropImageActivity() invalid activity");
    }

    public final void e(I i0, Request imageSelector$Request0) {
        if(i0 != null) {
            Intent intent0 = new Intent("android.intent.action.PICK");
            intent0.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "vnd.android.cursor.dir/image");
            try {
                this.g.b(intent0);
                this.b(imageSelector$Request0);
            }
            catch(Exception exception0) {
                H0.b.v(exception0, new StringBuilder("startImagePickerActivity() Exception:"), "ImageSelector");
            }
            return;
        }
        LogU.e("ImageSelector", "startImagePickerActivity() invalid fragment");
    }

    public boolean handleActivityResult(int v, int v1, Intent intent0) {
        LogU.d("ImageSelector", "handleActivityResult requestCode:" + v + ", resultCode:" + v1);
        if(this.a() != null) {
            I i0 = this.a();
            Request imageSelector$Request0 = (Request)this.e.pollLast();
            LogU.d("ImageSelector", "pollRequest " + imageSelector$Request0 + ", stackSize:" + this.e.size());
            if(imageSelector$Request0 != null) {
                Context context0 = this.b;
                File file0 = imageSelector$Request0.a(context0);
                this.f.add(file0);
                if(v1 == -1) {
                    LogU.d("ImageSelector", "requestInfo=" + imageSelector$Request0);
                    if(v != 7000) {
                        switch(v) {
                            case 7001: {
                                this.d(i0, FileUtils.getFileUri(context0, imageSelector$Request0.a(context0)), imageSelector$Request0);
                                return true;
                            }
                            case 7002: {
                                Uri uri1 = Uri.fromFile(imageSelector$Request0.a(context0));
                                ImageSelectorListener imageSelector$ImageSelectorListener0 = this.j;
                                if(imageSelector$ImageSelectorListener0 == null) {
                                    return true;
                                }
                                imageSelector$ImageSelectorListener0.onImageSelectorComplete(this, imageSelector$Request0, uri1);
                                return true;
                            }
                            default: {
                                return false;
                            }
                        }
                    }
                    else if("mounted".equals(Environment.getExternalStorageState())) {
                        Uri uri0 = intent0.getData();
                        LogU.d("ImageSelector", "PICK_FROM_FILE mPhotoFileUri = " + uri0);
                        this.d(i0, uri0, imageSelector$Request0);
                        return true;
                    }
                }
                else {
                    LogU.w("ImageSelector", "RESULT ISN\'T OK - resultCode:" + v1 + ", reqCode:" + v);
                    if(v1 == 99) {
                        if(v == 7002) {
                            if(imageSelector$Request0.h == 7000) {
                                this.e(i0, imageSelector$Request0);
                                return true;
                            }
                            this.c(i0, imageSelector$Request0);
                            return true;
                        }
                    }
                    else if(v == 7000) {
                        ImageSelectorListener imageSelector$ImageSelectorListener1 = this.j;
                        if(imageSelector$ImageSelectorListener1 != null) {
                            imageSelector$ImageSelectorListener1.onImageSelectorCanceled(this, imageSelector$Request0);
                        }
                        return true;
                    }
                }
                return false;
            }
            LogU.e("ImageSelector", "handleActivityResult() invalid reqInfo");
            return false;
        }
        LogU.w("ImageSelector", "fragment isn\'t available!");
        return false;
    }

    public void setAspectRatio(int v, int v1) {
        this.c = v;
        this.d = v1;
    }

    public void startSelector(Request imageSelector$Request0) {
        this.startSelector(imageSelector$Request0, null, false, null);
    }

    public void startSelector(Request imageSelector$Request0, String s, boolean z, OnDefaultImageClick imageSelector$OnDefaultImageClick0) {
        if((this.a() == null ? null : this.a().getActivity()) != null) {
            if(TextUtils.isEmpty(s)) {
                s = "사진 선택";
            }
            w w0 = new w(s, z);
            com.melon.ui.popup.b.h(this.a().getChildFragmentManager(), s, w0, new com.iloen.melon.player.playlist.mixup.composables.c(this, imageSelector$Request0, imageSelector$OnDefaultImageClick0, 3));
        }
    }
}

