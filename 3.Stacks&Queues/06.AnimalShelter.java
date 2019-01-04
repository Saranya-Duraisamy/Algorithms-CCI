import java.util.LinkedList;

/*
 * Animal Shelter: LinkedLists with below operations
 * enqueue, dequeueAny, dequeueDog, dequeueCat
 */
class Animal{
    String name;
    int order;

    Animal(String name, int order) {
        this.name = name;
        this.order = order;
    }

    int getArrivalOrder(){
        return this.order;
    }

    public String toString(){
        return name+" "+order;
    }
}

class AnimalShelter {
    LinkedList<Animal> dogsList;
    LinkedList<Animal> catsList;
    int arrivalOrder;

    AnimalShelter(){
        dogsList = new LinkedList<>();
        catsList = new LinkedList<>();
        arrivalOrder = 0;
    }

    // Enqueue common to all animals
    public void enqueue(String name) {
        Animal animal = new Animal(name, arrivalOrder);
        if(name.equalsIgnoreCase("dog")) {
            dogsList.add(animal);
        }
        else if(name.equalsIgnoreCase("cat")) {
            catsList.add(animal);
        }
        arrivalOrder++;
    }

    // dequeue the oldest(based on arrival time) among all animals
    public Animal dequeueAny(){
        Animal dog = null;
        Animal cat = null;

        // Both lists are non empty
        if(!dogsList.isEmpty()){
            dog = dogsList.peek();
        }
        if(!catsList.isEmpty()) {
            cat = catsList.peek();
        }

        if(dog != null && cat != null) {
            return (dog.getArrivalOrder() < cat.getArrivalOrder()) ? dogsList.remove():catsList.remove();
        }
        else if(dog == null && cat == null) {
            return null;
        }
        else if(cat == null) {
            return dogsList.remove();
        }
        else {
            return catsList.remove();
        }
    }

    //dequeue the oldest(based on arrival time) dog
    public Animal dequeueDog(){
        if(!dogsList.isEmpty()){
            return dogsList.remove();
        }
        return null;
    }

    //dequeue the oldest(based on arrival time) cat
    public Animal dequeueCat(){
        if(!catsList.isEmpty()){
            return catsList.remove();
        }
        return null;
    }

    public String toString(){
        StringBuilder sbr = new StringBuilder();
        for(Animal dogs:dogsList){
            sbr.append(dogs + ", ");
        }
        sbr.append("\n");
        for(Animal cats:catsList){
            sbr.append(cats + ", ");
        }
        return sbr.toString();
    }
}
class Solution {
    public static void main(String args[]) {
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue("dog");
        animalShelter.enqueue("cat");
        animalShelter.enqueue("dog");
        animalShelter.enqueue("cat");
        animalShelter.enqueue("dog");
        animalShelter.enqueue("cat");
        System.out.println(animalShelter);
        System.out.println("DequeueAny: " + animalShelter.dequeueAny());
        System.out.println(animalShelter);
        System.out.println("DequeueDog: " + animalShelter.dequeueDog());
        System.out.println(animalShelter);
        System.out.println("DequeueAny: " + animalShelter.dequeueAny());
        System.out.println(animalShelter);
        System.out.println("DequeueDog: " + animalShelter.dequeueDog());
    }
}