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

import java.util.Objects;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public interface Command {

	/**
	 * Encapsulates help metadata about a shell command.
	 *
	 * @author Eric Bottard
	 */
	class Help {
		/**
		 * Optional group to gather related commands together.
		 */
		private final String group;

		/**
		 * A required, short one sentence description of the command. Should start with a capital and end with a dot
		 * for consistency.
		 */
		private final String description;

		/**
		 * Optional examples section for the command.
		 */
		private final String examples;

		public Help(final String description) {
			this(description, null, null);
		}

		public Help(final String description, final String group) {
			this(description, group, null);
		}

		public Help(final String description, final String group, final String examples) {
			Assert.isTrue(StringUtils.hasText(description), "Command description cannot be null or empty");
			this.description = description;
			this.group = StringUtils.hasText(group) ? group : "";
			this.examples = StringUtils.hasText(examples) ? examples : "";
		}

		public String getDescription() {
			return description;
		}

		public String getGroup() {
			return group;
		}

		public String getExamples() {
			return examples;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Help help = (Help) o;
			return Objects.equals(group, help.group) &&
					Objects.equals(description, help.description) &&
					Objects.equals(examples, help.examples);
		}

		@Override
		public int hashCode() {
			return Objects.hash(group, description, examples);
		}
	}
}
