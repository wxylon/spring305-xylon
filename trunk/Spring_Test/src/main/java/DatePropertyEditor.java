import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport {

	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("setAsText--->"+text);
		String format = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			Date date = sdf.parse(text);
			super.setValue(date); // 把转换后的值传过去
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getAsText() {
		String time = super.getAsText();

		String format = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			System.out.println("getAsText--->"+sdf.format(new Date(time)));
			return sdf.format(new Date(time));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
