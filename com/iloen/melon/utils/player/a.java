package com.iloen.melon.utils.player;

import android.app.Notification;
import android.app.RecoverableSecurityException;
import android.app.RemoteAction;
import android.app.Service;
import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.BlendMode;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes.Builder;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack.Builder;
import android.media.AudioTrack;
import android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import androidx.media3.session.p0;
import i.n.i.b.a.s.e.tb;
import java.util.List;

public abstract class a {
    public static void A(AudioTrack audioTrack0, tb tb0) {
        audioTrack0.unregisterStreamEventCallback(tb0);
    }

    public static boolean B(AudioFormat audioFormat0, AudioAttributes audioAttributes0) {
        return AudioManager.isOffloadedPlaybackSupported(audioFormat0, audioAttributes0);
    }

    public static AccessibilityNodeInfo.AccessibilityAction C() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
    }

    public static AccessibilityNodeInfo.AccessibilityAction D() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
    }

    public static RecoverableSecurityException a(Exception exception0) [...] // Inlined contents

    public static RecoverableSecurityException b(Exception exception0, RemoteAction remoteAction0) {
        return new RecoverableSecurityException(exception0, "deleteMV Exception", remoteAction0);
    }

    public static AssetFileDescriptor c(ContentResolver contentResolver0, Uri uri0, Bundle bundle0) {
        return contentResolver0.openTypedAssetFile(uri0, "image/*", bundle0, null);
    }

    public static MediaCodecInfo.VideoCapabilities.PerformancePoint e() {
        return new MediaCodecInfo.VideoCapabilities.PerformancePoint(0x500, 720, 60);
    }

    public static MediaCodecInfo.VideoCapabilities.PerformancePoint f(int v, int v1, int v2) {
        return new MediaCodecInfo.VideoCapabilities.PerformancePoint(v, v1, v2);
    }

    public static MediaCodecInfo.VideoCapabilities.PerformancePoint g(Object object0) {
        return (MediaCodecInfo.VideoCapabilities.PerformancePoint)object0;
    }

    public static AccessibilityNodeInfo.AccessibilityAction h() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
    }

    public static List i(MediaCodecInfo.VideoCapabilities mediaCodecInfo$VideoCapabilities0) {
        return mediaCodecInfo$VideoCapabilities0.getSupportedPerformancePoints();
    }

    public static void j() {
    }

    public static void k(Service service0, int v, Notification notification0) {
        service0.startForeground(v, notification0, 2);
    }

    public static void l(Drawable drawable0, BlendMode blendMode0) {
        drawable0.setTintBlendMode(blendMode0);
    }

    public static void m(AudioAttributes.Builder audioAttributes$Builder0) {
        audioAttributes$Builder0.setAllowedCapturePolicy(1);
    }

    public static void n(AudioTrack.Builder audioTrack$Builder0, boolean z) {
        audioTrack$Builder0.setOffloadedPlayback(z);
    }

    public static boolean u(MediaCodecInfo.VideoCapabilities.PerformancePoint mediaCodecInfo$VideoCapabilities$PerformancePoint0, MediaCodecInfo.VideoCapabilities.PerformancePoint mediaCodecInfo$VideoCapabilities$PerformancePoint1) {
        return mediaCodecInfo$VideoCapabilities$PerformancePoint0.covers(mediaCodecInfo$VideoCapabilities$PerformancePoint1);
    }

    public static boolean w(Exception exception0) {
        return exception0 instanceof RecoverableSecurityException;
    }

    public static AccessibilityNodeInfo.AccessibilityAction x() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
    }

    public static void y() {
    }

    public static void z(AudioTrack audioTrack0, p0 p00, tb tb0) {
        audioTrack0.registerStreamEventCallback(p00, tb0);
    }
}

