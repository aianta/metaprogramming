 package metaprogramming . demo ;
 import javax . swing . AbstractListModel ;
 public class TitleListModel extends DataFieldAbstractListModel {
 private DataModel model ;
 private String listName = "Title" ;
 public TitleListModel ( DataModel model ) {
 this . model = model ;
 }
 @ Override
 public Object getElementAt ( int index ) {
 return model . get ( index ) . getTitle ( ) ;
 }
 @ Override
 public int getSize ( ) {
 return model . getSize ( ) ;
 }
 @ Override
 public void sort ( ) {
 model . sortByTitle ( ) ;
 }
 @ Override
 public String getListName ( ) {
 return this . listName ;
 }
 }
