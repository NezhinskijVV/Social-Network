package common;

/**
 * Created by Nezhinskij VV on 15.10.2016.
 */
public class ConnectionPoolException extends Exception{
    public ConnectionPoolException(String message, Exception e){
        super(message,e);
    }
}
