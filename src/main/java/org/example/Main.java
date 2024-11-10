package org.example;

import java.util.*;

import static java.lang.Math.random;
import static javax.swing.UIManager.get;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задание 1");
        int n = 10;
        Integer[] randomArray = new Integer[n];
        int minValue = 1;
        int maxValue = 100;
        System.out.println("a)");

        for(int i=-0;i<n;i++)
        {
            randomArray[i]=minValue + (int) (random() * (maxValue - minValue + 1));
            System.out.println(randomArray[i]);
        }
        System.out.print("b)");
        List<Integer> list = new ArrayList<>(Arrays.asList(randomArray));
        System.out.println(list);

        Collections.sort(list);
        System.out.print("c)");
        System.out.println(list);

        Collections.reverse(list);
        System.out.print("d)");
        System.out.println(list);

        Collections.shuffle(list);
        System.out.print("e)");
        System.out.println(list);

        Collections.rotate(list, 1);
        System.out.print("f)");
        System.out.println(list);

        Integer[] test={1,1,1,2,3,4,5,5};

        List<Integer> testList = new ArrayList<>(Arrays.asList(test));
        System.out.println(testList);
        List<Integer> uniqueList = new ArrayList<>();
        List<Integer> notUniqueList = new ArrayList<>();

        Map<Integer,Integer> testMap1= new HashMap<>();
        for (int num : testList) {
            testMap1.put(num, testMap1.getOrDefault(num, 0) + 1);
        }
        System.out.println(testMap1);

        for (Map.Entry<Integer, Integer> entry : testMap1.entrySet()) {
            if (entry.getValue()>1){
                notUniqueList.add(entry.getKey());
            }
            else uniqueList.add(entry.getKey());
        }

        System.out.print("g)");
        System.out.println(uniqueList);

        System.out.print("h)");
        System.out.println(notUniqueList);

        Integer[] array = list.toArray(new Integer[0]);
        System.out.print("i)");
        System.out.print('[');
        for (Integer element : array) {
            System.out.print(element + " ");
        }
        System.out.println(']');

        System.out.println("j)");
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : list) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " встречается " + entry.getValue() + " раз");
        }

        //Задание 2
        System.out.println("Задание 2");
        PrimesGenerator p=new PrimesGenerator(10);
        PrimesGeneratorTest t=new PrimesGeneratorTest(p);
        t.test();


        //Задание 3
        System.out.println("\nЗадание 3");

        List<Human> humanArr=new ArrayList<>();
        Human h1= new Human ("Juliya", "Zubenko", 19);
        Human h2= new Human ("Maksim", "Zubenko", 11);
        Human h3= new Human ("Artur", "Peynikov", 19);
        humanArr.add(h1);
        humanArr.add(h2);
        humanArr.add(h3);
        System.out.println(humanArr);

        Set<Human> humanSet = new HashSet<>(humanArr);
        System.out.println("a) "+humanSet); //не сохраняет порядок вставки, удаляет дубликаты, сортировка не выполняется

        Set<Human> humanLinkedHashSet = new LinkedHashSet<>(humanArr);
        System.out.println("b) "+humanLinkedHashSet); //сохраняет порядок вставки, удаляет дубликаты, сортировка не выполняется

        Set<Human> humanTreeSet = new TreeSet<>(humanArr);
        System.out.println("c)"+humanTreeSet);  //сохраняет порядок вставки, удаляет дубликаты, выполняет сортировку по умолчанию(по фамилии)

        Set<Human> humanTreeSet1 = new TreeSet<>(new HumanComparatorByLastName());
        humanTreeSet1.addAll(humanArr);
        System.out.println("d)"+humanTreeSet1); //сохраняет порядок вставки, удаляет дубликаты, выполняет сортировку по фамилии

        Set<Human> humanTreeSet2=new TreeSet<>(new Comparator<Human>(){
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        humanTreeSet2.addAll(humanArr);
        System.out.println("e)"+humanTreeSet2); //сохраняет порядок вставки, удаляет дубликаты, выполняет сортировку по возрасту


        //Задание 4
        System.out.println("Задание 4");

        String str=("Last Christmas, I gave you my heart\n" +
                "But the very next day, you gave it away\n" +
                "This year, to save me from tears\n" +
                "I'll give it to someone special").toLowerCase();

        List<String> arrStr= new ArrayList<>(List.of(str.split("[^a-zA-Z]+")));
        System.out.println(arrStr);

        Map<String, Integer> mapStr=new HashMap<>();
        for(String word: arrStr){
            if(!word.isEmpty()){
                mapStr.put(word, mapStr.getOrDefault(word, 0)+1); // Если слово есть в HashMap, то увеличивается его счетчик, если нет — добавляется с начальным значением 1.
            }
        }
        for (Map.Entry<String, Integer> entry : mapStr.entrySet()) {
            System.out.println("'"+entry.getKey() +"'"+ " встречается " + entry.getValue() + " раз");
        }

        //Задание 5
        System.out.println("Задание 5");

        Map<Integer, String> testMap= new HashMap<>();
        testMap.put(4,"may");
        testMap.put(5, "april");
        testMap.put(12, "september");
        System.out.println(testMap);
        Map<String,Integer> res= new HashMap<>(moving(testMap));
        System.out.println(res);

    }

    public static Map<String, Integer> moving(Map<Integer, String> inputMap) {
        Map<String, Integer> outputMap= new HashMap<>();

        for(Map.Entry<Integer, String> entry1: inputMap.entrySet()){
            outputMap.put(entry1.getValue(), entry1.getKey());
        }
        return outputMap;
    }
}

class PrimesGeneratorTest {
    PrimesGenerator p;

    public PrimesGeneratorTest(PrimesGenerator p) {
        this.p = p;
    }

    public void test() {
        List<Integer> primes =p.getPrimes();
        System.out.println("Простые числа в прямом порядке:");
        for (Integer prime : primes) {
            System.out.print(prime + " ");
        }
        System.out.println("\nПростые числа в обратном порядке:");

        for (Integer prime : primes.reversed()) {
            System.out.print(prime + " ");
        }
    }
}


class PrimesGenerator{

    private List<Integer> primes;
    public PrimesGenerator(int n){
        primes= new ArrayList<>();
        generatePrimes(n);
    }
    private void generatePrimes(int n) {
        int count = 0;
        int number = 2; // Начинаем с первого простого числа

        while (count < n) {
            if (isPrime(number)) {
                primes.add(number);
                count++;
            }
            number++;
        }
    }
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    public List<Integer> getPrimes() {
        return primes;
    }
}



class Human implements Comparable<Human> {
    private String firstName;
    private String lastName;
    private int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + ' ' +lastName + ' ' + age;
    }

    @Override
    public int compareTo(Human other) {
        return this.lastName.compareTo(other.lastName);
    }

    public int getAge() {
        return age;
    }
}

class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return (h1.getLastName()).compareTo(h2.getLastName());
    }
}