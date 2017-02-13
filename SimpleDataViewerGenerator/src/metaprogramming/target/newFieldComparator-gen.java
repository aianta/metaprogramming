 package metaprogramming . demo ;
 import java . util . Comparator ;
 public class NewFieldComparator implements Comparator < Data > {
 @ Override
 public int compare ( Data data1 , Data data2 ) {
 return data1 . getNewField ( ) . compareTo ( data2 . getNewField ( ) ) ;
 }
 }
