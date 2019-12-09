package com.ehi.vehicles.vi.logger.aspect;
/**
 * This an AOP based Logger, Which will be used to write application logs
 */

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ViLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(ViLoggingAspect.class);

}
