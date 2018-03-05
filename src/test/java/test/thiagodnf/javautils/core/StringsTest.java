/** Copyright 2018 Thiago Ferreira
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  *   http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */
package test.thiagodnf.javautils.core;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import thiagodnf.javautils.core.Strings;

public class StringsTest {

	@Test(expected=InvocationTargetException.class)
	public void givenConstructorWhenInitializedThenThrowException() throws Exception{
		Constructor<Strings> c = Strings.class.getDeclaredConstructor();
		c.setAccessible(true);
		c.newInstance();
	}
	
	@Test(expected=NullPointerException.class)
	public void givenTrimMethodWhenCalledWithNullThenThrowException(){
		Strings.trim(null);
	}
	
	@Test
	public void givenTrimMethodWhenCalledWithNotNullThenReturnCleanList(){
		
		List<String> expected = Arrays.asList("a","b","c");
		List<String> result = Strings.trim(Arrays.asList(" a ","  b  ","  c "));
		
		assertEquals(expected, result);
	}
	
	
}
