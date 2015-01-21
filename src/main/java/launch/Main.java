package launch;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.startup.Tomcat;

public class Main {

	public static void main(String[] args) throws Exception  {
		String webappDirLocation = "src/main/webapp/";
		Tomcat tomcat = new Tomcat();

		//The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        tomcat.setPort(Integer.valueOf(webPort));

        Context ctx = tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        Tomcat.addServlet(ctx, "jsf_servlet", "javax.faces.webapp.FacesServlet");
        ctx.addServletMapping("*.xhtml", "jsf_servlet");
        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());
        tomcat.start();
        tomcat.getServer().await();
		
		
		
		
//		String webappDirLocation = "src/main/webapp/";
//	    Tomcat tomcat = new Tomcat();
//	    tomcat.setPort(8080);
//
//	    tomcat.setBaseDir(".");
//	    tomcat.getHost().setAppBase(".");
//	    tomcat.setSilent(false);
//
//	    // Add AprLifecycleListener
//	    StandardServer server = (StandardServer) tomcat.getServer();
//	    AprLifecycleListener listener = new AprLifecycleListener();
//	    server.addLifecycleListener(listener);
//
//	    Context ctx = tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
//	    Tomcat.addServlet(ctx, "jsf_servlet", "javax.faces.webapp.FacesServlet");
//	    ctx.addServletMapping("*.xhtml", "jsf_servlet");
//	    tomcat.start();
//	    tomcat.getServer().await();
	    
	    
	    
//	    Tomcat tomcat = new Tomcat();
//		tomcat.setPort(9000);
//		tomcat.setBaseDir(".");
//		tomcat.enableNaming();
//
//		
//		Context ctx = tomcat.addWebapp("/", docBase.getAbsolutePath());
//		ctx.setConfigFile(new File("/META-INF/context.xml").toURI().toURL());
//		tomcat.start();
//		tomcat.getServer().await();
	}

}
