package mum.edu.waa.nycsports.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.waa.nycsports.domain.CreditCard;
import mum.edu.waa.nycsports.repository.CreditCardRepository;
import mum.edu.waa.nycsports.service.CreditCardService;

@Service
@Transactional
public class CreditCardServiceImpl  implements CreditCardService{

	@Autowired
	CreditCardRepository creditCardRepository;
	@Override
	public CreditCard findCreditCardByNumber(String number) {
		
		return creditCardRepository.findCreditCardByNumber(number);
	}

}
