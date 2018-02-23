package com.digid.bfsi.trainings.virtualbank.billpay.controller;

import com.digid.bfsi.trainings.virtualbank.billpay.domain.Bill;
import com.digid.bfsi.trainings.virtualbank.billpay.service.BillPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/virtualbank/billpay/bill")
@Api(tags = { "Virtual Bank" })
@SwaggerDefinition(tags = { @Tag(name = "Virtual Bank", description = "API exposing the bill pay resource") })
public class BillPayController {

	@Autowired
	BillPayService billPayService;

    @ApiOperation(value = "Pay bill for vendor", response = String.class, httpMethod = "POST")
    @RequestMapping(value = "/vendor/{vendorId}", method = RequestMethod.POST)
    public ResponseEntity<?> createBill(@PathVariable Long vendorId, @RequestBody Bill bill) {
        final Bill savedBill = billPayService.createBill(vendorId, bill);
        System.err.println(" saved " + savedBill);
        return new ResponseEntity<>(savedBill, HttpStatus.OK);
    }

    @ApiOperation(value = "Get bill by billId", response = Bill.class, httpMethod = "GET")
	@RequestMapping(method = RequestMethod.GET, value = "/{billId}")
	ResponseEntity<?> getBill(@PathVariable Long billId) {
		final Bill bill = billPayService.findByBillId(billId);
		return new ResponseEntity<>(bill, HttpStatus.OK);
	}

    @ApiOperation(value = "Delete bill by billId", response = String.class, httpMethod = "GET")
    @RequestMapping(method = RequestMethod.GET, value = "delete/{billId}")
    ResponseEntity<?> deleteBill(@PathVariable Long billId) {
        billPayService.deleteByBillId(billId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
