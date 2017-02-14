 package metaprogramming . demo ;
 import java . util . Comparator ;
 public class TitleComparator implements Comparator < Data > {
 @ Override
 public int compare ( Data data1 , Data data2 ) {
 return data1 . getTitle ( ) . compareTo ( data2 . getTitle ( ) ) ;
 }
 }
