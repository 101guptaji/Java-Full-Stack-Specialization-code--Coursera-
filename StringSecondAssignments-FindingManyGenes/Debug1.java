
/**
 * Write a method that finds each occurrence of “abc_” in a String input (where _ is a single character) and prints “bc_” for each such occurrence. 
 * For example, findAbc(“abcdefabcghi”) should print:
 * bcd
 * bcg
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Debug1 {

    public void findAbc(String input) {
    int index = input.indexOf("abc");
    System.out.println("For string '" + input+"'");
    while (true) {
        if (index == -1 || index >= input.length()-3) {
            break;
        }
        //System.out.println("index " + index);
        String found = input.substring(index+1, index+4);
        System.out.println(found);
        index = input.indexOf("abc", index+3);
        //System.out.println("index after updating " + index);
        
    }
}
   public void test() {
     //findAbc("abcd");
     //findAbc("abcdabc");
     findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
     findAbc("abcabcabcabca");
    }
}
