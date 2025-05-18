class JavaQuestions{
  public static void main(String[] args){
    /*In below Strings how many Objects are created*/
    String s1="Welcome";
    String s2="Welcome";
    String s3="Welcome";
    /*Answer is only one object is created here because "Welcome" is created once and stored in String pool from s1 and once object is created since s2 and s3 are 
    created as String literal rather than created using new String("") it refers same object as s1*/
    
  }
}
