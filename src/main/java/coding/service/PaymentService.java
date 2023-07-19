package coding.service;

import com.braintreegateway.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PaymentService {

	private static BraintreeGateway gateway = new BraintreeGateway(Environment.SANDBOX,
			System.getenv("BRAINTREE_MERCHANT_ID"), System.getenv("BRAINTREE_PUBLIC_KEY"),
			System.getenv("BRAINTREE_PRIVATE_KEY"));

	/*
	 * export BRAINTREE_MERCHANT_ID="your-merchant-id" export
	 * BRAINTREE_PUBLIC_KEY="your-public-key" export
	 * BRAINTREE_PRIVATE_KEY="your-private-key" In your IDE: If you're using an
	 * Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse to run
	 * your application, you can usually set environment variables in the run
	 * configuration settings. In IntelliJ, for example, you would go to Run -> Edit
	 * Configurations, then under the "Configuration" tab, there's an
	 * "Environment variables" field where you can add your variables.
	 */
	// Merchant ID: vjs2rngd6srn866g
	// Public Key: 8ff39p268fzrxxr9
	// Private Key: b43bb3ba29d3df13b8b79decd2fc5fd2

	public Result<Transaction> processPayment(String nonce, BigDecimal amount, String currency) {
		String merchantAccountId;

		// Map currencies to merchant account IDs
		switch (currency) {
		case "USD":
			merchantAccountId = "your-merchant-account-id-for-usd";
			break;
		case "AUD":
			merchantAccountId = "your-merchant-account-id-for-aud";
			break;
		// Add more cases as needed for other currencies
		default:
			merchantAccountId = "your-default-merchant-account-id";
			break;
		}

		TransactionRequest transactionRequest = new TransactionRequest().amount(amount).paymentMethodNonce(nonce)
				.merchantAccountId(merchantAccountId) // Set the merchant account ID
				.options().submitForSettlement(true).done();

		return gateway.transaction().sale(transactionRequest);
	}

	public String getClientToken() {
		return gateway.clientToken().generate();
	}

}
