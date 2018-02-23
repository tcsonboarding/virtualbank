package com.digid.bfsi.trainings.virtualbank.billpay.exception;

public class VendorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 533121715662663882L;

    public VendorNotFoundException(Long vendorId) {
        super("could not find vendor for vendorId : '" + vendorId + "'.");
    }

}