package org.scc.util;

import com.google.gdata.client.authn.oauth.*;
import com.google.gdata.client.spreadsheet.*;
import com.google.gdata.data.*;
import com.google.gdata.data.batch.*;
import com.google.gdata.data.spreadsheet.*;
import com.google.gdata.util.*;

import java.io.IOException;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

import org.scc.model.AirlineInfo;

public class Spreadsheet {
	private static final String MAIN_SPREADSHEET_KEY = "0Ai17tNBG_tLddFUxb0JqNS1kT2xjQ3h3eUV0NEtONVE";
	private static final String DAY10_SPREADSHEET_KEY = "0Ai17tNBG_tLddHVWTHRhX2tlVjBaN2tlRGRYb2Q3VUE";
	private static final String DAY11_SPREADSHEET_KEY = "0Ai17tNBG_tLddE5YeHNHSTNjcExlYmhIZ3U2anVfaVE";
	private static final String DAY16_SPREADSHEET_KEY = "0Ai17tNBG_tLddE84TUV3UWIyUGZoUkJGREJCbU1qZGc";
	private static final String DAY17_SPREADSHEET_KEY = "0Ai17tNBG_tLddGd4UGV0LVMybTRUR01NVFJfWnRRNEE";
	private static final String DAY18_SPREADSHEET_KEY = "0Ai17tNBG_tLddHkyQlhFSGVmWHR6eWsxUlBCdVpSN0E";
	private static String DAILY_SPREADSHEET_KEY = null;

	public static void updateSpreadsheet(AirlineInfo user)
			throws AuthenticationException, MalformedURLException, IOException,
			ServiceException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		String arrivalDate = dateFormat.format(user.getArrivalDate());
		String arrivalDateNum = arrivalDate.split("/")[1];
		if (arrivalDateNum.equals("10")) {
			DAILY_SPREADSHEET_KEY = DAY10_SPREADSHEET_KEY;
		} else if (arrivalDateNum.equals("11")) {
			DAILY_SPREADSHEET_KEY = DAY11_SPREADSHEET_KEY;
		} else if (arrivalDateNum.equals("16")) {
			DAILY_SPREADSHEET_KEY = DAY16_SPREADSHEET_KEY;
		} else if (arrivalDateNum.equals("17")) {
			DAILY_SPREADSHEET_KEY = DAY17_SPREADSHEET_KEY;
		} else if (arrivalDateNum.equals("18")) {
			DAILY_SPREADSHEET_KEY = DAY18_SPREADSHEET_KEY;
		}
		String des = user.getDestination();
		if (des.equals("other")) {
			des = user.getOffCampusRow();
		}
		String sendToAddress = user.getEmail();
		String sendToName = user.getLastName() + user.getFirstName();

		// Application code here
		String USERNAME = "sbcampusfellowship@gmail.com";
		String PASSWORD = "ShanghaiChenhao";

		SpreadsheetService service = new SpreadsheetService(
				"MySpreadsheetIntegration-v1");
		service.setUserCredentials(USERNAME, PASSWORD);

		// TODO: See other portions of this guide for code to put here...

		// Define the URL to request. This should never change.
		URL SPREADSHEET_FEED_URL = new URL(
				"https://spreadsheets.google.com/feeds/spreadsheets/private/full");

		// Make a request to the API and get all spreadsheets.
		SpreadsheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL,
				SpreadsheetFeed.class);
		List<SpreadsheetEntry> spreadsheetList = feed.getEntries();

		// if (spreadsheets.size() == 0) {
		// // TODO: There were no spreadsheets, act accordingly.
		// }

		List<SpreadsheetEntry> spreadsheets = new ArrayList<SpreadsheetEntry>();
		int spreadsheetListSize = spreadsheetList.size();
		for (int i = 0; i < spreadsheetListSize; i++) {
			SpreadsheetEntry spreadsheet = spreadsheetList.get(i);
			String key = spreadsheet.getSpreadsheetLink().getHref();
			if (key.contains(MAIN_SPREADSHEET_KEY)) {
				spreadsheets.add(spreadsheet);
			} else if (key.contains(DAILY_SPREADSHEET_KEY)) {
				spreadsheets.add(spreadsheet);
			}
		}

		int spreadsheetsSize = spreadsheets.size();
		for (int i = 0; i < spreadsheetsSize; i++) {
			SpreadsheetEntry spreadsheet = spreadsheets.get(i);
			// Get the first worksheet of the first spreadsheet.
			WorksheetFeed worksheetFeed = service.getFeed(
					spreadsheet.getWorksheetFeedUrl(), WorksheetFeed.class);
			List<WorksheetEntry> worksheets = worksheetFeed.getEntries();
			WorksheetEntry worksheet = worksheets.get(0);

			// Fetch the list feed of the worksheet.
			URL listFeedUrl = worksheet.getListFeedUrl();
			ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);

			// Create a local representation of the new row.
			ListEntry row = new ListEntry();
			row.getCustomElements().setValueLocal("姓名", sendToName);
			row.getCustomElements().setValueLocal("联系邮箱",
					sendToAddress);
			row.getCustomElements().setValueLocal("国内紧急联系电话", user.getPhone());
			row.getCustomElements().setValueLocal("到达日期", arrivalDate);
			row.getCustomElements().setValueLocal("到达时间", timeFormat.format(user.getArrivalTime()));
			row.getCustomElements().setValueLocal("航班号", user.getFlightNumber());
			row.getCustomElements().setValueLocal("到达航站楼", "Terminal " + user.getTerminal());
			row.getCustomElements().setValueLocal("宿舍或校外住址", des);
			row.getCustomElements().setValueLocal("学号", Integer.toString(user.getSbuId()));
			row.getCustomElements().setValueLocal("专业", user.getMajorName());
			row.getCustomElements().setValueLocal("QQ", user.getQQ());
			row.getCustomElements().setValueLocal("群名片", user.getQQName());
			row.getCustomElements().setValueLocal("备注", user.getMemo());

			// Send the new row to the API for insertion.
			row = service.insert(listFeedUrl, row);
		}
		// SpreadsheetEntry spreadsheet = spreadsheets.get(0);
		// System.out.println(spreadsheet.getTitle().getPlainText());

	}
}