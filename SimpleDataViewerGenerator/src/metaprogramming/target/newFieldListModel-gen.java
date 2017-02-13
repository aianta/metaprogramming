 package metaprogramming . demo ;
 import javax . swing . AbstractListModel ;
 public class NewFieldListModel extends DataFieldAbstractListModel {
 private DataModel model ;
 private String listName = "New Field" ;
 public NewFieldListModel ( DataModel model ) {
 this . model = model ;
 }
 @ Override
 public Object getElementAt ( int index ) {
 return model . get ( index ) . getNewField ( ) ;
 }
 @ Override
 public int getSize ( ) {
 return model . getSize ( ) ;
 }
 @ Override
 public void sort ( ) {
 model . sortByNewField ( ) ;
 }
 @ Override
 public String getListName ( ) {
 return this . listName ;
 }
 }
