public class LongestStringLength {
    public static void main(String[] args) {
        String[] arr = {"apple", "banana", "grapes", "kiwi"};
        int maxLength = 0;

        for (String s : arr) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }

        System.out.println("Length of longest string: " + maxLength);
    }
}
