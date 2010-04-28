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
package org.jboss.osgi.jaxb.internal;

//$Id: JAXBServiceActivator.java 91417 2009-07-20 09:25:44Z thomas.diesler@jboss.com $

import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.jboss.osgi.jaxb.JAXBService;
import org.jboss.osgi.spi.util.BundleClassLoader;
import org.osgi.framework.Bundle;

/**
 * An implementation of the {@link JAXBService}
 * 
 * @author thomas.diesler@jboss.com
 * @since 21-Jul-2009
 */
public class JAXBServiceImpl implements JAXBService
{
   private Bundle bundle;

   public JAXBServiceImpl(Bundle bundle)
   {
      this.bundle = bundle;
   }

   public JAXBContext newJAXBContext(String contextPath) throws JAXBException
   {
      return newJAXBContext(contextPath, null);
   }

   public JAXBContext newJAXBContext(String contextPath, Map<String, ?> props) throws JAXBException
   {
      ClassLoader classLoader = BundleClassLoader.createClassLoader(bundle);
      return JAXBContext.newInstance(contextPath, classLoader, props);
   }

   public JAXBContext newJAXBContext(Class<?>... classesToBeBound) throws JAXBException
   {
      return JAXBContext.newInstance(classesToBeBound);
   }

   public JAXBContext newJAXBContext(Class<?>[] classesToBeBound, Map<String, ?> props) throws JAXBException
   {
      return JAXBContext.newInstance(classesToBeBound, props);
   }
}