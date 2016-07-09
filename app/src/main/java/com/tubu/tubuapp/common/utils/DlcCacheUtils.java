package com.tubu.tubuapp.common.utils;

import android.content.Context;
import android.os.Environment;
import android.support.annotation.NonNull;

import com.jakewharton.disklrucache.DiskLruCache;
import com.tubu.tubuapp.common.app.AppInfo;
import com.tubu.tubuapp.constants.PublicConstants;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description: DiskLruCache 封包
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/5 15:32
 * @Modifier: songjunpeng
 * @Update: 2016/7/5 15:32
 */
public class DlcCacheUtils {

    public static DiskLruCache getDiskLruCache(Context context) {
        DiskLruCache diskLruCache = null;
        try {
            File cacheDir = getDiskCacheDir(context, "bitmap");
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            diskLruCache = DiskLruCache.open(cacheDir, AppInfo.getVersionCode(context), 1, PublicConstants.FILE_CACHE_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return diskLruCache;
    }

    private static File getDiskCacheDir(Context context, String uniqueName) {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + uniqueName);
    }

    public static String hashKeyForDisk(String key) {
        String cacheKey;
        try {
            final MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(key.getBytes());
            cacheKey = bytesToHexString(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            cacheKey = String.valueOf(key.hashCode());
        }
        return cacheKey;
    }

    @NonNull
    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}
