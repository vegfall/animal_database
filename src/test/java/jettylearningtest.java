import org.junit.Test;

public class jettylearningtest {
    @Test
    public void AnimalTest() {
        AnimalRepository.addAnimal(AnimalType.DOG, "Spotty");
        assert (AnimalRepository.getAnimalsMap().size() == 1);
        assert (AnimalRepository.getAnimalsMap().get(0).getName().equals("Spotty"));
    }
}
