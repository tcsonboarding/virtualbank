package com.virtualbank.billpay.controller;

import com.virtualbank.billpay.domain.Bill;
import com.virtualbank.billpay.domain.Vendor;
import com.virtualbank.billpay.service.VendorService;
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
@RequestMapping("/virtualbank/billpay/vendor")
@Api(tags = { "Virtual Bank Vendor" })
@SwaggerDefinition(tags = { @Tag(name = "Virtual Bank", description = "API exposing the Vendor resource") })
public class VendorController {

	@Autowired
	VendorService vendorService;

    @ApiOperation(value = "Register vendor", response = String.class, httpMethod = "POST")
    @PostMapping(value = "/vendors")
	public ResponseEntity<?> registerVendor(@RequestBody Vendor vendor) {
		vendorService.registerVendor(vendor);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

    @ApiOperation(value = "Get vendor by vendorId", response = Vendor.class, httpMethod = "GET")
    @GetMapping(value = "/{vendorId}")
	ResponseEntity<?> getVendor(@PathVariable Long vendorId) {
		Vendor vendor = vendorService.findByVendorId(vendorId);
		return new ResponseEntity<>(vendor, HttpStatus.OK);
	}

    @ApiOperation(value = "Get list of vendors", response = Vendor.class, httpMethod = "GET")
    @GetMapping(value = "/vendors")
    ResponseEntity<?> getVendors() {
        List<Vendor> vendors = vendorService.findVendors();

        return new ResponseEntity<>(vendors, HttpStatus.OK);
    }

    @ApiOperation(value = "Get bills by vendorId", response = Bill.class, httpMethod = "GET")
    @GetMapping(value = "/bills/{vendorId}")
    ResponseEntity<?> getBills(@PathVariable Long vendorId) {
        List<Bill> bills = vendorService.findBills(vendorId);

        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete vendor by vendorId all customers", response = String.class, httpMethod = "DELETE")
    @DeleteMapping(value = "/delete/{vendorId}")
    public ResponseEntity<?> deleteVendor(@PathVariable Long vendorId) {
        vendorService.deleteVendor(vendorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
