package org.scc.mail;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.scc.model.AirlineInfo;

public class SendMail {

//	/**
//	 * @param args
//	 * @throws MessagingException
//	 * @throws UnsupportedEncodingException
//	 */
//	public static void main(String[] args) throws UnsupportedEncodingException,
//			MessagingException {
//		AirlineInfo user = new AirlineInfo();
//		user.setLastName("高");
//		user.setFirstName("帅富");
//		user.setEmail("czgt123@gmail.com");
//		user.setPhone("+6875528185953");
//
//		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//		String arrivalDateStr = "08/10/2013";
//		Date arrivalDate;
//		try {
//			arrivalDate = dateFormat.parse(arrivalDateStr);
//			user.setArrivalDate(new java.sql.Date(arrivalDate.getTime()));
//		} catch (ParseException e) {
//			System.out.println(e);
//		}
//
//		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
//		// flightArrivalTime
//		String arrivalTimeStr = "11:22";
//		Date arrivalTime;
//		try {
//			arrivalTime = timeFormat.parse(arrivalTimeStr);
//			user.setArrivalTime(new java.sql.Time(arrivalTime.getTime()));
//		} catch (ParseException e) {
//			System.out.println(e);
//		}
//		
//		user.setFlightNumber("ca988".toUpperCase());
//		user.setTerminal(8);
//		user.setDestination("chapin");
//		user.setOffCampusRow(null);
//		user.setQQName("qqName");
//		// qq#
//		user.setQQ("123456");
//		// major
//		user.setMajorId("CSE");
//		// studentId
//		user.setSbuId(108292118);
//		// memo
//		String memo = "";
//		user.setMemo(memo);
//		
//		
//		
//		sendMail(user);
//		System.out.println("Sent!");
//	}

	public static void sendMail(AirlineInfo user)
			throws UnsupportedEncodingException, MessagingException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		String arrivalDate = dateFormat.format(user.getArrivalDate());
		String arrivalDateCn = arrivalDate.split("/")[1];
		if (arrivalDateCn.equals("10")) {
			arrivalDateCn = "八月十号";
		} else if (arrivalDateCn.equals("11")) {
			arrivalDateCn = "八月十一号";
		} else if (arrivalDateCn.equals("16")) {
			arrivalDateCn = "八月十六号";
		} else if (arrivalDateCn.equals("17")) {
			arrivalDateCn = "八月十七号";
		} else if (arrivalDateCn.equals("18")) {
			arrivalDateCn = "八月十八号";
		}
		String des = user.getDestination();
		if (des.equals("other")) {
			des = user.getOffCampusRow();
		}
		
		String sendFromAddress = "sbcampusfellowship@gmail.com";
		String sendFromName = "石溪校园团契";
		String sendToAddress = user.getEmail();
		String sendToName = user.getLastName() + user.getFirstName();
		String mailSubject = "2013年施福基督教会新生接机报名成功";
		String mailText = "<p>亲爱的"
				+ sendToName
				+ "你好，</p><p>　　你已经<b>成功</b>报名了哦~~~我也不知道该说些什么了哦~~~我们" + arrivalDateCn + "见咯~~~</p>" +
				"<div style=\"border: solid 1px black;width: 500px;\">" +
				"<table style=\"margin-left: auto;margin-right: auto;\">" +
					"<tr>" +
						"<td colspan=\"2\" style=\"text-align: center;\"><h3><b>基本信息</b></h3></td>" +
					"</tr>" +
					"<tr>" +
						"<td style=\"text-align: right;padding-right: 20px;\">姓名：</td>" +
						"<td>" + sendToName + "</td>" +
					"</tr>" +
					"<tr>" +
						"<td style=\"text-align: right;padding-right: 20px;\">联系邮箱：</td>" +
						"<td>" + sendToAddress + "</td>" +
					"</tr>" +
					"<tr>" +
						"<td style=\"text-align: right;padding-right: 20px;\">国内紧急联系电话：</td>" +
						"<td>" + user.getPhone() + "</td>" +
					"</tr>" +
					"<tr>" +
						"<td colspan=\"2\" style=\"text-align: center;\"><h3><b>航班信息</b></h3></td>" +
					"</tr>" +
					"<tr>" +
						"<td style=\"text-align: right;padding-right: 20px;\">到达日期：</td>" +
						"<td>" + arrivalDate + "</td>" +
					"</tr>" +
					"<tr>" +
						"<td style=\"text-align: right;padding-right: 20px;\">到达时间(24小时制)：</td>" +
						"<td>" + timeFormat.format(user.getArrivalTime()) + "</td>" +
					"</tr>" +
					"<tr>" +
						"<td style=\"text-align: right;padding-right: 20px;\">航班号：</td>" +
						"<td>" + user.getFlightNumber() + "</td>" +
					"</tr>" +
					"<tr>" +
						"<td style=\"text-align: right;padding-right: 20px;\">到达航站楼：</td>" +
						"<td>Terminal " + user.getTerminal() + "</td>" +
					"</tr>" +
					"<tr>" +
						"<td colspan=\"2\" style=\"text-align: center;\"><h3><b>石溪信息</b></h3></td>" +
					"</tr>" +
					"<tr>" +
						"<td style=\"text-align: right;padding-right: 20px;\">宿舍或校外住址：</td>" +
						"<td>" + des + "</td>" +
					"</tr>" +
					"<tr>" +
						"<td style=\"text-align: right;padding-right: 20px;\">学号：</td>" +
						"<td>" + user.getSbuId() + "</td>" +
					"</tr>" +
					"<tr>" +
						"<td style=\"text-align: right;padding-right: 20px;\">专业：</td>" +
						"<td>" + user.getMajorName() + "</td>" +
					"</tr>" +
					"<tr>" +
						"<td style=\"text-align: right;padding-right: 20px;\">QQ：</td>" +
						"<td>" + user.getQQ() + "</td>" +
					"</tr>" +
					"<tr>" +
						"<td style=\"text-align: right;padding-right: 20px;\">群名片：</td>" +
						"<td>" + user.getQQName() + "</td>" +
					"</tr>" +
					"<tr>" +
						"<td style=\"text-align: right;padding-right: 20px;\">备注：</td>" +
						"<td>" + user.getMemo() + "</td>" +
					"</tr>" +
					"</table>" +
					"</div>" +
					"<p>各种注意事项啊啥啥啥的就放在这里吧。。。</p>" +
					"<br><p>　　　　　　　　　　　　　　　　　　　　　　　　施福基督教会石溪校园团契</p>";

		Properties propsSSL = new Properties();
		propsSSL.put("mail.transport.protocol", "smtps");
		propsSSL.put("mail.smtps.host", "smtp.gmail.com");
		propsSSL.put("mail.smtps.auth", "true");
		Session sessionSSL = Session.getInstance(propsSSL);
		// sessionSSL.setDebug(true);
		Message messageSSL = new MimeMessage(sessionSSL);
		messageSSL.setFrom(new InternetAddress(sendFromAddress, sendFromName));
		messageSSL.setRecipient(Message.RecipientType.TO, new InternetAddress(
				sendToAddress, sendToName)); // real recipient
		messageSSL.setSubject(mailSubject);
		messageSSL.setContent(mailText, "text/html;charset=UTF-8");

		Transport transportSSL = sessionSSL.getTransport();
		transportSSL.connect("smtp.gmail.com", 465,
				"sbcampusfellowship@gmail.com", "ShanghaiChenhao"); // account
																	// used
		// transportSSL.connect("smtpout.secureserver.net", 465,
		// "info@sccfellowship.org", "28185953"); // account used
		transportSSL.sendMessage(messageSSL, messageSSL.getAllRecipients());
		transportSSL.close();
	}

}
