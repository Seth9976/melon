package k9;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventPremiumDownload;
import i.n.i.b.a.s.e.Ga;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import u9.f;

public abstract class i {
    public static final Ga a;
    public static byte[] b;

    static {
        i.a = new Ga(28, false);
    }

    public static byte[] a() {
        int v;
        FileInputStream fileInputStream0;
        byte[] arr_b2;
        Context context0 = MelonAppBase.instance.getContext();
        byte[] arr_b = null;
        if(context0 == null) {
            return null;
        }
        byte[] arr_b1 = i.b;
        if(arr_b1 != null) {
            return arr_b1;
        }
        try {
            arr_b2 = new byte[0x200];
            fileInputStream0 = null;
            fileInputStream0 = context0.openFileInput("premium.auth");
            v = fileInputStream0.read(arr_b2);
            goto label_27;
        }
        catch(FileNotFoundException unused_ex) {
            goto label_16;
        }
        catch(IOException unused_ex) {
            goto label_19;
        }
        catch(Throwable throwable0) {
        }
        Throwable throwable1 = throwable0;
        goto label_24;
        try {
            v = fileInputStream0.read(arr_b2);
            goto label_27;
        }
        catch(FileNotFoundException unused_ex) {
        }
        catch(IOException unused_ex) {
            goto label_19;
        }
        catch(Throwable throwable1) {
            goto label_24;
        }
    label_16:
        if(fileInputStream0 != null) {
            try {
                fileInputStream0.close();
                v = 0;
                goto label_28;
            label_19:
                if(fileInputStream0 != null) {
                    fileInputStream0.close();
                }
            }
            catch(IOException unused_ex) {
            }
        }
        v = 0;
        goto label_28;
    label_24:
        if(fileInputStream0 != null) {
            try {
                fileInputStream0.close();
            }
            catch(IOException unused_ex) {
            }
        }
        throw throwable1;
        try {
        label_27:
            fileInputStream0.close();
        }
        catch(IOException unused_ex) {
        }
    label_28:
        if(v > 0) {
            arr_b = Arrays.copyOf(arr_b2, v);
        }
        i.b = arr_b;
        return arr_b;
    }

    public static File b(String s) {
        String s1 = i.d(new String[]{s});
        return TextUtils.isEmpty(s1) ? null : new File(i.c(0), s1);
    }

    public static File c(int v) {
        switch(v) {
            case 0: {
                Context context0 = MelonAppBase.instance.getContext();
                return new File(f.g.b(context0, "offline").a(), "0");
            }
            case 1: {
                Context context1 = MelonAppBase.instance.getContext();
                return new File(f.g.b(context1, "offline").a(), "1");
            }
            case 2: {
                Context context2 = MelonAppBase.instance.getContext();
                return new File(f.g.b(context2, "offline").a(), "2");
            }
            default: {
                return null;
            }
        }
    }

    public static String d(String[] arr_s) {
        if(arr_s.length > 0) {
            StringBuilder stringBuilder0 = new StringBuilder();
            for(int v = 0; v < arr_s.length; ++v) {
                stringBuilder0.append(arr_s[v]);
            }
            try {
                return Base64.encodeToString(MessageDigest.getInstance("MD5").digest(stringBuilder0.toString().getBytes()), 11);
            }
            catch(NoSuchAlgorithmException unused_ex) {
            }
            catch(NullPointerException unused_ex) {
                return null;
            }
            try {
                return URLEncoder.encode(stringBuilder0.toString().replaceAll("://|[^\\d\\w]", "_"), "utf-8");
            }
            catch(UnsupportedEncodingException unused_ex) {
                throw new IllegalStateException();
            }
        }
        return null;
    }

    public static void e(String s) {
        FileOutputStream fileOutputStream0;
        Context context0 = MelonAppBase.instance.getContext();
        if(context0 != null) {
            try {
                fileOutputStream0 = null;
                fileOutputStream0 = context0.openFileOutput("premium.auth", 0);
                fileOutputStream0.write(Base64.decode(s, 0));
                i.b = null;
            }
            catch(IOException unused_ex) {
                if(fileOutputStream0 != null) {
                    goto label_14;
                }
                EventBusHelper.post(EventPremiumDownload.UpdateButtonUI);
                return;
            }
            catch(Throwable throwable0) {
                if(fileOutputStream0 != null) {
                    try {
                        fileOutputStream0.close();
                    }
                    catch(IOException unused_ex) {
                    }
                }
                EventBusHelper.post(EventPremiumDownload.UpdateButtonUI);
                throw throwable0;
            }
            try {
            label_14:
                fileOutputStream0.close();
            }
            catch(IOException unused_ex) {
            }
            EventBusHelper.post(EventPremiumDownload.UpdateButtonUI);
        }
    }
}

