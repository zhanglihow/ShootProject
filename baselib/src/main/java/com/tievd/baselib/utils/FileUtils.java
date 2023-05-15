package com.tievd.baselib.utils;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
    public final String TAG = "LAZY";
    public final static String FILE_EXTENSION_SEPARATOR = ".";
    /** URI类型：file */
    public static final String URI_TYPE_FILE = "file";


    private FileUtils() {
        throw new AssertionError();
    }


    /**
     * 将字符串以charsetName编码保存到文件中
     * @param str    保存的字符串
     * @param fileName  文件的名字
     * @param charsetName  字符串编码
     * @return  是否保存成功
     */
    public static boolean saveStrToFile(String str, String fileName, String charsetName) {

        if (str == null || "".equals(str)) {
            return false;
        }

        FileOutputStream stream = null;
        try {
            File file = new File(fileName);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            byte[] b = null;
            if (charsetName != null && !"".equals(charsetName)) {
                b = str.getBytes(charsetName);
            }
            else {
                b = str.getBytes();
            }

            stream = new FileOutputStream(file);
            stream.write(b, 0, b.length);
            stream.flush();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                    stream = null;
                } catch (Exception e) {
                }
            }
        }
    }


    /**
     * 将content://形式的uri转为实际文件路径
     * @param context    上下文
     * @param uri  地址
     * @return  uri转为实际文件路径
     */
    public static String uriToPath(Context context, Uri uri) {

        Cursor cursor = null;
        try {
            if (uri.getScheme().equalsIgnoreCase(URI_TYPE_FILE)) {
                return uri.getPath();
            }
            cursor = context.getContentResolver()
                    .query(uri, null, null, null, null);
            if (cursor.moveToFirst()) {
                return cursor.getString(cursor.getColumnIndex(
                        MediaStore.Images.Media.DATA)); //图片文件路径
            }
        } catch (Exception e) {
            if (null != cursor) {
                cursor.close();
                cursor = null;
            }
            return null;
        }
        return null;
    }


    /**
     * 打开多媒体文件.
     *
     * @param context    上下文
     * @param file 多媒体文件
     */
    public static void playSound(Context context, String file) {

        playSound(context, new File(file));
    }


    /**
     * 打开多媒体文件.
     *
     * @param context    上下文
     * @param file 多媒体文件
     */
    public static void playSound(Context context, File file) {

        try {
            // 调用系统程序打开文件.
            Intent intent = new Intent(Intent.ACTION_VIEW);
            //			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //			intent.setClassName("com.android.music", "com.android.music.MediaPlaybackActivity");
            intent.setDataAndType(Uri.fromFile(file), "audio/*");
            context.startActivity(intent);
        } catch (Exception ex) {
            Toast.makeText(context, "打开失败.", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * 打开视频文件.
     *
     * @param context    上下文
     * @param file 视频文件
     */
    public static void playVideo(Context context, String file) {

        playVideo(context, new File(file));
    }


    /**
     * 打开视频文件.
     * @param context    上下文
     * @param file 视频文件
     */
    public static void playVideo(Context context, File file) {
        try {
            // 调用系统程序打开文件.
            Intent intent = new Intent(Intent.ACTION_VIEW);
            //			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(file), "video/*");
            context.startActivity(intent);
        } catch (Exception ex) {
            Toast.makeText(context, "打开失败.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 保存多媒体数据为文件.
     *
     * @param data 多媒体数据
     * @param fileName 保存文件名
     * @return 保存成功或失败
     */
    public static boolean save2File(InputStream data, String fileName) {
        File file = new File(fileName);
        FileOutputStream fos = null;
        try {
            // 文件或目录不存在时,创建目录和文件.
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            // 写入数据
            fos = new FileOutputStream(file);
            byte[] b = new byte[1024];
            int len;
            while ((len = data.read(b)) > -1) {
                fos.write(b, 0, len);
            }
            fos.close();

            return true;
        } catch (IOException ex) {

            return false;
        }
    }



    /**
     * 文件重命名
     *
     * @param oldPath    旧的文件名字
     * @param newPath    新的文件名字
     */
    public static void renameFile(String oldPath, String newPath) {

        try {
            if (!TextUtils.isEmpty(oldPath) && !TextUtils.isEmpty(newPath)
                    && !oldPath.equals(newPath)) {
                File fileOld = new File(oldPath);
                File fileNew = new File(newPath);
                fileOld.renameTo(fileNew);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
