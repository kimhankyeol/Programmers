//package basic;
//
//import java.util.Comparator;
//
//public class BinTree {
//    static class Node<K,V>{
//        private K key;
//        private V data;
//        private Node<K,V> left;
//        private Node<K,V> right;
//
//        Node(K key, V data, Node<K,V> left, Node<K,V> right){
//            this.key = key;
//            this.data = data;
//            this.left = left;
//            this.right = right;
//        }
//
//        K getKey(){
//            return key;
//        }
//
//        V getData(){
//            return data;
//        }
//
//        void print(){
//            System.out.println(data);
//        }
//    }
////    private Node<K,V> root; // 루트
////    private Comparator<? super K> comparator = null; 비교자
//    //key1> key2 양수
//    //key1<key2 음수
//    //key1 == key2 0ㅕㅓ7
//    private int comp(K key1, K key2){
//            return (comparator == null) ? ((COmparable<K>) key1).compareTo(key2) : comprator.compare(key1,key2)
//    }
//}
//
//
