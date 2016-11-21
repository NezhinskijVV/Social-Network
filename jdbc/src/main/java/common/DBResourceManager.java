package common;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Nezhinskij VV on 15.10.2016.
 */
public class DBResourceManager {
    private final static DBResourceManager instance = new DBResourceManager();

    private ResourceBundle bundle = ResourceBundle.getBundle("db", Locale.getDefault());

    public static DBResourceManager getInstance(){
        return instance;
    }

    public String getValue(String key){
        return bundle.getString(key);
    }
}
