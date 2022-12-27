package com.resource.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.resource.entity.Resource;

@Service
public class ResourceServiceImpl  implements IResourceService{

	List<Resource> listResource = List.of(
			new Resource(1L,"Rahul@gmail.com","Rahul","Software Dev",101L),
			new Resource(2L,"amit@gmail.com","amit","JS Dev",101L),
			new Resource(3L,"kunal@gmail.com","kunal","React Dev",102L),
			new Resource(4L,"amul@gmail.com","amul"," Tester",102L),
			new Resource(5L,"tarun@gmail.com","tarun","Software Dev",103L));
	
	
	@Override
	public List<Resource> getResourceForUsers(Long userID) {
		// TODO Auto-generated method stub
		 return listResource.stream().filter(resource -> resource.getUserID().
				 equals(userID)).collect(Collectors.toList());
		 
	}

}
