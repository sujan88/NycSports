package mum.edu.waa.nycsports.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import mum.edu.waa.nycsports.domain.Cart;
import mum.edu.waa.nycsports.domain.CreditCard;
import mum.edu.waa.nycsports.domain.Customer;
import mum.edu.waa.nycsports.domain.Orders;
import mum.edu.waa.nycsports.domain.ShippingDetail;
import mum.edu.waa.nycsports.service.CartService;
import mum.edu.waa.nycsports.service.OrderService;



@Controller
@SessionAttributes("orderSession")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	CartService cartService;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping("/checkoutCart")
	public String checkOut(@RequestParam String cartId, Model model, Locale locale){
		Cart cart= validateCart(cartId);
		if(cart==null || cart.getCartItems().size()==0){
			return "invalidPromoCode";
		}
        Orders order = new Orders();
        order.setCart(cart);
		model.addAttribute("customer", new Customer());
		model.addAttribute("orderSession", order);
		
		return "/checkout/collectCustomerInfo";
	}
	
	@RequestMapping(value="/shipping", method = RequestMethod.POST)
	public String shipping(@Valid @ModelAttribute("customer") Customer customer,BindingResult result, Model model){
		
		if(result.hasErrors())
		{
		return 	"/checkout/collectCustomerInfo";
		}
		Orders orderSession =(Orders)model.asMap().get("orderSession");
		orderSession.setCustomer(customer);
		model.addAttribute("orderSession", orderSession);
		model.addAttribute("shippingDetail", new ShippingDetail());
		return "/checkout/collectShippingDetail";
	}
	
	@RequestMapping(value="/creditCard", method = RequestMethod.POST)
	public String creditCard(@Valid @ModelAttribute("shippingDetail") ShippingDetail shippingDetail,BindingResult result, Model model){
		if(result.hasErrors())
		{
		return 	"/checkout/collectShippingDetail";
		}
		Orders orderSession =(Orders)model.asMap().get("orderSession");
		orderSession.setShippingDetail(shippingDetail);
		model.addAttribute("orderSession", orderSession);
		model.addAttribute("creditCard", new CreditCard());
		return "/checkout/creditCardInfo";
	}
	
	
	@RequestMapping(value="/details", method = RequestMethod.POST)
	public String orderConfirm(@Valid @ModelAttribute("creditCard") CreditCard creditCard,BindingResult result, Model model){
		if(result.hasErrors())
		{
		return 	"/checkout/creditCardInfo";
		}
		Orders orderSession =(Orders)model.asMap().get("orderSession");
		orderSession.setCreditCard(creditCard);
		orderSession.getCreditCard().setBillingAddress(orderSession.getCustomer().getBillingAddress());
		
		model.addAttribute("orderSession", orderSession);
		return "/checkout/orderConfirmation";
	}
	
	
	
	@RequestMapping(value="/confirm", method = RequestMethod.POST)
	public String saveOrder( Model model) {
		
		Orders orderSession =(Orders)model.asMap().get("orderSession");
		
		Long orderId= orderService.saveOrder(orderSession);
		System.out.println(orderId);
		model.addAttribute("orderId",orderId);
		model.addAttribute("shippingDate",orderSession.getShippingDetail().getShippingDate());
		model.asMap().remove("orderSession");
		return "/checkout/thankCustomer";
	}
	
	public Cart validateCart(String cartId) {
		
		return cartService.validate(cartId);
		
	}
	
	
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
}
