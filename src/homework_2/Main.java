package homework_2;

import homework_2.impl.MyArrayList;


public class Main {
    public static void main(String[] args) {
        List<String> strArr = new MyArrayList<>();
        strArr.add("str 1");
        strArr.add("str 2");
        strArr.add("str 3");
        System.out.println(strArr); // [str 1, str 2, str 3]

        System.out.println(strArr.get(2)); // str 3

        strArr.remove(1);
        System.out.println(strArr); // [str 1, str 3]

        List<String> strArr2 = new MyArrayList<>(8);
        strArr2.add("str 4");
        strArr2.add("str 5");

        strArr.addAll(strArr2);
        System.out.println(strArr); //[str 1, str 3, str 4, str 5]

        List<Integer> intArr = new MyArrayList<>();
        intArr.add(4);
        intArr.add(12);
        intArr.add(9);
        intArr.add(43);
        intArr.add(3);
        intArr.add(6);

        System.out.println(intArr); //[4, 12, 9, 43, 3, 6]
        intArr.sort();
        System.out.println(intArr); //[3, 4, 6, 9, 12, 43]
    }
}
