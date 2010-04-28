/*
 * JBoss, Home of Professional Open Source
 * Copyright 2005, JBoss Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.osgi.jaxb;

//$Id$

import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * A service to obtain the JAXBContext
 * 
 * @author thomas.diesler@jboss.com
 * @since 29-May-2009
 */
public interface JAXBService
{
   /**
    * Obtain a new instance of a JAXBContext class. 
    * 
    * @see {@link JAXBContext#newInstance(String)}
    */
   JAXBContext newJAXBContext(String contextPath) throws JAXBException;
   
   /**
    * Obtain a new instance of a JAXBContext class. 
    * 
    * @see {@link JAXBContext#newInstance(String,ClassLoader,Map)}
    */
   JAXBContext newJAXBContext(String contextPath, Map<String,?> props) throws JAXBException;
   
   /**
    * Obtain a new instance of a JAXBContext class. 
    * 
    * @see {@link JAXBContext#newInstance(Class...)}
    */
   JAXBContext newJAXBContext(Class<?> ... classesToBeBound) throws JAXBException;
   
   /**
    * Obtain a new instance of a JAXBContext class. 
    * 
    * @see {@link JAXBContext#newInstance(Class[], Map)}
    */
   JAXBContext newJAXBContext(Class<?>[] classesToBeBound, Map<String,?> props) throws JAXBException;
}