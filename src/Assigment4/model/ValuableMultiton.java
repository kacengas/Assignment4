package Assigment4.model;

import java.util.HashMap;
import java.util.Map;

public class ValuableMultiton extends Valuables {
    private String type;
    private static Map<String, ValuableMultiton> instances = new HashMap<>();

    private ValuableMultiton(String type) {
        super(type);
    }

    public static Valuables getInstance(String type) {
        if (!instances.containsKey(type)) {
            switch (type) {
                case "Diamond":
                    instances.put(type, new ValuableMultiton("Diamond"));
                    break;
                case "Gold":
                    instances.put(type, new ValuableMultiton("Gold"));
                    break;
                case "Emerald":
                    instances.put(type, new ValuableMultiton("Emerald"));
                    break;
                case "Ruby":
                    instances.put(type, new ValuableMultiton("Ruby"));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown valuable type: " + type);
            }
        }
        return instances.get(type);
    }
}
