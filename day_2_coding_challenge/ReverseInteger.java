public class ReverseInteger {
    public static int reverseNumber(int n) {
        int reversed = 0;
        while (n != 0) {
            int digit = n % 10;  
            reversed = reversed * 10 + digit;
            n /= 10;        
        }
        return reversed;
    }

    public static void main(String[] args) {
        int number = 120300; 
        System.out.println("Original number: " + number);
        int reversed = reverseNumber(number);
        System.out.println("Reversed number: " + reversed);
    }
}
