package com.payment.feignClient;


import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient(value="ecommercefrontend", path="/dataServer")
//@LoadBalancerClient(name="cartData", configuration = LoadInstanceConfig.class)
public interface EcommerceServiceRes {
	
	@RequestMapping(method=RequestMethod.GET,path="/cartProdList/{cartId}" )
	CartDataResponse getcartResponse(@PathVariable int cartId);
	
	@RequestMapping(method=RequestMethod.GET,path="/cartDelete/{cartId}")
	CartDeleteResponse delete(@PathVariable int cartId);
}
