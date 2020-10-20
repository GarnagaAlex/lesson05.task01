package com.garnagaaa.lesson05.task01.app1;

import com.garnagaaa.lesson05.task01.app1.enums.Sex;

/**
 * @author Aleksei Garnaga
 */
public class Program {
    public static void main(String[] args) throws Exception {

        Base base = new Base();
        base.addAnimal(new Animal("b", new Person((byte) 12, Sex.MAN, "b"), (short) 10));
        base.addAnimal(new Animal("df", new Person((byte) 12, Sex.WOMAN, "a"), (short) 40));
        base.addAnimal(new Animal("sdf", new Person((byte) 12, Sex.WOMAN, "a"), (short) 59));
        base.addAnimal(new Animal("b", new Person((byte) 12, Sex.MAN, "a"), (short) 10));

        System.out.println("-------поиск-----");
        Animal[] t = base.searchByNameAnimal("b");
        for (Animal animal : t) {
            System.out.println(animal);
        }

        System.out.println("-------вывод после сортировки-----");
        base.printSortAnimal();

        System.out.println("-------обновление-----");
        Animal upd = base.getAnimal(0);
        upd.setName("bobik");
        base.updateAnimal(upd);
        base.printSortAnimal();

    }
}