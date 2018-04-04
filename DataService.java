import java.util.Date;

import javax.net.ssl.SSLSession;
import javax.swing.text.Document;
import javax.swing.text.View;
import javax.xml.crypto.Data;

import java.util.*;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.text.*;
import java.io.File;

public class DataService<JSONObject, HttpServletResponse> extends User {
	 
	public DataService(String userEmail, String userPass, Date createTime, Date lastUpdate) {
		super(userEmail, userPass, createTime, lastUpdate);
		// TODO Auto-generated constructor stub
	
	try {
	    //Create an empty JSONArray. This array will contain all data objects.
        JSONArray jsonResponse = new JSONArray();
 
        View thisdb;
		//Create a Domino session
        SSLSession session = ExtLibUtil.getCurrentSessionAsSignerWithFullAccess();
        Data thisdb1 = session.getCurrentDatabase();
        View view = thisdb1.getView("tasks");
 
        //Loop through all documents found in the view
        Document doc = view.getDocument();
        while (doc != null) {
            //TODO: You should do some checks here... is value empty, etc...
 
            //Create a separate JSON Object for each document
            JSONObject jsonObject = new JSONObject();
 
            //Add properties to the JSONObject we want to return
            jsonObject.put("userEmail", doc.getItemValueString("userEmail"));
            jsonObject.put("tite", doc.getItemValueString("title"));
            jsonObject.put("userNote", doc.getItemValueString("userNote"));
            jsonObject.put("createDate", doc.getFirstItem("createDate").getDateTimeValue());
            jsonObject.put("lastUpdate", doc.getFirstItem("lastUpdate").getDateTimeValue());

 
            //Add the JSONObject to the JSONArray
            jsonResponse.put(jsonObject);
 
            //process next document in view
            doc = view.getNextDocument(doc);
        }
        //Create a response
        HttpServletResponse response = engine.getHttpResponse();
 
        //Change response content type to JSON
        response.setHeader("Content-Type", "application/json; charset=UTF-8"); 
 
        //Send the created JSONObject as response
        response.getWriter().write(jsonResponse.toString());
        response.getWriter().close();
    } catch (Exception e) {
        e.printStackTrace();
        }
    }
}
