package part2;

import java.util.ArrayList;

//part2.3 trace of recursive Binary Search
public class Main {
    public static void main(String[] args) {
        int[] a = {2, 3, 5, 10, 16, 24, 32, 48, 96, 120, 240, 360, 800, 1600};
        ArrayList<String> b = new ArrayList<>();
        b.add("banana");
        b.add("apple");
        b.add("orange");
        b.add("raspberry");
        System.out.println("part 2.1");
        System.out.println(recLinearSearch(b,"banana" , 0, b.size() - 1));
        System.out.println("part 2.2");
        System.out.println(binarySearch(a, 10));
        System.out.println(recursiveBinarySearch(a, 150, 0, a.length - 1));
    }

    // part2.1 recursive for linerSearch
    public static int recLinearSearch(ArrayList<String> list, String key, int beginIdx, int endIdx) {
        if (beginIdx > endIdx) {
            return -1;
        } else if (list.get(beginIdx).equals(key)) {
            return beginIdx;
        } else {
            return recLinearSearch(list, key, beginIdx + 1, endIdx);
        }
    }

    //part2.2 binary search
    public static int binarySearch(int[] a, int search) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (search == a[middle]) {
                return middle;
            } else if (search < a[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    //part2.2 recursive binary search
    public static int recursiveBinarySearch(int[] a, int search, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = (low + high) / 2;
        if (search == a[middle]) {
            return middle;
        } else if (search < a[middle]) {
            return recursiveBinarySearch(a, search, low, middle - 1);
        } else {
            return recursiveBinarySearch(a, search, middle + 1, high);
        }
    }
}


//part2.3 trace of recursive binary search

//a = { 2, 3, 5, 10, 16, 24, 32, 48, 96, 120, 240, 360, 800, 1600 }
//first call recursiveBinarySearch(a, 10, 0, 13):
//0 > 13(false), so skip "if" condition
// middle = (0+13)/2 = 6
// 10 = 32(false), so skip second "if" conditions
//10 < 32(true) --> recursiveBinarySearch(a, 10, 0, 5)

//second call recursiveBinarySearch(a, 10, 0, 5):
//0 > 5(false), so skip "if" condition
//middle = (0+5)/2 = 2
//10 = 5 (false), so skip second "if" conditions
//10 < 5(false) , so skip second "else if" conditions
// --> recursiveBinarySearch(a, 10, 3, 5)

//third call recursiveBinarySearch(a, 10, 3, 5):
//3 > 5(false), so skip "if" condition
// middle = (3+5)/2 = 4
// 10 = 16 (false), so skip second "if" conditions
// 10 < 16(true) --> recursiveBinarySearch(a, 10, 3, 3)

//fourth call recursiveBinarySearch(a, 10, 3, 3):
// 3 > 3 (false), so skip "if" condition
// middle = (3+3)/2 = 3
// 10 = 10 (true), return index of search --> 3


//part 2.4. trace of recursive binary search with key 150

//a = { 2, 3, 5, 10, 16, 24, 32, 48, 96, 120, 240, 360, 800, 1600 }
//first call recursiveBinarySearch(a, 10, 0, 13):
//0 > 13(false), so skip "if" condition
//middle = (0 + 13)/2 = 6
//150 = 32 (false), so skip second "if" conditions
//150 < 32 (false), so skip second "else if" conditions
// --> recursiveBinarySearch(a, 150, 7, 13);

//second call recursiveBinarySearch(a, 150, 7, 13):
//7 > 13 (false), so skip "if" condition
//middle = (7 + 13)/2 = 10
//150 = 240 (false), so skip second "if" conditions
//150 < 240 --> recursiveBinarySearch(a, 150, 7, 9)

// third call  recursiveBinarySearch(a, 150, 7, 9):
//7 > 9 (false), so skip "if" condition
// middle = (7 + 9)/2 = 8
// 150 = 96 (false), so skip second "if" conditions
// 150 < 96 (false), so skip second "else if" conditions
// --> recursiveBinarySearch(a, 150, 9, 9);

//fourth call recursiveBinarySearch(a, 150, 9, 9):
// 9 > 9 (false), so skip "if" condition
// middle = (9 + 9)/2 = 9
// 150 = 120  (false), so skip second "if" conditions
// 150 < 120 (false), so skip second "else if" conditions
// --> recursiveBinarySearch(a, 150, 10, 9);

// fifth call recursiveBinarySearch(a, 150, 10, 9):
//10 > 9, return -1, so there is no key with value 150 in array a



