package com.xqk.learn.javase.net.uri;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author 熊乾坤
 * @since 2021-04-19 15:03
 */
public class URIDemo {
    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URI(
                "https://10.65.3.63:44370/illegalrecord_20210204_16_00000000005030000001_87aw28.Jpeg?mt=/mnt/&id=kis_&v=000000&src=10.65.5" +
                        ".70:8000");
        System.out.println(uri.getPath());

        String path = uri.getPath();
        System.out.println(path.lastIndexOf("."));
        System.out.println(path.substring(1));
        //这里这样写会有BUG，是因为第二个SubString的长度会少1
        String suffix = path.substring(1).substring(path.lastIndexOf("."));
        System.out.println(suffix);
    }
}