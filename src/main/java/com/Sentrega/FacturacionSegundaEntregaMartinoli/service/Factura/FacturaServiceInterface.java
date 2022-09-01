package com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Factura;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Factura;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public interface FacturaServiceInterface {

    Factura getFacturaById(Integer id);
    List<Factura> getFacturas();
    List<Factura> getFacturasByClienteId(Integer idCliente);
    List<Factura> getFacturaByFecha(Date d);

    Factura postFactura(Factura f)throws ApiException;

    Factura updateFactura(Factura f) throws ApiException;

    Factura delete(Integer id) throws ApiException;
}
