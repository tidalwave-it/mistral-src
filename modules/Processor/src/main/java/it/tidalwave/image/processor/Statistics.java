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
package it.tidalwave.image.processor;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.io.PrintWriter;
import java.io.Serializable;
import it.tidalwave.image.processor.Statistics.Item;
import lombok.extern.slf4j.Slf4j;

/***********************************************************************************************************************
 *
 * This class represents a set of statistics, that can be updated incrementally
 * sample by sample. Each item has a name; min/max/avg values are recorded.
 * It is mostly used for measuring execution time, but can be used for any value
 * of type <code>long</code>.
 *
 * @author Fabrizio Giudici
 *
 **********************************************************************************************************************/
@Slf4j
public class Statistics implements Serializable, Iterable<Item>
  {
    private static final long serialVersionUID = 6751339155167897162L;

    /**
     * The map
     */
    private SortedMap<String, Item> map = new TreeMap<>();

    /*******************************************************************************************************************
     *
     * This class represents a single statistics item with name, min/max/avg
     * value.
     *
     ******************************************************************************************************************/
    public static class Item implements Serializable, Comparable<Item>
      {
//        private static final long serialVersionUID = 49503335739587897162L;

        private String name;

        private long minimum = Long.MAX_VALUE;

        private long maximum = Long.MIN_VALUE;

        private long accumulator;

        private int sampleCount;

        /***************************************************************************************************************
         *
         * Create a new sample.
         *
         * @param  name  the item name
         *
         **************************************************************************************************************/
        public Item (final String name)
          {
            this.name = name;
          }

        /***************************************************************************************************************
         *
         * Returns the sample name.
         *
         * @return the name
         *
         **************************************************************************************************************/
        public String getName()
          {
            return name;
          }

        /***************************************************************************************************************
         *
         * Returns the minimum value.
         *
         * @return the minimum value
         *
         **************************************************************************************************************/
        public long getMinimum()
          {
            return minimum;
          }

        /***************************************************************************************************************
         *
         * Returns the maximum value.
         *
         * @return the maximum value
         *
         **************************************************************************************************************/
        public long getMaximum()
          {
            return maximum;
          }

        /***************************************************************************************************************
         *
         * Returns the average value.
         *
         * @return the average value
         *
         **************************************************************************************************************/
        public long getAverage()
          {
            return accumulator / sampleCount;
          }

        public long getAccumulator()
          {
            return accumulator;
          }

        public int getSampleCount()
          {
            return sampleCount;
          }

        /***************************************************************************************************************
         *
         * Adds a new sample to this item.
         *
         * @param  value  the value
         *
         **************************************************************************************************************/
        public void addSample (final long value)
          {
            minimum = Math.min(minimum, value);
            maximum = Math.max(maximum, value);
            accumulator += value;
            sampleCount++;
          }

        /***************************************************************************************************************
         *
         *
         *
         **************************************************************************************************************/
        @Override
        public int compareTo (final Statistics.Item o)
          {
            return this.name.compareTo(o.name);
          }

        /***************************************************************************************************************
         *
         * Merges this item with another.
         *
         * @param  otherItem  the other item
         *
         **************************************************************************************************************/
        protected void merge (final Item otherItem)
          {
            minimum = Math.min(minimum, otherItem.minimum);
            maximum = Math.max(maximum, otherItem.maximum);
            accumulator += otherItem.accumulator;
            sampleCount += otherItem.sampleCount;
          }

        /***************************************************************************************************************
         *
         *
         *
         **************************************************************************************************************/
        @Override
        public String toString()
          {
            return "Statistics.Item[" + name + " min:" + minimum + " max:" + maximum + " avg:" + getAverage() + "]";
          }
      }

    /*******************************************************************************************************************
     *
     * Adds a new sample to these statistics.
     *
     * @param  name   the name
     * @param  value  the value
     *
     ******************************************************************************************************************/
    public synchronized void addSample (final String name, final long value)
      {
        var statItem = map.get(name);

        if (statItem == null)
          {
            statItem = new Item(name);
            map.put(name, statItem);
          }

        statItem.addSample(value);
      }

    /*******************************************************************************************************************
     *
     * Merges these statistics with others.
     *
     * @param  statistics  the other statistics
     *
     ******************************************************************************************************************/
    public synchronized void merge (final Statistics statistics)
      {
        for (final var statItem : statistics)
          {
            final var here = map.get(statItem.getName());

            if (here == null)
              {
                map.put(statItem.getName(), statItem);
              }

            else
              {
                here.merge(statItem);
              }
          }
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    public void dump()
      {
        for (final var item : this)
          {
            log.info("STATS: >>>> " +
                     item.getName() + ": min/max/avg " +
                     item.getMinimum() + "/" +
                     item.getMaximum() + "/" +
                     item.getAverage() + " samples: " +
                     item.getSampleCount() + " acc: " +
                     item.getAccumulator());
          }
      }

    /*******************************************************************************************************************
     *
     *
     *
     ******************************************************************************************************************/
    public void dump (final PrintWriter pw)
      {
        for (final var item : this)
          {
            pw.println(item.getName() + ": min/max/avg " +
                       item.getMinimum() + "/" +
                       item.getMaximum() + "/" +
                       item.getAverage() + " samples: " +
                       item.getSampleCount() + " acc: " +
                       item.getAccumulator());
          }
      }

    /*******************************************************************************************************************
     *
     * {@inheritDoc}
     *
     ******************************************************************************************************************/
    @Override
    public Iterator<Statistics.Item> iterator()
      {
        return map.values().iterator();
      }
  }
