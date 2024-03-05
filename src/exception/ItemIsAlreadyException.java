package exception;

public class ItemIsAlreadyException extends RuntimeException {
    
    public ItemIsAlreadyException(String message){
        super(message);
    }

}
