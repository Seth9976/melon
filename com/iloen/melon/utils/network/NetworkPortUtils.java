package com.iloen.melon.utils.network;

import com.iloen.melon.utils.log.LogU;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class NetworkPortUtils {
    public static final String TAG = "NetworkPortUtils";
    public static final AtomicInteger a;

    static {
        NetworkPortUtils.a = new AtomicInteger(new Random(System.currentTimeMillis()).nextInt(40000) + 10000);
    }

    public static boolean a(int v) {
        DatagramSocket datagramSocket0;
        ServerSocket serverSocket0;
        if(v < 0x400 || v > 0xFFFF) {
            throw new IllegalArgumentException("Port Number Out of Bound: " + v);
        }
        try {
            serverSocket0 = null;
            serverSocket0 = new ServerSocket(v);
        }
        catch(IOException unused_ex) {
            datagramSocket0 = null;
            goto label_17;
        }
        catch(Throwable throwable0) {
            datagramSocket0 = null;
            goto label_23;
        }
        try {
            serverSocket0.setReuseAddress(true);
            datagramSocket0 = null;
            datagramSocket0 = new DatagramSocket(v);
            goto label_15;
        }
        catch(IOException unused_ex) {
            datagramSocket0 = null;
            goto label_17;
            try {
            label_15:
                datagramSocket0.setReuseAddress(true);
                goto label_28;
            }
            catch(IOException unused_ex) {
            }
            catch(Throwable throwable0) {
                goto label_23;
            }
        label_17:
            if(serverSocket0 != null) {
                serverSocket0.close();
            }
            if(datagramSocket0 != null) {
                datagramSocket0.close();
            }
            return false;
        }
        catch(Throwable throwable0) {
        }
    label_23:
        if(serverSocket0 != null) {
            serverSocket0.close();
        }
        if(datagramSocket0 != null) {
            datagramSocket0.close();
        }
        throw throwable0;
    label_28:
        serverSocket0.close();
        datagramSocket0.close();
        return true;
    }

    public static int b() {
        int v;
        Throwable throwable1;
        IOException iOException1;
        ServerSocket serverSocket0 = null;
        try {
            serverSocket0 = new ServerSocket(0);
        }
        catch(IOException iOException0) {
            iOException1 = iOException0;
            throw new IllegalStateException("Can\'t get an available port.", iOException1);
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            goto label_14;
        }
        try {
            try {
                v = serverSocket0.getLocalPort();
                goto label_20;
            }
            catch(IOException iOException1) {
            }
            throw new IllegalStateException("Can\'t get an available port.", iOException1);
        }
        catch(Throwable throwable1) {
        }
    label_14:
        if(serverSocket0 != null) {
            try {
                serverSocket0.close();
            }
            catch(IOException iOException2) {
                LogU.w("NetworkPortUtils", "getAvailPort() - " + iOException2.toString());
            }
        }
        throw throwable1;
        try {
        label_20:
            serverSocket0.close();
        }
        catch(IOException iOException3) {
            LogU.w("NetworkPortUtils", "getAvailPort() - " + iOException3.toString());
        }
        return v;
    }

    public static int getUnusedPort() {
        int v1;
        synchronized(NetworkPortUtils.class) {
            try {
                do {
                    AtomicInteger atomicInteger0 = NetworkPortUtils.a;
                    v1 = atomicInteger0.getAndIncrement();
                    if(v1 >= 50000) {
                        atomicInteger0.set(10000);
                        v1 = atomicInteger0.getAndIncrement();
                    }
                }
                while(!NetworkPortUtils.a(v1));
                return v1;
            }
            catch(IOException unused_ex) {
                return NetworkPortUtils.b();
            }
        }
    }
}

