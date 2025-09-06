package i.n.i.b.a.s.e;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.security.crypto.EncryptedFile.Builder;
import androidx.security.crypto.EncryptedFile.FileEncryptionScheme;
import androidx.security.crypto.MasterKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;

public final class V0 extends Kb {
    public final Context e;
    public final MasterKey f;
    public FileInputStream g;
    public Uri h;

    public V0(Context context0, MasterKey masterKey0) {
        super(false);
        this.e = context0;
        this.f = masterKey0;
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final long b(W2 w20) {
        long v;
        FileInputStream fileInputStream0;
        Uri uri0 = w20.b;
        this.h = uri0;
        String s = uri0.getPath();
        s.getClass();
        File file0 = new File(s);
        if(!file0.exists() || file0.isDirectory()) {
            throw new j0(new FileNotFoundException("File not found: " + uri0.toString() + " " + (!TextUtils.isEmpty(uri0.getQuery()) || !TextUtils.isEmpty(uri0.getFragment()) ? "Query and/or fragment is not supported in this scheme." : "")));  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
        }
        try {
            fileInputStream0 = new EncryptedFile.Builder(this.e, file0, this.f, EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB).build().openFileInput();
            v = w20.f;
        }
        catch(GeneralSecurityException generalSecurityException0) {
            throw new j0(generalSecurityException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
        }
        if(v != 0L) {
            long v1 = fileInputStream0.skip(v);
            if(w20.f != v1) {
                throw new IOException("File is not large enough. (position=" + w20.f + " skip=" + v1 + ")");
            }
        }
        this.g = fileInputStream0;
        this.d(w20);
        return -1L;
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final Uri c() {
        return this.h;
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final void close() {
        FileInputStream fileInputStream0 = this.g;
        if(fileInputStream0 != null) {
            try {
                fileInputStream0.close();
            }
            catch(IOException iOException0) {
                throw new j0(iOException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
            }
            finally {
                this.h();
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final Map e() {
        return Collections.EMPTY_MAP;
    }

    @Override  // i.n.i.b.a.s.e.xe
    public final int o(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return 0;
        }
        int v2 = this.g.read(arr_b, v, v1);
        this.g(v2);
        return v2;
    }
}

