package shimkin.lab5;

/**
 *
 * @author User
 */
public class Lab5 {

    public static void main(String[] args) {
        String file1 = "1.properties", file2 = "2.properties";
        try {
            SomeBean firstbean = (new Injector(file1)).inject(new SomeBean());
            firstbean.foo();
            System.out.println();
            SomeBean secondbean = (new Injector(file2)).inject(new SomeBean());
            secondbean.foo();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
