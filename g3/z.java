package g3;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

public final class z extends b {
    public final int e;
    public final byte[] f;
    public final DatagramPacket g;
    public Uri h;
    public DatagramSocket i;
    public MulticastSocket j;
    public InetAddress k;
    public boolean l;
    public int m;

    public z() {
        super(true);
        this.e = 8000;
        byte[] arr_b = new byte[2000];
        this.f = arr_b;
        this.g = new DatagramPacket(arr_b, 0, 2000);
    }

    @Override  // g3.f
    public final void close() {
        this.h = null;
        MulticastSocket multicastSocket0 = this.j;
        if(multicastSocket0 != null) {
            try {
                InetAddress inetAddress0 = this.k;
                inetAddress0.getClass();
                multicastSocket0.leaveGroup(inetAddress0);
            }
            catch(IOException unused_ex) {
            }
            this.j = null;
        }
        DatagramSocket datagramSocket0 = this.i;
        if(datagramSocket0 != null) {
            datagramSocket0.close();
            this.i = null;
        }
        this.k = null;
        this.m = 0;
        if(this.l) {
            this.l = false;
            this.b();
        }
    }

    @Override  // g3.f
    public final Uri getUri() {
        return this.h;
    }

    @Override  // g3.f
    public final long p(j j0) {
        this.h = j0.a;
        String s = j0.a.getHost();
        s.getClass();
        int v = this.h.getPort();
        this.c();
        try {
            this.k = InetAddress.getByName(s);
            InetSocketAddress inetSocketAddress0 = new InetSocketAddress(this.k, v);
            if(this.k.isMulticastAddress()) {
                MulticastSocket multicastSocket0 = new MulticastSocket(inetSocketAddress0);
                this.j = multicastSocket0;
                multicastSocket0.joinGroup(this.k);
                this.i = this.j;
            }
            else {
                this.i = new DatagramSocket(inetSocketAddress0);
            }
            this.i.setSoTimeout(this.e);
            goto label_21;
        }
        catch(SecurityException securityException0) {
        }
        catch(IOException iOException0) {
            throw new y(2001, iOException0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
        }
        throw new y(2006, securityException0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
    label_21:
        this.l = true;
        this.d(j0);
        return -1L;
    }

    @Override  // b3.j
    public final int read(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return 0;
        }
        DatagramPacket datagramPacket0 = this.g;
        if(this.m == 0) {
            try {
                DatagramSocket datagramSocket0 = this.i;
                datagramSocket0.getClass();
                datagramSocket0.receive(datagramPacket0);
            }
            catch(SocketTimeoutException socketTimeoutException0) {
                throw new y(2002, socketTimeoutException0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
            }
            catch(IOException iOException0) {
                throw new y(2001, iOException0);  // 初始化器: Lg3/g;-><init>(ILjava/lang/Exception;)V
            }
            int v2 = datagramPacket0.getLength();
            this.m = v2;
            this.a(v2);
        }
        int v3 = datagramPacket0.getLength();
        int v4 = Math.min(this.m, v1);
        System.arraycopy(this.f, v3 - this.m, arr_b, v, v4);
        this.m -= v4;
        return v4;
    }
}

