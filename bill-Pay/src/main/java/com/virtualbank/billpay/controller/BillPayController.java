package com.virtualbank.billpay.controller;

import com.virtualbank.billpay.domain.Bill;
import com.virtualbank.billpay.service.BillPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/virtualbank/billpay/bill")
@Api(tags = { "Virtual Bank bill pay" })
@SwaggerDefinition(tags = { @Tag(name = "Virtual Bank", description = "API exposing the bill pay resource") })
public class BillPayController {

	@Autowired
	BillPayService billPayService;

    @ApiOperation(value = "Pay bill for vendor", response = String.class, httpMethod = "POST")
    @PostMapping(value = "/vendor/{vendorId}")
    public ResponseEntity<?> createBill(@PathVariable Long vendorId, @RequestBody Bill bill) {
        final Bill savedBill = billPayService.createBill(vendorId, bill);
        System.err.println(" saved " + savedBill);
        return new ResponseEntity<>(savedBill, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Pay bills for vendor", response = String.class, httpMethod = "POST")
    @PostMapping(value = "/vendor/{vendorId}/bills")
    public ResponseEntity<?> createBills(@PathVariable Long vendorId, @RequestBody List<Bill> bills) {
        final List<Bill> savedBills = billPayService.createBills(vendorId, bills);
        System.err.println(" saved " + savedBills);
        return new ResponseEntity<>(savedBills, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Search a billPay with an ID", response = Bill.class, httpMethod = "GET")
	@GetMapping(value = "/{billId}")
	ResponseEntity<?> getBill(@PathVariable Long billId) {
		final Bill bill = billPayService.findByBillId(billId);
		return new ResponseEntity<>(bill, HttpStatus.OK);
	}

    @ApiOperation(value = "Delete bill by billId", response = String.class, httpMethod = "DELETE")
    @DeleteMapping(value = "delete/{billId}")
    public void deleteBill(@PathVariable Long billId) {
        billPayService.deleteByBillId(billId);
    }
}
