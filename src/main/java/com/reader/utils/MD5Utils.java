package com.reader.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author: lijinhao
 * @date: 2022/04/12 20:12
 */
public class MD5Utils {
    public static String md5Digest(String source, Integer salt){
        char[] ca = source.toCharArray();
        // 混淆源数据
        for(int i = 0; i < ca.length; i++){
            ca[i] = (char) (ca[i] + salt);
        }

        String target = new String(ca);
        return DigestUtils.md5Hex(target);
    }
}
