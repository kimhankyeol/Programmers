package level2;

import java.util.Arrays;
//정확성 측면에서는 이게 빠른데
public class PhoneBookList {
    static String[] phone_book = {"12", "123", "1235", "567", "88"};
    public static void main(String[] args) {
//        for(int i = 0 ; i<phone_book.length;i++){
//            for( int j = i+1 ; j<phone_book.length;j++){
//                //if( phone_book[j].startsWith(phone_book[i])) return false;
//               // if( phone_book[i].startsWith(phone_book[j])) return false;
//            }
//        }
        Arrays.sort(phone_book);
        for(int i = 0 ; i <phone_book.length;i++){
            System.out.println(phone_book[i]);
        }
        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
//                    return false;
            }
        }
    }
}
//효율성 측면
