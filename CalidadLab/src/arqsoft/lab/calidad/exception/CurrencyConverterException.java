package arqsoft.lab.calidad.exception;

public class CurrencyConverterException extends Exception {

    /**
     * Creates a new instance of <code>CurrencyConverterException</code> without
     * detail message.
     */
    public CurrencyConverterException() {
    }

    /**
     * Constructs an instance of <code>CurrencyConverterException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public CurrencyConverterException(String msg) {
        super(msg);
    }
    
}