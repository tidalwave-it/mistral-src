/*
 * *********************************************************************************************************************
 *
 * Mistral: open source imaging engine
 * http://tidalwave.it/projects/mistral
 *
 * Copyright (C) 2003 - 2023 by Tidalwave s.a.s. (http://tidalwave.it)
 *
 * *********************************************************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * *********************************************************************************************************************
 *
 * git clone https://bitbucket.org/tidalwave/mistral-src
 * git clone https://github.com/tidalwave-it/mistral-src
 *
 * *********************************************************************************************************************
 */
package it.tidalwave.image.metadata;

import javax.annotation.Nonnull;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.is;

/***********************************************************************************************************************
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
public class DirectoryTest
  {
    @Test(dataProvider = "dates")
    public void testParseDateTime (@Nonnull final String string, @Nonnull final Instant expected)
      {
        // WHEN
        var actual = Directory.parseDateTime(string);
        // THEN
        assertThat(expected, is(actual));
      }

    @DataProvider
    public static Object[][] dates()
      {
        final var dzo = ZoneOffset.UTC;

        return new Object[][]
          {
            { "2023:03:15 12:20:45", LocalDateTime.of(2023, 3, 15, 12, 20, 45).toInstant(dzo) },
            { "2021-07-25T17:42:31", LocalDateTime.of(2021, 7, 25, 17, 42, 31).toInstant(dzo) }
          };
      }
  }
