/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confirmfirmaopclient;

import com.siebel.fins.OCSSpcConfirmacionSpcFirmaSpcDigitalSpcWF;
import com.siebel.fins.OcsConfirmarFirma;
import com.siebel.xml.ocs_20detalle_20documento_20io.Action;
import com.siebel.xml.ocs_20detalle_20documento_20io.ListOfAction;
import com.siebel.xml.ocs_20detalle_20documento_20io.ListOfOcsDetalleDocumentoIo;
import com.siebel.xml.ocs_20detalle_20documento_20io.ListOfOcsDetalleDocumentoIoTopElmt;
import java.util.Map;
import javax.jws.WebParam;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

/**
 *
 * @author oscar
 */
public class ConfirmFirmaOPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        OcsConfirmarFirma service = new OcsConfirmarFirma();
        OCSSpcConfirmacionSpcFirmaSpcDigitalSpcWF port = service.getOCSSpcConfirmacionSpcFirmaSpcDigitalSpcWF();

        BindingProvider bp = (BindingProvider) port;
        Map<String, Object> rc = bp.getRequestContext();
        rc.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://lasiewebsit.ccaf.andes:8080/enterprise/EntDetalleDocumentoService?WSDL");

        ListOfOcsDetalleDocumentoIoTopElmt requestIO = new ListOfOcsDetalleDocumentoIoTopElmt();
        ListOfOcsDetalleDocumentoIo value= new ListOfOcsDetalleDocumentoIo();
        ListOfAction listOfAction = new ListOfAction();
        Action action = new Action();
        action.setId("1-1BSUGWR");
        action.setOCSIdDocumento("1-1BSUHIF");
        listOfAction.getAction().add(action);
        value.setListOfAction(listOfAction);
        requestIO.setListOfOcsDetalleDocumentoIo(value);
        Holder<String> errorSpcCode = new Holder<String>();
        Holder<String> errorSpcMessage = new Holder<String>();
        Holder<String> executionStatus = new Holder<String>();

        port.ocsSpcConfirmacionSpcFirmaSpcDigitalSpcWF(requestIO, errorSpcCode, errorSpcMessage, executionStatus);

        System.out.println("Codigo " + errorSpcCode.value);
        System.out.println("Mensaje " + errorSpcMessage.value);
        System.out.println("ExecutionStatus " + executionStatus.value);

    }

}
