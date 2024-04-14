package com.jsonServer.responseEntity;



import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;


import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsonServer.Dao.CartDao;
import com.jsonServer.Dao.CartProductDao;
import com.jsonServer.Dao.CouponCodeDao;
import com.jsonServer.Dao.ProdCategoryDao;
import com.jsonServer.Dao.ProdInfoDao;
import com.jsonServer.Dto.CouponDto;
import com.jsonServer.Dto.ProdIdDto;
import com.jsonServer.Dto.ProductCatDto;
import com.jsonServer.Dto.ProductCatMapper;
import com.jsonServer.Dto.ProductDataDto;
import com.jsonServer.Dto.ProductPicDto;
import com.jsonServer.Dto.UpdateProdCatDto;

import com.jsonServer.cloudinaryservice.CloudinaryImageservice;
import com.jsonServer.exception.DuplicateException;
import com.jsonServer.model.Cart;
import com.jsonServer.model.CartProduct;
import com.jsonServer.model.CouponCode;
import com.jsonServer.model.ProdCategory;
import com.jsonServer.model.ProdIds;
import com.jsonServer.model.ProductInfo;

import com.jsonServer.service.ProdCatServiceImp;

import com.jsonServer.validator.ValidatorProgrammatically;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;



@RestController()
@RequestMapping(path="/dataServer")
@Validated
public class JsonController {
	
	@Autowired
	CloudinaryImageservice cloudinaryImageservice;
	
	  @Autowired
	 ProdCategoryDao prodCategoryDao;
	 
	 ProductInfo productInfo = null;
	 @Autowired
	 ProdCatServiceImp  prodCatServiceImp;
	 @Autowired
     private ObjectMapper mapper;
	 @Autowired
	 private ModelMapper modelMapper;
	 @Autowired
	 private ProductCatDto productCatDto;
	 
	 private ProdCategory prodCategory = null;
	 @Autowired
	 ValidatorProgrammatically validProgrammatically;
	 @Autowired
	 ProductCatMapper productCatMapper;
	 @Autowired
	 ProductPicDto productPicDto;
	 @Autowired
	 ProdIdDto prodIdDto;
	 @Autowired
	 CartDao cartDao;
	 @Autowired
	 ProdInfoDao prodInfoDao;
	 @Autowired
	 CartProductDao cartProductDao;
	 @Autowired
	 CouponCodeDao couponCodeDao;
	 
	 @Autowired
	 FeignCartResponse feignCartResponse;
	
	 @Autowired
	 private Environment environment;
	 
	 
	 
	 private double discountValue = 0;
	 
	 private double total1 = 0;
	 
	 @PostMapping(path="/categoryCreation" ,produces= MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Object> CategoryCreation(@RequestParam("prodCatInfo") String prodCatInfo ,@RequestParam("prodCatFile") MultipartFile prodCatFile) throws IOException, DuplicateException{
		 
		 
		 
		 Map data =  this.cloudinaryImageservice.upload(prodCatFile);
			
		 String st = "secure_url"; 
		 
		 data.forEach((k,v)->{
			 if(k.equals(st)) {
				 System.out.println(v);
				 productPicDto.setProdPicUrl(v.toString());
			 }
			
		 });
		 
		 
		 productCatDto  =   mapper.readValue(prodCatInfo,ProductCatDto.class);
		 
		
		
		//programaticall validator setup
		 
		  validProgrammatically.validateInput(productCatDto);
		  validProgrammatically.validateImage(productPicDto);
		 // ending validator setup
		 prodCategory = new ProdCategory();
		 productInfo = new ProductInfo(); 
	/*	
		if(result.hasErrors()) {
			System.out.println("has some error");
		}else {
			System.out.println("No error------------");
		}
		 */
		// ProdCategory prodCategory = modelMapper.map(productCatDto,ProdCategory.class);
		 
		 
		 System.out.println(productCatDto.toString());
		 
		if(!prodCatFile.isEmpty()&&!(productCatDto==null)) {
			System.out.println("file exist");
			
			 
			
			 productInfo.setProdId(productCatDto.getProdId());
			 productInfo.setProdTitle(productCatDto.getProdTitle());
			 productInfo.setProdQuantity(productCatDto.getProdQuantity());
			 productInfo.setRateProd(productCatDto.getRateProd());
			 productInfo.setTotalRate(productCatDto.getTotalRate());
			 productInfo.setCutPrice(productCatDto.getCutPrice());
			 productInfo.setSalePrice(productCatDto.getSalePrice());
			 productInfo.setOffer(productCatDto.getOffer());
			 productInfo.setProdPicUrl(productPicDto.getProdPicUrl());  
			 productInfo.setProdCategory(prodCategory);
			 
			 List<ProductInfo> ListprodInfo = new ArrayList<>();
			 
			 ListprodInfo.add(productInfo);
			 
			 prodCategory.setProductInfo(ListprodInfo);
			 prodCategory.setProdCategory(productCatDto.getProdCategory());
			 prodCategory.setProdCategoryId(productCatDto.getProdCategoryId());
			prodCatServiceImp.SaveCatService(prodCategory);
		
			 
			 
			 String jsonResponse = "Got the request categoryCreation";
			 
			 return ResponseEntity.ok().body(jsonResponse);
			
		}else {
			
			 Map<String,Object> ResCatBody = new HashMap<>();
			 
			 ResCatBody.put("ResjsonBody","Error in categoryCreation");
			 
			 return ResponseEntity.ok().body(ResCatBody);
			
			
		}
		 
		
		 
		
		 
	 }
	 
	 
	 @PostMapping(path = "/itemProdSubmit", produces=MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Object> ProdItemSubmit(@RequestParam("itemInfo") String prodInfo,@RequestParam("itemPicFile") MultipartFile file) throws JsonMappingException, JsonProcessingException {
		 System.out.println(prodInfo);
		 
		 if(!file.isEmpty()) {
			 
			 System.out.println("Not empty");
		 }
		 
		 ProductDataDto prodData =   mapper.readValue(prodInfo,ProductDataDto.class);
		
		 
		 Map<String,Object> RespoItemBody = new HashMap<>();
		 
		 RespoItemBody.put("RespoItemBody","Item info success response");
		 
		 
		 return ResponseEntity.ok().header("Access-Control-Allow-Origin","http://localhost:3000").body(RespoItemBody);
	 }
	 
	@PostMapping(path="/updateCategory", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> UpdateCategory(@RequestParam("itemInfo") String itemInfo) throws JsonMappingException, JsonProcessingException{
		
		 UpdateProdCatDto updateProdCatDto = mapper.readValue(itemInfo, UpdateProdCatDto.class)	;
		                       
		   Map<String,Object> ResponsejsonBody = new HashMap<>();
		   
		   ResponsejsonBody.put("updateProdCatRes","Updated successfylly");
		
	return ResponseEntity.ok().header("Access-Control-Allow-Origin","http://localhost:3000").body(ResponsejsonBody);	
		
	}
	 
	@PostMapping(path="/upItemSubmit", produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> UpdateItem(@RequestParam("itemInfo") String itemInfo,@RequestParam("itemPicFile") MultipartFile itemPicFile){
		
		
		
		Map<String,Object> ResponsejsonBody = new HashMap<>();
		
		ResponsejsonBody.put("upItemSubmitRes","Updated Item Submit");
		
	return ResponseEntity.ok().header("Access-Control-Allow-Origin","http://localhost:3000").body(ResponsejsonBody);	
	}


@GetMapping(path="/fetchAllCategory", produces =MediaType.APPLICATION_JSON_VALUE)	
 public ResponseEntity<List<Map<String,Object>>> FetchAllCategory(){
	
	 
	 List<Map<String,Object>> responseCollector = new ArrayList<>();
	  
	
	
	List<ProdCategory> AllprodCategory =   prodCategoryDao.getAllProdCat();
	
	System.out.println(AllprodCategory);
	
	ListIterator<ProdCategory> prodCatIterator = AllprodCategory.listIterator();
	
	
	while(prodCatIterator.hasNext()){
		Map<String,Object> fetchAllCatRes = new HashMap<>();
		Map<String,Object> fetchProdAllItem = new HashMap<>();
		ProdCategory prodCategory  =  prodCatIterator.next(); 		
		System.out.println(prodCategory.getProdCategory());
		fetchAllCatRes.put("productCategoryname",prodCategory.getProdCategory());
		fetchAllCatRes.put("productCategoryId",prodCategory.getProdCategoryId());
		fetchAllCatRes.put("prodCategoryKey",prodCategory.getProdCategoryKey());
		
		List<ProductInfo> productInfo1 =  prodCategory.getProductInfo();
		    
		    	 for(ProductInfo productInfo:productInfo1) {
					    System.out.println("----------#######-----------");
					    fetchProdAllItem.put("ProdTitle",productInfo.getProdTitle());
					    fetchProdAllItem.put("prodId",productInfo.getProdId());
					    fetchProdAllItem.put("prodOffer",productInfo.getOffer());
					  //  fetchProdAllItem.put("prodKey",productInfo.getProductKey());
					    fetchProdAllItem.put("prodSalePrice",productInfo.getSalePrice());
					    fetchProdAllItem.put("prodCutPrice",productInfo.getCutPrice());
					    fetchProdAllItem.put("prodQuantity",productInfo.getProdQuantity());
					    fetchProdAllItem.put("prodRate",productInfo.getRateProd());
					    fetchProdAllItem.put("prodTotalrate",productInfo.getTotalRate());
					    fetchProdAllItem.put("prodPicUrl",productInfo.getProdPicUrl()); 
					     System.out.println("---------------********------------");
					      
				
		    	 
		     } 
		    fetchAllCatRes.put("catRes",fetchProdAllItem);
		    
		    responseCollector.add(fetchAllCatRes);
		   
		}
                  	
	    HttpHeaders headers = new HttpHeaders();
                  	headers.add("Content-Type","application/json");
                //  	headers.add("Access-Control-Allow-Origin","http://localhost:3000");
  	return ResponseEntity.status(HttpStatus.OK).headers(headers).body(responseCollector);
}
	
	
	
	
	
	
	@PostMapping(path="/deleteCatSubmit", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteCategory(@RequestParam("deleteCat") String deleteCat){
		
		
		
		
	   Map<String,Object> ResponsejsonBody = new HashMap<>();
	   
	   ResponsejsonBody.put("deleteCatRes","Category deleted");
		
		return ResponseEntity.ok().header("Access-Control-Allow-Origin","http://localhost:3000").body(ResponsejsonBody);
	}
	 
	@PostMapping(path="/deleteItemSubmit", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteItem(@RequestParam("deleteItem") String deleteItem){
		
		
		 
		Map<String,Object> ResponsejsonBody = new HashMap<>();
		
		ResponsejsonBody.put("deleteItemRes","Delete Item Success");
		
		return ResponseEntity.ok().header("Access-Control-Allow-Origin","http://localhost:3000").body(ResponsejsonBody);
		
	}
	
	@GetMapping(path="/upload")
	public ResponseEntity<Map> uploadImage(@RequestParam("itemPicFile") MultipartFile itemPicFile){
		
		 Map data =  this.cloudinaryImageservice.upload(itemPicFile);
		
		 String st = "secure_url"; 
		 
		 data.forEach((k,v)->{
			 if(k.equals(st)) {
				 System.out.println(v);
			 }
			
		 });
		 
		return new ResponseEntity<>(data,HttpStatus.OK);
	}
	
	
	@PostMapping(path="/cartManager" ,consumes=MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> CartManager(@Valid @RequestBody ProdIdDto prodIdDto,@CookieValue(value = "cartId", defaultValue = "0") String cookieValue){
		
     		//Cart cart = null;
		
		    ProdIds  prodIds = new ProdIds(prodIdDto.getProdId());
		    
		    Integer cartId = Integer.valueOf(cookieValue);
		 
		 //    Cart  cart = cartDao.getCart(cartId);
		     
		    ProductInfo  productInfo  = prodInfoDao.getProdInfo(prodIds);
		    
		    Integer pk = null;
		    
		   
		  System.out.println(cookieValue)  ;
		   
		    
		  if(cartId!=0) {  
		    System.out.println("cart id is not null");
		    System.out.println("cartId------------"+cartId);
			//  cart = cartDao.getCart(cartId);
			  Date date = new Date();
	          
			  Cart  cart = cartDao.getCart(cartId);
		    	
			  System.out.println("cart obj-----"+cart);
			  
		      CartProduct cartProduct = new CartProduct();  
		    	
		    if(cartProductDao.getCartProduct(cartId,prodIdDto.getProdId())!=null){
		    	
		    	System.out.println("----cart product is not null----");
		    	
		    	
		    	
		      List<CartProduct> cartProductList = new ArrayList<>();
		      cartProduct  =  cartProductDao.getCartProduct(cartId,prodIdDto.getProdId());
		 //   cartProduct  = cartProductDao.getProduct(prodIds);
		      int prodQuantity =  cartProduct.getProductQuantity();
		      double prodPrice = cartProduct.getProductPrice();	
		      cartProduct.setProdId(prodIdDto.getProdId());
		      cartProduct.setImageUrl(cartProduct.getImageUrl());
		      cartProduct.setProductQuantity(prodQuantity+1);
		      cartProduct.setProductPrice(prodPrice);
		      cartProduct.setProductName(cartProduct.getProductName());
		      cartProduct.setCart(cart);
		      cartProductList.add(cartProduct);
		     
		      cart.setCartProduct(cartProductList);
		      cart.setCartCreation(date);
		      cart.setTotalCartValue(cart.getTotalCartValue()+productInfo.getSalePrice());
		      cartDao.updateCart(cart);
		      pk = cartId;
		      }else {
		    	  
		    	  System.out.println("----cart product is null----");
		    	  
		    	List<CartProduct> cartProductList = new ArrayList<>();  
		    	  
		    	cartProduct.setProdId(productInfo.getProdId());
		    	cartProduct.setImageUrl(productInfo.getProdPicUrl());
			    cartProduct.setProductName(productInfo.getProdTitle());
			    cartProduct.setProductPrice(productInfo.getSalePrice());
			    cartProduct.setProductQuantity(1);
			    cartProduct.setCart(cart);
			    
			    cartProductList.add(cartProduct); 
			    cart.setCartCreation(date);
		        cart.setCartProduct(cartProductList);
		        cart.setTotalCartValue(cart.getTotalCartValue()+productInfo.getSalePrice());
		        cartDao.updateCart(cart);
		        pk = cartId ;
		    }
		       }else {
		    	   
		    	   System.out.println("cart Is null");
		    	   
		    	 Cart  cart1 = new Cart();
		    	 Date date = new Date();
		    	 
		    	 CartProduct cartProduct12 = new CartProduct();
		    	 
		    	 List<CartProduct> cartProductList = new ArrayList<>(); 
		    	 
		    	 
		    	 
		    	 cartProduct12.setProdId(prodIdDto.getProdId());
		    	 cartProduct12.setImageUrl(productInfo.getProdPicUrl());
		    	 cartProduct12.setProductName(productInfo.getProdTitle());
		    	 cartProduct12.setProductPrice(productInfo.getSalePrice());
		    	 cartProduct12.setProductQuantity(1);
		    	 cartProduct12.setCart(cart1);
		    	 cartProductList.add(cartProduct12);
		    	
		    	 cart1.setCartProduct(cartProductList);
		    	 cart1.setCartCreation(date);
		    	 cart1.setCustomerBrowserId("not available");
		    	 cart1.setTotalCartValue(productInfo.getSalePrice());
		    	  pk =  cartDao.saveCart(cart1);
		    	 
		    	  }
		   
		       
		       
	          System.out.println(pk);	  
		
		    String	stHeader ="cartId="+pk.toString()+";"+"Path=/";
			
		   
		    
	    System.out.println("cookie---Value   "+cookieValue);		
		System.out.println("pppppppppppppp----"+prodIdDto.getProdId());
        
	//	Cookie cookie = new Cookie("cartId",stHeader);
		       
	//	cookie.setMaxAge(0);
		
	//	response.addCookie(cookie);
		
	    	HttpHeaders header = new HttpHeaders();
		            header.add("Set-Cookie",stHeader);
		         //   header.add("Access-Control-Allow-Origin","http://localhost:3000");
		
		 
		            
		return  ResponseEntity.status(HttpStatus.OK).headers(header).body("Item added to cart");
	}
	
	@GetMapping(path="/cartItems", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> cartFetcher(@CookieValue(value="cartId" ,defaultValue="0") String cookieValue){
		
		System.out.println("cartItems----"+cookieValue);
		
		 Integer cartId = Integer.valueOf(cookieValue);
		 
		
		
		
		
	  if(cartId!=0&&cartDao.getCart(cartId).getTotalCartValue()!=0) {
		  Cart cart = cartDao.getCart(cartId);
		System.out.println("cartItems----"+cookieValue);
		
		List<Map<String,Object>> cartDataList = new ArrayList<>();
		
	//	Integer cartId = Integer.valueOf(cookieValue);
		
	 //     Cart cart =  cartDao.getCart(cartId);
	      
	      List<CartProduct> cartItems = cart.getCartProduct();
	      
           Iterator<CartProduct> cp = cartItems.iterator();
           while(cp.hasNext()) {
        	  
        	   Map<String,Object> cartData = new HashMap<>();
        	     CartProduct cartProduct = cp.next();
        	      
        	     int quantity =  cartProduct.getProductQuantity();
        	     
        	     cartData.put("ImageUrl",cartProduct.getImageUrl());
        	     cartData.put("Price",cartProduct.getProductPrice());
        	     cartData.put("Quantity",cartProduct.getProductQuantity());
        	     cartData.put("Title",cartProduct.getProductName());
        	     cartData.put("prodId",cartProduct.getProdId());
        	     cartData.put("cart",true);
        	     
        	     cartDataList.add(cartData);
           }
           Map<String,Object> mapRes = new HashMap<>();
           
           Map<String,Object> mapRes2 = new HashMap<>();
           
           Map<String,Object> mapRes3 = new HashMap<>();
           
           if(cart.getCouponCode()!=null) {
        	   mapRes.put("isCouponCode",true); 
        	   mapRes.put("couponCode",cart.getCouponCode());
        	   mapRes.put("couponMessage","coupon code "+cart.getCouponCode()+" is applied");
           }else {
        	   
        	   mapRes.put("isCouponCode",false);
        	   mapRes.put("couponCode","null");
           }
              mapRes2.put("TotalCartValue",cart.getTotalCartValue());
           
          List<Map<String,Object>> listRes = new ArrayList<>();    
          mapRes2.put("isCouponTotalDisplay",true);
         if(cart.getTotalCartValue()!=0) {
          mapRes3.put("isCart",true);
         }else {
        	 mapRes3.put("isCart",false);
         }
          listRes.add(mapRes);
         
          List<Object> listRes2 = new ArrayList<>();
          
          listRes2.add(mapRes2);
          
		  List<Object> CartRes = new ArrayList<>();
          CartRes.add(0,listRes);
		  CartRes.add(1, cartDataList);
		  CartRes.add(2,mapRes2);
          CartRes.add(3,mapRes3); 
           
		return ResponseEntity.status(HttpStatus.OK).body(CartRes);
		
		}
		else {
			  Map<String,Object> mapRes2 = new HashMap<>();
			
			  Map<String,Object> resMap = new HashMap<>();
			  
			  Map<String,Object> mapRes3 = new HashMap<>();
			  
			 resMap.put("isCart","cart is empty");
			 resMap.put("cart",false);
			 List<Object> resList = new ArrayList<>();
			 
			 List<Object> listRes2 = new ArrayList<>();
			 List<Object> listRes1 = new ArrayList<>();
			 
			 listRes1.add(resMap);
			 
			 mapRes2.put("isCouponTotalDisplay",false);
			 if(cartId!=0) {
			 mapRes2.put("TotalCartValue",cartDao.getCart(cartId).getTotalCartValue());}
			 mapRes3.put("isCart",false);
			 listRes2.add(mapRes2);
			 
			  resList.add(0,listRes1);
			  resList.add(1,listRes1);
			  resList.add(2,mapRes2);
			  resList.add(3, mapRes3);
			return ResponseEntity.status(HttpStatus.OK).body(resList);
		}
	}

@PostMapping(path="/couponCode" ,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
 public ResponseEntity<Object> CouponCreation(@Valid @RequestBody CouponDto couponDto) throws DuplicateException{
	 
	CouponCode couponObject = new CouponCode();
	
	couponObject.setCouponCode(couponDto.getCouponCode());
	couponObject.setDiscountCode(couponDto.getCouponDiscount());
	
	couponCodeDao.SaveCouponCode(couponObject);
	
	 
	return ResponseEntity.ok().body("Coupon code Added"); 
 }	
	
@GetMapping(path="/totalCartValue",produces=MediaType.APPLICATION_JSON_VALUE)	
public ResponseEntity<Object> TotalCart(@CookieValue(value="cartId", defaultValue="0") String cookieValue){
	
	 Integer cartId = Integer.valueOf(cookieValue);
	
	 
	 if(cartId!=0) {
	  Cart cart = cartDao.getCart(cartId);
	 if(cart.getCouponCode()==null) {
	  double total =0;
	  
	  Map<String,Object> mapRes = new HashMap<>();
	  
	  List<Map<String,Object>> listResp = new ArrayList<>();
	  
	  List<CartProduct> cartProductList    =   cart.getCartProduct();
	
	  Iterator<CartProduct> cpIterator = cartProductList.iterator();
	  
	  while(cpIterator.hasNext()){
		 
		  CartProduct cartProduct = cpIterator.next();
		 int quantity= cartProduct.getProductQuantity();
		 total+=cartProduct.getProductPrice()*quantity;
		 
		 
	  }
	  
	  cart.setTotalCartValue(total);
	  
	  cartDao.updateCart(cart);
	  
	  mapRes.put("TotalValue",cart.getTotalCartValue());
	  mapRes.put("totalCartValue",true);
	  mapRes.put("CouponMessage",cart.getCouponCode());
	  listResp.add(mapRes) ;
	  
	return ResponseEntity.ok().body(listResp);}
	 else {
		 Map<String,Object> mapRes = new HashMap<>();
		  
		  List<Map<String,Object>> listResp = new ArrayList<>();
		  
		  mapRes.put("TotalValue",cart.getTotalCartValue());
		  mapRes.put("totalCartValue",true);
		  mapRes.put("CouponMessage",cart.getCouponCode());
		  listResp.add(mapRes);
		 return ResponseEntity.status(HttpStatus.OK).body(listResp);
	 }
	}
	 else {
		 Map<String,Object> mapRes = new HashMap<>();
		 
		 List<Map<String,Object>> listRes = new ArrayList<>();
		 
		 mapRes.put("totalCartValue",false);
		 
		 listRes.add(mapRes);
		 
		 return ResponseEntity.ok().body(listRes);
		 
	 }
	 
} 	

@GetMapping(path="/couponApp/{coupon}", produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Object> CouponApp(@PathVariable String coupon   ,@CookieValue(value="cartId" , defaultValue="0") String cookieValue){

	CouponCode couponCode = null;
	
	System.out.println(coupon);
	System.out.println(cookieValue);
	
 Integer cartId = Integer.valueOf(cookieValue);
	
 
    if(couponCodeDao.getCouponCode(coupon)!=null) {
    	
    	 couponCode = couponCodeDao.getCouponCode(coupon);	
    	 discountValue = couponCode.getDiscountCode();
    	
    	 System.out.println("discount value "+discountValue);
    }else{
    	
    	Map<String,String> ResMap = new HashMap<>();
    	
    	List<Map<String,String>> listRes = new ArrayList<>();
    	
    	ResMap.put("message","Invalid coupon Code");
    	
    	listRes.add(ResMap);
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listRes);
    }
 
	 
	 if(cartId!=0&&discountValue!=0.0d) {
	  Cart cart = cartDao.getCart(cartId);
	 
	  if(cart.getCouponCode()==coupon) {
		  Map<String,Object> mapRes = new HashMap<>();
		  
		  List<Map<String,Object>> listRes = new ArrayList<>();
		  
		  mapRes.put("TotalValue",cart.getTotalCartValue());
		  mapRes.put("isCoupCart",true);
		  mapRes.put("Couponcode",cart.getCouponCode());
		  mapRes.put("message","Coupon code "+cart.getCouponCode()+" applied");
		  listRes.add(mapRes);
		  
		  return ResponseEntity.status(HttpStatus.OK).body(listRes);
	  }
	  else {
	  double total =0;
	  
	  Map<String,Object> mapRes = new HashMap<>();
	  
	  List<Map<String,Object>> listResp = new ArrayList<>();
	  
	  List<CartProduct> cartProductList    =   cart.getCartProduct();
	
	  Iterator<CartProduct> cpIterator = cartProductList.iterator();
	  
	  while(cpIterator.hasNext()){
		 
		  CartProduct cartProduct = cpIterator.next();
		 int quantity= cartProduct.getProductQuantity();
		 total+=cartProduct.getProductPrice()*quantity;
		
		  }
	  
	  total1 = total - discountValue;
	  
	  cart.setCouponCode(coupon);
	  cart.setTotalCartValue(total1);
	  
	  cartDao.updateCart(cart);
	  
	  mapRes.put("TotalValue",cart.getTotalCartValue());
		
	  mapRes.put("iscoupon",true);
	  mapRes.put("message","Coupon code "+cart.getCouponCode()+" applied");
	  
	  listResp.add(mapRes) ;
	  
	return ResponseEntity.ok().body(listResp);
	} }
	 else {
		 Map<String,Object> mapRes = new HashMap<>();
		 
		 List<Map<String,Object>> listRes = new ArrayList<>();
		 
		 mapRes.put("iscoupon",false);
		 
		 listRes.add(mapRes);
		 
		 return ResponseEntity.ok().body(listRes);
		 
	 }
	
	
	
	

}

@PostMapping(path="/cartIncrement", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Object> cartIncrementor(@Valid @RequestBody ProdIdDto prodIdDto,@CookieValue(value="cartId" , defaultValue="0") String cookieValue){
	
	ProdIds  prodIds = new ProdIds(prodIdDto.getProdId());
	
	Integer cartId = Integer.valueOf(cookieValue);
	
	ProductInfo  productInfo  = prodInfoDao.getProdInfo(prodIds);
	
	if(cartId!=0&&prodIdDto.getProdId()!=null) {
    List<CartProduct> CartprodList = new ArrayList<>();		
	Cart cart =	 cartDao.getCart(cartId);
		
	CartProduct    cartProduct  =  cartProductDao.getCartProduct(cartId,prodIdDto.getProdId());
	double totalPrice =  cart.getTotalCartValue();
	int quantity = cartProduct.getProductQuantity();
	System.out.println("quantity---"+quantity);
	 double price =   productInfo.getSalePrice();
	cartProduct.setProductQuantity(quantity+1);
	CartprodList.add(cartProduct);
	cart.setCartProduct(CartprodList);
	cart.setTotalCartValue(totalPrice+price);
	
	cartDao.updateCart(cart);
	Map<String,Object> mapRes = new HashMap<>();
	//
	List<Map<String,Object>> listRes = new ArrayList<>();
	mapRes.put("quantity",cartProduct.getProductQuantity());
	mapRes.put("TotalCartValue",cart.getTotalCartValue());
	
	listRes.add(mapRes);
	return ResponseEntity.status(HttpStatus.OK).body(listRes);
	
	}else {
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad request");
	}
	
	
	
	
}

@PostMapping(path="/cartDecrementor",consumes=MediaType.APPLICATION_JSON_VALUE ,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Object> cartDecrement(@Valid @RequestBody ProdIdDto prodIdDto,@CookieValue(value="cartId" , defaultValue="0") String cookieValue){
	
    ProdIds  prodIds = new ProdIds(prodIdDto.getProdId());
	
	Integer cartId = Integer.valueOf(cookieValue);
	
	ProductInfo  productInfo  = prodInfoDao.getProdInfo(prodIds);
	
	if(cartId!=0&&cartProductDao.getCartProduct(cartId,prodIdDto.getProdId())!=null) {
		
		List<Map<String,Object>> listRes = new ArrayList<>();
		
		Cart cart =	 cartDao.getCart(cartId);
		CartProduct    cartProduct  =  cartProductDao.getCartProduct(cartId,prodIdDto.getProdId());
		double totalPrice =  cart.getTotalCartValue();
		int quantity1 = cartProduct.getProductQuantity();
		System.out.println("outer if"+quantity1);
		if(quantity1>1) {
			Map<String,Object> mapRes = new HashMap<>();
			  List<CartProduct> CartprodList = new ArrayList<>();	
			    double price =   productInfo.getSalePrice();
				cartProduct.setProductQuantity(quantity1-1);
				CartprodList.add(cartProduct);
				cart.setCartProduct(CartprodList);
				cart.setTotalCartValue(totalPrice-price);
				
				cartDao.updateCart(cart);
			mapRes.put("TotalCartValue",cart.getTotalCartValue());
			mapRes.put("quantity",cartProduct.getProductQuantity());
			listRes.add(mapRes)	;
			System.out.println("inner if "+cartProduct.getProductQuantity());
		}else {
			Map<String,Object> mapRes = new HashMap<>();
			if(quantity1==1&&cart.getTotalCartValue()!=0) {
				 double price =   productInfo.getSalePrice();
				cart.setTotalCartValue(totalPrice-price);
				cart.setCouponCode(null);
				if(cart.getTotalCartValue()<=0) {
				cart.setTotalCartValue(0); 
				}
				cartDao.updateCart(cart);
				cartProductDao.deleteCartProduct(cartProduct);
			}else {
				
				 double price =   productInfo.getSalePrice();
				//	cart.setTotalCartValue(totalPrice-price);
					cart.setCouponCode(null);
					cart.setTotalCartValue(0);
					cartDao.updateCart(cart);
					cartProductDao.deleteCartProduct(cartProduct);
				
				
			}
		mapRes.put("decreMessage","cart done");
		listRes.add(mapRes)	;
		}
	
		return ResponseEntity.status(HttpStatus.OK).body(listRes);
		
	}else {
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad request");
	}

	
	
}

@PostMapping(path="/cartArticulator", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Object> cartArticulator(@CookieValue(value="cartId", defaultValue="0") String cookieValue){
	
	
	
	
	return null;
}
@GetMapping(path="/cartProdList/{cartId}" , produces= MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<FeignCartResponse> cartProdList(@PathVariable("cartId") int cookieValue){
	
	List<Object> listResponse = new ArrayList<>();
	
	Integer cartId = Integer.valueOf(cookieValue);
	
	System.out.println(cartId);
	
	    List<CartProduct> cartProdList =  cartProductDao.getCartProductList(cartId);
	   
	     Cart cart = cartDao.getCart(cookieValue);
	
	   double totalCartValue = cart.getTotalCartValue();
	   String couponCode = cart.getCouponCode();
	   
	   feignCartResponse.setCartProduct(cartProdList);
	   feignCartResponse.setTotalCartValue(totalCartValue);
	   feignCartResponse.setCouponCode(couponCode);
	   if(couponCode!= null){
		   feignCartResponse.setCoupon(true);
	   
		   CouponCode couponObj = couponCodeDao.getCouponCode(couponCode);
		    
		   double couponValue = couponObj.getDiscountCode();
		   feignCartResponse.setCouponValue(couponValue);
		   
	   }
	   else {
		   feignCartResponse.setCoupon(false);
		   feignCartResponse.setCouponValue(0);
	   }
	   System.out.println("ecommercePort123-------"+environment.getProperty("server.port"));
	   
	   
	   
	  return ResponseEntity.ok(feignCartResponse);
}

@GetMapping(path="/cartDelete/{cartId}",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Map<String,String>> DeleteFeign(@PathVariable int cartId) {
	
   cartDao.deleteCart(cartId);	
	
   Map<String,String> deleteRes = new HashMap<>();
   
   deleteRes.put("deleteResponse","cart deleted success");
   
   String cartID = String.valueOf(cartId);
   
   System.out.println(cartID);
   
   Instant instant = Instant.now();
   
   String	stHeader ="cartId="+cartID+";"+"expires="+instant+";"+"Path=/";
   
   HttpHeaders header= new HttpHeaders();
               header.add("Set-Cookie",stHeader);
   
   return  ResponseEntity.status(HttpStatus.OK).headers(header).body(deleteRes);
	
}


}
