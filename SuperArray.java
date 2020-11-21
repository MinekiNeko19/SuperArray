import java.lang.reflect.Array;
import java.util.Arrays;

public class SuperArray {
    private String[] data;
    private int size; // the current size

    // constructor
    public SuperArray() {
        data = new String[10];
        size = 0;
    }

    public SuperArray(int initialCapacity) {
        if (initialCapacity >= 0) {
            data = new String[initialCapacity];
        } else {
            throw new IllegalArgumentException("Initial capacity " + initialCapacity + " cannot be negative.");
        }
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is not in range");
        } else {
            return data[index];
        }
    }

    public String set(int index, String element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " not in range");
        } else {
            String old = data[index];
            data[index] = element;
            return old;
        }
    }

    private void resize() {
        String[] bigger = new String[data.length*2+1];
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        } else {
            if (data.length==size) {
                resize();
            }
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
    }

    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        } else {
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
    }

    public int indexOf(String s) {
        if (this.contains(s)) {
            for (int i = 0; i < size;i++) {
                if (data[i].equals(s)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public String[] toArray() {
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = data[i];
        }
        return arr;
    }

    public int lastIndexOf(String value) {
        for (int i = size()-1; i > 0; i--) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public boolean equals(SuperArray other) {
        if (this.size()==other.size()) {
            for (int i = 0; i < size; i++) {
                if (!data[i].equals(other.get(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        SuperArray fruits = new SuperArray();
        System.out.println(fruits.size());
        fruits.add("apples");
        // fruits.get(0);
        // fruits.set(0,"oranges");
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
        System.out.println(fruits.size());
        // for (int i = 0; i < fruits.size();i++) {
        //     System.out.println(fruits.get(i));
        // }
        // SuperArray words = new SuperArray();
        // System.out.println(words.isEmpty());
        // fruits.clear();
        // System.out.println(fruits.size());
        // System.out.println(fruits.get(0));

        // System.out.println(fruits.toString());

        // System.out.println(fruits.contains("banana"));
        // System.out.println(fruits.contains("turkey"));
        // System.out.println(words.contains("apple"));
        // fruits.add(8, "rambutan");
        // System.out.println(fruits.toString());
        // System.out.println(fruits.remove(8));
        // System.out.println(fruits.toString());
        // System.out.println(fruits.indexOf("dragonfruit"));
        // System.out.println(fruits.indexOf("applesauce"));
        // String[] fruitArray = fruits.toArray();
        // System.out.println(Arrays.toString(fruitArray));

        // Testing exceptions
        // SuperArray exceptional = null;
        // try {
        //     exceptional = new SuperArray(0);
        // } catch (IllegalArgumentException e) {
        //     e.printStackTrace();
        //     System.out.println("Test");
        // }

        // try {
        //     System.out.println(fruits.get(-4));
        // } catch (IndexOutOfBoundsException e) {
        //     e.printStackTrace();
        //     System.out.println("Range of indexes: 0-" + Integer.toString(fruits.size()-1));
        // }

        // try {
        //     System.out.println(fruits.set(11, "kumquat"));
        // } catch (IndexOutOfBoundsException e) {
        //     e.printStackTrace();
        //     System.out.println("Range of indexes: 0-" + Integer.toString(fruits.size()-1));
        // }

        // try {
        //     fruits.add(-3,"kumquat");
        //     System.out.println(fruits.toString());
        // } catch (IndexOutOfBoundsException e) {
        //     e.printStackTrace();
        //     System.out.println("Range of indexes: 0-" + Integer.toString(fruits.size()-1));
        // }

        // try {
        //     System.out.println(fruits.remove(30));
        // } catch (IndexOutOfBoundsException e) {
        //     e.printStackTrace();
        //     System.out.println("Range of indexes: 0-" + Integer.toString(fruits.size()-1));
        // }
    }
}
