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
        if (data.length==size) {
            resize();
        }
        data[size] = str;
        size++;
        return true;
    }

    public String get(int index) {
        return data[index];
    }

    public String set(int index, String element) {
        String old = data[index];
        data[index] = element;
        return old;
    }

    private void resize() {
        String[] bigger = new String[data.length+2];
        for (int i = 0; i < data.length; i++) {
            bigger[i]=data[i];
        }
        data = bigger;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void clear() {
        size = 0; 
        data = new String[10];
    }

    public static void main(String[] args) {
        SuperArray fruits = new SuperArray();
        System.out.println(fruits.size());
        System.out.println(fruits.add("apples"));
        System.out.println(fruits.size());
        System.out.println(fruits.get(0));
        System.out.println(fruits.set(0,"oranges"));
        System.out.println(fruits.add("apples"));
        System.out.println(fruits.add("dragonfruit"));
        System.out.println(fruits.add("grape"));
        System.out.println(fruits.add("persimmon"));
        System.out.println(fruits.add("pear"));
        System.out.println(fruits.add("mango"));
        System.out.println(fruits.add("tomato"));
        System.out.println(fruits.add("banana"));
        System.out.println(fruits.add("watermelon"));
        System.out.println(fruits.add("pineapple"));
        for (int i = 0; i < fruits.size();i++) {
            System.out.println(fruits.get(i));
        }
        SuperArray words = new SuperArray();
        System.out.println(words.isEmpty());
        fruits.clear();
        System.out.println(fruits.size());
        System.out.println(fruits.get(0));
    }
}
