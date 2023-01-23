package com.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.user.entity.Role;
import com.user.entity.User;
import com.user.model.ERoles;
import com.user.repo.IUserRepo;
import com.user.service.IUserService;

@SpringBootTest
class UserServiceApplicationTests {
	
	@Autowired
	private IUserService iUserService;
	
	@MockBean
	private IUserRepo iUserRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void signupTest() {
		User userobj = new User();
		userobj.setId(1L);
		userobj.setFirstname("rahul");
		userobj.setLastname("kumar");
		userobj.setEmail("rahul@gmail.com");
		userobj.setUsername("rahul");
		userobj.setPassword("rahul@123");
		when(this.iUserRepo.save(userobj)).thenReturn(userobj);
		assertEquals(userobj,iUserService.signup(userobj));
	}
	
	
	@Test
	public void getAllUserTest() {
		User userobj = new User();
		userobj.setId(1L);
		userobj.setFirstname("rahul");
		userobj.setLastname("kumar");
		userobj.setEmail("rahul@gmail.com");
		userobj.setUsername("rahul");
		userobj.setPassword("rahul@123");
		
		User userobj1 = new User();
		userobj1.setId(1L);
		userobj1.setFirstname("Pavitra");
		userobj1.setLastname("kumar");
		userobj1.setEmail("Pavitra@gmail.com");
		userobj1.setUsername("Pavitra");
		userobj1.setPassword("Pavitra@123");
		List<User> listofusers = List.of(userobj,userobj1);
		when(this.iUserRepo.findAll()).thenReturn(listofusers);
		assertEquals(2,iUserService.getAllUsers().size());
	}
	
	@Test
	public void getUserByNameTest() {
		User userobj = new User();
		userobj.setId(1L);
		userobj.setFirstname("rahul");
		userobj.setLastname("kumar");
		userobj.setEmail("rahul@gmail.com");
		userobj.setUsername("rahul");
		userobj.setPassword("rahul@123");
		String user = "rahul";
		when(this.iUserRepo.findByUsername(user)).thenReturn(userobj);
		assertEquals(userobj,iUserRepo.findByUsername(user));
	}

	@Test
	public void deleteTest() {
		Long id =1L;
		iUserService.deleteUserDetail(id);
		verify(iUserRepo,times(1)).deleteById(id);
	}
	
	@Test
	public void updateUserDetailTest() {
		User userobj = new User();
		userobj.setId(1L);
		userobj.setFirstname("rahul");
		userobj.setLastname("kumar");
		userobj.setEmail("rahul@gmail.com");
		userobj.setUsername("rahul");
		userobj.setPassword("rahul@123");
		when(this.iUserRepo.findById(1L)).thenReturn(Optional.of(userobj));
		assertEquals(1L, userobj.getId());
		when(this.iUserRepo.save(userobj)).thenReturn(userobj);
		assertEquals(userobj, iUserService.updateUserDetail(userobj, userobj.getId()));	
	}

	@Test
	public void updateUserRole() {
		User userobj = new User();
		userobj.setId(1L);
		userobj.setFirstname("rahul");
		userobj.setLastname("kumar");
		userobj.setEmail("rahul@gmail.com");
		userobj.setUsername("rahul");
		userobj.setPassword("rahul@123");
		when(this.iUserRepo.findById(1L)).thenReturn(Optional.of(userobj));
		assertEquals(1L, userobj.getId());
		when(this.iUserRepo.save(userobj)).thenReturn(userobj);
		assertEquals(userobj, iUserService.updateUserRole("user", userobj.getId()));	
	}
}	