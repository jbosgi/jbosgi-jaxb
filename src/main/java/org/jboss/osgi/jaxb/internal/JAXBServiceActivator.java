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

//$Id$

import org.jboss.osgi.common.log.LogServiceTracker;
import org.jboss.osgi.jaxb.JAXBService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.log.LogService;

/**
 * A BundleActivator for JAXB related services
 * 
 * @author thomas.diesler@jboss.com
 * @since 29-May-2009
 */
public class JAXBServiceActivator implements BundleActivator
{
   private LogService log;

   public void start(BundleContext context)
   {
      log = new LogServiceTracker(context);
      
      ServiceFactory factory = new ServiceFactory()
      {
         public Object getService(Bundle bundle, ServiceRegistration registration)
         {
            return new JAXBServiceImpl(bundle);
         }

         public void ungetService(Bundle bundle, ServiceRegistration registration, Object service)
         {
         }
      };
      context.registerService(JAXBService.class.getName(), factory, null);
      log.log(LogService.LOG_INFO, "JAXBService registered");
   }

   public void stop(BundleContext context)
   {
   }
}