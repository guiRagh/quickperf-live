/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2021-2021 the original author or authors.
 */
package org.quickperf.web.spring;

import org.quickperf.web.spring.config.DatabaseConfig;
import org.quickperf.web.spring.config.DatabaseHttpConfig;
import org.quickperf.web.spring.config.JvmConfig;
import org.quickperf.web.spring.config.TestGenerationConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@Import({ DatabaseConfig.class
        , JvmConfig.class
        , DatabaseHttpConfig.class
        , TestGenerationConfig.class
        , QuickPerfBeforeRequestServletFilter.class
        , QuickPerfAfterRequestServletFilter.class
        , QuickPerfHttpCallHttpCallWarningLogger.class
        , QuickPerfHttpCallHttpCallInfoLogger.class
        , ExternalHttCallInterceptionConfig.class
})
@ConditionalOnProperty(value = "quickperf.enabled")
public class WebLiveAutoconfiguration {

}
