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
package thiagodnf.javautils.core;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Static utility methods pertaining to String instances.
 * 
 * @author Thiago Ferreira
 * @since 2018-03-03
 * @version 0.0.2
 */
public class Strings {

	/**
	 * Constructor. Do not allow this class to be instantiated.
	 * @throws IllegalAccessException 
	 */
	private Strings() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Remove the space before and after for each element in array
	 * The list cannot be null
	 * 
	 * @param list list that should be removed the space
	 * @return a list with no spaces
	 */
	public static List<String> trim(List<String> list) {
		
		checkNotNull(list, "The list cannot be null");
		
		return list.stream().map(String::trim).collect(Collectors.toList());
	}
}
