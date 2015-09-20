package com.rescam.androidapp.bimx.activity;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

//���
public class SelectDriver {
	
  	private static final String targetNamespace = "http://service.web.fsms.brzt.com/";

  	//������·��
  	//private static String URL = "http://192.168.1.21:6060/fsms/services/PhoneWebService?wsdl";
  	//��������·��
  	private static String URL = "http://www.bdtrace.com.cn/mgr/services/PhoneWebService?wsdl";

  	private static final String METHOD_NAME = "getCarByCarNumber";
  	private static String SOAP_ACTION = targetNamespace + METHOD_NAME;
  	
  	private String de;
  	
  	public String getJson(String carCord) {
  		SoapObject rpc = new SoapObject(targetNamespace, METHOD_NAME);
  		//���ݽṹ
  		//{"car_number":"��a32164"}
  		carCord = changeLetter(carCord);
  		String params = "{\"car_number\":\""
				+ carCord +
				"}";
  		rpc.addProperty("arg0", params);
  		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
  				SoapEnvelope.VER11);
  		envelope.bodyOut = rpc;
  		envelope.dotNet = false;
  		HttpTransportSE ht = new HttpTransportSE(URL);
  		ht.debug = true;

  		try {
  			ht.call(SOAP_ACTION, envelope);
  			de = envelope.getResponse().toString();
  			
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} catch (XmlPullParserException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		return de;
  	}
  	
  	public String changeLetter(String carCord){
		byte[] buff = carCord.getBytes();
		for (int i=0;i<buff.length;i++){
			if (buff[i]>='a' && buff[i]<='z'){
				buff[i] += ('A'-'a');
			}
		}
		String result = new String(buff);
		return result;
  	}
}
