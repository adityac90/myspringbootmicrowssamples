/**
 * 
 */
package org.cts.client;

import org.cts.factory.AnotherFactory;
import org.cts.factory.CustomBeanFactory;
import org.cts.pojo.Singleton;
import org.cts.pojo.SpringTraining;
import org.cts.pojo.Trainer;
import org.cts.pojo.Webex;
import org.cts.pojo.WebexConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author aditya
 *
 */
public class ApplicationClient {

	public static void main(String[] args) {
		SpringTraining springTraining = new SpringTraining("Spring Core", "Aditya", 12);

		// Look up for its dependency and create it
		Webex webex = new Webex("Citrix", "4.7.12");
		springTraining.setWebex(webex);
		System.out.println(springTraining);

		// Spring creates the beans and manges their lifecycles

		// Initialize the spring application context
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "springConfig.xml", "yetAnotherConfig.xml" });

		ctx.registerShutdownHook();

		final SpringTraining springTrainingObj = ctx.getBean("springTraining-One", SpringTraining.class);
		final SpringTraining springTrainingObj2 = ctx.getBean("springTraining-Two", SpringTraining.class);
		System.out.println(springTrainingObj);
		System.out.println(springTrainingObj2);

		final Trainer trainerObj = ctx.getBean("trainer-One", Trainer.class);
		System.out.println(trainerObj);

		final Trainer trainerObjTwo = ctx.getBean("trainer-Two", Trainer.class);
		System.out.println(trainerObjTwo);

		final CustomBeanFactory customBeanFactory = ctx.getBean("customFactory", CustomBeanFactory.class);
		System.out.println(customBeanFactory.getClass());

		final AnotherFactory anotherFactory = ctx.getBean("objectFromFactory", AnotherFactory.class);
		System.out.println(anotherFactory);

		final WebexConnection webexConnectionOne = ctx.getBean("webexConnections", WebexConnection.class);
		final WebexConnection webexConnectionTwo = ctx.getBean("webexConnections", WebexConnection.class);
		System.out.println(webexConnectionOne);
		System.out.println(webexConnectionTwo);
		System.out.println(webexConnectionOne == webexConnectionTwo);

		final SpringTraining springTrainingObj3 = ctx.getBean("springTraining-Three", SpringTraining.class);
		System.out.println(springTrainingObj3);

		final Trainer trainerObjThree = ctx.getBean("trainer-Three", Trainer.class);
		System.out.println(trainerObjThree);

		/*
		 * Singleton singletonOne = ctx.getBean("mySingleTon", Singleton.class);
		 * singletonOne.doSomething(); singletonOne.doSomethingElse();
		 * 
		 * Singleton singletonTwo = ctx.getBean("mySingleTon", Singleton.class);
		 * singletonTwo.doSomething(); singletonTwo.doSomethingElse();
		 */

		Singleton singletonOne = ctx.getBean("mySingleTon", Singleton.class);
		singletonOne.doSomethingMod();
		singletonOne.doSomethingElseMod();

		Singleton singletonTwo = ctx.getBean("mySingleTon", Singleton.class);
		singletonTwo.doSomethingMod();
		singletonTwo.doSomethingElseMod();

		final SpringTraining springTrainingSpcl = ctx.getBean("springTraining-Special", SpringTraining.class);
		System.out.println(springTrainingSpcl);

	}

}
