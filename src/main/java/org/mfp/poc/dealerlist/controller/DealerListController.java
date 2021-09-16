/**
 * 
 */
package org.mfp.poc.dealerlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.mfp.poc.dealerlist.model.Dealer;

import java.util.List;
import org.mfp.poc.dealerlist.bean.ApiErrorBean;
import org.mfp.poc.dealerlist.bean.DealerListResponse;
import org.mfp.poc.dealerlist.service.DealerListService;
import org.mfp.poc.dealerlist.util.ApplicationConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sangeeta
 *
 */

//@CrossOrigin("*")
@Api(value = "Dealer List Controller", description = "Fetch all Dealer List.")
@RestController
@RequestMapping(value = "/mfp/sales/")
public class DealerListController {
	
	private static final Logger log =LoggerFactory.getLogger(DealerListController.class);
     
 	@Autowired
	DealerListService dealerListService;

	@ApiOperation(value = "Get all Dealer List." , response = DealerListResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200 , message = "Successfully retrived Dealer List Data."),
			@ApiResponse(code = 404 , message = "Dealer List Data not found.")
	})
	@RequestMapping(value = "dealer-list", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<?> getAllDealerList(@RequestParam(name = "region", required = false) String region,
			@RequestParam(name = "zone", required = false) String zone,
			@RequestParam(name = "district", required = false) String district,
			@RequestParam(name = "dealer_name", required = false) String dealer_name,
			@RequestParam(name = "sortBy", required = false) List<String> sortBy) {
		 
	    if (log.isDebugEnabled()) {
	            log.debug("BEGIN :----> DealerListController.getAllDealerList()");
	    }
		try {
			System.out.println("dealer-list calling");
			DealerListResponse dealerListResponse = dealerListService.getAllDealerList(region, zone, district, dealer_name, sortBy);

			ResponseEntity<DealerListResponse> responseEntity = new ResponseEntity<DealerListResponse>(
					dealerListResponse, HttpStatus.OK);

			return responseEntity;
		} catch (Exception e) {
			log.error(ApplicationConstant.ERROR_MESSAGE + e);
			ApiErrorBean apiError = new ApiErrorBean(HttpStatus.NOT_FOUND, ApplicationConstant.ERROR_MESSAGE);
			return new ResponseEntity<ApiErrorBean>(apiError, apiError.getStatus());

		}
	}

	
	
	@PostMapping(value = "add")
	public ResponseEntity<Dealer> addDealer(@RequestBody Dealer request) {
		Dealer addDealer = dealerListService.addDealer(request);
		return ResponseEntity.ok().body(addDealer);

	}

}
