package leetcode;

import java.io.UnsupportedEncodingException;

public class Test {
    public static void main(String[] args) {
        String s = "select * from test";
        System.out.println(s.getBytes());
        byte [] bb = new byte[0];
        try {
            bb = s.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < bb.length ; i ++){
            System.out.println(bb[i]);
        }

    }
}
