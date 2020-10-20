package com.garnagaaa.lesson05.task01.app1;

import com.garnagaaa.lesson05.task01.app1.enums.Sex;
import com.garnagaaa.lesson05.task01.app1.exception.AgeExceptionBase;
import com.garnagaaa.lesson05.task01.app1.exception.NameBasePersonException;

import java.util.Objects;

/**
 * @author Aleksei Garnaga
 * Модель персонажа
 */
public class Person implements Comparable<Person> {
    private Byte age;           // Возраст
    private Sex sex;            // Пол
    private String name;        // Имя

    /**
     * Метод получения возраста
     *
     * @return Возраст
     */
    public Byte getAge() {
        return age;
    }

    /**
     * Метод установки возраста
     *
     * @param age возраст
     * @throws AgeExceptionBase Исключение по возрасту
     */
    private void setAge(Byte age) throws AgeExceptionBase {
        if (age >= 0 && age <= 100) {
            this.age = age;
        } else {
            throw new AgeExceptionBase(String.valueOf(age));
        }
    }

    /**
     * Метод получения пола
     *
     * @return Пол персонажа
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Метод установки пола персонажа
     *
     * @param sex Пол персонажа
     */
    private void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * Метод получения имени персонажа
     *
     * @return Имя пресонажа
     */
    public String getName() {
        return name;
    }

    /**
     * Метод установки имени персонажа
     *
     * @param name Имя персонажа
     * @throws NameBasePersonException Исключение по имени пресонажа...
     */
    private void setName(String name) throws NameBasePersonException {
        if (name != null && !name.equalsIgnoreCase("") && name.length() <= 128) {
            this.name = name;
        } else {
            throw new NameBasePersonException();
        }
    }

    /**
     * Конструктор
     *
     * @param age  Возраст
     * @param sex  Пол
     * @param name Имя
     * @throws AgeExceptionBase        Ошибка возраста
     * @throws NameBasePersonException Ошибка имени пресонажа
     */
    public Person(byte age, Sex sex, String name) throws AgeExceptionBase, NameBasePersonException {
        setAge(age);
        setSex(sex);
        setName(name);
    }

    /**
     * Перегрузка для toString
     *
     * @return Форматированная строка
     */
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age.equals(person.age) &&
                sex == person.sex &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, sex, name);
    }

    @Override
    public int compareTo(Person o) {
        int comp;
        comp = getSex().compareTo(o.getSex());
        if (comp == 0) {
            comp = o.getAge().compareTo(getAge());
        }
        if (comp == 0) {
            comp = getName().compareTo(o.getName());
        }
        return comp;
    }
}
