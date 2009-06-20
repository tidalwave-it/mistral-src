/*******************************************************************************
 *
 * Mistral - open source imaging engine
 * ====================================
 *
 * Project home page: http://mistral.tidalwave.it
 *
 *******************************************************************************
 *
 * Copyright (C) 2003-2008 by Fabrizio Giudici
 *                        and Emmanuele Sordini
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
 *
 *******************************************************************************
 *
 * $Id: JavaBeanSupport.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
package it.tidalwave.image.metadata;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

/*******************************************************************************
 * 
 * Code adapted from AbstractBean by SwingLabs.
 * 
 * @author  Fabrizio Giudici
 * @version $Id: JavaBeanSupport.java 946 2008-09-07 09:45:55Z fabriziogiudici $
 *
 ******************************************************************************/
public abstract class JavaBeanSupport 
  {
    protected final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    protected final VetoableChangeSupport vetoableChangeSupport = new VetoableChangeSupport(this);
    
    public final void addPropertyChangeListener(PropertyChangeListener listener) 
      {
        propertyChangeSupport.addPropertyChangeListener(listener);
      }

    public final void removePropertyChangeListener(PropertyChangeListener listener) 
      {
        propertyChangeSupport.removePropertyChangeListener(listener);
      }

    public final PropertyChangeListener[] getPropertyChangeListeners() 
      {
        return propertyChangeSupport.getPropertyChangeListeners();
      }

    public final void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) 
      {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
      }

    public final void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) 
      {
        propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
      }

    public final PropertyChangeListener[] getPropertyChangeListeners(String propertyName) 
      {
        return propertyChangeSupport.getPropertyChangeListeners(propertyName);
      }

    public final void addVetoableChangeListener(VetoableChangeListener listener) 
      {
        vetoableChangeSupport.addVetoableChangeListener(listener);
      }

    public final void removeVetoableChangeListener(VetoableChangeListener listener) 
      {
        vetoableChangeSupport.removeVetoableChangeListener(listener);
      }

    public final VetoableChangeListener[] getVetoableChangeListeners()
      {
        return vetoableChangeSupport.getVetoableChangeListeners();
      }

    public final void addVetoableChangeListener(String propertyName, VetoableChangeListener listener) 
      {
        vetoableChangeSupport.addVetoableChangeListener(propertyName, listener);
      }

    public final void removeVetoableChangeListener(String propertyName, VetoableChangeListener listener)
      {
        vetoableChangeSupport.removeVetoableChangeListener(propertyName, listener);
      }

    public final VetoableChangeListener[] getVetoableChangeListeners(String propertyName) 
      {
        return vetoableChangeSupport.getVetoableChangeListeners(propertyName);
      }
  }
