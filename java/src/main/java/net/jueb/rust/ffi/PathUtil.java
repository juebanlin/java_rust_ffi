package net.jueb.rust.ffi;

import java.io.File;

/**
 * @Classname PathUtil
 * @Description TODO
 * @Date 2021/9/17 3:34 下午
 * @Created by helin
 */
public class PathUtil {

    static final String root;

    static {
        String darwin = new File("").getAbsolutePath();
        root=darwin;
    }

    public static String getRootPath(){
        return new File(root).getParent();
    }

    public static String getLibPath(){
        return getRootPath()+"/target/release";
    }
}
