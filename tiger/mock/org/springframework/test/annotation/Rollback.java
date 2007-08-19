/*
 * Copyright 2007 the original author or authors.
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

package org.springframework.test.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Test annotation to indicate whether or not the transaction for the annotated
 * test method should be <em>rolled back</em> after the test method has
 * completed. If <code>true</code>, the transaction will be rolled back;
 * otherwise, the transaction will be committed.
 *
 * @author Sam Brannen
 * @version $Revision: 1.1 $
 * @since 2.1
 */
@Target( { ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Rollback {

	// ------------------------------------------------------------------------|
	// --- ATTRIBUTES ---------------------------------------------------------|
	// ------------------------------------------------------------------------|

	/**
	 * <p>
	 * Whether or not the transaction for the annotated method should be rolled
	 * back after the method has completed.
	 * </p>
	 * <p>
	 * Defaults to <code>true</code>.
	 * </p>
	 */
	boolean value() default true;

}
