/*
 * Copyright 2011 <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ocpsoft.socialpm;

import com.ocpsoft.rewrite.config.Condition;
import com.ocpsoft.rewrite.config.ConditionBuilder;
import com.ocpsoft.rewrite.context.EvaluationContext;
import com.ocpsoft.rewrite.event.Rewrite;
import com.ocpsoft.rewrite.servlet.config.Path;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public abstract class SocialPMResources extends ConditionBuilder
{
   public static Condition excluded()
   {
      return new SocialPMResources() {
         @Override
         public boolean evaluate(final Rewrite event, final EvaluationContext context)
         {
            return Path.matches(".*")
                     .andNot(Path.matches(".*javax\\.faces\\.resource.*"))
                     .andNot(Path.matches("/openid/.*"))
                     .andNot(Path.matches("/logout"))
                     .andNot(Path.matches("/rfRes/.*")).evaluate(event, context);
         }
      };
   }
}
