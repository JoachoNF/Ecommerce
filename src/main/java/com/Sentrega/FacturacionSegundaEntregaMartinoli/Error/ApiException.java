package com.Sentrega.FacturacionSegundaEntregaMartinoli.Error;

public class ApiException extends Exception{
    private String error;
    public ApiException(String error){super(error);}
}
