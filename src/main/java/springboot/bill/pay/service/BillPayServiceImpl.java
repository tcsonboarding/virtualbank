package springboot.bill.pay.service;

import org.springframework.beans.factory.annotation.Autowired;
import springboot.bill.pay.dto.BillPayRequest;
import springboot.bill.pay.dto.BillPayVendor;
import org.springframework.stereotype.Service;
import springboot.bill.pay.repository.BillPayVendorRepository;

@Service
public class BillPayServiceImpl implements BillPayService {

    @Autowired
    private BillPayVendorRepository billPayVendorRepository;

    @Override
    public BillPayVendor registerVendor(BillPayVendor billPayVendor) {
        return billPayVendorRepository.save(billPayVendor);
    }

    @Override
    public BillPayVendor findBillPay(Long vendorId) {
        return billPayVendorRepository.findOne(vendorId);
    }

}
