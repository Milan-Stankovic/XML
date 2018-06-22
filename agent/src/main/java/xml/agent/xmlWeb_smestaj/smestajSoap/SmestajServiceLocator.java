/**
 * SmestajServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xml.agent.xmlWeb_smestaj.smestajSoap;

import javax.xml.ws.WebServiceClient;

import org.apache.axis.client.Service;

@WebServiceClient(name = "SmestajServiceLocator", targetNamespace = "https://agent.soap.smestaj", wsdlLocation = "https://localhost:8096/services/smestajService?wsdl")
public class SmestajServiceLocator extends Service implements SmestajService {

    public SmestajServiceLocator() {
    }


    public SmestajServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SmestajServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SmestajPort
    private java.lang.String SmestajPort_address = "https://localhost:8096/services/smestajService?wsdl";

    public java.lang.String getSmestajPortAddress() {
        return SmestajPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SmestajPortWSDDServiceName = "SmestajPort";

    public java.lang.String getSmestajPortWSDDServiceName() {
        return SmestajPortWSDDServiceName;
    }

    public void setSmestajPortWSDDServiceName(java.lang.String name) {
        SmestajPortWSDDServiceName = name;
    }

    public SmestajSoap getSmestajPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SmestajPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSmestajPort(endpoint);
    }

    public SmestajSoap getSmestajPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            SmestajServiceSoapBindingStub _stub = new SmestajServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSmestajPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSmestajPortEndpointAddress(java.lang.String address) {
        SmestajPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (SmestajSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                SmestajServiceSoapBindingStub _stub = new SmestajServiceSoapBindingStub(new java.net.URL(SmestajPort_address), this);
                _stub.setPortName(getSmestajPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SmestajPort".equals(inputPortName)) {
            return getSmestajPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://xmlWeb-smestaj/smestajSoap", "SmestajService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://xmlWeb-smestaj/smestajSoap", "SmestajPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SmestajPort".equals(portName)) {
            setSmestajPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}