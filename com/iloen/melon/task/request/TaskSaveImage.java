package com.iloen.melon.task.request;

import Cb.i;
import H0.b;
import J0.m;
import O8.d;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore.Images.Media;
import com.bumptech.glide.integration.okhttp3.MelonOkHttpStreamFetcher;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.mediastore.MelonMediaScanner;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.image.ImageUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import ie.H;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.c;
import x8.f;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\b\b\u0007\u0018\u0000 \u000E2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000EB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001B\u0010\t\u001A\u00020\u00032\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001A\u0010\f\u001A\u00020\u00032\b\u0010\u000B\u001A\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/task/request/TaskSaveImage;", "Lx8/f;", "Ljava/lang/Void;", "Lie/H;", "<init>", "()V", "", "", "urls", "setParams", "(Ljava/util/List;)V", "param", "backgroundWork", "(Ljava/lang/Void;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TaskSaveImage extends f {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/task/request/TaskSaveImage$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final ArrayList a;

    static {
        TaskSaveImage.Companion = new Companion(null);
        TaskSaveImage.$stable = 8;
    }

    public TaskSaveImage() {
        this.a = new ArrayList();
    }

    @Override  // x8.f
    public Object backgroundWork(Object object0, Continuation continuation0) {
        return this.backgroundWork(((Void)object0), continuation0);
    }

    @Nullable
    public Object backgroundWork(@Nullable Void void0, @NotNull Continuation continuation0) {
        String s4;
        String s3;
        Context context0 = Y.a(MelonAppBase.Companion);
        ArrayList arrayList0 = this.a;
        if(!arrayList0.isEmpty()) {
            Iterator iterator0 = arrayList0.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(object0, "next(...)");
                String s = (String)object0;
                if(ImageUtils.isDownloadableImageUrl(s)) {
                    String s1 = ImageUtils.isGifImage(s) ? ".gif" : ".png";
                    String s2 = StorageUtils.isScopedStorage() ? b.g(System.currentTimeMillis(), "melon_", s1) : i.i(new File(new File(c.c(), "download"), b.g(System.currentTimeMillis(), "melon_", s1)));
                    LogU.Companion.d("SaveImageTask", "downloadLegacy() url:" + s + ", local filepath : " + s2);
                    O8.f f0 = new O8.f(null);
                    boolean z = StorageUtils.isScopedStorage();
                    OkHttpClient okHttpClient0 = f0.a;
                    if(z) {
                        Context context1 = MelonAppBase.instance.getContext();
                        ContentValues contentValues0 = new ContentValues();
                        contentValues0.put("_display_name", s2);
                        contentValues0.put("mime_type", "image/*");
                        contentValues0.put("is_pending", 1);
                        ContentResolver contentResolver0 = context1.getContentResolver();
                        Uri uri0 = MediaStore.Images.Media.getContentUri("external_primary");
                        try {
                            Response response0 = okHttpClient0.newCall(MelonOkHttpStreamFetcher.getImageDownloadRequest(s)).execute();
                            if(response0.isSuccessful()) {
                                Uri uri1 = contentResolver0.insert(uri0, contentValues0);
                                try {
                                    ParcelFileDescriptor parcelFileDescriptor0 = m.g(contentResolver0, uri1);
                                    if(parcelFileDescriptor0 == null) {
                                        goto label_56;
                                    }
                                    else {
                                        InputStream inputStream0 = response0.body().byteStream();
                                        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
                                        byte[] arr_b = new byte[0x1000];
                                        int v;
                                        while((v = inputStream0.read(arr_b)) != -1) {
                                            byteArrayOutputStream0.write(arr_b, 0, v);
                                        }
                                        byte[] arr_b1 = byteArrayOutputStream0.toByteArray();
                                        FileOutputStream fileOutputStream0 = new FileOutputStream(parcelFileDescriptor0.getFileDescriptor());
                                        fileOutputStream0.write(arr_b1);
                                        fileOutputStream0.close();
                                        inputStream0.close();
                                        parcelFileDescriptor0.close();
                                        contentResolver0.update(uri1, contentValues0, null, null);
                                        contentValues0.clear();
                                        contentValues0.put("is_pending", 0);
                                        contentResolver0.update(uri1, contentValues0, null, null);
                                        s3 = response0.header("ETag");
                                        goto label_65;
                                    }
                                }
                                catch(FileNotFoundException fileNotFoundException0) {
                                    fileNotFoundException0.printStackTrace();
                                }
                                catch(IOException iOException1) {
                                    iOException1.printStackTrace();
                                }
                                goto label_62;
                            label_56:
                                contentValues0.clear();
                                contentValues0.put("is_pending", 0);
                                contentResolver0.update(uri1, contentValues0, null, null);
                            }
                        }
                        catch(IOException iOException0) {
                            iOException0.printStackTrace();
                        }
                    label_62:
                        s3 = null;
                    }
                    else {
                        s3 = d.b(okHttpClient0, s, s2);
                    }
                label_65:
                    if(s3 != null) {
                        MelonMediaScanner.c(context0, s2, null);
                        s4 = "저장이 완료되었습니다.";
                        q.d("저장이 완료되었습니다.");
                        goto label_72;
                    }
                }
                else {
                    LogU.Companion.w("SaveImageTask", "executeDownload() invalid url");
                }
                s4 = "이미지 파일을 처리하는데 문제가 발생하였습니다.";
                q.d("이미지 파일을 처리하는데 문제가 발생하였습니다.");
            label_72:
                ToastManager.show(s4);
            }
        }
        return H.a;
    }

    public final void setParams(@NotNull List list0) {
        q.g(list0, "urls");
        this.a.addAll(list0);
    }
}

