import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class SendMessage {
	public static void main(String arg[])
	{
		sendSms("8970820521", "hello");
	}
	public static String apiKey = "8q1SWsrhujTNMZIeK7ldGU6gmRLkDv9HoBCatQ3pzEYA0iJV2FW6LApaeTxy8YsNz5tBHMUXd41Ouh07 ";
	public static String sendSms(String number, String msg) {
		try {
			// Construct data
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://www.fast2sms.com/dev/bulk").openConnection();
			String data = "sender_id=FSTSMS&message=" + msg + "&language=english&route=p&numbers=" + number;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("authorization", apiKey);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			System.out.println("SMS Result: " + stringBuffer.toString());
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return "Error " + e;
		}
	}
}