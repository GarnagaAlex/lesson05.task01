package com.garnagaaa.lesson05.task01.app1;

import java.util.*;

/**
 * @author Aleksei Garnaga
 * Класс хранилище данных
 */
public class Base {

    private List<Animal> list = new ArrayList<>();
    private Map<String, List<Integer>> NameAnimalIndex = new HashMap<>();

    /**
     * @return Количество записей в базе
     */
    public int getCount() {
        return list.size();
    }

    /**
     * @param idx Идентификатор животного
     * @return Возвращает животное по его идентификатору
     */
    public Animal getAnimal(int idx) {
        return list.get(idx);
    }

    /**
     * @param animal Животное которое необходимо добавить
     * @throws Exception Исключение в случае если такая запись уже существует
     */
    public void addAnimal(Animal animal) throws Exception {
        if (!list.contains(animal)) {
            list.add(animal);
            addIndex(list.indexOf(animal));
        } else {
            throw new Exception("Уже существует");
        }
    }

    /**
     * Метод добавляет индекс
     * @param index Индекс элемента
     */
    private void addIndex(int index) {
        Animal temp = list.get(index);
        if (!NameAnimalIndex.containsKey(temp.getName())) {
            NameAnimalIndex.put(temp.getName(), new ArrayList<Integer>());
        }
        NameAnimalIndex.get(temp.getName()).add(index);
    }

    /**
     * @param animal Кличка животного
     * @return Массив животных с данной кличкой
     */
    public Animal[] searchByNameAnimal(String animal) {
        if (NameAnimalIndex.containsKey(animal)) {
            List<Integer> temp = NameAnimalIndex.get(animal);
            Animal[] ret = new Animal[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                ret[i] = list.get(temp.get(i));
            }
            return ret;
        }
        return null;
    }

    /**
     * Метод обновления животного
     * @param animal Новое состояние животного
     */
    public void updateAnimal(Animal animal) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUid().equals(animal.getUid())) {
                list.set(i, animal);
                break;
            }
        }
    }

    /**
     * Метод печати отсортированного списка животных
     */
    public void printSortAnimal() {
        List<Animal> temp = new ArrayList<>(list);
        Collections.sort(temp);
        for (Animal animal : temp) {
            System.out.println(animal);
        }
    }

    @Override
    public String toString() {
        Collections.sort(list);
        return "Base{" +
                "list=" + list +
                '}';
    }
}
