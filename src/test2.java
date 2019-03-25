interface Service{
    void method1();
    void method2();
}

interface ServiceFactory{
    Service getService();
}

class Implementation implements Service{
    Implementation(){

    }

    public void method1(){
        System.out.println("method1");
    }

    public void method2(){
        System.out.println("method2");
    }
}

class ImplementationFactory implements ServiceFactory{

    public Service getService(){
        return new Implementation();
    }
}

public class test2{
    public static void main(String[] args){
        ImplementationFactory face = new ImplementationFactory();
        Service s = face.getService();
        s.method1();
        s.method2();
    }
}