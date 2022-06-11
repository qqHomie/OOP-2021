package week7;
import java.math.BigDecimal;

public class GoldenAccount extends BankAccount {

	public GoldenAccount(String number, String status, Client owner, BigDecimal balance) {
		super(number, status, owner, balance);
	}
	@Override
	public void debit(BigDecimal amount) {
		BigDecimal newBalance = balance.subtract(amount);

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
        	throw new IllegalStateException("Not enough cash");
        }

        newBalance = newBalance.add(new BigDecimal("100.00"));

        balance = newBalance;

        operations[opIndex] = "Debit " + amount.toString();
		opIndex++;
	}
	@Override
	public void paymentForService() {
		BigDecimal newBalance = balance.subtract(new BigDecimal("3000.00"));
        balance = newBalance;
	}
	@Override
	protected String balanceBuilder() {
		return "@@@@Your golden account balance is " + balance.toString() + "@@@@@";
	}


}