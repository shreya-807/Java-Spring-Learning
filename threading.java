class A extends Thread{
public void run(){
  for(int i=0;i<5;i++){
    System.out.println("Thread A: "+i);
  }
}
}

class B extends Thread{
public void run(){
  for(int i=0;i<15;i++){
    System.out.println("Thread B: "+i);
  }
}
}
public class threading {
public static void main(String[] args){
A obj1= new A();
B obj2= new B();
obj1.start();
obj2.start();
}
}
