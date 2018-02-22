package com.digid.bfsi.trainings.virtualbank.creditScore.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.digid.bfsi.trainings.virtualbank.creditScore.domain.CreditEvent;
import com.digid.bfsi.trainings.virtualbank.creditScore.domain.ExternalizedEnums;
import com.digid.bfsi.trainings.virtualbank.creditScore.repository.CreditEventRepository;

@RunWith(SpringRunner.class)
public class CreditScoreServiceTest {

	private ArrayList<CreditEvent> eventList;

	@TestConfiguration
	static class OrderServiceTestContextConfiguration {
		@Bean
		public CreditScoreService orderService() {
			return new CreditScoreService();
		}
	}

	@Autowired
	private CreditScoreService creditService;

	@MockBean
	private CreditEventRepository repository;

	@Before
	public void setup() {
		eventList = initializeRepositoryRecords();

		Mockito.when(repository.findBySsn(Mockito.anyString())).thenReturn(new ArrayList<CreditEvent>());

		Mockito.when(repository.findBySsn("123-45-6789")).thenReturn(
				eventList.stream().filter(e -> e.getSsn().equals("123-45-6789")).collect(Collectors.toList()));
		Mockito.when(repository.findBySsn("123-45-5555")).thenReturn(
				eventList.stream().filter(e -> e.getSsn().equals("123-45-5555")).collect(Collectors.toList()));
		Mockito.when(repository.findBySsn("123-45-7777")).thenReturn(
				eventList.stream().filter(e -> e.getSsn().equals("123-45-7777")).collect(Collectors.toList()));
		Mockito.when(repository.findBySsn("234-25-6234")).thenReturn(
				eventList.stream().filter(e -> e.getSsn().equals("234-25-6234")).collect(Collectors.toList()));
		Mockito.when(repository.findBySsn("967-93-7383")).thenReturn(
				eventList.stream().filter(e -> e.getSsn().equals("967-93-7383")).collect(Collectors.toList()));
		Mockito.when(repository.findBySsn("045-35-2134")).thenReturn(
				eventList.stream().filter(e -> e.getSsn().equals("045-35-2134")).collect(Collectors.toList()));
		Mockito.when(repository.findBySsn("273-23-4344")).thenReturn(
				eventList.stream().filter(e -> e.getSsn().equals("273-23-4344")).collect(Collectors.toList()));

		Mockito.doAnswer(new Answer<CreditEvent>() {
			@Override
			public CreditEvent answer(InvocationOnMock invocation) throws Throwable {
				CreditEvent event = (CreditEvent) invocation.getArguments()[0];
				eventList.add(event);
				return event;
			}
		}).when(repository).save(any(CreditEvent.class));


	}

	private ArrayList<CreditEvent> initializeRepositoryRecords() {
		ArrayList<CreditEvent> eventList = new ArrayList<CreditEvent>();
		eventList.add(new CreditEvent(1l, "123-45-6789", ExternalizedEnums.EventType.MIN_BALANCE_PAID, 10));
		eventList.add(new CreditEvent(2l, "123-45-6789", ExternalizedEnums.EventType.MIN_BALANCE_PAID, 10));
		eventList.add(new CreditEvent(3l, "123-45-6789", ExternalizedEnums.EventType.MIN_BALANCE_PAID, 10));
		eventList.add(new CreditEvent(4l, "123-45-6789", ExternalizedEnums.EventType.OUTSTANDING_BALANCE_PAID, 50));
		eventList.add(new CreditEvent(5l, "123-45-6789", ExternalizedEnums.EventType.OUTSTANDING_BALANCE_PAID, 50));
		eventList.add(new CreditEvent(6l, "123-45-6789", ExternalizedEnums.EventType.PAYMENT_DEFAULT, -40));
		eventList.add(new CreditEvent(7l, "123-45-6789", ExternalizedEnums.EventType.PAYMENT_DEFAULT, -40));
		eventList.add(new CreditEvent(8l, "123-45-6789", ExternalizedEnums.EventType.MIN_BALANCE_PAID, 10));

		eventList.add(new CreditEvent(9l, "123-45-5555", ExternalizedEnums.EventType.OUTSTANDING_BALANCE_PAID, 50));
		eventList.add(new CreditEvent(10l, "123-45-5555", ExternalizedEnums.EventType.MIN_BALANCE_PAID, 10));
		eventList.add(new CreditEvent(11l, "123-45-5555", ExternalizedEnums.EventType.MIN_BALANCE_PAID, 10));
		eventList.add(new CreditEvent(12l, "123-45-5555", ExternalizedEnums.EventType.MIN_BALANCE_PAID, 10));

		eventList.add(new CreditEvent(13l, "123-45-7777", ExternalizedEnums.EventType.MIN_BALANCE_PAID, 20));
		eventList.add(new CreditEvent(14l, "123-45-7777", ExternalizedEnums.EventType.PAYMENT_DEFAULT, -50));
		eventList.add(new CreditEvent(15l, "123-45-7777", ExternalizedEnums.EventType.PAYMENT_DEFAULT, -50));

		eventList.add(new CreditEvent(16l, "234-25-6234", ExternalizedEnums.EventType.PAYMENT_DEFAULT, -100));

		eventList.add(new CreditEvent(17l, "967-93-7383", ExternalizedEnums.EventType.MIN_BALANCE_PAID, 20));
		eventList.add(new CreditEvent(18l, "967-93-7383", ExternalizedEnums.EventType.MIN_BALANCE_PAID, 20));

		eventList.add(new CreditEvent(19l, "045-35-2134", ExternalizedEnums.EventType.PAYMENT_DEFAULT, -50));

		eventList.add(new CreditEvent(20l, "273-23-4344", ExternalizedEnums.EventType.OUTSTANDING_BALANCE_PAID, 40));
		return eventList;
	}

	@Test
	public void getScore_ReturnsZero_IfSsnNotFound() {
		int score = creditService.getScore("999-99-9999");
		assertThat(score, equalTo(0));
	}

	@Test
	public void getScore_ReturnsCorrectCalculatedSums() {
		assertThat(creditService.getScore("123-45-6789"), equalTo(60));
		assertThat(creditService.getScore("123-45-5555"), equalTo(80));
		assertThat(creditService.getScore("123-45-7777"), equalTo(-80));
		assertThat(creditService.getScore("234-25-6234"), equalTo(-100));
		assertThat(creditService.getScore("967-93-7383"), equalTo(40));
		assertThat(creditService.getScore("045-35-2134"), equalTo(-50));
		assertThat(creditService.getScore("273-23-4344"), equalTo(40));

	}

	@Test
	public void addCreditEvent_ProperlyInsertsRecordForNonExistingSSN() {
		String ssn = "111-11-1111";
		CreditEvent event = new CreditEvent(50L, ssn, ExternalizedEnums.EventType.OUTSTANDING_BALANCE_PAID, 40);
		assertThat(creditService.getScore(ssn), equalTo(0));
		creditService.addCreditEvent(event);
		assertThat(creditService.getScore(ssn), equalTo(40));

	}

	@Test
	public void addCreditEvent_ProperlyInsertsRecordForExistingSSN() {
		String ssn = "123-45-6789";
		assertThat(creditService.getScore(ssn), equalTo(60));
		creditService
				.addCreditEvent(new CreditEvent(50L, ssn, ExternalizedEnums.EventType.OUTSTANDING_BALANCE_PAID, 40));
		assertThat(creditService.getScore(ssn), equalTo(100));
	}

}
