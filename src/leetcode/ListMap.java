package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a1", "1111");
        map.put("a2", "2111");

        List list = new ArrayList<>();
        list.add(map);
    }
}
