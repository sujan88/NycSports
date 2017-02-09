package mum.edu.waa.nycsports.service;

import mum.edu.waa.nycsports.domain.CreditCard;

public interface CreditCardService {

	CreditCard findCreditCardByNumber(String number);
}
