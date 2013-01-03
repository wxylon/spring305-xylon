/*
 * Copyright 2002-2006 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.propertyeditors;

import junit.framework.TestCase;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;

/**
 * 属性编辑器：主要功能是通过设置字符串，来默认转换为指定格式；
 * 可以注册监听器：PropertyChangeListener，只要调用setValue方法，将会触发监听器；
 * @see java.beans.PropertyEditorSupport.setValue("??") and setAsText()
 * setAsText()
 * getAsText()		用来获取和设置将字符串转换为任意类型，包括基本数据类型，对象类型
 * getValue()
 * setValue()		用来获取和设置原始类型
 * @author Rick Evans
 */
public final class ByteArrayPropertyEditorTests extends TestCase {

	public void testSunnyDaySetAsText() throws Exception {
		final String text = "Hideous towns make me throw... up";

		PropertyEditor byteEditor = new ByteArrayPropertyEditor();
		byteEditor.addPropertyChangeListener(new PropertyChangeListenerCustomer());
		byteEditor.setAsText(text);

		Object value = byteEditor.getValue();
		assertNotNull(value);
		assertTrue(value instanceof byte[]);
		byte[] bytes = (byte[]) value;
		for (int i = 0; i < text.length(); ++i) {
			assertEquals("cyte[] differs at index '" + i + "'", text.charAt(i), bytes[i]);
		}
		assertEquals(text, byteEditor.getAsText());
	}

	public void testGetAsTextReturnsEmptyStringIfValueIsNull() throws Exception {
		PropertyEditor byteEditor = new ByteArrayPropertyEditor();
		assertEquals("", byteEditor.getAsText());
		
		byteEditor.setAsText(null);
		assertEquals("", byteEditor.getAsText());
	}
	
	
	public static final class PropertyChangeListenerCustomer implements PropertyChangeListener{

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			System.out.println(evt.getSource());
			System.out.println(evt.getNewValue());
			System.out.println(evt.getOldValue());
			System.out.println(evt.getPropagationId());
			System.out.println(evt.getPropertyName());
		}
	}
}
