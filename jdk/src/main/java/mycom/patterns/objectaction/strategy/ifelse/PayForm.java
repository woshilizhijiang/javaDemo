package mycom.patterns.objectaction.strategy.ifelse;

import java.math.BigDecimal;

/**
 * Created by 20013649 on 2020/6/29.
 */
public class PayForm {
    private String payWay;

    private BigDecimal payAmount;

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }
}
