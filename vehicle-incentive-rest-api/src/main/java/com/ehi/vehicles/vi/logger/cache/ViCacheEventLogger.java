package com.ehi.vehicles.vi.logger.cache;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.ehcache.event.EventFiring;
import org.ehcache.event.EventOrdering;
import org.ehcache.event.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViCacheEventLogger implements CacheEventListener<Object, Object> {
    private static final Logger logger = LoggerFactory.getLogger(ViCacheEventLogger.class);

    /**
     * Invoked on {@link CacheEvent CacheEvent} firing.
     * <p>
     * This method is invoked according to the {@link EventOrdering}, {@link EventFiring} and
     * {@link EventType} requirements provided at listener registration time.
     * <p>
     * Any exception thrown from this listener will be swallowed and logged but will not prevent other listeners to run.
     *
     * @param event the actual {@code CacheEvent}
     */
    @Override
    public void onEvent(CacheEvent<?, ?> event) {
        logger.info("Cache Event - {}  , Key - {} , Old Value - {} , New Value - {}", event.getType(), event.getKey(), event.getOldValue(), event.getNewValue());
    }
}
