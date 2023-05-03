package codechallenges.linkedlist;


import codechallenges.linkedlist.AnimalShelter.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalShelterTest {
  private AnimalShelter shelter;

  @BeforeEach
  void setUp() {
    shelter = new AnimalShelter();
  }

  @Test
  void enqueueAddsAnimalsToCorrectQueue() {
    AnimalShelter.Animal cat = new AnimalShelter.Animal("Mittens", AnimalShelter.AnimalType.CAT);
    AnimalShelter.Animal dog = new AnimalShelter.Animal("Fido", AnimalShelter.AnimalType.DOG);

    shelter.enqueue(cat);
    shelter.enqueue(dog);

    assertEquals(cat, shelter.dequeue(AnimalShelter.AnimalType.CAT));
    assertEquals(dog, shelter.dequeue(AnimalShelter.AnimalType.DOG));
  }

  @Test
  void dequeueReturnsOldestAnimal() {
    AnimalShelter.Animal cat1 = new AnimalShelter.Animal("Mittens", AnimalShelter.AnimalType.CAT);
    AnimalShelter.Animal cat2 = new AnimalShelter.Animal("Whiskers", AnimalShelter.AnimalType.CAT);
    AnimalShelter.Animal dog1 = new AnimalShelter.Animal("Fido", AnimalShelter.AnimalType.DOG);
    AnimalShelter.Animal dog2 = new AnimalShelter.Animal("Rex", AnimalShelter.AnimalType.DOG);

    shelter.enqueue(cat1);
    shelter.enqueue(dog1);
    shelter.enqueue(cat2);
    shelter.enqueue(dog2);

    assertEquals(cat1, shelter.dequeue(AnimalShelter.AnimalType.CAT));
    assertEquals(dog1, shelter.dequeue(AnimalShelter.AnimalType.DOG));
    assertEquals(cat2, shelter.dequeue(AnimalShelter.AnimalType.CAT));
    assertEquals(dog2, shelter.dequeue(AnimalShelter.AnimalType.DOG));
  }

  @Test
  void dequeueReturnsOldestAnimalIfNoPreference() {
    AnimalShelter.Animal cat1 = new AnimalShelter.Animal("Mittens", AnimalShelter.AnimalType.CAT);
    AnimalShelter.Animal cat2 = new AnimalShelter.Animal("Whiskers", AnimalShelter.AnimalType.CAT);
    AnimalShelter.Animal dog1 = new AnimalShelter.Animal("Fido", AnimalShelter.AnimalType.DOG);
    AnimalShelter.Animal dog2 = new AnimalShelter.Animal("Rex", AnimalShelter.AnimalType.DOG);

    shelter.enqueue(cat1);
    shelter.enqueue(dog1);
    shelter.enqueue(cat2);
    shelter.enqueue(dog2);

    assertEquals(cat1, shelter.dequeue(null));
    assertEquals(dog1, shelter.dequeue(null));
    assertEquals(cat2, shelter.dequeue(null));
    assertEquals(dog2, shelter.dequeue(null));
  }

  @Test
  void dequeueReturnsNullIfNoMatchingAnimal() {
    assertNull(shelter.dequeue(AnimalShelter.AnimalType.CAT));
    assertNull(shelter.dequeue(AnimalShelter.AnimalType.DOG));
  }

}
