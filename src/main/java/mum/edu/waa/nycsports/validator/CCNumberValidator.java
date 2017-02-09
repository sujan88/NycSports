package mum.edu.waa.nycsports.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import mum.edu.waa.nycsports.domain.CreditCard;
import mum.edu.waa.nycsports.domain.Product;
import mum.edu.waa.nycsports.exception.ProductNotFoundException;
import mum.edu.waa.nycsports.service.CreditCardService;
import mum.edu.waa.nycsports.service.ProductService;


public class CCNumberValidator implements ConstraintValidator<CCNumber, String>{
	
	@Autowired
	private CreditCardService creditCardService;

	public void initialize(CCNumber constraintAnnotation) {
		//  intentionally left blank; this is the place to initialize the constraint annotation for any sensible default values.
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		CreditCard card;
		try {
			card = creditCardService.findCreditCardByNumber(value);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		if(card!= null) {
			return true;
		}
		
		return false;
	}
	
}
