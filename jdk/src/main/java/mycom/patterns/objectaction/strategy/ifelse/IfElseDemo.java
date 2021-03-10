package mycom.patterns.objectaction.strategy.ifelse;

/**
 * Created by 20013649 on 2020/6/29.
 */
public class IfElseDemo {
    public static void main(String[] args){
        PayForm payForm = new PayForm();
        payForm.setPayWay("ALIPAY");

        if (payForm.getPayWay().equals("ALIPAY")) {
            // 业务
            PayService payService = new AliPayService();
            String pay = payService.pay(payForm);
            System.out.println(pay);
        } else if (payForm.getPayWay().equals("WX")) {
            // 业务
            PayService payService = new WXPayService();
            String pay = payService.pay(payForm);
            System.out.println(pay);
        } else if (payForm.getPayWay().equals("UNION")) {
            // 业务
            PayService payService = new UNIONPayService();
            String pay = payService.pay(payForm);
            System.out.println(pay);
        } else {
            throw new RuntimeException("不支持该种支付方式");
        }
    }
}
