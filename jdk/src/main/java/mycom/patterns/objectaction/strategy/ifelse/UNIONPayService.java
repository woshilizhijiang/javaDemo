package mycom.patterns.objectaction.strategy.ifelse;

/**
 * Created by 20013649 on 2020/6/29.
 */
public class UNIONPayService implements PayService{
    @Override
    public String pay(PayForm payForm) {
        return payForm.getPayWay()+ "220";
    }
}