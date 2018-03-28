/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chuck
 */
@XmlRootElement
public class ErrorResponse {

    private int errorCode; // server-defined error status code
    private String errorMessage;
    private String documentation;

    // mandatory default no-arg constructor for serialization
    public ErrorResponse() {
        super();
    }

    public ErrorResponse(int errorCode, String errorMessage) {
        this();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    
    public ErrorResponse(int errorCode, String errorMessage, String documentation) {
        this(errorCode, errorMessage);
        this.documentation = documentation;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

}
