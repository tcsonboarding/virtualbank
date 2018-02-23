package springboot.bill.pay.service;

import org.springframework.stereotype.Service;
import springboot.bill.pay.dto.BillPayRequest;
import springboot.bill.pay.dto.BillPayVendor;

@Service
public interface BillPayService {

    BillPayVendor registerVendor(BillPayVendor billPayVendor);

    BillPayVendor findBillPay(Long vendorId);

}
