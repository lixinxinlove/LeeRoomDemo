package com.lixinxin.leeroomdemo.cache;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.jakewharton.disklrucache.DiskLruCache;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by lixinxin on 2017/11/28.
 * 缓存
 */

public class DiskLruCacheHelper {


    private static final String DIR_NAME = "diskCache";
    private static final long MAX_COUNT = 5 * 1024 * 1024;
    private static final int DEFAULT_APP_VERSION = 1; //版本升级就 清除数据

    private String path = Environment.getRootDirectory().getPath() + DIR_NAME;

    private File rootFile;

    private DiskLruCache mDiskLruCache;

    public DiskLruCacheHelper(Context context) throws IOException {

        init();
    }

    private void init() throws IOException {
        rootFile = new File(path);
        if (!rootFile.exists()) {
            if (!rootFile.getParentFile().exists()) {
                rootFile.getParentFile().mkdirs();
                rootFile.createNewFile();
            }

        }
        mDiskLruCache = DiskLruCache.open(rootFile, 1, DEFAULT_APP_VERSION, MAX_COUNT);
    }


    public void put(String key, String value) {

        DiskLruCache.Editor editor = null;
        BufferedWriter bw = null;

        try {
            editor = editor(key);
            if (editor != null) {
                return;
            }
            OutputStream os = editor.newOutputStream(0);
            bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write(value);
            editor.commit();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                editor.abort();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }


    /**
     * 返回String
     *
     * @param key
     * @return
     */
    public String getAsString(String key) {
        StringBuilder sb = new StringBuilder();
        InputStream is = null;

        try {
            is = get(key);
            if (is == null) {
                return null;
            }
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = is.read(buf)) != -1) {
                sb.append(new String(buf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }


    /**
     * 获取对应的 editor
     *
     * @param key
     * @return
     */
    private DiskLruCache.Editor editor(String key) {

        try {
            DiskLruCache.Editor editor = mDiskLruCache.edit(key);
            if (editor == null) {
                Log.e("", "");
            }

            return editor;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    private InputStream get(String key) {
        try {
            DiskLruCache.Snapshot snapshot = mDiskLruCache.get(key);
            if (snapshot != null) {
                return snapshot.getInputStream(0);
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}