 package metaprogramming . demo ;
 import java . util . Comparator ;
 public class test implements Comparator < Data > {
 @ Override
 public int compare ( Data data1 , Data data2 ) {
 return data1 . test ( ) . compareTo ( data2 . test ( ) ) ;
 }
 }
