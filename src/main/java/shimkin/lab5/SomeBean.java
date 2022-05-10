package shimkin.lab5;

/**
 * Класс с полями типа интерфейсов SomeInterface и SomeOtherInterface,
 * помеченными аннотацией @AutoInjectable
 */
public class SomeBean {
    @AutoInjectable
    private SomeInterface field1;
    
    @AutoInjectable
    private SomeOtherInterface field2;
    
    public void foo(){
        field1.doSomething();
        field2.doSomeOther();
    }
}
