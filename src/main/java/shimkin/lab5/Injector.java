package shimkin.lab5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author User
 */
public class Injector {
    Properties props = new Properties();
    
    FileReader file = null;
    
    public Injector() throws FileNotFoundException, IOException {
        file = new FileReader(".properties");
        props.load(file);
    }
}
