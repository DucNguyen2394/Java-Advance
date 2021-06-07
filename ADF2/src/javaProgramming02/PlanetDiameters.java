package javaProgramming02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class PlanetDiameters {
    private static final String[] names = {"Mercury", "Venus", "Earth",
            "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto" };
    private static final float[] diameters = { 4800f, 12103.6f, 12756.3f, 6794f, 142984f,
            120536f, 51118f, 49532f, 2274f };
    public static void main(String[] args) {
        Map planets = new HashMap<>();

        for (int i = 0; i < names.length; i++){
            planets.put(names[i],diameters[i]);
        }

        Iterator it = planets.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry e = (Map.Entry) it.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
        // Find a planet by name basing on key
        while (true){
            System.out.print("Find planet (ENTER to quit): ");
            String name = (new Scanner(System.in)).nextLine();
            if(name.length() == 0){
                break;
            }
            if(planets.containsKey(name)){
                System.out.println("The diameter of " + name +
                        " is " + planets.get(name));
            }else{
                System.out.println("Not found");
            }

        }

    }
}
