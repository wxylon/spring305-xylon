import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;

public class TestPerson {
	public static void test() {
		try {
			Log log = LogFactory.getLog(TestPerson.class);
			Object obj = Class.forName("Person").newInstance();
			BeanWrapper bw = new BeanWrapperImpl(obj);
			bw.setExtractOldValueForEditor(true);
			bw.registerCustomEditor(Date.class, new DatePropertyEditor());
			bw.setPropertyValue("name", "Erica");
			bw.setPropertyValue("birthday", new Date());
			log.debug("User name=>" + bw.getPropertyValue("name"));
			log.debug("User birthday=>" + bw.getPropertyValue("birthday"));
			//System.out.println("User name=>" + bw.getPropertyValue("name"));
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		test();
	}
}
