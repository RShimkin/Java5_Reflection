package shimkin.lab5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 *
 * @author User
 */
public class Injector {
    Properties props = new Properties();
    
    FileReader file = null;
    
    /**
     * Основной конструктор
     * @param fname - строка имени файла
     */
    public Injector(String fname) throws FileNotFoundException, IOException {
        props.load(new FileReader(fname));
    }
    
    /**
     * Метод с параметром для инъекции зависимостей полей класса
     * @param obj - объект для инъекции
     */
    public<T> T inject(T obj) throws InstantiationException, IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields){
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof AutoInjectable) {
                    Class cla = null;
                    field.setAccessible(true);
                    try{
                        cla = Class.forName((String) props.get(field.getType().getTypeName()));
                    }catch (ClassNotFoundException e){
                        e.printStackTrace();
                    }
                    field.set(obj, cla.newInstance());
                }
            } 
        }
        return obj;
    }
}
