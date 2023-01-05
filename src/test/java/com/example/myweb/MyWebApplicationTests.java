package com.example.myweb;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.MOCK,
		classes = MyWebApplication.class)
public class MyWebApplicationTests {

	@Autowired
	private ContactRequestService requestService;
	private final List<ContactRequest> requestList = new ArrayList<>();

	@Before
	public void setUp(){
		requestList.add(new ContactRequest(123456, "Compliant", "Ilon", "Musk", "Starlink is nothing working. Do something!"));
		requestList.add(new ContactRequest(654321, "Damage Case", "Johann", "Bach", "Fortepiano is broken. Please repair it."));
	}

	@Test
	public void testSaveRequest() {
		requestList.forEach(request -> requestService.save(request));
		ContactRequest requestFromDB = (ContactRequest) requestService.getAllContactRequests().get(0);

		Assert.assertNotNull(requestFromDB);
		Assert.assertEquals("Name is not correct", "Ilon", requestFromDB.getName());
	}

	@Test
	public void testDeleteAll() {
		requestList.forEach(request -> requestService.save(request));
		List<ContactRequest> requestList = requestService.getAllContactRequests();
		Assert.assertFalse(requestList.isEmpty());

		requestService.deleteAll();

		Assert.assertTrue(requestService.getAllContactRequests().isEmpty());
	}
}
