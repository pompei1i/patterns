package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {
    private static final Map<String, TreeType> cache = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "_" + color + "_" + texture;
        if (!cache.containsKey(key)) {
            cache.put(key, new TreeType(name, color, texture));
            System.out.println("  [Flyweight] Created new TreeType: " + name);
        }
        return cache.get(key);
    }

    public static int getCacheSize() { return cache.size(); }
}
