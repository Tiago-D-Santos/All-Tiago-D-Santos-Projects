/* public class Main {
    public static void main(String[] args) {
        //------------------Methode1: envoque all types manualy--------------------
        GenericsClassIntClass myInt = new GenericsClassIntClass(22);
        GenericsClassDoubleClass myDouble = new GenericsClassDoubleClass(22.222);
        GenericsClassStringClass myString = new GenericsClassStringClass("lala");
        GenericsClassCharClass myChar = new GenericsClassCharClass('a');

        System.out.println(myInt.getValue());
        System.out.println(myDouble.getValue());
        System.out.println(myString.getValue());
        System.out.println(myChar.getValue());
        //------------------Methode2: use a generic Class
        GenericsClassGenericClass<Integer,Integer> myInt2 = new GenericsClassGenericClass<>(22,22);
        GenericsClassGenericClass<Double,Double> myDouble2 = new GenericsClassGenericClass<>(22.222,22.2222);
        GenericsClassGenericClass<String,String> myString2 = new GenericsClassGenericClass<>("lala","lololo");
        GenericsClassGenericClass<Character,String> myChar2 = new GenericsClassGenericClass<>('a',"aaaaaaaaaaaaaaaaaaaaa");

        System.out.println(myInt2.getValue());
        System.out.println(myDouble2.getValue());
        System.out.println(myString2.getValue());
        System.out.println(myChar2.getValue());

    }
}
 */