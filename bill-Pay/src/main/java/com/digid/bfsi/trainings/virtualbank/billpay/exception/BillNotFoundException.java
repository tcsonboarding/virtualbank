package com.digid.bfsi.trainings.virtualbank.billpay.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class BillNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 533121715662663882L;

    public BillNotFoundException(Long billId) {
        super("could not find bill for billId : '" + billId + "'.");
    }

}