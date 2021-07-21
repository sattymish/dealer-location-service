package com.mazdausa.mfp.dealerlocationservice.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mazdausa.mfp.dealerlocationservice.dao.DealerLocationDao;
import com.mazdausa.mfp.dealerlocationservice.entity.DealerEntity;
import com.mazdausa.mfp.dealerlocationservice.entity.LocationEntity;
import com.mazdausa.mfp.dealerlocationservice.vo.DealerResponseVO;
import com.mazdausa.mfp.dealerlocationservice.vo.DealerVO;
import com.mazdausa.mfp.dealerlocationservice.vo.LocationVO;

@Controller
public class DealerLocationDataResource {

	@Autowired
	private DealerLocationDao dealerLocationDao;
	
	@Autowired
	Environment environment; 
	
	@GetMapping("/dealerLocation")
	public ResponseEntity<DealerResponseVO> getDealerLocationData(){
		
		try {
			List<DealerEntity> dealerList = dealerLocationDao.findAll();
			List<DealerVO> responseList = new ArrayList<DealerVO>(dealerList.size());
			for( DealerEntity dealer: dealerList ) {
				DealerVO dealerVO =  new DealerVO();
				dealerVO.setDealerCode(dealer.getDealerCode());
				dealerVO.setDealerName(dealer.getDealerName());
				dealerVO.setLocation(null);
				dealerVO.setStatus(dealer.getStatus());
				LocationEntity locationEn = dealer.getLocation();
				LocationVO locationVO = new LocationVO();
				locationVO.setDistrictCode(locationEn.getDistrictCode());
				locationVO.setRegionCode(locationEn.getRegionCode());
				dealerVO.setLocation(locationVO);
				responseList.add(dealerVO);
			}
			DealerResponseVO dealerResponseVO = new DealerResponseVO();
			dealerResponseVO.setDealers(responseList);
			dealerResponseVO.setEnvironment(environment.getProperty("local.server.port"));
			return new ResponseEntity<> (dealerResponseVO,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
