 package metaprogramming . demo ;
 import java . util . Comparator ;
 public class RankComparator implements Comparator < Data > {
 @ Override
 public int compare ( Data data1 , Data data2 ) {
 return data1 . getRank ( ) . compareTo ( data2 . getRank ( ) ) ;
 }
 }
