package com.garnagaaa.lesson05.task01.app1;

import java.util.Objects;
import java.util.UUID;

/**
 * @author Aleksei Garnaga
 * Класс модель животного
 */
public class Animal implements Comparable<Animal> {
    private final UUID uid;
    private String name;
    private Person person;
    private Short weight;

    public Animal(String name, Person person, short weight) {
        this.uid = UUID.randomUUID();
        this.name = name;
        this.person = person;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return weight.equals(animal.weight) &&
                Objects.equals(name, animal.name) &&
                person.equals(animal.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, person, weight);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", person=" + person +
                ", weight=" + weight +
                '}';
    }

    public UUID getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public Person getPerson() {
        return person;
    }

    public Short getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setWeight(Short weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Animal o) {
        int comp;
        comp = getPerson().compareTo(o.getPerson());
        if (comp == 0) {
            comp = getName().compareTo(o.getName());
        }
        if (comp == 0) {
            comp = getWeight().compareTo(o.getWeight());
        }
        return comp;
    }
}
