package net.ktc.customer.exceptions;

public class SuppressionException extends RuntimeException{
    public SuppressionException(String message){
        super("Erreur pendant la suppression. \n CAUSE: "+message);
    }
}
