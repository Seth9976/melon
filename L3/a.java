package l3;

import android.net.Uri;
import g3.f;
import g3.h;
import g3.j;
import g3.x;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a implements f {
    public final f a;
    public final byte[] b;
    public final byte[] c;
    public CipherInputStream d;

    public a(f f0, byte[] arr_b, byte[] arr_b1) {
        this.a = f0;
        this.b = arr_b;
        this.c = arr_b1;
    }

    @Override  // g3.f
    public final void close() {
        if(this.d != null) {
            this.d = null;
            this.a.close();
        }
    }

    @Override  // g3.f
    public final Map getResponseHeaders() {
        return this.a.getResponseHeaders();
    }

    @Override  // g3.f
    public final Uri getUri() {
        return this.a.getUri();
    }

    @Override  // g3.f
    public final long p(j j0) {
        Cipher cipher0;
        try {
            cipher0 = Cipher.getInstance("AES/CBC/PKCS7Padding");
        }
        catch(NoSuchAlgorithmException | NoSuchPaddingException noSuchAlgorithmException0) {
            throw new RuntimeException(noSuchAlgorithmException0);
        }
        SecretKeySpec secretKeySpec0 = new SecretKeySpec(this.b, "AES");
        IvParameterSpec ivParameterSpec0 = new IvParameterSpec(this.c);
        try {
            cipher0.init(2, secretKeySpec0, ivParameterSpec0);
        }
        catch(InvalidKeyException | InvalidAlgorithmParameterException invalidKeyException0) {
            throw new RuntimeException(invalidKeyException0);
        }
        h h0 = new h(this.a, j0);
        this.d = new CipherInputStream(h0, cipher0);
        h0.h();
        return -1L;
    }

    @Override  // g3.f
    public final void r(x x0) {
        x0.getClass();
        this.a.r(x0);
    }

    @Override  // b3.j
    public final int read(byte[] arr_b, int v, int v1) {
        this.d.getClass();
        int v2 = this.d.read(arr_b, v, v1);
        return v2 >= 0 ? v2 : -1;
    }
}

