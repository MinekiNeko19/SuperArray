public class SuperArray {
    private String[] data;
    private int size; // the current size

    // constructor
    public SuperArray() {
        data = new String[10];
        size = 0;
    }

    // methods
    public int size() {
        return size;
    }

    public boolean add(String str) {
        data[size] = str;
        size++;
        return true;
    }

    public String get(int index) {
        return data[index];
    }

    // public String set(int index, String element) {

    // }

    public static void main(String[] args) {
        SuperArray fruits = new SuperArray();
        System.out.println(fruits.size());
        System.out.println(fruits.add("apples"));
        System.out.println(fruits.size());
        System.out.println(fruits.get(0));
    }
}
