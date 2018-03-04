package thiagodnf.javautils.core;

/**
 * This class is responsible for return the operational system used by the
 * application. It is based on <a href=
 * "http://www.mkyong.com/java/how-to-detect-os-in-java-systemgetpropertyosname/">
 * http://www.mkyong.com/java/how-to-detect-os-in-java-systemgetpropertyosname/</a>
 * 
 * @author Thiago Ferreira
 * @since 2018-03-03
 * @version 0.0.1
 */
public class OS {
	
	/** Operational System found */
	private static String OS = System.getProperty("os.name").toLowerCase();

	/**
	 * Constructor. Do not allow this class to be instantiated.
	 * @throws IllegalAccessException 
	 */
	private OS() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Verify if the operational system used is Windows
	 * 
	 * @return true if is Windows. False otherwise
	 */
	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	/**
	 * Verify if the operational system used is MacOS
	 * 
	 * @return true if is MacOS. False otherwise
	 */
	public static boolean isMacOS() {
		return (OS.indexOf("mac") >= 0);
	}

	/**
	 * Verify if the operational system used is Unix
	 * 
	 * @return true if is Unix. False otherwise
	 */
	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") >= 0);
	}

	/**
	 * Verify if the operational system used is Solaris
	 * 
	 * @return true if is Solaris. False otherwise
	 */
	public static boolean isSolaris() {
		return (OS.indexOf("sunos") >= 0);
	}
	
	/**
	 * Return the operational system's name
	 * 
	 * @return the OS name. Possible names: windows, macos, unix, solaris
	 * @throws IllegalArgumentException if the operational system was not found
	 */
	public static String getOSName() {
		if (isWindows()) {
			return "windows";
		} else if (isMacOS()) {
			return "macos";
		} else if (isUnix()) {
			return "unix";
		} else if (isSolaris()) {
			return "solaris";
		} else {
			throw new IllegalArgumentException("The operational system was not found");
		}
	}
}
