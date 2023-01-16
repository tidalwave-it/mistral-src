/***********************************************************************************************************************
 *
 * Mistral - open source imaging engine
 * Copyright (C) 2003-2023 by Tidalwave s.a.s.
 *
 ***********************************************************************************************************************
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
 ***********************************************************************************************************************
 *
 * WWW: http://mistral.tidalwave.it
 * SCM: https://bitbucket.org/tidalwave/mistral-src
 *
 **********************************************************************************************************************/
/*
 * TestReportFormatter.java
 *
 * Created on November 26, 2006, 2:43 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.tidalwave.image.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/**
 *
 * @author fritz
 */
class TestInfo implements Comparable<TestInfo>
  {
    private final String revision;
    private final String test;
    private final String quality;
    private final String file;
    private Set<TestResults> results = new TreeSet<TestResults>();

    public TestInfo (final String body)
      {
        System.err.println(body);

        final String[] tmp = body.split("::");
        revision = tmp[0];
        test = tmp[3];
        quality = tmp[4];
        file = tmp[5];
      }

    public void add (final TestResults testResults)
      {
        results.add(testResults);
      }

    public void printHeader (final PrintWriter pw)
      {
        pw.println(
            "<tr><td rowspan='2'>Revision</td><td rowspan='2'>Test</td><td rowspan='2'>Quality</td><td rowspan='2'>File</td>");

        for (final TestResults testResults : results)
          {
            pw.println("<td>" + testResults.host + "</td>");
          }

        pw.println("</tr>");
        pw.println("<tr>");

        for (final TestResults testResults : results)
          {
            pw.println("<td>" + testResults.os + "</td>");
          }

        pw.println("</tr>");
      }

    private static String latestTest = "";
    private String[] colors = new String[] { "#ffffff", "#dddddd" };
    private static int k;

    public void print (final PrintWriter pw)
      {
        if (!latestTest.equals(test + quality))
          {
            k++;
            latestTest = test + quality;
          }

        pw.print("<tr bgcolor='" + colors[k % colors.length] + "'><td align='right'>" + revision + "</td>");
        pw.print("<td>" + test + "</td>");
        pw.print("<td>" + quality + "</td>");
        pw.print("<td>" + file + "</td>");

        for (final TestResults testResults : results)
          {
            testResults.print(pw);
          }

        pw.println("</tr>");
      }

    @Override
    public int compareTo (final TestInfo o)
      {
        int r = test.compareTo(o.test);

        if (r != 0)
          {
            return r;
          }

        r = quality.compareTo(o.quality);

        if (r != 0)
          {
            return r;
          }

        r = file.compareTo(o.file);

        if (r != 0)
          {
            return r;
          }

        String tRevision = revision;
        int i = tRevision.lastIndexOf('.');

        if (i > 0)
          {
            tRevision = revision.substring(i + 1);
          }

        String oRevision = o.revision;
        i = oRevision.lastIndexOf('.');

        if (i > 0)
          {
            oRevision = oRevision.substring(i + 1);
          }

        r = tRevision.compareTo(oRevision);

        return r;
      }

    @Override
    public boolean equals (final Object o)
      {
        if (!(o instanceof TestInfo))
          {
            return false;
          }

        return compareTo((TestInfo)o) == 0;
      }

    public int hashcode ()
      {
        return revision.hashCode() ^ test.hashCode() ^ quality.hashCode() ^ file.hashCode();
      }
  }


class TestResults implements Comparable<TestResults>
  {
    private final String value;
    public final String host;
    public final String os;

    public TestResults (final String body, final String value)
      {
        final String[] tmp = body.split("::");
        host = tmp[1];
        os = tmp[2];
        this.value = value;
      }

    @Override
    public int compareTo (final TestResults o)
      {
        int r = host.compareTo(o.host);

        if (r != 0)
          {
            return r;
          }

        r = os.compareTo(o.os);

        return r;
      }

    public void print (final PrintWriter pw)
      {
        String color = "black";

        if (value.equals("FAILS") || (!value.equals("-") && (Integer.parseInt(value) > 50000)))
          {
            color = "red";
          }

        pw.print("<td align='right'><font color='" + color + "'>" + value + "</font></td>");
      }
  }


public class TestReportFormatter
  {
    private final File reportFile;
    private final File htmlFile;
    private List<TestInfo> tests = new ArrayList<TestInfo>();

    /** Creates a new instance of TestReportFormatter */
    public TestReportFormatter (final File reportFile, final File htmlFile)
      {
        this.reportFile = reportFile;
        this.htmlFile = htmlFile;
      }

    public void run ()
        throws IOException
      {
        final BufferedReader br = new BufferedReader(new FileReader(reportFile));

        for (;;)
          {
            String s = br.readLine();

            if (s == null)
              {
                break;
              }

            s = s.split("#")[0].trim();

            if ("".equals(s))
              {
                continue;
              }

            final String[] tmp = s.split("=");
            final String body = tmp[0].trim();
            final String value = tmp[1].trim();
            TestInfo testInfo = new TestInfo(body);
            final TestResults testResults = new TestResults(body, value);

            final int i = tests.indexOf(testInfo);

            if (i < 0)
              {
                tests.add(testInfo);
              }

            else
              {
                testInfo = tests.get(i);
              }

            testInfo.add(testResults);
          }

        br.close();
        Collections.sort(tests);

        final PrintWriter pw = new PrintWriter(new FileWriter(htmlFile));
        pw.println("<table border='1' cellpadding='2' cellspacing='0'>");
        tests.get(0).printHeader(pw);

        for (final TestInfo testInfo : tests)
          {
            testInfo.print(pw);
          }

        pw.println("</table>");
        pw.close();
      }

    public static void main (final String[] args)
        throws IOException
      {
        new TestReportFormatter(new File(
                "/Users/fritz/Business/Tidalwave/Projects/Mistral/trunk/src/EditableImage/TestReport.txt"),
            new File("/Users/fritz/Business/Tidalwave/Projects/Mistral/trunk/src/EditableImage/TestReport.html")).run();
      }
  }
