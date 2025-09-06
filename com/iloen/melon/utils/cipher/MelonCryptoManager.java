package com.iloen.melon.utils.cipher;

import E9.w;
import Ma.e;
import android.content.Context;
import android.util.Base64;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.system.DeviceIdentifier;
import com.melon.utils.system.DeviceData;
import java.lang.ref.WeakReference;
import k8.o;

public class MelonCryptoManager {
    public static final WeakReference a;

    static {
        System.loadLibrary("meloncrypto");
        MelonCryptoManager.a = new WeakReference(((o)(((e)w.s(MelonAppBase.instance.getContext(), e.class)))).e());
    }

    public static String decrypt(String s) {
        DeviceData deviceData0 = (DeviceData)MelonCryptoManager.a.get();
        Context context0 = MelonAppBase.instance.getContext();
        String s1 = MelonAppBase.instance.getDeviceData().b();
        String s2 = DeviceIdentifier.id(context0);
        return deviceData0 == null ? new String(MelonCryptoManager.getDecCKey("".getBytes(), "".getBytes(), s1.getBytes(), s2.getBytes(), Base64.decode(s.getBytes(), 0))) : new String(MelonCryptoManager.getDecCKey(((DeviceData)MelonCryptoManager.a.get()).e().getBytes(), "".getBytes(), s1.getBytes(), s2.getBytes(), Base64.decode(s.getBytes(), 0)));
    }

    public static String encodeBuyInfo(String s) {
        DeviceData deviceData0 = (DeviceData)MelonCryptoManager.a.get();
        Context context0 = MelonAppBase.instance.getContext();
        String s1 = MelonAppBase.instance.getDeviceData().b();
        String s2 = DeviceIdentifier.id(context0);
        return deviceData0 == null ? Base64.encodeToString(MelonCryptoManager.encodeBuyInfo("".getBytes(), "".getBytes(), s1.getBytes(), s2.getBytes(), s.getBytes()), 0) : Base64.encodeToString(MelonCryptoManager.encodeBuyInfo(((DeviceData)MelonCryptoManager.a.get()).e().getBytes(), "".getBytes(), s1.getBytes(), s2.getBytes(), s.getBytes()), 0);
    }

    private static native byte[] encodeBuyInfo(byte[] arg0, byte[] arg1, byte[] arg2, byte[] arg3, byte[] arg4) {
    }

    public static String encrypt(String s) {
        DeviceData deviceData0 = (DeviceData)MelonCryptoManager.a.get();
        Context context0 = MelonAppBase.instance.getContext();
        String s1 = MelonAppBase.instance.getDeviceData().b();
        String s2 = DeviceIdentifier.id(context0);
        return deviceData0 == null ? Base64.encodeToString(MelonCryptoManager.getEncCKey("".getBytes(), "".getBytes(), s1.getBytes(), s2.getBytes(), s.getBytes()), 0) : Base64.encodeToString(MelonCryptoManager.getEncCKey(((DeviceData)MelonCryptoManager.a.get()).e().getBytes(), "".getBytes(), s1.getBytes(), s2.getBytes(), s.getBytes()), 0);
    }

    public static String getBInfo(byte[] arr_b) {
        DeviceData deviceData0 = (DeviceData)MelonCryptoManager.a.get();
        Context context0 = MelonAppBase.instance.getContext();
        String s = MelonAppBase.instance.getDeviceData().b();
        String s1 = DeviceIdentifier.id(context0);
        return deviceData0 == null ? MelonCryptoManager.getBInfo("".getBytes(), "".getBytes(), s.getBytes(), s1.getBytes(), arr_b) : MelonCryptoManager.getBInfo(((DeviceData)MelonCryptoManager.a.get()).e().getBytes(), "".getBytes(), s.getBytes(), s1.getBytes(), arr_b);
    }

    private static native String getBInfo(byte[] arg0, byte[] arg1, byte[] arg2, byte[] arg3, byte[] arg4) {
    }

    private static native byte[] getDecCKey(byte[] arg0, byte[] arg1, byte[] arg2, byte[] arg3, byte[] arg4) {
    }

    private static native byte[] getEncCKey(byte[] arg0, byte[] arg1, byte[] arg2, byte[] arg3, byte[] arg4) {
    }

    public static int getProductState(byte[] arr_b) {
        DeviceData deviceData0 = (DeviceData)MelonCryptoManager.a.get();
        Context context0 = MelonAppBase.instance.getContext();
        String s = MelonAppBase.instance.getDeviceData().b();
        String s1 = DeviceIdentifier.id(context0);
        return deviceData0 == null ? MelonCryptoManager.getProductState("".getBytes(), "".getBytes(), s.getBytes(), s1.getBytes(), arr_b) : MelonCryptoManager.getProductState(((DeviceData)MelonCryptoManager.a.get()).e().getBytes(), "".getBytes(), s.getBytes(), s1.getBytes(), arr_b);
    }

    private static native int getProductState(byte[] arg0, byte[] arg1, byte[] arg2, byte[] arg3, byte[] arg4) {
    }

    public static boolean isShownBtn(byte[] arr_b) {
        DeviceData deviceData0 = (DeviceData)MelonCryptoManager.a.get();
        Context context0 = MelonAppBase.instance.getContext();
        String s = MelonAppBase.instance.getDeviceData().b();
        String s1 = DeviceIdentifier.id(context0);
        return deviceData0 == null ? MelonCryptoManager.isShownBtn("".getBytes(), "".getBytes(), s.getBytes(), s1.getBytes(), arr_b) : MelonCryptoManager.isShownBtn(((DeviceData)MelonCryptoManager.a.get()).e().getBytes(), "".getBytes(), s.getBytes(), s1.getBytes(), arr_b);
    }

    private static native boolean isShownBtn(byte[] arg0, byte[] arg1, byte[] arg2, byte[] arg3, byte[] arg4) {
    }

    public static boolean isShownSongBtn(byte[] arr_b) {
        DeviceData deviceData0 = (DeviceData)MelonCryptoManager.a.get();
        Context context0 = MelonAppBase.instance.getContext();
        String s = MelonAppBase.instance.getDeviceData().b();
        String s1 = DeviceIdentifier.id(context0);
        return deviceData0 == null ? MelonCryptoManager.isShownSongBtn("".getBytes(), "".getBytes(), s.getBytes(), s1.getBytes(), arr_b) : MelonCryptoManager.isShownSongBtn(((DeviceData)MelonCryptoManager.a.get()).e().getBytes(), "".getBytes(), s.getBytes(), s1.getBytes(), arr_b);
    }

    private static native boolean isShownSongBtn(byte[] arg0, byte[] arg1, byte[] arg2, byte[] arg3, byte[] arg4) {
    }

    public static String melonCrypto(int v, String s) {
        String s1 = DeviceIdentifier.id(MelonAppBase.instance.getContext());
        return v == 0 ? new String(MelonCryptoManager.melonCrypto(0, s1.getBytes(), Base64.decode(s.getBytes(), 0))) : Base64.encodeToString(MelonCryptoManager.melonCrypto(v, s1.getBytes(), s.getBytes()), 0);
    }

    private static native byte[] melonCrypto(int arg0, byte[] arg1, byte[] arg2) {
    }

    public static byte[] patchAuthData(byte[] arr_b) {
        DeviceData deviceData0 = (DeviceData)MelonCryptoManager.a.get();
        Context context0 = MelonAppBase.instance.getContext();
        String s = MelonAppBase.instance.getDeviceData().b();
        String s1 = DeviceIdentifier.id(context0);
        return deviceData0 == null ? MelonCryptoManager.patchAuthData("".getBytes(), "".getBytes(), s.getBytes(), s1.getBytes(), arr_b) : MelonCryptoManager.patchAuthData(((DeviceData)MelonCryptoManager.a.get()).e().getBytes(), "".getBytes(), s.getBytes(), s1.getBytes(), arr_b);
    }

    private static native byte[] patchAuthData(byte[] arg0, byte[] arg1, byte[] arg2, byte[] arg3, byte[] arg4) {
    }
}

