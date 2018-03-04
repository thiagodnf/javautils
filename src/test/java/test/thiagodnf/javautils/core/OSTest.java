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
