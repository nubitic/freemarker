/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.freemarker.core.cformat.impl;

import org.apache.freemarker.core.Environment;
import org.apache.freemarker.core.ProcessingConfiguration;
import org.apache.freemarker.core.TemplateException;
import org.apache.freemarker.core.cformat.CFormat;
import org.apache.freemarker.core.util._StringUtils;
import org.apache.freemarker.core.util._StringUtils.JsStringEncCompatibility;
import org.apache.freemarker.core.util._StringUtils.JsStringEncQuotation;

/**
 * {@value #NAME} {@link CFormat}; for generating output that's compatible with both JSON and JavaScript. This format is
 * therefore resilient against configuration mistakes, where we generate output in one language, but use the
 * {@link CFormat} for the other. The small price to pay is that we can't utilize some language-specific opportunities
 * to make the output a bit shorter, but that hardly matters in practice.
 * This is the default of {@link ProcessingConfiguration#getCFormat()}.
 *
 * @see JavaScriptCFormat
 * @see JSONCFormat
 */
public final class JavaScriptOrJSONCFormat extends AbstractJSONLikeFormat {
    public static final String NAME = "JavaScript or JSON";
    public static final JavaScriptOrJSONCFormat INSTANCE = new JavaScriptOrJSONCFormat();

    private JavaScriptOrJSONCFormat() {
    }

    @Override
    public String formatString(String s, Environment env) throws TemplateException {
        return _StringUtils.jsStringEnc(
                s, JsStringEncCompatibility.JAVA_SCRIPT_OR_JSON, JsStringEncQuotation.QUOTATION_MARK);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
