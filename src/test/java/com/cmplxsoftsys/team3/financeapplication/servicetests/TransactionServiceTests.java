package com.cmplxsoftsys.team3.financeapplication.servicetests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cmplxsoftsys.team3.financeapplication.model.Loan;
import com.cmplxsoftsys.team3.financeapplication.model.Transaction;
import com.cmplxsoftsys.team3.financeapplication.model.Loan.STATUS;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanApplicationRequest;
import com.cmplxsoftsys.team3.financeapplication.payload.request.LoanDecisionRequest;
import com.cmplxsoftsys.team3.financeapplication.payload.request.MakeTransactionRequest;
import com.cmplxsoftsys.team3.financeapplication.repository.LoanRepository;
import com.cmplxsoftsys.team3.financeapplication.repository.TransactionRepository;
import com.cmplxsoftsys.team3.financeapplication.service.LoanServiceImpl;
import com.cmplxsoftsys.team3.financeapplication.service.TransactionServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TransactionServiceTests {
    
    @Autowired
    TransactionServiceImpl service;

    @MockBean
    TransactionRepository repository;


    @Test
    public void contextLoads() throws Exception {
        assertThat(service).isNotNull();
        assertThat(repository).isNotNull();
    }


    @Test
    public void transactionServiceLogic_canSuccessfullyMakePayment() throws Exception {
        Transaction transaction = new Transaction("testuserid", 123.50);

        MakeTransactionRequest request = Mockito.mock(MakeTransactionRequest.class);
        Mockito.when(request.getUserId()).thenReturn(transaction.getUserId());
        Mockito.when(request.getValue()).thenReturn(transaction.getValue());

        // submit valid request which should be received and saved here
        service.makePayment(request);

        // verify that save was called once (e.g. it would have been a write)
        Mockito.verify(repository).save(Mockito.any());
    }


    @Test
    public void transactionServiceLogic_getPaymentsByUserReturnsList() throws Exception {
        ArrayList<Transaction> transactionTestList = new ArrayList<>();
        String testid = "testuser";

        Transaction t1 = new Transaction(testid, 123.50);
        Transaction t2 = new Transaction(testid, 250);
        Transaction t3 = new Transaction(testid, 165651.76);
        transactionTestList.add(t1);
        transactionTestList.add(t2);
        transactionTestList.add(t3);

        Mockito.when(repository.findByUserId(testid)).thenReturn(Optional.of(transactionTestList));

        List<Transaction> returned = service.viewPaymentsByUser(testid);
        assertThat(returned).isSameAs(transactionTestList);
    }


    @Test
    public void transactionServiceLogic_getPaymentsByNonexistantUserReturnsNull() throws Exception {
        String testid = "nonexistant";

        Mockito.when(repository.findByUserId(testid)).thenReturn(Optional.empty());

        List<Transaction> returned = service.viewPaymentsByUser("nonexistant");
        assertThat(returned).isNull();
    }


    @Test
    public void transactionServiceLogic_canViewAllTransactions() {
        ArrayList<Transaction> transactionTestList = new ArrayList<>();
        transactionTestList.add(new Transaction("testuid1", 123));
        transactionTestList.add(new Transaction("testuid2", 456));
        transactionTestList.add(new Transaction("testuid3", 789));

        Mockito.when(repository.findAll()).thenReturn(transactionTestList);

        List<Transaction> results = service.viewAllTransactions();

        assertThat(results).hasSize(transactionTestList.size());
    }
}
