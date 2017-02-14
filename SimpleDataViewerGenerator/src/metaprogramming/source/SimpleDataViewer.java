 package metaprogramming . demo ;
 import java . awt . BorderLayout ;
 import java . awt . EventQueue ;
 import javax . swing . JFrame ;
 import javax . swing . JPanel ;
 import javax . swing . border . EmptyBorder ;
 import java . awt . GridBagLayout ;
 import java . awt . GridBagConstraints ;
 import java . awt . Insets ;
 import java . beans . PropertyChangeSupport ;
 import java . awt . FlowLayout ;
 public class SimpleDataViewer extends JFrame {
 Data record1 = new Data ( ) ;
 Data record2 = new Data ( ) ;
 Data record3 = new Data ( ) ;
 private JPanel contentPane = new JPanel ( ) ;
 DataModel dataModel = new DataModel ( ) ;
 private boolean componentUpdate = false ;
 private PropertyChangeSupport stateProperty = new PropertyChangeSupport ( this ) ;
 public static void main ( String [ ] args ) {
 EventQueue . invokeLater ( new Runnable ( ) {
 public void run ( ) {
 try {
 SimpleDataViewer frame = new SimpleDataViewer ( ) ;
 frame . setVisible ( true ) ;
 }
 catch ( Exception e ) {
 e . printStackTrace ( ) ;
 }
 }
 }
 ) ;
 }
 public SimpleDataViewer ( ) {
 TitleListModel titleListModel = new TitleListModel ( dataModel ) ;
 DataFieldPanel titlePanel = new DataFieldPanel ( titleListModel , this ) ;
 contentPane . add ( titlePanel ) ;
 record3 . setTitle ( "QSA" ) ;
 record2 . setTitle ( "TSA" ) ;
 record1 . setTitle ( "CEO" ) ;
 stateProperty . addPropertyChangeListener ( new SimpleDataViewerListener ( titlePanel ) ) ;
 setTitle ( "Simple Data Viewer" ) ;
 setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE ) ;
 setBounds ( 100 , 100 , 450 , 300 ) ;
 contentPane . setBorder ( new EmptyBorder ( 5 , 5 , 5 , 5 ) ) ;
 setContentPane ( contentPane ) ;
 record1 . setFirstName ( "Bob" ) ;
 record1 . setLastName ( "Marley" ) ;
 record1 . setId ( 5 ) ;
 record2 . setFirstName ( "Tim" ) ;
 record2 . setLastName ( "Cook" ) ;
 record2 . setId ( 1 ) ;
 record3 . setFirstName ( "Alex" ) ;
 record3 . setLastName ( "Ianta" ) ;
 record3 . setId ( 7 ) ;
 dataModel . addData ( record1 ) ;
 dataModel . addData ( record2 ) ;
 dataModel . addData ( record3 ) ;
 FirstNameListModel firstNameModel = new FirstNameListModel ( dataModel ) ;
 LastNameListModel lastNameModel = new LastNameListModel ( dataModel ) ;
 IdListModel idModel = new IdListModel ( dataModel ) ;
 contentPane . setLayout ( new FlowLayout ( FlowLayout . CENTER , 5 , 5 ) ) ;
 DataFieldPanel firstNamePanel = new DataFieldPanel ( firstNameModel , this ) ;
 contentPane . add ( firstNamePanel ) ;
 DataFieldPanel lastNamePanel = new DataFieldPanel ( lastNameModel , this ) ;
 contentPane . add ( lastNamePanel ) ;
 DataFieldPanel idPanel = new DataFieldPanel ( idModel , this ) ;
 contentPane . add ( idPanel ) ;
 stateProperty . addPropertyChangeListener ( new SimpleDataViewerListener ( firstNamePanel ) ) ;
 stateProperty . addPropertyChangeListener ( new SimpleDataViewerListener ( lastNamePanel ) ) ;
 stateProperty . addPropertyChangeListener ( new SimpleDataViewerListener ( idPanel ) ) ;
 }
 public boolean isStateChanged ( ) {
 return componentUpdate ;
 }
 public void changeState ( ) {
 boolean oldComponentUpdate = componentUpdate ;
 if ( this . componentUpdate ) {
 this . componentUpdate = false ;
 }
 else {
 this . componentUpdate = true ;
 }
 stateProperty . firePropertyChange ( "componentUpdate" , oldComponentUpdate , componentUpdate ) ;
 }
 }
