public class SuperArray {
    private String[] data;
    private int size; // the current size

    // constructor
    public SuperArray() {
        data = new String[10];
        size = 0;
    }

    public SuperArray(int initialCapacity) {
            data = new String[initialCapacity];
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
        String[] bigger = new String[data.length+(data.length)];
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

    public boolean contains(String s) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(s)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String list = "[" + data[0];
        for (int i = 1; i < size; i++) {
            list += ", " + data[i];
        }
        list += "]";
        return list;
    }

    public void add(int index, String element) {
        String replace = data[index];
        String store = "";
        data[index] = element;
        for (int i = index+1; i < size; i++) {
            store = data[i];
            data[i] = replace;
            replace = store;
        }
        data[size] = replace;
        size++;
    }

    public String remove(int index) {
        String gone = data[index];
        String replace = data[size-1];
        String store = "";
        data[size-1] = null;
        for (int i = size-2; i > index; i--) {
            store = data[i];
            data[i]=replace;
            replace = store;
        }
        data[index] = replace;
        size--;
        return gone;
    }
    
    public static void main(String[] args) {
        SuperArray fruits = new SuperArray();
        System.out.println(fruits.size());
        fruits.add("apples");
        fruits.size();
        fruits.get(0);
        fruits.set(0,"oranges");
        fruits.add("apples");
        fruits.add("dragonfruit");
        fruits.add("grape");
        fruits.add("persimmon");
        fruits.add("pear");
        fruits.add("mango");
        fruits.add("tomato");
        fruits.add("banana");
        fruits.add("watermelon");
        fruits.add("pineapple");
        // for (int i = 0; i < fruits.size();i++) {
        //     System.out.println(fruits.get(i));
        // }
        SuperArray words = new SuperArray();
        System.out.println(words.isEmpty());
        // fruits.clear();
        // System.out.println(fruits.size());
        // System.out.println(fruits.get(0));

        System.out.println(fruits.toString());

        // System.out.println(fruits.contains("banana"));
        // System.out.println(fruits.contains("turkey"));
        // System.out.println(words.contains("apple"));
        fruits.add(8, "rambutan");
        System.out.println(fruits.toString());
        System.out.println(fruits.remove(8));
        System.out.println(fruits.toString());
    }
}
