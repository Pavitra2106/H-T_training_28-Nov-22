package com.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hr.entity.HR;

@Service
public class HrServiceImpl  implements IhrService{

	List<HR> listHr = List.of(
			new HR(101L,"Pavita","987543322"),
			new HR(102L,"rohan","3465891351"),
			new HR(103L,"aakash","097387264"),
			new HR(104L,"prateek","34366418391"),
			new HR(105L,"anish","2399438738"));
	
	@Override
	public HR getHr(Long id) {
		// TODO Auto-generated method stub
		return listHr.stream().filter(hr -> hr.getUserId().equals(id)).findAny().orElse(null);
	}

}
