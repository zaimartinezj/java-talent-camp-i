package com.companyname.springapp.web.controllers;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.springapp.business.services.PriceIncrease;
import com.companyname.springapp.business.services.ProductManager;

@Controller
@RequestMapping(value="/priceincrease.htm")
public class PriceIncreaseFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ProductManager productManager;

    // será invocado cuando el usuario envíe del formulario a través del método POST.
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid PriceIncrease priceIncrease, BindingResult result)
    {
        if (result.hasErrors()) {
            return "priceincrease";
        }
		
        int increase = priceIncrease.getPercentage();
        logger.info("Increasing prices by " + increase + "%.");

        productManager.increasePrice(increase);

        return "redirect:/hello.htm";
    }
    //será invocado antes de que el formulario se muestre al usuario (petición GET) y rellenará el campo con un incremento por defecto de un 15%.
    @RequestMapping(method = RequestMethod.GET)
    protected PriceIncrease formBackingObject() {
        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(15);
        return priceIncrease;
    }

}