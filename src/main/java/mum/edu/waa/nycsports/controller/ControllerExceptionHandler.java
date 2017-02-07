	package mum.edu.waa.nycsports.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import mum.edu.waa.nycsports.domain.dto.DomainError;
import mum.edu.waa.nycsports.domain.dto.DomainErrors;
import mum.edu.waa.nycsports.exception.NoProductsFoundUnderCategoryException;
import mum.edu.waa.nycsports.exception.ProductNotFoundException;


@ControllerAdvice
public class ControllerExceptionHandler {

	   public static final String DEFAULT_ERROR_VIEW = "error";

	   @Autowired
		MessageSourceAccessor messageAccessor;
		
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ResponseBody
	       public DomainErrors handleException(MethodArgumentNotValidException exception) {
	        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
	   
	        DomainErrors errors = new DomainErrors();
	        errors.setErrorType("ValidationError");
	        for (FieldError fieldError : fieldErrors) {
	         	DomainError error = new DomainError( messageAccessor.getMessage(fieldError));
	                       errors.addError(error);
	        }
	         
	         return errors;
	    }
	     
	     
	     
	     
	   // Either this Method...OR remove and put @ResponseStatus on NoProductsFoundUnderCategoryException class
	   @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No products found under this category")
	   @ExceptionHandler(NoProductsFoundUnderCategoryException.class)
	   public void noCategoryProducts() {
		        return  ;
		    }
		
		  
	// Either this Method HERE ...OR remove and put it in ProductController
		@ExceptionHandler(ProductNotFoundException.class)
		public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
			 ModelAndView mav = new ModelAndView();
			 mav.addObject("invalidProductId", exception.getFullMessage());
 			 mav.setViewName("productNotFound");
			 return mav;
		}
		
		// BIG BUCKET
//	    @ExceptionHandler(value = Exception.class)
//	    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//	        // If the exception is annotated with @ResponseStatus rethrow it and let
//	        // the framework handle it -  
//	        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
//	            throw e;
//
//	        // Otherwise setup and send the user to a default error-view.
//	        ModelAndView mav = new ModelAndView();
//	        mav.addObject("exception", e);
//	        mav.addObject("url", req.getRequestURL());
//	        mav.setViewName(DEFAULT_ERROR_VIEW);
//	        return mav;
//	    }

		 @ExceptionHandler(NumberFormatException.class)
	     @ResponseStatus(HttpStatus.BAD_REQUEST)
	     @ResponseBody
	        public DomainErrors handleExceptionAll( NumberFormatException exception) {
	    
	         DomainErrors errors = new DomainErrors();
	         errors.setMessage(exception.getMessage()+"n/ Input should be a number.");
	      
	          
	          return errors;
	     }
	    
		 @ExceptionHandler(Exception.class)
	     @ResponseStatus(HttpStatus.BAD_REQUEST)
	     @ResponseBody
	        public DomainErrors handleExceptionAll( Exception exception) {
	    
	         DomainErrors errors = new DomainErrors();
	         errors.setMessage(exception.getMessage());
	      
	          
	          return errors;
	     }
}
