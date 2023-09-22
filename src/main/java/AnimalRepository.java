import java.util.ArrayList;
import java.util.HashMap;

public class AnimalRepository {
    private static HashMap<Integer, Animal> animalMap = new HashMap<>();
    private static int lastEntry = 0;

    public static void addAnimal(AnimalType animalType, String name) {
        animalMap.put(lastEntry, new Animal(animalType, name));
        lastEntry++;
    }

    public static HashMap<Integer, Animal> getAnimalsMap() {
        return animalMap;
    }

    public static void removeAnimal(int index) {
        animalMap.remove(index);
    }

    public static void changeAnimalName(int index, String name) {
        animalMap.replace(index, new Animal(animalMap.get(index).getType(), name));
    }
}
