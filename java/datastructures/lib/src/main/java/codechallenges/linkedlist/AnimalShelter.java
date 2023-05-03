package codechallenges.linkedlist;




import datastructures.queue.Queue;

public class AnimalShelter {

  // Animal class
  public static class Animal {
    private String name;
    private AnimalType type;

    public Animal(String name, AnimalType type) {
      this.name = name;
      this.type = type;
    }

    public String getName() {
      return name;
    }

    public AnimalType getType() {
      return type;
    }
  }

  // Animal type enum
  public enum AnimalType {
    DOG,
    CAT
  }

  // Fields
  private Queue<Animal> dogQueue;
  private Queue<Animal> catQueue;

  // Constructor
  public AnimalShelter() {
    dogQueue = new Queue<>();
    catQueue = new Queue<>();
  }

  // Enqueue method
  public void enqueue(Animal animal) {
    if (animal.getType() == AnimalType.DOG) {
      dogQueue.enqueue(animal);
    } else if (animal.getType() == AnimalType.CAT) {
      catQueue.enqueue(animal);
    }
  }

  // Dequeue method
  public Animal dequeue(AnimalType pref) {
    if (pref == AnimalType.DOG && !dogQueue.isEmpty()) {
      return dogQueue.dequeue();
    } else if (pref == AnimalType.CAT && !catQueue.isEmpty()) {
      return catQueue.dequeue();
    } else if (pref == null) {
      // Return the oldest animal if no preference is specified
      if (!dogQueue.isEmpty() && !catQueue.isEmpty()) {
        if (dogQueue.peek().getName().compareTo(catQueue.peek().getName()) < 0) {
          return dogQueue.dequeue();
        } else {
          return catQueue.dequeue();
        }
      } else if (!dogQueue.isEmpty()) {
        return dogQueue.dequeue();
      } else if (!catQueue.isEmpty()) {
        return catQueue.dequeue();
      }
    }
    return null; // Return null if no matching animal is found
  }
}
