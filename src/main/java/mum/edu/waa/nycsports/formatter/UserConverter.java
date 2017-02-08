package mum.edu.waa.nycsports.formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.core.convert.converter.Converter;

import mum.edu.waa.nycsports.domain.Address;
import mum.edu.waa.nycsports.domain.User;

public class UserConverter implements Converter<String, User> {
	
	@Override
	public User convert(String text) {
		JSONObject jObject = new JSONObject(text);
		JSONObject juser = (JSONObject) jObject.get("customer");		
		JSONObject jaddress = (JSONObject) jObject.get("address");
		
		//User
		User user = new User();
		user.setFirstName(juser.get("firstName").toString());
		user.setLastName(juser.get("lastName").toString());
		user.setEmail(juser.get("email").toString());
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
	
		Date dob = null;
		try {
			dob = df.parse(juser.get("dob").toString());
		} catch (JSONException | ParseException e) {
			e.printStackTrace();
		}
		
		user.setDob(dob);
		
		//Address
		Address address = new Address();
		address.setStreet(jaddress.get("street").toString());
		address.setCity(jaddress.get("city").toString());
		address.setState(jaddress.get("state").toString());
		address.setZipCode(jaddress.get("zipCode").toString());
		
		user.addAddress(address);
		
		return user;
	}

}
