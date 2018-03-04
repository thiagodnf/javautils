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
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import thiagodnf.javautils.core.OS;

public class OSTest {

	@Test(expected=InvocationTargetException.class)
	public void givenConstructorWhenInitializedThenThrowException() throws Exception{
		Constructor<OS> c = OS.class.getDeclaredConstructor();
		c.setAccessible(true);
		c.newInstance();
	}
	
	@Test
	public void givenOSNameMethodWhenCalledThenReturnNotNull(){
		assertNotNull(OS.getOSName());
	}
	
	@Test
	public void givenOSNameMethodWhenTheOSIsWindowsThenReturnWindows() throws Exception{
		setCurrentOS("windows");
		assertEquals("windows", OS.getOSName());
	}
	
	@Test
	public void givenOSNameMethodWhenTheOSIsUnixThenReturnUnix() throws Exception{
		setCurrentOS("unix");
		assertEquals("unix", OS.getOSName());
		setCurrentOS("nux");
		assertEquals("unix", OS.getOSName());
		setCurrentOS("aix");
		assertEquals("unix", OS.getOSName());
	}
	
	@Test
	public void givenOSNameMethodWhenTheOSIsMacOSThenReturnMacOS() throws Exception{
		setCurrentOS("mac");
		assertEquals("macos", OS.getOSName());
	}
	
	@Test
	public void givenOSNameMethodWhenTheOSIsSolarisThenReturnSolaris() throws Exception{
		setCurrentOS("sunos");
		assertEquals("solaris", OS.getOSName());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void givenOSNameMethodWhenTheOSIsUnknownThenThrowException() throws Exception{
		setCurrentOS("abc");
		OS.getOSName();
	}
	
	private void setCurrentOS(String name) throws Exception {
		Field f = OS.class.getDeclaredField("OS");
		f.setAccessible(true);
		f.set(null, name);
	}
	
}
