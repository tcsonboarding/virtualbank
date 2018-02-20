package springboot.bill.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.bill.pay.dto.BillPayRequest;
import springboot.bill.pay.dto.BillPayVendor;
import springboot.bill.pay.service.BillPayService;
import springboot.bill.pay.vo.ResponseVO;

@RestController
@RequestMapping("/account/{accountId}")
public class BillPayController {

    @Autowired
    private BillPayService billPayService;

    /**
     *
     * @param accountId
     * @param billPayVendor
     * @return
     */

    @RequestMapping(value = "/vendors", method = RequestMethod.POST)
    public ResponseEntity<String> registerVendor(@PathVariable String accountId,
                                                      @RequestBody BillPayVendor billPayVendor) {
        final BillPayVendor savedBillPayVendor = billPayService.registerVendor(billPayVendor);
        System.err.println(" saved " + savedBillPayVendor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     *
     * @param accountId
     * @param vendorId
     * @param billPayRequest
     * @return
     */
    @RequestMapping(value = "bills/vendor/{vendorId}", method = RequestMethod.POST)
    public ResponseEntity<String> createBillPay(@PathVariable Long accountId,
                                                @PathVariable Long vendorId,
                                                @RequestBody BillPayRequest billPayRequest) {
        return null; //billPayVendorRepository.createBillPay(billPayRequest);
    }

    /**
     *
     * @param accountId
     * @param vendorId
     * @return BillPayVendor for given vendorId and accountId
     */

    @RequestMapping(value = "bills/vendor/{vendorId}", method = RequestMethod.GET)
    public ResponseEntity<ResponseVO<BillPayVendor>> findBillPay(@PathVariable Long accountId,
                                                                 @PathVariable Long vendorId) {
        return ResponseEntity.ok(new ResponseVO<>(billPayService.findBillPay(vendorId)));
    }
}
