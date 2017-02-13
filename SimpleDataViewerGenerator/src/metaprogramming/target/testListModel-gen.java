 package metaprogramming . demo ;
 import javax . swing . AbstractListModel ;
 public class test extends DataFieldAbstractListModel {
 private DataModel model ;
 private String listName = test ;
 public test ( DataModel model ) {
 this . model = model ;
 }
 @ Override
 public Object getElementAt ( int index ) {
 return model . get ( index ) . test ( ) ;
 }
 @ Override
 public int getSize ( ) {
 return model . getSize ( ) ;
 }
 @ Override
 public void sort ( ) {
 model . test ( ) ;
 }
 @ Override
 public String getListName ( ) {
 return this . listName ;
 }
 }
