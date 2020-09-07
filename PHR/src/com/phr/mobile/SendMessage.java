package com.phr.mobile;

public class SendMessage
{
   public static String sendSms(String number, String msg)
   {
      try
      {
         // Construct data
	 // Send data
         String apiKey = Qk9D8foVvN4WsIEGuOTCxJAHK7BnZLbpSz2q0yYP1Rg5a3lXUt2jIfcx4LE1A0GRlKsJ8BuzbiCPUMQ5
         HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
         String data = "sender_id=FSTSMS&message=" + msg + "&language=english&route=p&numbers=" + number;
         conn.setDoOutput(true);
         conn.setRequestMethod("POST");
	 conn.setRequestProperty("authorization", apiKey);
	 conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
	 conn.setRequestProperty("User-Agent",
			"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36");
         conn.getOutputStream().write(data.getBytes("UTF-8"));
         final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         final StringBuffer stringBuffer = new StringBuffer();
         String line;
         while ((line = rd.readLine()) != null)
         {
            stringBuffer.append(line);
         }
         rd.close();

         System.out.println("SMS Result: " + stringBuffer.toString());
         return stringBuffer.toString();
      }
      catch (Exception e)
      {
         System.out.println("Error SMS " + e);
         return "Error " + e;
      }
   }

}
