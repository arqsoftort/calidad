package arqsoft.lab.calidad.exception;

public class otherException extends Exception {
    
    int count = 0;

    /**
     * Creates a new instance of <code>CurrencyConverterException</code> without
     * detail message.
     */
    public otherException() {
    }

    /**
     * Constructs an instance of <code>CurrencyConverterException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public otherException(String msg) {
        super(msg);
    }
    
    public otherException(int count) {
        count = count;
    }
    
}