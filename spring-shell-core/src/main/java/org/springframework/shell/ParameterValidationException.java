/*
 * Copyright 2017 the original author or authors.
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

package org.springframework.shell;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Thrown when one or more parameters fail bean validation constraints.
 *
 * @author Eric Bottard
 */
public class ParameterValidationException extends RuntimeException {
	private final Set<ConstraintViolation<Object>> constraintViolations;
	private final MethodTarget methodTarget;

	public ParameterValidationException(Set<ConstraintViolation<Object>> constraintViolations, MethodTarget methodTarget) {
		this.constraintViolations = constraintViolations;
		this.methodTarget = methodTarget;
	}

	public Set<ConstraintViolation<Object>> getConstraintViolations() {
		return constraintViolations;
	}

	public MethodTarget getMethodTarget() {
		return methodTarget;
	}
}
