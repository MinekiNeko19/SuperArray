public class Demo{
    public static void main(String[]args){
        SuperArray words = new SuperArray();
        //grouped to save vertical space
        words.add("kani");   words.add("uni");     words.add("ebi");     words.add("una");     
        words.add("una");    words.add("ebi");     words.add("kani");    words.add("una");
        words.add("una");    words.add("ebi");     words.add("toro"); 
  
        System.out.println(words);
        removeDuplicates(words);
        System.out.println(words);
        SuperArray arr1 = new SuperArray();
        arr1.add("9"); arr1.add("1"); arr1.add("2");
        arr1.add("2");arr1.add("3");arr1.add("4");
        SuperArray arr2 = new SuperArray();
        arr2.add("0");arr2.add("4");arr2.add("2");
        arr2.add("2");arr2.add("9");
        SuperArray test = findOverlap(arr1,arr2);
        System.out.println(test.toString());

        // HW
        // // Testing new SuperArray methods
        // System.out.println(arr2.lastIndexOf("2"));
        // SuperArray test2 = new SuperArray();
        // test2.add("9"); test2.add("2"); test2.add("4");
        // System.out.println(test2.equals(arr2));

        // Testing zip
        // System.out.println(arr1.toString());
        // System.out.println(arr2.toString());
        // System.out.print(zip(arr1,arr2).toString());

        // Testing exception throws
        // SuperArray exceptional = null;
        // try {
        //     exceptional = new SuperArray(-1);
        // } catch (IllegalArgumentException e) {
        //     System.out.println("Test");
        // }
    }

    public static void removeDuplicates(SuperArray s){  
        for (int i = 0; i < s.size();i++) {
            if (s.indexOf(s.get(i))==i) {
                i++;
            } else {
                s.remove(i);
                i--;
            }
        }
    }// using a backwards loop can work and not make you think about indexes

    public static SuperArray findOverlap(SuperArray a, SuperArray b) {
        SuperArray shared = new SuperArray();
        for (int i = 0; i < (Math.max(a.size(),b.size())); i++) {
            if (b.contains(a.get(i))) {
                shared.add(a.get(i));
            }
        }
        removeDuplicates(shared);
        return shared;
    }

    public static SuperArray zip(SuperArray a, SuperArray b) {
        SuperArray zipped = new SuperArray();
        for (int i = 0; i < Math.max(a.size(),b.size());i++) {
            if (i < a.size()) {
                zipped.add(a.get(i));
            }
            if (i < b.size()) {
                zipped.add(b.get(i));
            }
        }
        return zipped;
    }

  }
