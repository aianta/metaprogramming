 package metaprogramming . demo ;
 public class Data {
 private String test ;
 public void test ( String test ) {
 this . test = test ;
 }
 public String test ( ) {
 return this . test ;
 }
 private String firstName ;
 private String lastName ;
 private Integer id ;
 public String getFirstName ( ) {
 return this . firstName ;
 }
 public void setFirstName ( String firstName ) {
 this . firstName = firstName ;
 }
 public String getLastName ( ) {
 return lastName ;
 }
 public void setLastName ( String lastName ) {
 this . lastName = lastName ;
 }
 public Integer getId ( ) {
 return id ;
 }
 public void setId ( Integer id ) {
 this . id = id ;
 }
 }
